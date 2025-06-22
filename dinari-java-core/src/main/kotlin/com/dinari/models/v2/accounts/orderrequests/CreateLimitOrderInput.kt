// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts.orderrequests

import com.dinari.core.ExcludeMissing
import com.dinari.core.JsonField
import com.dinari.core.JsonMissing
import com.dinari.core.JsonValue
import com.dinari.core.checkRequired
import com.dinari.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects

/** Input parameters for creating a limit `OrderRequest`. */
class CreateLimitOrderInput
private constructor(
    private val assetQuantity: JsonField<Long>,
    private val limitPrice: JsonField<Double>,
    private val stockId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("asset_quantity")
        @ExcludeMissing
        assetQuantity: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("limit_price")
        @ExcludeMissing
        limitPrice: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
    ) : this(assetQuantity, limitPrice, stockId, mutableMapOf())

    /**
     * Quantity of shares to trade. Must be a positive integer.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assetQuantity(): Long = assetQuantity.getRequired("asset_quantity")

    /**
     * Price at which to execute the order. Must be a positive number with a precision of up to 2
     * decimal places.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun limitPrice(): Double = limitPrice.getRequired("limit_price")

    /**
     * ID of `Stock`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = stockId.getRequired("stock_id")

    /**
     * Returns the raw JSON value of [assetQuantity].
     *
     * Unlike [assetQuantity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("asset_quantity")
    @ExcludeMissing
    fun _assetQuantity(): JsonField<Long> = assetQuantity

    /**
     * Returns the raw JSON value of [limitPrice].
     *
     * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("limit_price") @ExcludeMissing fun _limitPrice(): JsonField<Double> = limitPrice

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
         * Returns a mutable builder for constructing an instance of [CreateLimitOrderInput].
         *
         * The following fields are required:
         * ```java
         * .assetQuantity()
         * .limitPrice()
         * .stockId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreateLimitOrderInput]. */
    class Builder internal constructor() {

        private var assetQuantity: JsonField<Long>? = null
        private var limitPrice: JsonField<Double>? = null
        private var stockId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(createLimitOrderInput: CreateLimitOrderInput) = apply {
            assetQuantity = createLimitOrderInput.assetQuantity
            limitPrice = createLimitOrderInput.limitPrice
            stockId = createLimitOrderInput.stockId
            additionalProperties = createLimitOrderInput.additionalProperties.toMutableMap()
        }

        /** Quantity of shares to trade. Must be a positive integer. */
        fun assetQuantity(assetQuantity: Long) = assetQuantity(JsonField.of(assetQuantity))

        /**
         * Sets [Builder.assetQuantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assetQuantity] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun assetQuantity(assetQuantity: JsonField<Long>) = apply {
            this.assetQuantity = assetQuantity
        }

        /**
         * Price at which to execute the order. Must be a positive number with a precision of up to
         * 2 decimal places.
         */
        fun limitPrice(limitPrice: Double) = limitPrice(JsonField.of(limitPrice))

        /**
         * Sets [Builder.limitPrice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limitPrice] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun limitPrice(limitPrice: JsonField<Double>) = apply { this.limitPrice = limitPrice }

        /** ID of `Stock`. */
        fun stockId(stockId: String) = stockId(JsonField.of(stockId))

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
         * Returns an immutable instance of [CreateLimitOrderInput].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .assetQuantity()
         * .limitPrice()
         * .stockId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreateLimitOrderInput =
            CreateLimitOrderInput(
                checkRequired("assetQuantity", assetQuantity),
                checkRequired("limitPrice", limitPrice),
                checkRequired("stockId", stockId),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreateLimitOrderInput = apply {
        if (validated) {
            return@apply
        }

        assetQuantity()
        limitPrice()
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
            (if (limitPrice.asKnown().isPresent) 1 else 0) +
            (if (stockId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CreateLimitOrderInput && assetQuantity == other.assetQuantity && limitPrice == other.limitPrice && stockId == other.stockId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(assetQuantity, limitPrice, stockId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreateLimitOrderInput{assetQuantity=$assetQuantity, limitPrice=$limitPrice, stockId=$stockId, additionalProperties=$additionalProperties}"
}
