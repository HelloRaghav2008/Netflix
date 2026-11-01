package com.raghav.netflix.config

data class ServerConfig(
    val databaseUrl: String,
    val databaseUser: String,
    val databasePassword: String,
    val redisUri: String,
    val jwtSecret: String,
    val smtpHost: String,
    val smtpPort: Int,
    val migrateOnStart: Boolean,
)
