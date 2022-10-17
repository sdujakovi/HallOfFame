package com.example.halloffame.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.HallOfFameRepository
import com.example.domain.game.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HallOfFameViewModel @Inject constructor(private val hallOfFameRepository: HallOfFameRepository) : ViewModel() {

    val getHallOfFameGamesSuccess = MutableLiveData<List<Game>>()
    val anyUseCaseInProgress = MutableLiveData<Boolean>()
    val anyUseCaseFailure = MutableLiveData<Throwable>()

    fun getHallOfFameGames() {
        viewModelScope.launch {
            try {
                anyUseCaseInProgress.postValue(true)
                getHallOfFameGamesSuccess.postValue(listOf()) // repository call
            } catch (cause: Throwable) {
                anyUseCaseFailure.postValue(cause)
            } finally {
                anyUseCaseInProgress.postValue(false)
            }
        }
    }
}