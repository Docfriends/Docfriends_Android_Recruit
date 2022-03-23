package test.map.dak_project.adapter.expertAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import test.map.dak_project.dakmodel_Package.Expert
import test.map.dak_project.databinding.ExpertlistItemBinding



[ ExpertList Adapter 생성 ]
class ExpertListAdapter : RecyclerView.Adapter<ExpertListAdapter.ExpertListViewHolder>() {

    lateinit var expertmodel: List<Expert>

    lateinit var expertTagListAdater: ExpertTagListAdater

    inner class ExpertListViewHolder(val binding: ExpertlistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Expert) {
            Glide.with(itemView).load(item.profileImagePath).into(binding.expertImageView)
            binding.expertItem = item

            expertTagListAdater = ExpertTagListAdater()
            binding.expertTagListRecyclerView.apply {
                adapter = expertTagListAdater
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                expertTagListAdater.submitList(item.tagList)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertListViewHolder {
        val view = ExpertlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpertListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpertListViewHolder, position: Int) {
        holder.bind(expertmodel[position])
    }

    override fun getItemCount(): Int {
        return expertmodel.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Expert>?) {
        expertmodel = list!!
        notifyDataSetChanged()
    }
}