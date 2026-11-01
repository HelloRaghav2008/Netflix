import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.koin.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidx.room3)
}

room3 {
    schemaDirectory("$projectDir/schemas")
}

kotlin {
    val xcFrameworkName = "SharedLogic"
    val xcf = XCFramework(xcFrameworkName)
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = xcFrameworkName
            binaryOption("bundleId", "com.raghav.${xcFrameworkName}")
            xcf.add(this)
            isStatic = true
        }
    }
    jvm()
    android {
        namespace = "com.raghav.netflix.sharedLogic"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
    }
    sourceSets {
        androidMain.dependencies {
            implementation(libs.koin.android)
            implementation(ktorlibs.client.okhttp)
        }
        commonMain.dependencies {
            api(project(":core"))
            // put your Multiplatform dependencies here
            implementation(libs.koin.core)
            implementation(libs.androidx.room3.runtime)
            implementation(libs.androidx.sqlite.bundled)
            api(libs.kotlinx.serialization.json)
            implementation(ktorlibs.client.core)
            implementation(ktorlibs.serialization.kotlinx.json)
            implementation(ktorlibs.client.contentNegotiation)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.koin.test)
            implementation(libs.ktor.client.mock)
        }
        iosMain.dependencies {
            implementation(ktorlibs.client.darwin)
        }
        jvmMain.dependencies {
            implementation(ktorlibs.client.java)
        }
    }
}

dependencies {
    add("kspAndroid", libs.androidx.room3.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room3.compiler)
    add("kspIosArm64", libs.androidx.room3.compiler)
    add("kspJvm", libs.androidx.room3.compiler)
}
