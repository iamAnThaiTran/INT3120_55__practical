package com.example.superheros

import SuperHerosTheme
import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheros.model1.Hero
import com.example.superheros.model1.HeroesRepository

@OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)
@Composable
fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(8.dp),
) {
    LazyColumn(contentPadding = contentPadding) {
            itemsIndexed(heroes) { index, hero ->
                HeroCard(
                    hero = hero,
                    modifier = Modifier
                        .padding(8.dp)
                        // Animate each list item to slide in vertically
                )
            }
        }

}

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier= Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Composable
fun HeroInfo(hero: Hero, modifier: Modifier = Modifier) {
    Column() {
        Text(
            text = stringResource(hero.nameRes) ,
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(hero.descriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroIcon(hero: Hero, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(hero.imageRes),
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.FillWidth,
        contentDescription = null
    )
}

@Preview("Heroes List")
@Composable
fun HeroesPreview() {
    SuperHerosTheme(darkTheme = false) {
        Surface (
            color = MaterialTheme.colorScheme.background
        ) {
            /* Important: It is not a good practice to access data source directly from the UI.
            In later units you will learn how to use ViewModel in such scenarios that takes the
            data source as a dependency and exposes heroes.
            */
            HeroesList(heroes = HeroesRepository.heroes)
        }
    }
}