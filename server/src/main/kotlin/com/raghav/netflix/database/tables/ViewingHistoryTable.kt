package com.raghav.netflix.database.tables

import org.jetbrains.exposed.v1.core.dao.id.java.UUIDTable
import org.jetbrains.exposed.v1.javatime.timestampWithTimeZone

object ViewingHistoryTable : UUIDTable(name = "viewing_history") {
    val accountId = reference(name = "account_id", foreign = AccountTable)
    val tmdbId = long(name = "tmdb_id")
    val mediaType = varchar(name = "media_type", length = 16)
    val activityType = varchar(name = "activity_type", length = 32)
    val occurredAt = timestampWithTimeZone(name = "occurred_at")
}
