package com.example.halloffame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.halloffame.ui.game.HallOfFameScreen
import com.example.halloffame.ui.theme.HallOfFameTheme
import com.example.halloffame.vm.HallOfFameViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val hallOfFameViewModel: HallOfFameViewModel = hiltViewModel()
            val games = hallOfFameViewModel.getHallOfFameGamesSuccess.observeAsState().value
            val progress = hallOfFameViewModel.anyUseCaseInProgress.observeAsState().value

            LaunchedEffect(Unit) {
                hallOfFameViewModel.getHallOfFameGames()
            }

            HallOfFameTheme() {
                HallOfFameScreen(games, progress)
            }
        }
    }
}