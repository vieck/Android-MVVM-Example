package com.example.home.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.repositories.PlayerRepository

class HomeViewModel(private val playerRepository: PlayerRepository): ViewModel() {
    val recentlyPlayedTracks = playerRepository.getRecentlyPlayedTracks(10)
}