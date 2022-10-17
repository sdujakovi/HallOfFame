package com.example.data.remote.interfaces

import com.example.data.remote.responses.GameResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface HallOfFameApi {

    @GET("game/hall-of-fame")
    fun getMockHallOfFame(@Header("X-RapidAPI-Key") apiKey: String) : List<GameResponse>
}