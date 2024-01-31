package com.example.weatherapp.presentation.components

import androidx.annotation.RawRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.weatherapp.R

@Composable
fun WeatherLottieAnimation(
    modifier: Modifier = Modifier,
    @RawRes rawFile: Int
) {
    val preloaderLottieComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(rawFile))

    val preloaderProgress by animateLottieCompositionAsState(
        composition = preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}

@Preview
@Composable
fun WeatherLottieAnimationPreview() {
    MaterialTheme {
        WeatherLottieAnimation(
            rawFile = R.raw.no_internet_lottie
        )
    }
}
