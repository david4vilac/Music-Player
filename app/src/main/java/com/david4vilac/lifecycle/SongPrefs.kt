package com.david4vilac.lifecycle

import android.app.Application
import com.david4vilac.lifecycle.Prefs

class SongPrefs: Application() {

        companion object{
            lateinit var prefs: Prefs
        }

        override fun onCreate() {
            prefs = Prefs(applicationContext)
            super.onCreate()
        }
    }