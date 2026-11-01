package com.raghav.netflix.di

import org.koin.dsl.module

val uiModule = module {
    includes(dataModule, domainModule)
}
