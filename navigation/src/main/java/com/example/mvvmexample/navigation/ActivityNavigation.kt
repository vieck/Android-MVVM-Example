package com.example.mvvmexample.navigation

import android.content.Intent
import com.example.mvvmexample.navigation.loaders.loadIntentOrNull

object ActivityNavigation : FeatureModule<Intent> {
    override fun dynamicStart(destination: Destinations): Intent? = destination.loadIntentOrNull()
}