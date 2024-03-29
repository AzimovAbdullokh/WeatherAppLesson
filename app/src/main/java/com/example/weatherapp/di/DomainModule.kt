package com.example.weatherapp.di

import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.use_cases.DefaultGetCurrentWeatherUseCase
import com.example.weatherapp.domain.use_cases.DefaultGetWeatherForFifteenDays
import com.example.weatherapp.domain.use_cases.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.use_cases.GetWeatherForFifteenDays
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetCurrentWeatherUseCase(
        repository: WeatherRepository,
        getCurrentLocationManager: GetCurrentLocationManager
    ): GetCurrentWeatherUseCase = DefaultGetCurrentWeatherUseCase(
        repository = repository,
        getCurrentLocationManager = getCurrentLocationManager
    )

    @Provides
    fun provideDefaultGetWeatherForFifteenDays(
        repository: WeatherRepository,
        getCurrentLocationManager: GetCurrentLocationManager
    ): GetWeatherForFifteenDays = DefaultGetWeatherForFifteenDays(
        repository = repository,
        getCurrentLocationManager = getCurrentLocationManager
    )

}