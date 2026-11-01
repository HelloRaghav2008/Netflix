package com.raghav.netflix.domain.repository

import com.raghav.netflix.models.ViewingHistoryRecord
import java.util.*

interface ViewingHistoryRepository {
    suspend fun add(accountId: UUID, tmdbId: Long, mediaType: String, activityType: String): ViewingHistoryRecord
    suspend fun list(accountId: UUID, limit: Int, offset: Long): List<ViewingHistoryRecord>
}