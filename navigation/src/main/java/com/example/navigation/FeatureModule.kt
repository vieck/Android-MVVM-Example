package com.example.navigation

interface FeatureModule<T> {
    fun dynamicStart(destination: Destinations): T?
}