package com.example.marvelapp.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.response.BaseResponse
import com.example.marvelapp.data.response.dto.CharacterDto
import com.example.marvelapp.utilities.Event
import com.example.marvelapp.utilities.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel(), CharacterInteractionListener {


    private val _request = MutableLiveData<State<BaseResponse<CharacterDto>>>()
    val request: LiveData<State<BaseResponse<CharacterDto>>> get() = _request


    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    val navigateToDetails: LiveData<Event<Int>> = _navigateToDetails

    init {
        getAllCharacter()
    }


    private fun getAllCharacter() {
        viewModelScope.launch {
            repository.getCharacters().collectLatest { state ->
                _request.postValue(state)
            }
        }
    }

    fun tryLoadDataAgain() {
        getAllCharacter()
    }

    override fun onClickCharacter(characterId: Int) {
        _navigateToDetails.postEvent(characterId)
    }

}







