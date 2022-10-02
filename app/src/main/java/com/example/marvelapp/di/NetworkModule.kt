package com.example.marvelapp.di


import com.example.marvelapp.data.service.MarvelApiService
import com.example.marvelapp.utilities.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  //  okHttpClient: OkHttpClient,
    @Singleton
    @Provides
    fun provideMoviesService(gsonConverterFactory: GsonConverterFactory):MarvelApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
          //  .client(okHttpClient)
            .build()
        return  retrofit.create(MarvelApiService::class.java)
    }

//    @Singleton
//    @Provides
//    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
//        return OkHttpClient
//            .Builder()
//            .addInterceptor(loggingInterceptor)
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
//            setLevel(HttpLoggingInterceptor.Level.BODY)
//        }
//
    @Singleton
    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()


}