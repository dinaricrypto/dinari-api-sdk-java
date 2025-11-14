// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

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
 * Generates a permit that can be signed and used to create an `OrderRequest` using Dinari's EVM
 * smart contracts.
 *
 * This is a convenience method to prepare the transactions needed to create an `OrderRequest` using
 * Dinari's EVM smart contracts. Once signed, the transactions can be sent to the EVM network to
 * create the order. Note that the fee quote is already included in the transactions, so no
 * additional fee quote lookup is needed.
 */
class Eip155CreatePermitParams
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
     * Address of payment token.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentToken(): String = body.paymentToken()

    /**
     * Amount of dShare asset tokens involved. Required for limit `Orders` and market sell `Orders`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun assetTokenQuantity(): Optional<Double> = body.assetTokenQuantity()

    /**
     * Customer-supplied unique identifier to map this `Order` to an order in the customer's
     * systems.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientOrderId(): Optional<String> = body.clientOrderId()

    /**
     * Price per asset in the asset's native currency. USD for US equities and ETFs. Required for
     * limit `Orders`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun limitPrice(): Optional<Double> = body.limitPrice()

    /**
     * Amount of payment tokens involved. Required for market buy `Orders`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentTokenQuantity(): Optional<Double> = body.paymentTokenQuantity()

    /**
     * The ID of the `Stock` for which the `Order` is being placed.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun stockId(): Optional<String> = body.stockId()

    /**
     * The ID of the `Token` for which the `Order` is being placed.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tokenId(): Optional<String> = body.tokenId()

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
     * Returns the raw JSON value of [paymentToken].
     *
     * Unlike [paymentToken], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _paymentToken(): JsonField<String> = body._paymentToken()

    /**
     * Returns the raw JSON value of [assetTokenQuantity].
     *
     * Unlike [assetTokenQuantity], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _assetTokenQuantity(): JsonField<Double> = body._assetTokenQuantity()

    /**
     * Returns the raw JSON value of [clientOrderId].
     *
     * Unlike [clientOrderId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _clientOrderId(): JsonField<String> = body._clientOrderId()

    /**
     * Returns the raw JSON value of [limitPrice].
     *
     * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _limitPrice(): JsonField<Double> = body._limitPrice()

    /**
     * Returns the raw JSON value of [paymentTokenQuantity].
     *
     * Unlike [paymentTokenQuantity], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _paymentTokenQuantity(): JsonField<Double> = body._paymentTokenQuantity()

    /**
     * Returns the raw JSON value of [stockId].
     *
     * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _stockId(): JsonField<String> = body._stockId()

    /**
     * Returns the raw JSON value of [tokenId].
     *
     * Unlike [tokenId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tokenId(): JsonField<String> = body._tokenId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [Eip155CreatePermitParams].
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .orderSide()
         * .orderTif()
         * .orderType()
         * .paymentToken()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155CreatePermitParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(eip155CreatePermitParams: Eip155CreatePermitParams) = apply {
            accountId = eip155CreatePermitParams.accountId
            body = eip155CreatePermitParams.body.toBuilder()
            additionalHeaders = eip155CreatePermitParams.additionalHeaders.toBuilder()
            additionalQueryParams = eip155CreatePermitParams.additionalQueryParams.toBuilder()
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
         * - [paymentToken]
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

        /**
         * Amount of dShare asset tokens involved. Required for limit `Orders` and market sell
         * `Orders`.
         */
        fun assetTokenQuantity(assetTokenQuantity: Double?) = apply {
            body.assetTokenQuantity(assetTokenQuantity)
        }

        /**
         * Alias for [Builder.assetTokenQuantity].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun assetTokenQuantity(assetTokenQuantity: Double) =
            assetTokenQuantity(assetTokenQuantity as Double?)

        /**
         * Alias for calling [Builder.assetTokenQuantity] with `assetTokenQuantity.orElse(null)`.
         */
        fun assetTokenQuantity(assetTokenQuantity: Optional<Double>) =
            assetTokenQuantity(assetTokenQuantity.getOrNull())

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
         * Customer-supplied unique identifier to map this `Order` to an order in the customer's
         * systems.
         */
        fun clientOrderId(clientOrderId: String?) = apply { body.clientOrderId(clientOrderId) }

        /** Alias for calling [Builder.clientOrderId] with `clientOrderId.orElse(null)`. */
        fun clientOrderId(clientOrderId: Optional<String>) =
            clientOrderId(clientOrderId.getOrNull())

        /**
         * Sets [Builder.clientOrderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientOrderId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clientOrderId(clientOrderId: JsonField<String>) = apply {
            body.clientOrderId(clientOrderId)
        }

        /**
         * Price per asset in the asset's native currency. USD for US equities and ETFs. Required
         * for limit `Orders`.
         */
        fun limitPrice(limitPrice: Double?) = apply { body.limitPrice(limitPrice) }

        /**
         * Alias for [Builder.limitPrice].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limitPrice(limitPrice: Double) = limitPrice(limitPrice as Double?)

        /** Alias for calling [Builder.limitPrice] with `limitPrice.orElse(null)`. */
        fun limitPrice(limitPrice: Optional<Double>) = limitPrice(limitPrice.getOrNull())

        /**
         * Sets [Builder.limitPrice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limitPrice] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun limitPrice(limitPrice: JsonField<Double>) = apply { body.limitPrice(limitPrice) }

        /** Amount of payment tokens involved. Required for market buy `Orders`. */
        fun paymentTokenQuantity(paymentTokenQuantity: Double?) = apply {
            body.paymentTokenQuantity(paymentTokenQuantity)
        }

        /**
         * Alias for [Builder.paymentTokenQuantity].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun paymentTokenQuantity(paymentTokenQuantity: Double) =
            paymentTokenQuantity(paymentTokenQuantity as Double?)

        /**
         * Alias for calling [Builder.paymentTokenQuantity] with
         * `paymentTokenQuantity.orElse(null)`.
         */
        fun paymentTokenQuantity(paymentTokenQuantity: Optional<Double>) =
            paymentTokenQuantity(paymentTokenQuantity.getOrNull())

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

        /** The ID of the `Stock` for which the `Order` is being placed. */
        fun stockId(stockId: String?) = apply { body.stockId(stockId) }

        /** Alias for calling [Builder.stockId] with `stockId.orElse(null)`. */
        fun stockId(stockId: Optional<String>) = stockId(stockId.getOrNull())

        /**
         * Sets [Builder.stockId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stockId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stockId(stockId: JsonField<String>) = apply { body.stockId(stockId) }

        /** The ID of the `Token` for which the `Order` is being placed. */
        fun tokenId(tokenId: String?) = apply { body.tokenId(tokenId) }

        /** Alias for calling [Builder.tokenId] with `tokenId.orElse(null)`. */
        fun tokenId(tokenId: Optional<String>) = tokenId(tokenId.getOrNull())

        /**
         * Sets [Builder.tokenId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tokenId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tokenId(tokenId: JsonField<String>) = apply { body.tokenId(tokenId) }

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
         * Returns an immutable instance of [Eip155CreatePermitParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .orderSide()
         * .orderTif()
         * .orderType()
         * .paymentToken()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155CreatePermitParams =
            Eip155CreatePermitParams(
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

    /**
     * Input parameters for building a token permit involved in creating an `OrderRequest` using
     * Dinari's EVM smart contracts.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val chainId: JsonField<Chain>,
        private val orderSide: JsonField<OrderSide>,
        private val orderTif: JsonField<OrderTif>,
        private val orderType: JsonField<OrderType>,
        private val paymentToken: JsonField<String>,
        private val assetTokenQuantity: JsonField<Double>,
        private val clientOrderId: JsonField<String>,
        private val limitPrice: JsonField<Double>,
        private val paymentTokenQuantity: JsonField<Double>,
        private val stockId: JsonField<String>,
        private val tokenId: JsonField<String>,
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
            @JsonProperty("payment_token")
            @ExcludeMissing
            paymentToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("asset_token_quantity")
            @ExcludeMissing
            assetTokenQuantity: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("client_order_id")
            @ExcludeMissing
            clientOrderId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("limit_price")
            @ExcludeMissing
            limitPrice: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("payment_token_quantity")
            @ExcludeMissing
            paymentTokenQuantity: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("token_id") @ExcludeMissing tokenId: JsonField<String> = JsonMissing.of(),
        ) : this(
            chainId,
            orderSide,
            orderTif,
            orderType,
            paymentToken,
            assetTokenQuantity,
            clientOrderId,
            limitPrice,
            paymentTokenQuantity,
            stockId,
            tokenId,
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
         * Address of payment token.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun paymentToken(): String = paymentToken.getRequired("payment_token")

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
         * Customer-supplied unique identifier to map this `Order` to an order in the customer's
         * systems.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun clientOrderId(): Optional<String> = clientOrderId.getOptional("client_order_id")

        /**
         * Price per asset in the asset's native currency. USD for US equities and ETFs. Required
         * for limit `Orders`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun limitPrice(): Optional<Double> = limitPrice.getOptional("limit_price")

        /**
         * Amount of payment tokens involved. Required for market buy `Orders`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun paymentTokenQuantity(): Optional<Double> =
            paymentTokenQuantity.getOptional("payment_token_quantity")

        /**
         * The ID of the `Stock` for which the `Order` is being placed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun stockId(): Optional<String> = stockId.getOptional("stock_id")

        /**
         * The ID of the `Token` for which the `Order` is being placed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tokenId(): Optional<String> = tokenId.getOptional("token_id")

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
         * Returns the raw JSON value of [paymentToken].
         *
         * Unlike [paymentToken], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("payment_token")
        @ExcludeMissing
        fun _paymentToken(): JsonField<String> = paymentToken

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
         * Returns the raw JSON value of [clientOrderId].
         *
         * Unlike [clientOrderId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("client_order_id")
        @ExcludeMissing
        fun _clientOrderId(): JsonField<String> = clientOrderId

        /**
         * Returns the raw JSON value of [limitPrice].
         *
         * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit_price")
        @ExcludeMissing
        fun _limitPrice(): JsonField<Double> = limitPrice

        /**
         * Returns the raw JSON value of [paymentTokenQuantity].
         *
         * Unlike [paymentTokenQuantity], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("payment_token_quantity")
        @ExcludeMissing
        fun _paymentTokenQuantity(): JsonField<Double> = paymentTokenQuantity

        /**
         * Returns the raw JSON value of [stockId].
         *
         * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

        /**
         * Returns the raw JSON value of [tokenId].
         *
         * Unlike [tokenId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("token_id") @ExcludeMissing fun _tokenId(): JsonField<String> = tokenId

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
             * .paymentToken()
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
            private var paymentToken: JsonField<String>? = null
            private var assetTokenQuantity: JsonField<Double> = JsonMissing.of()
            private var clientOrderId: JsonField<String> = JsonMissing.of()
            private var limitPrice: JsonField<Double> = JsonMissing.of()
            private var paymentTokenQuantity: JsonField<Double> = JsonMissing.of()
            private var stockId: JsonField<String> = JsonMissing.of()
            private var tokenId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                chainId = body.chainId
                orderSide = body.orderSide
                orderTif = body.orderTif
                orderType = body.orderType
                paymentToken = body.paymentToken
                assetTokenQuantity = body.assetTokenQuantity
                clientOrderId = body.clientOrderId
                limitPrice = body.limitPrice
                paymentTokenQuantity = body.paymentTokenQuantity
                stockId = body.stockId
                tokenId = body.tokenId
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

            /**
             * Amount of dShare asset tokens involved. Required for limit `Orders` and market sell
             * `Orders`.
             */
            fun assetTokenQuantity(assetTokenQuantity: Double?) =
                assetTokenQuantity(JsonField.ofNullable(assetTokenQuantity))

            /**
             * Alias for [Builder.assetTokenQuantity].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun assetTokenQuantity(assetTokenQuantity: Double) =
                assetTokenQuantity(assetTokenQuantity as Double?)

            /**
             * Alias for calling [Builder.assetTokenQuantity] with
             * `assetTokenQuantity.orElse(null)`.
             */
            fun assetTokenQuantity(assetTokenQuantity: Optional<Double>) =
                assetTokenQuantity(assetTokenQuantity.getOrNull())

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
             * Customer-supplied unique identifier to map this `Order` to an order in the customer's
             * systems.
             */
            fun clientOrderId(clientOrderId: String?) =
                clientOrderId(JsonField.ofNullable(clientOrderId))

            /** Alias for calling [Builder.clientOrderId] with `clientOrderId.orElse(null)`. */
            fun clientOrderId(clientOrderId: Optional<String>) =
                clientOrderId(clientOrderId.getOrNull())

            /**
             * Sets [Builder.clientOrderId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clientOrderId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clientOrderId(clientOrderId: JsonField<String>) = apply {
                this.clientOrderId = clientOrderId
            }

            /**
             * Price per asset in the asset's native currency. USD for US equities and ETFs.
             * Required for limit `Orders`.
             */
            fun limitPrice(limitPrice: Double?) = limitPrice(JsonField.ofNullable(limitPrice))

            /**
             * Alias for [Builder.limitPrice].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun limitPrice(limitPrice: Double) = limitPrice(limitPrice as Double?)

            /** Alias for calling [Builder.limitPrice] with `limitPrice.orElse(null)`. */
            fun limitPrice(limitPrice: Optional<Double>) = limitPrice(limitPrice.getOrNull())

            /**
             * Sets [Builder.limitPrice] to an arbitrary JSON value.
             *
             * You should usually call [Builder.limitPrice] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun limitPrice(limitPrice: JsonField<Double>) = apply { this.limitPrice = limitPrice }

            /** Amount of payment tokens involved. Required for market buy `Orders`. */
            fun paymentTokenQuantity(paymentTokenQuantity: Double?) =
                paymentTokenQuantity(JsonField.ofNullable(paymentTokenQuantity))

            /**
             * Alias for [Builder.paymentTokenQuantity].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun paymentTokenQuantity(paymentTokenQuantity: Double) =
                paymentTokenQuantity(paymentTokenQuantity as Double?)

            /**
             * Alias for calling [Builder.paymentTokenQuantity] with
             * `paymentTokenQuantity.orElse(null)`.
             */
            fun paymentTokenQuantity(paymentTokenQuantity: Optional<Double>) =
                paymentTokenQuantity(paymentTokenQuantity.getOrNull())

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

            /** The ID of the `Stock` for which the `Order` is being placed. */
            fun stockId(stockId: String?) = stockId(JsonField.ofNullable(stockId))

            /** Alias for calling [Builder.stockId] with `stockId.orElse(null)`. */
            fun stockId(stockId: Optional<String>) = stockId(stockId.getOrNull())

            /**
             * Sets [Builder.stockId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stockId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

            /** The ID of the `Token` for which the `Order` is being placed. */
            fun tokenId(tokenId: String?) = tokenId(JsonField.ofNullable(tokenId))

            /** Alias for calling [Builder.tokenId] with `tokenId.orElse(null)`. */
            fun tokenId(tokenId: Optional<String>) = tokenId(tokenId.getOrNull())

            /**
             * Sets [Builder.tokenId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tokenId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tokenId(tokenId: JsonField<String>) = apply { this.tokenId = tokenId }

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
             * .paymentToken()
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
                    checkRequired("paymentToken", paymentToken),
                    assetTokenQuantity,
                    clientOrderId,
                    limitPrice,
                    paymentTokenQuantity,
                    stockId,
                    tokenId,
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
            paymentToken()
            assetTokenQuantity()
            clientOrderId()
            limitPrice()
            paymentTokenQuantity()
            stockId()
            tokenId()
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
                (if (paymentToken.asKnown().isPresent) 1 else 0) +
                (if (assetTokenQuantity.asKnown().isPresent) 1 else 0) +
                (if (clientOrderId.asKnown().isPresent) 1 else 0) +
                (if (limitPrice.asKnown().isPresent) 1 else 0) +
                (if (paymentTokenQuantity.asKnown().isPresent) 1 else 0) +
                (if (stockId.asKnown().isPresent) 1 else 0) +
                (if (tokenId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                chainId == other.chainId &&
                orderSide == other.orderSide &&
                orderTif == other.orderTif &&
                orderType == other.orderType &&
                paymentToken == other.paymentToken &&
                assetTokenQuantity == other.assetTokenQuantity &&
                clientOrderId == other.clientOrderId &&
                limitPrice == other.limitPrice &&
                paymentTokenQuantity == other.paymentTokenQuantity &&
                stockId == other.stockId &&
                tokenId == other.tokenId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                chainId,
                orderSide,
                orderTif,
                orderType,
                paymentToken,
                assetTokenQuantity,
                clientOrderId,
                limitPrice,
                paymentTokenQuantity,
                stockId,
                tokenId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{chainId=$chainId, orderSide=$orderSide, orderTif=$orderTif, orderType=$orderType, paymentToken=$paymentToken, assetTokenQuantity=$assetTokenQuantity, clientOrderId=$clientOrderId, limitPrice=$limitPrice, paymentTokenQuantity=$paymentTokenQuantity, stockId=$stockId, tokenId=$tokenId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Eip155CreatePermitParams &&
            accountId == other.accountId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(accountId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "Eip155CreatePermitParams{accountId=$accountId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
