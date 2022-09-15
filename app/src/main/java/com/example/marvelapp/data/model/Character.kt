package com.example.marvelapp.data.model


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("comics")
    val comics: Comics,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("series")
    val series: Series,
    @SerializedName("thumbnail")
    val imageUrl: CharacterImage
)