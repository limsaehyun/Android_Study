package com.hackaton.composetest

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hackaton.composetest.ui.theme.ComposeTestTheme

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        drawerContent = { Text(text = "drawer Test") },
        topBar = {
            TopAppBar(
                title =  { Text(text = "Scaffold 예제", textAlign = TextAlign.Center) },
                backgroundColor = Color.Gray
            )
        },
        content = {
            Text(text = "Api slot test")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ComposeTestTheme {
        HomeScreen()
    }
}