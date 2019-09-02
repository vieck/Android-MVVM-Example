package com.example.mvvmexample.data.models

data class CursorPaging<T>(
    val href: String,
    val items: Array<T>,
    val limit: Int,
    val next: String,
    val total: Int
)