package com.example.sandbox.annotations


fun main() {

    val service = ApiBuilder()
        .create<TestService>()

    val a = service.test("bababababababab")
    println(a)
}