package com.example.sandbox.settings.domain.types

import com.example.sandbox.settings.util.FromStorageIdRetriever
import com.example.sandbox.settings.util.StorageIdHolder

enum class NearVisionOptotype(override val storageId: Int) : StorageIdHolder {
    ROTARY(1),
    PARINAUD(2),
    ;
    companion object : FromStorageIdRetriever<NearVisionOptotype> {
        override fun fromStorageId(id: Int): NearVisionOptotype =
            entries.first { it.storageId == id }
    }
}