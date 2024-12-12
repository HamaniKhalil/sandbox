package org.example.sandbox.chat.app.client.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.example.sandbox.chat.app.client.websocketService

class ChatViewModel : ViewModel() {


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
            content.add(message)
        }
    }
}