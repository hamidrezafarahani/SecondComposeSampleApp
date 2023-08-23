package com.example.secondcomposesampleapp

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.secondcomposesampleapp.ui.theme.SecondComposeSampleAppTheme

@Composable
fun AppScreen() {
    var shouldShowOnBoarding by rememberSaveable {
        mutableStateOf(true)
    }
    if (shouldShowOnBoarding) {
        OnBoardingScreen {
            shouldShowOnBoarding = false
        }
    } else {
        GreetingScreen()
    }
}

@Preview("Light Mode", showBackground = true)
@Preview("Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun AppScreenPreview() {
    SecondComposeSampleAppTheme {
        AppScreen()
    }
}