package com.example.weatherapp.data.models.current_weather

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class WeatherCoordinateModel(
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lon")
    val longitude: Double,
) : Serializable {
    companion object {
        val unknown = WeatherCoordinateModel(
            latitude = 0.0,
            longitude = 0.0,
        )
    }
}