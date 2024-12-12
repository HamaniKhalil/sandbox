package org.example.sandbox.chat.services

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.http.*
import io.ktor.websocket.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.*


class WebsocketClientService(
    private val client: HttpClient = HttpClient(CIO) {
        install(WebSockets)
    },
) {
    private lateinit var out: SendChannel<Frame>

    fun connectToServer(id: Int): Flow<String> = flow {
        client.webSocket(
            method = HttpMethod.Get,
            host = "localhost",
            port = 2000,
            path = "/chat/$id",
        ) {
            println("Attempting connection")
            out = outgoing
            incoming.receiveAsFlow()
                .flowOn(Dispatchers.IO)
                .filter { it is Frame.Text }
                .collect {
                    it as? Frame.Text ?: throw IllegalStateException("AAAAAAAAAAAA")
                    emit(it.readText())
                }
        }
    }

    suspend fun send(message: String) {
        out.send(Frame.Text(message))
    }
}