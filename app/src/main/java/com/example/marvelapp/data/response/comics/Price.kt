package com.example.marvelapp.data.response.comics


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("price")
    val price: Double,
    @SerializedName("type")
    val type: String
)