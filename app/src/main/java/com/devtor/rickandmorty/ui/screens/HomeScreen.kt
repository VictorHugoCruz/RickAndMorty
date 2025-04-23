package com.devtor.rickandmorty.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.devtor.rickandmorty.network.CharacterResponse

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    rickAndMortyUiState: RickAndMortyUiState,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Log.d("HomeScreen", "HomeScreen: $rickAndMortyUiState")
    when (rickAndMortyUiState) {
        is RickAndMortyUiState.Loading -> LoadingScreen(modifier.padding(contentPadding))
        is RickAndMortyUiState.Success -> {
            ListRickAndMorty(
                modifier = modifier,
                list = rickAndMortyUiState.photos
            )
            Log.d("HomeScreen", "HomeScreen: ${rickAndMortyUiState.photos}")
        }

        is RickAndMortyUiState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun ListRickAndMorty(modifier: Modifier = Modifier, list: List<CharacterResponse>) {
    LazyVerticalGrid(
        modifier=modifier,
        columns = GridCells.Adaptive(150.dp)
    ) {
        items(
            items = list,
            key = {photo -> photo.id}
        ) {character->
            RickAndMortyPhotoCard(
                character = character,
                modifier = modifier.padding(4.dp).fillMaxWidth().aspectRatio(1.5f)
            )
        }
    }
}

@Composable
fun RickAndMortyPhotoCard(modifier: Modifier = Modifier, character: CharacterResponse) {
    Card(
        modifier = modifier.fillMaxSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Log.d("Card", "HomeScreen: ${character.imageUrl}")
        AsyncImage(
            model = character.imageUrl,
            contentDescription = character.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Error",
            style = MaterialTheme.typography.displayLarge
        )
    }
}

@Composable
fun SuccessScreen(modifier: Modifier = Modifier, rickAndMortyUiState: String) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = rickAndMortyUiState,
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Loading",
            style = MaterialTheme.typography.displayLarge
        )
    }
}