package com.example.sandbox.preferences.ui

import com.example.sandbox.preferences.models.ExamPreferenceType

data class UiExamPreference<T>(
    val id: Int,
    val type: ExamPreferenceType,
    val value: T,
)