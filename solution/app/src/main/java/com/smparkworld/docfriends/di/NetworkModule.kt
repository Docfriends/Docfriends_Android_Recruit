package com.smparkworld.docfriends.di

import com.smparkworld.docfriends.BuildConfig
import com.smparkworld.docfriends.data.remote.api.DocfriendsAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
            Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Provides
    @Singleton
    fun provideDocfriendsAPI(retrofit: Retrofit): DocfriendsAPI =
            retrofit.create(DocfriendsAPI::class.java)
}