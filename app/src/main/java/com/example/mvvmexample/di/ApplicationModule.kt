package com.example.mvvmexample.di

import com.example.mvvmexample.data.repositories.AuthRepository
import com.example.mvvmexample.data.repositories.PlayerRepository
import com.example.mvvmexample.data.services.PlayerService
import com.example.mvvmexample.viewmodels.AuthViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val spotifyRetrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.spotify.com/v1/")
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()
val playerService: PlayerService = spotifyRetrofit.create(PlayerService::class.java)

val serviceModule = module {
    single { playerService }
}

val repositoryModule = module {
    single { spotifyRetrofit }
    single { AuthRepository() }
    single { PlayerRepository(get()) }
}

val viewModelModules = module {
    viewModel { AuthViewModel(get()) }
}

val applicationModules = listOf(serviceModule, repositoryModule, viewModelModules)


