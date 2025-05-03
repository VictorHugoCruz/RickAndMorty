package com.devtor.rickandmorty.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.devtor.rickandmorty.model.CharacterItem

@Composable
fun SuccessScreen(modifier: Modifier = Modifier, list: List<CharacterItem>) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        RickAndMortyGrid(list = list)
    }
}

@Composable
fun RickAndMortyGrid(modifier: Modifier = Modifier, list: List<CharacterItem>) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Adaptive(150.dp),
    ) {
        items(
            list
        ) { item ->

            Card(
                modifier = Modifier.padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Log.d("teste", "$item")
                AsyncImage(
                    modifier= Modifier.size(300.dp),
                    model = item.imageUrl,
                    contentDescription = item.name,
                    contentScale = ContentScale.Crop,
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GridPreview() {
    MaterialTheme {
        RickAndMortyGrid(list = listOf(
            CharacterItem(
                id = 1,
                name = "Rick Sanchez",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
            ),
            CharacterItem(
                id = 2,
                name = "Morty Smith",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
            ),
            CharacterItem(
                id = 3,
                name = "Summer Smith",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/3.jpeg"
            ),
            CharacterItem(
                id = 4,
                name = "Beth Smith",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/4.jpeg"
            ),
            CharacterItem(
                id = 5,
                name = "Jerry Smith",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/5.jpeg"
            )
        ))
    }
}