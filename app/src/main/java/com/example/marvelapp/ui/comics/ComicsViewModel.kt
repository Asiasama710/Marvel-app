package com.example.marvelapp.ui.comics


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.response.comicsResponse.ComicsResponse
import com.example.marvelapp.ui.base.BaseInteractionListener
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.add
import com.example.marvelapp.utilities.observeOnMainThread
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), BaseInteractionListener {


    private val _request = MutableLiveData<State<ComicsResponse?>>()
    val request: LiveData<State<ComicsResponse?>> get() = _request


    fun getCharacterId(characterId: Int) {
        viewModelScope.launch {
            repository.getComicsListByCharacterId(characterId).collect { state ->
                _request.postValue(state)
            }
        }
    }


}