package org.example.sandbox.chat.app.client

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.example.sandbox.chat.services.WebsocketClientService

val websocketService: WebsocketClientService = WebsocketClientService()

// Client
fun main() = application {
    val windowState = rememberWindowState()

    Window(
        onCloseRequest = {
            runBlocking(Dispatchers.IO) {
                websocketService.close()
                withContext(Dispatchers.Default) {
                    exitApplication()
                }
            }
        },
        title = "Chat",
        state = windowState,
    ) {
        ClientApp()
    }
}
