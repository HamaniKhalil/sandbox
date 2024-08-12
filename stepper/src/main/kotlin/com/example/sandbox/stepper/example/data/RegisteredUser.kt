package com.example.sandbox.stepper.example.data

import com.example.sandbox.stepper.core.AggregationResult
import com.example.sandbox.stepper.core.StepContent
import kotlinx.serialization.Serializable

@AggregationResult
@Serializable
data class RegisteredUser(
    @StepContent(name = "credentials")
    val credentials: Credentials,
    @StepContent(name = "profile")
    val profile: Profile,
)