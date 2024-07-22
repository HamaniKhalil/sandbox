package com.example.sandbox.preferences.types

import com.example.sandbox.preferences.util.FromStorageIdRetriever
import com.example.sandbox.preferences.util.StorageIdHolder

enum class BiocularMethod(override val storageId: Int) : StorageIdHolder {
    POLARIZATION(1),
    ALTERNATE_OCCLUSION(2),
    ;

    companion object : FromStorageIdRetriever<BiocularMethod> {
        override fun fromStorageId(id: Int): BiocularMethod =
            entries.first { it.storageId == id }
    }
}