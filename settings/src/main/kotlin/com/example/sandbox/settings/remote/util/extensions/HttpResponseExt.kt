package com.example.sandbox.settings.remote.util.extensions

import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*


suspend inline fun <reified T> HttpResponse.bodyOrThrow(): T =
    when {
        status.isSuccess() -> body()
        else -> throw status.asNetException()
    }

