package com.example.sandbox.stepper

import com.example.sandbox.stepper.data.Credentials
import com.example.sandbox.stepper.data.Profile
import com.example.sandbox.stepper.data.RegisteredUser


fun main() {

    val profile = Milestone(
        support = "profile",
        next = null,
    )
    val login = Milestone(
        support = "login",
        next = profile,
    )
    val roadmap = Stepper.RoadmapBuilder<String>()
        .addMilestone(login)
        .addMilestone(profile)
        .build()

    val stepper = Stepper(roadmap)

    stepper.next(
        Step(
            content = Credentials(
                username = "user",
                password = "pass"
            ),
            milestone = login,
        ),
    )
    stepper.next(
        Step(
            content = Profile(
                firstname = "First",
                lastname = "Last",
                age = 20,
            ),
            milestone = profile,
        )
    )

    println(stepper.aggregate<RegisteredUser>())

    println(stepper.current.support)
    stepper.previous()
    println(stepper.current.support)
}