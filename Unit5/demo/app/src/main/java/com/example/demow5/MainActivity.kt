package com.example.demow5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.demow5.ui.theme.Demow5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Demow5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        //jpg file
        /*
        Image(painter = painterResource(R.drawable.ronaldo3),
            contentDescription = null
        )

        //9patch
        Image(painter = painterResource(R.drawable.ronaldo2),
            contentDescription = null
        )

         */

        //layerlist
        Image(painter = painterResource(R.drawable.baseline_add_a_photo_24),
            contentDescription = null
        )

        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.thientruong),
                contentDescription = null
            )

            Image(painter = painterResource(R.drawable.ronaldo3),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Demow5Theme {
        Greeting("Android")
    }
}