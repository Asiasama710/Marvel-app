package com.example.marvelapp.data.service



import com.example.marvelapp.data.response.characterResponse.CharacterResponse
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

//    @GET("characters/{characterId}/comics")
//    fun getComicsCharacterList(
//        @Path("characterId") characterId: Int,
//        @Query("apikey") apikey:String = Constants.API_KEY,
//        @Query("ts") ts:String = Constants.timestamp,
//        @Query("hash") hash:String = Constants.HASH
//    ): Single<Response<MarvelResponse>>

//    @GET("characters/{characterId}/series")
//    fun getSeriesCharacterList(
//        @Path("characterId") characterId: Int,
//        @Query("apikey") apikey:String = Constants.API_KEY,
//        @Query("ts") ts:String = Constants.timestamp,
//        @Query("hash") hash:String = Constants.HASH
//    ): Single<Response<MarvelResponse>>

}

















