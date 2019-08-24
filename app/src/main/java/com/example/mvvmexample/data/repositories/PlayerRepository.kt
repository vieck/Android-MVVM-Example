package com.example.mvvmexample.data.repositories

import com.example.mvvmexample.data.services.PlayerService

class PlayerRepository(private val playerService: PlayerService) {

    fun getRecentlyPlayedTracks(limit: Int) {
        return playerService.getRecentlyPlayedTracks(limit)
    }
}