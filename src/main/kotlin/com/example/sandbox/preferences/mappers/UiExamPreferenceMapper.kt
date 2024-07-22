package com.example.sandbox.preferences.mappers

import com.example.sandbox.preferences.models.ExamPreference
import com.example.sandbox.preferences.ui.UiExamPreference
import com.example.sandbox.preferences.util.ModelMapper

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