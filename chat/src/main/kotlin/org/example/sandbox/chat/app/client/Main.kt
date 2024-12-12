package org.example.sandbox.chat.app.client

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


// Client
fun main() = application {
    val windowState = rememberWindowState()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Chat",
        state = windowState,
    ) {
        ClientApp()
    }
}
