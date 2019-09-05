package com.example.mvvmexample.home.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.repositories.AuthRepository

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    fun saveToken(authToken: String) {
        authRepository.saveToken(authToken)
    }
}