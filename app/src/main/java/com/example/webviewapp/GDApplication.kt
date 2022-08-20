package com.example.webviewapp

import android.app.Application
import com.good.gd.GDAndroid

class GDApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        GDAndroid.getInstance().applicationInit(applicationContext)
    }
}