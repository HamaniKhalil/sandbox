package com.example.sandbox.stepper.core

import com.example.sandbox.stepper.Milestone

class Step<T, S>(
    @StepContent("content")
    val content: T,
    val milestone: Milestone<S>,
)