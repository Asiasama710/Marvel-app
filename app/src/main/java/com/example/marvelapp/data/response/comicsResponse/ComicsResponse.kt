package com.example.marvelapp.data.response.comicsResponse


import com.google.gson.annotations.SerializedName

data class ComicsResponse(
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("attributionText")
    val attributionText: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)