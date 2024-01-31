package com.example.weatherapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.presentation.screens.screen_home.MainScreen
import com.example.weatherapp.presentation.screens.screen_home.MainScreenViewModel
import com.example.weatherapp.presentation.screens.screen_splash.SplashScreen

@Composable
fun AppNavGraph(
    onBackPressedCallBack: () -> Unit,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route,
    ) {
        composable(Screens.HomeScreen.route) {
            val viewModel: MainScreenViewModel = hiltViewModel()
            MainScreen(
                uiStateFlow = viewModel.uiState,
                getCurrentWeatherData = viewModel::getCurrentWeatherData,
                onBackPressedCallBack = onBackPressedCallBack
            )
        }

        composable(Screens.SplashScreen.route) {
            SplashScreen(
                onNavigateNext = {
                    navController.navigate(Screens.HomeScreen.route)
                }
            )
        }
    }
}