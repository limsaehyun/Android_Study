package com.hackaton.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hackaton.composetest.ui.theme.ComposeTestTheme

class LayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Profile("Android")
                }
            }
        }
    }
}

@Composable
fun Profile(name: String) {
    var click by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        UpdateProfile(name = name, onClick = { click = !click })

        Spacer(modifier = Modifier.padding(16.dp))

        if(click) {
            ProfileImage()
        }
    }
}

@Composable
fun ProfileImage() {
    Card() {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "image",
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun UpdateProfile(name: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "profile Image",
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        
        Spacer(modifier = Modifier.padding(8.dp))

        Column {
            Text(text = "Hello", style = MaterialTheme.typography.subtitle2)
            Text(text = name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeTestTheme {
        Profile("Android")
    }
}