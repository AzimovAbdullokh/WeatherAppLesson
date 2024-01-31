package com.example.weatherapp.presentation.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.theme.BackgroundLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopAppBar(
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BackgroundLight
        ),
        title = {
            Text(
                text = stringResource(id = R.string.weather),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.background,
            )
        }
    )
}

@Preview
@Composable
fun WeatherTopAppBarPreview() {
    MaterialTheme {
        WeatherTopAppBar()
    }
}