package com.example.weatherapp.data.models.weather_for_fifteen_days

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherWindInfoModelInDays(
    @SerializedName("speed") val weatherSpeed: Double,
    @SerializedName("dag") val weatherDag: Int,
    @SerializedName("gust") val weatherGust: Int,
) : Serializable {
    companion object {
        val unknown = WeatherWindInfoModelInDays(
            weatherDag = 0,
            weatherSpeed = 0.0,
            weatherGust = 0
        )
    }
}