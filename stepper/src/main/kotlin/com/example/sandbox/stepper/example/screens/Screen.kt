package com.example.sandbox.stepper.example.screens

import com.example.sandbox.stepper.core.Stepper

abstract class Screen {

    abstract val name: String

    protected lateinit var stepper: Stepper<*>

    open fun attachToStepper(stepper: Stepper<*>) {
        this.stepper = stepper
    }

    open fun render() {
        println("||==================================||")
        println("||\t\t\t$name screen\t\t\t||")
        println("||==================================||")
    }


}