package com.smparkworld.docfriends.data.repository

import com.smparkworld.docfriends.data.remote.UserRemoteDataSource
import com.smparkworld.docfriends.di.AppModule.DispatcherIO
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
    @DispatcherIO private val ioDispatcher: CoroutineDispatcher
) : UserRepository {

    override fun getHome(search: String?): HomePagingSource {
        return HomePagingSource(remoteDataSource, search)
    }
}