package com.example.sandbox.settings.remote.util.exceptions

class NetOperationUnavailableException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "Network call failed for because the operation is unavailable"
    }
}