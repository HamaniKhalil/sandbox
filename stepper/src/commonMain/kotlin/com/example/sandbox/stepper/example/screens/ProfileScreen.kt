package com.example.sandbox.stepper.example.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sandbox.stepper.example.data.Profile

@Composable
fun ProfileScreen(
    state: Profile?,
    onNext: (Profile) -> Unit,
    onPrevious: () -> Unit,
) {

    var firstname by remember { mutableStateOf(state?.firstname ?: "") }
    var lastname by remember { mutableStateOf(state?.lastname ?: "") }
    var age by remember { mutableStateOf(state?.age?.toString() ?: "") }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            TextField(
                value = firstname,
                onValueChange = { firstname = it },
                placeholder = { Text("Firstname") }
            )
            TextField(
                value = lastname,
                onValueChange = { lastname = it },
                placeholder = { Text("Lastname") }
            )
            TextField(
                value = age,
                onValueChange = { age = it },
                placeholder = { Text("Age") }
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    onClick = onPrevious
                ) {
                    Text("Previous")
                }
                Button(
                    onClick = {
                        val profile = Profile(
                            firstname = firstname,
                            lastname = lastname,
                            age = age.toIntOrNull() ?: 0,
                        )
                        onNext(profile)
                    }
                ) {
                    Text("Next")
                }
            }
        }
    }
}