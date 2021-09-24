package com.smparkworld.docfriends.data.remote

import com.smparkworld.docfriends.data.remote.api.DocfriendsAPI
import com.smparkworld.docfriends.data.remote.api.HomeResponse
import com.smparkworld.docfriends.model.Result
import com.smparkworld.docfriends.model.Result.Success
import com.smparkworld.docfriends.model.Result.Error
import retrofit2.HttpException
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val docfriendsAPI: DocfriendsAPI
) : UserRemoteDataSource {

    override suspend fun getHome(search: String?): Result<HomeResponse> {
        return try {
            val response = docfriendsAPI.getHome()
            val body = response.body()
            if (body != null) {
                Success(body)
            } else {
                throw HttpException(response)
            }
        } catch (e: Exception) {
            Error(e)
        }
    }
}