package com.example.sandbox.settings.remote.services

import com.example.sandbox.settings.remote.dtos.ExamPreferenceDto
import com.example.sandbox.settings.remote.util.extensions.bodyOrThrow
import com.siviewtech.data.remote.settings.services.MS_SETTINGS
import io.ktor.client.*
import io.ktor.client.request.*

class ExamPreferencesService(
    // Authenticated
    val client: HttpClient,
) {

    suspend fun getAll(): List<ExamPreferenceDto> =
        client.get("$MS_SETTINGS/$ENDPOINT_NAME")
            .bodyOrThrow()


    suspend fun upload(preference: ExamPreferenceDto): ExamPreferenceDto =
        client.put("$MS_SETTINGS/$ENDPOINT_NAME") {
            setBody(preference)
        }
            .bodyOrThrow()


    companion object {
        const val ENDPOINT_NAME = "exam-preferences"
    }
}