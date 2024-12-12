plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "sandbox"
include("annotations")
include("flows")
include("ktor")
include("serialization")
include("stepper")
include("uuid")
include("settings")
include("datetime")
include("chat")
include("chat:client")
findProject(":chat:client")?.name = "client"
include("chat:server")
findProject(":chat:server")?.name = "server"
