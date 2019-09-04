package com.example.mvvmexample.data.repositories

class AuthRepository {
    private var token: String = ""

    fun getBearerToken() = "Bearer $token"

    fun saveToken(token: String) {
        this.token = token
    }
}