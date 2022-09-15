package com.example.marvelapp.data.response


import com.example.marvelapp.data.model.Character
import com.google.gson.annotations.SerializedName

data class MarvelResponse(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("results")
    val characters: List<Character?>?
)