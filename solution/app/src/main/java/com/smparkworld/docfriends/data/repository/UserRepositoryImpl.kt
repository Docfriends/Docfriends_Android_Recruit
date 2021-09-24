package com.smparkworld.docfriends.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.smparkworld.docfriends.data.remote.UserRemoteDataSource
import com.smparkworld.docfriends.di.AppModule.DispatcherIO
import com.smparkworld.docfriends.model.HomeUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
    @DispatcherIO private val ioDispatcher: CoroutineDispatcher
) : UserRepository {

    override fun getHome(search: String?): Flow<PagingData<HomeUiModel>> {
        return Pager(PagingConfig(pageSize = 10)) {
            HomePagingSource(remoteDataSource, search)
        }.flow
    }
}