package com.example.sandbox.settings

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.*

@Serializable
sealed class BaseClass {
    abstract val id: Int
}

@Serializable
@SerialName("DerivedClassA")
data class DerivedClassA(override val id: Int, val value: String) : BaseClass()

@Serializable
@SerialName("DerivedClassB")
data class DerivedClassB(override val id: Int, val value: Double) : BaseClass()

val module = SerializersModule {
    polymorphic(BaseClass::class) {
        subclass(DerivedClassA::class, DerivedClassA.serializer())
        subclass(DerivedClassB::class, DerivedClassB.serializer())
    }
}

val json = Json { serializersModule = module }

fun main() {
    val objects: List<BaseClass> = listOf(
        DerivedClassA(id = 1, value = "Alice") as BaseClass,
        DerivedClassB(id = 2, value = 3.14) as BaseClass,
    )

    // Serialize
    val jsonString = json.encodeToString(objects)
    println("Serialized JSON: $jsonString")

    // Deserialize
    val deserializedObjects: List<BaseClass> = json.decodeFromString(jsonString)
    println("Deserialized Objects: $deserializedObjects")
}
