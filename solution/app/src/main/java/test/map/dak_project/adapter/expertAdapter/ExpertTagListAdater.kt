package test.map.dak_project.adapter.expertAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.map.dak_project.dakmodel_Package.TagX
import test.map.dak_project.databinding.ExpertTaglistItemBinding


//Expert 태그 리스트
class ExpertTagListAdater : RecyclerView.Adapter<ExpertTagListAdater.ExpertTagListViewHolder>() {

    lateinit var taglist: List<TagX>

    inner class ExpertTagListViewHolder(val binding: ExpertTaglistItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TagX) {
            binding.tagxitem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertTagListViewHolder {
        val view =
            ExpertTaglistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpertTagListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpertTagListViewHolder, position: Int) {
       holder.bind(taglist[position])
    }

    override fun getItemCount(): Int {
        return taglist.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<TagX>?){
        taglist = list!!
        notifyDataSetChanged()
    }
}