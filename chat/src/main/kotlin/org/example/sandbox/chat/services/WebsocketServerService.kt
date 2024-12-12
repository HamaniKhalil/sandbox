package org.example.sandbox.chat.services

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.flow.receiveAsFlow


class WebsocketServerService {

    private val sessions = mutableSetOf<DefaultWebSocketServerSession>()

    fun startServer() {

        embeddedServer(Netty, port = 2000) {
            install(WebSockets)

            routing {
                get("/") {
                    call.respondText("Hello world")
                }

                webSocket("/chat/{id}") {
                    val id = call.parameters["id"] ?: "Unknown"
                    println("Connected with id : $id")
                    sessions += this

                    runCatching {
                        while (true) {
                            incoming
                                .receiveAsFlow()
                                .collect { frame ->
                                    when (frame) {
                                        is Frame.Text -> {
                                            val messageResponse = frame.readText()
                                            sessions
                                                .filterNot { it == this }
                                                .forEach {
                                                    it.send(messageResponse)
                                                }
                                        }

                                        else -> {
                                            println("Received this frame $frame")
                                        }
                                    }
                                }
                        }
                    }.onFailure { exception ->
                        println("WebSocket exception: ${exception.localizedMessage}")
                    }
                }
            }
        }
            .start(wait = true)
    }

}