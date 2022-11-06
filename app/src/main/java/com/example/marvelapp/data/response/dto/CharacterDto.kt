package com.example.marvelapp.data.response.dto


import com.example.marvelapp.data.response.Info
import com.example.marvelapp.data.response.Thumbnail
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("comics")
    val comics: Info<ComicDto>,
    @SerializedName("series")
    val series: Info<SeriesDto>,
    @SerializedName("stories")
    val stories: Info<StoriesDto>

)