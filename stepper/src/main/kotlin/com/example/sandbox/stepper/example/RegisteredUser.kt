package com.example.sandbox.stepper.example

import com.example.sandbox.stepper.core.AggregationResult
import com.example.sandbox.stepper.core.StepContent

@AggregationResult
data class RegisteredUser(
    @StepContent(name = "credentials")
    val credentials: Credentials,
    @StepContent(name = "profile")
    val profile: Profile,
)