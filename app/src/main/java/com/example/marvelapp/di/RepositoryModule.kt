package com.example.marvelapp.di

import com.example.marvelapp.data.State
import com.example.marvelapp.data.StateWrapper
import com.example.marvelapp.data.repository.MarvelRepository
import com.example.marvelapp.data.repository.MarvelRepositoryImp
import com.example.marvelapp.data.service.MarvelApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(apiService: MarvelApiService, stateWrapper: StateWrapper): MarvelRepository {
        return MarvelRepositoryImp(apiService,stateWrapper)
    }

    @Singleton
    @Provides
    fun provideStateWrapper(): StateWrapper = StateWrapper()

}