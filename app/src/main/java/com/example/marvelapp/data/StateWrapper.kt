package com.example.marvelapp.data

import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class StateWrapper {
    fun <T> wrapResponse(response: Single<Response<T>>): Single<T> {
        return response.map {
            (if (it.isSuccessful) {
                it.body()
            } else {
                it.message()
            }) as T
        }
    }
}