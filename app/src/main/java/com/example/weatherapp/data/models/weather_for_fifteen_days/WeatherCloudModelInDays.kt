package com.example.weatherapp.data.models.weather_for_fifteen_days

import com.example.weatherapp.data.utils.Constants.EMPTY_STRING
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherCloudModelInDays(
    @SerializedName("id") val weatherId: Int,
    @SerializedName("main") val weatherMain: String,
    @SerializedName("description") val weatherDescription: String,
    ) : Serializable {
        companion object {
            val unknown = WeatherCloudModelInDays(
                weatherId = 0,
                weatherDescription = EMPTY_STRING,
                weatherMain = EMPTY_STRING
            )
    }
}