// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.alloys

import com.dinari.api.core.Enum
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

/** Datapoint of historical price data for an `Alloy`. */
class AlloyRetrieveHistoricalPricesResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val close: JsonField<Double>,
    private val high: JsonField<Double>,
    private val low: JsonField<Double>,
    private val open: JsonField<Double>,
    private val timestamp: JsonField<Long>,
    private val _sv: JsonField<_Sv>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("close") @ExcludeMissing close: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("high") @ExcludeMissing high: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("low") @ExcludeMissing low: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("open") @ExcludeMissing open: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("timestamp") @ExcludeMissing timestamp: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("_sv") @ExcludeMissing _sv: JsonField<_Sv> = JsonMissing.of(),
    ) : this(close, high, low, open, timestamp, _sv, mutableMapOf())

    /**
     * Close price from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun close(): Double = close.getRequired("close")

    /**
     * High price from the given time period.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun high(): Double = high.getRequired("high")

    /**
     * Low price from the given time period.
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
     * UNIX timestamp in seconds for the start of the aggregate window.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun timestamp(): Long = timestamp.getRequired("timestamp")

    /**
     * Schema version
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun _sv(): Optional<_Sv> = _sv.getOptional("_sv")

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

    /**
     * Returns the raw JSON value of [_sv].
     *
     * Unlike [_sv], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("_sv") @ExcludeMissing fun __sv(): JsonField<_Sv> = _sv

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
         * [AlloyRetrieveHistoricalPricesResponse].
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

    /** A builder for [AlloyRetrieveHistoricalPricesResponse]. */
    class Builder internal constructor() {

        private var close: JsonField<Double>? = null
        private var high: JsonField<Double>? = null
        private var low: JsonField<Double>? = null
        private var open: JsonField<Double>? = null
        private var timestamp: JsonField<Long>? = null
        private var _sv: JsonField<_Sv> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            alloyRetrieveHistoricalPricesResponse: AlloyRetrieveHistoricalPricesResponse
        ) = apply {
            close = alloyRetrieveHistoricalPricesResponse.close
            high = alloyRetrieveHistoricalPricesResponse.high
            low = alloyRetrieveHistoricalPricesResponse.low
            open = alloyRetrieveHistoricalPricesResponse.open
            timestamp = alloyRetrieveHistoricalPricesResponse.timestamp
            _sv = alloyRetrieveHistoricalPricesResponse._sv
            additionalProperties =
                alloyRetrieveHistoricalPricesResponse.additionalProperties.toMutableMap()
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

        /** High price from the given time period. */
        fun high(high: Double) = high(JsonField.of(high))

        /**
         * Sets [Builder.high] to an arbitrary JSON value.
         *
         * You should usually call [Builder.high] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun high(high: JsonField<Double>) = apply { this.high = high }

        /** Low price from the given time period. */
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

        /** UNIX timestamp in seconds for the start of the aggregate window. */
        fun timestamp(timestamp: Long) = timestamp(JsonField.of(timestamp))

        /**
         * Sets [Builder.timestamp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timestamp] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun timestamp(timestamp: JsonField<Long>) = apply { this.timestamp = timestamp }

        /** Schema version */
        fun _sv(_sv: _Sv) = _sv(JsonField.of(_sv))

        /**
         * Sets [Builder._sv] to an arbitrary JSON value.
         *
         * You should usually call [Builder._sv] with a well-typed [_Sv] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun _sv(_sv: JsonField<_Sv>) = apply { this._sv = _sv }

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
         * Returns an immutable instance of [AlloyRetrieveHistoricalPricesResponse].
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
        fun build(): AlloyRetrieveHistoricalPricesResponse =
            AlloyRetrieveHistoricalPricesResponse(
                checkRequired("close", close),
                checkRequired("high", high),
                checkRequired("low", low),
                checkRequired("open", open),
                checkRequired("timestamp", timestamp),
                _sv,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AlloyRetrieveHistoricalPricesResponse = apply {
        if (validated) {
            return@apply
        }

        close()
        high()
        low()
        open()
        timestamp()
        _sv().ifPresent { it.validate() }
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
            (if (timestamp.asKnown().isPresent) 1 else 0) +
            (_sv.asKnown().getOrNull()?.validity() ?: 0)

    /** Schema version */
    class _Sv @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField
            val ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1 = of("AlloyHistoricalPriceDataPointV1:v1")

            @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
        }

        /** An enum containing [_Sv]'s known values. */
        enum class Known {
            ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1
        }

        /**
         * An enum containing [_Sv]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [_Sv] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1,
            /** An enum member indicating that [_Sv] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1 ->
                    Value.ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws DinariInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1 ->
                    Known.ALLOY_HISTORICAL_PRICE_DATA_POINT_V1_V1
                else -> throw DinariInvalidDataException("Unknown _Sv: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws DinariInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { DinariInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): _Sv = apply {
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

            return other is _Sv && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AlloyRetrieveHistoricalPricesResponse &&
            close == other.close &&
            high == other.high &&
            low == other.low &&
            open == other.open &&
            timestamp == other.timestamp &&
            _sv == other._sv &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(close, high, low, open, timestamp, _sv, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AlloyRetrieveHistoricalPricesResponse{close=$close, high=$high, low=$low, open=$open, timestamp=$timestamp, _sv=$_sv, additionalProperties=$additionalProperties}"
}
