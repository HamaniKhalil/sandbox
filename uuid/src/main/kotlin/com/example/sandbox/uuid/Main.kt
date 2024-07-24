package com.example.sandbox.uuid

import java.util.*
import kotlin.experimental.and
import kotlin.experimental.or
import kotlin.random.Random

fun main() {
    println(UUID.randomUUID())
    println(Uuid.random())
}

class Uuid private constructor(
    private val data: ByteArray
) {

    @OptIn(ExperimentalStdlibApi::class)
    override fun toString(): String = buildString{
        append(data.copyOfRange(0, 4).toHexString())
        append("-")
        append(data.copyOfRange(4, 6).toHexString())
        append("-")
        append(data.copyOfRange(6, 8).toHexString())
        append("-")
        append(data.copyOfRange(8, 10).toHexString())
        append("-")
        append(data.copyOfRange(10, 16).toHexString())
    }

    companion object {

        fun random(): Uuid {
            val bytes = Random.nextBytes(16)
            bytes[6] = bytes[6] and 0x0f /* clear version        */
            bytes[6] = bytes[6] or 0x40 /* set to version 4     */
            bytes[8] = bytes[8] and 0x3f /* clear variant        */
            bytes[8] = bytes[8] or 0x80.toByte() /* set to IETF variant  */
            return Uuid(bytes)
        }
    }
}