package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.data.response.comicsResponse.ComicsResponse
import com.example.marvelapp.data.response.seriesResponse.SeriesResponse
import com.example.marvelapp.data.service.MarvelApiService
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class MarvelRepositoryImp(private val marvelApiService : MarvelApiService ):MarvelRepository {

    override fun getCharacterList(): Single<State<CharacterResponse>> =
        wrapResponse( marvelApiService.getCharactersList())

    override fun getCharacterById(characterId:Int): Single<State<CharacterResponse>> =
        wrapResponse( marvelApiService.getCharacterById(characterId))

    override fun getComicsListByCharacterId(characterId: Int): Single<State<ComicsResponse>> =
       wrapResponse(marvelApiService.getComicsListByCharacterId(characterId))

    override fun getSeriesListByCharacterId(characterId: Int): Single<State<SeriesResponse>> =
        wrapResponse(marvelApiService.getSeriesListByCharacterId(characterId))



        private fun <T> wrapResponse(response: Single<Response<T>>): Single<State<T>> {
        return response.map {
            if (it.isSuccessful) {
                State.Success(it.body())
            } else {
                State.Error(it.message())
            }
        }
    }
}