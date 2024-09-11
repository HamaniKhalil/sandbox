package com.example.sandbox.ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaDto(
    @SerialName("id")
    val id: String,
    @SerialName("related_to")
    val relatedTo: String?,
)