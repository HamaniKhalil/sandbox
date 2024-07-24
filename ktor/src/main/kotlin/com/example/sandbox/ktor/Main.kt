package com.example.sandbox.ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


@Serializable
data class ApiResponse(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("expires_in")
    val expiresIn: Int,
)

@Serializable
data class ApiLogin(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,
)

fun main() = runBlocking {
    // Create a Ktor client with CIO engine
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    // Define the URL for the GET request
    val url = "https://api.n-eskone.com/ms-auth/login"

    // Perform the GET request
    try {
        val response: ApiResponse = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(
                ApiLogin(
                    username = "hamani_khalil@yahoo.fr",
                    password = "!sEcurity23"
                )
            )
        }
            .body() as ApiResponse
        println("Response: ${response.accessToken}")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        client.close()
    }
}
