package com.smparkworld.docfriends.data.repository

interface UserRepository {

    fun getHome(search: String?): HomePagingSource
}