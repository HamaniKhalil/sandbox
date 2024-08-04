package com.example.sandbox.stepper.core

class Milestone<S>(
    val support: S,
    var next: Milestone<S>? = null,
)