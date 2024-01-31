package com.example.weatherapp.presentation.screens.screen_home

import android.annotation.SuppressLint
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.domain.models.current_weather.WeatherDataDomainModel
import com.example.weatherapp.presentation.components.WeatherTopAppBar
import com.example.weatherapp.presentation.components.common.ErrorScreen
import com.example.weatherapp.presentation.components.common.LoadingScreen
import com.example.weatherapp.presentation.components.common.NoConnectionScreen
import com.example.weatherapp.presentation.screens.screen_home.components.LoadedWeatherScreen
import com.example.weatherapp.presentation.theme.BackgroundLight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainScreen(
    uiStateFlow: StateFlow<MainScreenUiState>,
    getCurrentWeatherData: () -> Unit,
    onBackPressedCallBack: () -> Unit,
) {

    when (val mainUiStateFlow = uiStateFlow.collectAsState().value) {
        is MainScreenUiState.Loading -> LoadingScreen()
        is MainScreenUiState.Success -> LoadedMainScreen(mainUiStateFlow, onBackPressedCallBack)
        is MainScreenUiState.Error -> {
            if (mainUiStateFlow.isErrorWithConnection) NoConnectionScreen(getCurrentWeatherData)
            else ErrorScreen(mainUiStateFlow.message, getCurrentWeatherData)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoadedMainScreen(
    uiState: MainScreenUiState.Success,
    onBackPressedCallBack: () -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    val colorBackgroundLight = BackgroundLight
    val backStackDispatcher = LocalOnBackPressedDispatcherOwner.current

    backStackDispatcher?.onBackPressedDispatcher?.addCallback {
        onBackPressedCallBack()
    }

    Scaffold(
        containerColor = BackgroundLight,
        topBar = { WeatherTopAppBar() }
    ) { innerPadding ->
        LoadedWeatherScreen(
            loadedUiState = uiState,
            modifier = Modifier.padding(innerPadding)
        )
    }

    SideEffect {
        systemUiController.setStatusBarColor(colorBackgroundLight)
        systemUiController.setNavigationBarColor(colorBackgroundLight)
    }
}

@Preview
@Composable
fun LoadedMainScreenPreview() {
    MaterialTheme {
        LoadedMainScreen(
            MainScreenUiState.Success(
                WeatherDataDomainModel.preview
            ),
            onBackPressedCallBack = {}
        )
    }
}



