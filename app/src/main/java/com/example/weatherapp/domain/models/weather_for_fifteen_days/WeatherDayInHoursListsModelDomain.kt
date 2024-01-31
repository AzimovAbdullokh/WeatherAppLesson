package com.example.weatherapp.domain.models.weather_for_fifteen_days

import com.example.weatherapp.domain.models.current_weather.WeatherCloudDomainModel
import java.io.Serializable

data class WeatherDayInHoursListsModelDomain(
    val weatherMain: WeatherMainModelInDaysDomain,
    val weather: WeatherCloudModelInDaysDomain,
    val weatherClouds: WeatherCloudDomainModel,
    val weatherWind: WeatherWindInfoModelInDayDomain,
    val visibility: Int,
    val weatherData: Int,
): Serializable {
    companion object {
        val unknown = WeatherDayInHoursListsModelDomain(
            weatherMain = WeatherMainModelInDaysDomain.unknown,
            weather = WeatherCloudModelInDaysDomain.unknown,
            weatherClouds = WeatherCloudDomainModel.unknown,
            weatherData = 0,
            weatherWind = WeatherWindInfoModelInDayDomain.unknown,
            visibility = 0
        )
    }
}