package com.example.sandbox.stepper.example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.sandbox.stepper.core.Milestone
import com.example.sandbox.stepper.core.Stepper
import com.example.sandbox.stepper.example.data.Credentials
import com.example.sandbox.stepper.example.data.Profile
import com.example.sandbox.stepper.example.data.RegisteredUser
import com.example.sandbox.stepper.example.screens.LoginScreen
import com.example.sandbox.stepper.example.screens.ProfileScreen
import com.example.sandbox.stepper.example.screens.RegistrationScreen
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement


val registrationTransformer: (Json, Any) -> JsonElement = { json, obj ->
    when (obj) {
        is Credentials -> json.encodeToJsonElement(obj)
        is Profile -> json.encodeToJsonElement(obj)
        else -> throw IllegalArgumentException("")
    }
}

@Composable
fun App() {

    val roadmap = Stepper.RoadmapBuilder<RegistrationScreen>()
        .addMilestones(RegistrationScreen.entries.map { Milestone(it) })
        .build()

    val stepper = remember { Stepper(roadmap, registrationTransformer) }
    val current by remember { stepper.current }

    when (current?.support) {
        RegistrationScreen.LOGIN -> {
            LoginScreen(
                state = stepper.currentStep?.content as? Credentials,
                onNext = { stepper.next(it) }
            )
        }

        RegistrationScreen.PROFILE -> {
            ProfileScreen(
                state = stepper.currentStep?.content as? Profile?,
                onNext = {
                    stepper.next(it)
                    println(stepper.aggregate<RegisteredUser>())
                },
                onPrevious = { stepper.previous() }
            )
        }

        else -> Unit
    }
}