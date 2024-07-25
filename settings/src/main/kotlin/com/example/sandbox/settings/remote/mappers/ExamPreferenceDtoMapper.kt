package com.example.sandbox.settings.remote.mappers

import com.example.sandbox.settings.domain.models.ExamPreference
import com.example.sandbox.settings.domain.models.ExamPreferenceType
import com.example.sandbox.settings.remote.dtos.ExamPreferenceDto
import com.example.sandbox.settings.util.ModelMapper

class ExamPreferenceDtoMapper : ModelMapper<ExamPreference<Any>, ExamPreferenceDto> {
    override fun to(domain: ExamPreference<Any>): ExamPreferenceDto =
        ExamPreferenceDto(
            id = domain.id,
            type = domain.type.storageId,
            value = domain.value,
        )


    override fun from(destination: ExamPreferenceDto): ExamPreference<Any> =
        with(ExamPreferenceType.fromStorageId(destination.type)) {
            ExamPreference(
                id = destination.id,
                type = this,
                value = parseValue(destination.value),
            )
        }
}