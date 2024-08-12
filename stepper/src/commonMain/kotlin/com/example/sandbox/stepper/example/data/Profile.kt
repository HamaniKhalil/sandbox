package com.example.sandbox.stepper.example.data

import com.example.sandbox.stepper.core.StepContent
import kotlinx.serialization.Serializable

@StepContent("profile")
@Serializable
data class Profile(
    @StepContent(name = "firstname")
    val firstname: String,
    @StepContent(name = "lastname")
    val lastname: String,
    @StepContent(name = "age")
    val age: Int,
)
