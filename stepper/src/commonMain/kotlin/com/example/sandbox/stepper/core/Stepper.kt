package com.example.sandbox.stepper.core

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
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

    var _current: Milestone<S> = roadmap

    var current: MutableSharedFlow<Milestone<S>?> = MutableStateFlow(_current)

    val currentStep: Step<*, *>?
        get() = steps.firstOrNull { it.milestone.support == _current.support }


    suspend inline fun <@StepContent reified C> next(content: C) {
        val step = Step(
            content = content,
            milestone = _current,
        )
        val index = steps.indexOfFirst { it.milestone == _current }
        if(index != -1)
            steps.removeAt(index)
        steps.add(step)
        step.milestone.next?.let {
            _current = it
            current.emit(_current)
        }
        if (!checkIntegrity())
            throw IllegalStateException("Stepper is not working properly")
    }

    suspend fun previous() {
        _current = steps.last().milestone
        current.emit(_current)
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