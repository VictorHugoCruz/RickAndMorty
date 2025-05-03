package com.devtor.rickandmorty.data

import android.util.Log
import com.devtor.rickandmorty.network.CharacterResponse
import com.devtor.rickandmorty.network.RickAndMortyResponse
import com.devtor.rickandmorty.network.RickAndMortyService

interface RickAndMortyRepository {
    suspend fun getRickAndMortyPhotos(): List<CharacterResponse>
}

class NetworkRickAndMortyRepository(
    private val rickAndMortyService: RickAndMortyService
): RickAndMortyRepository {
    override suspend fun getRickAndMortyPhotos(): List<CharacterResponse> {
        return try {

            rickAndMortyService.getPhotos().results

        }catch (e: Exception){
            emptyList<CharacterResponse>()
        }
    }
}

