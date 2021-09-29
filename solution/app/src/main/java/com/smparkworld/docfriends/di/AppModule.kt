package com.smparkworld.docfriends.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DispatcherIO

    @JvmStatic
    @Singleton
    @Provides
    @DispatcherIO
    fun provideDispatcherIO() = Dispatchers.IO
}