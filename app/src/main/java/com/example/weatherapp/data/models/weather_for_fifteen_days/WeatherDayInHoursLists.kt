package com.example.weatherapp.data.models.weather_for_fifteen_days

import com.example.weatherapp.data.models.current_weather.WeatherCloudsModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDayInHoursLists(
    @SerializedName("main")
    val weatherMain: WeatherMainModelInDays,
    @SerializedName("weather")
    val weather: WeatherCloudModelInDays,
    @SerializedName("weather")
    val weatherClouds: WeatherCloudsModel,
    @SerializedName("weather")
    val weatherWind: WeatherWindInfoModelInDays,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("dt_txt")
    val weatherData: Int,
) : Serializable {
    companion object {
        val unknown = WeatherDayInHoursLists(
            weatherMain = WeatherMainModelInDays.unknown,
            weather = WeatherCloudModelInDays.unknown,
            weatherClouds = WeatherCloudsModel.unknown,
            weatherData = 0,
            weatherWind = WeatherWindInfoModelInDays.unknown,
            visibility = 0
        )
    }
}
