package com.devtor.rickandmorty.fake

import com.devtor.rickandmorty.ui.screens.RickAndMortyUiState
import com.devtor.rickandmorty.ui.screens.RickAndMortyViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RickAndMortyViewModelTest {
    @Test
    fun rickAndMortyViewModel_getCharacters_success() =
        runTest {
            val rickAndMortyViewModel = RickAndMortyViewModel(
                rickAndMortyRepository = FakeRickAndMortyRepository()
            )
            assertEquals(
                RickAndMortyUiState.Success("Success: ${FakeDataSource.data.size} RickAndMorty photos retrieved"),
                rickAndMortyViewModel.rickAndMortyUiState
                )

        }
}