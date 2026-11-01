package com.raghav.netflix.api

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val data: T,
    val requestId: String? = null,
)
