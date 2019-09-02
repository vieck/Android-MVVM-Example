package com.example.mvvmexample.data.models

import com.squareup.moshi.Json

data class PlayHistory(
    @Json(name = "track")
    val track: Any,
    @Json(name = "played_at")
    val playedAt: String,
    @Json(name = "context")
    val context: SpotifyContext
)