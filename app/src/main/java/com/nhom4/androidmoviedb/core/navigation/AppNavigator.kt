package com.nhom4.androidmoviedb.core.navigation

// object AppNavigator {
//    private var fragmentManager: FragmentManager? = null
//    private var containerId: Int = 0
//    private var bottomNavView: BottomNavigationView? = null
//
//    fun init(
//        fragmentManager: FragmentManager,
//        containerId: Int,
//        bottomNavView: BottomNavigationView
//    ) {
//        this.fragmentManager = fragmentManager
//        this.containerId = containerId
//        this.bottomNavView = bottomNavView
//    }
//
//    fun navigateTo(destination: NavDestination, addToBackStack: Boolean = false) {
//        val fragment = when (destination) {
//            is NavDestination.HomeScreen -> HomeFragment()
//            is NavDestination.NotificationScreen -> NotiFragment()
//            is NavDestination.ProfileScreen -> ProfileFragment()
//            is NavDestination.LoginScreen -> LoginFragment()
//            is NavDestination.MovieDetailScreen -> MovieDetailFragment.newInstance(destination.id)
//        }
//
//        val tag = destination::class.simpleName
//
//        fragmentManager?.beginTransaction()?.apply {
//            replace(containerId, fragment, tag)
//            if (addToBackStack) addToBackStack(tag)
//            commit()
//        }
//
//        val showNav = destination is NavDestination.HomeScreen ||
//                destination is NavDestination.NotificationScreen ||
//                destination is NavDestination.ProfileScreen
//
//        bottomNavView?.visibility = if (showNav) View.VISIBLE else View.GONE
//    }
//
//    fun handleDeepLink(url: String) {
//        // Example: "myapp://movie/detail/abc123"
//        val uri = url.toUri()
//        when {
//            uri.pathSegments.contains("detail") -> {
//                val id = uri.lastPathSegment ?: return
//                navigateTo(NavDestination.MovieDetailScreen(id), addToBackStack = true)
//            }
//
//            uri.pathSegments.contains("login") -> {
//                navigateTo(NavDestination.LoginScreen, addToBackStack = true)
//            }
//
//            // add more...
//        }
//    }
// }

// ------ How to use AppNavigator.kt ------
// val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
// AppNavigator.init(supportFragmentManager, R.id.fragmentContainer, bottomNav)
//
// bottomNav.setOnItemSelectedListener {
//    when (it.itemId) {
//        R.id.nav_home -> {
//            AppNavigator.navigateTo(NavDestination.HOME)
//            true
//        }
//        R.id.nav_noti -> {
//            AppNavigator.navigateTo(NavDestination.NOTI)
//            true
//        }
//        R.id.nav_profile -> {
//            AppNavigator.navigateTo(NavDestination.PROFILE)
//            true
//        }
//        else -> false
//    }
// }
//
// // Mặc định load Home
// AppNavigator.navigateTo(NavDestination.HOME)
