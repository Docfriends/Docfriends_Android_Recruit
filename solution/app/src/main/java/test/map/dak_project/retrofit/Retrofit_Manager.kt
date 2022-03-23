package test.map.dak_project.retrofit

import android.util.Log
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response
import test.map.dak_project.Url
import test.map.dak_project.Url.Companion.TAG
import test.map.dak_project.dakmodel_Package.Consult
import test.map.dak_project.dakmodel_Package.DakItem
import test.map.dak_project.dakmodel_Package.Item

//코루틴을 활용한 레트로핏 비동기 처리
class Retrofit_Manager {

    companion object {
        val retrofitManager = Retrofit_Manager()
    }

    private val retrofitInterface =
        Retrofit_Client.getClient(Url.DAK_MAIN_URL).create(Retrofit_InterFace::class.java)





    suspend fun SetDakData(entitymodel : (List<DakItem>?, List<Consult>?)->Unit){
        val call = retrofitInterface.DakResultSet()

        val body = call.body()!!

        val dakitem = listOf(
            body
        )
        val consultlist = call.body()!!.consultList

        if(call.isSuccessful){
            entitymodel(dakitem,consultlist)
        }




    }


}