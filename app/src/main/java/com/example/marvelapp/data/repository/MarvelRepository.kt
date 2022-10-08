package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.data.response.comicsResponse.ComicsResponse
import com.example.marvelapp.data.response.seriesResponse.SeriesResponse
import io.reactivex.rxjava3.core.Single


interface MarvelRepository {
    fun getCharacterList():  Single<CharacterResponse>
    fun getCharacterById(characterId:Int): Single<CharacterResponse>
    fun getComicsListByCharacterId(characterId:Int):  Single<ComicsResponse>
    fun getSeriesListByCharacterId(characterId:Int):  Single<SeriesResponse>

}