package com.android.wingsstoreapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WingsStoreApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler { thread, exception ->
            Log.e("Application Error", "Error System", Exception())
        }
    }
}