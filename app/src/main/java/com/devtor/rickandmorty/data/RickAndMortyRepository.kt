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
            //Log.d("Network Success", rickAndMortyService.getPhotos().results.toString())

            rickAndMortyService.getPhotos().results

        }catch (e: Exception){
            //Log.e("Network Error", e.message.toString())
            emptyList<CharacterResponse>()
        }
    }
}

