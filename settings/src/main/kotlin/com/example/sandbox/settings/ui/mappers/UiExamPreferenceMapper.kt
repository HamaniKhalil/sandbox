package com.example.sandbox.settings.ui.mappers

import com.example.sandbox.settings.domain.models.ExamPreference
import com.example.sandbox.settings.ui.model.UiExamPreference
import com.example.sandbox.settings.util.ModelMapper

class UiExamPreferenceMapper : ModelMapper<ExamPreference<*>, UiExamPreference<*>> {
    override fun to(domain: ExamPreference<*>): UiExamPreference<*> =
        UiExamPreference(
            id = domain.id,
            type = domain.type,
            value = domain.value,
        )

    override fun from(destination: UiExamPreference<*>): ExamPreference<*> {
        val value = destination.value ?: throw IllegalStateException("")
        return ExamPreference(
            id = destination.id,
            type = destination.type,
            value = value,
        )
    }
}