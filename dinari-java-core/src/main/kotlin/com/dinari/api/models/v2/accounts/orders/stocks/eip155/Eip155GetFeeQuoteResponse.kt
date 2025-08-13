// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders.stocks.eip155

import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkKnown
import com.dinari.api.core.checkRequired
import com.dinari.api.core.toImmutable
import com.dinari.api.errors.DinariInvalidDataException
import com.dinari.api.models.v2.accounts.Chain
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class Eip155GetFeeQuoteResponse
private constructor(
    private val chainId: JsonField<Chain>,
    private val fee: JsonField<Double>,
    private val orderFeeContractObject: JsonField<OrderFeeContractObject>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Chain> = JsonMissing.of(),
        @JsonProperty("fee") @ExcludeMissing fee: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("order_fee_contract_object")
        @ExcludeMissing
        orderFeeContractObject: JsonField<OrderFeeContractObject> = JsonMissing.of(),
    ) : this(chainId, fee, orderFeeContractObject, mutableMapOf())

    /**
     * CAIP-2 chain ID of the blockchain where the `Order` will be placed
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): Chain = chainId.getRequired("chain_id")

    /**
     * The total quantity of the fees paid via payment token.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fee(): Double = fee.getRequired("fee")

    /**
     * Opaque fee quote object to pass into the contract when creating an `Order` directly through
     * Dinari's smart contracts.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderFeeContractObject(): OrderFeeContractObject =
        orderFeeContractObject.getRequired("order_fee_contract_object")

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Chain> = chainId

    /**
     * Returns the raw JSON value of [fee].
     *
     * Unlike [fee], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fee") @ExcludeMissing fun _fee(): JsonField<Double> = fee

    /**
     * Returns the raw JSON value of [orderFeeContractObject].
     *
     * Unlike [orderFeeContractObject], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("order_fee_contract_object")
    @ExcludeMissing
    fun _orderFeeContractObject(): JsonField<OrderFeeContractObject> = orderFeeContractObject

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
         * Returns a mutable builder for constructing an instance of [Eip155GetFeeQuoteResponse].
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .fee()
         * .orderFeeContractObject()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155GetFeeQuoteResponse]. */
    class Builder internal constructor() {

        private var chainId: JsonField<Chain>? = null
        private var fee: JsonField<Double>? = null
        private var orderFeeContractObject: JsonField<OrderFeeContractObject>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eip155GetFeeQuoteResponse: Eip155GetFeeQuoteResponse) = apply {
            chainId = eip155GetFeeQuoteResponse.chainId
            fee = eip155GetFeeQuoteResponse.fee
            orderFeeContractObject = eip155GetFeeQuoteResponse.orderFeeContractObject
            additionalProperties = eip155GetFeeQuoteResponse.additionalProperties.toMutableMap()
        }

        /** CAIP-2 chain ID of the blockchain where the `Order` will be placed */
        fun chainId(chainId: Chain) = chainId(JsonField.of(chainId))

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [Chain] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<Chain>) = apply { this.chainId = chainId }

        /** The total quantity of the fees paid via payment token. */
        fun fee(fee: Double) = fee(JsonField.of(fee))

        /**
         * Sets [Builder.fee] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fee] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fee(fee: JsonField<Double>) = apply { this.fee = fee }

        /**
         * Opaque fee quote object to pass into the contract when creating an `Order` directly
         * through Dinari's smart contracts.
         */
        fun orderFeeContractObject(orderFeeContractObject: OrderFeeContractObject) =
            orderFeeContractObject(JsonField.of(orderFeeContractObject))

        /**
         * Sets [Builder.orderFeeContractObject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderFeeContractObject] with a well-typed
         * [OrderFeeContractObject] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun orderFeeContractObject(orderFeeContractObject: JsonField<OrderFeeContractObject>) =
            apply {
                this.orderFeeContractObject = orderFeeContractObject
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
         * Returns an immutable instance of [Eip155GetFeeQuoteResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .fee()
         * .orderFeeContractObject()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155GetFeeQuoteResponse =
            Eip155GetFeeQuoteResponse(
                checkRequired("chainId", chainId),
                checkRequired("fee", fee),
                checkRequired("orderFeeContractObject", orderFeeContractObject),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Eip155GetFeeQuoteResponse = apply {
        if (validated) {
            return@apply
        }

        chainId().validate()
        fee()
        orderFeeContractObject().validate()
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
        (chainId.asKnown().getOrNull()?.validity() ?: 0) +
            (if (fee.asKnown().isPresent) 1 else 0) +
            (orderFeeContractObject.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Opaque fee quote object to pass into the contract when creating an `Order` directly through
     * Dinari's smart contracts.
     */
    class OrderFeeContractObject
    private constructor(
        private val chainId: JsonField<ChainId>,
        private val feeQuote: JsonField<FeeQuote>,
        private val feeQuoteSignature: JsonField<String>,
        private val fees: JsonField<List<OrderFeeAmount>>,
        private val paymentToken: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("chain_id")
            @ExcludeMissing
            chainId: JsonField<ChainId> = JsonMissing.of(),
            @JsonProperty("fee_quote")
            @ExcludeMissing
            feeQuote: JsonField<FeeQuote> = JsonMissing.of(),
            @JsonProperty("fee_quote_signature")
            @ExcludeMissing
            feeQuoteSignature: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fees")
            @ExcludeMissing
            fees: JsonField<List<OrderFeeAmount>> = JsonMissing.of(),
            @JsonProperty("payment_token")
            @ExcludeMissing
            paymentToken: JsonField<String> = JsonMissing.of(),
        ) : this(chainId, feeQuote, feeQuoteSignature, fees, paymentToken, mutableMapOf())

        /**
         * EVM chain ID of the blockchain where the `Order` will be placed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun chainId(): ChainId = chainId.getRequired("chain_id")

        /**
         * `FeeQuote` structure to pass into contracts.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun feeQuote(): FeeQuote = feeQuote.getRequired("fee_quote")

        /**
         * Signed `FeeQuote` structure to pass into contracts.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun feeQuoteSignature(): String = feeQuoteSignature.getRequired("fee_quote_signature")

        /**
         * Breakdown of fees
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fees(): List<OrderFeeAmount> = fees.getRequired("fees")

        /**
         * Address of payment token used for fees
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun paymentToken(): String = paymentToken.getRequired("payment_token")

        /**
         * Returns the raw JSON value of [chainId].
         *
         * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<ChainId> = chainId

        /**
         * Returns the raw JSON value of [feeQuote].
         *
         * Unlike [feeQuote], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fee_quote") @ExcludeMissing fun _feeQuote(): JsonField<FeeQuote> = feeQuote

        /**
         * Returns the raw JSON value of [feeQuoteSignature].
         *
         * Unlike [feeQuoteSignature], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("fee_quote_signature")
        @ExcludeMissing
        fun _feeQuoteSignature(): JsonField<String> = feeQuoteSignature

        /**
         * Returns the raw JSON value of [fees].
         *
         * Unlike [fees], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fees") @ExcludeMissing fun _fees(): JsonField<List<OrderFeeAmount>> = fees

        /**
         * Returns the raw JSON value of [paymentToken].
         *
         * Unlike [paymentToken], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("payment_token")
        @ExcludeMissing
        fun _paymentToken(): JsonField<String> = paymentToken

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
             * Returns a mutable builder for constructing an instance of [OrderFeeContractObject].
             *
             * The following fields are required:
             * ```java
             * .chainId()
             * .feeQuote()
             * .feeQuoteSignature()
             * .fees()
             * .paymentToken()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OrderFeeContractObject]. */
        class Builder internal constructor() {

            private var chainId: JsonField<ChainId>? = null
            private var feeQuote: JsonField<FeeQuote>? = null
            private var feeQuoteSignature: JsonField<String>? = null
            private var fees: JsonField<MutableList<OrderFeeAmount>>? = null
            private var paymentToken: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(orderFeeContractObject: OrderFeeContractObject) = apply {
                chainId = orderFeeContractObject.chainId
                feeQuote = orderFeeContractObject.feeQuote
                feeQuoteSignature = orderFeeContractObject.feeQuoteSignature
                fees = orderFeeContractObject.fees.map { it.toMutableList() }
                paymentToken = orderFeeContractObject.paymentToken
                additionalProperties = orderFeeContractObject.additionalProperties.toMutableMap()
            }

            /** EVM chain ID of the blockchain where the `Order` will be placed. */
            fun chainId(chainId: ChainId) = chainId(JsonField.of(chainId))

            /**
             * Sets [Builder.chainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chainId] with a well-typed [ChainId] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun chainId(chainId: JsonField<ChainId>) = apply { this.chainId = chainId }

            /** `FeeQuote` structure to pass into contracts. */
            fun feeQuote(feeQuote: FeeQuote) = feeQuote(JsonField.of(feeQuote))

            /**
             * Sets [Builder.feeQuote] to an arbitrary JSON value.
             *
             * You should usually call [Builder.feeQuote] with a well-typed [FeeQuote] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun feeQuote(feeQuote: JsonField<FeeQuote>) = apply { this.feeQuote = feeQuote }

            /** Signed `FeeQuote` structure to pass into contracts. */
            fun feeQuoteSignature(feeQuoteSignature: String) =
                feeQuoteSignature(JsonField.of(feeQuoteSignature))

            /**
             * Sets [Builder.feeQuoteSignature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.feeQuoteSignature] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun feeQuoteSignature(feeQuoteSignature: JsonField<String>) = apply {
                this.feeQuoteSignature = feeQuoteSignature
            }

            /** Breakdown of fees */
            fun fees(fees: List<OrderFeeAmount>) = fees(JsonField.of(fees))

            /**
             * Sets [Builder.fees] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fees] with a well-typed `List<OrderFeeAmount>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fees(fees: JsonField<List<OrderFeeAmount>>) = apply {
                this.fees = fees.map { it.toMutableList() }
            }

            /**
             * Adds a single [OrderFeeAmount] to [fees].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addFee(fee: OrderFeeAmount) = apply {
                fees =
                    (fees ?: JsonField.of(mutableListOf())).also { checkKnown("fees", it).add(fee) }
            }

            /** Address of payment token used for fees */
            fun paymentToken(paymentToken: String) = paymentToken(JsonField.of(paymentToken))

            /**
             * Sets [Builder.paymentToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paymentToken] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun paymentToken(paymentToken: JsonField<String>) = apply {
                this.paymentToken = paymentToken
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
             * Returns an immutable instance of [OrderFeeContractObject].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .chainId()
             * .feeQuote()
             * .feeQuoteSignature()
             * .fees()
             * .paymentToken()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): OrderFeeContractObject =
                OrderFeeContractObject(
                    checkRequired("chainId", chainId),
                    checkRequired("feeQuote", feeQuote),
                    checkRequired("feeQuoteSignature", feeQuoteSignature),
                    checkRequired("fees", fees).map { it.toImmutable() },
                    checkRequired("paymentToken", paymentToken),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): OrderFeeContractObject = apply {
            if (validated) {
                return@apply
            }

            chainId().validate()
            feeQuote().validate()
            feeQuoteSignature()
            fees().forEach { it.validate() }
            paymentToken()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (chainId.asKnown().getOrNull()?.validity() ?: 0) +
                (feeQuote.asKnown().getOrNull()?.validity() ?: 0) +
                (if (feeQuoteSignature.asKnown().isPresent) 1 else 0) +
                (fees.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (paymentToken.asKnown().isPresent) 1 else 0)

        /** EVM chain ID of the blockchain where the `Order` will be placed. */
        class ChainId @JsonCreator private constructor(private val value: JsonField<Long>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Long> = value

            companion object {

                @JvmField val _42161 = of(42161L)

                @JvmField val _1 = of(1L)

                @JvmField val _8453 = of(8453L)

                @JvmField val _81457 = of(81457L)

                @JvmField val _7887 = of(7887L)

                @JvmField val _98866 = of(98866L)

                @JvmStatic fun of(value: Long) = ChainId(JsonField.of(value))
            }

            /** An enum containing [ChainId]'s known values. */
            enum class Known {
                _42161,
                _1,
                _8453,
                _81457,
                _7887,
                _98866,
            }

            /**
             * An enum containing [ChainId]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [ChainId] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                _42161,
                _1,
                _8453,
                _81457,
                _7887,
                _98866,
                /**
                 * An enum member indicating that [ChainId] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    _42161 -> Value._42161
                    _1 -> Value._1
                    _8453 -> Value._8453
                    _81457 -> Value._81457
                    _7887 -> Value._7887
                    _98866 -> Value._98866
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws DinariInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    _42161 -> Known._42161
                    _1 -> Known._1
                    _8453 -> Known._8453
                    _81457 -> Known._81457
                    _7887 -> Known._7887
                    _98866 -> Known._98866
                    else -> throw DinariInvalidDataException("Unknown ChainId: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws DinariInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asLong(): Long =
                _value().asNumber().getOrNull()?.let {
                    if (it.toDouble() % 1 == 0.0) it.toLong() else null
                } ?: throw DinariInvalidDataException("Value is not a Long")

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

                return other is ChainId && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** `FeeQuote` structure to pass into contracts. */
        class FeeQuote
        private constructor(
            private val deadline: JsonField<Long>,
            private val fee: JsonField<String>,
            private val orderId: JsonField<String>,
            private val requester: JsonField<String>,
            private val timestamp: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("deadline")
                @ExcludeMissing
                deadline: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("fee") @ExcludeMissing fee: JsonField<String> = JsonMissing.of(),
                @JsonProperty("orderId")
                @ExcludeMissing
                orderId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("requester")
                @ExcludeMissing
                requester: JsonField<String> = JsonMissing.of(),
                @JsonProperty("timestamp")
                @ExcludeMissing
                timestamp: JsonField<Long> = JsonMissing.of(),
            ) : this(deadline, fee, orderId, requester, timestamp, mutableMapOf())

            /**
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun deadline(): Long = deadline.getRequired("deadline")

            /**
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun fee(): String = fee.getRequired("fee")

            /**
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun orderId(): String = orderId.getRequired("orderId")

            /**
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun requester(): String = requester.getRequired("requester")

            /**
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun timestamp(): Long = timestamp.getRequired("timestamp")

            /**
             * Returns the raw JSON value of [deadline].
             *
             * Unlike [deadline], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("deadline") @ExcludeMissing fun _deadline(): JsonField<Long> = deadline

            /**
             * Returns the raw JSON value of [fee].
             *
             * Unlike [fee], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("fee") @ExcludeMissing fun _fee(): JsonField<String> = fee

            /**
             * Returns the raw JSON value of [orderId].
             *
             * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("orderId") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

            /**
             * Returns the raw JSON value of [requester].
             *
             * Unlike [requester], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requester")
            @ExcludeMissing
            fun _requester(): JsonField<String> = requester

            /**
             * Returns the raw JSON value of [timestamp].
             *
             * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamp") @ExcludeMissing fun _timestamp(): JsonField<Long> = timestamp

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
                 * Returns a mutable builder for constructing an instance of [FeeQuote].
                 *
                 * The following fields are required:
                 * ```java
                 * .deadline()
                 * .fee()
                 * .orderId()
                 * .requester()
                 * .timestamp()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FeeQuote]. */
            class Builder internal constructor() {

                private var deadline: JsonField<Long>? = null
                private var fee: JsonField<String>? = null
                private var orderId: JsonField<String>? = null
                private var requester: JsonField<String>? = null
                private var timestamp: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(feeQuote: FeeQuote) = apply {
                    deadline = feeQuote.deadline
                    fee = feeQuote.fee
                    orderId = feeQuote.orderId
                    requester = feeQuote.requester
                    timestamp = feeQuote.timestamp
                    additionalProperties = feeQuote.additionalProperties.toMutableMap()
                }

                fun deadline(deadline: Long) = deadline(JsonField.of(deadline))

                /**
                 * Sets [Builder.deadline] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.deadline] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun deadline(deadline: JsonField<Long>) = apply { this.deadline = deadline }

                fun fee(fee: String) = fee(JsonField.of(fee))

                /**
                 * Sets [Builder.fee] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fee] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun fee(fee: JsonField<String>) = apply { this.fee = fee }

                fun orderId(orderId: String) = orderId(JsonField.of(orderId))

                /**
                 * Sets [Builder.orderId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.orderId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

                fun requester(requester: String) = requester(JsonField.of(requester))

                /**
                 * Sets [Builder.requester] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requester] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requester(requester: JsonField<String>) = apply { this.requester = requester }

                fun timestamp(timestamp: Long) = timestamp(JsonField.of(timestamp))

                /**
                 * Sets [Builder.timestamp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timestamp] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timestamp(timestamp: JsonField<Long>) = apply { this.timestamp = timestamp }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [FeeQuote].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .deadline()
                 * .fee()
                 * .orderId()
                 * .requester()
                 * .timestamp()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): FeeQuote =
                    FeeQuote(
                        checkRequired("deadline", deadline),
                        checkRequired("fee", fee),
                        checkRequired("orderId", orderId),
                        checkRequired("requester", requester),
                        checkRequired("timestamp", timestamp),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FeeQuote = apply {
                if (validated) {
                    return@apply
                }

                deadline()
                fee()
                orderId()
                requester()
                timestamp()
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
            @JvmSynthetic
            internal fun validity(): Int =
                (if (deadline.asKnown().isPresent) 1 else 0) +
                    (if (fee.asKnown().isPresent) 1 else 0) +
                    (if (orderId.asKnown().isPresent) 1 else 0) +
                    (if (requester.asKnown().isPresent) 1 else 0) +
                    (if (timestamp.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is FeeQuote &&
                    deadline == other.deadline &&
                    fee == other.fee &&
                    orderId == other.orderId &&
                    requester == other.requester &&
                    timestamp == other.timestamp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(deadline, fee, orderId, requester, timestamp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FeeQuote{deadline=$deadline, fee=$fee, orderId=$orderId, requester=$requester, timestamp=$timestamp, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OrderFeeContractObject &&
                chainId == other.chainId &&
                feeQuote == other.feeQuote &&
                feeQuoteSignature == other.feeQuoteSignature &&
                fees == other.fees &&
                paymentToken == other.paymentToken &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                chainId,
                feeQuote,
                feeQuoteSignature,
                fees,
                paymentToken,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OrderFeeContractObject{chainId=$chainId, feeQuote=$feeQuote, feeQuoteSignature=$feeQuoteSignature, fees=$fees, paymentToken=$paymentToken, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Eip155GetFeeQuoteResponse &&
            chainId == other.chainId &&
            fee == other.fee &&
            orderFeeContractObject == other.orderFeeContractObject &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(chainId, fee, orderFeeContractObject, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Eip155GetFeeQuoteResponse{chainId=$chainId, fee=$fee, orderFeeContractObject=$orderFeeContractObject, additionalProperties=$additionalProperties}"
}
