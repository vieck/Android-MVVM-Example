package com.example.mvvmexample.data.models

import com.squareup.moshi.Json

data class SpotifyContext(
    @Json(name = "type")
    val type: String,
    @Json(name="href")
    val href: String,
    @Json(name = "uri")
    val uri: String
)