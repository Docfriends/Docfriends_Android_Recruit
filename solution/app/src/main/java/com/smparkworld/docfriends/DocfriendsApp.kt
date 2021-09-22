package com.smparkworld.docfriends

import android.app.Application
import com.smparkworld.docfriends.di.DaggerAppComponent

class DocfriendsApp : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}