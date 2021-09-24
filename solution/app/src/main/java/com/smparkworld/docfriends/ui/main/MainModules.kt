package com.smparkworld.docfriends.ui.main

import androidx.lifecycle.ViewModel
import com.smparkworld.docfriends.di.ViewModelKey
import com.smparkworld.docfriends.ui.main.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
class MainModule {

}

@Module
abstract class MainModuleBind {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}