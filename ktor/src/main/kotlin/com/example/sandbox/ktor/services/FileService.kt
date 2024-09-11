package com.example.sandbox.ktor.services

import java.io.File

class FileService {

    fun read(path: String): ByteArray =
        File(path)
            .readBytes()
}