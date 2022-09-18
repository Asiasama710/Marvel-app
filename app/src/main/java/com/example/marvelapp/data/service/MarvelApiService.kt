package com.example.marvelapp.data.service



import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.data.response.comicsResponse.ComicsResponse
import com.example.marvelapp.data.response.seriesResponse.SeriesResponse
import com.example.marvelapp.utilities.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {




    @GET("characters")
    fun getCharactersList(
        @Query("ts") ts:String = Constants.timestamp,
        @Query("apikey") apikey:String = Constants.API_KEY,
        @Query("hash") hash:String = Constants.HASH
    ): Single<Response<CharacterResponse>>

    @GET("characters/{characterId}")
    fun getCharacterById(
        @Path("characterId") characterId: Int,
        @Query("ts") ts:String = Constants.timestamp,
        @Query("apikey") apikey:String = Constants.API_KEY,
        @Query("hash") hash:String = Constants.HASH
    ): Single<Response<CharacterResponse>>

    @GET("characters/{characterId}/comics")
    fun getComicsListByCharacterId(
        @Path("characterId") characterId: Int,
        @Query("apikey") apikey:String = Constants.API_KEY,
        @Query("ts") ts:String = Constants.timestamp,
        @Query("hash") hash:String = Constants.HASH
    ): Single<Response<ComicsResponse>>

    @GET("characters/{characterId}/series")
    fun getSeriesListByCharacterId(
        @Path("characterId") characterId: Int,
        @Query("apikey") apikey:String = Constants.API_KEY,
        @Query("ts") ts:String = Constants.timestamp,
        @Query("hash") hash:String = Constants.HASH
    ): Single<Response<SeriesResponse>>

}

















