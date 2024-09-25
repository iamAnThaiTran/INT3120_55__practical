package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ArtSpaceMain()
                    }

            }
        }
    }


    

}

@Composable
fun ArtContent(artPainter: Painter, artTitile: String, artArtist: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = artPainter,
            contentDescription = null,
            modifier = Modifier
                //.padding(100.dp)
                .height(300.dp)
                .width(300.dp)
                .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
                .shadow(elevation = 4.dp)
                .padding(5.dp)
                .padding(2.dp)
        )
        Card(
            modifier = Modifier
                .padding(horizontal = 50.dp, vertical = 100.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = artTitile,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Thin
                )
                Text(
                    text = artArtist,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ArtSpaceMain() {
    var result by remember {mutableStateOf(3)}
    when (result) {
        1 -> ArtContent(
            artPainter = painterResource(R.drawable.ronaldo1),
            artTitile = "Siuuuuuuu",
            artArtist = "Lionel Messi"

        )

        2 -> ArtContent(
            artPainter = painterResource(R.drawable.ronaldo2),
            artTitile = "Greatest Of All Time",
            artArtist = "Lionel Messi"

        )

        else -> ArtContent(
            artPainter = painterResource(R.drawable.ronaldo3),
            artTitile = "Da real Goat",
            artArtist = "Lionel Messi"

        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 700.dp)
    ) {
        Button(
            onClick = { result-- },
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
            )
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = { result++ },
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
            )
        ) {
            Text(text = "Next")
        }
        if(result < 1 ) {
            result = 3
        } else if (result > 3) {
            result = 1
        }
    }

}


