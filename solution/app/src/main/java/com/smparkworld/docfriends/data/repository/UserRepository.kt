package com.smparkworld.docfriends.data.repository

import androidx.paging.PagingData
import com.smparkworld.docfriends.model.HomeUiModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getHome(): Flow<PagingData<HomeUiModel>>
}