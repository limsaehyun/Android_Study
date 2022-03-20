package com.hackaton.composetest.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

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

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(8.dp, 4.dp)
    ) {
        CardContent(name)
    }
}

@Composable()
fun CardContent(name: String) {

    var buttomState by rememberSaveable { mutableStateOf(false) }

    val expendedPadding by animateDpAsState (
        if (buttomState) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )

    Row(
        modifier = Modifier.padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = expendedPadding.coerceAtLeast(0.dp))
        ) {
            Text(text = "Hello,")
            Text(text = name, style = MaterialTheme.typography.h4.copy(
                fontWeight = FontWeight.ExtraBold
            ))
            if(buttomState) {
                Text(
                    text = ("이건 텍스트입니다.").repeat(10)
                )
            }
        }

        IconButton(onClick = { buttomState = !buttomState }) {
            Icon(
                imageVector = if (buttomState) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (buttomState) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessagePreview() {
    ComposeTestTheme {
        Message("Android")
    }
}
