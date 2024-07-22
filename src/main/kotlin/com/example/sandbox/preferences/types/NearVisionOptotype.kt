package com.example.sandbox.preferences.types

import com.example.sandbox.preferences.util.FromStorageIdRetriever
import com.example.sandbox.preferences.util.StorageIdHolder

enum class NearVisionOptotype(override val storageId: Int) : StorageIdHolder {
    ROTARY(1),
    PARINAUD(2),
    ;
    companion object : FromStorageIdRetriever<NearVisionOptotype> {
        override fun fromStorageId(id: Int): NearVisionOptotype =
            entries.first { it.storageId == id }
    }
}