package org.example.sandbox.chat.app.client

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.sandbox.chat.app.client.screens.ChatScreen
import org.example.sandbox.chat.app.client.screens.ChatViewModel

@Composable
fun ClientApp() {
    val viewModel = viewModel { ChatViewModel() }

    ChatScreen(
        messages = viewModel.content,
        onSend = viewModel::send,
        onStartChat = viewModel::connectToServer,
    )
}