package com.raghav.netflix.plugins

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callid.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.util.*

@Serializable
data class ApiError(
    val code: String,
    val message: String,
    val requestId: String?,
)

fun Application.configureHttp() {
    install(plugin = CallId) {
        retrieveFromHeader(headerName = HttpHeaders.XRequestId)
        generate { UUID.randomUUID().toString() }
        verify { it.isNotBlank() }
        replyToHeader(headerName = HttpHeaders.XRequestId)
    }
    install(plugin = ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
                explicitNulls = false
            }
        )
    }
    install(plugin = CORS) {
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Patch)
        allowMethod(HttpMethod.Delete)
        allowHeader(HttpHeaders.Authorization)
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.XRequestId)
    }
    install(plugin = StatusPages) {
        exception<Throwable> { call, cause ->
            this@configureHttp.environment.log.error("Unhandled request failure for ${call.callId}", cause)
            call.respond(
                status = HttpStatusCode.InternalServerError,
                message = ApiError(
                    code = "Internal error",
                    message = "An unexpected error occured",
                    requestId = call.callId,
                )
            )
        }
        status(HttpStatusCode.NotFound) { call, code ->
            call.respond(
                status = HttpStatusCode.NotFound,
                message = ApiError(
                    code = "not_found",
                    message = "The requested resource was not found",
                    requestId = call.callId
                )
            )
        }
    }
}
