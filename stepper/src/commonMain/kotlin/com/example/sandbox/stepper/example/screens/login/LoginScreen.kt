package com.example.sandbox.stepper.example.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sandbox.stepper.example.data.Credentials

@Composable
fun LoginScreen(
    state: Credentials?,
    onNext: (Credentials) -> Unit,
) {
    var username by remember { mutableStateOf(state?.username ?: "") }
    var password by remember { mutableStateOf(state?.password ?: "") }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 30.dp,
                alignment = Alignment.CenterVertically
            ),
        ) {
            TextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text("Username") }
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Password") }
            )
            Button(
                onClick = {
                    val credentials = Credentials(
                        username = username,
                        password = password,
                    )
                    onNext(credentials)
                }
            ) {
                Text("Next")
            }
        }
    }
}