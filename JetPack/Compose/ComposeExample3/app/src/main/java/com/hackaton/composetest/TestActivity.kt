package com.hackaton.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hackaton.composetest.ui.theme.ComposeTestTheme

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                MyApp2()
            }
        }
    }
}

@Composable
fun MyApp2() {
    var shouldOnBoarding by remember {
        mutableStateOf(true)
    }

    if(shouldOnBoarding) {
        ContinueButton(onContinueButton = { shouldOnBoarding = false })
    } else {
        Messages2()
    }
}

@Composable
fun ContinueButton(onContinueButton: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Click Button!!")

        Button(
            modifier = Modifier.padding(24.dp),
            onClick = onContinueButton
        ) {
            Text(text = "Cotinue")
        }
    }
}

@Composable
fun Messages2(names: List<String> = listOf("Test", "Test2")) {
    Column {
        for(name in names) {
            Message2(name)
        }
    }
}
@Composable
fun Message2(name: String) {

    var buttuonPress by remember { mutableStateOf(false) }
    var buttonBottomMargin = if (buttuonPress) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(8.dp, 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(24.dp)
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = buttonBottomMargin)
            ) {
                Text("Hello,")
                Text(name)
            }
            OutlinedButton(
                onClick = { buttuonPress = !buttuonPress }
            ) {
                Text(if(buttuonPress) "Show Less" else "Show More")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    ComposeTestTheme {
        MyApp2()
    }
}