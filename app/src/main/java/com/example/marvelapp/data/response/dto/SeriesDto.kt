package com.example.marvelapp.data.response.dto


import com.example.marvelapp.data.response.Info
import com.example.marvelapp.data.response.Thumbnail
import com.google.gson.annotations.SerializedName

data class SeriesDto(
    @SerializedName("characters")
    val characters: Info<CharacterDto>,
    @SerializedName("comics")
    val comics: Info<ComicDto>,
    @SerializedName("description")
    val description: String,
    @SerializedName("endYear")
    val endYear: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("startYear")
    val startYear: Int,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)