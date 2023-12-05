package com.example.findmyip.app

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FindMyAppLibrary : Application() {
    init {
        Instance = this
    }

    companion object {
        private var Instance: FindMyAppLibrary? = null
        fun applicationContext(): Context? {
            return Instance?.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}