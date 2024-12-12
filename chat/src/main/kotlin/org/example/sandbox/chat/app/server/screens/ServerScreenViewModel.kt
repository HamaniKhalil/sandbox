package org.example.sandbox.chat.app.server.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.example.sandbox.chat.services.WebsocketServerService

class ServerScreenViewModel : ViewModel() {

    private val websocketService: WebsocketServerService = WebsocketServerService()

    fun startServer() {
        viewModelScope.launch(Dispatchers.IO) {
            websocketService.startServer()
        }
    }

}