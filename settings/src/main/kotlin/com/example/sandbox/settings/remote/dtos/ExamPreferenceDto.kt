package com.example.sandbox.settings.remote.dtos

import com.example.sandbox.settings.domain.models.ExamPreferenceType

data class ExamPreferenceDto<T>(
    val id: Int,
    val type: ExamPreferenceType,
    val value: T,
)