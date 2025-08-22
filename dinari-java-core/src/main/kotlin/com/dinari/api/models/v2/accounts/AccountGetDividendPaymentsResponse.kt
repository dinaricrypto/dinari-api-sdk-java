// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

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

/** Represents a dividend payment event for an `Account`. */
class AccountGetDividendPaymentsResponse
private constructor(
    private val amount: JsonField<Double>,
    private val currency: JsonField<String>,
    private val paymentDate: JsonField<LocalDate>,
    private val stockId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("amount") @ExcludeMissing amount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("currency") @ExcludeMissing currency: JsonField<String> = JsonMissing.of(),
        @JsonProperty("payment_date")
        @ExcludeMissing
        paymentDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
    ) : this(amount, currency, paymentDate, stockId, mutableMapOf())

    /**
     * Amount of the dividend paid.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun amount(): Double = amount.getRequired("amount")

    /**
     * Currency in which the dividend was paid. (e.g. USD)
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun currency(): String = currency.getRequired("currency")

    /**
     * Date the dividend was distributed to the account. ISO 8601 format, YYYY-MM-DD.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentDate(): LocalDate = paymentDate.getRequired("payment_date")

    /**
     * ID of the `Stock` for which the dividend was paid.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = stockId.getRequired("stock_id")

    /**
     * Returns the raw JSON value of [amount].
     *
     * Unlike [amount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<Double> = amount

    /**
     * Returns the raw JSON value of [currency].
     *
     * Unlike [currency], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("currency") @ExcludeMissing fun _currency(): JsonField<String> = currency

    /**
     * Returns the raw JSON value of [paymentDate].
     *
     * Unlike [paymentDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("payment_date")
    @ExcludeMissing
    fun _paymentDate(): JsonField<LocalDate> = paymentDate

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
         * Returns a mutable builder for constructing an instance of
         * [AccountGetDividendPaymentsResponse].
         *
         * The following fields are required:
         * ```java
         * .amount()
         * .currency()
         * .paymentDate()
         * .stockId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountGetDividendPaymentsResponse]. */
    class Builder internal constructor() {

        private var amount: JsonField<Double>? = null
        private var currency: JsonField<String>? = null
        private var paymentDate: JsonField<LocalDate>? = null
        private var stockId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountGetDividendPaymentsResponse: AccountGetDividendPaymentsResponse) =
            apply {
                amount = accountGetDividendPaymentsResponse.amount
                currency = accountGetDividendPaymentsResponse.currency
                paymentDate = accountGetDividendPaymentsResponse.paymentDate
                stockId = accountGetDividendPaymentsResponse.stockId
                additionalProperties =
                    accountGetDividendPaymentsResponse.additionalProperties.toMutableMap()
            }

        /** Amount of the dividend paid. */
        fun amount(amount: Double) = amount(JsonField.of(amount))

        /**
         * Sets [Builder.amount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.amount] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun amount(amount: JsonField<Double>) = apply { this.amount = amount }

        /** Currency in which the dividend was paid. (e.g. USD) */
        fun currency(currency: String) = currency(JsonField.of(currency))

        /**
         * Sets [Builder.currency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currency] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun currency(currency: JsonField<String>) = apply { this.currency = currency }

        /** Date the dividend was distributed to the account. ISO 8601 format, YYYY-MM-DD. */
        fun paymentDate(paymentDate: LocalDate) = paymentDate(JsonField.of(paymentDate))

        /**
         * Sets [Builder.paymentDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentDate] with a well-typed [LocalDate] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentDate(paymentDate: JsonField<LocalDate>) = apply {
            this.paymentDate = paymentDate
        }

        /** ID of the `Stock` for which the dividend was paid. */
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
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [AccountGetDividendPaymentsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .amount()
         * .currency()
         * .paymentDate()
         * .stockId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountGetDividendPaymentsResponse =
            AccountGetDividendPaymentsResponse(
                checkRequired("amount", amount),
                checkRequired("currency", currency),
                checkRequired("paymentDate", paymentDate),
                checkRequired("stockId", stockId),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountGetDividendPaymentsResponse = apply {
        if (validated) {
            return@apply
        }

        amount()
        currency()
        paymentDate()
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
        (if (amount.asKnown().isPresent) 1 else 0) +
            (if (currency.asKnown().isPresent) 1 else 0) +
            (if (paymentDate.asKnown().isPresent) 1 else 0) +
            (if (stockId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountGetDividendPaymentsResponse &&
            amount == other.amount &&
            currency == other.currency &&
            paymentDate == other.paymentDate &&
            stockId == other.stockId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(amount, currency, paymentDate, stockId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountGetDividendPaymentsResponse{amount=$amount, currency=$currency, paymentDate=$paymentDate, stockId=$stockId, additionalProperties=$additionalProperties}"
}
