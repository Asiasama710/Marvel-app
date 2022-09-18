package com.example.marvelapp.ui.characterDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepositoryImp
import com.example.marvelapp.data.response.characterResponse.Character
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.data.service.WebRequest
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.Event
import com.example.marvelapp.utilities.observeOnMainThread
import com.example.marvelapp.utilities.postEvent

class DetailsCharacterViewModel : BaseViewModel(){

    val repository = MarvelRepositoryImp(WebRequest().apiService)

    private val _request = MutableLiveData<State<CharacterResponse?>>(State.Loading)
    val request: LiveData<State<CharacterResponse?>> get() = _request

    private val _characterInfo = MutableLiveData<Character>()
    val characterInfo: LiveData<Character> get() = _characterInfo

    private val _navigateToComicsList = MutableLiveData<Event<Int?>>()
    val navigateToComicsList: LiveData<Event<Int?>> = _navigateToComicsList

    private val _navigateToSeriesList = MutableLiveData<Event<Int?>>()
    val navigateToSeriesList: LiveData<Event<Int?>> = _navigateToSeriesList


    fun getCharacterId(characterId: Int){
        repository.getCharacterById(characterId).run {
            observeOnMainThread()
            subscribe(::onGetCharacterIdSuccess )
        }
    }

    private fun onGetCharacterIdSuccess(state: State<CharacterResponse>) {
        if (state is State.Success) {
            _request.postValue(state)
            _characterInfo.postValue(state.toData()?.data?.character?.first())
            Log.e("ASIATESTtt", _characterInfo.postValue(state.toData()?.data?.character?.first()).toString())
        }
        else {
            _request.postValue(state)
        }
    }

    private fun onGetCharacterIdError(throwable: Throwable) {
        _request.postValue(State.Error(requireNotNull(throwable.message)))
    }


    fun onClickComics(character: Character) {
        Log.v("clicking", _navigateToComicsList.value.toString())
        _navigateToComicsList.postEvent(character.id)
        Log.v("clicking", _navigateToComicsList.value.toString())

    }

     fun onClickSeries(character: Character) {
         _navigateToSeriesList.postEvent(character.id)
    }
}