package com.example.sandbox.stepper.core

import com.example.sandbox.stepper.Milestone

class Stepper<S>(
    private val roadmap: Milestone<S>,
) {
    val steps: MutableList<Step<*, S>> = mutableListOf()

    val size: Int
        get() {
            var steps = 1
            var current = roadmap
            while (current.next != null) {
                current = current.next!!
                steps++
            }
            return steps
        }

    val current: Milestone<S>
        get() = steps.last()
            .milestone

    fun next(step: Step<*, S>) {
        steps.add(step)
        if(!checkIntegrity())
            throw IllegalStateException("Stepper is not working properly")
    }

    fun previous() {
        steps.removeAt(steps.size - 1)
    }

    private fun checkIntegrity(): Boolean {
        var cursor: Milestone<*>? = roadmap
        steps.forEach { step ->
            if (cursor == null) return false
            if (step.milestone != cursor) return false
            cursor = cursor?.next
        }
        return true
    }

    inline fun <reified T> aggregate(): T =
        aggregate(steps, size)

    class RoadmapBuilder<S> {

        private lateinit var root: Milestone<S>

        private lateinit var tip: Milestone<S>

        fun addMilestone(milestone: Milestone<S>) =
            apply {
                if (!::root.isInitialized) {
                    root = milestone
                    tip = root
                } else {
                    tip.next = milestone
                    tip = milestone
                }
            }

        fun build(): Milestone<S> = root

    }

}