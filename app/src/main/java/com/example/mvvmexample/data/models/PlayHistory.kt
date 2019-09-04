package com.example.mvvmexample.data.models

import com.example.mvvmexample.repository.dtos.IPlayHistory
import com.squareup.moshi.Json

data class PlayHistory(
    @Json(name = "track")
    override val track: Track,
    @Json(name = "played_at")
    override val playedAt: String,
    @Json(name = "context")
    override val context: SpotifyContext
): IPlayHistory