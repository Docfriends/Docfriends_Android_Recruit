package com.example.Doc_Solution

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(MainFragment(), "홈")
        adapter.addFragment(SecondFragment(), "전문가")
        adapter.addFragment(ThirdFragment(), "상담방")
        adapter.addFragment(FourthFragment(),"비대면진료")
        adapter.addFragment(FifthFragment(),"프로필")
        after_login_viewpager.adapter = adapter
        after_login_tablayout.setupWithViewPager(after_login_viewpager)


    }
}