package com.example.mvvmexample.repository.dtos

interface IPlaylist {
    val id: String
    val images: List<IImage>
    val name: String
    val isPublic: Boolean
}