package com.example.sandbox.settings.models

import com.example.sandbox.settings.types.BiocularMethod
import com.example.sandbox.settings.types.NearVisionOptotype
import com.example.sandbox.settings.util.FromStorageIdRetriever
import com.example.sandbox.settings.util.StorageIdHolder

enum class ExamPreferenceType(override val storageId: Int, val options: Set<Any>) : StorageIdHolder {
    BIOCULAR_METHOD(1, BiocularMethod.entries.toSet()),
    NEAR_VISION_OPTOTYPE(2, NearVisionOptotype.entries.toSet()),
    READ_GREEN_TEST(3, emptySet()),
    ;

    companion object : FromStorageIdRetriever<ExamPreferenceType> {

        override fun fromStorageId(id: Int): ExamPreferenceType =
            entries.first { it.storageId == id }

    }
}