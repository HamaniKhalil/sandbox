package com.example.sandbox.settings.remote.util.exceptions

class NetUnauthorizedException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "401: The server answered with unauthorized"
    }
}