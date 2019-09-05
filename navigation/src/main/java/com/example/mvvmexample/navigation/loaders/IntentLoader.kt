package com.example.mvvmexample.navigation.loaders

import android.content.Intent
import com.example.mvvmexample.navigation.Destinations

const val PACKAGE_NAME = "com.example.mvvmexample"

internal fun Destinations.loadIntentOrNull(): Intent {
    return Class.forName(this.intentPath).run {
        intentTo(
            this@loadIntentOrNull.intentPath
        )
    }
}

private fun intentTo(className: String): Intent =
    Intent(Intent.ACTION_VIEW).setClassName(PACKAGE_NAME, className)
