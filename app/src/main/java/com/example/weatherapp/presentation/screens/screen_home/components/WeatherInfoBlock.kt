package com.example.weatherapp.presentation.screens.screen_home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.theme.BoxGradientColorGrayBlue

@Composable
fun WeatherInfoBlock(
    modifier: Modifier = Modifier,
    humidity: Int,
    windSpeed: Double,
    pressure: Int
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(66.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(BoxGradientColorGrayBlue),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Spacer(modifier = modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.rain_signiture),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "$humidity%",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = modifier.padding(start = 5.dp)
            )
            Spacer(modifier = modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.pressure_svgrepo_com),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "$pressure",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = modifier.padding(start = 5.dp)
            )
            Spacer(modifier = modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "$windSpeed km/h",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = modifier.padding(start = 5.dp)
            )
            Spacer(modifier = modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun WeatherInfoBlockPreview() {
    MaterialTheme {
        WeatherInfoBlock(
            humidity = 53,
            windSpeed = 2.0,
            pressure = 1024,
        )
    }
}