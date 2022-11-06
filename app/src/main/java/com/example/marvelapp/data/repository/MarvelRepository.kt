package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.response.BaseResponse
import com.example.marvelapp.data.response.dto.CharacterDto
import com.example.marvelapp.data.response.dto.ComicDto
import com.example.marvelapp.data.response.dto.SeriesDto
import com.example.marvelapp.data.response.dto.StoriesDto
import kotlinx.coroutines.flow.Flow


interface MarvelRepository {
     fun getCharacters(): Flow<State<BaseResponse<CharacterDto>>>
     fun getCharacterDetails(characterId: Int):  Flow<State<BaseResponse<CharacterDto>>>
     fun getCharacterComics(characterId: Int): Flow<State<BaseResponse<ComicDto>>>
     fun getCharacterSeries(characterId: Int): Flow<State<BaseResponse<SeriesDto>>>
     fun getCharacterStories(characterId: Int): Flow<State<BaseResponse<StoriesDto>>>

}