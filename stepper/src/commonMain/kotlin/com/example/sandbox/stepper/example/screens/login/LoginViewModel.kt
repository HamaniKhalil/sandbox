package com.example.sandbox.stepper.example.screens.login

import com.example.sandbox.stepper.core.Stepper
import com.example.sandbox.stepper.example.data.Credentials
import com.example.sandbox.stepper.example.screens.StepperViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginViewModel(override val stepper: Stepper<*>) : StepperViewModel<Credentials>() {

    @OptIn(DelicateCoroutinesApi::class)
    override fun next(content: Credentials) {
        GlobalScope.launch {
            stepper.next(content)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun previous() {
        GlobalScope.launch {
            stepper.previous()
        }
    }

}