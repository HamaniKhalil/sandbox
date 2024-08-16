package com.example.sandbox.stepper.example.screens.profile

import com.example.sandbox.stepper.core.Stepper
import com.example.sandbox.stepper.example.data.Profile
import com.example.sandbox.stepper.example.screens.StepperViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileViewModel(override val stepper: Stepper<*>) : StepperViewModel<Profile>() {

    @OptIn(DelicateCoroutinesApi::class)
    override fun next(content: Profile) {
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