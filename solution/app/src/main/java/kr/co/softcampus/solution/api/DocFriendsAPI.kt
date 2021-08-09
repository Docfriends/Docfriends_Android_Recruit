package kr.co.softcampus.solution.api

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import io.reactivex.Single
import kr.co.softcampus.solution.model.DocFriendsResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

/**
 * @author Gnoss
 * @email silmxmail@naver.com
 * @created 2021-08-03
 * @desc
 */

private const val TARGET_ADDRESS = "https://docfriends.github.io/Docfriends_Android_Recruit/api/"
interface DocFriendsAPI {
    @GET("home.json")
    fun getInfo(): Single<DocFriendsResponse>
    companion object {
        private var _docfriendService : DocFriendsAPI? = null
        private val docfriendService : DocFriendsAPI get() = _docfriendService!!
        operator fun invoke(context: Context) : DocFriendsAPI {
            if(_docfriendService != null) {
                return docfriendService
            } else {
                val requestInterceptor = Interceptor { chain ->
                    val url = chain.request()
                        .url()
                        .newBuilder()
                        .build()
                    val request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()
                    return@Interceptor chain.proceed(request)
                }
                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build()
                val gson = GsonBuilder()
                    .setLenient()
                    .create()
                _docfriendService = Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(TARGET_ADDRESS)
                    .build()
                    .create(DocFriendsAPI::class.java)
                return docfriendService
            }
        }
    }
}