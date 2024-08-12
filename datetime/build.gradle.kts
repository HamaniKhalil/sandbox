plugins {
    kotlin("multiplatform")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm()

    sourceSets {

        commonMain.dependencies {
            implementation(libs.kotlinx.datetime)
        }
    }
}