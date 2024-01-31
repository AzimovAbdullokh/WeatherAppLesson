package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.data.models.weather_for_fifteen.ListWeather
import com.example.weatherapp.domain.models.current_weather.WeatherDataDomainModel
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherDayInHoursListsModelDomain
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherDayInHoursModelDomain

interface WeatherRepository {

    suspend fun getCurrentWeatherData(
        latitude: Double,
        longitude: Double,
    ): ResultStatus<WeatherDataDomainModel>

    suspend fun getWeatherForFifteenDays(
        latitude: Double,
        longitude: Double,
    ): ResultStatus<List<ListWeather>>

}