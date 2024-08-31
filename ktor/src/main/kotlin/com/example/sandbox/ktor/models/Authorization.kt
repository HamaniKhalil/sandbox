package com.example.sandbox.ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Authorization(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("expires_in")
    val expiresIn: Int,
)
