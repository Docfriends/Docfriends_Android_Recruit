package test.map.dak_project.retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import test.map.dak_project.Url
import test.map.dak_project.dakmodel_Package.DakItem
import test.map.dak_project.dakmodel_Package.Item
import test.map.dak_project.dakmodel_Package.ItemConsult


//레트로핏 인터페이스
interface Retrofit_InterFace {

    @GET("Docfriends_Android_Recruit/api/home.json")
    suspend fun DakResultSet() : Response<DakItem>
}