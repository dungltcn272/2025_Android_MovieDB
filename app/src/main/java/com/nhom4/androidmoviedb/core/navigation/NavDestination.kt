package com.nhom4.androidmoviedb.core.navigation

sealed class NavDestination {
    data object HomeScreen : NavDestination()
    data object NotificationScreen : NavDestination()
    data object ProfileScreen : NavDestination()
    data object LoginScreen : NavDestination()
    data class MovieDetailScreen(val id: String) : NavDestination()
}
