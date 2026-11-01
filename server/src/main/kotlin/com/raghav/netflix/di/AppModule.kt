package com.raghav.netflix.di

import com.raghav.netflix.config.ServerConfig
import org.koin.core.module.Module
import org.koin.dsl.module

fun appModule(config: ServerConfig): Module = module {
    single { config }
}