package com.example.sandbox.settings.util

interface FromStorageIdRetriever<T> {
    fun fromStorageId(id: Int): T
}