package com.raghav.netflix

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.raghav.netflix.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Netflix",
    ) {
        App()
    }
}