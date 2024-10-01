package com.example.demow4

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demow4.ui.theme.Demow4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Demow4Theme {
                LazyVerticalGridExample()
            }
        }
    }
}

@Composable
fun MyApp() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            Log.d("ButtonClick", "Nút đã được nhấn!")
        }) {
            Text(text = "Nhấn vào tôi")
        }

        Image(
            painter = painterResource(R.drawable.ronaldo1),
            contentDescription =  null,
            Modifier.clickable {
                Log.d("Ronalo", "Ronaldo đã được nhấp")
            }
        )

        Fab()
        TapGestureExample()


    }

}

@Composable
fun Fab() {
    FloatingActionButton(
        onClick = {
            Log.d("Fab", "Fab đã được nhấp")
        },
        modifier = Modifier.size(200.dp)
    ) {
        Icon(Icons.Default.Call, contentDescription = null)
    }
}

@Composable
fun TapGestureExample() {

//    LazyColumn {
//        // Add a single item
//        item {
//            Text(text = "First item")
//        }
//
//        // Add 5 items
//        items(5) { index ->
//            Text(text = "Item: $index")
//        }
//
//        // Add another single item
//        item {
//            Text(text = "Last item")
//        }
//    }




//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .pointerInput(Unit) {
//                detectTapGestures(
//                    onTap = { offset ->
//                        Log.d("TapGesture", "Nhấn tại: $offset")
//                    },
//                    onDoubleTap = {
//                        Log.d("TapGesture", "Nhấn đúp!")
//                    }
//                )
//            }
//    ) {
//        Text("Nhấn vào bất kỳ đâu!")
//    }



}

@Composable
fun LazyRowExample() {
    LazyRow {
        item {
            Card(
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = "Item 1", modifier = Modifier.padding(16.dp))
            }
        }

        items(5) { index ->
            Card(
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = "Item ${index + 2}", modifier = Modifier.padding(16.dp))
            }
        }

    }
}

@Composable
fun LazyVerticalGridExample() {
    val columns = 3

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)

    ) {
        items(100) { index ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            ) {
                Text(text = "Item $index", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun LazyHorizontalGridExample() {
    // Số hàng trong lưới
    val rows = 3

    LazyHorizontalGrid(
        rows = GridCells.Fixed(rows),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(15) { index ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .width(100.dp),

                ) {
                Text(text = "Item $index", modifier = Modifier.padding(16.dp))
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}