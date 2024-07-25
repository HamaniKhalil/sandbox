package com.example.sandbox.settings.remote.util.exceptions

class NetTooManyRequestsException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "429: The server answered with too many requests error"
    }
}