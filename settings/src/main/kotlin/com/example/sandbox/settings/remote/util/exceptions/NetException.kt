package com.example.sandbox.settings.remote.util.exceptions

import com.example.sandbox.settings.remote.util.exceptions.ApiError

abstract class NetException(
    override var message: String,
    var error: ApiError? = null,
) : Exception(message)