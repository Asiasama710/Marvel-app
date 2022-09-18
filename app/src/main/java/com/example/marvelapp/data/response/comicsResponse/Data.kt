package com.example.marvelapp.data.response.comicsResponse


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val Comics: List<Comic>,
    @SerializedName("total")
    val total: Int
)