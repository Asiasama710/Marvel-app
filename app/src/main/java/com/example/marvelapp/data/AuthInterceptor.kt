package com.example.marvelapp.data

import com.example.marvelapp.utilities.Constants.API_KEY
import com.example.marvelapp.utilities.Constants.API_KEY_QUERY
import com.example.marvelapp.utilities.Constants.HASH
import com.example.marvelapp.utilities.Constants.HASH_KEY_QUERY
import com.example.marvelapp.utilities.Constants.TIME_STAMP
import com.example.marvelapp.utilities.Constants.TIME_STAMP_QUERY
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter(API_KEY_QUERY, API_KEY)
            .addQueryParameter(TIME_STAMP_QUERY, TIME_STAMP)
            .addQueryParameter(HASH_KEY_QUERY, HASH)
            .build()

        return chain.proceed(chain.request().newBuilder().url(original).build())
    }
}