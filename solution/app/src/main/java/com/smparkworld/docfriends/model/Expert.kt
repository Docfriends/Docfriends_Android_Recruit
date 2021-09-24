package com.smparkworld.docfriends.model

import com.google.gson.annotations.SerializedName

data class Expert (

    @SerializedName("name")
    val name: String,

    @SerializedName("typeName")
    val type: String,

    @SerializedName("companyName")
    val company: String,

    @SerializedName("profileImagePath")
    val imgUrl: String,

    @SerializedName("tagList")
    val tags: List<Tag>
) : HomeItem {

    fun getTagsAsString() = with(StringBuilder()) {
        tags.forEach { append("#${it.name} ") }
        return@with toString().trim()
    }
}