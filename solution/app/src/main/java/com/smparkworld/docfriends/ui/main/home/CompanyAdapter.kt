package com.smparkworld.docfriends.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smparkworld.docfriends.databinding.ItemHomeCompanyadapterBinding
import com.smparkworld.docfriends.model.Company
import com.smparkworld.docfriends.model.HomeItem

class CompanyAdapter (
    private val companies: List<Company>,
    private val onClickItem: (HomeItem) -> Unit
) : RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CompanyViewHolder(
            ItemHomeCompanyadapterBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
            ), onClickItem
    )

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        holder.bind(companies[position])
    }

    override fun getItemCount() = companies.size

    class CompanyViewHolder(
            private val binding: ItemHomeCompanyadapterBinding,
            private val onClickItem: (HomeItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(company: Company) {
            binding.company = company
            binding.onClick = onClickItem
            binding.executePendingBindings()
        }
    }
}