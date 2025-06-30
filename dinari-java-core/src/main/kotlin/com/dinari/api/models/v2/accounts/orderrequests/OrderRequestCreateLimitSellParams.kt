// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.Params
import com.dinari.api.core.checkRequired
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a managed `OrderRequest` to place a limit sell `Order`. */
class OrderRequestCreateLimitSellParams
private constructor(
    private val accountId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    /**
     * Amount of dShare asset involved. Required for limit `Orders` and market sell `Orders`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assetQuantity(): Double = body.assetQuantity()

    /**
     * Price at which to execute the order. Must be a positive number with a precision of up to 2
     * decimal places.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun limitPrice(): Double = body.limitPrice()

    /**
     * ID of `Stock`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = body.stockId()

    /**
     * Address of the payment token to be used for the sell order. If not provided, the default
     * payment token (USD+) will be used. Should only be specified if `recipient_account_id` for a
     * non-managed wallet account is also provided.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentTokenAddress(): Optional<String> = body.paymentTokenAddress()

    /**
     * ID of `Account` to receive the `Order`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun recipientAccountId(): Optional<String> = body.recipientAccountId()

    /**
     * Returns the raw JSON value of [assetQuantity].
     *
     * Unlike [assetQuantity], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _assetQuantity(): JsonField<Double> = body._assetQuantity()

    /**
     * Returns the raw JSON value of [limitPrice].
     *
     * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _limitPrice(): JsonField<Double> = body._limitPrice()

    /**
     * Returns the raw JSON value of [stockId].
     *
     * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _stockId(): JsonField<String> = body._stockId()

    /**
     * Returns the raw JSON value of [paymentTokenAddress].
     *
     * Unlike [paymentTokenAddress], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _paymentTokenAddress(): JsonField<String> = body._paymentTokenAddress()

    /**
     * Returns the raw JSON value of [recipientAccountId].
     *
     * Unlike [recipientAccountId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _recipientAccountId(): JsonField<String> = body._recipientAccountId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [OrderRequestCreateLimitSellParams].
         *
         * The following fields are required:
         * ```java
         * .assetQuantity()
         * .limitPrice()
         * .stockId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderRequestCreateLimitSellParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(orderRequestCreateLimitSellParams: OrderRequestCreateLimitSellParams) =
            apply {
                accountId = orderRequestCreateLimitSellParams.accountId
                body = orderRequestCreateLimitSellParams.body.toBuilder()
                additionalHeaders = orderRequestCreateLimitSellParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    orderRequestCreateLimitSellParams.additionalQueryParams.toBuilder()
            }

        fun accountId(accountId: String?) = apply { this.accountId = accountId }

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [assetQuantity]
         * - [limitPrice]
         * - [stockId]
         * - [paymentTokenAddress]
         * - [recipientAccountId]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Amount of dShare asset involved. Required for limit `Orders` and market sell `Orders`.
         */
        fun assetQuantity(assetQuantity: Double) = apply { body.assetQuantity(assetQuantity) }

        /**
         * Sets [Builder.assetQuantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assetQuantity] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun assetQuantity(assetQuantity: JsonField<Double>) = apply {
            body.assetQuantity(assetQuantity)
        }

        /**
         * Price at which to execute the order. Must be a positive number with a precision of up to
         * 2 decimal places.
         */
        fun limitPrice(limitPrice: Double) = apply { body.limitPrice(limitPrice) }

        /**
         * Sets [Builder.limitPrice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limitPrice] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun limitPrice(limitPrice: JsonField<Double>) = apply { body.limitPrice(limitPrice) }

        /** ID of `Stock`. */
        fun stockId(stockId: String) = apply { body.stockId(stockId) }

        /**
         * Sets [Builder.stockId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stockId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stockId(stockId: JsonField<String>) = apply { body.stockId(stockId) }

        /**
         * Address of the payment token to be used for the sell order. If not provided, the default
         * payment token (USD+) will be used. Should only be specified if `recipient_account_id` for
         * a non-managed wallet account is also provided.
         */
        fun paymentTokenAddress(paymentTokenAddress: String) = apply {
            body.paymentTokenAddress(paymentTokenAddress)
        }

        /**
         * Sets [Builder.paymentTokenAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentTokenAddress] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentTokenAddress(paymentTokenAddress: JsonField<String>) = apply {
            body.paymentTokenAddress(paymentTokenAddress)
        }

        /** ID of `Account` to receive the `Order`. */
        fun recipientAccountId(recipientAccountId: String) = apply {
            body.recipientAccountId(recipientAccountId)
        }

        /**
         * Sets [Builder.recipientAccountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipientAccountId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recipientAccountId(recipientAccountId: JsonField<String>) = apply {
            body.recipientAccountId(recipientAccountId)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [OrderRequestCreateLimitSellParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .assetQuantity()
         * .limitPrice()
         * .stockId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrderRequestCreateLimitSellParams =
            OrderRequestCreateLimitSellParams(
                accountId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> accountId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Input parameters for creating a limit sell `OrderRequest`. */
    class Body
    private constructor(
        private val assetQuantity: JsonField<Double>,
        private val limitPrice: JsonField<Double>,
        private val stockId: JsonField<String>,
        private val paymentTokenAddress: JsonField<String>,
        private val recipientAccountId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("asset_quantity")
            @ExcludeMissing
            assetQuantity: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("limit_price")
            @ExcludeMissing
            limitPrice: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("payment_token_address")
            @ExcludeMissing
            paymentTokenAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("recipient_account_id")
            @ExcludeMissing
            recipientAccountId: JsonField<String> = JsonMissing.of(),
        ) : this(
            assetQuantity,
            limitPrice,
            stockId,
            paymentTokenAddress,
            recipientAccountId,
            mutableMapOf(),
        )

        /**
         * Amount of dShare asset involved. Required for limit `Orders` and market sell `Orders`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun assetQuantity(): Double = assetQuantity.getRequired("asset_quantity")

        /**
         * Price at which to execute the order. Must be a positive number with a precision of up to
         * 2 decimal places.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun limitPrice(): Double = limitPrice.getRequired("limit_price")

        /**
         * ID of `Stock`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun stockId(): String = stockId.getRequired("stock_id")

        /**
         * Address of the payment token to be used for the sell order. If not provided, the default
         * payment token (USD+) will be used. Should only be specified if `recipient_account_id` for
         * a non-managed wallet account is also provided.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun paymentTokenAddress(): Optional<String> =
            paymentTokenAddress.getOptional("payment_token_address")

        /**
         * ID of `Account` to receive the `Order`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recipientAccountId(): Optional<String> =
            recipientAccountId.getOptional("recipient_account_id")

        /**
         * Returns the raw JSON value of [assetQuantity].
         *
         * Unlike [assetQuantity], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("asset_quantity")
        @ExcludeMissing
        fun _assetQuantity(): JsonField<Double> = assetQuantity

        /**
         * Returns the raw JSON value of [limitPrice].
         *
         * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit_price")
        @ExcludeMissing
        fun _limitPrice(): JsonField<Double> = limitPrice

        /**
         * Returns the raw JSON value of [stockId].
         *
         * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

        /**
         * Returns the raw JSON value of [paymentTokenAddress].
         *
         * Unlike [paymentTokenAddress], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("payment_token_address")
        @ExcludeMissing
        fun _paymentTokenAddress(): JsonField<String> = paymentTokenAddress

        /**
         * Returns the raw JSON value of [recipientAccountId].
         *
         * Unlike [recipientAccountId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("recipient_account_id")
        @ExcludeMissing
        fun _recipientAccountId(): JsonField<String> = recipientAccountId

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .assetQuantity()
             * .limitPrice()
             * .stockId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var assetQuantity: JsonField<Double>? = null
            private var limitPrice: JsonField<Double>? = null
            private var stockId: JsonField<String>? = null
            private var paymentTokenAddress: JsonField<String> = JsonMissing.of()
            private var recipientAccountId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                assetQuantity = body.assetQuantity
                limitPrice = body.limitPrice
                stockId = body.stockId
                paymentTokenAddress = body.paymentTokenAddress
                recipientAccountId = body.recipientAccountId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Amount of dShare asset involved. Required for limit `Orders` and market sell
             * `Orders`.
             */
            fun assetQuantity(assetQuantity: Double) = assetQuantity(JsonField.of(assetQuantity))

            /**
             * Sets [Builder.assetQuantity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.assetQuantity] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun assetQuantity(assetQuantity: JsonField<Double>) = apply {
                this.assetQuantity = assetQuantity
            }

            /**
             * Price at which to execute the order. Must be a positive number with a precision of up
             * to 2 decimal places.
             */
            fun limitPrice(limitPrice: Double) = limitPrice(JsonField.of(limitPrice))

            /**
             * Sets [Builder.limitPrice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.limitPrice] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun limitPrice(limitPrice: JsonField<Double>) = apply { this.limitPrice = limitPrice }

            /** ID of `Stock`. */
            fun stockId(stockId: String) = stockId(JsonField.of(stockId))

            /**
             * Sets [Builder.stockId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stockId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

            /**
             * Address of the payment token to be used for the sell order. If not provided, the
             * default payment token (USD+) will be used. Should only be specified if
             * `recipient_account_id` for a non-managed wallet account is also provided.
             */
            fun paymentTokenAddress(paymentTokenAddress: String) =
                paymentTokenAddress(JsonField.of(paymentTokenAddress))

            /**
             * Sets [Builder.paymentTokenAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paymentTokenAddress] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun paymentTokenAddress(paymentTokenAddress: JsonField<String>) = apply {
                this.paymentTokenAddress = paymentTokenAddress
            }

            /** ID of `Account` to receive the `Order`. */
            fun recipientAccountId(recipientAccountId: String) =
                recipientAccountId(JsonField.of(recipientAccountId))

            /**
             * Sets [Builder.recipientAccountId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipientAccountId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun recipientAccountId(recipientAccountId: JsonField<String>) = apply {
                this.recipientAccountId = recipientAccountId
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .assetQuantity()
             * .limitPrice()
             * .stockId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("assetQuantity", assetQuantity),
                    checkRequired("limitPrice", limitPrice),
                    checkRequired("stockId", stockId),
                    paymentTokenAddress,
                    recipientAccountId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            assetQuantity()
            limitPrice()
            stockId()
            paymentTokenAddress()
            recipientAccountId()
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
            (if (assetQuantity.asKnown().isPresent) 1 else 0) +
                (if (limitPrice.asKnown().isPresent) 1 else 0) +
                (if (stockId.asKnown().isPresent) 1 else 0) +
                (if (paymentTokenAddress.asKnown().isPresent) 1 else 0) +
                (if (recipientAccountId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && assetQuantity == other.assetQuantity && limitPrice == other.limitPrice && stockId == other.stockId && paymentTokenAddress == other.paymentTokenAddress && recipientAccountId == other.recipientAccountId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(assetQuantity, limitPrice, stockId, paymentTokenAddress, recipientAccountId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{assetQuantity=$assetQuantity, limitPrice=$limitPrice, stockId=$stockId, paymentTokenAddress=$paymentTokenAddress, recipientAccountId=$recipientAccountId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is OrderRequestCreateLimitSellParams && accountId == other.accountId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(accountId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "OrderRequestCreateLimitSellParams{accountId=$accountId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
