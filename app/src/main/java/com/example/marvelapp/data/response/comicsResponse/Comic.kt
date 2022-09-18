package com.example.marvelapp.data.response.comicsResponse


import com.google.gson.annotations.SerializedName

data class Comic(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("description")
    val description: String,
    @SerializedName("prices")
    val prices: List<Price>,
    @SerializedName("characters")
    val characters: CharacterData,
    @SerializedName("images")
    val images: List<Image>




    )