package com.example.sandbox.settings.ui

import com.example.sandbox.settings.models.ExamPreferenceType

data class UiExamPreference<T>(
    val id: Int,
    val type: ExamPreferenceType,
    val value: T,
)