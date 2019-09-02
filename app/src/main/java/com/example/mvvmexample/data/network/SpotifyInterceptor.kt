package com.example.mvvmexample.data.network

import com.example.mvvmexample.data.repositories.AuthRepository
import okhttp3.Interceptor
import okhttp3.Response

class SpotifyInterceptor(private val authRepository: AuthRepository) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (request.header("Authorization") == null) {
            request = request.newBuilder()
                .addHeader("Authorization", authRepository.getBearerToken()).build()
        }
        return chain.proceed(request)
    }
}