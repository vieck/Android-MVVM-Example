package com.example.mvvmexample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmexample.R
import com.example.mvvmexample.navigation.Destinations
import com.example.mvvmexample.navigation.FragmentNavigation
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        loadHomeFragment()
        setupBottomNavigation()
    }

    private fun loadHomeFragment() {
        startFragment(Destinations.HOME)
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    startFragment(Destinations.HOME)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_playlists -> {
                    startFragment(Destinations.PLAYLIST)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_browse -> {
                    startFragment(Destinations.BROWSE)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun startFragment(destination: Destinations) {
        FragmentNavigation.dynamicStart(destination)?.let { fragment ->
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, fragment)
                addToBackStack(null)
                commit()

            }
        }
    }
}