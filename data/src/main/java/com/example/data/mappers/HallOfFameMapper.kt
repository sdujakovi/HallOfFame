package com.example.data.mappers

import com.example.data.remote.responses.GameResponse
import com.example.domain.game.Game

object HallOfFameMapper {

    fun mapHallOfFameGamesResponseToListOfGames(response: List<GameResponse>): List<Game> =
        response.map { game ->
            Game().apply {
                game.id?.let { id = it.toString() }
                game.name?.let { name = it }
                game.topCriticScore?.let { criticScore = it }
                game.tier?.let { tier = it }
                game.images?.box?.sm?.let { thumbnail = it }
            }
        }
}