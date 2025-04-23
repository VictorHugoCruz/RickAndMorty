package com.devtor.rickandmorty.fake

import com.devtor.rickandmorty.data.NetworkRickAndMortyRepository
import com.devtor.rickandmorty.data.RickAndMortyRepository
import com.devtor.rickandmorty.network.CharacterResponse

class FakeRickAndMortyRepository():RickAndMortyRepository {
    override suspend fun getRickAndMortyPhotos(): List<CharacterResponse> {
        return FakeDataSource.data
    }
}