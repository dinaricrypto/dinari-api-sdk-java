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
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderType
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Get fee quote data for an `Order Request`. This is provided primarily for informational purposes.
 */
class OrderRequestGetFeeQuoteParams
private constructor(
    private val accountId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    /**
     * Indicates whether `Order Request` is a buy or sell.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderSide(): OrderSide = body.orderSide()

    /**
     * Type of `Order Request`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderType(): OrderType = body.orderType()

    /**
     * The Stock ID associated with the Order Request
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = body.stockId()

    /**
     * Amount of dShare asset tokens involved. Required for limit `Orders` and market sell `Order
     * Requests`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun assetTokenQuantity(): Optional<Double> = body.assetTokenQuantity()

    /**
     * CAIP-2 chain ID of the blockchain where the `Order Request` will be placed. If not provided,
     * the default chain ID (eip155:42161) will be used.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun chainId(): Optional<Chain> = body.chainId()

    /**
     * Price per asset in the asset's native currency. USD for US equities and ETFs. Required for
     * limit `Order Requests`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun limitPrice(): Optional<Double> = body.limitPrice()

    /**
     * Address of the payment token to be used for an order. If not provided, the default payment
     * token (USD+) will be used.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentTokenAddress(): Optional<String> = body.paymentTokenAddress()

    /**
     * Amount of payment tokens involved. Required for market buy `Order Requests`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentTokenQuantity(): Optional<Double> = body.paymentTokenQuantity()

    /**
     * Returns the raw JSON value of [orderSide].
     *
     * Unlike [orderSide], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _orderSide(): JsonField<OrderSide> = body._orderSide()

    /**
     * Returns the raw JSON value of [orderType].
     *
     * Unlike [orderType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _orderType(): JsonField<OrderType> = body._orderType()

    /**
     * Returns the raw JSON value of [stockId].
     *
     * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _stockId(): JsonField<String> = body._stockId()

    /**
     * Returns the raw JSON value of [assetTokenQuantity].
     *
     * Unlike [assetTokenQuantity], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _assetTokenQuantity(): JsonField<Double> = body._assetTokenQuantity()

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _chainId(): JsonField<Chain> = body._chainId()

    /**
     * Returns the raw JSON value of [limitPrice].
     *
     * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _limitPrice(): JsonField<Double> = body._limitPrice()

    /**
     * Returns the raw JSON value of [paymentTokenAddress].
     *
     * Unlike [paymentTokenAddress], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _paymentTokenAddress(): JsonField<String> = body._paymentTokenAddress()

    /**
     * Returns the raw JSON value of [paymentTokenQuantity].
     *
     * Unlike [paymentTokenQuantity], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _paymentTokenQuantity(): JsonField<Double> = body._paymentTokenQuantity()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [OrderRequestGetFeeQuoteParams].
         *
         * The following fields are required:
         * ```java
         * .orderSide()
         * .orderType()
         * .stockId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderRequestGetFeeQuoteParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(orderRequestGetFeeQuoteParams: OrderRequestGetFeeQuoteParams) = apply {
            accountId = orderRequestGetFeeQuoteParams.accountId
            body = orderRequestGetFeeQuoteParams.body.toBuilder()
            additionalHeaders = orderRequestGetFeeQuoteParams.additionalHeaders.toBuilder()
            additionalQueryParams = orderRequestGetFeeQuoteParams.additionalQueryParams.toBuilder()
        }

        fun accountId(accountId: String?) = apply { this.accountId = accountId }

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [orderSide]
         * - [orderType]
         * - [stockId]
         * - [assetTokenQuantity]
         * - [chainId]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Indicates whether `Order Request` is a buy or sell. */
        fun orderSide(orderSide: OrderSide) = apply { body.orderSide(orderSide) }

        /**
         * Sets [Builder.orderSide] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderSide] with a well-typed [OrderSide] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderSide(orderSide: JsonField<OrderSide>) = apply { body.orderSide(orderSide) }

        /** Type of `Order Request`. */
        fun orderType(orderType: OrderType) = apply { body.orderType(orderType) }

        /**
         * Sets [Builder.orderType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderType] with a well-typed [OrderType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderType(orderType: JsonField<OrderType>) = apply { body.orderType(orderType) }

        /** The Stock ID associated with the Order Request */
        fun stockId(stockId: String) = apply { body.stockId(stockId) }

        /**
         * Sets [Builder.stockId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stockId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stockId(stockId: JsonField<String>) = apply { body.stockId(stockId) }

        /**
         * Amount of dShare asset tokens involved. Required for limit `Orders` and market sell
         * `Order Requests`.
         */
        fun assetTokenQuantity(assetTokenQuantity: Double) = apply {
            body.assetTokenQuantity(assetTokenQuantity)
        }

        /**
         * Sets [Builder.assetTokenQuantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assetTokenQuantity] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun assetTokenQuantity(assetTokenQuantity: JsonField<Double>) = apply {
            body.assetTokenQuantity(assetTokenQuantity)
        }

        /**
         * CAIP-2 chain ID of the blockchain where the `Order Request` will be placed. If not
         * provided, the default chain ID (eip155:42161) will be used.
         */
        fun chainId(chainId: Chain) = apply { body.chainId(chainId) }

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [Chain] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<Chain>) = apply { body.chainId(chainId) }

        /**
         * Price per asset in the asset's native currency. USD for US equities and ETFs. Required
         * for limit `Order Requests`.
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

        /**
         * Address of the payment token to be used for an order. If not provided, the default
         * payment token (USD+) will be used.
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

        /** Amount of payment tokens involved. Required for market buy `Order Requests`. */
        fun paymentTokenQuantity(paymentTokenQuantity: Double) = apply {
            body.paymentTokenQuantity(paymentTokenQuantity)
        }

        /**
         * Sets [Builder.paymentTokenQuantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentTokenQuantity] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentTokenQuantity(paymentTokenQuantity: JsonField<Double>) = apply {
            body.paymentTokenQuantity(paymentTokenQuantity)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAlladditional_body_properties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAlladditional_body_properties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAlladditional_body_properties(keys: Set<String>) = apply {
            body.removeAlladditional_body_properties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAlladditional_headers(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAlladditional_headers(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putadditional_headers(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAlladditional_headers(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAlladditional_headers(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceadditional_headers(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceadditional_headers(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAlladditional_headers(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAlladditional_headers(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeadditional_headers(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAlladditional_headers(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAlladditional_query_params(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAlladditional_query_params(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putadditional_query_params(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAlladditional_query_params(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAlladditional_query_params(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceadditional_query_params(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceadditional_query_params(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAlladditional_query_params(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAlladditional_query_params(
            additionalQueryParams: Map<String, Iterable<String>>
        ) = apply { this.additionalQueryParams.replaceAll(additionalQueryParams) }

        fun removeadditional_query_params(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAlladditional_query_params(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [OrderRequestGetFeeQuoteParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .orderSide()
         * .orderType()
         * .stockId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrderRequestGetFeeQuoteParams =
            OrderRequestGetFeeQuoteParams(
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

    /** Input parameters for requesting a fee quote for an `Order Request`. */
    class Body
    private constructor(
        private val orderSide: JsonField<OrderSide>,
        private val orderType: JsonField<OrderType>,
        private val stockId: JsonField<String>,
        private val assetTokenQuantity: JsonField<Double>,
        private val chainId: JsonField<Chain>,
        private val limitPrice: JsonField<Double>,
        private val paymentTokenAddress: JsonField<String>,
        private val paymentTokenQuantity: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("order_side")
            @ExcludeMissing
            orderSide: JsonField<OrderSide> = JsonMissing.of(),
            @JsonProperty("order_type")
            @ExcludeMissing
            orderType: JsonField<OrderType> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("asset_token_quantity")
            @ExcludeMissing
            assetTokenQuantity: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Chain> = JsonMissing.of(),
            @JsonProperty("limit_price")
            @ExcludeMissing
            limitPrice: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("payment_token_address")
            @ExcludeMissing
            paymentTokenAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("payment_token_quantity")
            @ExcludeMissing
            paymentTokenQuantity: JsonField<Double> = JsonMissing.of(),
        ) : this(
            orderSide,
            orderType,
            stockId,
            assetTokenQuantity,
            chainId,
            limitPrice,
            paymentTokenAddress,
            paymentTokenQuantity,
            mutableMapOf(),
        )

        /**
         * Indicates whether `Order Request` is a buy or sell.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderSide(): OrderSide = orderSide.getRequired("order_side")

        /**
         * Type of `Order Request`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderType(): OrderType = orderType.getRequired("order_type")

        /**
         * The Stock ID associated with the Order Request
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun stockId(): String = stockId.getRequired("stock_id")

        /**
         * Amount of dShare asset tokens involved. Required for limit `Orders` and market sell
         * `Order Requests`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun assetTokenQuantity(): Optional<Double> =
            assetTokenQuantity.getOptional("asset_token_quantity")

        /**
         * CAIP-2 chain ID of the blockchain where the `Order Request` will be placed. If not
         * provided, the default chain ID (eip155:42161) will be used.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun chainId(): Optional<Chain> = chainId.getOptional("chain_id")

        /**
         * Price per asset in the asset's native currency. USD for US equities and ETFs. Required
         * for limit `Order Requests`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun limitPrice(): Optional<Double> = limitPrice.getOptional("limit_price")

        /**
         * Address of the payment token to be used for an order. If not provided, the default
         * payment token (USD+) will be used.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun paymentTokenAddress(): Optional<String> =
            paymentTokenAddress.getOptional("payment_token_address")

        /**
         * Amount of payment tokens involved. Required for market buy `Order Requests`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun paymentTokenQuantity(): Optional<Double> =
            paymentTokenQuantity.getOptional("payment_token_quantity")

        /**
         * Returns the raw JSON value of [orderSide].
         *
         * Unlike [orderSide], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("order_side")
        @ExcludeMissing
        fun _orderSide(): JsonField<OrderSide> = orderSide

        /**
         * Returns the raw JSON value of [orderType].
         *
         * Unlike [orderType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("order_type")
        @ExcludeMissing
        fun _orderType(): JsonField<OrderType> = orderType

        /**
         * Returns the raw JSON value of [stockId].
         *
         * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

        /**
         * Returns the raw JSON value of [assetTokenQuantity].
         *
         * Unlike [assetTokenQuantity], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("asset_token_quantity")
        @ExcludeMissing
        fun _assetTokenQuantity(): JsonField<Double> = assetTokenQuantity

        /**
         * Returns the raw JSON value of [chainId].
         *
         * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Chain> = chainId

        /**
         * Returns the raw JSON value of [limitPrice].
         *
         * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit_price")
        @ExcludeMissing
        fun _limitPrice(): JsonField<Double> = limitPrice

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
         * Returns the raw JSON value of [paymentTokenQuantity].
         *
         * Unlike [paymentTokenQuantity], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("payment_token_quantity")
        @ExcludeMissing
        fun _paymentTokenQuantity(): JsonField<Double> = paymentTokenQuantity

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
             * .orderSide()
             * .orderType()
             * .stockId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var orderSide: JsonField<OrderSide>? = null
            private var orderType: JsonField<OrderType>? = null
            private var stockId: JsonField<String>? = null
            private var assetTokenQuantity: JsonField<Double> = JsonMissing.of()
            private var chainId: JsonField<Chain> = JsonMissing.of()
            private var limitPrice: JsonField<Double> = JsonMissing.of()
            private var paymentTokenAddress: JsonField<String> = JsonMissing.of()
            private var paymentTokenQuantity: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                orderSide = body.orderSide
                orderType = body.orderType
                stockId = body.stockId
                assetTokenQuantity = body.assetTokenQuantity
                chainId = body.chainId
                limitPrice = body.limitPrice
                paymentTokenAddress = body.paymentTokenAddress
                paymentTokenQuantity = body.paymentTokenQuantity
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Indicates whether `Order Request` is a buy or sell. */
            fun orderSide(orderSide: OrderSide) = orderSide(JsonField.of(orderSide))

            /**
             * Sets [Builder.orderSide] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderSide] with a well-typed [OrderSide] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderSide(orderSide: JsonField<OrderSide>) = apply { this.orderSide = orderSide }

            /** Type of `Order Request`. */
            fun orderType(orderType: OrderType) = orderType(JsonField.of(orderType))

            /**
             * Sets [Builder.orderType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderType] with a well-typed [OrderType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderType(orderType: JsonField<OrderType>) = apply { this.orderType = orderType }

            /** The Stock ID associated with the Order Request */
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
             * Amount of dShare asset tokens involved. Required for limit `Orders` and market sell
             * `Order Requests`.
             */
            fun assetTokenQuantity(assetTokenQuantity: Double) =
                assetTokenQuantity(JsonField.of(assetTokenQuantity))

            /**
             * Sets [Builder.assetTokenQuantity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.assetTokenQuantity] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun assetTokenQuantity(assetTokenQuantity: JsonField<Double>) = apply {
                this.assetTokenQuantity = assetTokenQuantity
            }

            /**
             * CAIP-2 chain ID of the blockchain where the `Order Request` will be placed. If not
             * provided, the default chain ID (eip155:42161) will be used.
             */
            fun chainId(chainId: Chain) = chainId(JsonField.of(chainId))

            /**
             * Sets [Builder.chainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chainId] with a well-typed [Chain] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun chainId(chainId: JsonField<Chain>) = apply { this.chainId = chainId }

            /**
             * Price per asset in the asset's native currency. USD for US equities and ETFs.
             * Required for limit `Order Requests`.
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

            /**
             * Address of the payment token to be used for an order. If not provided, the default
             * payment token (USD+) will be used.
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

            /** Amount of payment tokens involved. Required for market buy `Order Requests`. */
            fun paymentTokenQuantity(paymentTokenQuantity: Double) =
                paymentTokenQuantity(JsonField.of(paymentTokenQuantity))

            /**
             * Sets [Builder.paymentTokenQuantity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paymentTokenQuantity] with a well-typed [Double]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun paymentTokenQuantity(paymentTokenQuantity: JsonField<Double>) = apply {
                this.paymentTokenQuantity = paymentTokenQuantity
            }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .orderSide()
             * .orderType()
             * .stockId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("orderSide", orderSide),
                    checkRequired("orderType", orderType),
                    checkRequired("stockId", stockId),
                    assetTokenQuantity,
                    chainId,
                    limitPrice,
                    paymentTokenAddress,
                    paymentTokenQuantity,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            orderSide().validate()
            orderType().validate()
            stockId()
            assetTokenQuantity()
            chainId().ifPresent { it.validate() }
            limitPrice()
            paymentTokenAddress()
            paymentTokenQuantity()
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
            (orderSide.asKnown().getOrNull()?.validity() ?: 0) +
                (orderType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (stockId.asKnown().isPresent) 1 else 0) +
                (if (assetTokenQuantity.asKnown().isPresent) 1 else 0) +
                (chainId.asKnown().getOrNull()?.validity() ?: 0) +
                (if (limitPrice.asKnown().isPresent) 1 else 0) +
                (if (paymentTokenAddress.asKnown().isPresent) 1 else 0) +
                (if (paymentTokenQuantity.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                orderSide == other.orderSide &&
                orderType == other.orderType &&
                stockId == other.stockId &&
                assetTokenQuantity == other.assetTokenQuantity &&
                chainId == other.chainId &&
                limitPrice == other.limitPrice &&
                paymentTokenAddress == other.paymentTokenAddress &&
                paymentTokenQuantity == other.paymentTokenQuantity &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                orderSide,
                orderType,
                stockId,
                assetTokenQuantity,
                chainId,
                limitPrice,
                paymentTokenAddress,
                paymentTokenQuantity,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{orderSide=$orderSide, orderType=$orderType, stockId=$stockId, assetTokenQuantity=$assetTokenQuantity, chainId=$chainId, limitPrice=$limitPrice, paymentTokenAddress=$paymentTokenAddress, paymentTokenQuantity=$paymentTokenQuantity, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrderRequestGetFeeQuoteParams &&
            accountId == other.accountId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(accountId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "OrderRequestGetFeeQuoteParams{accountId=$accountId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
