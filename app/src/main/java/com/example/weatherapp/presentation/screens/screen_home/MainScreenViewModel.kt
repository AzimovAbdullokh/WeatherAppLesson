package com.example.weatherapp.presentation.screens.screen_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.base.model.ResponseStatus
import com.example.weatherapp.domain.use_cases.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainScreenUiState> = MutableStateFlow(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        getCurrentWeatherData()
    }


    fun getCurrentWeatherData() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.tryEmit(MainScreenUiState.Loading)
            val response = getCurrentWeatherUseCase()
            when (response.status) {
                ResponseStatus.SUCCES -> {
                    response.data?.let { weather ->
                        _uiState.tryEmit(
                            MainScreenUiState.Success(
                                weatherDomainModel = weather
                            )
                        )
                    }

                }

                ResponseStatus.ERROR -> {
                    response.errorThrowable?.message?.let { message ->
                        if (response.errorThrowable.toString() == "java.net.UnknownHostException: Unable to resolve host \"api.openweathermap.org\": No address associated with hostname") {
                            _uiState.tryEmit(
                                MainScreenUiState.Error(
                                    message = message,
                                    isErrorWithConnection = true,
                                )
                            )
                        } else {
                            _uiState.tryEmit(
                                MainScreenUiState.Error(
                                    message = message,
                                    isErrorWithConnection = false,
                                )
                            )
                        }
                    }

                }
            }
        }
    }
}