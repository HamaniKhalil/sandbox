package com.example.sandbox.stepper.core

import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.memberProperties

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.PROPERTY,
)
annotation class StepContent(
    val name: String,
)

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FUNCTION,
)
annotation class AggregationResult


fun KClass<*>.getNames(): List<Pair<KProperty<*>, String>> {
    val result = mutableListOf<Pair<KProperty<*>, String>>()
    memberProperties
        .forEach { prop ->
            if (prop.hasAnnotation<StepContent>()) {
                val name = (prop.annotations.first {it is StepContent } as StepContent).name
                result += prop to name
            }

            (prop.returnType.classifier as? KClass<*>)
                ?.let { propClass ->
                    if (propClass != this)
                        result += propClass.getNames()
                }
        }
    return result
}

