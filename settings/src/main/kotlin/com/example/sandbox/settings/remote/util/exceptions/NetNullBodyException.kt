package com.example.sandbox.settings.remote.util.exceptions

class NetNullBodyException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "The response body should not be null"
    }
}