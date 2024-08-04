package com.example.sandbox.stepper.example

import com.example.sandbox.stepper.core.Milestone
import com.example.sandbox.stepper.core.Stepper
import com.example.sandbox.stepper.example.data.RegisteredUser
import com.example.sandbox.stepper.example.screens.LoginScreen
import com.example.sandbox.stepper.example.screens.ProfileScreen
import com.example.sandbox.stepper.example.screens.Screen


fun main() {

    val profileScreen = ProfileScreen()
    val profile = Milestone<Screen>(support = profileScreen)

    val loginScreen = LoginScreen()
    val login = Milestone(
        support = loginScreen,
        next = profile,
    )

    val roadmap = Stepper.RoadmapBuilder<Screen>()
        .addMilestone(login)
        .addMilestone(profile)
        .build()

    val stepper = Stepper(roadmap)

    profileScreen.attachToStepper(stepper)
    loginScreen.attachToStepper(stepper)

    while (!stepper.isLast) {
        stepper.current.support.render()
    }

    println(stepper.aggregate<RegisteredUser>())

}