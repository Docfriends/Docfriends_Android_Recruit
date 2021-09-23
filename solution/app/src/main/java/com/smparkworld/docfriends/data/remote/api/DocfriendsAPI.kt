package com.smparkworld.docfriends.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface DocfriendsAPI {

    @GET("/home.json")
    suspend fun getHome(): Response<HomeResponse>
}