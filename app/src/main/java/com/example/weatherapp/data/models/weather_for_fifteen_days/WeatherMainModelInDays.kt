package com.example.weatherapp.data.models.weather_for_fifteen_days

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherMainModelInDays(
    @SerializedName("temp")
    val weatherTemperature: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val weatherMinTemp: Double,
    @SerializedName("temp_max")
    val weatherMaxTemp: Double,
    @SerializedName("pressure")
    val weatherPressure: Int,
    @SerializedName("humidity")
    val weatherHumidity: Int,
    @SerializedName("sea_level")
    val weatherSeaLevel: Int,
    @SerializedName("grnd_level")
    val weatherLevel: Int,
    ) : Serializable {
    companion object {
        val unknown = WeatherMainModelInDays(
            weatherHumidity = 0,
            weatherMaxTemp = 0.0,
            weatherMinTemp = 0.0,
            weatherPressure = 0,
            weatherTemperature = 0.0,
            feelsLike = 0.0,
            weatherLevel = 0,
            weatherSeaLevel = 0
        )
    }
}