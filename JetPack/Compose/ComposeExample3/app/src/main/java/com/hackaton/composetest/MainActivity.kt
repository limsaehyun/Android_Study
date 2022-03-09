package com.hackaton.composetest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.hackaton.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {

    var shouldShowOnboarding by remember { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClick = { shouldShowOnboarding = false })
    } else {
        Messages()
    }
}

@Composable
fun OnboardingScreen(onContinueClick: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome MainActivity")

            Button(
                modifier = Modifier.padding(24.dp),
                onClick = onContinueClick
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
fun Messages(names: List<String> = List(1000) { "$it" }) {
    LazyColumn(modifier = Modifier.padding(bottom = 4.dp)) {
        items(items = names) { name ->
            Message(name = name)
        }
    }

}

@Composable
fun Message(name: String) {

    val buttomState = remember { mutableStateOf(false) }
    val expendedPadding = if (buttomState.value) 24.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(8.dp, 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = expendedPadding)
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }

            OutlinedButton(onClick = {
                buttomState.value = !buttomState.value
            }) {
                Text(if (buttomState.value) "Show Less" else "Show More")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessagePreview() {
    ComposeTestTheme {
        MyApp()
    }
}
