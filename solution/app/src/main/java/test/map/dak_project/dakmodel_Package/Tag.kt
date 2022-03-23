package test.map.dak_project.dakmodel_Package


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("key")
    val key: Int?,
    @SerializedName("name")
    val name: String?
)