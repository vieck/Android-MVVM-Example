package com.example.mvvmexample.repository.dtos

interface IAlbum {
    val albumType: String
    val images: List<IImage>
    val name: String
    val type: String
}
