package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.model.Character
import com.example.marvelapp.data.model.Comics
import com.example.marvelapp.data.model.Series
import com.example.marvelapp.data.response.MarvelResponse
import com.example.marvelapp.data.service.MarvelApiService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class MarvelRepositoryImp(private val marvelApiService : MarvelApiService ):MarvelRepository {

  //  override fun getCharacter() : Single<MarvelResponse> = marvelApiService.getCharacters()

    override fun getCharacterList(): Single<State<MarvelResponse>> =
        wrapResponse( marvelApiService.getCharactersList())


    override fun getComicsCharacterList(characterId: Int): Single<State<MarvelResponse>> =
        wrapResponse(marvelApiService.getComicsCharacterList(characterId))

    override fun getSeriesCharacterList(characterId: Int): Single<State<MarvelResponse>> =
        wrapResponse(marvelApiService.getSeriesCharacterList(characterId))



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