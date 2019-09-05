package com.example.mvvmexample.navigation.loaders

import androidx.fragment.app.Fragment
import com.example.mvvmexample.navigation.Destinations

internal fun Destinations.loadFragmentOrNull(): Fragment? =
    this.intentPath.loadClassOrNull<Fragment>().newInstance() as Fragment?

internal fun <T> String.loadClassOrNull(): Class<*> = Class.forName(this) as Class<*>