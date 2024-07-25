import org.jetbrains.kotlin.utils.addToStdlib.assertedCast

plugins {
    kotlin("jvm") version libs.versions.kotlin.get()
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}