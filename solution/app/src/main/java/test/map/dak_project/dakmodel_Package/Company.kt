package test.map.dak_project.dakmodel_Package


import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("address")
    val address: String?,
    @SerializedName("addressEtc")
    val addressEtc: String?,
    @SerializedName("companyName")
    val companyName: String?,
    @SerializedName("introPath")
    val introPath: String?
)