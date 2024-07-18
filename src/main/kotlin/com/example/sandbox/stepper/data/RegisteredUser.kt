package com.example.sandbox.stepper.data

import com.example.sandbox.stepper.StepContent

@StepContent(name = "user")
data class RegisteredUser(
    @StepContent(name = "credentials")
    val credentials: Credentials,
    @StepContent(name = "profile")
    val profile: Profile,
)