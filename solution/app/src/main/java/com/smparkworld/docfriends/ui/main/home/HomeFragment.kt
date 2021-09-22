package com.smparkworld.docfriends.ui.main.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smparkworld.docfriends.databinding.FragmentMainHomeBinding
import com.smparkworld.docfriends.ui.main.MainActivity

class HomeFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainHomeBinding.inflate(inflater, container, false).apply {

    }.root

}