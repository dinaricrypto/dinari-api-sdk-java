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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class StockRetrieveCurrentPriceResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val price: JsonField<Double>,
    private val stockId: JsonField<String>,
    private val timestamp: JsonField<OffsetDateTime>,
    private val change: JsonField<Double>,
    private val changePercent: JsonField<Double>,
    private val close: JsonField<Double>,
    private val high: JsonField<Double>,
    private val low: JsonField<Double>,
    private val marketCap: JsonField<Long>,
    private val open: JsonField<Double>,
    private val previousClose: JsonField<Double>,
    private val volume: JsonField<Double>,
    private val weightedSharesOutstanding: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("price") @ExcludeMissing price: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("timestamp")
        @ExcludeMissing
        timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("change") @ExcludeMissing change: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("change_percent")
        @ExcludeMissing
        changePercent: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("close") @ExcludeMissing close: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("high") @ExcludeMissing high: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("low") @ExcludeMissing low: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("market_cap") @ExcludeMissing marketCap: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("open") @ExcludeMissing open: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("previous_close")
        @ExcludeMissing
        previousClose: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("volume") @ExcludeMissing volume: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("weighted_shares_outstanding")
        @ExcludeMissing
        weightedSharesOutstanding: JsonField<Long> = JsonMissing.of(),
    ) : this(
        price,
        stockId,
        timestamp,
        change,
        changePercent,
        close,
        high,
        low,
        marketCap,
        open,
        previousClose,
        volume,
        weightedSharesOutstanding,
        mutableMapOf(),
    )

    /**
     * The ask price.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun price(): Double = price.getRequired("price")

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
     * The change in price from the previous close.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun change(): Optional<Double> = change.getOptional("change")

    /**
     * The percentage change in price from the previous close.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun changePercent(): Optional<Double> = changePercent.getOptional("change_percent")

    /**
     * The close price from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun close(): Optional<Double> = close.getOptional("close")

    /**
     * The highest price from the given time period
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun high(): Optional<Double> = high.getOptional("high")

    /**
     * The lowest price from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun low(): Optional<Double> = low.getOptional("low")

    /**
     * The most recent close price of the ticker multiplied by weighted outstanding shares.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun marketCap(): Optional<Long> = marketCap.getOptional("market_cap")

    /**
     * The open price from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun open(): Optional<Double> = open.getOptional("open")

    /**
     * The close price for the `Stock` from the previous trading session.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun previousClose(): Optional<Double> = previousClose.getOptional("previous_close")

    /**
     * The trading volume from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun volume(): Optional<Double> = volume.getOptional("volume")

    /**
     * The number of shares outstanding in the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun weightedSharesOutstanding(): Optional<Long> =
        weightedSharesOutstanding.getOptional("weighted_shares_outstanding")

    /**
     * Returns the raw JSON value of [price].
     *
     * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<Double> = price

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

    /**
     * Returns the raw JSON value of [change].
     *
     * Unlike [change], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("change") @ExcludeMissing fun _change(): JsonField<Double> = change

    /**
     * Returns the raw JSON value of [changePercent].
     *
     * Unlike [changePercent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("change_percent")
    @ExcludeMissing
    fun _changePercent(): JsonField<Double> = changePercent

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
     * Returns the raw JSON value of [marketCap].
     *
     * Unlike [marketCap], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("market_cap") @ExcludeMissing fun _marketCap(): JsonField<Long> = marketCap

    /**
     * Returns the raw JSON value of [open].
     *
     * Unlike [open], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("open") @ExcludeMissing fun _open(): JsonField<Double> = open

    /**
     * Returns the raw JSON value of [previousClose].
     *
     * Unlike [previousClose], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("previous_close")
    @ExcludeMissing
    fun _previousClose(): JsonField<Double> = previousClose

    /**
     * Returns the raw JSON value of [volume].
     *
     * Unlike [volume], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("volume") @ExcludeMissing fun _volume(): JsonField<Double> = volume

    /**
     * Returns the raw JSON value of [weightedSharesOutstanding].
     *
     * Unlike [weightedSharesOutstanding], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("weighted_shares_outstanding")
    @ExcludeMissing
    fun _weightedSharesOutstanding(): JsonField<Long> = weightedSharesOutstanding

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
         * [StockRetrieveCurrentPriceResponse].
         *
         * The following fields are required:
         * ```java
         * .price()
         * .stockId()
         * .timestamp()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StockRetrieveCurrentPriceResponse]. */
    class Builder internal constructor() {

        private var price: JsonField<Double>? = null
        private var stockId: JsonField<String>? = null
        private var timestamp: JsonField<OffsetDateTime>? = null
        private var change: JsonField<Double> = JsonMissing.of()
        private var changePercent: JsonField<Double> = JsonMissing.of()
        private var close: JsonField<Double> = JsonMissing.of()
        private var high: JsonField<Double> = JsonMissing.of()
        private var low: JsonField<Double> = JsonMissing.of()
        private var marketCap: JsonField<Long> = JsonMissing.of()
        private var open: JsonField<Double> = JsonMissing.of()
        private var previousClose: JsonField<Double> = JsonMissing.of()
        private var volume: JsonField<Double> = JsonMissing.of()
        private var weightedSharesOutstanding: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(stockRetrieveCurrentPriceResponse: StockRetrieveCurrentPriceResponse) =
            apply {
                price = stockRetrieveCurrentPriceResponse.price
                stockId = stockRetrieveCurrentPriceResponse.stockId
                timestamp = stockRetrieveCurrentPriceResponse.timestamp
                change = stockRetrieveCurrentPriceResponse.change
                changePercent = stockRetrieveCurrentPriceResponse.changePercent
                close = stockRetrieveCurrentPriceResponse.close
                high = stockRetrieveCurrentPriceResponse.high
                low = stockRetrieveCurrentPriceResponse.low
                marketCap = stockRetrieveCurrentPriceResponse.marketCap
                open = stockRetrieveCurrentPriceResponse.open
                previousClose = stockRetrieveCurrentPriceResponse.previousClose
                volume = stockRetrieveCurrentPriceResponse.volume
                weightedSharesOutstanding =
                    stockRetrieveCurrentPriceResponse.weightedSharesOutstanding
                additionalProperties =
                    stockRetrieveCurrentPriceResponse.additionalProperties.toMutableMap()
            }

        /** The ask price. */
        fun price(price: Double) = price(JsonField.of(price))

        /**
         * Sets [Builder.price] to an arbitrary JSON value.
         *
         * You should usually call [Builder.price] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun price(price: JsonField<Double>) = apply { this.price = price }

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

        /** The change in price from the previous close. */
        fun change(change: Double?) = change(JsonField.ofNullable(change))

        /**
         * Alias for [Builder.change].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun change(change: Double) = change(change as Double?)

        /** Alias for calling [Builder.change] with `change.orElse(null)`. */
        fun change(change: Optional<Double>) = change(change.getOrNull())

        /**
         * Sets [Builder.change] to an arbitrary JSON value.
         *
         * You should usually call [Builder.change] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun change(change: JsonField<Double>) = apply { this.change = change }

        /** The percentage change in price from the previous close. */
        fun changePercent(changePercent: Double?) =
            changePercent(JsonField.ofNullable(changePercent))

        /**
         * Alias for [Builder.changePercent].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun changePercent(changePercent: Double) = changePercent(changePercent as Double?)

        /** Alias for calling [Builder.changePercent] with `changePercent.orElse(null)`. */
        fun changePercent(changePercent: Optional<Double>) =
            changePercent(changePercent.getOrNull())

        /**
         * Sets [Builder.changePercent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.changePercent] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun changePercent(changePercent: JsonField<Double>) = apply {
            this.changePercent = changePercent
        }

        /** The close price from the given time period. */
        fun close(close: Double?) = close(JsonField.ofNullable(close))

        /**
         * Alias for [Builder.close].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun close(close: Double) = close(close as Double?)

        /** Alias for calling [Builder.close] with `close.orElse(null)`. */
        fun close(close: Optional<Double>) = close(close.getOrNull())

        /**
         * Sets [Builder.close] to an arbitrary JSON value.
         *
         * You should usually call [Builder.close] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun close(close: JsonField<Double>) = apply { this.close = close }

        /** The highest price from the given time period */
        fun high(high: Double?) = high(JsonField.ofNullable(high))

        /**
         * Alias for [Builder.high].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun high(high: Double) = high(high as Double?)

        /** Alias for calling [Builder.high] with `high.orElse(null)`. */
        fun high(high: Optional<Double>) = high(high.getOrNull())

        /**
         * Sets [Builder.high] to an arbitrary JSON value.
         *
         * You should usually call [Builder.high] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun high(high: JsonField<Double>) = apply { this.high = high }

        /** The lowest price from the given time period. */
        fun low(low: Double?) = low(JsonField.ofNullable(low))

        /**
         * Alias for [Builder.low].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun low(low: Double) = low(low as Double?)

        /** Alias for calling [Builder.low] with `low.orElse(null)`. */
        fun low(low: Optional<Double>) = low(low.getOrNull())

        /**
         * Sets [Builder.low] to an arbitrary JSON value.
         *
         * You should usually call [Builder.low] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun low(low: JsonField<Double>) = apply { this.low = low }

        /** The most recent close price of the ticker multiplied by weighted outstanding shares. */
        fun marketCap(marketCap: Long?) = marketCap(JsonField.ofNullable(marketCap))

        /**
         * Alias for [Builder.marketCap].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun marketCap(marketCap: Long) = marketCap(marketCap as Long?)

        /** Alias for calling [Builder.marketCap] with `marketCap.orElse(null)`. */
        fun marketCap(marketCap: Optional<Long>) = marketCap(marketCap.getOrNull())

        /**
         * Sets [Builder.marketCap] to an arbitrary JSON value.
         *
         * You should usually call [Builder.marketCap] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun marketCap(marketCap: JsonField<Long>) = apply { this.marketCap = marketCap }

        /** The open price from the given time period. */
        fun open(open: Double?) = open(JsonField.ofNullable(open))

        /**
         * Alias for [Builder.open].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun open(open: Double) = open(open as Double?)

        /** Alias for calling [Builder.open] with `open.orElse(null)`. */
        fun open(open: Optional<Double>) = open(open.getOrNull())

        /**
         * Sets [Builder.open] to an arbitrary JSON value.
         *
         * You should usually call [Builder.open] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun open(open: JsonField<Double>) = apply { this.open = open }

        /** The close price for the `Stock` from the previous trading session. */
        fun previousClose(previousClose: Double?) =
            previousClose(JsonField.ofNullable(previousClose))

        /**
         * Alias for [Builder.previousClose].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun previousClose(previousClose: Double) = previousClose(previousClose as Double?)

        /** Alias for calling [Builder.previousClose] with `previousClose.orElse(null)`. */
        fun previousClose(previousClose: Optional<Double>) =
            previousClose(previousClose.getOrNull())

        /**
         * Sets [Builder.previousClose] to an arbitrary JSON value.
         *
         * You should usually call [Builder.previousClose] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun previousClose(previousClose: JsonField<Double>) = apply {
            this.previousClose = previousClose
        }

        /** The trading volume from the given time period. */
        fun volume(volume: Double?) = volume(JsonField.ofNullable(volume))

        /**
         * Alias for [Builder.volume].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun volume(volume: Double) = volume(volume as Double?)

        /** Alias for calling [Builder.volume] with `volume.orElse(null)`. */
        fun volume(volume: Optional<Double>) = volume(volume.getOrNull())

        /**
         * Sets [Builder.volume] to an arbitrary JSON value.
         *
         * You should usually call [Builder.volume] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun volume(volume: JsonField<Double>) = apply { this.volume = volume }

        /** The number of shares outstanding in the given time period. */
        fun weightedSharesOutstanding(weightedSharesOutstanding: Long?) =
            weightedSharesOutstanding(JsonField.ofNullable(weightedSharesOutstanding))

        /**
         * Alias for [Builder.weightedSharesOutstanding].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun weightedSharesOutstanding(weightedSharesOutstanding: Long) =
            weightedSharesOutstanding(weightedSharesOutstanding as Long?)

        /**
         * Alias for calling [Builder.weightedSharesOutstanding] with
         * `weightedSharesOutstanding.orElse(null)`.
         */
        fun weightedSharesOutstanding(weightedSharesOutstanding: Optional<Long>) =
            weightedSharesOutstanding(weightedSharesOutstanding.getOrNull())

        /**
         * Sets [Builder.weightedSharesOutstanding] to an arbitrary JSON value.
         *
         * You should usually call [Builder.weightedSharesOutstanding] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun weightedSharesOutstanding(weightedSharesOutstanding: JsonField<Long>) = apply {
            this.weightedSharesOutstanding = weightedSharesOutstanding
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
         * Returns an immutable instance of [StockRetrieveCurrentPriceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .price()
         * .stockId()
         * .timestamp()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StockRetrieveCurrentPriceResponse =
            StockRetrieveCurrentPriceResponse(
                checkRequired("price", price),
                checkRequired("stockId", stockId),
                checkRequired("timestamp", timestamp),
                change,
                changePercent,
                close,
                high,
                low,
                marketCap,
                open,
                previousClose,
                volume,
                weightedSharesOutstanding,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StockRetrieveCurrentPriceResponse = apply {
        if (validated) {
            return@apply
        }

        price()
        stockId()
        timestamp()
        change()
        changePercent()
        close()
        high()
        low()
        marketCap()
        open()
        previousClose()
        volume()
        weightedSharesOutstanding()
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
        (if (price.asKnown().isPresent) 1 else 0) +
            (if (stockId.asKnown().isPresent) 1 else 0) +
            (if (timestamp.asKnown().isPresent) 1 else 0) +
            (if (change.asKnown().isPresent) 1 else 0) +
            (if (changePercent.asKnown().isPresent) 1 else 0) +
            (if (close.asKnown().isPresent) 1 else 0) +
            (if (high.asKnown().isPresent) 1 else 0) +
            (if (low.asKnown().isPresent) 1 else 0) +
            (if (marketCap.asKnown().isPresent) 1 else 0) +
            (if (open.asKnown().isPresent) 1 else 0) +
            (if (previousClose.asKnown().isPresent) 1 else 0) +
            (if (volume.asKnown().isPresent) 1 else 0) +
            (if (weightedSharesOutstanding.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StockRetrieveCurrentPriceResponse &&
            price == other.price &&
            stockId == other.stockId &&
            timestamp == other.timestamp &&
            change == other.change &&
            changePercent == other.changePercent &&
            close == other.close &&
            high == other.high &&
            low == other.low &&
            marketCap == other.marketCap &&
            open == other.open &&
            previousClose == other.previousClose &&
            volume == other.volume &&
            weightedSharesOutstanding == other.weightedSharesOutstanding &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            price,
            stockId,
            timestamp,
            change,
            changePercent,
            close,
            high,
            low,
            marketCap,
            open,
            previousClose,
            volume,
            weightedSharesOutstanding,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StockRetrieveCurrentPriceResponse{price=$price, stockId=$stockId, timestamp=$timestamp, change=$change, changePercent=$changePercent, close=$close, high=$high, low=$low, marketCap=$marketCap, open=$open, previousClose=$previousClose, volume=$volume, weightedSharesOutstanding=$weightedSharesOutstanding, additionalProperties=$additionalProperties}"
}
