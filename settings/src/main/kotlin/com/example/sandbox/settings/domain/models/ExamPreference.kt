package com.example.sandbox.settings.domain.models

data class ExamPreference<T>(
    val id: Int,
    val type: ExamPreferenceType,
    val value: T,
)