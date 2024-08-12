package com.example.sandbox.stepper.example.data

import com.example.sandbox.stepper.core.StepContent
import kotlinx.serialization.Serializable

@StepContent("credentials")
@Serializable
data class Credentials(
    @StepContent(name = "username")
    val username: String,
    @StepContent(name = "password")
    val password: String,
)