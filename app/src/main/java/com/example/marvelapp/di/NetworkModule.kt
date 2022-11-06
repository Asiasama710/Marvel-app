package com.example.marvelapp.di


import com.example.marvelapp.data.AuthInterceptor
import com.example.marvelapp.data.service.MarvelApiService
import com.example.marvelapp.utilities.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMoviesService(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): MarvelApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
        return retrofit.create(MarvelApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val builder = OkHttpClient()
            .newBuilder()
            .addInterceptor(authInterceptor)
            .connectTimeout(1, TimeUnit.MINUTES)
        return builder.build()
    }


    @Singleton
    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()


}