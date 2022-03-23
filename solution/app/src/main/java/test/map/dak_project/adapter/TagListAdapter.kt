package test.map.dak_project.adapter

import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.map.dak_project.dakmodel_Package.Tag
import test.map.dak_project.databinding.TaglistItemBinding



//[Consult의 TagList 아답터]
class TagListAdapter : RecyclerView.Adapter<TagListAdapter.TagListViewHolder>() {
    lateinit var tagmodel: List<Tag>

    inner class TagListViewHolder(var binding: TaglistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Tag) {
            binding.tagItem = item

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagListViewHolder {
        val view = TaglistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TagListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TagListViewHolder, position: Int) {
        holder.bind(tagmodel[position])
    }

    override fun getItemCount(): Int {
        return tagmodel.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list : List<Tag>?){
        tagmodel = list!!
        notifyDataSetChanged()
    }
}