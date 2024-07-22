package com.example.sandbox.preferences.models

import com.example.sandbox.preferences.types.BiocularMethod
import com.example.sandbox.preferences.types.NearVisionOptotype
import com.example.sandbox.preferences.util.FromStorageIdRetriever
import com.example.sandbox.preferences.util.StorageIdHolder

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