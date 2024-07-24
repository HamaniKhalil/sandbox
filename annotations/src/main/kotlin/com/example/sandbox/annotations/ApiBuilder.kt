package com.example.sandbox.annotations

import java.lang.reflect.Proxy


class ApiBuilder {

    inline fun <reified T> create(): T =
        Proxy.newProxyInstance(
            T::class.java.classLoader,
            arrayOf(T::class.java),
            ApiInvocationHandler(),
        ) as T

}