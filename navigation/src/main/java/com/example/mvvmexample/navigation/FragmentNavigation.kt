package com.example.mvvmexample.navigation

import androidx.fragment.app.Fragment
import com.example.mvvmexample.navigation.loaders.loadFragmentOrNull

object FragmentNavigation : FeatureModule<Fragment> {
    override fun dynamicStart(destination: Destinations): Fragment? =
        destination.loadFragmentOrNull()
}