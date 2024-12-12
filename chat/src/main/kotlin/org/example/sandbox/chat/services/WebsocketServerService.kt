package org.example.sandbox.chat.services

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*


class WebsocketServerService {

    fun startServer(id: Int) {

        embeddedServer(Netty, port = 2000) {
            install(WebSockets)

            routing {
                get("/") {
                    call.respondText("Hello world")
                }

                webSocket("/chat/$id") {
                    println("Connected")
                    send("Please enter your name")
                    for (frame in incoming) {
                        frame as? Frame.Text ?: continue
                        val receivedText = frame.readText()
                        send(Frame.Text(receivedText))
                    }
                }
            }
        }
            .start(wait = true)
    }

}