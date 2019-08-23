package com.example.home.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.home.R
import com.example.home.ui.di.injectFeature
import com.example.home.ui.viewmodels.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        injectFeature()
    }
}