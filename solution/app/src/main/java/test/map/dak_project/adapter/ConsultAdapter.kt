package test.map.dak_project.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import test.map.dak_project.adapter.expertAdapter.ExpertListAdapter
import test.map.dak_project.dakmodel_Package.Consult
import test.map.dak_project.dakmodel_Package.DakItem
import test.map.dak_project.databinding.ConsultlistItemBinding


//Consult Adapter
class ConsultAdapter : RecyclerView.Adapter<ConsultAdapter.ConsultViewHolder>() {


    //cosultlist
    lateinit var consultmodel: List<Consult>
    lateinit var tagListAdapter: TagListAdapter


    //consultViewHolder
    inner class ConsultViewHolder(var binding: ConsultlistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Consult) {

            binding.consultItem = item
        

            tagListAdapter = TagListAdapter()
            binding.tagListRecyclerView.apply {
                adapter = tagListAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                tagListAdapter.submitList(item.tagList)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultViewHolder {
        val view = ConsultlistItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ConsultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConsultViewHolder, position: Int) {
        holder.bind(consultmodel[position])
    }

    override fun getItemCount(): Int {
        return consultmodel.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Consult>?) {
        consultmodel = list!!
        notifyDataSetChanged()
    }


}