package com.example.mvvmexample.data.models

import com.example.mvvmexample.repository.dtos.IPlaylist

data class Playlist(
    override val id: String,
    override val images: List<Image>,
    override val name: String,
    override val isPublic: Boolean
): IPlaylist