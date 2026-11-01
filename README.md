This is a Kotlin Multiplatform project targeting Android, iOS, Desktop (JVM), Web, Server.

* [/app/androidApp](./app/androidApp) contains an Android application. Even if you're sharing your UI with Compose
  Multiplatform, you need this entry point for your Android app.

* [/app/desktopApp](./app/desktopApp) contains desktop application which targets all 3 platforms Windows, macOS. Linux.
  The UI is shared with Compose Multiplatform and logic is written in Kotlin.

* [/app/iosApp](./app/iosApp/iosApp) contains an iOS application. You need this entry point for your iOS app. This is
  where you should add SwiftUI code for your project.

* [/app/sharedLogic](./app/sharedLogic/src) is for the code that will be shared between Android, iOS, Desktop targets in
  the project. This is where logic part should be written. The most important subfolder
  is [commonMain](./app/sharedLogic/src/commonMain/kotlin). If preferred, you can add code to the platform-specific
  folders here.

* [/app/sharedUI](./app/sharedUI/src) is for code that will be shared across your Compose Multiplatform applications
  (Android, Desktop). It contains subfolders:
    - [commonMain](./app/sharedUI/src/commonMain/kotlin) is for code that’s for Android & Desktop.
    - [commonTest](./app/sharedUI/src/commonTest) is for writing tests for UI part of Android & Desktop.

* [/app/webApp](./app/webApp) contains a web application. This is standalone project in TanStack Start. The UI & logic
  should be written inside it only.

* [/core](./core/src) is for the code that will be shared between Android, iOS, Desktop & server in the project.
  The most important subfolder is [commonMain](./core/src/commonMain/kotlin). If preferred, you
  can add code to the platform-specific folders here too.

* [/server](./server/src/main/kotlin) is for the Ktor server application.

### Running the apps

Use the run configurations provided by the run widget in your IDE's toolbar. You can also use these commands and
options:

- Android app: `./gradlew :app:androidApp:assembleDebug`
- Desktop app:
    - Hot reload: `./gradlew :app:desktopApp:hotRun --auto`
    - Standard run: `./gradlew :app:desktopApp:run`
- Server: `./gradlew :server:run`
- iOS app: open the [/app/iosApp](./app/iosApp) directory in Xcode and run it from there.

### Running tests

Use the run button in your IDE's editor gutter, or run tests using Gradle tasks:

- Android tests: `./gradlew :app:sharedUI:testAndroidHostTest :app:sharedLogic:testAndroidHostTest`
- Desktop tests: `./gradlew :app:sharedUI:jvmTest :app:sharedLogic:jvmTest`
- Server tests: `./gradlew :server:test`
- iOS tests: `./gradlew :app:sharedLogic:iosSimulatorArm64Test`

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…