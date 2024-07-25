package com.example.sandbox.settings.remote.util.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

class SettingValueSerializer : KSerializer<Any> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("value", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Any) {
        when (value) {
            is Boolean -> encoder.encodeBoolean(value)
            is Int -> encoder.encodeInt(value)
            else -> throw SerializationException("")
        }
    }

    override fun deserialize(decoder: Decoder): Any {
        val input = decoder as? JsonDecoder
            ?: throw SerializationException("This class can be loaded only by Json")

        val element = input.decodeJsonElement().jsonPrimitive

        return when {
            element.booleanOrNull != null -> element.boolean
            element.intOrNull != null -> element.int
            else -> throw SerializationException("")
        }
    }
}