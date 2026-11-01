package com.raghav.netflix.domain.repository

import com.raghav.netflix.models.AccountRecord
import java.util.*

interface AccountRepository {
    suspend fun findByEmail(email: String): AccountRecord?
    suspend fun findById(accountId: UUID): AccountRecord?
    suspend fun create(email: String, password: String): AccountRecord
}