package com.raghav.netflix.api

import kotlinx.serialization.Serializable

@Serializable
data class PageMetaData(
    val limit: Int,
    val offset: Long,
    val returned: Int,
    val nextOffset: Long? = null,
)
