package com.devtor.rickandmorty.ui

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devtor.rickandmorty.ui.components.TopAppBar
import com.devtor.rickandmorty.ui.screens.HomeScreen
import com.devtor.rickandmorty.ui.screens.RickAndMortyViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun RickAndMortyApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar()
        }
    ) {
        val rickAndMortyViewModel: RickAndMortyViewModel = viewModel(
            factory = RickAndMortyViewModel.Factory
        )
        HomeScreen(
            rickAndMortyUiState = rickAndMortyViewModel.rickAndMortyUiState,
            contentPadding = it
        )

    }
}