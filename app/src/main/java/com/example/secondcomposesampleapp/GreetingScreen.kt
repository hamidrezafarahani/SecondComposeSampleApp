package com.example.secondcomposesampleapp

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    val extraPadding by animateDpAsState(
        targetValue = if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = ""
    )
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 2.dp, horizontal = 4.dp)
    ) {
        Row(modifier = modifier.padding(24.dp)) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello")
                Text(
                    text = "$name!",
                )
            }
            ElevatedButton(onClick = { expanded = !expanded }) {
                Text(text = if (expanded) "Show less" else "Show more")
            }
        }

    }
}

@Composable
fun GreetingScreen(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
            items(names) {
                Greeting(name = it)
            }
        }
    }
}
