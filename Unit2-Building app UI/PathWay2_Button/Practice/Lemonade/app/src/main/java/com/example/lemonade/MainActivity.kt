package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()

            }
        }
    }
}

@Composable
fun LemonContent(textAction: String, painter: Painter, imageDescription: String, step: Int): Int {
    var currentStep by remember { mutableStateOf(step) }
    var squeezeCount = (2..4).random()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = textAction
        )
        Image(
            painter = painter,
            contentDescription = imageDescription,
            modifier = Modifier
                .clickable {
                    squeezeCount--
                    if(currentStep == 2) {
                        if(squeezeCount == 0) {
                            currentStep = 3
                        }
                    }
                    else if(currentStep + 1 == 5) {
                        currentStep = 1
                    } else currentStep ++
                }
        )
    }
    return currentStep
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Lemonade") },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        content = { padding -> Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    currentStep = LemonContent(
                        textAction = stringResource(R.string.lemon_select),
                        painter = painterResource(R.drawable.lemon_tree),
                        imageDescription = stringResource(R.string.lemonade_content_description),
                        step = 1
                    )

                }

                2 -> {
                    currentStep = LemonContent(
                        textAction = stringResource(R.string.lemon_squeeze),
                        painter = painterResource(R.drawable.lemon_squeeze),
                        imageDescription = stringResource(R.string.lemon_content_description),
                        step = 2
                    )

                }
                3 -> {
                    currentStep = LemonContent(
                        textAction = stringResource(R.string.lemon_drink),
                        painter = painterResource(R.drawable.lemon_drink),
                        imageDescription = stringResource(R.string.lemonade_content_description),
                        step = 3
                    )

                }
                4 -> {
                    currentStep = LemonContent(
                        textAction = stringResource(R.string.lemon_empty_glass),
                        painter = painterResource(R.drawable.lemon_restart),
                        imageDescription = stringResource(R.string.empty_glass_content_description),
                        step = 4
                    )

                }
            }
        }
        }
    )

}

