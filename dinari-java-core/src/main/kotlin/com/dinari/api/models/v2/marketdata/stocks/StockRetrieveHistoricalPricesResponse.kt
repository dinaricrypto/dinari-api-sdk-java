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
import java.util.Collections
import java.util.Objects

/** Datapoint of historical price data for a `Stock`. */
class StockRetrieveHistoricalPricesResponse
private constructor(
    private val close: JsonField<Double>,
    private val high: JsonField<Double>,
    private val low: JsonField<Double>,
    private val open: JsonField<Double>,
    private val timestamp: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("close") @ExcludeMissing close: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("high") @ExcludeMissing high: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("low") @ExcludeMissing low: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("open") @ExcludeMissing open: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("timestamp") @ExcludeMissing timestamp: JsonField<Long> = JsonMissing.of(),
    ) : this(close, high, low, open, timestamp, mutableMapOf())

    /**
     * Close price from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun close(): Double = close.getRequired("close")

    /**
     * Highest price from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun high(): Double = high.getRequired("high")

    /**
     * Lowest price from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun low(): Double = low.getRequired("low")

    /**
     * Open price from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun open(): Double = open.getRequired("open")

    /**
     * The UNIX timestamp in seconds for the start of the aggregate window.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun timestamp(): Long = timestamp.getRequired("timestamp")

    /**
     * Returns the raw JSON value of [close].
     *
     * Unlike [close], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("close") @ExcludeMissing fun _close(): JsonField<Double> = close

    /**
     * Returns the raw JSON value of [high].
     *
     * Unlike [high], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("high") @ExcludeMissing fun _high(): JsonField<Double> = high

    /**
     * Returns the raw JSON value of [low].
     *
     * Unlike [low], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("low") @ExcludeMissing fun _low(): JsonField<Double> = low

    /**
     * Returns the raw JSON value of [open].
     *
     * Unlike [open], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("open") @ExcludeMissing fun _open(): JsonField<Double> = open

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
         * Returns a mutable builder for constructing an instance of
         * [StockRetrieveHistoricalPricesResponse].
         *
         * The following fields are required:
         * ```java
         * .close()
         * .high()
         * .low()
         * .open()
         * .timestamp()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StockRetrieveHistoricalPricesResponse]. */
    class Builder internal constructor() {

        private var close: JsonField<Double>? = null
        private var high: JsonField<Double>? = null
        private var low: JsonField<Double>? = null
        private var open: JsonField<Double>? = null
        private var timestamp: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            stockRetrieveHistoricalPricesResponse: StockRetrieveHistoricalPricesResponse
        ) = apply {
            close = stockRetrieveHistoricalPricesResponse.close
            high = stockRetrieveHistoricalPricesResponse.high
            low = stockRetrieveHistoricalPricesResponse.low
            open = stockRetrieveHistoricalPricesResponse.open
            timestamp = stockRetrieveHistoricalPricesResponse.timestamp
            additionalProperties =
                stockRetrieveHistoricalPricesResponse.additionalProperties.toMutableMap()
        }

        /** Close price from the given time period. */
        fun close(close: Double) = close(JsonField.of(close))

        /**
         * Sets [Builder.close] to an arbitrary JSON value.
         *
         * You should usually call [Builder.close] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun close(close: JsonField<Double>) = apply { this.close = close }

        /** Highest price from the given time period. */
        fun high(high: Double) = high(JsonField.of(high))

        /**
         * Sets [Builder.high] to an arbitrary JSON value.
         *
         * You should usually call [Builder.high] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun high(high: JsonField<Double>) = apply { this.high = high }

        /** Lowest price from the given time period. */
        fun low(low: Double) = low(JsonField.of(low))

        /**
         * Sets [Builder.low] to an arbitrary JSON value.
         *
         * You should usually call [Builder.low] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun low(low: JsonField<Double>) = apply { this.low = low }

        /** Open price from the given time period. */
        fun open(open: Double) = open(JsonField.of(open))

        /**
         * Sets [Builder.open] to an arbitrary JSON value.
         *
         * You should usually call [Builder.open] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun open(open: JsonField<Double>) = apply { this.open = open }

        /** The UNIX timestamp in seconds for the start of the aggregate window. */
        fun timestamp(timestamp: Long) = timestamp(JsonField.of(timestamp))

        /**
         * Sets [Builder.timestamp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timestamp] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [StockRetrieveHistoricalPricesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .close()
         * .high()
         * .low()
         * .open()
         * .timestamp()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StockRetrieveHistoricalPricesResponse =
            StockRetrieveHistoricalPricesResponse(
                checkRequired("close", close),
                checkRequired("high", high),
                checkRequired("low", low),
                checkRequired("open", open),
                checkRequired("timestamp", timestamp),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StockRetrieveHistoricalPricesResponse = apply {
        if (validated) {
            return@apply
        }

        close()
        high()
        low()
        open()
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
        (if (close.asKnown().isPresent) 1 else 0) +
            (if (high.asKnown().isPresent) 1 else 0) +
            (if (low.asKnown().isPresent) 1 else 0) +
            (if (open.asKnown().isPresent) 1 else 0) +
            (if (timestamp.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StockRetrieveHistoricalPricesResponse &&
            close == other.close &&
            high == other.high &&
            low == other.low &&
            open == other.open &&
            timestamp == other.timestamp &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(close, high, low, open, timestamp, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StockRetrieveHistoricalPricesResponse{close=$close, high=$high, low=$low, open=$open, timestamp=$timestamp, additionalProperties=$additionalProperties}"
}
