package com.example.mvvmexample.data.repositories

class AuthRepository {
    private var token: String = ""

    fun saveToken(token: String) {
        this.token = token
    }
}