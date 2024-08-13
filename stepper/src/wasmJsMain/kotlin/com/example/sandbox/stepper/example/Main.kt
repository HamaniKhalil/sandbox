package com.example.sandbox.stepper.example

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow


@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow("Stepper") {
        App()
    }

}