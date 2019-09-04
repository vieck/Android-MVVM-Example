package com.example.mvvmexample.data.models

import com.example.mvvmexample.repository.dtos.ISpotifyContext
import com.squareup.moshi.Json

data class SpotifyContext(
    @Json(name = "type")
    override val type: String,
    @Json(name = "href")
    override val href: String,
    @Json(name = "uri")
    override val uri: String
): ISpotifyContext