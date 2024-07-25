package com.example.sandbox.settings.remote.util.exceptions

import java.net.HttpURLConnection


/**
 * In the current project, some HTTP errors are returned by the server that are not found,
 * in the classic @[HttpURLConnection] class.
 * In order to have homogenous use of HTTP error codes, the following object.
 */
object HttpError {

    const val HTTP_BAD_REQUEST = HttpURLConnection.HTTP_BAD_REQUEST
    const val HTTP_UNAUTHORIZED = HttpURLConnection.HTTP_UNAUTHORIZED
    const val HTTP_FORBIDDEN = HttpURLConnection.HTTP_FORBIDDEN
    const val HTTP_NOT_FOUND = HttpURLConnection.HTTP_NOT_FOUND
    const val HTTP_INTERNAL_ERROR = HttpURLConnection.HTTP_INTERNAL_ERROR
    const val HTTP_UNPROCESSABLE_CONTENT = 422
}