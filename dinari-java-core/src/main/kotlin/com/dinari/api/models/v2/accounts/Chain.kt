// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

import com.dinari.api.core.Enum
import com.dinari.api.core.JsonField
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator

class Chain @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val EIP155_1 = of("eip155:1")

        @JvmField val EIP155_42161 = of("eip155:42161")

        @JvmField val EIP155_8453 = of("eip155:8453")

        @JvmField val EIP155_81457 = of("eip155:81457")

        @JvmField val EIP155_98866 = of("eip155:98866")

        @JvmField val EIP155_11155111 = of("eip155:11155111")

        @JvmField val EIP155_421614 = of("eip155:421614")

        @JvmField val EIP155_84532 = of("eip155:84532")

        @JvmField val EIP155_168587773 = of("eip155:168587773")

        @JvmField val EIP155_98867 = of("eip155:98867")

        @JvmField val EIP155_202110 = of("eip155:202110")

        @JvmField val EIP155_179205 = of("eip155:179205")

        @JvmField val EIP155_179202 = of("eip155:179202")

        @JvmField val EIP155_98865 = of("eip155:98865")

        @JvmField val EIP155_7887 = of("eip155:7887")

        @JvmStatic fun of(value: String) = Chain(JsonField.of(value))
    }

    /** An enum containing [Chain]'s known values. */
    enum class Known {
        EIP155_1,
        EIP155_42161,
        EIP155_8453,
        EIP155_81457,
        EIP155_98866,
        EIP155_11155111,
        EIP155_421614,
        EIP155_84532,
        EIP155_168587773,
        EIP155_98867,
        EIP155_202110,
        EIP155_179205,
        EIP155_179202,
        EIP155_98865,
        EIP155_7887,
    }

    /**
     * An enum containing [Chain]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [Chain] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        EIP155_1,
        EIP155_42161,
        EIP155_8453,
        EIP155_81457,
        EIP155_98866,
        EIP155_11155111,
        EIP155_421614,
        EIP155_84532,
        EIP155_168587773,
        EIP155_98867,
        EIP155_202110,
        EIP155_179205,
        EIP155_179202,
        EIP155_98865,
        EIP155_7887,
        /** An enum member indicating that [Chain] was instantiated with an unknown value. */
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
            EIP155_1 -> Value.EIP155_1
            EIP155_42161 -> Value.EIP155_42161
            EIP155_8453 -> Value.EIP155_8453
            EIP155_81457 -> Value.EIP155_81457
            EIP155_98866 -> Value.EIP155_98866
            EIP155_11155111 -> Value.EIP155_11155111
            EIP155_421614 -> Value.EIP155_421614
            EIP155_84532 -> Value.EIP155_84532
            EIP155_168587773 -> Value.EIP155_168587773
            EIP155_98867 -> Value.EIP155_98867
            EIP155_202110 -> Value.EIP155_202110
            EIP155_179205 -> Value.EIP155_179205
            EIP155_179202 -> Value.EIP155_179202
            EIP155_98865 -> Value.EIP155_98865
            EIP155_7887 -> Value.EIP155_7887
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws DinariInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            EIP155_1 -> Known.EIP155_1
            EIP155_42161 -> Known.EIP155_42161
            EIP155_8453 -> Known.EIP155_8453
            EIP155_81457 -> Known.EIP155_81457
            EIP155_98866 -> Known.EIP155_98866
            EIP155_11155111 -> Known.EIP155_11155111
            EIP155_421614 -> Known.EIP155_421614
            EIP155_84532 -> Known.EIP155_84532
            EIP155_168587773 -> Known.EIP155_168587773
            EIP155_98867 -> Known.EIP155_98867
            EIP155_202110 -> Known.EIP155_202110
            EIP155_179205 -> Known.EIP155_179205
            EIP155_179202 -> Known.EIP155_179202
            EIP155_98865 -> Known.EIP155_98865
            EIP155_7887 -> Known.EIP155_7887
            else -> throw DinariInvalidDataException("Unknown Chain: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws DinariInvalidDataException if this class instance's value does not have the expected
     *   primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { DinariInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    fun validate(): Chain = apply {
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
        } catch (e: DinariInvalidDataException) {
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

        return other is Chain && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
