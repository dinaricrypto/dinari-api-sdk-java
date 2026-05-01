// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Input parameters for creating a market sell `OrderRequest`. */
class CreateMarketSellOrderInput
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val assetQuantity: JsonField<Double>,
    private val alloyId: JsonField<String>,
    private val clientOrderId: JsonField<String>,
    private val fee: JsonField<Double>,
    private val paymentTokenAddress: JsonField<String>,
    private val recipientAccountId: JsonField<String>,
    private val stockId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("asset_quantity")
        @ExcludeMissing
        assetQuantity: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("alloy_id") @ExcludeMissing alloyId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("client_order_id")
        @ExcludeMissing
        clientOrderId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fee") @ExcludeMissing fee: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("payment_token_address")
        @ExcludeMissing
        paymentTokenAddress: JsonField<String> = JsonMissing.of(),
        @JsonProperty("recipient_account_id")
        @ExcludeMissing
        recipientAccountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
    ) : this(
        assetQuantity,
        alloyId,
        clientOrderId,
        fee,
        paymentTokenAddress,
        recipientAccountId,
        stockId,
        mutableMapOf(),
    )

    /**
     * Quantity of shares to trade. Must be a positive number with a precision of up to 6 decimal
     * places.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assetQuantity(): Double = assetQuantity.getRequired("asset_quantity")

    /**
     * ID of `Alloy`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun alloyId(): Optional<String> = alloyId.getOptional("alloy_id")

    /**
     * Customer-supplied ID to map this order to an order in their own systems. Must be unique
     * within the entity.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientOrderId(): Optional<String> = clientOrderId.getOptional("client_order_id")

    /**
     * Optional fee amount associated with `Order` in USD for DFN orders. Must be a positive number
     * with a precision of up to 6 decimal places.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fee(): Optional<Double> = fee.getOptional("fee")

    /**
     * Address of the payment token to be used for the sell order. If not provided, the default
     * payment token (USD+) will be used. Should only be specified if `recipient_account_id` for a
     * non-managed wallet account is also provided.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentTokenAddress(): Optional<String> =
        paymentTokenAddress.getOptional("payment_token_address")

    /**
     * ID of `Account` to receive the `Order`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun recipientAccountId(): Optional<String> =
        recipientAccountId.getOptional("recipient_account_id")

    /**
     * ID of `Stock`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun stockId(): Optional<String> = stockId.getOptional("stock_id")

    /**
     * Returns the raw JSON value of [assetQuantity].
     *
     * Unlike [assetQuantity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("asset_quantity")
    @ExcludeMissing
    fun _assetQuantity(): JsonField<Double> = assetQuantity

    /**
     * Returns the raw JSON value of [alloyId].
     *
     * Unlike [alloyId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("alloy_id") @ExcludeMissing fun _alloyId(): JsonField<String> = alloyId

    /**
     * Returns the raw JSON value of [clientOrderId].
     *
     * Unlike [clientOrderId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client_order_id")
    @ExcludeMissing
    fun _clientOrderId(): JsonField<String> = clientOrderId

    /**
     * Returns the raw JSON value of [fee].
     *
     * Unlike [fee], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fee") @ExcludeMissing fun _fee(): JsonField<Double> = fee

    /**
     * Returns the raw JSON value of [paymentTokenAddress].
     *
     * Unlike [paymentTokenAddress], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("payment_token_address")
    @ExcludeMissing
    fun _paymentTokenAddress(): JsonField<String> = paymentTokenAddress

    /**
     * Returns the raw JSON value of [recipientAccountId].
     *
     * Unlike [recipientAccountId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("recipient_account_id")
    @ExcludeMissing
    fun _recipientAccountId(): JsonField<String> = recipientAccountId

    /**
     * Returns the raw JSON value of [stockId].
     *
     * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

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
         * Returns a mutable builder for constructing an instance of [CreateMarketSellOrderInput].
         *
         * The following fields are required:
         * ```java
         * .assetQuantity()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreateMarketSellOrderInput]. */
    class Builder internal constructor() {

        private var assetQuantity: JsonField<Double>? = null
        private var alloyId: JsonField<String> = JsonMissing.of()
        private var clientOrderId: JsonField<String> = JsonMissing.of()
        private var fee: JsonField<Double> = JsonMissing.of()
        private var paymentTokenAddress: JsonField<String> = JsonMissing.of()
        private var recipientAccountId: JsonField<String> = JsonMissing.of()
        private var stockId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(createMarketSellOrderInput: CreateMarketSellOrderInput) = apply {
            assetQuantity = createMarketSellOrderInput.assetQuantity
            alloyId = createMarketSellOrderInput.alloyId
            clientOrderId = createMarketSellOrderInput.clientOrderId
            fee = createMarketSellOrderInput.fee
            paymentTokenAddress = createMarketSellOrderInput.paymentTokenAddress
            recipientAccountId = createMarketSellOrderInput.recipientAccountId
            stockId = createMarketSellOrderInput.stockId
            additionalProperties = createMarketSellOrderInput.additionalProperties.toMutableMap()
        }

        /**
         * Quantity of shares to trade. Must be a positive number with a precision of up to 6
         * decimal places.
         */
        fun assetQuantity(assetQuantity: Double) = assetQuantity(JsonField.of(assetQuantity))

        /**
         * Sets [Builder.assetQuantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assetQuantity] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun assetQuantity(assetQuantity: JsonField<Double>) = apply {
            this.assetQuantity = assetQuantity
        }

        /** ID of `Alloy`. */
        fun alloyId(alloyId: String?) = alloyId(JsonField.ofNullable(alloyId))

        /** Alias for calling [Builder.alloyId] with `alloyId.orElse(null)`. */
        fun alloyId(alloyId: Optional<String>) = alloyId(alloyId.getOrNull())

        /**
         * Sets [Builder.alloyId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.alloyId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun alloyId(alloyId: JsonField<String>) = apply { this.alloyId = alloyId }

        /**
         * Customer-supplied ID to map this order to an order in their own systems. Must be unique
         * within the entity.
         */
        fun clientOrderId(clientOrderId: String?) =
            clientOrderId(JsonField.ofNullable(clientOrderId))

        /** Alias for calling [Builder.clientOrderId] with `clientOrderId.orElse(null)`. */
        fun clientOrderId(clientOrderId: Optional<String>) =
            clientOrderId(clientOrderId.getOrNull())

        /**
         * Sets [Builder.clientOrderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientOrderId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clientOrderId(clientOrderId: JsonField<String>) = apply {
            this.clientOrderId = clientOrderId
        }

        /**
         * Optional fee amount associated with `Order` in USD for DFN orders. Must be a positive
         * number with a precision of up to 6 decimal places.
         */
        fun fee(fee: Double?) = fee(JsonField.ofNullable(fee))

        /**
         * Alias for [Builder.fee].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun fee(fee: Double) = fee(fee as Double?)

        /** Alias for calling [Builder.fee] with `fee.orElse(null)`. */
        fun fee(fee: Optional<Double>) = fee(fee.getOrNull())

        /**
         * Sets [Builder.fee] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fee] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fee(fee: JsonField<Double>) = apply { this.fee = fee }

        /**
         * Address of the payment token to be used for the sell order. If not provided, the default
         * payment token (USD+) will be used. Should only be specified if `recipient_account_id` for
         * a non-managed wallet account is also provided.
         */
        fun paymentTokenAddress(paymentTokenAddress: String?) =
            paymentTokenAddress(JsonField.ofNullable(paymentTokenAddress))

        /**
         * Alias for calling [Builder.paymentTokenAddress] with `paymentTokenAddress.orElse(null)`.
         */
        fun paymentTokenAddress(paymentTokenAddress: Optional<String>) =
            paymentTokenAddress(paymentTokenAddress.getOrNull())

        /**
         * Sets [Builder.paymentTokenAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentTokenAddress] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentTokenAddress(paymentTokenAddress: JsonField<String>) = apply {
            this.paymentTokenAddress = paymentTokenAddress
        }

        /** ID of `Account` to receive the `Order`. */
        fun recipientAccountId(recipientAccountId: String?) =
            recipientAccountId(JsonField.ofNullable(recipientAccountId))

        /**
         * Alias for calling [Builder.recipientAccountId] with `recipientAccountId.orElse(null)`.
         */
        fun recipientAccountId(recipientAccountId: Optional<String>) =
            recipientAccountId(recipientAccountId.getOrNull())

        /**
         * Sets [Builder.recipientAccountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipientAccountId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recipientAccountId(recipientAccountId: JsonField<String>) = apply {
            this.recipientAccountId = recipientAccountId
        }

        /** ID of `Stock`. */
        fun stockId(stockId: String?) = stockId(JsonField.ofNullable(stockId))

        /** Alias for calling [Builder.stockId] with `stockId.orElse(null)`. */
        fun stockId(stockId: Optional<String>) = stockId(stockId.getOrNull())

        /**
         * Sets [Builder.stockId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stockId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

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
         * Returns an immutable instance of [CreateMarketSellOrderInput].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .assetQuantity()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreateMarketSellOrderInput =
            CreateMarketSellOrderInput(
                checkRequired("assetQuantity", assetQuantity),
                alloyId,
                clientOrderId,
                fee,
                paymentTokenAddress,
                recipientAccountId,
                stockId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreateMarketSellOrderInput = apply {
        if (validated) {
            return@apply
        }

        assetQuantity()
        alloyId()
        clientOrderId()
        fee()
        paymentTokenAddress()
        recipientAccountId()
        stockId()
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
        (if (assetQuantity.asKnown().isPresent) 1 else 0) +
            (if (alloyId.asKnown().isPresent) 1 else 0) +
            (if (clientOrderId.asKnown().isPresent) 1 else 0) +
            (if (fee.asKnown().isPresent) 1 else 0) +
            (if (paymentTokenAddress.asKnown().isPresent) 1 else 0) +
            (if (recipientAccountId.asKnown().isPresent) 1 else 0) +
            (if (stockId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreateMarketSellOrderInput &&
            assetQuantity == other.assetQuantity &&
            alloyId == other.alloyId &&
            clientOrderId == other.clientOrderId &&
            fee == other.fee &&
            paymentTokenAddress == other.paymentTokenAddress &&
            recipientAccountId == other.recipientAccountId &&
            stockId == other.stockId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            assetQuantity,
            alloyId,
            clientOrderId,
            fee,
            paymentTokenAddress,
            recipientAccountId,
            stockId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreateMarketSellOrderInput{assetQuantity=$assetQuantity, alloyId=$alloyId, clientOrderId=$clientOrderId, fee=$fee, paymentTokenAddress=$paymentTokenAddress, recipientAccountId=$recipientAccountId, stockId=$stockId, additionalProperties=$additionalProperties}"
}
