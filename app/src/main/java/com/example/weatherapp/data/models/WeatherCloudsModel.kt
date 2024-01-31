package com.example.weatherapp.data.models

import java.io.Serializable

data class WeatherCloudsModel(val all: Int) : Serializable {
    companion object {
        val unknown = WeatherCloudsModel(
            all = 0,
        )
    }
}
