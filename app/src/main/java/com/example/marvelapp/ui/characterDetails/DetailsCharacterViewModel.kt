package com.example.marvelapp.ui.characterDetails


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.response.characterResponse.Character
import com.example.marvelapp.data.response.characterResponse.CharacterResponse
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.Event
import com.example.marvelapp.utilities.add
import com.example.marvelapp.utilities.observeOnMainThread
import com.example.marvelapp.utilities.postEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class DetailsCharacterViewModel @Inject constructor(
    private val repository : MarvelRepository
): BaseViewModel(){


    private val _request = MutableLiveData<CharacterResponse?>()
    val request: LiveData<CharacterResponse?> get() = _request

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
        }.add(compositeDisposable)
    }

    private fun onGetCharacterIdSuccess(state: CharacterResponse) {
            _request.postValue(state)
            _characterInfo.postValue(state.data.character.first())
        }



    fun onClickComics(character: Character) {
        _navigateToComicsList.postEvent(character.id)
    }

    fun onClickSeries(character: Character) {
         _navigateToSeriesList.postEvent(character.id)
    }
}