package com.example.mvvmexample.data.services

import com.example.mvvmexample.data.models.CursorPaging
import com.example.mvvmexample.data.models.Playlist
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaylistService {
    @GET("v1/me/playlists")
    fun getUserPlaylists(@Query("limit") limit: Int): Flowable<CursorPaging<Playlist>>
}