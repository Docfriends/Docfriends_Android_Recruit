package com.smparkworld.docfriends.ui.main

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
}