package kr.co.softcampus.solution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.co.softcampus.solution.adapter.QnaAdatper
import kr.co.softcampus.solution.api.DocFriendsAPI
import kr.co.softcampus.solution.databinding.ActivityMainBinding
import kr.co.softcampus.solution.model.DocFriendsResponse

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        DocFriendsAPI.invoke(this).getInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                var listone = it.companyList
                var listtwo = it.consultList
                var listthree = it.expertList
                binding.recyclerview.adapter = QnaAdatper(it.consultList)

                listtwo.forEach {
                    it.type = DocFriendsResponse.IMAGE_TYPE2
                }
                listthree.forEach {
                    it.type = DocFriendsResponse.IMAGE_TYPE3
                }
                // 요청성공 = onResponse
            }, {
                // 요청실패 = onFailure
            })
    }
}