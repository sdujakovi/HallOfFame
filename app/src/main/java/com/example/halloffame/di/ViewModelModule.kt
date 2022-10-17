package com.example.halloffame.di

import com.example.data.repository.HallOfFameRepository
import com.example.halloffame.vm.HallOfFameViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ViewModelModule {

    @Provides
    fun provideHallOfFameViewModel(hallOfFameRepository: HallOfFameRepository) = HallOfFameViewModel(hallOfFameRepository)
}