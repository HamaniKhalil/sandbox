package com.example.sandbox.ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CredentialsDto(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,
)
