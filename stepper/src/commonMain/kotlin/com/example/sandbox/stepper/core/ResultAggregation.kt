package com.example.sandbox.stepper.core

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.serializer


@OptIn(InternalSerializationApi::class, ExperimentalSerializationApi::class)
@AggregationResult
inline fun <@AggregationResult reified R> aggregate(
    steps: List<Step<*, *>>,
    transformer: (Json, Any) -> JsonElement,
): R {
    val res = buildJsonObject {
        steps.forEach {
            val serializer = it.content!!::class.serializer()
            val serialized = transformer(Json, it.content)
            put(
                key = serializer.descriptor.annotations.filterIsInstance<StepContent>().first().name,
                element = Json.encodeToJsonElement(serialized),
            )
        }
    }
    return Json.decodeFromString(res.toString())
}