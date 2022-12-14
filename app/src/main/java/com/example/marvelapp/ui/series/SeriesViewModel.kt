package com.example.marvelapp.ui.series


import androidx.lifecycle.*
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.response.BaseResponse
import com.example.marvelapp.data.response.dto.SeriesDto
import com.example.marvelapp.ui.base.BaseInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: MarvelRepository,
    saveStateHandle: SavedStateHandle,
) : ViewModel(), BaseInteractionListener {


    private val _request = MutableLiveData<State<BaseResponse<SeriesDto>?>>()
    val request: LiveData<State<BaseResponse<SeriesDto>?>> get() = _request

    private val args = SeriesFragmentArgs.fromSavedStateHandle(saveStateHandle)

    init {
        getSeries(args.characterid)
    }

   private fun getSeries(characterId: Int) {
        viewModelScope.launch {
            repository.getCharacterSeries(characterId).collect { state ->
                _request.postValue(state)
            }
        }
    }

    fun tryLoadDataAgain() {
        getSeries(args.characterid)
    }

}