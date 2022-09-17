package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import io.reactivex.rxjava3.core.Single


interface MarvelRepository {
    fun getCharacterList():  Single<State<CharacterResponse>>
    fun getCharacterById(characterId:Int): Single<State<CharacterResponse>>
//    fun getComicsCharacterList(characterId:Int):  Single<State<MarvelResponse>>
//    fun getSeriesCharacterList(characterId:Int):  Single<State<MarvelResponse>>

}