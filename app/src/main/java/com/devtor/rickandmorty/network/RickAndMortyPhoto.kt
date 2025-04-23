package com.devtor.rickandmorty.network

import com.devtor.rickandmorty.network.dto.Location
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("created") val created: String,
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("status") val status: String,
    @SerialName("species") val species: String,
    @SerialName("type") val type: String,
    @SerialName("gender") val gender: String,
    @SerialName("origin") val origin: Origin,
    @SerialName("image") val imageUrl: String,
    @SerialName("location") val location: Origin,
    @SerialName("episode") val episode: List<String>,
    @SerialName("url") val url: String
)


@Serializable
data class Origin(
    val name: String,
    val url: String
)
@Serializable
data class RickAndMortyResponse(
    @SerialName("info")
    val info: PageInfo?,
    @SerialName("results")
    val results: List<CharacterResponse>
)

@Serializable
data class PageInfo(
    @SerialName("count") val count: Int,
    @SerialName("pages") val pages: Int,
    @SerialName("next") val next: String?,
    @SerialName("prev") val prev: String?
)
