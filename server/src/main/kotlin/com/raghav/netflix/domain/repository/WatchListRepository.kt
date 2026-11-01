package com.raghav.netflix.domain.repository

import com.raghav.netflix.models.WatchListItemRecord
import java.util.*

interface WatchListRepository {
    suspend fun add(accountId: UUID, tmdbId: Long, mediaType: String): WatchListItemRecord
    suspend fun remove(accountId: UUID, tmdbId: Long, mediaType: String): Boolean
    suspend fun list(accountId: UUID, limit: Int, offset: Long): List<WatchListItemRecord>
}