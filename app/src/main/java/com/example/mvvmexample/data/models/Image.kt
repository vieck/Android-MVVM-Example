package com.example.mvvmexample.data.models

import com.example.mvvmexample.repository.dtos.IImage

data class Image(override val height: Int?, override val url: String, override val width: Int?) : IImage