package com.example.a30days

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30days.data.Day
import com.example.a30days.data.dayList
import com.example.a30days.ui.theme._30daysTheme

//import com.example.a30days.data.days

@Composable
fun DayList(
    days: List<Day> = dayList,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(8.dp),
) {
    LazyColumn(
        contentPadding = contentPadding
    ) {
        items(days) {
            DayCard(day = it)
        }
    }
}

@Composable
fun DayCard(
    day: Day,
    modifier: Modifier = Modifier.padding(8.dp)
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(8.dp),
       // elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), // do do bong
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(minHeight = 50.dp)
            ) {
                Text(
                    //stringResource(day.dayNumber),
                    text = day.dayNumber,
                    modifier = Modifier.weight(1f),
                    fontSize = 24.sp
                )
                DayButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded}
                )
            }
            if(expanded) {
                Text(
                    text = stringResource(day.titleResourceId),
                )
                Image(
                    painter = painterResource(day.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .size(200.dp)
                )
                Text(
                    text = stringResource(day.descriptionResourceId)
                )
            }
        }
    }
}

@Composable
fun DayButton(
    expanded: Boolean,
    onClick: () -> Unit, // ham lam da khong co tham so dau vao, unit khong tra ve gi
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            // imageVector = Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
@Preview
fun ScreenPreview() {
    _30daysTheme() {
        Surface() {
            DayList()
        }
    }
}

