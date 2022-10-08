package com.example.marvelapp.ui.series


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.response.seriesResponse.SeriesResponse
import com.example.marvelapp.ui.base.BaseInteractionListener
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.utilities.observeOnMainThread
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel@Inject constructor(
    private val repository : MarvelRepository
): BaseViewModel(),BaseInteractionListener{


    private val _request = MutableLiveData<SeriesResponse?>()
    val request: LiveData<SeriesResponse?> get() = _request


    fun getCharacterId(characterId: Int){
        repository.getSeriesListByCharacterId(characterId).run {
            observeOnMainThread()
            subscribe(::onGetSeriesListSuccess )
        }
    }

    private fun onGetSeriesListSuccess(state: SeriesResponse) {
            _request.postValue(state)
    }

}