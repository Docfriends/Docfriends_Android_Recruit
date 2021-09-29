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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.smparkworld.docfriends.R
import com.smparkworld.docfriends.databinding.FragmentMainHomeBinding
import com.smparkworld.docfriends.model.*
import com.smparkworld.docfriends.ui.main.MainActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadHome()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = FragmentMainHomeBinding.inflate(inflater, container, false).apply {
        lifecycleOwner = viewLifecycleOwner
        onClickMenu = ::onClickMenu
        vm = viewModel

        binding = this
    }.root

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) = with(binding) {

        initContainer(rvContainer)
    }

    // 클릭 이벤트를 확인하기 위한 임시 Toast 코드입니다.
    private fun onClickMenu(view: View) {
        when (view.id) {
            R.id.btnMenuSearch -> {
                Toast.makeText(requireContext(), "검색 버튼 클릭", Toast.LENGTH_SHORT).show()
            }
            R.id.btnMenuInvite -> {
                Toast.makeText(requireContext(), "초대 버튼 클릭", Toast.LENGTH_SHORT).show()
            }
            R.id.btnMoreExpert -> {
                Toast.makeText(requireContext(), "전문가 더보기 버튼 클릭", Toast.LENGTH_SHORT).show()
            }
            R.id.btnMoreCompany -> {
                Toast.makeText(requireContext(), "회사 더보기 버튼 클릭", Toast.LENGTH_SHORT).show()
            }
            R.id.btnAsk -> {
                Toast.makeText(requireContext(), "질문 추가 버튼 클릭", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 클릭 이벤트를 확인하기 위한 임시 Toast 코드입니다.
    private fun onClickItem(item: HomeItem) {
        when (item) {
            is User -> {
                Toast.makeText(requireContext(), "회원 질문 클릭 (이름: ${item.name})", Toast.LENGTH_SHORT).show()
            }
            is Consult -> {
                Toast.makeText(requireContext(), "상담 아이템 클릭 (제목: ${item.title.substring(0..5) + "..."})", Toast.LENGTH_SHORT).show()
            }
            is Expert -> {
                Toast.makeText(requireContext(), "전문가 아이템 클릭 (이름: ${item.name})", Toast.LENGTH_SHORT).show()
            }
            is Company -> {
                Toast.makeText(requireContext(), "회사 아이템 클릭 (이름: ${item.name})", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initContainer(list: RecyclerView) {

        viewModel.flow.observe(viewLifecycleOwner) {
            val adapter = HomeAdapter(::onClickItem, ::onClickMenu).apply {
                addLoadStateListener(viewModel::setUsersLoadState)

                list.adapter = withLoadStateFooter(HomeLoadStateAdapter(::retry))
            }
            lifecycleScope.launch {
                it.collectLatest { adapter.submitData(it) }
            }
        }
    }
}