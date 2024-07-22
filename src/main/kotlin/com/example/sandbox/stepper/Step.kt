package com.example.sandbox.stepper

class Step<T, S>(
    @StepContent("content")
    val content: T,
    val milestone: Milestone<S>,
)