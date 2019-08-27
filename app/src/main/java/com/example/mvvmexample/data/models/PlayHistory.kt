package com.example.mvvmexample.data.models

import java.util.*

data class PlayHistory(
    val track: Any,
    val playedAt: Date,
    val context: SpotifyContext
)