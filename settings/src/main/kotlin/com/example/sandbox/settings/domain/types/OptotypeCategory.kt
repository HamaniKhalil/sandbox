package com.example.sandbox.settings.domain.types

import com.example.sandbox.settings.util.FromStorageIdRetriever
import com.example.sandbox.settings.util.StorageIdHolder

enum class OptotypeCategory(override val storageId: Int) : StorageIdHolder {
    LETTER(1),
    SNELLEN(2),
    ;

    companion object : FromStorageIdRetriever<OptotypeCategory> {
        override fun fromStorageId(id: Int): OptotypeCategory =
            entries.first { it.storageId == id }
    }
}