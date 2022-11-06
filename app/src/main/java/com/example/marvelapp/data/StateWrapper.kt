package com.example.marvelapp.data

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
                    emit(State.Success(response.body()))
                } else {
                    val error = response.message()
                    emit(State.Error("error happened: $error"))
                }
            } catch (e: Exception) {
                emit(State.Error("threw exception: ${e.message}"))
            }
        }
}