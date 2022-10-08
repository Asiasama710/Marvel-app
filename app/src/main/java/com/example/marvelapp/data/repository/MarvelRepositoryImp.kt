package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.StateWrapper
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.data.response.comicsResponse.ComicsResponse
import com.example.marvelapp.data.response.seriesResponse.SeriesResponse
import com.example.marvelapp.data.service.MarvelApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MarvelRepositoryImp  @Inject constructor(
    private val marvelApiService : MarvelApiService,
    private val stateWrapper :StateWrapper
    ):MarvelRepository {


    override fun getCharacterList(): Single<CharacterResponse> =
         stateWrapper.wrapResponse( marvelApiService.getCharactersList())

    override fun getCharacterById(characterId:Int): Single<CharacterResponse> =
        stateWrapper.wrapResponse( marvelApiService.getCharacterById(characterId))

    override fun getComicsListByCharacterId(characterId: Int): Single<ComicsResponse> =
        stateWrapper.wrapResponse(marvelApiService.getComicsListByCharacterId(characterId))

    override fun getSeriesListByCharacterId(characterId: Int): Single<SeriesResponse> =
        stateWrapper.wrapResponse(marvelApiService.getSeriesListByCharacterId(characterId))




}