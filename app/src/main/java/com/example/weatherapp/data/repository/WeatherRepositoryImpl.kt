package com.example.weatherapp.data.repository

import com.example.weatherapp.data.base.BaseDataSource
import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.data.mappers.toDomainModel
import com.example.weatherapp.data.remote.WeatherService
import com.example.weatherapp.domain.models.current_weather.WeatherDataDomainModel
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherDayInHoursModelDomain
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val service: WeatherService
) : WeatherRepository, BaseDataSource() {

    override suspend fun getCurrentWeatherData(
        latitude: Double,
        longitude: Double,
    ): ResultStatus<WeatherDataDomainModel> {
        val response = invokeResponseRequest {
            service.getCurrentWeather(
                latitude = latitude,
                longitude = longitude,
            )
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.toDomainModel(),
        )
    }

    override suspend fun getWeatherForFifteenDays(
        latitude: Double,
        longitude: Double
    ): WeatherDayInHoursModelDomain {
        return service.getWeatherForFiveDays(
            latitude = latitude,
            longitude = longitude,
        ).body()?.toDomainModel() ?: WeatherDayInHoursModelDomain.unknown
    }
}