package com.example.weatherapp.data.models.weather_for_fifteen_days

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDayInHoursModel(
    @SerializedName("list")
    val weatherList: List<WeatherDayInHoursLists>,
) : Serializable {

    companion object {
        val unknown = WeatherDayInHoursModel(
            weatherList = emptyList()
        )
    }
}