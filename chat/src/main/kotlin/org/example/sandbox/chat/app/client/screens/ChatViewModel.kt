package org.example.sandbox.chat.app.client.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.example.sandbox.chat.services.WebsocketClientService

class ChatViewModel : ViewModel() {

    private val websocketService: WebsocketClientService = WebsocketClientService()


    var content = mutableStateListOf<String>()

    fun connectToServer(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            websocketService.connectToServer(id)
                .collect {
                    content.add(it)
                }
        }
    }

    fun send(message: String) {
        viewModelScope.launch(Dispatchers.IO) {
            websocketService.send(message)
        }
    }
}