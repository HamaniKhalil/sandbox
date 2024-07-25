package com.example.sandbox.settings.remote.util.exceptions

class NetForbiddenException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "403: The server answered with forbidden"
    }
}