package com.raghav.netflix.routes

import com.raghav.netflix.config.ServerConfig
import io.ktor.http.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class ServiceStatus(
    val status: String
)

fun Route.systemRoute(config: ServerConfig) {
    get("/health") {
        call.respond(HttpStatusCode.OK, ServiceStatus(status = "ok"))
    }
    get("/ready") {
        val isConfigured = config.databaseUrl.isNotBlank() && config.redisUri.isNotBlank()
        call.respond(
            status = if (isConfigured) HttpStatusCode.OK
            else HttpStatusCode.ServiceUnavailable,
            message = ServiceStatus(if (isConfigured) "ready" else "not_ready")
        )
    }
    swaggerUI(path = "swagger", swaggerFile = "openapi/openapi.yaml")
}
