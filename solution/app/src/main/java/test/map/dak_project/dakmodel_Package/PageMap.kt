package test.map.dak_project.dakmodel_Package


import com.google.gson.annotations.SerializedName

data class PageMap(
    @SerializedName("pageCount")
    val pageCount: Int?,
    @SerializedName("pageNumber")
    val pageNumber: Int?,
    @SerializedName("rowPerPage")
    val rowPerPage: Int?,
    @SerializedName("totalCount")
    val totalCount: Int?
)