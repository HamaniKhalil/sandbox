package org.example.sandbox.chat.app.client.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun ChatScreen(
    messages: List<String>,
    onSend: (String) -> Unit,
    onStartChat: (Int) -> Unit,
) {

    var currentMessage by remember { mutableStateOf("") }

    var id by remember { mutableStateOf("") }


    Surface {

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row {
                TextField(
                    value = id,
                    onValueChange = { id = it },
                )
                Button(
                    onClick = { onStartChat(id.toInt()) }
                ) {
                    Text("Start chat")
                }
            }

            LazyColumn {
                items(messages.size) {
                    Text(text = messages[it])
                }
            }

            Row {

                TextField(
                    value = currentMessage,
                    onValueChange = { currentMessage = it },
                )

                Button(
                    onClick = {
                        onSend(currentMessage)
                        currentMessage = ""
                    }
                ) {
                    Text(text = "Send")
                }
            }

        }

    }
}