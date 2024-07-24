package com.example.sandbox.settings.dtos

import com.example.sandbox.settings.models.ExamPreferenceType

data class ExamPreferenceDto<T>(
    val id: Int,
    val type: ExamPreferenceType,
    val value: T,
)