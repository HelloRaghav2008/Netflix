package com.raghav.netflix.database.tables

import org.jetbrains.exposed.v1.core.dao.id.java.UUIDTable
import org.jetbrains.exposed.v1.javatime.timestampWithTimeZone

object RefreshSessionsTable : UUIDTable(name = "refresh_sessions") {
    val accountId = reference(name = "account_id", foreign = AccountTable)
    val tokenHash = text(name = "token_hash").uniqueIndex()
    val expiresAt = timestampWithTimeZone(name = "expires_at")
    val revokedAt = timestampWithTimeZone(name = "revoked_at").nullable()
    val replacedSessionById = uuid(name = "replaced_by_session_id").nullable()
    val createdAt = timestampWithTimeZone(name = "created_at")
}
