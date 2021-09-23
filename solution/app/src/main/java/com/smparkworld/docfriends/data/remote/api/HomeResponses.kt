package com.smparkworld.docfriends.data.remote.api

import com.google.gson.annotations.SerializedName
import com.smparkworld.docfriends.model.Company
import com.smparkworld.docfriends.model.Consult
import com.smparkworld.docfriends.model.Expert

data class HomeResponse (

    @SerializedName("expertListPosition")
    val expertsPosition: Int,

    @SerializedName("companyListPosition")
    val companiesPosition: Int,

    @SerializedName("consultList")
    val consults: List<Consult>,

    @SerializedName("expertList")
    val experts: List<Expert>,

    @SerializedName("companyList")
    val companies: List<Company>
)