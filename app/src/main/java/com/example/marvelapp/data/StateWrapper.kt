package com.example.marvelapp.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class StateWrapper {
    fun <T> wrapWithFlow(requestFunction: suspend () -> Response<T>): Flow<State<T>> =
        flow {
            emit(State.Loading)
            try {
                val response = requestFunction()

                if (response.isSuccessful) {
                    Log.i("sssss",response.body().toString())
                    emit(State.Success(response.body()))
                } else {
                    val error = response.message()
                    Log.i("ssssssss",response.body().toString())
                    emit(State.Error("error happened: $error"))
                }
            } catch (e: Exception) {
                emit(State.Error("threw exception: ${e.message}"))
            }
        }
}