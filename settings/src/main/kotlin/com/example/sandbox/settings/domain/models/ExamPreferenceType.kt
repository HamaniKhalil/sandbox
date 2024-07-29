package com.example.sandbox.settings.domain.models

import com.example.sandbox.settings.domain.types.*
import com.example.sandbox.settings.util.FromStorageIdRetriever
import com.example.sandbox.settings.util.StorageIdHolder

enum class ExamPreferenceType(override val storageId: Int, val options: Set<Any>) : StorageIdHolder {
    BIOCULAR_METHOD(1, BiocularMethod.entries.toSet()),
    RED_GREEN_TEST(2, emptySet()),
    EXAM_DURATION_DISPLAY(3, emptySet()),
    CYLINDER_DISPLAY(4, CylinderDisplay.entries.toSet()),
    ACUITY_UNIT(5, VisualAcuityUnit.entries.toSet()),
    NEAR_VISION_OPTOTYPE(6, NearVisionOptotype.entries.toSet()),
    FAR_VISION_OPTOTYPE(7, OptotypeCategory.entries.toSet()),
    ;

    fun formatValue(value: Any): Any =
        when (this) {
            BIOCULAR_METHOD, CYLINDER_DISPLAY, ACUITY_UNIT, NEAR_VISION_OPTOTYPE, FAR_VISION_OPTOTYPE ->
                (value as StorageIdHolder).storageId
            EXAM_DURATION_DISPLAY -> value as Boolean
            RED_GREEN_TEST -> value as Boolean
        }

    fun parseValue(value: Any): Any =
        when (this) {
            BIOCULAR_METHOD -> BiocularMethod.fromStorageId(value as Int)
            CYLINDER_DISPLAY -> CylinderDisplay.fromStorageId(value as Int)
            ACUITY_UNIT -> VisualAcuityUnit.fromStorageId(value as Int)
            NEAR_VISION_OPTOTYPE -> NearVisionOptotype.fromStorageId(value as Int)
            FAR_VISION_OPTOTYPE -> OptotypeCategory.fromStorageId(value as Int)
            EXAM_DURATION_DISPLAY -> value as Boolean
            RED_GREEN_TEST -> value as Boolean
        }

    companion object : FromStorageIdRetriever<ExamPreferenceType> {

        override fun fromStorageId(id: Int): ExamPreferenceType =
            entries.first { it.storageId == id }

    }
}