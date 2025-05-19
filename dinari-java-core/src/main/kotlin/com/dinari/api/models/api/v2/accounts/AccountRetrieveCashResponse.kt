// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts

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

/** Balance of a payment token in an `Account`. */
class AccountRetrieveCashResponse
private constructor(
    private val amount: JsonField<Double>,
    private val chainId: JsonField<ChainId>,
    private val symbol: JsonField<String>,
    private val tokenAddress: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("amount") @ExcludeMissing amount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<ChainId> = JsonMissing.of(),
        @JsonProperty("symbol") @ExcludeMissing symbol: JsonField<String> = JsonMissing.of(),
        @JsonProperty("token_address")
        @ExcludeMissing
        tokenAddress: JsonField<String> = JsonMissing.of(),
    ) : this(amount, chainId, symbol, tokenAddress, mutableMapOf())

    /**
     * Total amount of the payment token in the `Account`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun amount(): Double = amount.getRequired("amount")

    /**
     * CAIP-2 chain ID of the payment token.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): ChainId = chainId.getRequired("chain_id")

    /**
     * Symbol of the payment token.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun symbol(): String = symbol.getRequired("symbol")

    /**
     * Address of the payment token.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tokenAddress(): String = tokenAddress.getRequired("token_address")

    /**
     * Returns the raw JSON value of [amount].
     *
     * Unlike [amount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<Double> = amount

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<ChainId> = chainId

    /**
     * Returns the raw JSON value of [symbol].
     *
     * Unlike [symbol], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("symbol") @ExcludeMissing fun _symbol(): JsonField<String> = symbol

    /**
     * Returns the raw JSON value of [tokenAddress].
     *
     * Unlike [tokenAddress], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("token_address")
    @ExcludeMissing
    fun _tokenAddress(): JsonField<String> = tokenAddress

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
         * Returns a mutable builder for constructing an instance of [AccountRetrieveCashResponse].
         *
         * The following fields are required:
         * ```java
         * .amount()
         * .chainId()
         * .symbol()
         * .tokenAddress()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountRetrieveCashResponse]. */
    class Builder internal constructor() {

        private var amount: JsonField<Double>? = null
        private var chainId: JsonField<ChainId>? = null
        private var symbol: JsonField<String>? = null
        private var tokenAddress: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountRetrieveCashResponse: AccountRetrieveCashResponse) = apply {
            amount = accountRetrieveCashResponse.amount
            chainId = accountRetrieveCashResponse.chainId
            symbol = accountRetrieveCashResponse.symbol
            tokenAddress = accountRetrieveCashResponse.tokenAddress
            additionalProperties = accountRetrieveCashResponse.additionalProperties.toMutableMap()
        }

        /** Total amount of the payment token in the `Account`. */
        fun amount(amount: Double) = amount(JsonField.of(amount))

        /**
         * Sets [Builder.amount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.amount] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun amount(amount: JsonField<Double>) = apply { this.amount = amount }

        /** CAIP-2 chain ID of the payment token. */
        fun chainId(chainId: ChainId) = chainId(JsonField.of(chainId))

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [ChainId] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<ChainId>) = apply { this.chainId = chainId }

        /** Symbol of the payment token. */
        fun symbol(symbol: String) = symbol(JsonField.of(symbol))

        /**
         * Sets [Builder.symbol] to an arbitrary JSON value.
         *
         * You should usually call [Builder.symbol] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun symbol(symbol: JsonField<String>) = apply { this.symbol = symbol }

        /** Address of the payment token. */
        fun tokenAddress(tokenAddress: String) = tokenAddress(JsonField.of(tokenAddress))

        /**
         * Sets [Builder.tokenAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tokenAddress] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tokenAddress(tokenAddress: JsonField<String>) = apply {
            this.tokenAddress = tokenAddress
        }

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
         * Returns an immutable instance of [AccountRetrieveCashResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .amount()
         * .chainId()
         * .symbol()
         * .tokenAddress()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountRetrieveCashResponse =
            AccountRetrieveCashResponse(
                checkRequired("amount", amount),
                checkRequired("chainId", chainId),
                checkRequired("symbol", symbol),
                checkRequired("tokenAddress", tokenAddress),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountRetrieveCashResponse = apply {
        if (validated) {
            return@apply
        }

        amount()
        chainId().validate()
        symbol()
        tokenAddress()
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
        (if (amount.asKnown().isPresent) 1 else 0) +
            (chainId.asKnown().getOrNull()?.validity() ?: 0) +
            (if (symbol.asKnown().isPresent) 1 else 0) +
            (if (tokenAddress.asKnown().isPresent) 1 else 0)

    /** CAIP-2 chain ID of the payment token. */
    class ChainId @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val EIP155_1 = of("eip155:1")

            @JvmField val EIP155_42161 = of("eip155:42161")

            @JvmField val EIP155_8453 = of("eip155:8453")

            @JvmField val EIP155_81457 = of("eip155:81457")

            @JvmField val EIP155_7887 = of("eip155:7887")

            @JvmField val EIP155_98866 = of("eip155:98866")

            @JvmStatic fun of(value: String) = ChainId(JsonField.of(value))
        }

        /** An enum containing [ChainId]'s known values. */
        enum class Known {
            EIP155_1,
            EIP155_42161,
            EIP155_8453,
            EIP155_81457,
            EIP155_7887,
            EIP155_98866,
        }

        /**
         * An enum containing [ChainId]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ChainId] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            EIP155_1,
            EIP155_42161,
            EIP155_8453,
            EIP155_81457,
            EIP155_7887,
            EIP155_98866,
            /** An enum member indicating that [ChainId] was instantiated with an unknown value. */
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
                EIP155_1 -> Value.EIP155_1
                EIP155_42161 -> Value.EIP155_42161
                EIP155_8453 -> Value.EIP155_8453
                EIP155_81457 -> Value.EIP155_81457
                EIP155_7887 -> Value.EIP155_7887
                EIP155_98866 -> Value.EIP155_98866
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
                EIP155_1 -> Known.EIP155_1
                EIP155_42161 -> Known.EIP155_42161
                EIP155_8453 -> Known.EIP155_8453
                EIP155_81457 -> Known.EIP155_81457
                EIP155_7887 -> Known.EIP155_7887
                EIP155_98866 -> Known.EIP155_98866
                else -> throw DinariInvalidDataException("Unknown ChainId: $value")
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

        fun validate(): ChainId = apply {
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

            return /* spotless:off */ other is ChainId && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AccountRetrieveCashResponse && amount == other.amount && chainId == other.chainId && symbol == other.symbol && tokenAddress == other.tokenAddress && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(amount, chainId, symbol, tokenAddress, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountRetrieveCashResponse{amount=$amount, chainId=$chainId, symbol=$symbol, tokenAddress=$tokenAddress, additionalProperties=$additionalProperties}"
}
