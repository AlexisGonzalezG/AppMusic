package com.example.appmusic

import android.app.Application
import com.example.appmusic.DI.ApplicationModule
import com.example.appmusic.DI.DaggerSongsComponent
import com.example.appmusic.DI.SongsComponent

class SongApp : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerSongsComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var component: SongsComponent
    }


}