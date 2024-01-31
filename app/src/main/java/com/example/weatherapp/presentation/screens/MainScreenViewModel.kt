package com.example.weatherapp.presentation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.use_cases.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
) : ViewModel() {


    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        viewModelScope.launch(handle + Dispatchers.IO) {
            Log.d("WEATHER_APP", "launch")
            val response = getCurrentWeatherUseCase(
                longitude = 72.816101,
                latitude = 40.513996,
            )
            Log.d("WEATHER_APP", "cityNameByServer: ${response.cityName}")
        }
    }
}