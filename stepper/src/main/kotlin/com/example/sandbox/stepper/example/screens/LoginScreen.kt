package com.example.sandbox.stepper.example.screens

import com.example.sandbox.stepper.example.data.Credentials

class LoginScreen : Screen() {

    override val name: String = "Login"

    override fun render() {
        super.render()
        print("Username\t: ")
        val login = readln()
        print("Password\t: ")
        val password = readln()

        val credentials = Credentials(
            username = login,
            password = password,
        )

        stepper.next(credentials)
    }
}