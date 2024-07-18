package com.example.sandbox.stepper

import com.example.sandbox.stepper.data.Credentials
import com.example.sandbox.stepper.data.Profile
import com.example.sandbox.stepper.data.RegisteredUser


fun main() {

    val aggregator = aggregatorFrom<RegisteredUser>()
    aggregator.addStep(
        Step(
            content = Credentials(
                username = "user",
                password = "pass"
            )
        )
    )
    aggregator.addStep(
        Step(
            content = Profile(
                firstname = "First",
                lastname = "Last",
                age = 20,
            )
        )
    )

//    println(aggregator.aggregate())
    println(aggregator.aggregate<RegisteredUser>())
}