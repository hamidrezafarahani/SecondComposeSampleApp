package com.example.secondcomposesampleapp

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.secondcomposesampleapp.ui.theme.SecondComposeSampleAppTheme

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Basic Code lab")
        Button(
            modifier = modifier.padding(vertical = 24.dp),
            onClick = onContinueClick
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview("Light Mode", showBackground = true)
@Preview("Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingScreenPreview() {
    SecondComposeSampleAppTheme {
        OnBoardingScreen()
    }
}