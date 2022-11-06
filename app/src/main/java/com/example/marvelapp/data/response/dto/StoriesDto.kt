package com.example.marvelapp.data.response.dto



import java.util.*
import com.example.marvelapp.data.response.Thumbnail
import com.google.gson.annotations.SerializedName

data class StoriesDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("modified")
    val modified: Date,

    )