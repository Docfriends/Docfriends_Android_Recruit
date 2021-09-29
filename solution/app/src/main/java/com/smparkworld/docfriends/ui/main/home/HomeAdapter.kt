package com.smparkworld.docfriends.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smparkworld.docfriends.R
import com.smparkworld.docfriends.databinding.*
import com.smparkworld.docfriends.model.HomeItem
import com.smparkworld.docfriends.model.HomeUiModel

class HomeAdapter(
        private val onClickItem: (HomeItem) -> Unit,
        private val onClickMenu: (View) -> Unit
) : PagingDataAdapter<HomeUiModel, RecyclerView.ViewHolder>(HomeUiModel.DIFF_CALLBACK) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeUiModel.Header ->      R.layout.item_home_adapter_header
            is HomeUiModel.ItemConsult -> R.layout.item_home_adapter_consult
            is HomeUiModel.ItemExperts -> R.layout.item_home_adapter_expert
            is HomeUiModel.ItemCompanies -> R.layout.item_home_adapter_company
            else -> R.layout.item_home_adapter_separator
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_home_adapter_header -> {
                HeaderViewHolder(
                    ItemHomeAdapterHeaderBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), onClickItem
                )
            }
            R.layout.item_home_adapter_consult -> {
                ConsultViewHolder(
                    ItemHomeAdapterConsultBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), onClickItem
                )
            }
            R.layout.item_home_adapter_expert -> {
                ExpertViewHolder(
                    ItemHomeAdapterExpertBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), onClickItem, onClickMenu
                )
            }
            R.layout.item_home_adapter_company -> {
                CompanyViewHolder(
                    ItemHomeAdapterCompanyBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), onClickItem, onClickMenu
                )
            }
            else -> {
                SeparatorViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_home_adapter_separator, parent, false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position) ?: return

        when (holder) {
            is HeaderViewHolder ->  holder.bind(item as? HomeUiModel.Header ?: return)
            is ConsultViewHolder -> holder.bind(item as? HomeUiModel.ItemConsult ?: return)
            is ExpertViewHolder ->  holder.bind(item as? HomeUiModel.ItemExperts ?: return)
            is CompanyViewHolder -> holder.bind(item as? HomeUiModel.ItemCompanies ?: return)
        }
    }

    class HeaderViewHolder(
        private val binding: ItemHomeAdapterHeaderBinding,
        private val onClickItem: (HomeItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(header: HomeUiModel.Header) {
            binding.user = header.user
            binding.onClick = onClickItem
            binding.executePendingBindings()
        }
    }

    class ConsultViewHolder(
        private val binding: ItemHomeAdapterConsultBinding,
        private val onClickItem: (HomeItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HomeUiModel.ItemConsult) {
            binding.consult = item.consult
            binding.onClick = onClickItem
            binding.executePendingBindings()
        }
    }

    class ExpertViewHolder(
        private val binding: ItemHomeAdapterExpertBinding,
        private val onClickItem: (HomeItem) -> Unit,
        private val onClickMenu: (View) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HomeUiModel.ItemExperts) {
            binding.rvContainer.adapter = ExpertAdapter(item.experts, onClickItem)
            binding.onClick = onClickMenu
            binding.executePendingBindings()
        }
    }

    class CompanyViewHolder(
        private val binding: ItemHomeAdapterCompanyBinding,
        private val onClickItem: (HomeItem) -> Unit,
        private val onClickMenu: (View) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HomeUiModel.ItemCompanies) {
            binding.rvContainer.adapter = CompanyAdapter(item.companies, onClickItem)
            binding.onClick = onClickMenu
            binding.executePendingBindings()
        }
    }

    class SeparatorViewHolder(view: View) : RecyclerView.ViewHolder(view)
}