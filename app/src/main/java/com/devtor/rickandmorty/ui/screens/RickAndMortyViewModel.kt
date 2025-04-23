package com.devtor.rickandmorty.ui.screens

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.devtor.rickandmorty.RickAndMortyApplication
import com.devtor.rickandmorty.data.RickAndMortyRepository
import com.devtor.rickandmorty.network.CharacterResponse
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface RickAndMortyUiState {
    data class Success(
        val photos: List<CharacterResponse>
    ) : RickAndMortyUiState

    object Error : RickAndMortyUiState
    object Loading : RickAndMortyUiState
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class RickAndMortyViewModel(
    private val rickAndMortyRepository: RickAndMortyRepository
) : ViewModel() {
    var rickAndMortyUiState: RickAndMortyUiState by mutableStateOf(RickAndMortyUiState.Loading)
        private set

    init {
        getRickAndMortyPhotos()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getRickAndMortyPhotos() {
        viewModelScope.launch {
            try {
                val listResult = rickAndMortyRepository.getRickAndMortyPhotos()

                rickAndMortyUiState = RickAndMortyUiState.Success(
                    photos = listResult
                )
            } catch (e: IOException) {
                rickAndMortyUiState = RickAndMortyUiState.Error
                println("Error: ${e.message}")
            }catch (e: HttpException) {
                rickAndMortyUiState = RickAndMortyUiState.Error
                println("Error: ${e.message}")
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as RickAndMortyApplication)
                val rickAndMortyRepository = application.container.rickAndMortyRepository
                RickAndMortyViewModel(rickAndMortyRepository = rickAndMortyRepository)
            }
        }
    }
}


