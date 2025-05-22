// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

import com.dinari.api.core.Enum
import com.dinari.api.core.JsonField
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator

class BrokerageOrderStatus @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val PENDING_SUBMIT = of("PENDING_SUBMIT")

        @JvmField val PENDING_CANCEL = of("PENDING_CANCEL")

        @JvmField val PENDING_ESCROW = of("PENDING_ESCROW")

        @JvmField val PENDING_FILL = of("PENDING_FILL")

        @JvmField val ESCROWED = of("ESCROWED")

        @JvmField val SUBMITTED = of("SUBMITTED")

        @JvmField val CANCELLED = of("CANCELLED")

        @JvmField val FILLED = of("FILLED")

        @JvmField val REJECTED = of("REJECTED")

        @JvmField val REQUIRING_CONTACT = of("REQUIRING_CONTACT")

        @JvmField val ERROR = of("ERROR")

        @JvmStatic fun of(value: String) = BrokerageOrderStatus(JsonField.of(value))
    }

    /** An enum containing [BrokerageOrderStatus]'s known values. */
    enum class Known {
        PENDING_SUBMIT,
        PENDING_CANCEL,
        PENDING_ESCROW,
        PENDING_FILL,
        ESCROWED,
        SUBMITTED,
        CANCELLED,
        FILLED,
        REJECTED,
        REQUIRING_CONTACT,
        ERROR,
    }

    /**
     * An enum containing [BrokerageOrderStatus]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [BrokerageOrderStatus] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        PENDING_SUBMIT,
        PENDING_CANCEL,
        PENDING_ESCROW,
        PENDING_FILL,
        ESCROWED,
        SUBMITTED,
        CANCELLED,
        FILLED,
        REJECTED,
        REQUIRING_CONTACT,
        ERROR,
        /**
         * An enum member indicating that [BrokerageOrderStatus] was instantiated with an unknown
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
            PENDING_SUBMIT -> Value.PENDING_SUBMIT
            PENDING_CANCEL -> Value.PENDING_CANCEL
            PENDING_ESCROW -> Value.PENDING_ESCROW
            PENDING_FILL -> Value.PENDING_FILL
            ESCROWED -> Value.ESCROWED
            SUBMITTED -> Value.SUBMITTED
            CANCELLED -> Value.CANCELLED
            FILLED -> Value.FILLED
            REJECTED -> Value.REJECTED
            REQUIRING_CONTACT -> Value.REQUIRING_CONTACT
            ERROR -> Value.ERROR
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
            PENDING_SUBMIT -> Known.PENDING_SUBMIT
            PENDING_CANCEL -> Known.PENDING_CANCEL
            PENDING_ESCROW -> Known.PENDING_ESCROW
            PENDING_FILL -> Known.PENDING_FILL
            ESCROWED -> Known.ESCROWED
            SUBMITTED -> Known.SUBMITTED
            CANCELLED -> Known.CANCELLED
            FILLED -> Known.FILLED
            REJECTED -> Known.REJECTED
            REQUIRING_CONTACT -> Known.REQUIRING_CONTACT
            ERROR -> Known.ERROR
            else -> throw DinariInvalidDataException("Unknown BrokerageOrderStatus: $value")
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

    fun validate(): BrokerageOrderStatus = apply {
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

        return /* spotless:off */ other is BrokerageOrderStatus && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
