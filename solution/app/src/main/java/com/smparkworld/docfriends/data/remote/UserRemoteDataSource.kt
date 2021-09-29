package com.smparkworld.docfriends.data.remote

import com.smparkworld.docfriends.data.remote.api.HomeResponse
import com.smparkworld.docfriends.model.Result

interface UserRemoteDataSource {

    suspend fun getHome(search: String?): Result<HomeResponse>
}