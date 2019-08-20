package com.example.mvvmexample.di

import com.example.mvvmexample.data.repositories.AuthRepository
import org.koin.dsl.module

val applicationModule = module {
    single { AuthRepository() }
}