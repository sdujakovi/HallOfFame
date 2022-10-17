package com.example.data.di

import com.example.data.remote.interfaces.HallOfFameApi
import com.example.data.repository.HallOfFameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideGameRepository(hallOfFameApi: HallOfFameApi) = HallOfFameRepository(hallOfFameApi)
}