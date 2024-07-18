package com.example.sandbox.annotations

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import kotlin.reflect.jvm.kotlinFunction

class ApiInvocationHandler : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        val annotation = method?.getAnnotation(Get::class.java)
            ?: throw IllegalStateException("You should add @Print annotation to your method ${method?.name}")

        println(annotation.value)
        args?.forEach {
            println(it)
        }

        return if (method.kotlinFunction?.isAbstract != true)
            "d"
        else "aaaa"
    }
}