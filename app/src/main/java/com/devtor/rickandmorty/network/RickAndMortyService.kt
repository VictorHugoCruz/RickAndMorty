package com.devtor.rickandmorty.network

import retrofit2.http.GET

interface RickAndMortyService {
    @GET("character")
    suspend fun getPhotos(
    ): RickAndMortyResponse
}