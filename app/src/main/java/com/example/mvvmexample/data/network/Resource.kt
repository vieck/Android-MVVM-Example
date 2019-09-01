package com.example.mvvmexample.data.network

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Failed<T>(val throwable: Throwable) : Resource<T>()
}