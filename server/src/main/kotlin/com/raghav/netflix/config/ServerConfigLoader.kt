package com.raghav.netflix.config

import io.ktor.server.application.*

object ServerConfigLoader {
    fun load(environment: ApplicationEnvironment): ServerConfig = ServerConfig(
        databaseUrl = environment.requiredValue(
            propertyName = "netflix.database.url",
            environmentName = "NETFLIX_DATABASE_URL"
        ),
        databaseUser = environment.requiredValue(
            propertyName = "netflix.database.user",
            environmentName = "NETFLIX_DATABASE_USER"
        ),
        databasePassword = environment.requiredValue(
            propertyName = "netflix.database.password",
            environmentName = "NETFLIX_DATABASE_PASSWORD"
        ),
        redisUri = environment.requiredValue(
            propertyName = "netflix.redis.uri",
            environmentName = "NETFLIX_REDIS_URI"
        ),
        jwtSecret = environment.requiredValue(
            propertyName = "netflix.database.password",
            environmentName = "NETFLIX_JWT_SECRET"
        ),
        smtpHost = environment.requiredValue(
            propertyName = "netflix.database.password",
            environmentName = "NETFLIX_SMTP_HOST"
        ),
        smtpPort = environment.requiredValue(
            propertyName = "netflix.database.password",
            environmentName = "NETFLIX_SMTP_PORT"
        ).toIntOrNull() ?: error("Server configuration value NETFLIX_SMTP_PORT must be a number."),
        migrateOnStart = environment.optionalValue(
            propertyName = "netflix.database.migrate-on-start",
            environmentName = "NETFLIX_DATABASE_MIGRATE_ON_START"
        )?.toBooleanStrictOrNull()
            ?: true,
    )

    private fun ApplicationEnvironment.requiredValue(propertyName: String, environmentName: String): String =
        config.propertyOrNull(path = propertyName)?.getString()
            ?: System.getenv(environmentName)
            ?: error("Missing required server configuration $environmentName (or $propertyName)")

    private fun ApplicationEnvironment.optionalValue(propertyName: String, environmentName: String): String? =
        config.propertyOrNull(propertyName)?.getString()
            ?: System.getenv(environmentName)
}
