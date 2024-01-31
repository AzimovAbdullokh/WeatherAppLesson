package com.example.weatherapp.data.remote

import com.example.weatherapp.data.models.WeatherDataModel
import com.example.weatherapp.data.utils.Constants.API_KEY
import com.example.weatherapp.data.utils.Constants.GET_CURRENT_WEATHER_DATA
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(GET_CURRENT_WEATHER_DATA)
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String = API_KEY,
    ): Response<WeatherDataModel>
}