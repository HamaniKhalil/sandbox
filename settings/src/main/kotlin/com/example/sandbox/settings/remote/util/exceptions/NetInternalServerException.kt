package com.example.sandbox.settings.remote.util.exceptions

class NetInternalServerException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "500: The server answered with internal error"
    }
}