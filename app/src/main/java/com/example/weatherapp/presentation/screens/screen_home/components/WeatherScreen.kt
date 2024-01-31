package com.example.weatherapp.presentation.screens.screen_home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.domain.models.current_weather.WeatherDataDomainModel
import com.example.weatherapp.presentation.components.WeatherLottieAnimation
import com.example.weatherapp.presentation.screens.screen_home.MainScreenUiState
import com.example.weatherapp.presentation.theme.BackgroundLight
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun LoadedWeatherScreen(
    modifier: Modifier = Modifier,
    loadedUiState: MainScreenUiState.Success
) {
    val loadedWeatherUiState = loadedUiState.weatherDomainModel
    val countryName = loadedUiState.weatherDomainModel.countryModel.country
    val cityName = loadedUiState.weatherDomainModel.cityName
    val sdf = SimpleDateFormat("hh:mm")
    val currentDate = sdf.format(Date())
    val currentDayName = LocalDate.now().dayOfWeek.name
    val temperature = (loadedUiState.weatherDomainModel.weatherMain.weatherTemperature - 273).toInt()
    val currentWeatherStatus = loadedUiState.weatherDomainModel.currentWeather.firstOrNull()?.weatherMain.orEmpty()

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "$cityName, $countryName",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.background,
            )
            Text(
                text = "$currentDate — ${
                    currentDayName.lowercase().replaceFirstChar { it.uppercase() }
                }",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.background,
            )
            WeatherStatusLotties(
                loadedUiState = loadedUiState,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(180.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "${temperature}° C",
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.background,
            )
            Text(
                text = currentWeatherStatus,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.background,
            )
            WeatherInfoBlock(
                humidity = loadedWeatherUiState.weatherMain.weatherHumidity,
                windSpeed = loadedWeatherUiState.weatherWind.windSpeed,
                pressure = loadedWeatherUiState.weatherMain.weatherPressure,
            )
        }
    }
}

@Composable
fun WeatherStatusLotties(
    loadedUiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier
) {
    loadedUiState.weatherDomainModel.currentWeather.firstOrNull()
        ?.apply {
            if (isClear) WeatherLottieAnimation(modifier, rawFile = R.raw.sunny_lottie)
            else if (isCloudy) WeatherLottieAnimation(modifier, rawFile = R.raw.rainny_lottie)
            else if (isMist) WeatherLottieAnimation(modifier, rawFile = R.raw.mist_weather_lottie)
        }
}

@Preview
@Composable
fun LoadedWeatherScreenPreview() {
    MaterialTheme {
        LoadedWeatherScreen(
            loadedUiState = MainScreenUiState.Success(WeatherDataDomainModel.preview),
            modifier = Modifier.background(BackgroundLight)
        )
    }
}