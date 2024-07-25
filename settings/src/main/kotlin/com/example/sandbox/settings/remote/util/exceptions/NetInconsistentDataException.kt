package com.example.sandbox.settings.remote.util.exceptions

class NetInconsistentDataException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "The response body contains inconsistent data"
    }
}