// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155

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
import com.dinari.api.models.v2.accounts.orders.OrderTif
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
 * Prepare a proxied order to be placed on EVM. The returned structure contains the necessary data
 * to create an `OrderRequest` with a `Wallet` that is not Dinari-managed.
 */
class Eip155PrepareProxiedOrderParams
private constructor(
    private val accountId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    /**
     * CAIP-2 chain ID of the blockchain where the `Order` will be placed.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): Chain = body.chainId()

    /**
     * Indicates whether `Order` is a buy or sell.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderSide(): OrderSide = body.orderSide()

    /**
     * Time in force. Indicates how long `Order` is valid for.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderTif(): OrderTif = body.orderTif()

    /**
     * Type of `Order`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderType(): OrderType = body.orderType()

    /**
     * The ID of the `Stock` for which the `Order` is being placed.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = body.stockId()

    /**
     * Amount of dShare asset tokens involved. Required for limit `Orders` and market sell `Orders`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun assetTokenQuantity(): Optional<Double> = body.assetTokenQuantity()

    /**
     * Price per asset in the asset's native currency. USD for US equities and ETFs. Required for
     * limit `Orders`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun limitPrice(): Optional<Double> = body.limitPrice()

    /**
     * Address of payment token.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentToken(): Optional<String> = body.paymentToken()

    /**
     * Amount of payment tokens involved. Required for market buy `Orders`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentTokenQuantity(): Optional<Double> = body.paymentTokenQuantity()

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _chainId(): JsonField<Chain> = body._chainId()

    /**
     * Returns the raw JSON value of [orderSide].
     *
     * Unlike [orderSide], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _orderSide(): JsonField<OrderSide> = body._orderSide()

    /**
     * Returns the raw JSON value of [orderTif].
     *
     * Unlike [orderTif], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _orderTif(): JsonField<OrderTif> = body._orderTif()

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
     * Returns the raw JSON value of [limitPrice].
     *
     * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _limitPrice(): JsonField<Double> = body._limitPrice()

    /**
     * Returns the raw JSON value of [paymentToken].
     *
     * Unlike [paymentToken], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _paymentToken(): JsonField<String> = body._paymentToken()

    /**
     * Returns the raw JSON value of [paymentTokenQuantity].
     *
     * Unlike [paymentTokenQuantity], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _paymentTokenQuantity(): JsonField<Double> = body._paymentTokenQuantity()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [Eip155PrepareProxiedOrderParams].
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .orderSide()
         * .orderTif()
         * .orderType()
         * .stockId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155PrepareProxiedOrderParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(eip155PrepareProxiedOrderParams: Eip155PrepareProxiedOrderParams) =
            apply {
                accountId = eip155PrepareProxiedOrderParams.accountId
                body = eip155PrepareProxiedOrderParams.body.toBuilder()
                additionalHeaders = eip155PrepareProxiedOrderParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    eip155PrepareProxiedOrderParams.additionalQueryParams.toBuilder()
            }

        fun accountId(accountId: String?) = apply { this.accountId = accountId }

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [chainId]
         * - [orderSide]
         * - [orderTif]
         * - [orderType]
         * - [stockId]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** CAIP-2 chain ID of the blockchain where the `Order` will be placed. */
        fun chainId(chainId: Chain) = apply { body.chainId(chainId) }

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [Chain] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<Chain>) = apply { body.chainId(chainId) }

        /** Indicates whether `Order` is a buy or sell. */
        fun orderSide(orderSide: OrderSide) = apply { body.orderSide(orderSide) }

        /**
         * Sets [Builder.orderSide] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderSide] with a well-typed [OrderSide] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderSide(orderSide: JsonField<OrderSide>) = apply { body.orderSide(orderSide) }

        /** Time in force. Indicates how long `Order` is valid for. */
        fun orderTif(orderTif: OrderTif) = apply { body.orderTif(orderTif) }

        /**
         * Sets [Builder.orderTif] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderTif] with a well-typed [OrderTif] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderTif(orderTif: JsonField<OrderTif>) = apply { body.orderTif(orderTif) }

        /** Type of `Order`. */
        fun orderType(orderType: OrderType) = apply { body.orderType(orderType) }

        /**
         * Sets [Builder.orderType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderType] with a well-typed [OrderType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderType(orderType: JsonField<OrderType>) = apply { body.orderType(orderType) }

        /** The ID of the `Stock` for which the `Order` is being placed. */
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
         * `Orders`.
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
         * Price per asset in the asset's native currency. USD for US equities and ETFs. Required
         * for limit `Orders`.
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

        /** Address of payment token. */
        fun paymentToken(paymentToken: String) = apply { body.paymentToken(paymentToken) }

        /**
         * Sets [Builder.paymentToken] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentToken] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun paymentToken(paymentToken: JsonField<String>) = apply {
            body.paymentToken(paymentToken)
        }

        /** Amount of payment tokens involved. Required for market buy `Orders`. */
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
         * Returns an immutable instance of [Eip155PrepareProxiedOrderParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .orderSide()
         * .orderTif()
         * .orderType()
         * .stockId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155PrepareProxiedOrderParams =
            Eip155PrepareProxiedOrderParams(
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

    /** Input parameters for building typed data involved in creating a proxied `OrderRequest`. */
    class Body
    private constructor(
        private val chainId: JsonField<Chain>,
        private val orderSide: JsonField<OrderSide>,
        private val orderTif: JsonField<OrderTif>,
        private val orderType: JsonField<OrderType>,
        private val stockId: JsonField<String>,
        private val assetTokenQuantity: JsonField<Double>,
        private val limitPrice: JsonField<Double>,
        private val paymentToken: JsonField<String>,
        private val paymentTokenQuantity: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Chain> = JsonMissing.of(),
            @JsonProperty("order_side")
            @ExcludeMissing
            orderSide: JsonField<OrderSide> = JsonMissing.of(),
            @JsonProperty("order_tif")
            @ExcludeMissing
            orderTif: JsonField<OrderTif> = JsonMissing.of(),
            @JsonProperty("order_type")
            @ExcludeMissing
            orderType: JsonField<OrderType> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("asset_token_quantity")
            @ExcludeMissing
            assetTokenQuantity: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("limit_price")
            @ExcludeMissing
            limitPrice: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("payment_token")
            @ExcludeMissing
            paymentToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("payment_token_quantity")
            @ExcludeMissing
            paymentTokenQuantity: JsonField<Double> = JsonMissing.of(),
        ) : this(
            chainId,
            orderSide,
            orderTif,
            orderType,
            stockId,
            assetTokenQuantity,
            limitPrice,
            paymentToken,
            paymentTokenQuantity,
            mutableMapOf(),
        )

        /**
         * CAIP-2 chain ID of the blockchain where the `Order` will be placed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun chainId(): Chain = chainId.getRequired("chain_id")

        /**
         * Indicates whether `Order` is a buy or sell.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderSide(): OrderSide = orderSide.getRequired("order_side")

        /**
         * Time in force. Indicates how long `Order` is valid for.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderTif(): OrderTif = orderTif.getRequired("order_tif")

        /**
         * Type of `Order`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderType(): OrderType = orderType.getRequired("order_type")

        /**
         * The ID of the `Stock` for which the `Order` is being placed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun stockId(): String = stockId.getRequired("stock_id")

        /**
         * Amount of dShare asset tokens involved. Required for limit `Orders` and market sell
         * `Orders`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun assetTokenQuantity(): Optional<Double> =
            assetTokenQuantity.getOptional("asset_token_quantity")

        /**
         * Price per asset in the asset's native currency. USD for US equities and ETFs. Required
         * for limit `Orders`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun limitPrice(): Optional<Double> = limitPrice.getOptional("limit_price")

        /**
         * Address of payment token.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun paymentToken(): Optional<String> = paymentToken.getOptional("payment_token")

        /**
         * Amount of payment tokens involved. Required for market buy `Orders`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun paymentTokenQuantity(): Optional<Double> =
            paymentTokenQuantity.getOptional("payment_token_quantity")

        /**
         * Returns the raw JSON value of [chainId].
         *
         * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Chain> = chainId

        /**
         * Returns the raw JSON value of [orderSide].
         *
         * Unlike [orderSide], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("order_side")
        @ExcludeMissing
        fun _orderSide(): JsonField<OrderSide> = orderSide

        /**
         * Returns the raw JSON value of [orderTif].
         *
         * Unlike [orderTif], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("order_tif") @ExcludeMissing fun _orderTif(): JsonField<OrderTif> = orderTif

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
         * Returns the raw JSON value of [limitPrice].
         *
         * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit_price")
        @ExcludeMissing
        fun _limitPrice(): JsonField<Double> = limitPrice

        /**
         * Returns the raw JSON value of [paymentToken].
         *
         * Unlike [paymentToken], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("payment_token")
        @ExcludeMissing
        fun _paymentToken(): JsonField<String> = paymentToken

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
             * .chainId()
             * .orderSide()
             * .orderTif()
             * .orderType()
             * .stockId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var chainId: JsonField<Chain>? = null
            private var orderSide: JsonField<OrderSide>? = null
            private var orderTif: JsonField<OrderTif>? = null
            private var orderType: JsonField<OrderType>? = null
            private var stockId: JsonField<String>? = null
            private var assetTokenQuantity: JsonField<Double> = JsonMissing.of()
            private var limitPrice: JsonField<Double> = JsonMissing.of()
            private var paymentToken: JsonField<String> = JsonMissing.of()
            private var paymentTokenQuantity: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                chainId = body.chainId
                orderSide = body.orderSide
                orderTif = body.orderTif
                orderType = body.orderType
                stockId = body.stockId
                assetTokenQuantity = body.assetTokenQuantity
                limitPrice = body.limitPrice
                paymentToken = body.paymentToken
                paymentTokenQuantity = body.paymentTokenQuantity
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** CAIP-2 chain ID of the blockchain where the `Order` will be placed. */
            fun chainId(chainId: Chain) = chainId(JsonField.of(chainId))

            /**
             * Sets [Builder.chainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chainId] with a well-typed [Chain] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun chainId(chainId: JsonField<Chain>) = apply { this.chainId = chainId }

            /** Indicates whether `Order` is a buy or sell. */
            fun orderSide(orderSide: OrderSide) = orderSide(JsonField.of(orderSide))

            /**
             * Sets [Builder.orderSide] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderSide] with a well-typed [OrderSide] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderSide(orderSide: JsonField<OrderSide>) = apply { this.orderSide = orderSide }

            /** Time in force. Indicates how long `Order` is valid for. */
            fun orderTif(orderTif: OrderTif) = orderTif(JsonField.of(orderTif))

            /**
             * Sets [Builder.orderTif] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderTif] with a well-typed [OrderTif] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderTif(orderTif: JsonField<OrderTif>) = apply { this.orderTif = orderTif }

            /** Type of `Order`. */
            fun orderType(orderType: OrderType) = orderType(JsonField.of(orderType))

            /**
             * Sets [Builder.orderType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderType] with a well-typed [OrderType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderType(orderType: JsonField<OrderType>) = apply { this.orderType = orderType }

            /** The ID of the `Stock` for which the `Order` is being placed. */
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
             * `Orders`.
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
             * Price per asset in the asset's native currency. USD for US equities and ETFs.
             * Required for limit `Orders`.
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

            /** Address of payment token. */
            fun paymentToken(paymentToken: String) = paymentToken(JsonField.of(paymentToken))

            /**
             * Sets [Builder.paymentToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paymentToken] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun paymentToken(paymentToken: JsonField<String>) = apply {
                this.paymentToken = paymentToken
            }

            /** Amount of payment tokens involved. Required for market buy `Orders`. */
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
             * .chainId()
             * .orderSide()
             * .orderTif()
             * .orderType()
             * .stockId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("chainId", chainId),
                    checkRequired("orderSide", orderSide),
                    checkRequired("orderTif", orderTif),
                    checkRequired("orderType", orderType),
                    checkRequired("stockId", stockId),
                    assetTokenQuantity,
                    limitPrice,
                    paymentToken,
                    paymentTokenQuantity,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            chainId().validate()
            orderSide().validate()
            orderTif().validate()
            orderType().validate()
            stockId()
            assetTokenQuantity()
            limitPrice()
            paymentToken()
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
            (chainId.asKnown().getOrNull()?.validity() ?: 0) +
                (orderSide.asKnown().getOrNull()?.validity() ?: 0) +
                (orderTif.asKnown().getOrNull()?.validity() ?: 0) +
                (orderType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (stockId.asKnown().isPresent) 1 else 0) +
                (if (assetTokenQuantity.asKnown().isPresent) 1 else 0) +
                (if (limitPrice.asKnown().isPresent) 1 else 0) +
                (if (paymentToken.asKnown().isPresent) 1 else 0) +
                (if (paymentTokenQuantity.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && chainId == other.chainId && orderSide == other.orderSide && orderTif == other.orderTif && orderType == other.orderType && stockId == other.stockId && assetTokenQuantity == other.assetTokenQuantity && limitPrice == other.limitPrice && paymentToken == other.paymentToken && paymentTokenQuantity == other.paymentTokenQuantity && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(chainId, orderSide, orderTif, orderType, stockId, assetTokenQuantity, limitPrice, paymentToken, paymentTokenQuantity, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{chainId=$chainId, orderSide=$orderSide, orderTif=$orderTif, orderType=$orderType, stockId=$stockId, assetTokenQuantity=$assetTokenQuantity, limitPrice=$limitPrice, paymentToken=$paymentToken, paymentTokenQuantity=$paymentTokenQuantity, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Eip155PrepareProxiedOrderParams && accountId == other.accountId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(accountId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "Eip155PrepareProxiedOrderParams{accountId=$accountId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
