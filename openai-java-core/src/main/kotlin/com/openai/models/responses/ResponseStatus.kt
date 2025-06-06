// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/**
 * The status of the response generation. One of `completed`, `failed`, `in_progress`, `cancelled`,
 * `queued`, or `incomplete`.
 */
class ResponseStatus @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val COMPLETED = of("completed")

        @JvmField val FAILED = of("failed")

        @JvmField val IN_PROGRESS = of("in_progress")

        @JvmField val CANCELLED = of("cancelled")

        @JvmField val QUEUED = of("queued")

        @JvmField val INCOMPLETE = of("incomplete")

        @JvmStatic fun of(value: String) = ResponseStatus(JsonField.of(value))
    }

    /** An enum containing [ResponseStatus]'s known values. */
    enum class Known {
        COMPLETED,
        FAILED,
        IN_PROGRESS,
        CANCELLED,
        QUEUED,
        INCOMPLETE,
    }

    /**
     * An enum containing [ResponseStatus]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [ResponseStatus] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        COMPLETED,
        FAILED,
        IN_PROGRESS,
        CANCELLED,
        QUEUED,
        INCOMPLETE,
        /**
         * An enum member indicating that [ResponseStatus] was instantiated with an unknown value.
         */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            COMPLETED -> Value.COMPLETED
            FAILED -> Value.FAILED
            IN_PROGRESS -> Value.IN_PROGRESS
            CANCELLED -> Value.CANCELLED
            QUEUED -> Value.QUEUED
            INCOMPLETE -> Value.INCOMPLETE
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws OpenAIInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            COMPLETED -> Known.COMPLETED
            FAILED -> Known.FAILED
            IN_PROGRESS -> Known.IN_PROGRESS
            CANCELLED -> Known.CANCELLED
            QUEUED -> Known.QUEUED
            INCOMPLETE -> Known.INCOMPLETE
            else -> throw OpenAIInvalidDataException("Unknown ResponseStatus: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws OpenAIInvalidDataException if this class instance's value does not have the expected
     *   primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    fun validate(): ResponseStatus = apply {
        if (validated) {
            return@apply
        }

        known()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseStatus && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
