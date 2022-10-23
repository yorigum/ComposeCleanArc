package com.yoriworks.yomovies.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
}