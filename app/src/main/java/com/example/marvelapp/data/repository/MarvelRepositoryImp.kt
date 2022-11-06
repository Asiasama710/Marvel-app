package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.StateWrapper
import com.example.marvelapp.data.response.BaseResponse
import com.example.marvelapp.data.response.dto.CharacterDto
import com.example.marvelapp.data.response.dto.ComicDto
import com.example.marvelapp.data.response.dto.SeriesDto
import com.example.marvelapp.data.response.dto.StoriesDto
import com.example.marvelapp.data.service.MarvelApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val marvelApiService: MarvelApiService,
    private val stateWrapper: StateWrapper
) : MarvelRepository {

    override  fun getCharacters(): Flow<State<BaseResponse<CharacterDto>>> {
        return stateWrapper.wrapWithFlow { marvelApiService.getCharactersList() }
    }

    override fun getCharacterDetails(characterId: Int): Flow<State<BaseResponse<CharacterDto>>> {
        return stateWrapper.wrapWithFlow { marvelApiService.getCharacterDetails(characterId) }
    }

    override  fun getCharacterComics(characterId: Int): Flow<State<BaseResponse<ComicDto>>> {
        return stateWrapper.wrapWithFlow { marvelApiService.getComicsListByCharacterId(characterId) }
    }

    override  fun getCharacterSeries(characterId: Int):  Flow<State<BaseResponse<SeriesDto>>> {
        return stateWrapper.wrapWithFlow { marvelApiService.getSeriesListByCharacterId(characterId) }
    }

    override fun getCharacterStories(characterId: Int): Flow<State<BaseResponse<StoriesDto>>> {
        return stateWrapper.wrapWithFlow { marvelApiService.getStoriesByCharacterId(characterId) }
    }


}