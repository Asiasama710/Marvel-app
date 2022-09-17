package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.response.CharacterResponse
import io.reactivex.rxjava3.core.Single


interface MarvelRepository {
  // fun getCharacter():Single<List<Character>>
    fun getCharacterList():  Single<State<CharacterResponse>>
//    fun getComicsCharacterList(characterId:Int):  Single<State<MarvelResponse>>
//    fun getSeriesCharacterList(characterId:Int):  Single<State<MarvelResponse>>

}