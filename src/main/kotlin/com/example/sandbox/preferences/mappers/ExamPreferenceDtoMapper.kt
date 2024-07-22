package com.example.sandbox.preferences.mappers

import com.example.sandbox.preferences.dtos.ExamPreferenceDto
import com.example.sandbox.preferences.models.ExamPreference
import com.example.sandbox.preferences.util.ModelMapper

class ExamPreferenceDtoMapper : ModelMapper<ExamPreference<*>, ExamPreferenceDto<*>> {
    override fun to(domain: ExamPreference<*>): ExamPreferenceDto<*> =
        ExamPreferenceDto(
            id = domain.id,
            type = domain.type,
            value = domain.value,
        )


    override fun from(destination: ExamPreferenceDto<*>): ExamPreference<*> {
        val value = destination.value ?: throw IllegalStateException("")
        return ExamPreference(
            id = destination.id,
            type = destination.type,
            value = value,
        )
    }
}