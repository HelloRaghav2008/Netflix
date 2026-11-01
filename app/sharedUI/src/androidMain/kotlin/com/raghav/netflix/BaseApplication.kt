package com.raghav.netflix

import android.app.Application
import com.raghav.netflix.di.initKoin
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@BaseApplication)
        }
    }
}
