package com.example.marvelapp.data.response


import com.google.gson.annotations.SerializedName

data class Info<T>(
    @SerializedName("available")
    val available: String,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<T>,
    @SerializedName("returned")
    val returned: Int
)