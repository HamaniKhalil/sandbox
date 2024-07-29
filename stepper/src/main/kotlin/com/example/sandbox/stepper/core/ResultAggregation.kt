package com.example.sandbox.stepper.core

import kotlin.reflect.KAnnotatedElement
import kotlin.reflect.KProperty
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.primaryConstructor

inline fun <reified R> aggregate(
    steps: List<Step<*, *>>,
    size: Int = Int.MAX_VALUE, // No limit for now
): R {
    when {
        !R::class.isData ->
            throw IllegalArgumentException(
                """
                The inferred type should be a data class, you should consider transforming ${R::class} to a data class
                before using this method
                """
            )

        !R::class.hasAnnotation<AggregationResult>() ->
            throw IllegalArgumentException(
                """
                The inferred data class result should be annotated with ${AggregationResult::class.simpleName}
                """
            )
    }


    if (size < steps.size)
        throw IllegalArgumentException(
            """
                The steps list is too large, max defined size is $size but the step list contains ${steps.size}
                step${if (steps.size > 1) "s" else "" }
                """
        )
    val flattenedProperties = R::class
        .getNames()

    val stepObjects = steps
        .mapNotNull { it.content }

    val resultConstructorParameters = mutableListOf<Any>()
    stepObjects
        .forEach { currentObject ->
            val members = currentObject::class.members.filterIsInstance<KProperty<*>>()
            val values = currentObject::class.primaryConstructor!!
                .parameters
                .map { currentObjectProperty ->
                    val member = members.first { currentObjectProperty.name == it.name }
                    val name = (member.annotations.first { it is StepContent } as StepContent).name
                    flattenedProperties.first { name == it.second }.first.getter.call(
                        currentObject
                    )
                }
            resultConstructorParameters += currentObject::class.constructors
                .first { it.parameters.size == values.size }
                .call(*values.toTypedArray())
        }


    val result = R::class.constructors
        .first()
        .call(
            *resultConstructorParameters.toTypedArray()
        )
    return result
}