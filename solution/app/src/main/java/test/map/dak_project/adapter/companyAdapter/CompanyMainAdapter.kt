package test.map.dak_project.adapter.companyAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import test.map.dak_project.dakmodel_Package.DakItem
import test.map.dak_project.databinding.CompanyItemBinding

//[ CompanyMain Adapter 생성 ]
class CompanyMainAdapter:RecyclerView.Adapter<CompanyMainAdapter.ComapanyMainViewHolder>() {
    lateinit var dakmodel : List<DakItem>
    lateinit var companyListAdapter: CompanyListAdapter

    inner class ComapanyMainViewHolder(val binding : CompanyItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item : DakItem){
            companyListAdapter = CompanyListAdapter()
            binding.companyRecyclerView.apply{
                adapter = companyListAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL , false)
                companyListAdapter.submitlist(item.companyList)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComapanyMainViewHolder {
        val view = CompanyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ComapanyMainViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComapanyMainViewHolder, position: Int) {
      holder.bind(dakmodel[position])
    }

    override fun getItemCount(): Int {
       return dakmodel.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitlist(list:List<DakItem>?){
        dakmodel = list!!
        notifyDataSetChanged()
    }

}