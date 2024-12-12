plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.jetbrains.compiler.compose)
    alias(libs.plugins.jetbrains.compose)
}

repositories {
    google()
    mavenCentral()
}
dependencies {
    implementation(libs.jetbrains.lifecycle.compose)

    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.websockets)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)

    implementation(compose.ui)
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.preview)
    implementation(compose.uiTooling)
    implementation(compose.desktop.common)
    implementation(compose.desktop.currentOs)
}