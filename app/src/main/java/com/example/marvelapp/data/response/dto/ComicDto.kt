package com.example.marvelapp.data.response.dto


import com.example.marvelapp.data.response.Image
import com.example.marvelapp.data.response.Price
import com.example.marvelapp.data.response.Thumbnail
import com.google.gson.annotations.SerializedName

data class ComicDto(
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
    @SerializedName("images")
    val images: List<Image>




    )