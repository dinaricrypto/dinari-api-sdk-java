// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orders

import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkKnown
import com.dinari.api.core.checkRequired
import com.dinari.api.core.toImmutable
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class OrderGetEstimatedFeeResponse
private constructor(
    private val chainId: JsonField<Long>,
    private val feeQuote: JsonField<FeeQuote>,
    private val feeQuoteSignature: JsonField<String>,
    private val fees: JsonField<List<Fee>>,
    private val paymentToken: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("fee_quote") @ExcludeMissing feeQuote: JsonField<FeeQuote> = JsonMissing.of(),
        @JsonProperty("fee_quote_signature")
        @ExcludeMissing
        feeQuoteSignature: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fees") @ExcludeMissing fees: JsonField<List<Fee>> = JsonMissing.of(),
        @JsonProperty("payment_token")
        @ExcludeMissing
        paymentToken: JsonField<String> = JsonMissing.of(),
    ) : this(chainId, feeQuote, feeQuoteSignature, fees, paymentToken, mutableMapOf())

    /**
     * Chain where the order is placed
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): Long = chainId.getRequired("chain_id")

    /**
     * FeeQuote structure to pass into contracts
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun feeQuote(): FeeQuote = feeQuote.getRequired("fee_quote")

    /**
     * Signed FeeQuote structure to pass into contracts
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
    fun fees(): List<Fee> = fees.getRequired("fees")

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
    @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Long> = chainId

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
    @JsonProperty("fees") @ExcludeMissing fun _fees(): JsonField<List<Fee>> = fees

    /**
     * Returns the raw JSON value of [paymentToken].
     *
     * Unlike [paymentToken], this method doesn't throw if the JSON field has an unexpected type.
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
         * Returns a mutable builder for constructing an instance of [OrderGetEstimatedFeeResponse].
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

    /** A builder for [OrderGetEstimatedFeeResponse]. */
    class Builder internal constructor() {

        private var chainId: JsonField<Long>? = null
        private var feeQuote: JsonField<FeeQuote>? = null
        private var feeQuoteSignature: JsonField<String>? = null
        private var fees: JsonField<MutableList<Fee>>? = null
        private var paymentToken: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(orderGetEstimatedFeeResponse: OrderGetEstimatedFeeResponse) = apply {
            chainId = orderGetEstimatedFeeResponse.chainId
            feeQuote = orderGetEstimatedFeeResponse.feeQuote
            feeQuoteSignature = orderGetEstimatedFeeResponse.feeQuoteSignature
            fees = orderGetEstimatedFeeResponse.fees.map { it.toMutableList() }
            paymentToken = orderGetEstimatedFeeResponse.paymentToken
            additionalProperties = orderGetEstimatedFeeResponse.additionalProperties.toMutableMap()
        }

        /** Chain where the order is placed */
        fun chainId(chainId: Long) = chainId(JsonField.of(chainId))

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<Long>) = apply { this.chainId = chainId }

        /** FeeQuote structure to pass into contracts */
        fun feeQuote(feeQuote: FeeQuote) = feeQuote(JsonField.of(feeQuote))

        /**
         * Sets [Builder.feeQuote] to an arbitrary JSON value.
         *
         * You should usually call [Builder.feeQuote] with a well-typed [FeeQuote] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun feeQuote(feeQuote: JsonField<FeeQuote>) = apply { this.feeQuote = feeQuote }

        /** Signed FeeQuote structure to pass into contracts */
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
        fun fees(fees: List<Fee>) = fees(JsonField.of(fees))

        /**
         * Sets [Builder.fees] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fees] with a well-typed `List<Fee>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fees(fees: JsonField<List<Fee>>) = apply { this.fees = fees.map { it.toMutableList() } }

        /**
         * Adds a single [Fee] to [fees].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFee(fee: Fee) = apply {
            fees = (fees ?: JsonField.of(mutableListOf())).also { checkKnown("fees", it).add(fee) }
        }

        /** Address of payment token used for fees */
        fun paymentToken(paymentToken: String) = paymentToken(JsonField.of(paymentToken))

        /**
         * Sets [Builder.paymentToken] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentToken] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [OrderGetEstimatedFeeResponse].
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
        fun build(): OrderGetEstimatedFeeResponse =
            OrderGetEstimatedFeeResponse(
                checkRequired("chainId", chainId),
                checkRequired("feeQuote", feeQuote),
                checkRequired("feeQuoteSignature", feeQuoteSignature),
                checkRequired("fees", fees).map { it.toImmutable() },
                checkRequired("paymentToken", paymentToken),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OrderGetEstimatedFeeResponse = apply {
        if (validated) {
            return@apply
        }

        chainId()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (chainId.asKnown().isPresent) 1 else 0) +
            (feeQuote.asKnown().getOrNull()?.validity() ?: 0) +
            (if (feeQuoteSignature.asKnown().isPresent) 1 else 0) +
            (fees.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (paymentToken.asKnown().isPresent) 1 else 0)

    /** FeeQuote structure to pass into contracts */
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
            @JsonProperty("deadline") @ExcludeMissing deadline: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("fee") @ExcludeMissing fee: JsonField<String> = JsonMissing.of(),
            @JsonProperty("orderId") @ExcludeMissing orderId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("requester")
            @ExcludeMissing
            requester: JsonField<String> = JsonMissing.of(),
            @JsonProperty("timestamp") @ExcludeMissing timestamp: JsonField<Long> = JsonMissing.of(),
        ) : this(deadline, fee, orderId, requester, timestamp, mutableMapOf())

        /**
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun deadline(): Long = deadline.getRequired("deadline")

        /**
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fee(): String = fee.getRequired("fee")

        /**
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderId(): String = orderId.getRequired("orderId")

        /**
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun requester(): String = requester.getRequired("requester")

        /**
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun timestamp(): Long = timestamp.getRequired("timestamp")

        /**
         * Returns the raw JSON value of [deadline].
         *
         * Unlike [deadline], this method doesn't throw if the JSON field has an unexpected type.
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
         * Unlike [requester], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("requester") @ExcludeMissing fun _requester(): JsonField<String> = requester

        /**
         * Returns the raw JSON value of [timestamp].
         *
         * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected type.
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
             * You should usually call [Builder.deadline] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deadline(deadline: JsonField<Long>) = apply { this.deadline = deadline }

            fun fee(fee: String) = fee(JsonField.of(fee))

            /**
             * Sets [Builder.fee] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fee] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun fee(fee: JsonField<String>) = apply { this.fee = fee }

            fun orderId(orderId: String) = orderId(JsonField.of(orderId))

            /**
             * Sets [Builder.orderId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

            fun requester(requester: String) = requester(JsonField.of(requester))

            /**
             * Sets [Builder.requester] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requester] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requester(requester: JsonField<String>) = apply { this.requester = requester }

            fun timestamp(timestamp: Long) = timestamp(JsonField.of(timestamp))

            /**
             * Sets [Builder.timestamp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timestamp] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timestamp(timestamp: JsonField<Long>) = apply { this.timestamp = timestamp }

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

            return /* spotless:off */ other is FeeQuote && deadline == other.deadline && fee == other.fee && orderId == other.orderId && requester == other.requester && timestamp == other.timestamp && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(deadline, fee, orderId, requester, timestamp, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FeeQuote{deadline=$deadline, fee=$fee, orderId=$orderId, requester=$requester, timestamp=$timestamp, additionalProperties=$additionalProperties}"
    }

    class Fee
    private constructor(
        private val feeInEth: JsonField<Double>,
        private val feeInWei: JsonField<String>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("fee_in_eth")
            @ExcludeMissing
            feeInEth: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("fee_in_wei")
            @ExcludeMissing
            feeInWei: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(feeInEth, feeInWei, type, mutableMapOf())

        /**
         * The quantity of the fee paid via payment token in ETH <a
         * href='https://ethereum.org/en/developers/docs/intro-to-ether/#what-is-ether'
         * target='_blank'>(what is ETH?)</a>
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun feeInEth(): Double = feeInEth.getRequired("fee_in_eth")

        /**
         * The quantity of the fee paid via payment token in wei <a
         * href='https://ethereum.org/en/developers/docs/intro-to-ether/#denominations'
         * target='_blank'>(what is wei?)</a>
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun feeInWei(): String = feeInWei.getRequired("fee_in_wei")

        /**
         * Type of fee
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
             * Returns a mutable builder for constructing an instance of [Fee].
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

        /** A builder for [Fee]. */
        class Builder internal constructor() {

            private var feeInEth: JsonField<Double>? = null
            private var feeInWei: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fee: Fee) = apply {
                feeInEth = fee.feeInEth
                feeInWei = fee.feeInWei
                type = fee.type
                additionalProperties = fee.additionalProperties.toMutableMap()
            }

            /**
             * The quantity of the fee paid via payment token in ETH <a
             * href='https://ethereum.org/en/developers/docs/intro-to-ether/#what-is-ether'
             * target='_blank'>(what is ETH?)</a>
             */
            fun feeInEth(feeInEth: Double) = feeInEth(JsonField.of(feeInEth))

            /**
             * Sets [Builder.feeInEth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.feeInEth] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun feeInEth(feeInEth: JsonField<Double>) = apply { this.feeInEth = feeInEth }

            /**
             * The quantity of the fee paid via payment token in wei <a
             * href='https://ethereum.org/en/developers/docs/intro-to-ether/#denominations'
             * target='_blank'>(what is wei?)</a>
             */
            fun feeInWei(feeInWei: String) = feeInWei(JsonField.of(feeInWei))

            /**
             * Sets [Builder.feeInWei] to an arbitrary JSON value.
             *
             * You should usually call [Builder.feeInWei] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun feeInWei(feeInWei: JsonField<String>) = apply { this.feeInWei = feeInWei }

            /** Type of fee */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * Returns an immutable instance of [Fee].
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
            fun build(): Fee =
                Fee(
                    checkRequired("feeInEth", feeInEth),
                    checkRequired("feeInWei", feeInWei),
                    checkRequired("type", type),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Fee = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (feeInEth.asKnown().isPresent) 1 else 0) +
                (if (feeInWei.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /** Type of fee */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
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
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
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
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws DinariInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    DinariInvalidDataException("Value is not a String")
                }

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

                return /* spotless:off */ other is Type && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Fee && feeInEth == other.feeInEth && feeInWei == other.feeInWei && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(feeInEth, feeInWei, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Fee{feeInEth=$feeInEth, feeInWei=$feeInWei, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is OrderGetEstimatedFeeResponse && chainId == other.chainId && feeQuote == other.feeQuote && feeQuoteSignature == other.feeQuoteSignature && fees == other.fees && paymentToken == other.paymentToken && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(chainId, feeQuote, feeQuoteSignature, fees, paymentToken, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OrderGetEstimatedFeeResponse{chainId=$chainId, feeQuote=$feeQuote, feeQuoteSignature=$feeQuoteSignature, fees=$fees, paymentToken=$paymentToken, additionalProperties=$additionalProperties}"
}
