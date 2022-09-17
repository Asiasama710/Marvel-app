package com.example.marvelapp.data.response.comics


import com.google.gson.annotations.SerializedName

data class Comic(
    @SerializedName("characters")
    val characters: Characters,
    @SerializedName("collectedIssues")
    val collectedIssues: List<Any>,
    @SerializedName("collections")
    val collections: List<Any>,
    @SerializedName("creators")
    val creators: Creators,
    @SerializedName("dates")
    val dates: List<Date>,
    @SerializedName("description")
    val description: String,
    @SerializedName("diamondCode")
    val diamondCode: String,
    @SerializedName("digitalId")
    val digitalId: Int,
    @SerializedName("ean")
    val ean: String,
    @SerializedName("format")
    val format: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("issn")
    val issn: String,
    @SerializedName("issueNumber")
    val issueNumber: Int,
    @SerializedName("prices")
    val prices: List<Price>,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("series")
    val series: Series,
    @SerializedName("textObjects")
    val textObjects: List<TextObject>,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("title")
    val title: String,
    @SerializedName("upc")
    val upc: String,
    @SerializedName("urls")
    val urls: List<Url>,
    @SerializedName("variantDescription")
    val variantDescription: String,
    @SerializedName("variants")
    val variants: List<Any>
)