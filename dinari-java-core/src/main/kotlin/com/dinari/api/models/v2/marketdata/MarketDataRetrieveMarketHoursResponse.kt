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
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val isMarketOpen: JsonField<Boolean>,
    private val nextSessionCloseDt: JsonField<OffsetDateTime>,
    private val nextSessionOpenDt: JsonField<OffsetDateTime>,
    private val currentSessionAfterHoursCloseTimeDt: JsonField<OffsetDateTime>,
    private val currentSessionCloseDt: JsonField<OffsetDateTime>,
    private val currentSessionOpenDt: JsonField<OffsetDateTime>,
    private val currentSessionOvernightOpenTimeDt: JsonField<OffsetDateTime>,
    private val currentSessionPreMarketOpenTimeDt: JsonField<OffsetDateTime>,
    private val nextSessionAfterHoursCloseTimeDt: JsonField<OffsetDateTime>,
    private val nextSessionOvernightOpenTimeDt: JsonField<OffsetDateTime>,
    private val nextSessionPreMarketOpenTimeDt: JsonField<OffsetDateTime>,
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
        @JsonProperty("current_session_after_hours_close_time_dt")
        @ExcludeMissing
        currentSessionAfterHoursCloseTimeDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("current_session_close_dt")
        @ExcludeMissing
        currentSessionCloseDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("current_session_open_dt")
        @ExcludeMissing
        currentSessionOpenDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("current_session_overnight_open_time_dt")
        @ExcludeMissing
        currentSessionOvernightOpenTimeDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("current_session_pre_market_open_time_dt")
        @ExcludeMissing
        currentSessionPreMarketOpenTimeDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("next_session_after_hours_close_time_dt")
        @ExcludeMissing
        nextSessionAfterHoursCloseTimeDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("next_session_overnight_open_time_dt")
        @ExcludeMissing
        nextSessionOvernightOpenTimeDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("next_session_pre_market_open_time_dt")
        @ExcludeMissing
        nextSessionPreMarketOpenTimeDt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        isMarketOpen,
        nextSessionCloseDt,
        nextSessionOpenDt,
        currentSessionAfterHoursCloseTimeDt,
        currentSessionCloseDt,
        currentSessionOpenDt,
        currentSessionOvernightOpenTimeDt,
        currentSessionPreMarketOpenTimeDt,
        nextSessionAfterHoursCloseTimeDt,
        nextSessionOvernightOpenTimeDt,
        nextSessionPreMarketOpenTimeDt,
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
     * Time at which the current session after-hours end.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun currentSessionAfterHoursCloseTimeDt(): Optional<OffsetDateTime> =
        currentSessionAfterHoursCloseTimeDt.getOptional("current_session_after_hours_close_time_dt")

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
     * Time at which the current session overnight starts.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun currentSessionOvernightOpenTimeDt(): Optional<OffsetDateTime> =
        currentSessionOvernightOpenTimeDt.getOptional("current_session_overnight_open_time_dt")

    /**
     * Time at which the current session pre-market hours start.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun currentSessionPreMarketOpenTimeDt(): Optional<OffsetDateTime> =
        currentSessionPreMarketOpenTimeDt.getOptional("current_session_pre_market_open_time_dt")

    /**
     * Time at which the next session after-hours end.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nextSessionAfterHoursCloseTimeDt(): Optional<OffsetDateTime> =
        nextSessionAfterHoursCloseTimeDt.getOptional("next_session_after_hours_close_time_dt")

    /**
     * Time at which the next session overnight starts.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nextSessionOvernightOpenTimeDt(): Optional<OffsetDateTime> =
        nextSessionOvernightOpenTimeDt.getOptional("next_session_overnight_open_time_dt")

    /**
     * Time at which the next session pre-market hours start.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nextSessionPreMarketOpenTimeDt(): Optional<OffsetDateTime> =
        nextSessionPreMarketOpenTimeDt.getOptional("next_session_pre_market_open_time_dt")

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
     * Returns the raw JSON value of [currentSessionAfterHoursCloseTimeDt].
     *
     * Unlike [currentSessionAfterHoursCloseTimeDt], this method doesn't throw if the JSON field has
     * an unexpected type.
     */
    @JsonProperty("current_session_after_hours_close_time_dt")
    @ExcludeMissing
    fun _currentSessionAfterHoursCloseTimeDt(): JsonField<OffsetDateTime> =
        currentSessionAfterHoursCloseTimeDt

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

    /**
     * Returns the raw JSON value of [currentSessionOvernightOpenTimeDt].
     *
     * Unlike [currentSessionOvernightOpenTimeDt], this method doesn't throw if the JSON field has
     * an unexpected type.
     */
    @JsonProperty("current_session_overnight_open_time_dt")
    @ExcludeMissing
    fun _currentSessionOvernightOpenTimeDt(): JsonField<OffsetDateTime> =
        currentSessionOvernightOpenTimeDt

    /**
     * Returns the raw JSON value of [currentSessionPreMarketOpenTimeDt].
     *
     * Unlike [currentSessionPreMarketOpenTimeDt], this method doesn't throw if the JSON field has
     * an unexpected type.
     */
    @JsonProperty("current_session_pre_market_open_time_dt")
    @ExcludeMissing
    fun _currentSessionPreMarketOpenTimeDt(): JsonField<OffsetDateTime> =
        currentSessionPreMarketOpenTimeDt

    /**
     * Returns the raw JSON value of [nextSessionAfterHoursCloseTimeDt].
     *
     * Unlike [nextSessionAfterHoursCloseTimeDt], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("next_session_after_hours_close_time_dt")
    @ExcludeMissing
    fun _nextSessionAfterHoursCloseTimeDt(): JsonField<OffsetDateTime> =
        nextSessionAfterHoursCloseTimeDt

    /**
     * Returns the raw JSON value of [nextSessionOvernightOpenTimeDt].
     *
     * Unlike [nextSessionOvernightOpenTimeDt], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("next_session_overnight_open_time_dt")
    @ExcludeMissing
    fun _nextSessionOvernightOpenTimeDt(): JsonField<OffsetDateTime> =
        nextSessionOvernightOpenTimeDt

    /**
     * Returns the raw JSON value of [nextSessionPreMarketOpenTimeDt].
     *
     * Unlike [nextSessionPreMarketOpenTimeDt], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("next_session_pre_market_open_time_dt")
    @ExcludeMissing
    fun _nextSessionPreMarketOpenTimeDt(): JsonField<OffsetDateTime> =
        nextSessionPreMarketOpenTimeDt

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
        private var currentSessionAfterHoursCloseTimeDt: JsonField<OffsetDateTime> =
            JsonMissing.of()
        private var currentSessionCloseDt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var currentSessionOpenDt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var currentSessionOvernightOpenTimeDt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var currentSessionPreMarketOpenTimeDt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var nextSessionAfterHoursCloseTimeDt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var nextSessionOvernightOpenTimeDt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var nextSessionPreMarketOpenTimeDt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            marketDataRetrieveMarketHoursResponse: MarketDataRetrieveMarketHoursResponse
        ) = apply {
            isMarketOpen = marketDataRetrieveMarketHoursResponse.isMarketOpen
            nextSessionCloseDt = marketDataRetrieveMarketHoursResponse.nextSessionCloseDt
            nextSessionOpenDt = marketDataRetrieveMarketHoursResponse.nextSessionOpenDt
            currentSessionAfterHoursCloseTimeDt =
                marketDataRetrieveMarketHoursResponse.currentSessionAfterHoursCloseTimeDt
            currentSessionCloseDt = marketDataRetrieveMarketHoursResponse.currentSessionCloseDt
            currentSessionOpenDt = marketDataRetrieveMarketHoursResponse.currentSessionOpenDt
            currentSessionOvernightOpenTimeDt =
                marketDataRetrieveMarketHoursResponse.currentSessionOvernightOpenTimeDt
            currentSessionPreMarketOpenTimeDt =
                marketDataRetrieveMarketHoursResponse.currentSessionPreMarketOpenTimeDt
            nextSessionAfterHoursCloseTimeDt =
                marketDataRetrieveMarketHoursResponse.nextSessionAfterHoursCloseTimeDt
            nextSessionOvernightOpenTimeDt =
                marketDataRetrieveMarketHoursResponse.nextSessionOvernightOpenTimeDt
            nextSessionPreMarketOpenTimeDt =
                marketDataRetrieveMarketHoursResponse.nextSessionPreMarketOpenTimeDt
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

        /** Time at which the current session after-hours end. */
        fun currentSessionAfterHoursCloseTimeDt(
            currentSessionAfterHoursCloseTimeDt: OffsetDateTime
        ) = currentSessionAfterHoursCloseTimeDt(JsonField.of(currentSessionAfterHoursCloseTimeDt))

        /**
         * Sets [Builder.currentSessionAfterHoursCloseTimeDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currentSessionAfterHoursCloseTimeDt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun currentSessionAfterHoursCloseTimeDt(
            currentSessionAfterHoursCloseTimeDt: JsonField<OffsetDateTime>
        ) = apply { this.currentSessionAfterHoursCloseTimeDt = currentSessionAfterHoursCloseTimeDt }

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

        /** Time at which the current session overnight starts. */
        fun currentSessionOvernightOpenTimeDt(currentSessionOvernightOpenTimeDt: OffsetDateTime) =
            currentSessionOvernightOpenTimeDt(JsonField.of(currentSessionOvernightOpenTimeDt))

        /**
         * Sets [Builder.currentSessionOvernightOpenTimeDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currentSessionOvernightOpenTimeDt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun currentSessionOvernightOpenTimeDt(
            currentSessionOvernightOpenTimeDt: JsonField<OffsetDateTime>
        ) = apply { this.currentSessionOvernightOpenTimeDt = currentSessionOvernightOpenTimeDt }

        /** Time at which the current session pre-market hours start. */
        fun currentSessionPreMarketOpenTimeDt(currentSessionPreMarketOpenTimeDt: OffsetDateTime) =
            currentSessionPreMarketOpenTimeDt(JsonField.of(currentSessionPreMarketOpenTimeDt))

        /**
         * Sets [Builder.currentSessionPreMarketOpenTimeDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currentSessionPreMarketOpenTimeDt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun currentSessionPreMarketOpenTimeDt(
            currentSessionPreMarketOpenTimeDt: JsonField<OffsetDateTime>
        ) = apply { this.currentSessionPreMarketOpenTimeDt = currentSessionPreMarketOpenTimeDt }

        /** Time at which the next session after-hours end. */
        fun nextSessionAfterHoursCloseTimeDt(nextSessionAfterHoursCloseTimeDt: OffsetDateTime) =
            nextSessionAfterHoursCloseTimeDt(JsonField.of(nextSessionAfterHoursCloseTimeDt))

        /**
         * Sets [Builder.nextSessionAfterHoursCloseTimeDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextSessionAfterHoursCloseTimeDt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun nextSessionAfterHoursCloseTimeDt(
            nextSessionAfterHoursCloseTimeDt: JsonField<OffsetDateTime>
        ) = apply { this.nextSessionAfterHoursCloseTimeDt = nextSessionAfterHoursCloseTimeDt }

        /** Time at which the next session overnight starts. */
        fun nextSessionOvernightOpenTimeDt(nextSessionOvernightOpenTimeDt: OffsetDateTime) =
            nextSessionOvernightOpenTimeDt(JsonField.of(nextSessionOvernightOpenTimeDt))

        /**
         * Sets [Builder.nextSessionOvernightOpenTimeDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextSessionOvernightOpenTimeDt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun nextSessionOvernightOpenTimeDt(
            nextSessionOvernightOpenTimeDt: JsonField<OffsetDateTime>
        ) = apply { this.nextSessionOvernightOpenTimeDt = nextSessionOvernightOpenTimeDt }

        /** Time at which the next session pre-market hours start. */
        fun nextSessionPreMarketOpenTimeDt(nextSessionPreMarketOpenTimeDt: OffsetDateTime) =
            nextSessionPreMarketOpenTimeDt(JsonField.of(nextSessionPreMarketOpenTimeDt))

        /**
         * Sets [Builder.nextSessionPreMarketOpenTimeDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextSessionPreMarketOpenTimeDt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun nextSessionPreMarketOpenTimeDt(
            nextSessionPreMarketOpenTimeDt: JsonField<OffsetDateTime>
        ) = apply { this.nextSessionPreMarketOpenTimeDt = nextSessionPreMarketOpenTimeDt }

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
                currentSessionAfterHoursCloseTimeDt,
                currentSessionCloseDt,
                currentSessionOpenDt,
                currentSessionOvernightOpenTimeDt,
                currentSessionPreMarketOpenTimeDt,
                nextSessionAfterHoursCloseTimeDt,
                nextSessionOvernightOpenTimeDt,
                nextSessionPreMarketOpenTimeDt,
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
        currentSessionAfterHoursCloseTimeDt()
        currentSessionCloseDt()
        currentSessionOpenDt()
        currentSessionOvernightOpenTimeDt()
        currentSessionPreMarketOpenTimeDt()
        nextSessionAfterHoursCloseTimeDt()
        nextSessionOvernightOpenTimeDt()
        nextSessionPreMarketOpenTimeDt()
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
            (if (currentSessionAfterHoursCloseTimeDt.asKnown().isPresent) 1 else 0) +
            (if (currentSessionCloseDt.asKnown().isPresent) 1 else 0) +
            (if (currentSessionOpenDt.asKnown().isPresent) 1 else 0) +
            (if (currentSessionOvernightOpenTimeDt.asKnown().isPresent) 1 else 0) +
            (if (currentSessionPreMarketOpenTimeDt.asKnown().isPresent) 1 else 0) +
            (if (nextSessionAfterHoursCloseTimeDt.asKnown().isPresent) 1 else 0) +
            (if (nextSessionOvernightOpenTimeDt.asKnown().isPresent) 1 else 0) +
            (if (nextSessionPreMarketOpenTimeDt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MarketDataRetrieveMarketHoursResponse &&
            isMarketOpen == other.isMarketOpen &&
            nextSessionCloseDt == other.nextSessionCloseDt &&
            nextSessionOpenDt == other.nextSessionOpenDt &&
            currentSessionAfterHoursCloseTimeDt == other.currentSessionAfterHoursCloseTimeDt &&
            currentSessionCloseDt == other.currentSessionCloseDt &&
            currentSessionOpenDt == other.currentSessionOpenDt &&
            currentSessionOvernightOpenTimeDt == other.currentSessionOvernightOpenTimeDt &&
            currentSessionPreMarketOpenTimeDt == other.currentSessionPreMarketOpenTimeDt &&
            nextSessionAfterHoursCloseTimeDt == other.nextSessionAfterHoursCloseTimeDt &&
            nextSessionOvernightOpenTimeDt == other.nextSessionOvernightOpenTimeDt &&
            nextSessionPreMarketOpenTimeDt == other.nextSessionPreMarketOpenTimeDt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            isMarketOpen,
            nextSessionCloseDt,
            nextSessionOpenDt,
            currentSessionAfterHoursCloseTimeDt,
            currentSessionCloseDt,
            currentSessionOpenDt,
            currentSessionOvernightOpenTimeDt,
            currentSessionPreMarketOpenTimeDt,
            nextSessionAfterHoursCloseTimeDt,
            nextSessionOvernightOpenTimeDt,
            nextSessionPreMarketOpenTimeDt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MarketDataRetrieveMarketHoursResponse{isMarketOpen=$isMarketOpen, nextSessionCloseDt=$nextSessionCloseDt, nextSessionOpenDt=$nextSessionOpenDt, currentSessionAfterHoursCloseTimeDt=$currentSessionAfterHoursCloseTimeDt, currentSessionCloseDt=$currentSessionCloseDt, currentSessionOpenDt=$currentSessionOpenDt, currentSessionOvernightOpenTimeDt=$currentSessionOvernightOpenTimeDt, currentSessionPreMarketOpenTimeDt=$currentSessionPreMarketOpenTimeDt, nextSessionAfterHoursCloseTimeDt=$nextSessionAfterHoursCloseTimeDt, nextSessionOvernightOpenTimeDt=$nextSessionOvernightOpenTimeDt, nextSessionPreMarketOpenTimeDt=$nextSessionPreMarketOpenTimeDt, additionalProperties=$additionalProperties}"
}
