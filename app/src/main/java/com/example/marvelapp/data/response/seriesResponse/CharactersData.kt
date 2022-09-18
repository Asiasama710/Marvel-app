package com.example.marvelapp.data.response.seriesResponse


import com.example.marvelapp.data.response.characterResponse.Character
import com.google.gson.annotations.SerializedName

data class CharactersData(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<Character>,
    @SerializedName("returned")
    val returned: Int
)