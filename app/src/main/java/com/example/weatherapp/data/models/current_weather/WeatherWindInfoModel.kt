package com.example.weatherapp.data.models.current_weather

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherWindInfoModel(
    @SerializedName("speed") val windSpeed: Double,
    @SerializedName("deg") val windDeg: Int,
) : Serializable {
    companion object {
        val unknown = WeatherWindInfoModel(
            windSpeed = 0.0,
            windDeg = 0,
        )
    }
}
