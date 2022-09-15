package com.example.marvelapp.data.service



import com.example.marvelapp.data.model.Character
import com.example.marvelapp.data.response.MarvelResponse
import com.example.marvelapp.utilities.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {


    @GET("v1/public/characters")
    fun getCharacters(
        @Query("limit") limit: Int = Constants.limit,
        @Query("apikey") apikey:String = Constants.API_KEY,
        @Query("ts") ts:String = Constants.timestamp,
        @Query("hash") hash:String = Constants.HASH
    ): Single<MarvelResponse>


    @GET("v1/public/characters")
    fun getCharactersList(
        @Query("limit") limit: Int = Constants.limit,
        @Query("apikey") apikey:String = Constants.API_KEY,
        @Query("ts") ts:String = Constants.timestamp,
        @Query("hash") hash:String = Constants.HASH
    ): Single<Response<MarvelResponse>>

    @GET("/v1/public/characters/{characterId}/comics")
    fun getComicsCharacterList(
        @Path("characterId") characterId: Int,
        @Query("apikey") apikey:String = Constants.API_KEY,
        @Query("ts") ts:String = Constants.timestamp,
        @Query("hash") hash:String = Constants.HASH
    ): Single<Response<MarvelResponse>>

    @GET("/v1/public/characters/{characterId}/series")
    fun getSeriesCharacterList(
        @Path("characterId") characterId: Int,
        @Query("apikey") apikey:String = Constants.API_KEY,
        @Query("ts") ts:String = Constants.timestamp,
        @Query("hash") hash:String = Constants.HASH
    ): Single<Response<MarvelResponse>>

}

















