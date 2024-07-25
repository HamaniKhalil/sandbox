package com.example.sandbox.settings

import com.example.sandbox.settings.remote.mappers.ExamPreferenceDtoMapper
import com.example.sandbox.settings.ui.mappers.UiExamPreferenceMapper
import com.example.sandbox.settings.domain.models.ExamPreferenceType.*
import com.example.sandbox.settings.remote.services.ExamPreferencesService
import com.example.sandbox.settings.remote.services.client
import kotlinx.coroutines.runBlocking
import kotlin.reflect.typeOf

fun main() {
    println("==================================")
    println("||\t\t\tSettings\t\t\t||")
    println("==================================")

    val service = ExamPreferencesService(client)
    runBlocking {
        val dtos = service.getAll()

        dtos.forEach {
            println(it)
        }

        val dtoMapper = ExamPreferenceDtoMapper()
        val uiMapper = UiExamPreferenceMapper()

        val domainSettings = dtos
            .map(dtoMapper::from)

        domainSettings
            .forEach {
                println(it)
            }

        domainSettings
            .map(uiMapper::to)
            .forEach {
                println(it)
            }

    }
}