package com.example.sandbox.stepper.core

import kotlinx.serialization.Serializable

@Serializable
class Milestone<S>(
    val support: S,
    var next: Milestone<S>? = null,
)