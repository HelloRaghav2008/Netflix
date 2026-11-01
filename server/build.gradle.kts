plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.koin.compiler)
}

group = "com.raghav.netflix"
version = "1.0.0"
application {
    mainClass = "com.raghav.netflix.ApplicationKt"
}

dependencies {
    api(project(":core"))
    implementation(libs.logback)
    implementation(libs.ktor.serverCore)
    implementation(libs.ktor.serverNetty)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)
    implementation(ktorlibs.serialization.kotlinx.json)
    implementation(ktorlibs.server.contentNegotiation)
    implementation(ktorlibs.server.statusPages)
    implementation(ktorlibs.server.cors)
    implementation(ktorlibs.server.callId)
    implementation(ktorlibs.server.openapi)
    implementation(ktorlibs.server.swagger)
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.dao)
    implementation(libs.exposed.java.time)
    implementation(libs.postgresql)
    implementation(libs.flyway)
    implementation(libs.flyway.postgres)
    implementation(libs.lettuce)
    implementation(libs.argon2)
    implementation(libs.java.jwt)
    implementation(libs.testcontainers.junit)
    implementation(libs.testcontainers.postgres)
    testImplementation(libs.ktor.serverTestHost)
    testImplementation(libs.kotlin.testJunit)
}
