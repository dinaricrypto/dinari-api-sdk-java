// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.errors.DinariInvalidDataException
import com.dinari.api.models.v2.accounts.Chain
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Order
private constructor(
    private val id: JsonField<String>,
    private val chainId: JsonField<Chain>,
    private val createdDt: JsonField<OffsetDateTime>,
    private val orderContractAddress: JsonField<String>,
    private val orderSide: JsonField<OrderSide>,
    private val orderTif: JsonField<OrderTif>,
    private val orderTransactionHash: JsonField<String>,
    private val orderType: JsonField<OrderType>,
    private val status: JsonField<BrokerageOrderStatus>,
    private val stockId: JsonField<String>,
    private val assetToken: JsonField<String>,
    private val assetTokenQuantity: JsonField<Double>,
    private val cancelTransactionHash: JsonField<String>,
    private val fee: JsonField<Double>,
    private val limitPrice: JsonField<Double>,
    private val paymentToken: JsonField<String>,
    private val paymentTokenQuantity: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Chain> = JsonMissing.of(),
        @JsonProperty("created_dt")
        @ExcludeMissing
        createdDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("order_contract_address")
        @ExcludeMissing
        orderContractAddress: JsonField<String> = JsonMissing.of(),
        @JsonProperty("order_side")
        @ExcludeMissing
        orderSide: JsonField<OrderSide> = JsonMissing.of(),
        @JsonProperty("order_tif") @ExcludeMissing orderTif: JsonField<OrderTif> = JsonMissing.of(),
        @JsonProperty("order_transaction_hash")
        @ExcludeMissing
        orderTransactionHash: JsonField<String> = JsonMissing.of(),
        @JsonProperty("order_type")
        @ExcludeMissing
        orderType: JsonField<OrderType> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<BrokerageOrderStatus> = JsonMissing.of(),
        @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("asset_token")
        @ExcludeMissing
        assetToken: JsonField<String> = JsonMissing.of(),
        @JsonProperty("asset_token_quantity")
        @ExcludeMissing
        assetTokenQuantity: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("cancel_transaction_hash")
        @ExcludeMissing
        cancelTransactionHash: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fee") @ExcludeMissing fee: JsonField<Double> = JsonMissing.of(),
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
        id,
        chainId,
        createdDt,
        orderContractAddress,
        orderSide,
        orderTif,
        orderTransactionHash,
        orderType,
        status,
        stockId,
        assetToken,
        assetTokenQuantity,
        cancelTransactionHash,
        fee,
        limitPrice,
        paymentToken,
        paymentTokenQuantity,
        mutableMapOf(),
    )

    /**
     * ID of the `Order`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * CAIP-2 formatted chain ID of the blockchain that the `Order` transaction was run on.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): Chain = chainId.getRequired("chain_id")

    /**
     * Datetime at which the `Order` was created. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdDt(): OffsetDateTime = createdDt.getRequired("created_dt")

    /**
     * Smart contract address that `Order` was created from.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderContractAddress(): String = orderContractAddress.getRequired("order_contract_address")

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
     * Transaction hash for the `Order` creation.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderTransactionHash(): String = orderTransactionHash.getRequired("order_transaction_hash")

    /**
     * Type of `Order`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderType(): OrderType = orderType.getRequired("order_type")

    /**
     * Status of the `Order`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): BrokerageOrderStatus = status.getRequired("status")

    /**
     * The `Stock` ID associated with the `Order`
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stockId(): String = stockId.getRequired("stock_id")

    /**
     * The dShare asset token address.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun assetToken(): Optional<String> = assetToken.getOptional("asset_token")

    /**
     * Total amount of assets involved.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun assetTokenQuantity(): Optional<Double> =
        assetTokenQuantity.getOptional("asset_token_quantity")

    /**
     * Transaction hash for cancellation of `Order`, if the `Order` was cancelled.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cancelTransactionHash(): Optional<String> =
        cancelTransactionHash.getOptional("cancel_transaction_hash")

    /**
     * Fee amount associated with `Order`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fee(): Optional<Double> = fee.getOptional("fee")

    /**
     * For limit `Orders`, the price per asset, specified in the `Stock`'s native currency (USD for
     * US equities and ETFs).
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun limitPrice(): Optional<Double> = limitPrice.getOptional("limit_price")

    /**
     * The payment token (stablecoin) address.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentToken(): Optional<String> = paymentToken.getOptional("payment_token")

    /**
     * Total amount of payment involved.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun paymentTokenQuantity(): Optional<Double> =
        paymentTokenQuantity.getOptional("payment_token_quantity")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Chain> = chainId

    /**
     * Returns the raw JSON value of [createdDt].
     *
     * Unlike [createdDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_dt")
    @ExcludeMissing
    fun _createdDt(): JsonField<OffsetDateTime> = createdDt

    /**
     * Returns the raw JSON value of [orderContractAddress].
     *
     * Unlike [orderContractAddress], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("order_contract_address")
    @ExcludeMissing
    fun _orderContractAddress(): JsonField<String> = orderContractAddress

    /**
     * Returns the raw JSON value of [orderSide].
     *
     * Unlike [orderSide], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_side") @ExcludeMissing fun _orderSide(): JsonField<OrderSide> = orderSide

    /**
     * Returns the raw JSON value of [orderTif].
     *
     * Unlike [orderTif], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_tif") @ExcludeMissing fun _orderTif(): JsonField<OrderTif> = orderTif

    /**
     * Returns the raw JSON value of [orderTransactionHash].
     *
     * Unlike [orderTransactionHash], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("order_transaction_hash")
    @ExcludeMissing
    fun _orderTransactionHash(): JsonField<String> = orderTransactionHash

    /**
     * Returns the raw JSON value of [orderType].
     *
     * Unlike [orderType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_type") @ExcludeMissing fun _orderType(): JsonField<OrderType> = orderType

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<BrokerageOrderStatus> = status

    /**
     * Returns the raw JSON value of [stockId].
     *
     * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

    /**
     * Returns the raw JSON value of [assetToken].
     *
     * Unlike [assetToken], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("asset_token") @ExcludeMissing fun _assetToken(): JsonField<String> = assetToken

    /**
     * Returns the raw JSON value of [assetTokenQuantity].
     *
     * Unlike [assetTokenQuantity], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("asset_token_quantity")
    @ExcludeMissing
    fun _assetTokenQuantity(): JsonField<Double> = assetTokenQuantity

    /**
     * Returns the raw JSON value of [cancelTransactionHash].
     *
     * Unlike [cancelTransactionHash], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("cancel_transaction_hash")
    @ExcludeMissing
    fun _cancelTransactionHash(): JsonField<String> = cancelTransactionHash

    /**
     * Returns the raw JSON value of [fee].
     *
     * Unlike [fee], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fee") @ExcludeMissing fun _fee(): JsonField<Double> = fee

    /**
     * Returns the raw JSON value of [limitPrice].
     *
     * Unlike [limitPrice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("limit_price") @ExcludeMissing fun _limitPrice(): JsonField<Double> = limitPrice

    /**
     * Returns the raw JSON value of [paymentToken].
     *
     * Unlike [paymentToken], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("payment_token")
    @ExcludeMissing
    fun _paymentToken(): JsonField<String> = paymentToken

    /**
     * Returns the raw JSON value of [paymentTokenQuantity].
     *
     * Unlike [paymentTokenQuantity], this method doesn't throw if the JSON field has an unexpected
     * type.
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
         * Returns a mutable builder for constructing an instance of [Order].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .chainId()
         * .createdDt()
         * .orderContractAddress()
         * .orderSide()
         * .orderTif()
         * .orderTransactionHash()
         * .orderType()
         * .status()
         * .stockId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Order]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var chainId: JsonField<Chain>? = null
        private var createdDt: JsonField<OffsetDateTime>? = null
        private var orderContractAddress: JsonField<String>? = null
        private var orderSide: JsonField<OrderSide>? = null
        private var orderTif: JsonField<OrderTif>? = null
        private var orderTransactionHash: JsonField<String>? = null
        private var orderType: JsonField<OrderType>? = null
        private var status: JsonField<BrokerageOrderStatus>? = null
        private var stockId: JsonField<String>? = null
        private var assetToken: JsonField<String> = JsonMissing.of()
        private var assetTokenQuantity: JsonField<Double> = JsonMissing.of()
        private var cancelTransactionHash: JsonField<String> = JsonMissing.of()
        private var fee: JsonField<Double> = JsonMissing.of()
        private var limitPrice: JsonField<Double> = JsonMissing.of()
        private var paymentToken: JsonField<String> = JsonMissing.of()
        private var paymentTokenQuantity: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(order: Order) = apply {
            id = order.id
            chainId = order.chainId
            createdDt = order.createdDt
            orderContractAddress = order.orderContractAddress
            orderSide = order.orderSide
            orderTif = order.orderTif
            orderTransactionHash = order.orderTransactionHash
            orderType = order.orderType
            status = order.status
            stockId = order.stockId
            assetToken = order.assetToken
            assetTokenQuantity = order.assetTokenQuantity
            cancelTransactionHash = order.cancelTransactionHash
            fee = order.fee
            limitPrice = order.limitPrice
            paymentToken = order.paymentToken
            paymentTokenQuantity = order.paymentTokenQuantity
            additionalProperties = order.additionalProperties.toMutableMap()
        }

        /** ID of the `Order`. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** CAIP-2 formatted chain ID of the blockchain that the `Order` transaction was run on. */
        fun chainId(chainId: Chain) = chainId(JsonField.of(chainId))

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [Chain] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<Chain>) = apply { this.chainId = chainId }

        /** Datetime at which the `Order` was created. ISO 8601 timestamp. */
        fun createdDt(createdDt: OffsetDateTime) = createdDt(JsonField.of(createdDt))

        /**
         * Sets [Builder.createdDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdDt(createdDt: JsonField<OffsetDateTime>) = apply { this.createdDt = createdDt }

        /** Smart contract address that `Order` was created from. */
        fun orderContractAddress(orderContractAddress: String) =
            orderContractAddress(JsonField.of(orderContractAddress))

        /**
         * Sets [Builder.orderContractAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderContractAddress] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun orderContractAddress(orderContractAddress: JsonField<String>) = apply {
            this.orderContractAddress = orderContractAddress
        }

        /** Indicates whether `Order` is a buy or sell. */
        fun orderSide(orderSide: OrderSide) = orderSide(JsonField.of(orderSide))

        /**
         * Sets [Builder.orderSide] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderSide] with a well-typed [OrderSide] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderSide(orderSide: JsonField<OrderSide>) = apply { this.orderSide = orderSide }

        /** Time in force. Indicates how long `Order` is valid for. */
        fun orderTif(orderTif: OrderTif) = orderTif(JsonField.of(orderTif))

        /**
         * Sets [Builder.orderTif] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderTif] with a well-typed [OrderTif] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderTif(orderTif: JsonField<OrderTif>) = apply { this.orderTif = orderTif }

        /** Transaction hash for the `Order` creation. */
        fun orderTransactionHash(orderTransactionHash: String) =
            orderTransactionHash(JsonField.of(orderTransactionHash))

        /**
         * Sets [Builder.orderTransactionHash] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderTransactionHash] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun orderTransactionHash(orderTransactionHash: JsonField<String>) = apply {
            this.orderTransactionHash = orderTransactionHash
        }

        /** Type of `Order`. */
        fun orderType(orderType: OrderType) = orderType(JsonField.of(orderType))

        /**
         * Sets [Builder.orderType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderType] with a well-typed [OrderType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderType(orderType: JsonField<OrderType>) = apply { this.orderType = orderType }

        /** Status of the `Order`. */
        fun status(status: BrokerageOrderStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [BrokerageOrderStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<BrokerageOrderStatus>) = apply { this.status = status }

        /** The `Stock` ID associated with the `Order` */
        fun stockId(stockId: String) = stockId(JsonField.of(stockId))

        /**
         * Sets [Builder.stockId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stockId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

        /** The dShare asset token address. */
        fun assetToken(assetToken: String) = assetToken(JsonField.of(assetToken))

        /**
         * Sets [Builder.assetToken] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assetToken] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun assetToken(assetToken: JsonField<String>) = apply { this.assetToken = assetToken }

        /** Total amount of assets involved. */
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

        /** Transaction hash for cancellation of `Order`, if the `Order` was cancelled. */
        fun cancelTransactionHash(cancelTransactionHash: String) =
            cancelTransactionHash(JsonField.of(cancelTransactionHash))

        /**
         * Sets [Builder.cancelTransactionHash] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancelTransactionHash] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cancelTransactionHash(cancelTransactionHash: JsonField<String>) = apply {
            this.cancelTransactionHash = cancelTransactionHash
        }

        /** Fee amount associated with `Order`. */
        fun fee(fee: Double) = fee(JsonField.of(fee))

        /**
         * Sets [Builder.fee] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fee] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fee(fee: JsonField<Double>) = apply { this.fee = fee }

        /**
         * For limit `Orders`, the price per asset, specified in the `Stock`'s native currency (USD
         * for US equities and ETFs).
         */
        fun limitPrice(limitPrice: Double) = limitPrice(JsonField.of(limitPrice))

        /**
         * Sets [Builder.limitPrice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limitPrice] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun limitPrice(limitPrice: JsonField<Double>) = apply { this.limitPrice = limitPrice }

        /** The payment token (stablecoin) address. */
        fun paymentToken(paymentToken: String) = paymentToken(JsonField.of(paymentToken))

        /**
         * Sets [Builder.paymentToken] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentToken] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun paymentToken(paymentToken: JsonField<String>) = apply {
            this.paymentToken = paymentToken
        }

        /** Total amount of payment involved. */
        fun paymentTokenQuantity(paymentTokenQuantity: Double) =
            paymentTokenQuantity(JsonField.of(paymentTokenQuantity))

        /**
         * Sets [Builder.paymentTokenQuantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentTokenQuantity] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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
         * Returns an immutable instance of [Order].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .chainId()
         * .createdDt()
         * .orderContractAddress()
         * .orderSide()
         * .orderTif()
         * .orderTransactionHash()
         * .orderType()
         * .status()
         * .stockId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Order =
            Order(
                checkRequired("id", id),
                checkRequired("chainId", chainId),
                checkRequired("createdDt", createdDt),
                checkRequired("orderContractAddress", orderContractAddress),
                checkRequired("orderSide", orderSide),
                checkRequired("orderTif", orderTif),
                checkRequired("orderTransactionHash", orderTransactionHash),
                checkRequired("orderType", orderType),
                checkRequired("status", status),
                checkRequired("stockId", stockId),
                assetToken,
                assetTokenQuantity,
                cancelTransactionHash,
                fee,
                limitPrice,
                paymentToken,
                paymentTokenQuantity,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Order = apply {
        if (validated) {
            return@apply
        }

        id()
        chainId().validate()
        createdDt()
        orderContractAddress()
        orderSide().validate()
        orderTif().validate()
        orderTransactionHash()
        orderType().validate()
        status().validate()
        stockId()
        assetToken()
        assetTokenQuantity()
        cancelTransactionHash()
        fee()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (chainId.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdDt.asKnown().isPresent) 1 else 0) +
            (if (orderContractAddress.asKnown().isPresent) 1 else 0) +
            (orderSide.asKnown().getOrNull()?.validity() ?: 0) +
            (orderTif.asKnown().getOrNull()?.validity() ?: 0) +
            (if (orderTransactionHash.asKnown().isPresent) 1 else 0) +
            (orderType.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (stockId.asKnown().isPresent) 1 else 0) +
            (if (assetToken.asKnown().isPresent) 1 else 0) +
            (if (assetTokenQuantity.asKnown().isPresent) 1 else 0) +
            (if (cancelTransactionHash.asKnown().isPresent) 1 else 0) +
            (if (fee.asKnown().isPresent) 1 else 0) +
            (if (limitPrice.asKnown().isPresent) 1 else 0) +
            (if (paymentToken.asKnown().isPresent) 1 else 0) +
            (if (paymentTokenQuantity.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Order && id == other.id && chainId == other.chainId && createdDt == other.createdDt && orderContractAddress == other.orderContractAddress && orderSide == other.orderSide && orderTif == other.orderTif && orderTransactionHash == other.orderTransactionHash && orderType == other.orderType && status == other.status && stockId == other.stockId && assetToken == other.assetToken && assetTokenQuantity == other.assetTokenQuantity && cancelTransactionHash == other.cancelTransactionHash && fee == other.fee && limitPrice == other.limitPrice && paymentToken == other.paymentToken && paymentTokenQuantity == other.paymentTokenQuantity && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, chainId, createdDt, orderContractAddress, orderSide, orderTif, orderTransactionHash, orderType, status, stockId, assetToken, assetTokenQuantity, cancelTransactionHash, fee, limitPrice, paymentToken, paymentTokenQuantity, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Order{id=$id, chainId=$chainId, createdDt=$createdDt, orderContractAddress=$orderContractAddress, orderSide=$orderSide, orderTif=$orderTif, orderTransactionHash=$orderTransactionHash, orderType=$orderType, status=$status, stockId=$stockId, assetToken=$assetToken, assetTokenQuantity=$assetTokenQuantity, cancelTransactionHash=$cancelTransactionHash, fee=$fee, limitPrice=$limitPrice, paymentToken=$paymentToken, paymentTokenQuantity=$paymentTokenQuantity, additionalProperties=$additionalProperties}"
}
