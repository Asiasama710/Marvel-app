package com.example.marvelapp.ui.characterDetails


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.response.BaseResponse
import com.example.marvelapp.data.response.dto.CharacterDto
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.Event
import com.example.marvelapp.utilities.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsCharacterViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {


    private val _request = MutableLiveData<State<BaseResponse<CharacterDto>?>>()
    val request: LiveData<State<BaseResponse<CharacterDto>?>> get() = _request

    private val _characterInfo = MutableLiveData<CharacterDto>()
    val characterInfo: LiveData<CharacterDto> get() = _characterInfo

    private val _navigateToComicsList = MutableLiveData<Event<Int>>()
    val navigateToComicsList: LiveData<Event<Int>> = _navigateToComicsList

    private val _navigateToSeries = MutableLiveData<Event<Int>>()
    val navigateToSeries: LiveData<Event<Int>> = _navigateToSeries

    private val _navigateToStories = MutableLiveData<Event<Int>>()
    val navigateToStories: LiveData<Event<Int>> = _navigateToStories


    fun getCharacterId(characterId: Int) {
        viewModelScope.launch {
            repository.getCharacterDetails(characterId).collect { state ->
                _request.postValue(state)
                _characterInfo.postValue(state.toData()?.data?.results?.first())
            }
        }
    }


    fun onClickComics(characterId: Int) {
        Log.i("MALT","in viewModel comic id: $characterId")
        _navigateToComicsList.postEvent(characterId)
    }

    fun onClickSeries(characterId: Int) {
        _navigateToSeries.postEvent(characterId)
    }

    fun onClickStories(characterId: Int){
        Log.i("MALT","click")
        Log.i("MALT","in viewModel stoty id: $characterId")
        _navigateToStories.postEvent(characterId)
    }

}