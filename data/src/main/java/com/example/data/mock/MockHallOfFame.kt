package com.example.data.mock

import com.example.domain.game.Game

object MockHallOfFame {

    private const val thumbnailOne = "game/12090/7YWqBEm4.jpg"

    private const val thumbnailTwo = "game/12715/Ta8oxoNg.jpg"

    val gameOne = Game().apply {
        name = "Game One"
        tier = "Tier One"
        thumbnail = thumbnailOne
        description = "This is a valid mock description text, bla bla bla bla..."
        criticScore = 54.32
    }

    val gameTwo = Game().apply {
        name = "Game Two"
        tier = "Tier Two"
        thumbnail = thumbnailTwo
        description = "This is a valid mock description text, bla bla bla bla..."
        criticScore = 84.323
    }

    fun getMockHallOfFame() = listOf(gameOne, gameTwo, gameOne, gameTwo)
}