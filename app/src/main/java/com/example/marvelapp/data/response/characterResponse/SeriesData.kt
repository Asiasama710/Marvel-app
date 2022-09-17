package com.example.marvelapp.data.response.characterResponse


import com.google.gson.annotations.SerializedName

data class SeriesData(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<ItemXXX>,
    @SerializedName("returned")
    val returned: Int
)