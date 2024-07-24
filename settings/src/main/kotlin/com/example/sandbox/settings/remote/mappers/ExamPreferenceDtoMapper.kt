package com.example.sandbox.settings.remote.mappers

import com.example.sandbox.settings.remote.dtos.ExamPreferenceDto
import com.example.sandbox.settings.domain.models.ExamPreference
import com.example.sandbox.settings.util.ModelMapper

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