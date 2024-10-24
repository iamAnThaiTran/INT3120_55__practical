package com.example.testingui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testingui.ui.theme.TestingUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestingUITheme {

                    Greeting(
                        name = "Android",
                        //modifier = Modifier.padding(innerPadding)
                    )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    var selectedItem by remember { mutableStateOf("No item selected") }
    var itemList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("TestingUI") })
        },
        bottomBar = {
            BottomAppBar {
                Text("Bottom Navigation")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Search:")
            BasicTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                items(itemList.size) { index ->
                    val item = itemList[index]
                    Button(
                        onClick = { selectedItem = item },
                        modifier = Modifier.fillMaxWidth().padding(4.dp)
                    ) {
                        Text(item)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Selected: $selectedItem")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingUITheme {
        Greeting("Android")
    }
}