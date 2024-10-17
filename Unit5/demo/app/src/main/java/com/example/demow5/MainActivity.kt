package com.example.demow5

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.Demow5Theme
import com.example.compose.onPrimaryContainerLight
import com.example.compose.onPrimaryLight
import com.example.compose.primaryLight


import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Demow5Theme(darkTheme = true) {
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
fun Card88() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
     {
        Text(
            text = "meo meo meo meo"
        )
        Spacer(
            modifier = Modifier.padding(20.dp)
        )

        Text(
            text = "gaau gaau gaau gaau"
        )
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
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


        Spacer(modifier = Modifier.padding(20.dp))
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

        Card88()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Demow5Theme {
        Greeting("Android")
    }
}