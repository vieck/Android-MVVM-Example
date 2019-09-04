package com.example.mvvmexample.data.models

import com.example.mvvmexample.repository.dtos.ISpotifyContext

data class SpotifyContext(
    override val type: String,
    override val href: String,
    override val uri: String
): ISpotifyContext