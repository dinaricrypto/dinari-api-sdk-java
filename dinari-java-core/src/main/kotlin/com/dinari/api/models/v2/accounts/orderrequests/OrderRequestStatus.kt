// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.Enum
import com.dinari.api.core.JsonField
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator

class OrderRequestStatus @JsonCreator private constructor(private val value: JsonField<String>) :
    Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val QUOTED = of("QUOTED")

        @JvmField val PENDING = of("PENDING")

        @JvmField val PENDING_BRIDGE = of("PENDING_BRIDGE")

        @JvmField val SUBMITTED = of("SUBMITTED")

        @JvmField val ERROR = of("ERROR")

        @JvmField val CANCELLED = of("CANCELLED")

        @JvmField val EXPIRED = of("EXPIRED")

        @JvmField val REJECTED = of("REJECTED")

        @JvmStatic fun of(value: String) = OrderRequestStatus(JsonField.of(value))
    }

    /** An enum containing [OrderRequestStatus]'s known values. */
    enum class Known {
        QUOTED,
        PENDING,
        PENDING_BRIDGE,
        SUBMITTED,
        ERROR,
        CANCELLED,
        EXPIRED,
        REJECTED,
    }

    /**
     * An enum containing [OrderRequestStatus]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [OrderRequestStatus] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        QUOTED,
        PENDING,
        PENDING_BRIDGE,
        SUBMITTED,
        ERROR,
        CANCELLED,
        EXPIRED,
        REJECTED,
        /**
         * An enum member indicating that [OrderRequestStatus] was instantiated with an unknown
         * value.
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
            QUOTED -> Value.QUOTED
            PENDING -> Value.PENDING
            PENDING_BRIDGE -> Value.PENDING_BRIDGE
            SUBMITTED -> Value.SUBMITTED
            ERROR -> Value.ERROR
            CANCELLED -> Value.CANCELLED
            EXPIRED -> Value.EXPIRED
            REJECTED -> Value.REJECTED
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
            QUOTED -> Known.QUOTED
            PENDING -> Known.PENDING
            PENDING_BRIDGE -> Known.PENDING_BRIDGE
            SUBMITTED -> Known.SUBMITTED
            ERROR -> Known.ERROR
            CANCELLED -> Known.CANCELLED
            EXPIRED -> Known.EXPIRED
            REJECTED -> Known.REJECTED
            else -> throw DinariInvalidDataException("Unknown OrderRequestStatus: $value")
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

    fun validate(): OrderRequestStatus = apply {
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

        return other is OrderRequestStatus && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
