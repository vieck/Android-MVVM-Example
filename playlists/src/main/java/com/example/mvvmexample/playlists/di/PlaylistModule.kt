package com.example.mvvmexample.playlists.di

import com.example.mvvmexample.playlists.viewmodels.PlaylistViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val playlistModule = module {
    viewModel { PlaylistViewModel(playlistRepository = get()) }
}

private val playlistFeature by lazy { loadKoinModules(playlistModule) }

fun injectFeature() = playlistFeature
