package com.example.mvvmexample.data.models

import com.example.mvvmexample.repository.dtos.IAlbum
import com.example.mvvmexample.repository.dtos.IImage

data class Album(
    override val albumType: String,
    override val images: List<IImage>,
    override val name: String,
    override val type: String
) : IAlbum