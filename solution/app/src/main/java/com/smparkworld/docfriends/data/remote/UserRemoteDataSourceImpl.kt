package com.smparkworld.docfriends.data.remote

import com.smparkworld.docfriends.data.remote.api.DocfriendsAPI
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val docfriendsAPI: DocfriendsAPI
) : UserRemoteDataSource {


}