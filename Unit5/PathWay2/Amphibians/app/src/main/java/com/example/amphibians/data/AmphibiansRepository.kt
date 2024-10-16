package com.example.amphibians.data

import com.example.amphibians.model.Amphibians
import com.example.amphibians.network.AmphibiansApiService

interface AmphibiansRepository {

    suspend fun getAmphibians(): List<Amphibians>
}


class DefaultAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {

    override suspend fun getAmphibians(): List<Amphibians> = amphibiansApiService.getAmphibians()
}