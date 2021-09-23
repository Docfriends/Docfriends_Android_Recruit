package com.smparkworld.docfriends.ui.main.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.smparkworld.docfriends.R
import com.smparkworld.docfriends.databinding.FragmentMainHomeBinding
import com.smparkworld.docfriends.model.*
import com.smparkworld.docfriends.ui.main.MainActivity
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    lateinit var binding: FragmentMainHomeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        binding = FragmentMainHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        onClickMenu = ::onClickMenu
    }

    private fun onClickMenu(view: View) {
        when (view.id) {
            R.id.btnMenuSearch -> {
                Toast.makeText(requireContext(), "검색 버튼 클릭", Toast.LENGTH_SHORT).show()
            }
            R.id.btnMenuInvite -> {
                Toast.makeText(requireContext(), "초대 버튼 클릭", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onClickItem(item: HomeItem) {
        when (item) {
            is HomeUiModel.Header -> {

            }
            is Consult -> {

            }
            is Expert -> {

            }
            is Company -> {

            }
        }
    }

    private fun initContainer(container: RecyclerView) {

    }
}