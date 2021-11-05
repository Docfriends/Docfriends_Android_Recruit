package com.example.Doc_Solution

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


public class FourthFragment : Fragment()
{

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fourthfragment, container, false)

    }

   // override fun onViewCreated(view: View, savedInstanceState: Bundle?)
}