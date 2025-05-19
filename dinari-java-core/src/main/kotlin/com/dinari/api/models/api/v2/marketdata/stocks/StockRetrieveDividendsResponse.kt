// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.marketdata.stocks

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Information about a dividend announcement for a `Stock`. */
class StockRetrieveDividendsResponse
private constructor(
    private val cashAmount: JsonField<Double>,
    private val currency: JsonField<String>,
    private val declarationDate: JsonField<LocalDate>,
    private val dividendType: JsonField<String>,
    private val exDividendDate: JsonField<LocalDate>,
    private val frequency: JsonField<Long>,
    private val payDate: JsonField<LocalDate>,
    private val recordDate: JsonField<LocalDate>,
    private val ticker: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("cash_amount")
        @ExcludeMissing
        cashAmount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("currency") @ExcludeMissing currency: JsonField<String> = JsonMissing.of(),
        @JsonProperty("declaration_date")
        @ExcludeMissing
        declarationDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("dividend_type")
        @ExcludeMissing
        dividendType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("ex_dividend_date")
        @ExcludeMissing
        exDividendDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("frequency") @ExcludeMissing frequency: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("pay_date") @ExcludeMissing payDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("record_date")
        @ExcludeMissing
        recordDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("ticker") @ExcludeMissing ticker: JsonField<String> = JsonMissing.of(),
    ) : this(
        cashAmount,
        currency,
        declarationDate,
        dividendType,
        exDividendDate,
        frequency,
        payDate,
        recordDate,
        ticker,
        mutableMapOf(),
    )

    /**
     * Cash amount of the dividend per share owned.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cashAmount(): Optional<Double> = cashAmount.getOptional("cash_amount")

    /**
     * Currency in which the dividend is paid.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun currency(): Optional<String> = currency.getOptional("currency")

    /**
     * Date on which the dividend was announced. In ISO 8601 format, YYYY-MM-DD.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun declarationDate(): Optional<LocalDate> = declarationDate.getOptional("declaration_date")

    /**
     * Type of dividend. Dividends that have been paid and/or are expected to be paid on consistent
     * schedules are denoted as `CD`. Special Cash dividends that have been paid that are infrequent
     * or unusual, and/or can not be expected to occur in the future are denoted as `SC`. Long-term
     * and short-term capital gain distributions are denoted as `LT` and `ST`, respectively.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun dividendType(): Optional<String> = dividendType.getOptional("dividend_type")

    /**
     * Date on or after which a `Stock` is traded without the right to receive the next dividend
     * payment. If you purchase a `Stock` on or after the ex-dividend date, you will not receive the
     * upcoming dividend. In ISO 8601 format, YYYY-MM-DD.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exDividendDate(): Optional<LocalDate> = exDividendDate.getOptional("ex_dividend_date")

    /**
     * Frequency of the dividend. The following values are possible:
     * - `1` - Annual
     * - `2` - Semi-Annual
     * - `4` - Quarterly
     * - `12` - Monthly
     * - `52` - Weekly
     * - `365` - Daily
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun frequency(): Optional<Long> = frequency.getOptional("frequency")

    /**
     * Date on which the dividend is paid out. In ISO 8601 format, YYYY-MM-DD.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun payDate(): Optional<LocalDate> = payDate.getOptional("pay_date")

    /**
     * Date that the shares must be held to receive the dividend; set by the company. In ISO 8601
     * format, YYYY-MM-DD.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun recordDate(): Optional<LocalDate> = recordDate.getOptional("record_date")

    /**
     * Ticker symbol of the `Stock`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ticker(): Optional<String> = ticker.getOptional("ticker")

    /**
     * Returns the raw JSON value of [cashAmount].
     *
     * Unlike [cashAmount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cash_amount") @ExcludeMissing fun _cashAmount(): JsonField<Double> = cashAmount

    /**
     * Returns the raw JSON value of [currency].
     *
     * Unlike [currency], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("currency") @ExcludeMissing fun _currency(): JsonField<String> = currency

    /**
     * Returns the raw JSON value of [declarationDate].
     *
     * Unlike [declarationDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("declaration_date")
    @ExcludeMissing
    fun _declarationDate(): JsonField<LocalDate> = declarationDate

    /**
     * Returns the raw JSON value of [dividendType].
     *
     * Unlike [dividendType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("dividend_type")
    @ExcludeMissing
    fun _dividendType(): JsonField<String> = dividendType

    /**
     * Returns the raw JSON value of [exDividendDate].
     *
     * Unlike [exDividendDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ex_dividend_date")
    @ExcludeMissing
    fun _exDividendDate(): JsonField<LocalDate> = exDividendDate

    /**
     * Returns the raw JSON value of [frequency].
     *
     * Unlike [frequency], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("frequency") @ExcludeMissing fun _frequency(): JsonField<Long> = frequency

    /**
     * Returns the raw JSON value of [payDate].
     *
     * Unlike [payDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pay_date") @ExcludeMissing fun _payDate(): JsonField<LocalDate> = payDate

    /**
     * Returns the raw JSON value of [recordDate].
     *
     * Unlike [recordDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("record_date")
    @ExcludeMissing
    fun _recordDate(): JsonField<LocalDate> = recordDate

    /**
     * Returns the raw JSON value of [ticker].
     *
     * Unlike [ticker], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ticker") @ExcludeMissing fun _ticker(): JsonField<String> = ticker

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
         * [StockRetrieveDividendsResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StockRetrieveDividendsResponse]. */
    class Builder internal constructor() {

        private var cashAmount: JsonField<Double> = JsonMissing.of()
        private var currency: JsonField<String> = JsonMissing.of()
        private var declarationDate: JsonField<LocalDate> = JsonMissing.of()
        private var dividendType: JsonField<String> = JsonMissing.of()
        private var exDividendDate: JsonField<LocalDate> = JsonMissing.of()
        private var frequency: JsonField<Long> = JsonMissing.of()
        private var payDate: JsonField<LocalDate> = JsonMissing.of()
        private var recordDate: JsonField<LocalDate> = JsonMissing.of()
        private var ticker: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(stockRetrieveDividendsResponse: StockRetrieveDividendsResponse) = apply {
            cashAmount = stockRetrieveDividendsResponse.cashAmount
            currency = stockRetrieveDividendsResponse.currency
            declarationDate = stockRetrieveDividendsResponse.declarationDate
            dividendType = stockRetrieveDividendsResponse.dividendType
            exDividendDate = stockRetrieveDividendsResponse.exDividendDate
            frequency = stockRetrieveDividendsResponse.frequency
            payDate = stockRetrieveDividendsResponse.payDate
            recordDate = stockRetrieveDividendsResponse.recordDate
            ticker = stockRetrieveDividendsResponse.ticker
            additionalProperties =
                stockRetrieveDividendsResponse.additionalProperties.toMutableMap()
        }

        /** Cash amount of the dividend per share owned. */
        fun cashAmount(cashAmount: Double) = cashAmount(JsonField.of(cashAmount))

        /**
         * Sets [Builder.cashAmount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cashAmount] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cashAmount(cashAmount: JsonField<Double>) = apply { this.cashAmount = cashAmount }

        /** Currency in which the dividend is paid. */
        fun currency(currency: String) = currency(JsonField.of(currency))

        /**
         * Sets [Builder.currency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currency] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun currency(currency: JsonField<String>) = apply { this.currency = currency }

        /** Date on which the dividend was announced. In ISO 8601 format, YYYY-MM-DD. */
        fun declarationDate(declarationDate: LocalDate) =
            declarationDate(JsonField.of(declarationDate))

        /**
         * Sets [Builder.declarationDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.declarationDate] with a well-typed [LocalDate] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun declarationDate(declarationDate: JsonField<LocalDate>) = apply {
            this.declarationDate = declarationDate
        }

        /**
         * Type of dividend. Dividends that have been paid and/or are expected to be paid on
         * consistent schedules are denoted as `CD`. Special Cash dividends that have been paid that
         * are infrequent or unusual, and/or can not be expected to occur in the future are denoted
         * as `SC`. Long-term and short-term capital gain distributions are denoted as `LT` and
         * `ST`, respectively.
         */
        fun dividendType(dividendType: String) = dividendType(JsonField.of(dividendType))

        /**
         * Sets [Builder.dividendType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dividendType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun dividendType(dividendType: JsonField<String>) = apply {
            this.dividendType = dividendType
        }

        /**
         * Date on or after which a `Stock` is traded without the right to receive the next dividend
         * payment. If you purchase a `Stock` on or after the ex-dividend date, you will not receive
         * the upcoming dividend. In ISO 8601 format, YYYY-MM-DD.
         */
        fun exDividendDate(exDividendDate: LocalDate) = exDividendDate(JsonField.of(exDividendDate))

        /**
         * Sets [Builder.exDividendDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exDividendDate] with a well-typed [LocalDate] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun exDividendDate(exDividendDate: JsonField<LocalDate>) = apply {
            this.exDividendDate = exDividendDate
        }

        /**
         * Frequency of the dividend. The following values are possible:
         * - `1` - Annual
         * - `2` - Semi-Annual
         * - `4` - Quarterly
         * - `12` - Monthly
         * - `52` - Weekly
         * - `365` - Daily
         */
        fun frequency(frequency: Long) = frequency(JsonField.of(frequency))

        /**
         * Sets [Builder.frequency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.frequency] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun frequency(frequency: JsonField<Long>) = apply { this.frequency = frequency }

        /** Date on which the dividend is paid out. In ISO 8601 format, YYYY-MM-DD. */
        fun payDate(payDate: LocalDate) = payDate(JsonField.of(payDate))

        /**
         * Sets [Builder.payDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.payDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun payDate(payDate: JsonField<LocalDate>) = apply { this.payDate = payDate }

        /**
         * Date that the shares must be held to receive the dividend; set by the company. In ISO
         * 8601 format, YYYY-MM-DD.
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

        /** Ticker symbol of the `Stock`. */
        fun ticker(ticker: String) = ticker(JsonField.of(ticker))

        /**
         * Sets [Builder.ticker] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ticker] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ticker(ticker: JsonField<String>) = apply { this.ticker = ticker }

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
         * Returns an immutable instance of [StockRetrieveDividendsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): StockRetrieveDividendsResponse =
            StockRetrieveDividendsResponse(
                cashAmount,
                currency,
                declarationDate,
                dividendType,
                exDividendDate,
                frequency,
                payDate,
                recordDate,
                ticker,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StockRetrieveDividendsResponse = apply {
        if (validated) {
            return@apply
        }

        cashAmount()
        currency()
        declarationDate()
        dividendType()
        exDividendDate()
        frequency()
        payDate()
        recordDate()
        ticker()
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
        (if (cashAmount.asKnown().isPresent) 1 else 0) +
            (if (currency.asKnown().isPresent) 1 else 0) +
            (if (declarationDate.asKnown().isPresent) 1 else 0) +
            (if (dividendType.asKnown().isPresent) 1 else 0) +
            (if (exDividendDate.asKnown().isPresent) 1 else 0) +
            (if (frequency.asKnown().isPresent) 1 else 0) +
            (if (payDate.asKnown().isPresent) 1 else 0) +
            (if (recordDate.asKnown().isPresent) 1 else 0) +
            (if (ticker.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StockRetrieveDividendsResponse && cashAmount == other.cashAmount && currency == other.currency && declarationDate == other.declarationDate && dividendType == other.dividendType && exDividendDate == other.exDividendDate && frequency == other.frequency && payDate == other.payDate && recordDate == other.recordDate && ticker == other.ticker && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(cashAmount, currency, declarationDate, dividendType, exDividendDate, frequency, payDate, recordDate, ticker, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StockRetrieveDividendsResponse{cashAmount=$cashAmount, currency=$currency, declarationDate=$declarationDate, dividendType=$dividendType, exDividendDate=$exDividendDate, frequency=$frequency, payDate=$payDate, recordDate=$recordDate, ticker=$ticker, additionalProperties=$additionalProperties}"
}
