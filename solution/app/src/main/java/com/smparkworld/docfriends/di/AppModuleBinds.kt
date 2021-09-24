package com.smparkworld.docfriends.di

import androidx.lifecycle.ViewModelProvider
import com.smparkworld.docfriends.data.remote.UserRemoteDataSource
import com.smparkworld.docfriends.data.remote.UserRemoteDataSourceImpl
import com.smparkworld.docfriends.data.repository.UserRepository
import com.smparkworld.docfriends.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppModuleBinds {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    abstract fun bindUserRemoteDataSource(userRemoteDataSourceImpl: UserRemoteDataSourceImpl): UserRemoteDataSource

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}