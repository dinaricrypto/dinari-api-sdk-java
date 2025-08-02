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

/** Input parameters for creating a market sell `OrderRequest`. */
class CreateMarketSellOrderInput
private constructor(
    private val assetQuantity: JsonField<Double>,
    private val stockId: JsonField<String>,
    private val paymentTokenAddress: JsonField<String>,
    private val recipientAccountId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("asset_quantity")
        @ExcludeMissing
        assetQuantity: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("payment_token_address")
        @ExcludeMissing
        paymentTokenAddress: JsonField<String> = JsonMissing.of(),
        @JsonProperty("recipient_account_id")
        @ExcludeMissing
        recipientAccountId: JsonField<String> = JsonMissing.of(),
    ) : this(assetQuantity, stockId, paymentTokenAddress, recipientAccountId, mutableMapOf())

    /**
     * Quantity of shares to trade. Must be a positive number with a precision of up to 9 decimal
     * places.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assetQuantity(): Double = assetQuantity.getRequired("asset_quantity")

    /**
     * ID of `Stock`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = stockId.getRequired("stock_id")

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
     * Returns the raw JSON value of [assetQuantity].
     *
     * Unlike [assetQuantity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("asset_quantity")
    @ExcludeMissing
    fun _assetQuantity(): JsonField<Double> = assetQuantity

    /**
     * Returns the raw JSON value of [stockId].
     *
     * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

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
         * .stockId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreateMarketSellOrderInput]. */
    class Builder internal constructor() {

        private var assetQuantity: JsonField<Double>? = null
        private var stockId: JsonField<String>? = null
        private var paymentTokenAddress: JsonField<String> = JsonMissing.of()
        private var recipientAccountId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(createMarketSellOrderInput: CreateMarketSellOrderInput) = apply {
            assetQuantity = createMarketSellOrderInput.assetQuantity
            stockId = createMarketSellOrderInput.stockId
            paymentTokenAddress = createMarketSellOrderInput.paymentTokenAddress
            recipientAccountId = createMarketSellOrderInput.recipientAccountId
            additionalProperties = createMarketSellOrderInput.additionalProperties.toMutableMap()
        }

        /**
         * Quantity of shares to trade. Must be a positive number with a precision of up to 9
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

        /** ID of `Stock`. */
        fun stockId(stockId: String) = stockId(JsonField.of(stockId))

        /**
         * Sets [Builder.stockId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stockId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

        /**
         * Address of the payment token to be used for the sell order. If not provided, the default
         * payment token (USD+) will be used. Should only be specified if `recipient_account_id` for
         * a non-managed wallet account is also provided.
         */
        fun paymentTokenAddress(paymentTokenAddress: String) =
            paymentTokenAddress(JsonField.of(paymentTokenAddress))

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
        fun recipientAccountId(recipientAccountId: String) =
            recipientAccountId(JsonField.of(recipientAccountId))

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
         * .stockId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreateMarketSellOrderInput =
            CreateMarketSellOrderInput(
                checkRequired("assetQuantity", assetQuantity),
                checkRequired("stockId", stockId),
                paymentTokenAddress,
                recipientAccountId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreateMarketSellOrderInput = apply {
        if (validated) {
            return@apply
        }

        assetQuantity()
        stockId()
        paymentTokenAddress()
        recipientAccountId()
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
            (if (stockId.asKnown().isPresent) 1 else 0) +
            (if (paymentTokenAddress.asKnown().isPresent) 1 else 0) +
            (if (recipientAccountId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CreateMarketSellOrderInput && assetQuantity == other.assetQuantity && stockId == other.stockId && paymentTokenAddress == other.paymentTokenAddress && recipientAccountId == other.recipientAccountId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(assetQuantity, stockId, paymentTokenAddress, recipientAccountId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreateMarketSellOrderInput{assetQuantity=$assetQuantity, stockId=$stockId, paymentTokenAddress=$paymentTokenAddress, recipientAccountId=$recipientAccountId, additionalProperties=$additionalProperties}"
}
