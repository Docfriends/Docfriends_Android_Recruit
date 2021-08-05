package kr.co.softcampus.solution.model


import com.google.gson.annotations.SerializedName

data class DocFriendsResponse(
    @SerializedName("pageMap")
    val pageMap: PageMap,
    @SerializedName("expertListPosition")
    val expertListPosition: Int,
    @SerializedName("companyListPosition")
    val companyListPosition: Int,
    @SerializedName("consultList")
    val consultList: List<Consult>,
    @SerializedName("expertList")
    val expertList: List<Expert>,
    @SerializedName("companyList")
    val companyList: List<Company>
) {
    data class PageMap(
        @SerializedName("pageNumber")
        val pageNumber: Int,
        @SerializedName("rowPerPage")
        val rowPerPage: Int,
        @SerializedName("pageCount")
        val pageCount: Int,
        @SerializedName("totalCount")
        val totalCount: Int
    )

    data class Consult(
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
        val tagList: List<Tag>
    ) {
        data class Tag(
            @SerializedName("key")
            val key: Int,
            @SerializedName("name")
            val name: String
        )
    }

    data class Expert(
        @SerializedName("name")
        val name: String,
        @SerializedName("typeName")
        val typeName: String,
        @SerializedName("companyName")
        val companyName: String,
        @SerializedName("profileImagePath")
        val profileImagePath: String,
        @SerializedName("tagList")
        val tagList: List<Tag>
    ) {
        data class Tag(
            @SerializedName("key")
            val key: Int,
            @SerializedName("name")
            val name: String
        )
    }

    data class Company(
        @SerializedName("companyName")
        val companyName: String,
        @SerializedName("address")
        val address: String,
        @SerializedName("addressEtc")
        val addressEtc: String,
        @SerializedName("introPath")
        val introPath: String
    )
}