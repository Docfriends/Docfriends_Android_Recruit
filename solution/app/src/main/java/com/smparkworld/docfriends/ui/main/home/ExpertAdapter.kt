package com.smparkworld.docfriends.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smparkworld.docfriends.databinding.ItemHomeExpertadapterBinding
import com.smparkworld.docfriends.model.Expert
import com.smparkworld.docfriends.model.HomeItem

class ExpertAdapter(
    private val experts: List<Expert>,
    private val onClickItem: (HomeItem) -> Unit
) : RecyclerView.Adapter<ExpertAdapter.ExpertViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExpertViewHolder(
        ItemHomeExpertadapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), onClickItem
    )

    override fun onBindViewHolder(holder: ExpertViewHolder, position: Int) {
        holder.bind(experts[position])
    }

    override fun getItemCount() = experts.size

    class ExpertViewHolder(
        private val binding: ItemHomeExpertadapterBinding,
        private val onClickItem: (HomeItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(expert: Expert) {
            binding.expert = expert
            binding.onClick = onClickItem
            binding.executePendingBindings()
        }
    }
}