package com.example.sandbox.settings.remote.dtos

import com.example.sandbox.settings.remote.util.serializers.SettingValueSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExamPreferenceDto(
    @SerialName("id")
    val id: Int,
    @SerialName("type")
    val type: Int,
    @Serializable(with = SettingValueSerializer::class)
    @SerialName("value")
    val value: Any,
)