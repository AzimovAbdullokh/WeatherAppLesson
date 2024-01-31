package com.example.weatherapp.presentation.navigation

import com.example.weatherapp.R

sealed class Screens(
    val route: String
) {
    data object HomeScreen : Screens(R.string.home_screen_route.toString())
    data object SplashScreen : Screens(R.string.splash_screen_route.toString())
}