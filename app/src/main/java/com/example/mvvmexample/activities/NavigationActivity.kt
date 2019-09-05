package com.example.mvvmexample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mvvmexample.R
import com.example.mvvmexample.navigation.Destinations
import com.example.mvvmexample.navigation.ActivityNavigation
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
        val homeFragment = FragmentNavigation.dynamicStart(Destinations.HOME)
        startFragment(homeFragment!!)
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    FragmentNavigation.dynamicStart(Destinations.HOME)?.let {
                        startFragment(it)
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_playlists -> {
                    intent = ActivityNavigation.dynamicStart(Destinations.MAIN)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}