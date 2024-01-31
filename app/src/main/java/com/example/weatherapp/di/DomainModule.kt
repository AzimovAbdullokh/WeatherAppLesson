package com.example.weatherapp.di

import com.example.weatherapp.domain.repository.GetCurrentWeatherRepository
import com.example.weatherapp.domain.use_cases.DefaultGetCurrentWeatherUseCase
import com.example.weatherapp.domain.use_cases.GetCurrentWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetCurrentWeatherUseCase(
        repository: GetCurrentWeatherRepository
    ): GetCurrentWeatherUseCase = DefaultGetCurrentWeatherUseCase(repository = repository)

}