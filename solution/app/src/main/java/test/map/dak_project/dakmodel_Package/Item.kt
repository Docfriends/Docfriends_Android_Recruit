package test.map.dak_project.dakmodel_Package

import com.google.gson.annotations.SerializedName

interface Item

data class ItemDakModel(
    @SerializedName("companyList")
    val companyList: List<Company>?,
    @SerializedName("companyListPosition")
    val companyListPosition: Int?,
    @SerializedName("consultList")
    val consultList: List<Consult>?,
    @SerializedName("expertList")
    val expertList: List<Expert>?,
    @SerializedName("expertListPosition")
    val expertListPosition: Int?,
    @SerializedName("pageMap")
    val pageMap: PageMap?
):Item

data class ItemConsult(
    @SerializedName("answerCnt")
    val answerCnt: Int?,
    @SerializedName("context")
    val context: String?,
    @SerializedName("regDate")
    val regDate: Long?,
    @SerializedName("seq")
    val seq: Int?,
    @SerializedName("tagList")
    val tagList: List<Tag>?,
    @SerializedName("title")
    val title: String?
) : Item

data class ItemExpert(
    @SerializedName("companyName")
    val companyName: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("profileImagePath")
    val profileImagePath: String?,
    @SerializedName("tagList")
    val tagList: List<TagX>?,
    @SerializedName("typeName")
    val typeName: String?
) : Item


