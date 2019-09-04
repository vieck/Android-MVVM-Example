package com.example.mvvmexample.data.models

import com.example.mvvmexample.repository.dtos.IAlbum

data class Album(
    override val albumType: String,
    override val images: List<Image>,
    override val name: String,
    override val type: String
) : IAlbum