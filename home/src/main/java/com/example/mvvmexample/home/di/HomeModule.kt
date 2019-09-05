package com.example.mvvmexample.home.di

import com.example.mvvmexample.home.viewmodels.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(playerRepository = get()) }
}

private val homeFeature by lazy { loadKoinModules(homeModule) }

fun injectFeature() = homeFeature
