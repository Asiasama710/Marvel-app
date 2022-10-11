package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.StateWrapper
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.data.response.comicsResponse.ComicsResponse
import com.example.marvelapp.data.response.seriesResponse.SeriesResponse
import com.example.marvelapp.data.service.MarvelApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val marvelApiService: MarvelApiService,
    private val stateWrapper: StateWrapper
) : MarvelRepository {

    override  fun getCharacterList(): Flow<State<CharacterResponse>> {
        return stateWrapper.wrapWithFlow { marvelApiService.getCharactersList() }
    }

    override  fun getCharacterById(characterId: Int): Flow<State<CharacterResponse>> {
        return stateWrapper.wrapWithFlow { marvelApiService.getCharacterById(characterId) }
    }

    override  fun getComicsListByCharacterId(characterId: Int): Flow<State<ComicsResponse>> {
        return stateWrapper.wrapWithFlow { marvelApiService.getComicsListByCharacterId(characterId) }
    }

    override  fun getSeriesListByCharacterId(characterId: Int): Flow<State<SeriesResponse>> {
        return stateWrapper.wrapWithFlow { marvelApiService.getSeriesListByCharacterId(characterId) }
    }


}