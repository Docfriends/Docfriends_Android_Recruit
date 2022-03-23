package test.map.dak_project.dakmodel_Package


import com.google.gson.annotations.SerializedName

data class Expert(
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
){
    val typeNametext: String
        get() {
            val resultText :String =" ("+ typeName +")"
            return resultText
        }
}