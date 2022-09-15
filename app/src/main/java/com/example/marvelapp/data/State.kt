package com.example.marvelapp.data

import com.example.marvelapp.utilities.Constants

sealed class State<out T> {

    data class Success<T>(val data: T?) : State<T>()
    data class Error(val message: String) : State<Nothing>()
    object Loading : State<Nothing>()

    fun toData(): T? = if (this is Success) data else null
    fun toError(): String = if (this is Error) message else Constants.DATA_IS_NULL_ERROR_MESSAGE

}
