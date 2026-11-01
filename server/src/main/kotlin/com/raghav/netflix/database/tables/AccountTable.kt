package com.raghav.netflix.database.tables

import org.jetbrains.exposed.v1.core.dao.id.java.UUIDTable
import org.jetbrains.exposed.v1.javatime.timestampWithTimeZone

object AccountTable : UUIDTable(name = "accounts"){
    val email = varchar(name = "email", length = 320).uniqueIndex()
    val passwordHash = text(name = "password_hash")
    val emailVerified = timestampWithTimeZone(name = "email_verified_at").nullable()
    val createdAt = timestampWithTimeZone(name = "created_at")
    val updatedAt = timestampWithTimeZone(name = "updated_at")
}
