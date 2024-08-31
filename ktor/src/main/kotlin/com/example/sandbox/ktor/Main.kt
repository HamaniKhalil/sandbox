package com.example.sandbox.ktor

import com.example.sandbox.ktor.models.Authorization
import com.example.sandbox.ktor.models.Credentials
import com.example.sandbox.ktor.services.AuthenticationService
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json


fun main() = runBlocking {
    // Create a Ktor client with CIO engine
    val client = HttpClient(CIO) {
        defaultRequest {
            url("https://api.n-eskone.com/")
            contentType(ContentType.Application.Json)
        }
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

    val authenticationService = AuthenticationService(client)

    try {
        val response: Authorization? = authenticationService.login(
            Credentials(
                username = "hamani_khalil@yahoo.fr",
                password = "!sEcurity23"
            )
        )

        println("Response: ${response?.accessToken}")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        client.close()
    }
}
