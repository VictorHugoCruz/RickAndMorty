package com.devtor.rickandmorty.data

import com.devtor.rickandmorty.network.RickAndMortyService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val rickAndMortyRepository: RickAndMortyRepository
}

class DefaultAppContainer() : AppContainer {
    private val baseUrl = "https://rickandmortyapi.com/api/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: RickAndMortyService by lazy {
        retrofit.create(RickAndMortyService::class.java)
    }

    override val rickAndMortyRepository: RickAndMortyRepository by lazy {
        NetworkRickAndMortyRepository(retrofitService)
    }

}

