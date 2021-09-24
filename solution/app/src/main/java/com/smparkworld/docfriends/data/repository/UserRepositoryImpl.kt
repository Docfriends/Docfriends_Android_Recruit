package com.smparkworld.docfriends.data.repository

import com.smparkworld.docfriends.data.remote.UserRemoteDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {



}