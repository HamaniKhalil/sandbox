package com.example.sandbox.settings.remote.util.exceptions

class NetFailedException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "Network call failed for unknown reason"
    }
}