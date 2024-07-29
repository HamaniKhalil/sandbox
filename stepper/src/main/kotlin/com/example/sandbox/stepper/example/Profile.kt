package com.example.sandbox.stepper.example

import com.example.sandbox.stepper.core.StepContent

data class Profile(
    @StepContent(name = "firstname")
    val firstname: String,
    @StepContent(name = "lastname")
    val lastname: String,
    @StepContent(name = "age")
    val age: Int,
)
