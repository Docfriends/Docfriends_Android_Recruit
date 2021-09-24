package com.smparkworld.docfriends.model

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class Consult (

    @SerializedName("seq")
    val seq: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("context")
    val context: String,

    @SerializedName("regDate")
    val regDate: Long,

    @SerializedName("answerCnt")
    val answerCnt: Int,

    @SerializedName("tagList")
    val tags: List<Tag>
) : HomeItem {

    fun getTagsAsString() = with(StringBuilder()) {
        tags.forEach { append("#${it.name} ") }
        return@with toString().trim()
    }

    fun getDateTime(): String = with(Date(regDate)) {
        return@with SimpleDateFormat("y.MM.dd", Locale.KOREA).format(this)
    }
}