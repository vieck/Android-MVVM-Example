package com.example.mvvmexample.navigation

interface FeatureModule<T> {
    fun dynamicStart(destination: Destinations): T?
}