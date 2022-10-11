package com.example.marvelapp.ui.home


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.observeOnMainThread
import com.example.marvelapp.data.response.characterResponse.Character
import com.example.marvelapp.utilities.Event
import com.example.marvelapp.utilities.add
import com.example.marvelapp.utilities.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), CharacterInteractionListener {


    private val _request = MutableLiveData<State<CharacterResponse?>>()
    val request: LiveData<State<CharacterResponse?>> get() = _request


    private val _navigateToDetails = MutableLiveData<Event<Int?>>()
    val navigateToDetails: LiveData<Event<Int?>> = _navigateToDetails

    init {
        getAllCharacter()
    }

    private fun getAllCharacter() {
        viewModelScope.launch {
            repository.getCharacterList().collectLatest { state ->
                _request.postValue(state)
                Log.i("nbbbb", state.toData().toString())
                Log.i("nbbbb", _request.value.toString())
            }
        }
    }

    override fun onClickCharacter(character: Character) {
        _navigateToDetails.postEvent(character.id)
    }

}







