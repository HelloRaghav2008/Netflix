package com.raghav.netflix

import com.raghav.netflix.config.ServerConfigLoader
import com.raghav.netflix.di.appModule
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val config = ServerConfigLoader.load(environment)
    if (config.migrateOnStart) {
        // Migrate
    }
    install(plugin = Koin) {
        slf4jLogger()
        modules(appModule(config))
    }
    routing {
        get("/") {
            call.respondText(sayHello("Ktor"))
        }
    }
}
