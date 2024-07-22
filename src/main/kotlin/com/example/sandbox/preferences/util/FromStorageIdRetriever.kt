package com.example.sandbox.preferences.util

interface FromStorageIdRetriever<T> {
    fun fromStorageId(id: Int): T
}