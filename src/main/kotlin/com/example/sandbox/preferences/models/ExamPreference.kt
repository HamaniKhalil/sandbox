package com.example.sandbox.preferences.models

data class ExamPreference<T>(
    val id: Int,
    val type: ExamPreferenceType,
    val value: T,
)