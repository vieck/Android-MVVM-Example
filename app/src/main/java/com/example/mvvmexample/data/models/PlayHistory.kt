package com.example.mvvmexample.data.models

import com.squareup.moshi.Json
import java.util.*

data class PlayHistory(
    @Json(name="track")
    val track: Any,
    @Json(name="played_at")
    val playedAt: Date,
    @Json(name="context")
    val context: SpotifyContext
)