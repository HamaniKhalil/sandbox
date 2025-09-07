import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compiler.compose)
}

kotlin {

    jvm()

    sourceSets {

        sourceSets.commonMain {
            kotlin.srcDirs("src/commonMain")
        }

        commonMain.dependencies {
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.runtime)
            implementation(compose.preview)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.common)
            implementation(compose.desktop.currentOs)
        }

    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = rootProject.name
            packageVersion = "1.0.0"
//            macOS {
//                iconFile.set(project.file("icons/icon.icns"))
//            }
//            windows {
//                iconFile.set(project.file("icon.ico"))
//            }
//            linux {
//                iconFile.set(project.file("icon.png"))
//            }
        }
    }
}