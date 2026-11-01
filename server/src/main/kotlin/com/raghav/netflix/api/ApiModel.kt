package com.raghav.netflix.api

const val API_VERSION_PREFIX = "/api/v1"

fun pageMetaData(limit: Int, offset: Long, returned: Int): PageMetaData = PageMetaData(
    limit = limit,
    offset = offset,
    returned = returned,
    nextOffset = if (returned == limit) offset + returned else null,
)
