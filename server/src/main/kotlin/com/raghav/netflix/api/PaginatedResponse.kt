package com.raghav.netflix.api

import kotlinx.serialization.Serializable

@Serializable
data class PaginatedResponse<T>(
    val data: List<T>,
    val page: PageMetaData,
    val requestId: String? = null,
)
