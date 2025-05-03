package com.devtor.rickandmorty.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            )
            Log.d("HomeScreen", "HomeScreen: ${rickAndMortyUiState.photos}")
        }

        is RickAndMortyUiState.Error -> ErrorScreen(modifier)
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