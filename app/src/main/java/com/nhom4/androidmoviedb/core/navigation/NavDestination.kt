package com.nhom4.androidmoviedb.core.navigation

sealed class NavDestination {
    data object HomeScreen : NavDestination()
    data object NotificationScreen : NavDestination()
    data class MovieDetailScreen(val slug: String) : NavDestination()
}
