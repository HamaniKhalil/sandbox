package com.example.sandbox.annotations

interface TestService {

    @Get("this is the test method")
    fun test(@Body a: String = ""): String {
        println("test method")
        return "tttt"
    }

}