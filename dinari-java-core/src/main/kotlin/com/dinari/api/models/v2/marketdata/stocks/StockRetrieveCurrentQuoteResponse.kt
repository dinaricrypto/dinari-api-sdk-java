// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects

class StockRetrieveCurrentQuoteResponse
private constructor(
    private val askPrice: JsonField<Double>,
    private val askSize: JsonField<Double>,
    private val bidPrice: JsonField<Double>,
    private val bidSize: JsonField<Double>,
    private val stockId: JsonField<String>,
    private val timestamp: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("ask_price") @ExcludeMissing askPrice: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("ask_size") @ExcludeMissing askSize: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("bid_price") @ExcludeMissing bidPrice: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("bid_size") @ExcludeMissing bidSize: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("timestamp")
        @ExcludeMissing
        timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(askPrice, askSize, bidPrice, bidSize, stockId, timestamp, mutableMapOf())

    /**
     * The ask price.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun askPrice(): Double = askPrice.getRequired("ask_price")

    /**
     * The ask size.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun askSize(): Double = askSize.getRequired("ask_size")

    /**
     * The bid price.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bidPrice(): Double = bidPrice.getRequired("bid_price")

    /**
     * The bid size.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bidSize(): Double = bidSize.getRequired("bid_size")

    /**
     * ID of the `Stock`
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = stockId.getRequired("stock_id")

    /**
     * When the Stock Quote was generated.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun timestamp(): OffsetDateTime = timestamp.getRequired("timestamp")

    /**
     * Returns the raw JSON value of [askPrice].
     *
     * Unlike [askPrice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ask_price") @ExcludeMissing fun _askPrice(): JsonField<Double> = askPrice

    /**
     * Returns the raw JSON value of [askSize].
     *
     * Unlike [askSize], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ask_size") @ExcludeMissing fun _askSize(): JsonField<Double> = askSize

    /**
     * Returns the raw JSON value of [bidPrice].
     *
     * Unlike [bidPrice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bid_price") @ExcludeMissing fun _bidPrice(): JsonField<Double> = bidPrice

    /**
     * Returns the raw JSON value of [bidSize].
     *
     * Unlike [bidSize], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bid_size") @ExcludeMissing fun _bidSize(): JsonField<Double> = bidSize

    /**
     * Returns the raw JSON value of [stockId].
     *
     * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

    /**
     * Returns the raw JSON value of [timestamp].
     *
     * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timestamp")
    @ExcludeMissing
    fun _timestamp(): JsonField<OffsetDateTime> = timestamp

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
         * Returns a mutable builder for constructing an instance of
         * [StockRetrieveCurrentQuoteResponse].
         *
         * The following fields are required:
         * ```java
         * .askPrice()
         * .askSize()
         * .bidPrice()
         * .bidSize()
         * .stockId()
         * .timestamp()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StockRetrieveCurrentQuoteResponse]. */
    class Builder internal constructor() {

        private var askPrice: JsonField<Double>? = null
        private var askSize: JsonField<Double>? = null
        private var bidPrice: JsonField<Double>? = null
        private var bidSize: JsonField<Double>? = null
        private var stockId: JsonField<String>? = null
        private var timestamp: JsonField<OffsetDateTime>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(stockRetrieveCurrentQuoteResponse: StockRetrieveCurrentQuoteResponse) =
            apply {
                askPrice = stockRetrieveCurrentQuoteResponse.askPrice
                askSize = stockRetrieveCurrentQuoteResponse.askSize
                bidPrice = stockRetrieveCurrentQuoteResponse.bidPrice
                bidSize = stockRetrieveCurrentQuoteResponse.bidSize
                stockId = stockRetrieveCurrentQuoteResponse.stockId
                timestamp = stockRetrieveCurrentQuoteResponse.timestamp
                additionalProperties =
                    stockRetrieveCurrentQuoteResponse.additionalProperties.toMutableMap()
            }

        /** The ask price. */
        fun askPrice(askPrice: Double) = askPrice(JsonField.of(askPrice))

        /**
         * Sets [Builder.askPrice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.askPrice] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun askPrice(askPrice: JsonField<Double>) = apply { this.askPrice = askPrice }

        /** The ask size. */
        fun askSize(askSize: Double) = askSize(JsonField.of(askSize))

        /**
         * Sets [Builder.askSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.askSize] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun askSize(askSize: JsonField<Double>) = apply { this.askSize = askSize }

        /** The bid price. */
        fun bidPrice(bidPrice: Double) = bidPrice(JsonField.of(bidPrice))

        /**
         * Sets [Builder.bidPrice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bidPrice] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bidPrice(bidPrice: JsonField<Double>) = apply { this.bidPrice = bidPrice }

        /** The bid size. */
        fun bidSize(bidSize: Double) = bidSize(JsonField.of(bidSize))

        /**
         * Sets [Builder.bidSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bidSize] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun bidSize(bidSize: JsonField<Double>) = apply { this.bidSize = bidSize }

        /** ID of the `Stock` */
        fun stockId(stockId: String) = stockId(JsonField.of(stockId))

        /**
         * Sets [Builder.stockId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stockId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

        /** When the Stock Quote was generated. */
        fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

        /**
         * Sets [Builder.timestamp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply { this.timestamp = timestamp }

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
         * Returns an immutable instance of [StockRetrieveCurrentQuoteResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .askPrice()
         * .askSize()
         * .bidPrice()
         * .bidSize()
         * .stockId()
         * .timestamp()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StockRetrieveCurrentQuoteResponse =
            StockRetrieveCurrentQuoteResponse(
                checkRequired("askPrice", askPrice),
                checkRequired("askSize", askSize),
                checkRequired("bidPrice", bidPrice),
                checkRequired("bidSize", bidSize),
                checkRequired("stockId", stockId),
                checkRequired("timestamp", timestamp),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StockRetrieveCurrentQuoteResponse = apply {
        if (validated) {
            return@apply
        }

        askPrice()
        askSize()
        bidPrice()
        bidSize()
        stockId()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (askPrice.asKnown().isPresent) 1 else 0) +
            (if (askSize.asKnown().isPresent) 1 else 0) +
            (if (bidPrice.asKnown().isPresent) 1 else 0) +
            (if (bidSize.asKnown().isPresent) 1 else 0) +
            (if (stockId.asKnown().isPresent) 1 else 0) +
            (if (timestamp.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StockRetrieveCurrentQuoteResponse &&
            askPrice == other.askPrice &&
            askSize == other.askSize &&
            bidPrice == other.bidPrice &&
            bidSize == other.bidSize &&
            stockId == other.stockId &&
            timestamp == other.timestamp &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(askPrice, askSize, bidPrice, bidSize, stockId, timestamp, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StockRetrieveCurrentQuoteResponse{askPrice=$askPrice, askSize=$askSize, bidPrice=$bidPrice, bidSize=$bidSize, stockId=$stockId, timestamp=$timestamp, additionalProperties=$additionalProperties}"
}
