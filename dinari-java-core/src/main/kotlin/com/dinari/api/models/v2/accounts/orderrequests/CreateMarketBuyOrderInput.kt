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

/** Input parameters for creating a market buy `OrderRequest`. */
class CreateMarketBuyOrderInput
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val paymentAmount: JsonField<Double>,
    private val stockId: JsonField<String>,
    private val recipientAccountId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("payment_amount")
        @ExcludeMissing
        paymentAmount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("recipient_account_id")
        @ExcludeMissing
        recipientAccountId: JsonField<String> = JsonMissing.of(),
    ) : this(paymentAmount, stockId, recipientAccountId, mutableMapOf())

    /**
     * Amount of currency (USD for US equities and ETFs) to pay for the order. Must be a positive
     * number with a precision of up to 2 decimal places.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentAmount(): Double = paymentAmount.getRequired("payment_amount")

    /**
     * ID of `Stock`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = stockId.getRequired("stock_id")

    /**
     * ID of `Account` to receive the `Order`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun recipientAccountId(): Optional<String> =
        recipientAccountId.getOptional("recipient_account_id")

    /**
     * Returns the raw JSON value of [paymentAmount].
     *
     * Unlike [paymentAmount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("payment_amount")
    @ExcludeMissing
    fun _paymentAmount(): JsonField<Double> = paymentAmount

    /**
     * Returns the raw JSON value of [stockId].
     *
     * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

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
         * Returns a mutable builder for constructing an instance of [CreateMarketBuyOrderInput].
         *
         * The following fields are required:
         * ```java
         * .paymentAmount()
         * .stockId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreateMarketBuyOrderInput]. */
    class Builder internal constructor() {

        private var paymentAmount: JsonField<Double>? = null
        private var stockId: JsonField<String>? = null
        private var recipientAccountId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(createMarketBuyOrderInput: CreateMarketBuyOrderInput) = apply {
            paymentAmount = createMarketBuyOrderInput.paymentAmount
            stockId = createMarketBuyOrderInput.stockId
            recipientAccountId = createMarketBuyOrderInput.recipientAccountId
            additionalProperties = createMarketBuyOrderInput.additionalProperties.toMutableMap()
        }

        /**
         * Amount of currency (USD for US equities and ETFs) to pay for the order. Must be a
         * positive number with a precision of up to 2 decimal places.
         */
        fun paymentAmount(paymentAmount: Double) = paymentAmount(JsonField.of(paymentAmount))

        /**
         * Sets [Builder.paymentAmount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentAmount] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun paymentAmount(paymentAmount: JsonField<Double>) = apply {
            this.paymentAmount = paymentAmount
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
         * Returns an immutable instance of [CreateMarketBuyOrderInput].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .paymentAmount()
         * .stockId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreateMarketBuyOrderInput =
            CreateMarketBuyOrderInput(
                checkRequired("paymentAmount", paymentAmount),
                checkRequired("stockId", stockId),
                recipientAccountId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreateMarketBuyOrderInput = apply {
        if (validated) {
            return@apply
        }

        paymentAmount()
        stockId()
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
        (if (paymentAmount.asKnown().isPresent) 1 else 0) +
            (if (stockId.asKnown().isPresent) 1 else 0) +
            (if (recipientAccountId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreateMarketBuyOrderInput &&
            paymentAmount == other.paymentAmount &&
            stockId == other.stockId &&
            recipientAccountId == other.recipientAccountId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(paymentAmount, stockId, recipientAccountId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreateMarketBuyOrderInput{paymentAmount=$paymentAmount, stockId=$stockId, recipientAccountId=$recipientAccountId, additionalProperties=$additionalProperties}"
}
