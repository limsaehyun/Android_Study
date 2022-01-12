package com.saehyun.jetpackcomposeexample

import android.app.Application
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class PracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArtistCard(artist = "skeat")
        }

    }
    
    @Composable
    fun ArtistCard(
        artist  : String
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "profile image",
                modifier = Modifier
                    .size(40.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(artist)
                Text("3 minutes ago")
            }
        }
    }
    
    @Preview
    @Composable
    fun PreviewArtistCard() {
        ArtistCard(artist = "132")
    }
}