package com.example.weatherapp.presentation.screens.screen_home

import com.example.weatherapp.data.models.weather_for_fifteen.ListWeather
import com.example.weatherapp.domain.models.current_weather.WeatherDataDomainModel
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenUiState {

    @Immutable
    data class Success(
        val weatherDomainModel: WeatherDataDomainModel = WeatherDataDomainModel.preview,
        val weatherDayInHours: List<ListWeather> = emptyList()

    ) : MainScreenUiState()

    data object Loading : MainScreenUiState()

    @Immutable
    data class Error(
        val message: String,
        val isErrorWithConnection: Boolean,
    ) : MainScreenUiState()

}