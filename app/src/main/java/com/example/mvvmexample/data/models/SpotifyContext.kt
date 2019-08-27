package com.example.mvvmexample.data.models

import com.google.gson.annotations.SerializedName

data class SpotifyContext(
    @SerializedName("type")
    val type: String,
    @SerializedName("href")
    val href: String,
    @SerializedName("uri")
    val uri: String
)