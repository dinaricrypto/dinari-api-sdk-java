// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderfulfillments

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.errors.DinariInvalidDataException
import com.dinari.api.models.v2.accounts.Chain
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Information about a fulfillment of an `Order`. An order may be fulfilled in multiple
 * transactions.
 */
class Fulfillment
private constructor(
    private val id: JsonField<String>,
    private val assetTokenFilled: JsonField<Double>,
    private val assetTokenSpent: JsonField<Double>,
    private val chainId: JsonField<Chain>,
    private val orderId: JsonField<String>,
    private val paymentTokenFilled: JsonField<Double>,
    private val paymentTokenSpent: JsonField<Double>,
    private val transactionDt: JsonField<OffsetDateTime>,
    private val transactionHash: JsonField<String>,
    private val paymentTokenFee: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("asset_token_filled")
        @ExcludeMissing
        assetTokenFilled: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("asset_token_spent")
        @ExcludeMissing
        assetTokenSpent: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Chain> = JsonMissing.of(),
        @JsonProperty("order_id") @ExcludeMissing orderId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("payment_token_filled")
        @ExcludeMissing
        paymentTokenFilled: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("payment_token_spent")
        @ExcludeMissing
        paymentTokenSpent: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("transaction_dt")
        @ExcludeMissing
        transactionDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("transaction_hash")
        @ExcludeMissing
        transactionHash: JsonField<String> = JsonMissing.of(),
        @JsonProperty("payment_token_fee")
        @ExcludeMissing
        paymentTokenFee: JsonField<Double> = JsonMissing.of(),
    ) : this(
        id,
        assetTokenFilled,
        assetTokenSpent,
        chainId,
        orderId,
        paymentTokenFilled,
        paymentTokenSpent,
        transactionDt,
        transactionHash,
        paymentTokenFee,
        mutableMapOf(),
    )

    /**
     * ID of the `OrderFulfillment`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Amount of dShare asset token filled for `BUY` orders.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assetTokenFilled(): Double = assetTokenFilled.getRequired("asset_token_filled")

    /**
     * Amount of dShare asset token spent for `SELL` orders.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assetTokenSpent(): Double = assetTokenSpent.getRequired("asset_token_spent")

    /**
     * Blockchain that the transaction was run on.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): Chain = chainId.getRequired("chain_id")

    /**
     * ID of the `Order` this `OrderFulfillment` is for.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderId(): String = orderId.getRequired("order_id")

    /**
     * Amount of payment token filled for `SELL` orders.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentTokenFilled(): Double = paymentTokenFilled.getRequired("payment_token_filled")

    /**
     * Amount of payment token spent for `BUY` orders.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentTokenSpent(): Double = paymentTokenSpent.getRequired("payment_token_spent")

    /**
     * Time when transaction occurred.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transactionDt(): OffsetDateTime = transactionDt.getRequired("transaction_dt")

    /**
     * Transaction hash for this fulfillment.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transactionHash(): String = transactionHash.getRequired("transaction_hash")

    /**
     * Fee amount, in payment tokens.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentTokenFee(): Optional<Double> = paymentTokenFee.getOptional("payment_token_fee")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [assetTokenFilled].
     *
     * Unlike [assetTokenFilled], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("asset_token_filled")
    @ExcludeMissing
    fun _assetTokenFilled(): JsonField<Double> = assetTokenFilled

    /**
     * Returns the raw JSON value of [assetTokenSpent].
     *
     * Unlike [assetTokenSpent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("asset_token_spent")
    @ExcludeMissing
    fun _assetTokenSpent(): JsonField<Double> = assetTokenSpent

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Chain> = chainId

    /**
     * Returns the raw JSON value of [orderId].
     *
     * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_id") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

    /**
     * Returns the raw JSON value of [paymentTokenFilled].
     *
     * Unlike [paymentTokenFilled], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("payment_token_filled")
    @ExcludeMissing
    fun _paymentTokenFilled(): JsonField<Double> = paymentTokenFilled

    /**
     * Returns the raw JSON value of [paymentTokenSpent].
     *
     * Unlike [paymentTokenSpent], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("payment_token_spent")
    @ExcludeMissing
    fun _paymentTokenSpent(): JsonField<Double> = paymentTokenSpent

    /**
     * Returns the raw JSON value of [transactionDt].
     *
     * Unlike [transactionDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transaction_dt")
    @ExcludeMissing
    fun _transactionDt(): JsonField<OffsetDateTime> = transactionDt

    /**
     * Returns the raw JSON value of [transactionHash].
     *
     * Unlike [transactionHash], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transaction_hash")
    @ExcludeMissing
    fun _transactionHash(): JsonField<String> = transactionHash

    /**
     * Returns the raw JSON value of [paymentTokenFee].
     *
     * Unlike [paymentTokenFee], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("payment_token_fee")
    @ExcludeMissing
    fun _paymentTokenFee(): JsonField<Double> = paymentTokenFee

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
         * Returns a mutable builder for constructing an instance of [Fulfillment].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .assetTokenFilled()
         * .assetTokenSpent()
         * .chainId()
         * .orderId()
         * .paymentTokenFilled()
         * .paymentTokenSpent()
         * .transactionDt()
         * .transactionHash()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Fulfillment]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var assetTokenFilled: JsonField<Double>? = null
        private var assetTokenSpent: JsonField<Double>? = null
        private var chainId: JsonField<Chain>? = null
        private var orderId: JsonField<String>? = null
        private var paymentTokenFilled: JsonField<Double>? = null
        private var paymentTokenSpent: JsonField<Double>? = null
        private var transactionDt: JsonField<OffsetDateTime>? = null
        private var transactionHash: JsonField<String>? = null
        private var paymentTokenFee: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fulfillment: Fulfillment) = apply {
            id = fulfillment.id
            assetTokenFilled = fulfillment.assetTokenFilled
            assetTokenSpent = fulfillment.assetTokenSpent
            chainId = fulfillment.chainId
            orderId = fulfillment.orderId
            paymentTokenFilled = fulfillment.paymentTokenFilled
            paymentTokenSpent = fulfillment.paymentTokenSpent
            transactionDt = fulfillment.transactionDt
            transactionHash = fulfillment.transactionHash
            paymentTokenFee = fulfillment.paymentTokenFee
            additionalProperties = fulfillment.additionalProperties.toMutableMap()
        }

        /** ID of the `OrderFulfillment`. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Amount of dShare asset token filled for `BUY` orders. */
        fun assetTokenFilled(assetTokenFilled: Double) =
            assetTokenFilled(JsonField.of(assetTokenFilled))

        /**
         * Sets [Builder.assetTokenFilled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assetTokenFilled] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun assetTokenFilled(assetTokenFilled: JsonField<Double>) = apply {
            this.assetTokenFilled = assetTokenFilled
        }

        /** Amount of dShare asset token spent for `SELL` orders. */
        fun assetTokenSpent(assetTokenSpent: Double) =
            assetTokenSpent(JsonField.of(assetTokenSpent))

        /**
         * Sets [Builder.assetTokenSpent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assetTokenSpent] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun assetTokenSpent(assetTokenSpent: JsonField<Double>) = apply {
            this.assetTokenSpent = assetTokenSpent
        }

        /** Blockchain that the transaction was run on. */
        fun chainId(chainId: Chain) = chainId(JsonField.of(chainId))

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [Chain] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<Chain>) = apply { this.chainId = chainId }

        /** ID of the `Order` this `OrderFulfillment` is for. */
        fun orderId(orderId: String) = orderId(JsonField.of(orderId))

        /**
         * Sets [Builder.orderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

        /** Amount of payment token filled for `SELL` orders. */
        fun paymentTokenFilled(paymentTokenFilled: Double) =
            paymentTokenFilled(JsonField.of(paymentTokenFilled))

        /**
         * Sets [Builder.paymentTokenFilled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentTokenFilled] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentTokenFilled(paymentTokenFilled: JsonField<Double>) = apply {
            this.paymentTokenFilled = paymentTokenFilled
        }

        /** Amount of payment token spent for `BUY` orders. */
        fun paymentTokenSpent(paymentTokenSpent: Double) =
            paymentTokenSpent(JsonField.of(paymentTokenSpent))

        /**
         * Sets [Builder.paymentTokenSpent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentTokenSpent] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentTokenSpent(paymentTokenSpent: JsonField<Double>) = apply {
            this.paymentTokenSpent = paymentTokenSpent
        }

        /** Time when transaction occurred. */
        fun transactionDt(transactionDt: OffsetDateTime) =
            transactionDt(JsonField.of(transactionDt))

        /**
         * Sets [Builder.transactionDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transactionDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun transactionDt(transactionDt: JsonField<OffsetDateTime>) = apply {
            this.transactionDt = transactionDt
        }

        /** Transaction hash for this fulfillment. */
        fun transactionHash(transactionHash: String) =
            transactionHash(JsonField.of(transactionHash))

        /**
         * Sets [Builder.transactionHash] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transactionHash] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun transactionHash(transactionHash: JsonField<String>) = apply {
            this.transactionHash = transactionHash
        }

        /** Fee amount, in payment tokens. */
        fun paymentTokenFee(paymentTokenFee: Double) =
            paymentTokenFee(JsonField.of(paymentTokenFee))

        /**
         * Sets [Builder.paymentTokenFee] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentTokenFee] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentTokenFee(paymentTokenFee: JsonField<Double>) = apply {
            this.paymentTokenFee = paymentTokenFee
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [Fulfillment].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .assetTokenFilled()
         * .assetTokenSpent()
         * .chainId()
         * .orderId()
         * .paymentTokenFilled()
         * .paymentTokenSpent()
         * .transactionDt()
         * .transactionHash()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Fulfillment =
            Fulfillment(
                checkRequired("id", id),
                checkRequired("assetTokenFilled", assetTokenFilled),
                checkRequired("assetTokenSpent", assetTokenSpent),
                checkRequired("chainId", chainId),
                checkRequired("orderId", orderId),
                checkRequired("paymentTokenFilled", paymentTokenFilled),
                checkRequired("paymentTokenSpent", paymentTokenSpent),
                checkRequired("transactionDt", transactionDt),
                checkRequired("transactionHash", transactionHash),
                paymentTokenFee,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Fulfillment = apply {
        if (validated) {
            return@apply
        }

        id()
        assetTokenFilled()
        assetTokenSpent()
        chainId().validate()
        orderId()
        paymentTokenFilled()
        paymentTokenSpent()
        transactionDt()
        transactionHash()
        paymentTokenFee()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (assetTokenFilled.asKnown().isPresent) 1 else 0) +
            (if (assetTokenSpent.asKnown().isPresent) 1 else 0) +
            (chainId.asKnown().getOrNull()?.validity() ?: 0) +
            (if (orderId.asKnown().isPresent) 1 else 0) +
            (if (paymentTokenFilled.asKnown().isPresent) 1 else 0) +
            (if (paymentTokenSpent.asKnown().isPresent) 1 else 0) +
            (if (transactionDt.asKnown().isPresent) 1 else 0) +
            (if (transactionHash.asKnown().isPresent) 1 else 0) +
            (if (paymentTokenFee.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Fulfillment &&
            id == other.id &&
            assetTokenFilled == other.assetTokenFilled &&
            assetTokenSpent == other.assetTokenSpent &&
            chainId == other.chainId &&
            orderId == other.orderId &&
            paymentTokenFilled == other.paymentTokenFilled &&
            paymentTokenSpent == other.paymentTokenSpent &&
            transactionDt == other.transactionDt &&
            transactionHash == other.transactionHash &&
            paymentTokenFee == other.paymentTokenFee &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            assetTokenFilled,
            assetTokenSpent,
            chainId,
            orderId,
            paymentTokenFilled,
            paymentTokenSpent,
            transactionDt,
            transactionHash,
            paymentTokenFee,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Fulfillment{id=$id, assetTokenFilled=$assetTokenFilled, assetTokenSpent=$assetTokenSpent, chainId=$chainId, orderId=$orderId, paymentTokenFilled=$paymentTokenFilled, paymentTokenSpent=$paymentTokenSpent, transactionDt=$transactionDt, transactionHash=$transactionHash, paymentTokenFee=$paymentTokenFee, additionalProperties=$additionalProperties}"
}
