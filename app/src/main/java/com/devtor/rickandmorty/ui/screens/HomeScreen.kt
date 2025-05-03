package com.devtor.rickandmorty.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    rickAndMortyUiState: RickAndMortyUiState,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when (rickAndMortyUiState) {
        is RickAndMortyUiState.Loading -> LoadingScreen(modifier.padding(contentPadding))
        is RickAndMortyUiState.Success -> {
            SuccessScreen(
                modifier = modifier.padding(contentPadding),
                list = rickAndMortyUiState.photos
            )
        }

        is RickAndMortyUiState.Error -> ErrorScreen(modifier)
    }
}




