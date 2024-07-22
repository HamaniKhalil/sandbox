package com.example.sandbox.preferences

import com.example.sandbox.preferences.mappers.ExamPreferenceDtoMapper
import com.example.sandbox.preferences.mappers.UiExamPreferenceMapper
import com.example.sandbox.preferences.models.ExamPreference
import com.example.sandbox.preferences.models.ExamPreferenceType.*
import com.example.sandbox.preferences.types.BiocularMethod.ALTERNATE_OCCLUSION
import com.example.sandbox.preferences.types.NearVisionOptotype.PARINAUD

fun main() {
    println("==================================")
    println("||\t\t\tSettings\t\t\t||")
    println("==================================")

    val settings: MutableList<ExamPreference<*>> = mutableListOf()

    settings.add(
        ExamPreference(
            id = 1,
            type = READ_GREEN_TEST,
            value = false,
        )
    )
    settings.add(
        ExamPreference(
            id = 2,
            type = NEAR_VISION_OPTOTYPE,
            value = PARINAUD,
        )
    )
    settings.add(
        ExamPreference(
            id = 3,
            type = BIOCULAR_METHOD,
            value = ALTERNATE_OCCLUSION,
        )
    )

    settings.forEach {
        println(it)
        println(it.type.options)
    }

    val dtoMapper = ExamPreferenceDtoMapper()
    val uiMapper = UiExamPreferenceMapper()

    settings
        .map(dtoMapper::to)
        .forEach {
            println(it)
            println(it.type.options)
        }

    settings
        .map(uiMapper::to)
        .forEach {
            println(it)
            println(it.type.options)
        }
}