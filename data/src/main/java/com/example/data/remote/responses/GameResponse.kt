package com.example.data.remote.responses

class GameResponse {
    var id: Int? = null
    var name: String? = null
    var tier: String? = null
    var topCriticScore: Double? = null
    var images: ImagesData? = null
}

class ImagesData {
    var box: ScreenshotData? = null
    var banner: ScreenshotData? = null
}

class ScreenshotData {
    var og: String? = null
    var sm: String? = null
}