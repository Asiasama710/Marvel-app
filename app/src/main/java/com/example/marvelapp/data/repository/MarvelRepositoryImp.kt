package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.data.service.MarvelApiService
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class MarvelRepositoryImp(private val marvelApiService : MarvelApiService ):MarvelRepository {

    override fun getCharacterList(): Single<State<CharacterResponse>> =
        wrapResponse( marvelApiService.getCharactersList())
    override fun getCharacterById(characterId:Int): Single<State<CharacterResponse>> =
        wrapResponse( marvelApiService.getCharacterById(characterId))

//    override fun getComicsCharacterList(characterId: Int): Single<State<MarvelResponse>> =
//        wrapResponse(marvelApiService.getComicsCharacterList(characterId))
//
//    override fun getSeriesCharacterList(characterId: Int): Single<State<MarvelResponse>> =
//        wrapResponse(marvelApiService.getSeriesCharacterList(characterId))



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