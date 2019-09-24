package com.example.mvvmexample.navigation.loaders

import androidx.fragment.app.Fragment
import com.example.mvvmexample.navigation.Destinations

internal fun Destinations.loadFragmentOrNull(): Fragment? =
    this.intentPath.loadClassOrNull().newInstance() as Fragment?

internal fun String.loadClassOrNull(): Class<*> = Class.forName(this)