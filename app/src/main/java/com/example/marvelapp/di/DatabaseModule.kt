package com.example.marvelapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
//
//    @Singleton
//    @Provides
//    fun provideDatabase(
//        @ApplicationContext context: Context
//    ): MarvelDatabase =
//        Room.databaseBuilder(
//            context,
//            MarvelDatabase::class.java,
//            MarvelDatabase.DATABASE_NAME
//        ).build()
//
//
//    @Singleton
//    @Provides
//    fun provideDao(database: MarvelDatabase): MarvelDao = database.marvelDao()


}