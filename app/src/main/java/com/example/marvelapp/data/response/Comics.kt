package com.example.marvelapp.data.response


import com.example.marvelapp.data.response.comics.Comic
import com.google.gson.annotations.SerializedName

data class Comics(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<Comic>,
    @SerializedName("returned")
    val returned: Int
)