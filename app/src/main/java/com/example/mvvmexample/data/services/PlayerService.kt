package com.example.mvvmexample.data.services

import retrofit2.http.GET

interface PlayerService {
    @GET("/me/player/recently-played")
    fun getRecentlyPlayed()
}