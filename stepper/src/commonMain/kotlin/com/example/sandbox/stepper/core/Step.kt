package com.example.sandbox.stepper.core

class Step<T, S>(
    @StepContent("content")
    val content: T,
    val milestone: Milestone<S>,
)