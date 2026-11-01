package com.raghav.netflix.database.tables

import org.jetbrains.exposed.v1.core.dao.id.java.UUIDTable
import org.jetbrains.exposed.v1.javatime.timestampWithTimeZone

object PasswordResetTokens : UUIDTable(name = "password_rest_tokens") {
    val accountId = reference(name = "account_id", foreign = AccountTable)
    val tokenHash = text(name = "token_hash").uniqueIndex()
    val expiresAt = timestampWithTimeZone(name = "expires_at")
    val usedAt = timestampWithTimeZone(name = "used_at").nullable()
    val createdAt = timestampWithTimeZone(name = "created_at")
}
