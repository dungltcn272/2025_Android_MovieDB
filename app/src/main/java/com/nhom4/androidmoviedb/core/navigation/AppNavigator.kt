package com.nhom4.androidmoviedb.core.navigation

import android.view.View
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nhom4.androidmoviedb.presentation.detail.MovieDetailFragment
import com.nhom4.androidmoviedb.presentation.home.HomeFragment
import com.nhom4.androidmoviedb.presentation.notification.NotificationFragment

object AppNavigator {
    private var fragmentManager: FragmentManager? = null
    private var containerId: Int = 0
    private var bottomNavView: BottomNavigationView? = null

    fun init(
        fragmentManager: FragmentManager,
        containerId: Int,
        bottomNavView: BottomNavigationView
    ) {
        this.fragmentManager = fragmentManager
        this.containerId = containerId
        this.bottomNavView = bottomNavView
    }

    fun navigateTo(destination: NavDestination, addToBackStack: Boolean = false) {
        val fragment = when (destination) {
            is NavDestination.HomeScreen -> HomeFragment()
            is NavDestination.NotificationScreen -> NotificationFragment()
            is NavDestination.MovieDetailScreen -> MovieDetailFragment.newInstance(destination.slug)
        }

        val tag = destination::class.simpleName

        fragmentManager?.beginTransaction()?.apply {
            replace(containerId, fragment, tag)
            if (addToBackStack) addToBackStack(tag)
            commit()
        }
    }

    fun attachNavVisibilityListener() {
        fragmentManager?.addOnBackStackChangedListener {
            val currentFragment = fragmentManager?.findFragmentById(containerId)
            val showNav = currentFragment is HomeFragment || currentFragment is NotificationFragment
            bottomNavView?.visibility = if (showNav) View.VISIBLE else View.GONE
        }
    }
}
