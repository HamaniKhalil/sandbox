package com.example.sandbox.stepper.example.screens

import com.example.sandbox.stepper.example.data.Profile

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

        stepper.next(profile)
    }
}