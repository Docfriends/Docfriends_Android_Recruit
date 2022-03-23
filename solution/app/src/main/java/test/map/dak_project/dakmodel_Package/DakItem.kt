package test.map.dak_project.dakmodel_Package


import com.google.gson.annotations.SerializedName


//모델
data class DakItem(
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
)