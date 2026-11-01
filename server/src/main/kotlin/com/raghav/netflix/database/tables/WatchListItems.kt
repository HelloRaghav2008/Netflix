package com.raghav.netflix.database.tables

import org.jetbrains.exposed.v1.core.dao.id.java.UUIDTable
import org.jetbrains.exposed.v1.javatime.timestampWithTimeZone

object WatchListItems : UUIDTable(name = "watchlist_items") {
    val accountId = reference(name = "account_id", foreign = AccountTable)
    val tmdbId = long(name = "tmdb_id")
    val mediaType = varchar(name = "media_type", length = 16)
    val addedAt = timestampWithTimeZone(name = "added_at")
    init {
        uniqueIndex(accountId, tmdbId, mediaType)
    }
}