// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders.stocks.eip155

import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class OrderFeeAmount
private constructor(
    private val feeInEth: JsonField<Double>,
    private val feeInWei: JsonField<String>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("fee_in_eth") @ExcludeMissing feeInEth: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("fee_in_wei") @ExcludeMissing feeInWei: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(feeInEth, feeInWei, type, mutableMapOf())

    /**
     * The quantity of the fee paid via payment token in
     * [ETH](https://ethereum.org/en/developers/docs/intro-to-ether/#what-is-ether).
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun feeInEth(): Double = feeInEth.getRequired("fee_in_eth")

    /**
     * The quantity of the fee paid via payment token in
     * [wei](https://ethereum.org/en/developers/docs/intro-to-ether/#denominations).
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun feeInWei(): String = feeInWei.getRequired("fee_in_wei")

    /**
     * Type of fee.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [feeInEth].
     *
     * Unlike [feeInEth], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fee_in_eth") @ExcludeMissing fun _feeInEth(): JsonField<Double> = feeInEth

    /**
     * Returns the raw JSON value of [feeInWei].
     *
     * Unlike [feeInWei], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fee_in_wei") @ExcludeMissing fun _feeInWei(): JsonField<String> = feeInWei

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OrderFeeAmount].
         *
         * The following fields are required:
         * ```java
         * .feeInEth()
         * .feeInWei()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderFeeAmount]. */
    class Builder internal constructor() {

        private var feeInEth: JsonField<Double>? = null
        private var feeInWei: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(orderFeeAmount: OrderFeeAmount) = apply {
            feeInEth = orderFeeAmount.feeInEth
            feeInWei = orderFeeAmount.feeInWei
            type = orderFeeAmount.type
            additionalProperties = orderFeeAmount.additionalProperties.toMutableMap()
        }

        /**
         * The quantity of the fee paid via payment token in
         * [ETH](https://ethereum.org/en/developers/docs/intro-to-ether/#what-is-ether).
         */
        fun feeInEth(feeInEth: Double) = feeInEth(JsonField.of(feeInEth))

        /**
         * Sets [Builder.feeInEth] to an arbitrary JSON value.
         *
         * You should usually call [Builder.feeInEth] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun feeInEth(feeInEth: JsonField<Double>) = apply { this.feeInEth = feeInEth }

        /**
         * The quantity of the fee paid via payment token in
         * [wei](https://ethereum.org/en/developers/docs/intro-to-ether/#denominations).
         */
        fun feeInWei(feeInWei: String) = feeInWei(JsonField.of(feeInWei))

        /**
         * Sets [Builder.feeInWei] to an arbitrary JSON value.
         *
         * You should usually call [Builder.feeInWei] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun feeInWei(feeInWei: JsonField<String>) = apply { this.feeInWei = feeInWei }

        /** Type of fee. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [OrderFeeAmount].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .feeInEth()
         * .feeInWei()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrderFeeAmount =
            OrderFeeAmount(
                checkRequired("feeInEth", feeInEth),
                checkRequired("feeInWei", feeInWei),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OrderFeeAmount = apply {
        if (validated) {
            return@apply
        }

        feeInEth()
        feeInWei()
        type().validate()
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
    @JvmSynthetic
    internal fun validity(): Int =
        (if (feeInEth.asKnown().isPresent) 1 else 0) +
            (if (feeInWei.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /** Type of fee. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val SPONSORED_NETWORK = of("SPONSORED_NETWORK")

            @JvmField val NETWORK = of("NETWORK")

            @JvmField val TRADING = of("TRADING")

            @JvmField val ORDER = of("ORDER")

            @JvmField val PARTNER_ORDER = of("PARTNER_ORDER")

            @JvmField val PARTNER_TRADING = of("PARTNER_TRADING")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            SPONSORED_NETWORK,
            NETWORK,
            TRADING,
            ORDER,
            PARTNER_ORDER,
            PARTNER_TRADING,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SPONSORED_NETWORK,
            NETWORK,
            TRADING,
            ORDER,
            PARTNER_ORDER,
            PARTNER_TRADING,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                SPONSORED_NETWORK -> Value.SPONSORED_NETWORK
                NETWORK -> Value.NETWORK
                TRADING -> Value.TRADING
                ORDER -> Value.ORDER
                PARTNER_ORDER -> Value.PARTNER_ORDER
                PARTNER_TRADING -> Value.PARTNER_TRADING
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws DinariInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                SPONSORED_NETWORK -> Known.SPONSORED_NETWORK
                NETWORK -> Known.NETWORK
                TRADING -> Known.TRADING
                ORDER -> Known.ORDER
                PARTNER_ORDER -> Known.PARTNER_ORDER
                PARTNER_TRADING -> Known.PARTNER_TRADING
                else -> throw DinariInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws DinariInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { DinariInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Type = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrderFeeAmount &&
            feeInEth == other.feeInEth &&
            feeInWei == other.feeInWei &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(feeInEth, feeInWei, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OrderFeeAmount{feeInEth=$feeInEth, feeInWei=$feeInWei, type=$type, additionalProperties=$additionalProperties}"
}
