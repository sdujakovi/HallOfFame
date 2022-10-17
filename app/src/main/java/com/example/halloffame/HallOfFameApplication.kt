package com.example.halloffame

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class HallOfFameApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}