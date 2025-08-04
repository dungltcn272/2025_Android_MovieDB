package com.nhom4.androidmoviedb.presentation

import com.nhom4.androidmoviedb.R
import com.nhom4.androidmoviedb.core.navigation.AppNavigator
import com.nhom4.androidmoviedb.core.navigation.NavDestination
import com.nhom4.androidmoviedb.core.platform.BaseActivity
import com.nhom4.androidmoviedb.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        AppNavigator.init(
            supportFragmentManager,
            binding.navHostFragment.id,
            binding.bottomNav
        )
        AppNavigator.attachNavVisibilityListener()
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    AppNavigator.navigateTo(NavDestination.HomeScreen)
                    true
                }
                R.id.notificationFragment -> {
                    AppNavigator.navigateTo(NavDestination.NotificationScreen, addToBackStack = true)
                    true
                }
                else -> false
            }
        }
        // Set default selected item (start destination)
        binding.bottomNav.selectedItemId = R.id.homeFragment
    }
}
