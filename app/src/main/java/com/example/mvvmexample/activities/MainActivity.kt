package com.example.mvvmexample.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmexample.BuildConfig
import com.example.mvvmexample.R
import com.example.mvvmexample.home.viewmodels.AuthViewModel
import com.example.mvvmexample.navigation.ActivityNavigation
import com.example.mvvmexample.navigation.Destinations
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import org.koin.android.viewmodel.ext.android.viewModel

private const val REQUEST_CODE = 1008

class MainActivity : AppCompatActivity() {
    private val authViewModel: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login()
    }

    private fun login() {
        val authBuilder = AuthenticationRequest.Builder(
            BuildConfig.SPOTIFY_CLIENT_ID,
            AuthenticationResponse.Type.TOKEN,
            "https://com.example.mvvm/spotify"
        )
        authBuilder.setScopes(arrayOf("streaming", "user-read-recently-played"))
        val request = authBuilder.build()

        AuthenticationClient.openLoginActivity(this, 1008, request)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, data)
            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> {
                    authViewModel.saveToken(response.accessToken)
                    val intent = ActivityNavigation.dynamicStart(Destinations.NAVIGATION)?.apply {
                        addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    }
                    startActivity(intent)
                }
                AuthenticationResponse.Type.ERROR -> return
                else -> return
            }
        }
    }
}
