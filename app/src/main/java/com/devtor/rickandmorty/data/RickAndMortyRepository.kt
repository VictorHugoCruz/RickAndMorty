package com.devtor.rickandmorty.data

import android.util.Log
import com.devtor.rickandmorty.model.CharacterItem
import com.devtor.rickandmorty.network.CharacterResponse
import com.devtor.rickandmorty.network.RickAndMortyResponse
import com.devtor.rickandmorty.network.RickAndMortyService

interface RickAndMortyRepository {
    suspend fun getRickAndMortyPhotos(): List<CharacterItem>
}

class NetworkRickAndMortyRepository(
    private val rickAndMortyService: RickAndMortyService
): RickAndMortyRepository {
    override suspend fun getRickAndMortyPhotos(): List<CharacterItem> {
        return try {

            rickAndMortyService.getPhotos().results.map {
                CharacterItem(
                    id = it.id,
                    name = it.name,
                    imageUrl = it.imageUrl
                )
            }

        }catch (e: Exception){
            emptyList<CharacterItem>()
        }
    }
}

