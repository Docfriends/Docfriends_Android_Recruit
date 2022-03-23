package test.map.dak_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*
import test.map.dak_project.adapter.ConsultAdapter
import test.map.dak_project.adapter.companyAdapter.CompanyMainAdapter
import test.map.dak_project.adapter.expertAdapter.ExpertTitleAdapter
import test.map.dak_project.adapter.viewModel.DakViewModel
import test.map.dak_project.databinding.ActivityMainBinding

import test.map.dak_project.retrofit.Retrofit_Manager
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

//메인엑티비티 및 리사이클러뷰 셋
class MainActivity : AppCompatActivity(), CoroutineScope {


    private var mainBinding: ActivityMainBinding? = null
    private val binding get() = mainBinding!!

    lateinit var consultAdapter: ConsultAdapter
    lateinit var expertTitleAdapter: ExpertTitleAdapter
    lateinit var companyMainAdapter: CompanyMainAdapter


    lateinit var dakViewModel: DakViewModel
    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

//    lateinit var testAdapter: TestAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        job = Job()

        consultAdapter = ConsultAdapter()
        expertTitleAdapter = ExpertTitleAdapter()
        companyMainAdapter = CompanyMainAdapter()
        dakViewModel = ViewModelProvider(this).get(DakViewModel::class.java)

        dakRecyclerViewset()

    }


    //Coroutine
    private fun dakRecyclerViewset(){
        launch(coroutineContext) {
            try{
                withContext(Dispatchers.Main){
                    Retrofit_Manager.retrofitManager.SetDakData { dakitem, consultitem ->

                        dakViewModel.setDakItem(dakitem)
                        dakViewModel.setConsultItem(consultitem)

                        //epxertRecycelrview, companyRecyclerView Set
                        dakViewModel.dakitem.observe(this@MainActivity,
                            Observer { dakitem->
                                binding.expertRecyclerView.apply {
                                    adapter = expertTitleAdapter
                                    layoutManager = LinearLayoutManager(context)
                                    expertTitleAdapter.submitList(dakitem)

                                    binding.companyRecyclerview.apply {
                                        adapter = companyMainAdapter
                                        layoutManager = LinearLayoutManager(context)
                                        companyMainAdapter.submitlist(dakitem)
                                    }
                                }
                            })

                        dakViewModel.consultItem.observe(this@MainActivity,
                            Observer { consultlist->
                                binding.consultRecyclerView.apply {
                                    adapter = consultAdapter
                                    layoutManager = LinearLayoutManager(context)
                                    consultAdapter.submitList(consultlist)
                                }
                            })



                    }
                }
            }catch (e:Exception){
                e.printStackTrace()
                Toast.makeText(this@MainActivity,"Retrofit Error",Toast.LENGTH_SHORT).show()
            }
        }


    }








}