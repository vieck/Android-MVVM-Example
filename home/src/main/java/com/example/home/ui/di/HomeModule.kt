package com.example.home.ui.di

import com.example.home.ui.viewmodels.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}

private val homeFeature by lazy { loadKoinModules(homeModule) }

fun injectFeature() = homeFeature
