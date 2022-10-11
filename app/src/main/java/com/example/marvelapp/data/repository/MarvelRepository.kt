package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.data.response.comicsResponse.ComicsResponse
import com.example.marvelapp.data.response.seriesResponse.SeriesResponse
import kotlinx.coroutines.flow.Flow


interface MarvelRepository {
     fun getCharacterList(): Flow<State<CharacterResponse>>
     fun getCharacterById(characterId: Int): Flow<State<CharacterResponse>>
     fun getComicsListByCharacterId(characterId: Int): Flow<State<ComicsResponse>>
     fun getSeriesListByCharacterId(characterId: Int): Flow<State<SeriesResponse>>

}