package com.example.data.repository

import com.example.data.remote.interfaces.HallOfFameApi
import javax.inject.Inject

class HallOfFameRepository @Inject constructor(private val hallOfFameApi: HallOfFameApi) {}