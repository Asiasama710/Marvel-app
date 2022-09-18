package com.example.marvelapp.ui.comics


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepositoryImp
import com.example.marvelapp.data.response.comicsResponse.ComicsResponse
import com.example.marvelapp.data.service.WebRequest
import com.example.marvelapp.ui.base.BaseInteractionListener
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.add
import com.example.marvelapp.utilities.observeOnMainThread

class ComicsViewModel: BaseViewModel() ,BaseInteractionListener {

    private val repository = MarvelRepositoryImp(WebRequest().apiService)

    private val _request = MutableLiveData<State<ComicsResponse?>>(State.Loading)
    val request: LiveData<State<ComicsResponse?>> get() = _request



    fun getCharacterId(characterId: Int){
        repository.getComicsListByCharacterId(characterId).run {
            observeOnMainThread()
            subscribe(::onGetComicsListSuccess , ::onGetComicsListError)
        }.add(compositeDisposable)
    }

    private fun onGetComicsListSuccess(state: State<ComicsResponse>) {
        if (state is State.Success)
            _request.postValue(state)
    }

    private fun onGetComicsListError(throwable: Throwable) {
        _request.postValue(State.Error(requireNotNull(throwable.message)))
    }


}