package com.devtor.rickandmorty.fake

import com.devtor.rickandmorty.network.CharacterResponse
import com.devtor.rickandmorty.network.Origin
import com.devtor.rickandmorty.network.PageInfo
import com.devtor.rickandmorty.network.RickAndMortyResponse

object FakeDataSource {
    val data = listOf<CharacterResponse>(
        CharacterResponse(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = Origin(
                name = "Earth (C-137)",
                url = "https://rickandmortyapi.com/api/location/1"
            ),
            location = Origin(
                name = "Earth (C-137)",
                url = "https://rickandmortyapi.com/api/location/20"
            ),
            episode = listOf(),
            created = "2017-11-04T18:48:46.250Z",
            url = "https://rickandmortyapi.com/api/character/1",
            imageUrl ="https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        ),
        CharacterResponse(
            id = 2,
            name = "Morty Smith",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = Origin(
                name = "Earth (C-137)",
                url = "https://rickandmortyapi.com/api/location/1"
            ),
            location = Origin(
                name = "Earth (C-137)",
                url = "https://rickandmortyapi.com/api/location/20"
            ),
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            episode = listOf(),
            created = "2017-11-04T18:48:46.250Z",
            url = "https://rickandmortyapi.com/api/character/1",
        )
    )

    val response = RickAndMortyResponse(
        info = PageInfo(
            count = 2,
            pages = 1,
            next = null,
            prev = null
        ),
        results = data
    )



}