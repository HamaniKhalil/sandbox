package com.example.sandbox.settings.remote.util.exceptions

class NetBadRequestException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "400: The server answered with bad request"
    }
}