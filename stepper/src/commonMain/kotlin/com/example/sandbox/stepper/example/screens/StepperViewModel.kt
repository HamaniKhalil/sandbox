package com.example.sandbox.stepper.example.screens

import com.example.sandbox.stepper.core.Stepper

abstract class StepperViewModel<T> {

    abstract val stepper: Stepper<*>

    abstract fun next(content: T)

    abstract fun previous()
}