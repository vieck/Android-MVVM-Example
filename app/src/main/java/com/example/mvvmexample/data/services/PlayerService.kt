package com.example.mvvmexample.data.services

import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerService {
    @GET("/me/player/recently-played")
    fun getRecentlyPlayedTracks(@Query("limit") limit: Int)
}