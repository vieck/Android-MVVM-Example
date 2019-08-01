package com.example.mvvmexample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse

private const val REQUEST_CODE = 1008
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login()
    }

    private fun login() {
        val authBuilder = AuthenticationRequest.Builder(BuildConfig.SPOTIFY_CLIENT_ID, AuthenticationResponse.Type.TOKEN, "https://com.example.mvvm/spotify")
        authBuilder.setScopes(arrayOf("streaming"))
        val request = authBuilder.build()

        AuthenticationClient.openLoginActivity(this, 1008, request)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> return
                AuthenticationResponse.Type.ERROR -> return
                else -> return
            }
        }
    }
}
