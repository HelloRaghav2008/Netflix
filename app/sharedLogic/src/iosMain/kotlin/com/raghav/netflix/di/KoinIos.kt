package com.raghav.netflix.di

import org.koin.core.context.startKoin

fun initKoinIos() {
    startKoin {
        modules(dataModule, domainModule)
    }
}
