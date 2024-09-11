package com.example.sandbox.ktor

import com.example.sandbox.ktor.models.AuthorizationDto
import com.example.sandbox.ktor.models.CredentialsDto
import com.example.sandbox.ktor.services.AuthenticationService
import com.example.sandbox.ktor.services.MediaService
import com.example.sandbox.ktor.services.EstatesService
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import java.io.File


fun main(): Unit = runBlocking {
    var authorization: AuthorizationDto? = null
    // Create a Ktor client with CIO engine
    val client = HttpClient(CIO) {
        defaultRequest {
            url("https://api.n-eskone.com/")
//            url("http://localhost:8080/")
            contentType(ContentType.Application.Json)
            headers {
                authorization?.let {
                    append(HttpHeaders.Authorization, "Bearer ${it.accessToken}")
                }
            }
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
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }

    val authenticationService = AuthenticationService(client)
    val mediaService = MediaService(client)
    val estatesService = EstatesService(client)

    try {
        authorization = authenticationService.login(
            CredentialsDto(
                username = "hamani_khalil@yahoo.fr",
                password = "!sEcurity23"
            )
        )

        val files = listOf(
            File("/Users/khalilperso/Documents/projects/n/products/n-eskone/assets/seeds/houses/pexels-binyaminmellish-106399.jpg"),
            File("/Users/khalilperso/Documents/projects/n/products/n-eskone/assets/seeds/houses/pexels-expect-best-79873-323780.jpg"),
            File("/Users/khalilperso/Documents/projects/n/products/n-eskone/assets/seeds/houses/pexels-pixabay-280229.jpg"),
        )
        val images = files.associate { it.name to it.readBytes() }

//        val media = mediaService.upload(authorization?.accessToken ?: "", file.name, image)
//        val media = mediaService.upload(file.name, image)
        val media = estatesService.upload(
            id = "a8805a82-2532-4c94-82bd-bacc52d6ada3",
            images = images
        )

        media.forEach { println(it) }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        client.close()
    }
}
