package com.example.sandbox.settings.types

import com.example.sandbox.settings.util.FromStorageIdRetriever
import com.example.sandbox.settings.util.StorageIdHolder

enum class CylinderDisplay(override val storageId: Int) : StorageIdHolder {
    NEGATIVE(1),
    POSITIVE(2),
    ;

    companion object : FromStorageIdRetriever<CylinderDisplay> {
        override fun fromStorageId(id: Int): CylinderDisplay =
            entries.first { it.storageId == id }
    }
}