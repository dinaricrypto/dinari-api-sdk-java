// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata

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

class MarketDataRetrieveMarketHoursResponse
private constructor(
    private val isMarketOpen: JsonField<Boolean>,
    private val nextSessionCloseDt: JsonField<OffsetDateTime>,
    private val nextSessionOpenDt: JsonField<OffsetDateTime>,
    private val currentSessionCloseDt: JsonField<OffsetDateTime>,
    private val currentSessionOpenDt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("is_market_open")
        @ExcludeMissing
        isMarketOpen: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_session_close_dt")
        @ExcludeMissing
        nextSessionCloseDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("next_session_open_dt")
        @ExcludeMissing
        nextSessionOpenDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("current_session_close_dt")
        @ExcludeMissing
        currentSessionCloseDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("current_session_open_dt")
        @ExcludeMissing
        currentSessionOpenDt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        isMarketOpen,
        nextSessionCloseDt,
        nextSessionOpenDt,
        currentSessionCloseDt,
        currentSessionOpenDt,
        mutableMapOf(),
    )

    /**
     * Whether or not the market is open
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isMarketOpen(): Boolean = isMarketOpen.getRequired("is_market_open")

    /**
     * Datetime at which the next session closes. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun nextSessionCloseDt(): OffsetDateTime =
        nextSessionCloseDt.getRequired("next_session_close_dt")

    /**
     * Datetime at which the next session opens. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun nextSessionOpenDt(): OffsetDateTime = nextSessionOpenDt.getRequired("next_session_open_dt")

    /**
     * Datetime at which the current session closes. `null` if the market is currently closed. ISO
     * 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun currentSessionCloseDt(): Optional<OffsetDateTime> =
        currentSessionCloseDt.getOptional("current_session_close_dt")

    /**
     * Datetime at which the current session opened. `null` if the market is currently closed. ISO
     * 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun currentSessionOpenDt(): Optional<OffsetDateTime> =
        currentSessionOpenDt.getOptional("current_session_open_dt")

    /**
     * Returns the raw JSON value of [isMarketOpen].
     *
     * Unlike [isMarketOpen], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_market_open")
    @ExcludeMissing
    fun _isMarketOpen(): JsonField<Boolean> = isMarketOpen

    /**
     * Returns the raw JSON value of [nextSessionCloseDt].
     *
     * Unlike [nextSessionCloseDt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("next_session_close_dt")
    @ExcludeMissing
    fun _nextSessionCloseDt(): JsonField<OffsetDateTime> = nextSessionCloseDt

    /**
     * Returns the raw JSON value of [nextSessionOpenDt].
     *
     * Unlike [nextSessionOpenDt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("next_session_open_dt")
    @ExcludeMissing
    fun _nextSessionOpenDt(): JsonField<OffsetDateTime> = nextSessionOpenDt

    /**
     * Returns the raw JSON value of [currentSessionCloseDt].
     *
     * Unlike [currentSessionCloseDt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("current_session_close_dt")
    @ExcludeMissing
    fun _currentSessionCloseDt(): JsonField<OffsetDateTime> = currentSessionCloseDt

    /**
     * Returns the raw JSON value of [currentSessionOpenDt].
     *
     * Unlike [currentSessionOpenDt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("current_session_open_dt")
    @ExcludeMissing
    fun _currentSessionOpenDt(): JsonField<OffsetDateTime> = currentSessionOpenDt

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
         * [MarketDataRetrieveMarketHoursResponse].
         *
         * The following fields are required:
         * ```java
         * .isMarketOpen()
         * .nextSessionCloseDt()
         * .nextSessionOpenDt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MarketDataRetrieveMarketHoursResponse]. */
    class Builder internal constructor() {

        private var isMarketOpen: JsonField<Boolean>? = null
        private var nextSessionCloseDt: JsonField<OffsetDateTime>? = null
        private var nextSessionOpenDt: JsonField<OffsetDateTime>? = null
        private var currentSessionCloseDt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var currentSessionOpenDt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            marketDataRetrieveMarketHoursResponse: MarketDataRetrieveMarketHoursResponse
        ) = apply {
            isMarketOpen = marketDataRetrieveMarketHoursResponse.isMarketOpen
            nextSessionCloseDt = marketDataRetrieveMarketHoursResponse.nextSessionCloseDt
            nextSessionOpenDt = marketDataRetrieveMarketHoursResponse.nextSessionOpenDt
            currentSessionCloseDt = marketDataRetrieveMarketHoursResponse.currentSessionCloseDt
            currentSessionOpenDt = marketDataRetrieveMarketHoursResponse.currentSessionOpenDt
            additionalProperties =
                marketDataRetrieveMarketHoursResponse.additionalProperties.toMutableMap()
        }

        /** Whether or not the market is open */
        fun isMarketOpen(isMarketOpen: Boolean) = isMarketOpen(JsonField.of(isMarketOpen))

        /**
         * Sets [Builder.isMarketOpen] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isMarketOpen] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isMarketOpen(isMarketOpen: JsonField<Boolean>) = apply {
            this.isMarketOpen = isMarketOpen
        }

        /** Datetime at which the next session closes. ISO 8601 timestamp. */
        fun nextSessionCloseDt(nextSessionCloseDt: OffsetDateTime) =
            nextSessionCloseDt(JsonField.of(nextSessionCloseDt))

        /**
         * Sets [Builder.nextSessionCloseDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextSessionCloseDt] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun nextSessionCloseDt(nextSessionCloseDt: JsonField<OffsetDateTime>) = apply {
            this.nextSessionCloseDt = nextSessionCloseDt
        }

        /** Datetime at which the next session opens. ISO 8601 timestamp. */
        fun nextSessionOpenDt(nextSessionOpenDt: OffsetDateTime) =
            nextSessionOpenDt(JsonField.of(nextSessionOpenDt))

        /**
         * Sets [Builder.nextSessionOpenDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextSessionOpenDt] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun nextSessionOpenDt(nextSessionOpenDt: JsonField<OffsetDateTime>) = apply {
            this.nextSessionOpenDt = nextSessionOpenDt
        }

        /**
         * Datetime at which the current session closes. `null` if the market is currently closed.
         * ISO 8601 timestamp.
         */
        fun currentSessionCloseDt(currentSessionCloseDt: OffsetDateTime) =
            currentSessionCloseDt(JsonField.of(currentSessionCloseDt))

        /**
         * Sets [Builder.currentSessionCloseDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currentSessionCloseDt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun currentSessionCloseDt(currentSessionCloseDt: JsonField<OffsetDateTime>) = apply {
            this.currentSessionCloseDt = currentSessionCloseDt
        }

        /**
         * Datetime at which the current session opened. `null` if the market is currently closed.
         * ISO 8601 timestamp.
         */
        fun currentSessionOpenDt(currentSessionOpenDt: OffsetDateTime) =
            currentSessionOpenDt(JsonField.of(currentSessionOpenDt))

        /**
         * Sets [Builder.currentSessionOpenDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currentSessionOpenDt] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun currentSessionOpenDt(currentSessionOpenDt: JsonField<OffsetDateTime>) = apply {
            this.currentSessionOpenDt = currentSessionOpenDt
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
         * Returns an immutable instance of [MarketDataRetrieveMarketHoursResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .isMarketOpen()
         * .nextSessionCloseDt()
         * .nextSessionOpenDt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MarketDataRetrieveMarketHoursResponse =
            MarketDataRetrieveMarketHoursResponse(
                checkRequired("isMarketOpen", isMarketOpen),
                checkRequired("nextSessionCloseDt", nextSessionCloseDt),
                checkRequired("nextSessionOpenDt", nextSessionOpenDt),
                currentSessionCloseDt,
                currentSessionOpenDt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MarketDataRetrieveMarketHoursResponse = apply {
        if (validated) {
            return@apply
        }

        isMarketOpen()
        nextSessionCloseDt()
        nextSessionOpenDt()
        currentSessionCloseDt()
        currentSessionOpenDt()
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
        (if (isMarketOpen.asKnown().isPresent) 1 else 0) +
            (if (nextSessionCloseDt.asKnown().isPresent) 1 else 0) +
            (if (nextSessionOpenDt.asKnown().isPresent) 1 else 0) +
            (if (currentSessionCloseDt.asKnown().isPresent) 1 else 0) +
            (if (currentSessionOpenDt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MarketDataRetrieveMarketHoursResponse && isMarketOpen == other.isMarketOpen && nextSessionCloseDt == other.nextSessionCloseDt && nextSessionOpenDt == other.nextSessionOpenDt && currentSessionCloseDt == other.currentSessionCloseDt && currentSessionOpenDt == other.currentSessionOpenDt && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(isMarketOpen, nextSessionCloseDt, nextSessionOpenDt, currentSessionCloseDt, currentSessionOpenDt, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MarketDataRetrieveMarketHoursResponse{isMarketOpen=$isMarketOpen, nextSessionCloseDt=$nextSessionCloseDt, nextSessionOpenDt=$nextSessionOpenDt, currentSessionCloseDt=$currentSessionCloseDt, currentSessionOpenDt=$currentSessionOpenDt, additionalProperties=$additionalProperties}"
}
