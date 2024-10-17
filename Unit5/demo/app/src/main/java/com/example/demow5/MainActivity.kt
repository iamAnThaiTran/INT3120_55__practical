package com.example.demow5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.updateBounds
import com.example.compose.Demow5Theme

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

         */

        //9patch
//        Image(painter = painterResource(R.drawable.TranThaiAn),
//            contentDescription = null
//        )






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

        ImageButton()
    }
}

@Composable
fun ImageButton(
    //onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            //.clickable { onClick() }
    ) {

        val bgImg = ContextCompat.getDrawable(
            LocalContext.current,
            R.drawable.tranthaian_1
        )
        Text(text = "This my xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx message",
            modifier = Modifier
                .drawBehind {
                    bgImg?.updateBounds(0, 0, size.width.toInt(), size.height.toInt())
                    bgImg?.draw(drawContext.canvas.nativeCanvas)
                }
                .padding(8.dp)
        )
    }
}

