package com.smparkworld.docfriends.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.smparkworld.docfriends.R
import com.smparkworld.docfriends.databinding.ActivityMainBinding
import com.smparkworld.docfriends.extension.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {

            btmNaviView.setupWithNavController(supportFragmentManager, R.id.fragContainer, listOf(
                HomeFragment(), CareFragment(), ChatFragment(), VideoFragment(), MeFragment()
            ))
        }
    }
}