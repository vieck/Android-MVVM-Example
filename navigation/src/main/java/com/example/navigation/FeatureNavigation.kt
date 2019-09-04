package com.example.navigation

import android.content.Intent

object FeatureNavigation : FeatureModule<Intent> {
    override fun dynamicStart(destination: Destinations): Intent? = destination.loadIntentOrNull()
}