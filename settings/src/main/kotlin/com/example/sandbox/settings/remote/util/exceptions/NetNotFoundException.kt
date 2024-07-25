package com.example.sandbox.settings.remote.util.exceptions

class NetNotFoundException(
    override var message: String = MESSAGE
) : NetException(message) {

    companion object {
        const val MESSAGE = "404: Fetched resource is not found on server"
    }
}