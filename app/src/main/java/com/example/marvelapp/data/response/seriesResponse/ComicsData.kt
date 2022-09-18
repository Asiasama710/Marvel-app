package com.example.marvelapp.data.response.seriesResponse


import com.example.marvelapp.data.response.comicsResponse.Comic
import com.google.gson.annotations.SerializedName

data class ComicsData(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<Comic>,
    @SerializedName("returned")
    val returned: Int
)