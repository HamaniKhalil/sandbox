package com.example.sandbox.serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun main() {
    val a = A()

    val empty = "{}"
    val notEmpty = "{\"a\": \"test\"}"

    val b = Test(a = "dddddd")
    println(b.parse())
    println(a.decode(notEmpty))


}


@Serializable
data class Test(
    val a: String
)


class A {

    inline fun <reified T> decode(value: String): T? =
        value.fromJson()
}

inline fun <reified T> T.parse(): String =
    Json.encodeToString(this)

inline fun <reified T> String.fromJson(): T? =
    try {
        Json.decodeFromString<T>(this)
    } catch (e: Exception) {
        null
    }