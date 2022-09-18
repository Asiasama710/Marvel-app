package com.example.marvelapp.data.response.seriesResponse


import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("characters")
    val characters: CharactersData,
    @SerializedName("comics")
    val comics: ComicsData,
    @SerializedName("description")
    val description: Any,
    @SerializedName("endYear")
    val endYear: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("next")
    val next: Any,
    @SerializedName("previous")
    val previous: Any,
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