package com.example.mvvmexample.navigation

enum class Destinations(val intentPath: String) {
    HOME("com.example.mvvmexample.home.ui.fragments.HomeFragment"),
    PLAYLIST("com.example.mvvmexample.playlists.ui.fragments.PlaylistFragment"),
    NAVIGATION("com.example.mvvmexample.activities.NavigationActivity"),
    MAIN("com.example.mvvmexample.activities.MainActivity")
}