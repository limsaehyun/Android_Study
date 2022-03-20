package com.hackaton.composetest.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.hackaton.composetest.ui.theme.ComposeTestTheme
import kotlinx.coroutines.launch

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SimpleList()
                }
            }
        }
    }
}

@Composable
fun SimpleList() {

    val listSize = 100
    val scrollState = rememberLazyListState()
    val coroutinesState = rememberCoroutineScope()

    Column {
        Row {
            Button(
                modifier = Modifier.weight(1F),
                onClick = {
                    coroutinesState.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }) {
                Text(text = "Scroll to the top")
            }
            Button(
                modifier = Modifier.weight(1F),
                onClick = {
                    coroutinesState.launch { 
                        scrollState.animateScrollToItem(listSize - 1)
                    }
                }
            ) {
                Text(text = "Scroll to the end")
            }
        }
        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Test Image",
            modifier = Modifier.size(50.dp)
        )

        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "Item $index",
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeTestTheme {
        SimpleList()
    }
}