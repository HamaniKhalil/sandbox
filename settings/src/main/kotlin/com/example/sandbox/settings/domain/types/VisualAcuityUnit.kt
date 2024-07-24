package com.example.sandbox.settings.domain.types

import com.example.sandbox.settings.util.FromStorageIdRetriever
import com.example.sandbox.settings.util.StorageIdHolder

enum class VisualAcuityUnit(override val storageId: Int) : StorageIdHolder {
    DECIMAL(1),
    FRACTION_10(2),
    SNELLEN_20FT(3),
    SNELLEN_6M(4),
    LOG_MAR(5),
    ;

    companion object : FromStorageIdRetriever<VisualAcuityUnit> {
        override fun fromStorageId(id: Int): VisualAcuityUnit =
            entries.first { it.storageId == id }
    }
}