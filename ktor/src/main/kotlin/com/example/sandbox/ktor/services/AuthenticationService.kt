package com.example.sandbox.ktor.services

import com.example.sandbox.ktor.models.AuthorizationDto
import com.example.sandbox.ktor.models.CredentialsDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class AuthenticationService(
    private val client: HttpClient,
) : MicroService() {

    override val name: String = "ms-auth"

    suspend fun login(credentials: CredentialsDto): AuthorizationDto? =
        client.post("$name/login") {
            setBody(credentials)
        }
            .body() as? AuthorizationDto

}