package org.example.sandbox.chat.app.server

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


// Server
fun main() = application {
    val windowState = rememberWindowState()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Chat",
        state = windowState,
    ) {
        ServerApp()
    }
}
