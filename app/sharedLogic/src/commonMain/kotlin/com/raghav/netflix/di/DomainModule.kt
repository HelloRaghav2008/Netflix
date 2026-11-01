package com.raghav.netflix.di

import org.koin.dsl.module

val domainModule = module {
    includes(dataModule)
}
