package com.smparkworld.docfriends.ui.main

import com.smparkworld.docfriends.ui.main.home.HomeFragment
import dagger.Subcomponent

@Subcomponent(modules = [
    MainModule::class,
    MainModuleBind::class
])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(homeFragment: HomeFragment)
}