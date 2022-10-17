package com.example.halloffame.ui.game

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.domain.game.Game
import com.example.halloffame.R
import com.example.halloffame.util.toStringAsFixed

@Composable
fun HallOfFameItem(game: Game) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column {
            FirstRowContent(game)
            SecondRowContent(game)
        }
    }
}

@Composable
fun FirstRowContent(game: Game) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 15.dp, end = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BaseGameInfo(game = game)
        Icon(
            modifier = Modifier.padding(end = 5.dp),
            imageVector = Icons.Rounded.FavoriteBorder,
            contentDescription = "Add to favorites button",
        )
    }
}

@Composable
fun SecondRowContent(game: Game) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp, start = 20.dp, end = 20.dp, top = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = game.description,
            modifier = Modifier.fillMaxWidth(0.8f),
            style = MaterialTheme.typography.bodySmall,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = game.criticScore.toStringAsFixed(1),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Composable
fun BaseGameInfo(game: Game) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        GameImage(game = game)
        Column(
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 15.dp)
                .fillMaxWidth(0.8f)
        ) {
            Text(
                text = game.name,
                modifier = Modifier.padding(top = 10.dp),
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = game.tier,
                modifier = Modifier.padding(bottom = 10.dp),
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun GameImage(game: Game) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://img.opencritic.com/" + game.thumbnail)
            .crossfade(true)
            .build(),
        placeholder = painterResource(id = R.drawable.ic_videogame),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(74.dp)
            .width(74.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewGameItem() {
    HallOfFameItem(
        game = Game().apply {
            name = "name"
            tier = "tier"
            criticScore = 98.422
            description = "description text"
        }
    )
}