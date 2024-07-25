package com.example.sandbox.settings.remote.util.extensions

import com.example.sandbox.settings.remote.util.exceptions.*
import io.ktor.http.*


fun HttpStatusCode.asNetException(): NetException =
    when (this) {
        HttpStatusCode.BadRequest -> NetBadRequestException()
        HttpStatusCode.Unauthorized -> NetUnauthorizedException()
        HttpStatusCode.Forbidden -> NetForbiddenException()
        HttpStatusCode.UnprocessableEntity -> NetUnprocessableContentException()
        HttpStatusCode.TooManyRequests -> NetTooManyRequestsException()
        HttpStatusCode.InternalServerError -> NetInternalServerException()
        else -> NetFailedException()
    }