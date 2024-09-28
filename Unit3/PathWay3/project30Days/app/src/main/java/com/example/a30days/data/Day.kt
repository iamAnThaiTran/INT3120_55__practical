package com.example.a30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30days.R

data class Day(
    val dayNumber: String,
    @StringRes val titleResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val descriptionResourceId: Int,
)

val dayList = listOf(
    Day("Day 1", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 2", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 3", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),
    Day("Day 4", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 5", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 6", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),
    Day("Day 7", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 8", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 9", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),
    Day("Day 10", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 11", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 12", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),
    Day("Day 13", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 14", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 15", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),
    Day("Day 16", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 17", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 18", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),
    Day("Day 19", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 20", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 21", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),
    Day("Day 22", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 23", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 24", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),
    Day("Day 25", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 26", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 27", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),
    Day("Day 28", R.string.titile1, R.drawable.ronaldo1, R.string.description1 ),
    Day("Day 29", R.string.titile2, R.drawable.ronaldo2, R.string.description2 ),
    Day("Day 30", R.string.titile3, R.drawable.ronaldo3, R.string.description3 ),



)
