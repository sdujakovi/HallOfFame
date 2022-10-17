package com.example.data.repository

import com.example.data.BuildConfig.API_KEY
import com.example.data.mappers.HallOfFameMapper
import com.example.data.remote.interfaces.HallOfFameApi
import javax.inject.Inject

class HallOfFameRepository @Inject constructor(private val hallOfFameApi: HallOfFameApi) {

    suspend fun getHallOfFame() = HallOfFameMapper.mapHallOfFameGamesResponseToListOfGames(hallOfFameApi.getMockHallOfFame(API_KEY))
}