package com.example.marvelapp.ui.comics


import androidx.lifecycle.*
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.response.BaseResponse
import com.example.marvelapp.data.response.dto.ComicDto
import com.example.marvelapp.ui.base.BaseInteractionListener
import com.example.marvelapp.ui.stories.StoriesFragmentArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val repository: MarvelRepository,
    saveStateHandle: SavedStateHandle,
) : ViewModel(), BaseInteractionListener {


    private val _request = MutableLiveData<State<BaseResponse<ComicDto>?>>()
    val request: LiveData<State<BaseResponse<ComicDto>?>> get() = _request

    private val args = StoriesFragmentArgs.fromSavedStateHandle(saveStateHandle)

    init {
        getComics(args.characterid)
    }

    private fun getComics(characterId: Int) {
        viewModelScope.launch {
            repository.getCharacterComics(characterId).collect { state ->
                _request.postValue(state)
            }
        }
    }

    fun tryLoadDataAgain() {
        getComics(args.characterid)
    }

}