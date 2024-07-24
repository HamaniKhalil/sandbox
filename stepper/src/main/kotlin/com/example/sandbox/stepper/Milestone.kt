package com.example.sandbox.stepper

class Milestone<S>(
    val support: S,
    var next: Milestone<S>?,
)