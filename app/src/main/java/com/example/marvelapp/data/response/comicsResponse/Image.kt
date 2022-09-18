package com.example.marvelapp.data.response.comicsResponse


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("extension")
    val extension: String,
    @SerializedName("path")
    val path: String
)