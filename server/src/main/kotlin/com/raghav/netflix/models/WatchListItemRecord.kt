package com.raghav.netflix.models

import java.time.OffsetDateTime

data class WatchListItemRecord(
    val tmdb: Long,
    val mediaType: Long,
    val addedAt: OffsetDateTime,
)
