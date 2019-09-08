package com.example.mvvmexample.home.di

import com.example.mvvmexample.data.network.SpotifyInterceptor
import com.example.mvvmexample.data.repositories.AuthRepository
import com.example.mvvmexample.data.repositories.PlayerRepository
import com.example.mvvmexample.data.repositories.PlaylistRepository
import com.example.mvvmexample.data.services.PlayerService
import com.example.mvvmexample.data.services.PlaylistService
import com.example.mvvmexample.home.viewmodels.AuthViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val authRepository = AuthRepository()
val okHttpClient: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(SpotifyInterceptor(authRepository))
    .build()
val spotifyRetrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://api.spotify.com/")
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(okHttpClient)
    .build()

val serviceModule = module {
    single { spotifyRetrofit.create(PlayerService::class.java) }
    single { spotifyRetrofit.create(PlaylistService::class.java)}
}

val repositoryModule = module {
    single { spotifyRetrofit }
    single { authRepository }
    single { PlayerRepository(get()) }
    single { PlaylistRepository(get()) }
}

val viewModelModules = module {
    viewModel { AuthViewModel(get()) }
}

val applicationModules = listOf(serviceModule, repositoryModule, viewModelModules)


