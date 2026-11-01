package com.raghav.netflix.models

import java.time.OffsetDateTime
import java.util.UUID

data class AccountRecord(
    val id: UUID,
    val email: String,
    val passwordHash: String,
    val emailVerifiedAt: OffsetDateTime?,
)
