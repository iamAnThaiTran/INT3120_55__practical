package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.model.Amphibians

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier)
        is AmphibiansUiState.Success -> ListScreen(amphibiansUiState.data, modifier)
        is AmphibiansUiState.Error -> ErrorScreen({},modifier)
    }

}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier
                .size(200.dp),
            painter = painterResource(id = R.drawable.loading_img),
            contentDescription = null
        )
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = "loading fail", modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(text = "retry")
        }
    }
}

@Composable
fun AmphibianCard(
    amphibians: Amphibians,
    modifier: Modifier = Modifier

) {


    Card(
        modifier = modifier
            .padding(16.dp)
            //.background(backgroundColor)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium)
                //.background(surfaceColor)
                .padding(4.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = modifier
                    .padding(4.dp)
            ) {
                Text(
                    text = amphibians.name + " (" + amphibians.type + ")",
                    //style = androidx.compose.material.MaterialTheme.typography.h2,
                    //color = textColor,
                )
            }
            Spacer(modifier = modifier.height(8.dp))
            Column(
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                        .shadow(4.dp),

                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(amphibians.imgSrc)
                        .crossfade(true)
                        .build(),
                    contentDescription = amphibians.type,
                    contentScale = ContentScale.Crop,
                    error = painterResource(id = R.drawable.ic_broken_image),
                    placeholder = painterResource(id = R.drawable.loading_img),
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    text = amphibians.description,
                    modifier = modifier
                        .padding(4.dp),
                    //color = textColor,
                    //style = androidx.compose.material.MaterialTheme.typography.body1
                )
            }

        }
    }
    Spacer(modifier = modifier.height(16.dp))
}
@Composable
fun ListScreen(
    amphibians: List<Amphibians>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier

    ) {
        items(amphibians.size) { index ->
            AmphibianCard(amphibians = amphibians[index])
        }
    }
}