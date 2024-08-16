package com.example.sandbox.stepper.example.data

import com.example.sandbox.stepper.core.StepContent

@StepContent("credentials")
data class Credentials(
    @StepContent(name = "username")
    val username: String,
    @StepContent(name = "password")
    val password: String,
)