package com.example.marvelapp.ui.series


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepositoryImp
import com.example.marvelapp.data.response.seriesResponse.SeriesResponse
import com.example.marvelapp.data.service.WebRequest
import com.example.marvelapp.ui.base.BaseInteractionListener
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.observeOnMainThread

class SeriesViewModel: BaseViewModel(),BaseInteractionListener{
    private val repository = MarvelRepositoryImp(WebRequest().apiService)

    private val _request = MutableLiveData<State<SeriesResponse?>>(State.Loading)
    val request: LiveData<State<SeriesResponse?>> get() = _request


    fun getCharacterId(characterId: Int){
        repository.getSeriesListByCharacterId(characterId).run {
            observeOnMainThread()
            subscribe(::onGetSeriesListSuccess , ::onGetSeriesListError)
        }
    }

    private fun onGetSeriesListSuccess(state: State<SeriesResponse>) {
        if (state is State.Success) {
            _request.postValue(state)
        }
    }

    private fun onGetSeriesListError(throwable: Throwable) {
        _request.postValue(State.Error(requireNotNull(throwable.message)))

    }
}