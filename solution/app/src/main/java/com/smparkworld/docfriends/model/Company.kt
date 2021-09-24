package com.smparkworld.docfriends.model

import com.google.gson.annotations.SerializedName

data class Company (

    @SerializedName("companyName")
    val name: String,

    @SerializedName("address")
    val address: String,

    @SerializedName("addressEtc")
    val addressEtc: String,

    @SerializedName("introPath")
    val imgUrl: String
) : HomeItem