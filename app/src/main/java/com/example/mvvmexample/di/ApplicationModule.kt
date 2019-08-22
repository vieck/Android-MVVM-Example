package com.example.mvvmexample.di

import com.example.mvvmexample.data.repositories.AuthRepository
import com.example.mvvmexample.viewmodels.AuthViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    viewModel { AuthViewModel(get()) }

    single { AuthRepository() }
}