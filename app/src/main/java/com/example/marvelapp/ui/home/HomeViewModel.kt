package com.example.marvelapp.ui.home



import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : MarvelRepository
): BaseViewModel(),CharacterInteractionListener {


    private val _request = MutableLiveData<State<CharacterResponse?>>(State.Loading)
    val request: LiveData<State<CharacterResponse?>> get() = _request


    private val _navigateToDetails = MutableLiveData<Event<Int?>>()
    val navigateToDetails: LiveData<Event<Int?>> = _navigateToDetails

    init {
      getAllCharacter()
    }

    private fun getAllCharacter() {
        repository.getCharacterList().run {
            observeOnMainThread()
            subscribe(::onGetCharacterSuccess, ::onGetCharacterError)
        }.add(compositeDisposable)

    }

    private fun onGetCharacterSuccess(state: State<CharacterResponse>) {
        if (state is State.Success) {
            _request.postValue(state)
        }
    }

    private fun onGetCharacterError(throwable: Throwable) {
        _request.postValue(State.Error(requireNotNull(throwable.message)))
    }

    override fun onClickCharacter(character: Character) {
        Log.e("AsiaMMM", character.id.toString())
        Log.e("AsiaMMM", character.name.toString())
        _navigateToDetails.postEvent(character.id)

    }

}







