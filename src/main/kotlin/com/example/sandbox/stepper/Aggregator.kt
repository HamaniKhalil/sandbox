package com.example.sandbox.stepper

import kotlin.reflect.KProperty
import kotlin.reflect.full.primaryConstructor

abstract class Aggregator<R> {
    open val steps: MutableList<Step<*>> = mutableListOf()

    /**
     * TODO:
     *  - Implement a way that enables us to set the max steps number
     */
    fun <T> addStep(step: Step<T>) =
        steps.add(step)

    fun <T> removeStep(step: Step<T>) =
        steps.remove(step)

    inline fun <reified R> aggregate(): R {
        if (!R::class.isData)
            throw IllegalArgumentException(
                """
                The inferred type should be a data class, you should consider transforming ${R::class} to a data class before using this method
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
                        val member = members.first { currentObjectProperty.name == it.name}
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

}