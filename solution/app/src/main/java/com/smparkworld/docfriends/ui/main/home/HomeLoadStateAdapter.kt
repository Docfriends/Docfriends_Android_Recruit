package com.smparkworld.docfriends.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smparkworld.docfriends.databinding.ItemHomeAdapterLoadstateBinding

class HomeLoadStateAdapter(
        private val retry: () -> Unit
) : LoadStateAdapter<HomeLoadStateAdapter.StateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = StateViewHolder(
            ItemHomeAdapterLoadstateBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
            ), retry
    )

    override fun onBindViewHolder(holder: StateViewHolder, loadState: LoadState) = holder.bind(loadState)

    class StateViewHolder(
            private val binding: ItemHomeAdapterLoadstateBinding,
            private val retry: () -> Unit
    ): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnRetry.setOnClickListener { retry() }
        }

        fun bind(loadState: LoadState) {
            binding.progressbar.isVisible = loadState is LoadState.Loading
            binding.tvErrorMsg.isVisible  = loadState is LoadState.Error
            binding.btnRetry.isVisible    = loadState is LoadState.Error
        }
    }
}