package com.example.marvelapp.data.response.seriesResponse


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val series: List<Series>,
    @SerializedName("total")
    val total: Int
)