package com.example.sandbox.stepper

import com.example.sandbox.stepper.data.RegisteredUser
import com.example.sandbox.stepper.data.RegistrationAggregator

@Suppress("UNCHECKED_CAST")
inline fun <reified R> aggregatorFrom(): Aggregator<R> =
    when(R::class) {
        RegisteredUser::class -> RegistrationAggregator() as Aggregator<R>
        else -> throw IllegalArgumentException("This factory does not implement the instantiation of type ${R::class.simpleName}")
    }