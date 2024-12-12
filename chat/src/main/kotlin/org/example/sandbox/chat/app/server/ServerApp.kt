package org.example.sandbox.chat.app.server

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.sandbox.chat.app.server.screens.ServerScreen
import org.example.sandbox.chat.app.server.screens.ServerScreenViewModel

@Composable
fun ServerApp() {

    val viewModel = viewModel { ServerScreenViewModel() }

    ServerScreen(
        onStartServer = viewModel::startServer
    )
}