package com.example.marvelapp.data.response.seriesResponse


import com.google.gson.annotations.SerializedName

data class SeriesResponse(
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