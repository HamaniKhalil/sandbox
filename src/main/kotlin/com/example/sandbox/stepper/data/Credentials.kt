package com.example.sandbox.stepper.data

import com.example.sandbox.stepper.StepContent

data class Credentials(
    @StepContent(name = "username")
    val username: String,
    @StepContent(name = "password")
    val password: String,
)
