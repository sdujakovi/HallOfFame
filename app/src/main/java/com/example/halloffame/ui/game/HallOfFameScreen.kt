package com.example.halloffame.ui.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.game.Game

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HallOfFameScreen(games: List<Game>?, progress: Boolean?) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        "Hall of Fame",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                scrollBehavior = scrollBehavior
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                games?.let {
                    items(items = it.toTypedArray()) { game ->
                        HallOfFameItem(game)
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HallOfFameScreen(
        games = MutableList(5) {
            Game().apply {
                name = "name"
                tier = "tier"
                criticScore = 92.321
                thumbnail = "game/12361/pXD4SeFs.jpg"
                description = "description text"
            }
        },
        progress = false
    )
}