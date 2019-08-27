package com.example.mvvmexample.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class PlayHistory(
    @SerializedName("track")
    val track: Any,
    @SerializedName("played_at")
    val playedAt: Date,
    @SerializedName("context")
    val context: SpotifyContext
)