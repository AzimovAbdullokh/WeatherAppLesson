package com.example.weatherapp.data.repository

import android.util.Log
import com.example.weatherapp.data.base.BaseDataSource
import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.data.mappers.toDomainModel
import com.example.weatherapp.data.models.weather_for_fifteen.ListWeather
import com.example.weatherapp.data.remote.WeatherService
import com.example.weatherapp.domain.models.current_weather.WeatherDataDomainModel
import com.example.weatherapp.domain.models.weather_for_fifteen_days.WeatherDayInHoursListsModelDomain
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
    ): ResultStatus<List<ListWeather>> {
        val response = invokeResponseRequest {
            service.getWeatherForFiveDays(
                latitude = latitude,
                longitude = longitude,
            )
        }
        Log.i("AAA","response = ${response.data?.list}")
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.list
        )
    }
}