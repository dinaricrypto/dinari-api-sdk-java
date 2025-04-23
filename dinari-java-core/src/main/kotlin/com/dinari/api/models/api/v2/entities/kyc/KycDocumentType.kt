// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.entities.kyc

import com.dinari.api.core.Enum
import com.dinari.api.core.JsonField
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator

class KycDocumentType @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val GOVERNMENT_ID = of("GOVERNMENT_ID")

        @JvmField val SELFIE = of("SELFIE")

        @JvmField val RESIDENCY = of("RESIDENCY")

        @JvmField val UNKNOWN = of("UNKNOWN")

        @JvmStatic fun of(value: String) = KycDocumentType(JsonField.of(value))
    }

    /** An enum containing [KycDocumentType]'s known values. */
    enum class Known {
        GOVERNMENT_ID,
        SELFIE,
        RESIDENCY,
        UNKNOWN,
    }

    /**
     * An enum containing [KycDocumentType]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [KycDocumentType] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        GOVERNMENT_ID,
        SELFIE,
        RESIDENCY,
        UNKNOWN,
        /**
         * An enum member indicating that [KycDocumentType] was instantiated with an unknown value.
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
            GOVERNMENT_ID -> Value.GOVERNMENT_ID
            SELFIE -> Value.SELFIE
            RESIDENCY -> Value.RESIDENCY
            UNKNOWN -> Value.UNKNOWN
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
            GOVERNMENT_ID -> Known.GOVERNMENT_ID
            SELFIE -> Known.SELFIE
            RESIDENCY -> Known.RESIDENCY
            UNKNOWN -> Known.UNKNOWN
            else -> throw DinariInvalidDataException("Unknown KycDocumentType: $value")
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

    fun validate(): KycDocumentType = apply {
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

        return /* spotless:off */ other is KycDocumentType && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
