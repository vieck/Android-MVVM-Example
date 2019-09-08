package com.example.mvvmexample.playlists.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.repositories.PlaylistRepository

class PlaylistViewModel(playlistRepository: PlaylistRepository) : ViewModel() {
    val userPlaylists = playlistRepository.getUserPlaylists(10)
}