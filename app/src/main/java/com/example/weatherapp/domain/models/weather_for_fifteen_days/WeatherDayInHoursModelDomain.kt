package com.example.weatherapp.domain.models.weather_for_fifteen_days

import java.io.Serializable

data class WeatherDayInHoursModelDomain(
    val weatherList: List<WeatherDayInHoursListsModelDomain>,
) : Serializable {
    companion object {
        val unknown = WeatherDayInHoursModelDomain(
            weatherList = emptyList()
        )
    }
}
