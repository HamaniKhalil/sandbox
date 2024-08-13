package com.example.sandbox.stepper.core

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement

class Stepper<S>(
    private val roadmap: Milestone<S>,
    val contentTransformer: (Json, Any) -> JsonElement,
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

    var current: MutableState<Milestone<S>?> = mutableStateOf(roadmap)

    val currentStep: Step<*, *>?
        get() = steps.firstOrNull { it.milestone.support == current.value?.support }

    inline fun <@StepContent reified C> next(content: C) {
        if (current.value == null) throw IllegalStateException("")
        val step = Step(
            content = content,
            milestone = current.value!!,
        )
        val index = steps.indexOfFirst { it.milestone == current.value }
        if(index != -1)
            steps.removeAt(index)
        steps.add(step)
        current.value = step.milestone.next
        if (!checkIntegrity())
            throw IllegalStateException("Stepper is not working properly")
    }

    fun previous() {
        current.value = steps.last().milestone
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
        aggregate(steps, contentTransformer)

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

        fun addMilestones(milestones: List<Milestone<S>>) =
            apply { milestones.forEach { addMilestone(it) } }

        fun build(): Milestone<S> = root

    }

}