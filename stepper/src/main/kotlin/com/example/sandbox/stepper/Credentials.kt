package com.example.sandbox.stepper

data class Credentials(
    @StepContent(name = "username")
    val username: String,
    @StepContent(name = "password")
    val password: String,
)
