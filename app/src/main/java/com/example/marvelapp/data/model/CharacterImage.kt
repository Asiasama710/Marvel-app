package com.example.marvelapp.data.model


import com.google.gson.annotations.SerializedName

data class CharacterImage(
    @SerializedName("extension")
    val extension: String,
    @SerializedName("path")
    val path: String
)