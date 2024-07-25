package com.example.sandbox.settings.remote.util.exceptions

class NetUnprocessableContentException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "422: The server answered with unprocessable content error"
    }
}