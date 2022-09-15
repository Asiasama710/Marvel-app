package com.example.marvelapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.model.Character
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.repository.MarvelRepositoryImp
import com.example.marvelapp.data.response.MarvelResponse
import com.example.marvelapp.data.service.WebRequest
import com.example.marvelapp.ui.base.BaseInteractionListener
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.add
import com.example.marvelapp.utilities.observeOnMainThread


class HomeViewModel: BaseViewModel() , BaseInteractionListener{
    //val repository = MarvelRepositoryImp(WebRequest().apiService)
    //val repository = MarvelRepository.getCharacter()
    //  val character = repository.getCharacterList()

    private val _request = MutableLiveData<State<MarvelResponse>>(State.Loading)
    val request: LiveData<State<MarvelResponse>> get() = _request
    private val _currentCharacter = MutableLiveData<MarvelResponse>()
    val currentCharacter: LiveData<MarvelResponse> = _currentCharacter

    init {
     //  setCurrentCharacter()
    }

    override fun onClickCharacter(character: Character) {

    }

//    private fun getAllCharacter() {
//        repository.getCharacterList().run {
//            observeOnMainThread()
//            subscribe(::onGetQuestionsSuccess, ::onGetQuestionsError)
//        }.add(compositeDisposable)
//    }
//    private fun onGetCharacterSuccess(character: Character) {
//      // _currentCharacter.postValue( character)
//    }
//
//    private fun onGetCharacterError(throwable: Throwable) {
//
//    }
//
//    private fun setCurrentCharacter() {
//        repository.getCharacter().run {
//             observeOnMainThread()
//              subscribe(::onGetCharacterSuccess, ::onGetCharacterError)
//        }.add(compositeDisposable)
//
//    }

}





