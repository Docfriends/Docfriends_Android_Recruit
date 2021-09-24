package com.smparkworld.docfriends.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.smparkworld.docfriends.DocfriendsApp
import com.smparkworld.docfriends.R
import com.smparkworld.docfriends.databinding.ActivityMainBinding
import com.smparkworld.docfriends.extension.setupWithNavController
import com.smparkworld.docfriends.ui.main.care.CareFragment
import com.smparkworld.docfriends.ui.main.chat.ChatFragment
import com.smparkworld.docfriends.ui.main.home.HomeFragment
import com.smparkworld.docfriends.ui.main.me.MeFragment
import com.smparkworld.docfriends.ui.main.video.VideoFragment

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (application as DocfriendsApp).appComponent.mainComponent().create()

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