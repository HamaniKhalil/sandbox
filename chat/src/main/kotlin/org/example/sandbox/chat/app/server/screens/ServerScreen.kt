package org.example.sandbox.chat.app.server.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun ServerScreen(
    onStartServer: (Int) -> Unit,
) {

    var id by remember { mutableStateOf("") }

    Surface {

        Column {
            TextField(
                value = id,
                onValueChange = { id = it }
            )
            Button(
                onClick = { onStartServer(id.toInt()) }
            ) {
                Text("Start server")
            }
        }

    }
}