package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.model.Character
import com.example.marvelapp.data.model.Comics
import com.example.marvelapp.data.model.Series
import com.example.marvelapp.data.response.MarvelResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


interface MarvelRepository {
  //  fun getCharacter():Single<State<MarvelResponse>>
    fun getCharacterList():  Single<State<MarvelResponse>>
    fun getComicsCharacterList(characterId:Int):  Single<State<MarvelResponse>>
    fun getSeriesCharacterList(characterId:Int):  Single<State<MarvelResponse>>

}