package com.example.sandbox.settings.ui.model

import com.example.sandbox.settings.domain.models.ExamPreferenceType

data class UiExamPreference<T>(
    val id: Int,
    val type: ExamPreferenceType,
    val value: T,
)