package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridapp.data.DataSource
import com.example.gridapp.model.Topic
import com.example.gridapp.ui.theme.GridAppTheme
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    //.statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(
//                        modifier = Modifier.padding(
//                            start = dimensionResource(R.dimen.padding_small),
//                            top = dimensionResource(R.dimen.padding_small),
//                            end = dimensionResource(R.dimen.padding_small),
                    )
                }
            }
        }
    }

    @Composable
    fun TopicGrid(modifier: Modifier = Modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
//        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
//        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            modifier = modifier
        ) {
            items(DataSource.topics) { topic ->
                TopicCard(topic)
            }
        }
    }


    @Composable
    fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
        Card(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            //shape = RoundedCornerShape(8.dp)
        ) {
            Row() {
                Box(
                    modifier = Modifier.size(68.dp)
                ) {
                    Image(
                        painter = painterResource(id = topic.imageResourceId),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 68.dp, height = 68.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column() {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = topic.stringResourceId),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.wrapContentWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.ic_grain),
                            contentDescription = null,
//                    modifier = Modifier
//                        .padding(start = dimensionResource(R.dimen.padding_medium))
                        )
                        Text(
                            text = topic.numberCourses.toString(),
                            style = MaterialTheme.typography.labelMedium,
                            //modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                        )
                    }
                }
            }
        }
    }
}

