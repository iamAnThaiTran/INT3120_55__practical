package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            //.background(Color.DarkGray)
            .padding(bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .background(color = Color.DarkGray)
                .height(120.dp)
                .width(150.dp)
        )
        Text(
            text = "An Dep trai vcl",
            color = Color.Black,
            fontSize = 32.sp
        )
        Text(
            text = "Android Developer",
            color = Color(0xFF3ddc84)
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth()
            //.fillMaxWidth()
            //.background(Color.DarkGray)
            .padding(bottom = 50.dp)
            .padding(top = 500.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 70.dp),
            //horizontalArrangement = Arrangement.Start

        ) {
            Icon(
                Icons.Rounded.Call,
                contentDescription = null
            )
            Text(
                text = "+84 0328427594",
                color = Color.Black
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 70.dp),
           // horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = null
            )
            Text(
                text = "@AndroidDev",
                color = Color.Black
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 70.dp),
            //horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = null
            )
            Text(
                text = "anthaitran1001@gmail.com",
                color = Color.Black
            )
        }

    }
}

@Composable
@Preview
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}