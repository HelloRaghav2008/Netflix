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
    testImplementation(libs.ktor.serverTestHost)
    testImplementation(libs.kotlin.testJunit)
}
