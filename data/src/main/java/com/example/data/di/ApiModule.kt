package com.example.data.di

import com.example.data.remote.interfaces.HallOfFameApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideGameApi(retrofit: Retrofit) = retrofit.create(HallOfFameApi::class.java)
}