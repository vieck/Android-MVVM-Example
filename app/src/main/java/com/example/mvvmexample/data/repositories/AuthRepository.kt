package com.example.mvvmexample.data.repositories

class AuthRepository {
    var token: String = ""

    fun saveToken(token: String) {
        this.token = token
    }
}