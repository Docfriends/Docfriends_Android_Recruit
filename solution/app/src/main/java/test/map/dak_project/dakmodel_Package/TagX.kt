package test.map.dak_project.dakmodel_Package


import com.google.gson.annotations.SerializedName

data class TagX(
    @SerializedName("key")
    val key: Int?,
    @SerializedName("name")
    val name: String?
){
    val tagxtext: String
        get() {
            val tagx :String =" #"+ name
            return tagx
        }

}