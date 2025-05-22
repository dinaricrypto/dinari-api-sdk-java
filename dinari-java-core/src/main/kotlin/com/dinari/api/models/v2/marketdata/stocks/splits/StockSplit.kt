// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks.splits

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
import java.time.LocalDate
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * Information about a stock split, including the `Stock` ID, the number of shares before and after
 * the split, the record date, payable date, ex-date, and the status of the split.
 */
class StockSplit
private constructor(
    private val id: JsonField<String>,
    private val exDate: JsonField<LocalDate>,
    private val payableDate: JsonField<LocalDate>,
    private val recordDate: JsonField<LocalDate>,
    private val splitFrom: JsonField<Double>,
    private val splitTo: JsonField<Double>,
    private val status: JsonField<Status>,
    private val stockId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("ex_date") @ExcludeMissing exDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("payable_date")
        @ExcludeMissing
        payableDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("record_date")
        @ExcludeMissing
        recordDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("split_from") @ExcludeMissing splitFrom: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("split_to") @ExcludeMissing splitTo: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        exDate,
        payableDate,
        recordDate,
        splitFrom,
        splitTo,
        status,
        stockId,
        mutableMapOf(),
    )

    /**
     * ID of the `StockSplit`
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Ex-date of the split in Eastern Time Zone. First day the stock trades at post-split prices.
     * Typically is last date in the process, and the main important date for investors. In ISO 8601
     * format, YYYY-MM-DD.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun exDate(): LocalDate = exDate.getRequired("ex_date")

    /**
     * Payable date of the split in Eastern Time Zone. This is the date when company will send out
     * the new shares. Mainly for record keeping by brokerages, who forward the shares to eventual
     * owners. Typically is the second date in the process. In ISO 8601 format, YYYY-MM-DD.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun payableDate(): LocalDate = payableDate.getRequired("payable_date")

    /**
     * Record date of the split in Eastern Time Zone, for company to determine where to send their
     * new shares. Mainly for record keeping by brokerages, who forward the shares to eventual
     * owners. Typically is the first date in the process. In ISO 8601 format, YYYY-MM-DD.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recordDate(): LocalDate = recordDate.getRequired("record_date")

    /**
     * The number of shares before the split. In a 10-for-1 split, this would be 1.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun splitFrom(): Double = splitFrom.getRequired("split_from")

    /**
     * The number of shares after the split. In a 10-for-1 split, this would be 10.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun splitTo(): Double = splitTo.getRequired("split_to")

    /**
     * The status of Dinari's processing of the `StockSplit`. `Stocks` for which this status is
     * `IN_PROGRESS` will not be available for trading.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * ID of the `Stock` whose shares are being split.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = stockId.getRequired("stock_id")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [exDate].
     *
     * Unlike [exDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ex_date") @ExcludeMissing fun _exDate(): JsonField<LocalDate> = exDate

    /**
     * Returns the raw JSON value of [payableDate].
     *
     * Unlike [payableDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("payable_date")
    @ExcludeMissing
    fun _payableDate(): JsonField<LocalDate> = payableDate

    /**
     * Returns the raw JSON value of [recordDate].
     *
     * Unlike [recordDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("record_date")
    @ExcludeMissing
    fun _recordDate(): JsonField<LocalDate> = recordDate

    /**
     * Returns the raw JSON value of [splitFrom].
     *
     * Unlike [splitFrom], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("split_from") @ExcludeMissing fun _splitFrom(): JsonField<Double> = splitFrom

    /**
     * Returns the raw JSON value of [splitTo].
     *
     * Unlike [splitTo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("split_to") @ExcludeMissing fun _splitTo(): JsonField<Double> = splitTo

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
         * Returns a mutable builder for constructing an instance of [StockSplit].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .exDate()
         * .payableDate()
         * .recordDate()
         * .splitFrom()
         * .splitTo()
         * .status()
         * .stockId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StockSplit]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var exDate: JsonField<LocalDate>? = null
        private var payableDate: JsonField<LocalDate>? = null
        private var recordDate: JsonField<LocalDate>? = null
        private var splitFrom: JsonField<Double>? = null
        private var splitTo: JsonField<Double>? = null
        private var status: JsonField<Status>? = null
        private var stockId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(stockSplit: StockSplit) = apply {
            id = stockSplit.id
            exDate = stockSplit.exDate
            payableDate = stockSplit.payableDate
            recordDate = stockSplit.recordDate
            splitFrom = stockSplit.splitFrom
            splitTo = stockSplit.splitTo
            status = stockSplit.status
            stockId = stockSplit.stockId
            additionalProperties = stockSplit.additionalProperties.toMutableMap()
        }

        /** ID of the `StockSplit` */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * Ex-date of the split in Eastern Time Zone. First day the stock trades at post-split
         * prices. Typically is last date in the process, and the main important date for investors.
         * In ISO 8601 format, YYYY-MM-DD.
         */
        fun exDate(exDate: LocalDate) = exDate(JsonField.of(exDate))

        /**
         * Sets [Builder.exDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exDate(exDate: JsonField<LocalDate>) = apply { this.exDate = exDate }

        /**
         * Payable date of the split in Eastern Time Zone. This is the date when company will send
         * out the new shares. Mainly for record keeping by brokerages, who forward the shares to
         * eventual owners. Typically is the second date in the process. In ISO 8601 format,
         * YYYY-MM-DD.
         */
        fun payableDate(payableDate: LocalDate) = payableDate(JsonField.of(payableDate))

        /**
         * Sets [Builder.payableDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.payableDate] with a well-typed [LocalDate] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun payableDate(payableDate: JsonField<LocalDate>) = apply {
            this.payableDate = payableDate
        }

        /**
         * Record date of the split in Eastern Time Zone, for company to determine where to send
         * their new shares. Mainly for record keeping by brokerages, who forward the shares to
         * eventual owners. Typically is the first date in the process. In ISO 8601 format,
         * YYYY-MM-DD.
         */
        fun recordDate(recordDate: LocalDate) = recordDate(JsonField.of(recordDate))

        /**
         * Sets [Builder.recordDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recordDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun recordDate(recordDate: JsonField<LocalDate>) = apply { this.recordDate = recordDate }

        /** The number of shares before the split. In a 10-for-1 split, this would be 1. */
        fun splitFrom(splitFrom: Double) = splitFrom(JsonField.of(splitFrom))

        /**
         * Sets [Builder.splitFrom] to an arbitrary JSON value.
         *
         * You should usually call [Builder.splitFrom] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun splitFrom(splitFrom: JsonField<Double>) = apply { this.splitFrom = splitFrom }

        /** The number of shares after the split. In a 10-for-1 split, this would be 10. */
        fun splitTo(splitTo: Double) = splitTo(JsonField.of(splitTo))

        /**
         * Sets [Builder.splitTo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.splitTo] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun splitTo(splitTo: JsonField<Double>) = apply { this.splitTo = splitTo }

        /**
         * The status of Dinari's processing of the `StockSplit`. `Stocks` for which this status is
         * `IN_PROGRESS` will not be available for trading.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** ID of the `Stock` whose shares are being split. */
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
         * Returns an immutable instance of [StockSplit].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .exDate()
         * .payableDate()
         * .recordDate()
         * .splitFrom()
         * .splitTo()
         * .status()
         * .stockId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StockSplit =
            StockSplit(
                checkRequired("id", id),
                checkRequired("exDate", exDate),
                checkRequired("payableDate", payableDate),
                checkRequired("recordDate", recordDate),
                checkRequired("splitFrom", splitFrom),
                checkRequired("splitTo", splitTo),
                checkRequired("status", status),
                checkRequired("stockId", stockId),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StockSplit = apply {
        if (validated) {
            return@apply
        }

        id()
        exDate()
        payableDate()
        recordDate()
        splitFrom()
        splitTo()
        status().validate()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (exDate.asKnown().isPresent) 1 else 0) +
            (if (payableDate.asKnown().isPresent) 1 else 0) +
            (if (recordDate.asKnown().isPresent) 1 else 0) +
            (if (splitFrom.asKnown().isPresent) 1 else 0) +
            (if (splitTo.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (stockId.asKnown().isPresent) 1 else 0)

    /**
     * The status of Dinari's processing of the `StockSplit`. `Stocks` for which this status is
     * `IN_PROGRESS` will not be available for trading.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PENDING = of("PENDING")

            @JvmField val IN_PROGRESS = of("IN_PROGRESS")

            @JvmField val COMPLETE = of("COMPLETE")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PENDING,
            IN_PROGRESS,
            COMPLETE,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PENDING,
            IN_PROGRESS,
            COMPLETE,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                PENDING -> Value.PENDING
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETE -> Value.COMPLETE
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
                PENDING -> Known.PENDING
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETE -> Known.COMPLETE
                else -> throw DinariInvalidDataException("Unknown Status: $value")
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

        fun validate(): Status = apply {
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

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StockSplit && id == other.id && exDate == other.exDate && payableDate == other.payableDate && recordDate == other.recordDate && splitFrom == other.splitFrom && splitTo == other.splitTo && status == other.status && stockId == other.stockId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, exDate, payableDate, recordDate, splitFrom, splitTo, status, stockId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StockSplit{id=$id, exDate=$exDate, payableDate=$payableDate, recordDate=$recordDate, splitFrom=$splitFrom, splitTo=$splitTo, status=$status, stockId=$stockId, additionalProperties=$additionalProperties}"
}
