package com.raghav.netflix.models

import java.time.OffsetDateTime

data class ViewingHistoryRecord(
    val tmdbId: Long,
    val mediaType: String,
    val activityType: String,
    val occurredAt: OffsetDateTime,
)
