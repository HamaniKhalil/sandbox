package com.example.sandbox.ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AuthorizationDto(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("expires_in")
    val expiresIn: Int,
)
