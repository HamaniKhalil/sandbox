package com.example.sandbox.settings.models

data class ExamPreference<T>(
    val id: Int,
    val type: ExamPreferenceType,
    val value: T,
)