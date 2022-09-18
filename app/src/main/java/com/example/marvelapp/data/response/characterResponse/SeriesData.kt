package com.example.marvelapp.data.response.characterResponse


import com.example.marvelapp.data.response.seriesResponse.Series
import com.google.gson.annotations.SerializedName

data class SeriesData(
    @SerializedName("available")
    val available: String,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<Series>,
    @SerializedName("returned")
    val returned: Int
)