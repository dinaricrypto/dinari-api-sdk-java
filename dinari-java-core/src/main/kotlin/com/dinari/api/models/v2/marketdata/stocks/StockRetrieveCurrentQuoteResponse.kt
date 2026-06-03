// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.BaseDeserializer
import com.dinari.api.core.BaseSerializer
import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.core.getOrThrow
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Stock Quote */
@JsonDeserialize(using = StockRetrieveCurrentQuoteResponse.Deserializer::class)
@JsonSerialize(using = StockRetrieveCurrentQuoteResponse.Serializer::class)
class StockRetrieveCurrentQuoteResponse
private constructor(
    private val quoteV1: StockQuoteV1? = null,
    private val quoteV2: StockQuoteV2? = null,
    private val _json: JsonValue? = null,
) {

    /** Stock Quote */
    fun quoteV1(): Optional<StockQuoteV1> = Optional.ofNullable(quoteV1)

    /** Stock Quote */
    fun quoteV2(): Optional<StockQuoteV2> = Optional.ofNullable(quoteV2)

    fun isQuoteV1(): Boolean = quoteV1 != null

    fun isQuoteV2(): Boolean = quoteV2 != null

    /** Stock Quote */
    fun asQuoteV1(): StockQuoteV1 = quoteV1.getOrThrow("quoteV1")

    /** Stock Quote */
    fun asQuoteV2(): StockQuoteV2 = quoteV2.getOrThrow("quoteV2")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.dinari.api.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = stockRetrieveCurrentQuoteResponse.accept(new StockRetrieveCurrentQuoteResponse.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitQuoteV1(StockQuoteV1 quoteV1) {
     *         return Optional.of(quoteV1.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws DinariInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            quoteV1 != null -> visitor.visitQuoteV1(quoteV1)
            quoteV2 != null -> visitor.visitQuoteV2(quoteV2)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws DinariInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): StockRetrieveCurrentQuoteResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitQuoteV1(quoteV1: StockQuoteV1) {
                    quoteV1.validate()
                }

                override fun visitQuoteV2(quoteV2: StockQuoteV2) {
                    quoteV2.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitQuoteV1(quoteV1: StockQuoteV1) = quoteV1.validity()

                override fun visitQuoteV2(quoteV2: StockQuoteV2) = quoteV2.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StockRetrieveCurrentQuoteResponse &&
            quoteV1 == other.quoteV1 &&
            quoteV2 == other.quoteV2
    }

    override fun hashCode(): Int = Objects.hash(quoteV1, quoteV2)

    override fun toString(): String =
        when {
            quoteV1 != null -> "StockRetrieveCurrentQuoteResponse{quoteV1=$quoteV1}"
            quoteV2 != null -> "StockRetrieveCurrentQuoteResponse{quoteV2=$quoteV2}"
            _json != null -> "StockRetrieveCurrentQuoteResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid StockRetrieveCurrentQuoteResponse")
        }

    companion object {

        /** Stock Quote */
        @JvmStatic
        fun ofQuoteV1(quoteV1: StockQuoteV1) = StockRetrieveCurrentQuoteResponse(quoteV1 = quoteV1)

        /** Stock Quote */
        @JvmStatic
        fun ofQuoteV2(quoteV2: StockQuoteV2) = StockRetrieveCurrentQuoteResponse(quoteV2 = quoteV2)
    }

    /**
     * An interface that defines how to map each variant of [StockRetrieveCurrentQuoteResponse] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        /** Stock Quote */
        fun visitQuoteV1(quoteV1: StockQuoteV1): T

        /** Stock Quote */
        fun visitQuoteV2(quoteV2: StockQuoteV2): T

        /**
         * Maps an unknown variant of [StockRetrieveCurrentQuoteResponse] to a value of type [T].
         *
         * An instance of [StockRetrieveCurrentQuoteResponse] can contain an unknown variant if it
         * was deserialized from data that doesn't match any known variant. For example, if the SDK
         * is on an older version than the API, then the API may respond with new variants that the
         * SDK is unaware of.
         *
         * @throws DinariInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw DinariInvalidDataException("Unknown StockRetrieveCurrentQuoteResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<StockRetrieveCurrentQuoteResponse>(
            StockRetrieveCurrentQuoteResponse::class
        ) {

        override fun ObjectCodec.deserialize(node: JsonNode): StockRetrieveCurrentQuoteResponse {
            val json = JsonValue.fromJsonNode(node)
            val _sv = json.asObject().getOrNull()?.get("_sv")?.asString()?.getOrNull()

            when (_sv) {
                "StockQuote:v1" -> {
                    return tryDeserialize(node, jacksonTypeRef<StockQuoteV1>())?.let {
                        StockRetrieveCurrentQuoteResponse(quoteV1 = it, _json = json)
                    } ?: StockRetrieveCurrentQuoteResponse(_json = json)
                }
                "StockQuote:v2" -> {
                    return tryDeserialize(node, jacksonTypeRef<StockQuoteV2>())?.let {
                        StockRetrieveCurrentQuoteResponse(quoteV2 = it, _json = json)
                    } ?: StockRetrieveCurrentQuoteResponse(_json = json)
                }
            }

            return StockRetrieveCurrentQuoteResponse(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<StockRetrieveCurrentQuoteResponse>(
            StockRetrieveCurrentQuoteResponse::class
        ) {

        override fun serialize(
            value: StockRetrieveCurrentQuoteResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.quoteV1 != null -> generator.writeObject(value.quoteV1)
                value.quoteV2 != null -> generator.writeObject(value.quoteV2)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid StockRetrieveCurrentQuoteResponse")
            }
        }
    }

    /** Stock Quote */
    class StockQuoteV1
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val askPrice: JsonField<Double>,
        private val askSize: JsonField<Double>,
        private val bidPrice: JsonField<Double>,
        private val bidSize: JsonField<Double>,
        private val stockId: JsonField<String>,
        private val timestamp: JsonField<OffsetDateTime>,
        private val _sv: JsonField<_Sv>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ask_price")
            @ExcludeMissing
            askPrice: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("ask_size") @ExcludeMissing askSize: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("bid_price")
            @ExcludeMissing
            bidPrice: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("bid_size") @ExcludeMissing bidSize: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("timestamp")
            @ExcludeMissing
            timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("_sv") @ExcludeMissing _sv: JsonField<_Sv> = JsonMissing.of(),
        ) : this(askPrice, askSize, bidPrice, bidSize, stockId, timestamp, _sv, mutableMapOf())

        /**
         * The ask price. 0 if there is no active ask.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun askPrice(): Double = askPrice.getRequired("ask_price")

        /**
         * The ask size in shares.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun askSize(): Double = askSize.getRequired("ask_size")

        /**
         * The bid price. 0 if there is no active bid.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bidPrice(): Double = bidPrice.getRequired("bid_price")

        /**
         * The bid size in shares.
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
         * When the `StockQuote` was generated.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun timestamp(): OffsetDateTime = timestamp.getRequired("timestamp")

        /**
         * Schema version
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun _sv(): Optional<_Sv> = _sv.getOptional("_sv")

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
             * Returns a mutable builder for constructing an instance of [StockQuoteV1].
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

        /** A builder for [StockQuoteV1]. */
        class Builder internal constructor() {

            private var askPrice: JsonField<Double>? = null
            private var askSize: JsonField<Double>? = null
            private var bidPrice: JsonField<Double>? = null
            private var bidSize: JsonField<Double>? = null
            private var stockId: JsonField<String>? = null
            private var timestamp: JsonField<OffsetDateTime>? = null
            private var _sv: JsonField<_Sv> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(stockQuoteV1: StockQuoteV1) = apply {
                askPrice = stockQuoteV1.askPrice
                askSize = stockQuoteV1.askSize
                bidPrice = stockQuoteV1.bidPrice
                bidSize = stockQuoteV1.bidSize
                stockId = stockQuoteV1.stockId
                timestamp = stockQuoteV1.timestamp
                _sv = stockQuoteV1._sv
                additionalProperties = stockQuoteV1.additionalProperties.toMutableMap()
            }

            /** The ask price. 0 if there is no active ask. */
            fun askPrice(askPrice: Double) = askPrice(JsonField.of(askPrice))

            /**
             * Sets [Builder.askPrice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.askPrice] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun askPrice(askPrice: JsonField<Double>) = apply { this.askPrice = askPrice }

            /** The ask size in shares. */
            fun askSize(askSize: Double) = askSize(JsonField.of(askSize))

            /**
             * Sets [Builder.askSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.askSize] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun askSize(askSize: JsonField<Double>) = apply { this.askSize = askSize }

            /** The bid price. 0 if there is no active bid. */
            fun bidPrice(bidPrice: Double) = bidPrice(JsonField.of(bidPrice))

            /**
             * Sets [Builder.bidPrice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bidPrice] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bidPrice(bidPrice: JsonField<Double>) = apply { this.bidPrice = bidPrice }

            /** The bid size in shares. */
            fun bidSize(bidSize: Double) = bidSize(JsonField.of(bidSize))

            /**
             * Sets [Builder.bidSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bidSize] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bidSize(bidSize: JsonField<Double>) = apply { this.bidSize = bidSize }

            /** ID of the `Stock` */
            fun stockId(stockId: String) = stockId(JsonField.of(stockId))

            /**
             * Sets [Builder.stockId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stockId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

            /** When the `StockQuote` was generated. */
            fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

            /**
             * Sets [Builder.timestamp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply {
                this.timestamp = timestamp
            }

            /** Schema version */
            fun _sv(_sv: _Sv) = _sv(JsonField.of(_sv))

            /**
             * Sets [Builder._sv] to an arbitrary JSON value.
             *
             * You should usually call [Builder._sv] with a well-typed [_Sv] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * Returns an immutable instance of [StockQuoteV1].
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
            fun build(): StockQuoteV1 =
                StockQuoteV1(
                    checkRequired("askPrice", askPrice),
                    checkRequired("askSize", askSize),
                    checkRequired("bidPrice", bidPrice),
                    checkRequired("bidSize", bidSize),
                    checkRequired("stockId", stockId),
                    checkRequired("timestamp", timestamp),
                    _sv,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws DinariInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): StockQuoteV1 = apply {
            if (validated) {
                return@apply
            }

            askPrice()
            askSize()
            bidPrice()
            bidSize()
            stockId()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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
                (if (timestamp.asKnown().isPresent) 1 else 0) +
                (_sv.asKnown().getOrNull()?.validity() ?: 0)

        /** Schema version */
        class _Sv @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val STOCK_QUOTE_V1 = of("StockQuote:v1")

                @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
            }

            /** An enum containing [_Sv]'s known values. */
            enum class Known {
                STOCK_QUOTE_V1
            }

            /**
             * An enum containing [_Sv]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [_Sv] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                STOCK_QUOTE_V1,
                /** An enum member indicating that [_Sv] was instantiated with an unknown value. */
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
                    STOCK_QUOTE_V1 -> Value.STOCK_QUOTE_V1
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
                    STOCK_QUOTE_V1 -> Known.STOCK_QUOTE_V1
                    else -> throw DinariInvalidDataException("Unknown _Sv: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws DinariInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

            return other is StockQuoteV1 &&
                askPrice == other.askPrice &&
                askSize == other.askSize &&
                bidPrice == other.bidPrice &&
                bidSize == other.bidSize &&
                stockId == other.stockId &&
                timestamp == other.timestamp &&
                _sv == other._sv &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                askPrice,
                askSize,
                bidPrice,
                bidSize,
                stockId,
                timestamp,
                _sv,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "StockQuoteV1{askPrice=$askPrice, askSize=$askSize, bidPrice=$bidPrice, bidSize=$bidSize, stockId=$stockId, timestamp=$timestamp, _sv=$_sv, additionalProperties=$additionalProperties}"
    }

    /** Stock Quote */
    class StockQuoteV2
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val askPrice: JsonField<Double>,
        private val askSize: JsonField<Double>,
        private val bidPrice: JsonField<Double>,
        private val bidSize: JsonField<Double>,
        private val stockId: JsonField<String>,
        private val timestamp: JsonField<OffsetDateTime>,
        private val _sv: JsonField<_Sv>,
        private val askExchange: JsonField<String>,
        private val bidExchange: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ask_price")
            @ExcludeMissing
            askPrice: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("ask_size") @ExcludeMissing askSize: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("bid_price")
            @ExcludeMissing
            bidPrice: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("bid_size") @ExcludeMissing bidSize: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("timestamp")
            @ExcludeMissing
            timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("_sv") @ExcludeMissing _sv: JsonField<_Sv> = JsonMissing.of(),
            @JsonProperty("ask_exchange")
            @ExcludeMissing
            askExchange: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bid_exchange")
            @ExcludeMissing
            bidExchange: JsonField<String> = JsonMissing.of(),
        ) : this(
            askPrice,
            askSize,
            bidPrice,
            bidSize,
            stockId,
            timestamp,
            _sv,
            askExchange,
            bidExchange,
            mutableMapOf(),
        )

        /**
         * The ask price. 0 if there is no active ask.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun askPrice(): Double = askPrice.getRequired("ask_price")

        /**
         * The ask size in shares.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun askSize(): Double = askSize.getRequired("ask_size")

        /**
         * The bid price. 0 if there is no active bid.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun bidPrice(): Double = bidPrice.getRequired("bid_price")

        /**
         * The bid size in shares.
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
         * When the `StockQuote` was generated.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun timestamp(): OffsetDateTime = timestamp.getRequired("timestamp")

        /**
         * Schema version
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun _sv(): Optional<_Sv> = _sv.getOptional("_sv")

        /**
         * The ask exchange.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun askExchange(): Optional<String> = askExchange.getOptional("ask_exchange")

        /**
         * The bid exchange.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bidExchange(): Optional<String> = bidExchange.getOptional("bid_exchange")

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

        /**
         * Returns the raw JSON value of [_sv].
         *
         * Unlike [_sv], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("_sv") @ExcludeMissing fun __sv(): JsonField<_Sv> = _sv

        /**
         * Returns the raw JSON value of [askExchange].
         *
         * Unlike [askExchange], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ask_exchange")
        @ExcludeMissing
        fun _askExchange(): JsonField<String> = askExchange

        /**
         * Returns the raw JSON value of [bidExchange].
         *
         * Unlike [bidExchange], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bid_exchange")
        @ExcludeMissing
        fun _bidExchange(): JsonField<String> = bidExchange

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
             * Returns a mutable builder for constructing an instance of [StockQuoteV2].
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

        /** A builder for [StockQuoteV2]. */
        class Builder internal constructor() {

            private var askPrice: JsonField<Double>? = null
            private var askSize: JsonField<Double>? = null
            private var bidPrice: JsonField<Double>? = null
            private var bidSize: JsonField<Double>? = null
            private var stockId: JsonField<String>? = null
            private var timestamp: JsonField<OffsetDateTime>? = null
            private var _sv: JsonField<_Sv> = JsonMissing.of()
            private var askExchange: JsonField<String> = JsonMissing.of()
            private var bidExchange: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(stockQuoteV2: StockQuoteV2) = apply {
                askPrice = stockQuoteV2.askPrice
                askSize = stockQuoteV2.askSize
                bidPrice = stockQuoteV2.bidPrice
                bidSize = stockQuoteV2.bidSize
                stockId = stockQuoteV2.stockId
                timestamp = stockQuoteV2.timestamp
                _sv = stockQuoteV2._sv
                askExchange = stockQuoteV2.askExchange
                bidExchange = stockQuoteV2.bidExchange
                additionalProperties = stockQuoteV2.additionalProperties.toMutableMap()
            }

            /** The ask price. 0 if there is no active ask. */
            fun askPrice(askPrice: Double) = askPrice(JsonField.of(askPrice))

            /**
             * Sets [Builder.askPrice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.askPrice] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun askPrice(askPrice: JsonField<Double>) = apply { this.askPrice = askPrice }

            /** The ask size in shares. */
            fun askSize(askSize: Double) = askSize(JsonField.of(askSize))

            /**
             * Sets [Builder.askSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.askSize] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun askSize(askSize: JsonField<Double>) = apply { this.askSize = askSize }

            /** The bid price. 0 if there is no active bid. */
            fun bidPrice(bidPrice: Double) = bidPrice(JsonField.of(bidPrice))

            /**
             * Sets [Builder.bidPrice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bidPrice] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bidPrice(bidPrice: JsonField<Double>) = apply { this.bidPrice = bidPrice }

            /** The bid size in shares. */
            fun bidSize(bidSize: Double) = bidSize(JsonField.of(bidSize))

            /**
             * Sets [Builder.bidSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bidSize] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bidSize(bidSize: JsonField<Double>) = apply { this.bidSize = bidSize }

            /** ID of the `Stock` */
            fun stockId(stockId: String) = stockId(JsonField.of(stockId))

            /**
             * Sets [Builder.stockId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stockId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

            /** When the `StockQuote` was generated. */
            fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

            /**
             * Sets [Builder.timestamp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply {
                this.timestamp = timestamp
            }

            /** Schema version */
            fun _sv(_sv: _Sv) = _sv(JsonField.of(_sv))

            /**
             * Sets [Builder._sv] to an arbitrary JSON value.
             *
             * You should usually call [Builder._sv] with a well-typed [_Sv] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun _sv(_sv: JsonField<_Sv>) = apply { this._sv = _sv }

            /** The ask exchange. */
            fun askExchange(askExchange: String?) = askExchange(JsonField.ofNullable(askExchange))

            /** Alias for calling [Builder.askExchange] with `askExchange.orElse(null)`. */
            fun askExchange(askExchange: Optional<String>) = askExchange(askExchange.getOrNull())

            /**
             * Sets [Builder.askExchange] to an arbitrary JSON value.
             *
             * You should usually call [Builder.askExchange] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun askExchange(askExchange: JsonField<String>) = apply {
                this.askExchange = askExchange
            }

            /** The bid exchange. */
            fun bidExchange(bidExchange: String?) = bidExchange(JsonField.ofNullable(bidExchange))

            /** Alias for calling [Builder.bidExchange] with `bidExchange.orElse(null)`. */
            fun bidExchange(bidExchange: Optional<String>) = bidExchange(bidExchange.getOrNull())

            /**
             * Sets [Builder.bidExchange] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bidExchange] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bidExchange(bidExchange: JsonField<String>) = apply {
                this.bidExchange = bidExchange
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
             * Returns an immutable instance of [StockQuoteV2].
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
            fun build(): StockQuoteV2 =
                StockQuoteV2(
                    checkRequired("askPrice", askPrice),
                    checkRequired("askSize", askSize),
                    checkRequired("bidPrice", bidPrice),
                    checkRequired("bidSize", bidSize),
                    checkRequired("stockId", stockId),
                    checkRequired("timestamp", timestamp),
                    _sv,
                    askExchange,
                    bidExchange,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws DinariInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): StockQuoteV2 = apply {
            if (validated) {
                return@apply
            }

            askPrice()
            askSize()
            bidPrice()
            bidSize()
            stockId()
            timestamp()
            _sv().ifPresent { it.validate() }
            askExchange()
            bidExchange()
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
            (if (askPrice.asKnown().isPresent) 1 else 0) +
                (if (askSize.asKnown().isPresent) 1 else 0) +
                (if (bidPrice.asKnown().isPresent) 1 else 0) +
                (if (bidSize.asKnown().isPresent) 1 else 0) +
                (if (stockId.asKnown().isPresent) 1 else 0) +
                (if (timestamp.asKnown().isPresent) 1 else 0) +
                (_sv.asKnown().getOrNull()?.validity() ?: 0) +
                (if (askExchange.asKnown().isPresent) 1 else 0) +
                (if (bidExchange.asKnown().isPresent) 1 else 0)

        /** Schema version */
        class _Sv @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val STOCK_QUOTE_V2 = of("StockQuote:v2")

                @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
            }

            /** An enum containing [_Sv]'s known values. */
            enum class Known {
                STOCK_QUOTE_V2
            }

            /**
             * An enum containing [_Sv]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [_Sv] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                STOCK_QUOTE_V2,
                /** An enum member indicating that [_Sv] was instantiated with an unknown value. */
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
                    STOCK_QUOTE_V2 -> Value.STOCK_QUOTE_V2
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
                    STOCK_QUOTE_V2 -> Known.STOCK_QUOTE_V2
                    else -> throw DinariInvalidDataException("Unknown _Sv: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws DinariInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

            return other is StockQuoteV2 &&
                askPrice == other.askPrice &&
                askSize == other.askSize &&
                bidPrice == other.bidPrice &&
                bidSize == other.bidSize &&
                stockId == other.stockId &&
                timestamp == other.timestamp &&
                _sv == other._sv &&
                askExchange == other.askExchange &&
                bidExchange == other.bidExchange &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                askPrice,
                askSize,
                bidPrice,
                bidSize,
                stockId,
                timestamp,
                _sv,
                askExchange,
                bidExchange,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "StockQuoteV2{askPrice=$askPrice, askSize=$askSize, bidPrice=$bidPrice, bidSize=$bidSize, stockId=$stockId, timestamp=$timestamp, _sv=$_sv, askExchange=$askExchange, bidExchange=$bidExchange, additionalProperties=$additionalProperties}"
    }
}
