package com.example.sandbox.stepper.example.screens

import com.example.sandbox.stepper.example.data.Profile
import com.example.sandbox.stepper.example.screens.ProfileScreen.Action.BACK
import com.example.sandbox.stepper.example.screens.ProfileScreen.Action.CONTINUE

class ProfileScreen : Screen() {

    override val name: String = "Profile"

    override fun render() {
        super.render()

        print("Firstname\t: ")
        val firstname = readln()
        print("Lastname\t: ")
        val lastname = readln()
        print("Age\t\t\t: ")
        val age = readln().toInt()

        val profile = Profile(
            firstname = firstname,
            lastname = lastname,
            age = age,
        )

        var action: String
        do {
            print("Go back [b]\tContinue [C] : ")
            action = readln()

            if (action.isBlank()) action = CONTINUE.value

            when (Action.fromValue(action)) {
                CONTINUE -> stepper.next(profile)
                BACK -> stepper.previous()
                else -> println("Only ${Action.values} are allowed entries")
            }
        } while (action !in Action.values)
    }

    enum class Action(val value: String) {
        CONTINUE("c"),
        BACK("b"),
        ;

        companion object {
            val values = entries.map { it.value }

            fun fromValue(value: String): Action? =
                entries.firstOrNull { it.value == value }
        }
    }

}