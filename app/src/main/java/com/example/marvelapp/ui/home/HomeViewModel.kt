package com.example.marvelapp.ui.home


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.data.repository.MarvelRepositoryImp
import com.example.marvelapp.data.service.WebRequest
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.observeOnMainThread
import com.example.marvelapp.data.response.characterResponse.Character
import com.example.marvelapp.utilities.Event
import com.example.marvelapp.utilities.add
import com.example.marvelapp.utilities.postEvent


class HomeViewModel: BaseViewModel(),CharacterInteractionListener {
    val repository = MarvelRepositoryImp(WebRequest().apiService)

    private val _request = MutableLiveData<State<CharacterResponse?>>(State.Loading)
    val request: LiveData<State<CharacterResponse?>> get() = _request

    private val _listOfCharacter = MutableLiveData<List<Character>>()
    val listOfCharacter: LiveData<List<Character>> get() = _listOfCharacter

    private val _characterInfo = MutableLiveData<Character>()
    val characterInfo: LiveData<Character> get() = _characterInfo

    private val _navigateToDetails = MutableLiveData<Event<Int?>>()
    val navigateToDetails: LiveData<Event<Int?>> = _navigateToDetails

    init {
      setAllCharacter()
        Log.v("state1",listOfCharacter.value.toString())
    }



    private fun onGetCharacterSuccess(state: State<CharacterResponse>) {
        if (state is State.Success) {
            _request.postValue(state)
       _listOfCharacter.postValue(state.toData()?.data?.character)
            Log.v("state2",listOfCharacter.value.toString())
        }
         else {
            _request.postValue(state)
        }
    }

    private fun onGetCharacterError(throwable: Throwable) {
        _request.postValue(State.Error(requireNotNull(throwable.message)))
    }

    private fun setAllCharacter() {
        repository.getCharacterList().run {
             observeOnMainThread()
             subscribe(::onGetCharacterSuccess, ::onGetCharacterError)
        }.add(compositeDisposable)

    }



    override fun onClickCharacter(character: Character) {
        Log.v("click",character.id.toString())
        _navigateToDetails.postEvent(character.id)
        Log.v("click", _navigateToDetails.value.toString())
    }

}







