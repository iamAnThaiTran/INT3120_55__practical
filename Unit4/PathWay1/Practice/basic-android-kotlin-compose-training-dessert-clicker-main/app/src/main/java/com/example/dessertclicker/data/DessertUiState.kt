package com.example.dessertclicker.data

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource.dessertList

data class DessertUiState(
    val currentDessertIndex: Int = 0,
    val dessertsSold: Int = 0, // so luong banh da ban
    val revenue: Int = 0, // doanh thu
    val currentDessertPrice: Int = dessertList[currentDessertIndex].price, // gia ban hien tai
    @DrawableRes val currentDessertImageId: Int = dessertList[currentDessertIndex].imageId
)