package com.example.secondcomposesampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.secondcomposesampleapp.ui.theme.SecondComposeSampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeSampleAppTheme {
                AppScreen()
            }
        }
    }
}