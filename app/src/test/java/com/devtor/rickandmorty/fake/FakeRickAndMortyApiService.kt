package com.devtor.rickandmorty.fake

import com.devtor.rickandmorty.network.RickAndMortyResponse
import com.devtor.rickandmorty.network.RickAndMortyService

class FakeRickAndMortyApiService: RickAndMortyService{
    override suspend fun getPhotos(): RickAndMortyResponse {
        return FakeDataSource.response
    }
}
