package com.example.mvvmexample.data.services

import com.example.mvvmexample.data.models.PlayHistory
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerService {
    @GET("/me/player/recently-played")
    fun getRecentlyPlayedTracks(@Query("limit") limit: Int): Flowable<List<PlayHistory>>
}