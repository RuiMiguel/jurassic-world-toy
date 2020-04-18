package com.ruiskas.jurassicworldtoy

import android.app.Application
import com.ruiskas.jurassicworldtoy.di.baseModules
import com.ruiskas.jurassicworldtoy.navigation.base.NavigatorLifecycle
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JurassicWorldToyApplication : Application() {
    private val navigator: NavigatorLifecycle by inject()

    override fun onCreate() {
        super.onCreate()

        initDI()
        initActivityLifecycle()
    }

    private fun initDI() {
        startKoin {
            androidContext(applicationContext)
            modules(baseModules)
            properties(getExtraProperties())
            printLogger()
        }
    }

    private fun getExtraProperties(): HashMap<String, String> {
        val extraProperties = HashMap<String, String>()
        //extraProperties[Property.API_URL] = BuildConfig.API_URL
        return extraProperties
    }

    private fun initActivityLifecycle() {
        registerActivityLifecycleCallbacks(navigator.activityLifecycleCallbacks)
    }
}