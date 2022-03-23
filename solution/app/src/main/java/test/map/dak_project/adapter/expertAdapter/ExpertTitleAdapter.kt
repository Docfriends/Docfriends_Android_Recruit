package test.map.dak_project.adapter.expertAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import test.map.dak_project.adapter.ConsultAdapter
import test.map.dak_project.dakmodel_Package.DakItem
import test.map.dak_project.databinding.ExpertmainItemBinding




//[Expert 메인 아답터]
class ExpertTitleAdapter:RecyclerView.Adapter<ExpertTitleAdapter.ExpertTitleViewHolder>() {

    lateinit var expertlistAdater: ExpertListAdapter
    lateinit var dakmodel: List<DakItem>

    lateinit var consultAdapter: ConsultAdapter


    inner class ExpertTitleViewHolder(val binding : ExpertmainItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind ( item : DakItem){
            expertlistAdater = ExpertListAdapter()
            consultAdapter = ConsultAdapter()


            binding.expertTitleRecyclerView.apply {
                adapter = expertlistAdater
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL ,false)
                expertlistAdater.submitList(item.expertList)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertTitleViewHolder {
        val view = ExpertmainItemBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return ExpertTitleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpertTitleViewHolder, position: Int) {
       holder.bind(dakmodel[position])
    }

    override fun getItemCount(): Int {
        return dakmodel.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<DakItem>?){
        dakmodel = list!!
        notifyDataSetChanged()
    }
}