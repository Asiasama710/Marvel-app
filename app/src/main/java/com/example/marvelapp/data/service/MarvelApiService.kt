package com.example.marvelapp.data.service


import com.example.marvelapp.data.response.BaseResponse
import com.example.marvelapp.data.response.dto.CharacterDto
import com.example.marvelapp.data.response.dto.ComicDto
import com.example.marvelapp.data.response.dto.SeriesDto
import com.example.marvelapp.data.response.dto.StoriesDto
import com.example.marvelapp.utilities.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {

    @GET("characters")
    suspend fun getCharactersList(
    ): Response<BaseResponse<CharacterDto>>

    @GET("characters/{characterId}")
    suspend fun getCharacterDetails(
        @Path("characterId") characterId: Int
    ): Response<BaseResponse<CharacterDto>>

    @GET("characters/{characterId}/comics")
    suspend fun getComicsListByCharacterId(
        @Path("characterId") characterId: Int
    ): Response<BaseResponse<ComicDto>>

    @GET("characters/{characterId}/series")
    suspend fun getSeriesListByCharacterId(
        @Path("characterId") characterId: Int
    ): Response<BaseResponse<SeriesDto>>

    @GET("characters/{characterId}/stories")
    suspend fun getStoriesByCharacterId(
        @Path("characterId") characterId: Int
    ): Response<BaseResponse<StoriesDto>>

}

















