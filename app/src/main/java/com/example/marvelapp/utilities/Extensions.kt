package com.example.marvelapp.utilities


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

fun <T : Any> Single<T>.observeOnMainThread(): Single<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}


fun Disposable.add(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun <T> MutableLiveData<Event<T>>.postEvent(content: T) {
    postValue(Event(content))
}

inline fun <T> LiveData<Event<T>>.observeEvent(owner: LifecycleOwner, crossinline onEventUnhandledContent: (T) -> Unit) {
    observe(owner) { it?.getContentIfNotHandled()?.let(onEventUnhandledContent) }
}

