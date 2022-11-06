package com.example.marvelapp.ui.stories


import androidx.lifecycle.*
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.response.BaseResponse
import com.example.marvelapp.data.response.dto.StoriesDto
import com.example.marvelapp.ui.base.BaseInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoriesViewModel @Inject constructor(
    private val repository: MarvelRepository,
    saveStateHandle: SavedStateHandle,
) : ViewModel(), BaseInteractionListener {


    private val _request = MutableLiveData<State<BaseResponse<StoriesDto>?>>()
    val request: LiveData<State<BaseResponse<StoriesDto>?>> get() = _request

    private val args = StoriesFragmentArgs.fromSavedStateHandle(saveStateHandle)

    init {
        getStories(args.characterid)
    }

    private fun getStories(characterId: Int) {
        viewModelScope.launch {
            repository.getCharacterStories(characterId).collect { state ->
                _request.postValue(state)
            }
        }
    }

    fun tryLoadDataAgain() {
        getStories(args.characterid)
    }
}