package com.raghav.netflix

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform