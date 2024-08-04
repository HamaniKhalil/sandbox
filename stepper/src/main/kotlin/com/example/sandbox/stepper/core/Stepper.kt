package com.example.sandbox.stepper.core

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
        get() = if (steps.isEmpty()) {
            roadmap
        } else {
            val cur = steps.last()
                .milestone
            cur.next ?: cur
        }

    val isLast: Boolean
        get() = steps.size == size

    inline fun <reified C> next(content: C) {
        val step = Step(
            content = content,
            milestone = current,
        )
        steps.add(step)
        if (!checkIntegrity())
            throw IllegalStateException("Stepper is not working properly")
    }

    fun previous() {
        steps.removeAt(steps.size - 1)
    }

    fun checkIntegrity(): Boolean {
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