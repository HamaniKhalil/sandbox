package com.example.sandbox.ktor.services

import com.example.sandbox.ktor.models.Authorization
import com.example.sandbox.ktor.models.Credentials
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class AuthenticationService(
    private val client: HttpClient,
) : MicroService() {

    override val name: String = "ms-auth"

    suspend fun login(credentials: Credentials): Authorization? =
        client.post("$name/login") {
            setBody(credentials)
        }
            .body() as? Authorization

}