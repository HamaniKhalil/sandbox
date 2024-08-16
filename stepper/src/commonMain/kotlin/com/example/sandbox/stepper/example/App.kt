package com.example.sandbox.stepper.example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.sandbox.stepper.core.Milestone
import com.example.sandbox.stepper.core.Stepper
import com.example.sandbox.stepper.example.data.Credentials
import com.example.sandbox.stepper.example.data.Profile
import com.example.sandbox.stepper.example.data.RegisteredUser
import com.example.sandbox.stepper.example.screens.RegistrationScreen
import com.example.sandbox.stepper.example.screens.login.LoginScreen
import com.example.sandbox.stepper.example.screens.login.LoginViewModel
import com.example.sandbox.stepper.example.screens.profile.ProfileScreen
import com.example.sandbox.stepper.example.screens.profile.ProfileViewModel
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
    val current by stepper.current.collectAsState(null)

    val loginViewModel = LoginViewModel(stepper)
    val profileViewModel = ProfileViewModel(stepper)

    when (current?.support) {
        RegistrationScreen.LOGIN -> {
            LoginScreen(
                state = stepper.currentStep?.content as? Credentials,
                onNext = loginViewModel::next,
            )
        }

        RegistrationScreen.PROFILE -> {
            ProfileScreen(
                state = stepper.currentStep?.content as? Profile?,
                onNext = {
                    profileViewModel.next(it)
                    println(stepper.aggregate<RegisteredUser>())
                },
                onPrevious = profileViewModel::previous
            )
        }

        else -> Unit
    }
}