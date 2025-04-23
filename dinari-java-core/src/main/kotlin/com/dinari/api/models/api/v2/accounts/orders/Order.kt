// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orders

import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkKnown
import com.dinari.api.core.checkRequired
import com.dinari.api.core.toImmutable
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Order
private constructor(
    private val id: JsonField<String>,
    private val assetTokenQuantity: JsonField<Double>,
    private val brokerageOrderStatus: JsonField<BrokerageOrderStatus>,
    private val chainId: JsonField<Long>,
    private val orderContractAddress: JsonField<String>,
    private val orderSide: JsonField<OrderSide>,
    private val orderTif: JsonField<OrderTif>,
    private val orderTransactionHash: JsonField<String>,
    private val orderType: JsonField<OrderType>,
    private val paymentTokenQuantity: JsonField<Double>,
    private val smartContractOrderId: JsonField<String>,
    private val cancelTransactionHash: JsonField<String>,
    private val fees: JsonField<List<Fee>>,
    private val networkFeeInUsd: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("asset_token_quantity")
        @ExcludeMissing
        assetTokenQuantity: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("brokerage_order_status")
        @ExcludeMissing
        brokerageOrderStatus: JsonField<BrokerageOrderStatus> = JsonMissing.of(),
        @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Long> = JsonMissing.of(),
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
        @JsonProperty("payment_token_quantity")
        @ExcludeMissing
        paymentTokenQuantity: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("smart_contract_order_id")
        @ExcludeMissing
        smartContractOrderId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cancel_transaction_hash")
        @ExcludeMissing
        cancelTransactionHash: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fees") @ExcludeMissing fees: JsonField<List<Fee>> = JsonMissing.of(),
        @JsonProperty("network_fee_in_usd")
        @ExcludeMissing
        networkFeeInUsd: JsonField<Double> = JsonMissing.of(),
    ) : this(
        id,
        assetTokenQuantity,
        brokerageOrderStatus,
        chainId,
        orderContractAddress,
        orderSide,
        orderTif,
        orderTransactionHash,
        orderType,
        paymentTokenQuantity,
        smartContractOrderId,
        cancelTransactionHash,
        fees,
        networkFeeInUsd,
        mutableMapOf(),
    )

    /**
     * Identifier of the order
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Total amount of assets involved
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assetTokenQuantity(): Double = assetTokenQuantity.getRequired("asset_token_quantity")

    /**
     * Status of the order
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun brokerageOrderStatus(): BrokerageOrderStatus =
        brokerageOrderStatus.getRequired("brokerage_order_status")

    /**
     * Blockchain that transaction was run on
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): Long = chainId.getRequired("chain_id")

    /**
     * Smart Contract address that order came from
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderContractAddress(): String = orderContractAddress.getRequired("order_contract_address")

    /**
     * Indicates if order is a buy or sell
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderSide(): OrderSide = orderSide.getRequired("order_side")

    /**
     * Indicates how long order is valid
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderTif(): OrderTif = orderTif.getRequired("order_tif")

    /**
     * Transaction hash for the order
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderTransactionHash(): String = orderTransactionHash.getRequired("order_transaction_hash")

    /**
     * Indicates what type of order
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderType(): OrderType = orderType.getRequired("order_type")

    /**
     * Total amount of payment involved
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentTokenQuantity(): Double = paymentTokenQuantity.getRequired("payment_token_quantity")

    /**
     * Unique identifier of this Order generated by the order contract.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun smartContractOrderId(): String = smartContractOrderId.getRequired("smart_contract_order_id")

    /**
     * Transaction hash for cancellation of order
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cancelTransactionHash(): Optional<String> =
        cancelTransactionHash.getOptional("cancel_transaction_hash")

    /**
     * List of fees associated with order
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fees(): Optional<List<Fee>> = fees.getOptional("fees")

    /**
     * Total amount of network fee taken in USD
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun networkFeeInUsd(): Optional<Double> = networkFeeInUsd.getOptional("network_fee_in_usd")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
     * Returns the raw JSON value of [brokerageOrderStatus].
     *
     * Unlike [brokerageOrderStatus], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("brokerage_order_status")
    @ExcludeMissing
    fun _brokerageOrderStatus(): JsonField<BrokerageOrderStatus> = brokerageOrderStatus

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Long> = chainId

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
     * Returns the raw JSON value of [paymentTokenQuantity].
     *
     * Unlike [paymentTokenQuantity], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("payment_token_quantity")
    @ExcludeMissing
    fun _paymentTokenQuantity(): JsonField<Double> = paymentTokenQuantity

    /**
     * Returns the raw JSON value of [smartContractOrderId].
     *
     * Unlike [smartContractOrderId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("smart_contract_order_id")
    @ExcludeMissing
    fun _smartContractOrderId(): JsonField<String> = smartContractOrderId

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
     * Returns the raw JSON value of [fees].
     *
     * Unlike [fees], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fees") @ExcludeMissing fun _fees(): JsonField<List<Fee>> = fees

    /**
     * Returns the raw JSON value of [networkFeeInUsd].
     *
     * Unlike [networkFeeInUsd], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("network_fee_in_usd")
    @ExcludeMissing
    fun _networkFeeInUsd(): JsonField<Double> = networkFeeInUsd

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
         * .assetTokenQuantity()
         * .brokerageOrderStatus()
         * .chainId()
         * .orderContractAddress()
         * .orderSide()
         * .orderTif()
         * .orderTransactionHash()
         * .orderType()
         * .paymentTokenQuantity()
         * .smartContractOrderId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Order]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var assetTokenQuantity: JsonField<Double>? = null
        private var brokerageOrderStatus: JsonField<BrokerageOrderStatus>? = null
        private var chainId: JsonField<Long>? = null
        private var orderContractAddress: JsonField<String>? = null
        private var orderSide: JsonField<OrderSide>? = null
        private var orderTif: JsonField<OrderTif>? = null
        private var orderTransactionHash: JsonField<String>? = null
        private var orderType: JsonField<OrderType>? = null
        private var paymentTokenQuantity: JsonField<Double>? = null
        private var smartContractOrderId: JsonField<String>? = null
        private var cancelTransactionHash: JsonField<String> = JsonMissing.of()
        private var fees: JsonField<MutableList<Fee>>? = null
        private var networkFeeInUsd: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(order: Order) = apply {
            id = order.id
            assetTokenQuantity = order.assetTokenQuantity
            brokerageOrderStatus = order.brokerageOrderStatus
            chainId = order.chainId
            orderContractAddress = order.orderContractAddress
            orderSide = order.orderSide
            orderTif = order.orderTif
            orderTransactionHash = order.orderTransactionHash
            orderType = order.orderType
            paymentTokenQuantity = order.paymentTokenQuantity
            smartContractOrderId = order.smartContractOrderId
            cancelTransactionHash = order.cancelTransactionHash
            fees = order.fees.map { it.toMutableList() }
            networkFeeInUsd = order.networkFeeInUsd
            additionalProperties = order.additionalProperties.toMutableMap()
        }

        /** Identifier of the order */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Total amount of assets involved */
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

        /** Status of the order */
        fun brokerageOrderStatus(brokerageOrderStatus: BrokerageOrderStatus) =
            brokerageOrderStatus(JsonField.of(brokerageOrderStatus))

        /**
         * Sets [Builder.brokerageOrderStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brokerageOrderStatus] with a well-typed
         * [BrokerageOrderStatus] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun brokerageOrderStatus(brokerageOrderStatus: JsonField<BrokerageOrderStatus>) = apply {
            this.brokerageOrderStatus = brokerageOrderStatus
        }

        /** Blockchain that transaction was run on */
        fun chainId(chainId: Long) = chainId(JsonField.of(chainId))

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<Long>) = apply { this.chainId = chainId }

        /** Smart Contract address that order came from */
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

        /** Indicates if order is a buy or sell */
        fun orderSide(orderSide: OrderSide) = orderSide(JsonField.of(orderSide))

        /**
         * Sets [Builder.orderSide] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderSide] with a well-typed [OrderSide] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderSide(orderSide: JsonField<OrderSide>) = apply { this.orderSide = orderSide }

        /** Indicates how long order is valid */
        fun orderTif(orderTif: OrderTif) = orderTif(JsonField.of(orderTif))

        /**
         * Sets [Builder.orderTif] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderTif] with a well-typed [OrderTif] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderTif(orderTif: JsonField<OrderTif>) = apply { this.orderTif = orderTif }

        /** Transaction hash for the order */
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

        /** Indicates what type of order */
        fun orderType(orderType: OrderType) = orderType(JsonField.of(orderType))

        /**
         * Sets [Builder.orderType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderType] with a well-typed [OrderType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderType(orderType: JsonField<OrderType>) = apply { this.orderType = orderType }

        /** Total amount of payment involved */
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

        /** Unique identifier of this Order generated by the order contract. */
        fun smartContractOrderId(smartContractOrderId: String) =
            smartContractOrderId(JsonField.of(smartContractOrderId))

        /**
         * Sets [Builder.smartContractOrderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.smartContractOrderId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun smartContractOrderId(smartContractOrderId: JsonField<String>) = apply {
            this.smartContractOrderId = smartContractOrderId
        }

        /** Transaction hash for cancellation of order */
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

        /** List of fees associated with order */
        fun fees(fees: List<Fee>) = fees(JsonField.of(fees))

        /**
         * Sets [Builder.fees] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fees] with a well-typed `List<Fee>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fees(fees: JsonField<List<Fee>>) = apply { this.fees = fees.map { it.toMutableList() } }

        /**
         * Adds a single [Fee] to [fees].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFee(fee: Fee) = apply {
            fees = (fees ?: JsonField.of(mutableListOf())).also { checkKnown("fees", it).add(fee) }
        }

        /** Total amount of network fee taken in USD */
        fun networkFeeInUsd(networkFeeInUsd: Double) =
            networkFeeInUsd(JsonField.of(networkFeeInUsd))

        /**
         * Sets [Builder.networkFeeInUsd] to an arbitrary JSON value.
         *
         * You should usually call [Builder.networkFeeInUsd] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun networkFeeInUsd(networkFeeInUsd: JsonField<Double>) = apply {
            this.networkFeeInUsd = networkFeeInUsd
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
         * .assetTokenQuantity()
         * .brokerageOrderStatus()
         * .chainId()
         * .orderContractAddress()
         * .orderSide()
         * .orderTif()
         * .orderTransactionHash()
         * .orderType()
         * .paymentTokenQuantity()
         * .smartContractOrderId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Order =
            Order(
                checkRequired("id", id),
                checkRequired("assetTokenQuantity", assetTokenQuantity),
                checkRequired("brokerageOrderStatus", brokerageOrderStatus),
                checkRequired("chainId", chainId),
                checkRequired("orderContractAddress", orderContractAddress),
                checkRequired("orderSide", orderSide),
                checkRequired("orderTif", orderTif),
                checkRequired("orderTransactionHash", orderTransactionHash),
                checkRequired("orderType", orderType),
                checkRequired("paymentTokenQuantity", paymentTokenQuantity),
                checkRequired("smartContractOrderId", smartContractOrderId),
                cancelTransactionHash,
                (fees ?: JsonMissing.of()).map { it.toImmutable() },
                networkFeeInUsd,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Order = apply {
        if (validated) {
            return@apply
        }

        id()
        assetTokenQuantity()
        brokerageOrderStatus().validate()
        chainId()
        orderContractAddress()
        orderSide().validate()
        orderTif().validate()
        orderTransactionHash()
        orderType().validate()
        paymentTokenQuantity()
        smartContractOrderId()
        cancelTransactionHash()
        fees().ifPresent { it.forEach { it.validate() } }
        networkFeeInUsd()
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
            (if (assetTokenQuantity.asKnown().isPresent) 1 else 0) +
            (brokerageOrderStatus.asKnown().getOrNull()?.validity() ?: 0) +
            (if (chainId.asKnown().isPresent) 1 else 0) +
            (if (orderContractAddress.asKnown().isPresent) 1 else 0) +
            (orderSide.asKnown().getOrNull()?.validity() ?: 0) +
            (orderTif.asKnown().getOrNull()?.validity() ?: 0) +
            (if (orderTransactionHash.asKnown().isPresent) 1 else 0) +
            (orderType.asKnown().getOrNull()?.validity() ?: 0) +
            (if (paymentTokenQuantity.asKnown().isPresent) 1 else 0) +
            (if (smartContractOrderId.asKnown().isPresent) 1 else 0) +
            (if (cancelTransactionHash.asKnown().isPresent) 1 else 0) +
            (fees.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (networkFeeInUsd.asKnown().isPresent) 1 else 0)

    /** Status of the order */
    class BrokerageOrderStatus
    @JsonCreator
    private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PENDING_SUBMIT = of("PENDING_SUBMIT")

            @JvmField val PENDING_CANCEL = of("PENDING_CANCEL")

            @JvmField val PENDING_ESCROW = of("PENDING_ESCROW")

            @JvmField val PENDING_FILL = of("PENDING_FILL")

            @JvmField val ESCROWED = of("ESCROWED")

            @JvmField val SUBMITTED = of("SUBMITTED")

            @JvmField val CANCELLED = of("CANCELLED")

            @JvmField val FILLED = of("FILLED")

            @JvmField val REJECTED = of("REJECTED")

            @JvmField val REQUIRING_CONTACT = of("REQUIRING_CONTACT")

            @JvmField val ERROR = of("ERROR")

            @JvmStatic fun of(value: String) = BrokerageOrderStatus(JsonField.of(value))
        }

        /** An enum containing [BrokerageOrderStatus]'s known values. */
        enum class Known {
            PENDING_SUBMIT,
            PENDING_CANCEL,
            PENDING_ESCROW,
            PENDING_FILL,
            ESCROWED,
            SUBMITTED,
            CANCELLED,
            FILLED,
            REJECTED,
            REQUIRING_CONTACT,
            ERROR,
        }

        /**
         * An enum containing [BrokerageOrderStatus]'s known values, as well as an [_UNKNOWN]
         * member.
         *
         * An instance of [BrokerageOrderStatus] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PENDING_SUBMIT,
            PENDING_CANCEL,
            PENDING_ESCROW,
            PENDING_FILL,
            ESCROWED,
            SUBMITTED,
            CANCELLED,
            FILLED,
            REJECTED,
            REQUIRING_CONTACT,
            ERROR,
            /**
             * An enum member indicating that [BrokerageOrderStatus] was instantiated with an
             * unknown value.
             */
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
                PENDING_SUBMIT -> Value.PENDING_SUBMIT
                PENDING_CANCEL -> Value.PENDING_CANCEL
                PENDING_ESCROW -> Value.PENDING_ESCROW
                PENDING_FILL -> Value.PENDING_FILL
                ESCROWED -> Value.ESCROWED
                SUBMITTED -> Value.SUBMITTED
                CANCELLED -> Value.CANCELLED
                FILLED -> Value.FILLED
                REJECTED -> Value.REJECTED
                REQUIRING_CONTACT -> Value.REQUIRING_CONTACT
                ERROR -> Value.ERROR
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
                PENDING_SUBMIT -> Known.PENDING_SUBMIT
                PENDING_CANCEL -> Known.PENDING_CANCEL
                PENDING_ESCROW -> Known.PENDING_ESCROW
                PENDING_FILL -> Known.PENDING_FILL
                ESCROWED -> Known.ESCROWED
                SUBMITTED -> Known.SUBMITTED
                CANCELLED -> Known.CANCELLED
                FILLED -> Known.FILLED
                REJECTED -> Known.REJECTED
                REQUIRING_CONTACT -> Known.REQUIRING_CONTACT
                ERROR -> Known.ERROR
                else -> throw DinariInvalidDataException("Unknown BrokerageOrderStatus: $value")
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

        fun validate(): BrokerageOrderStatus = apply {
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

            return /* spotless:off */ other is BrokerageOrderStatus && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Indicates if order is a buy or sell */
    class OrderSide @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val BUY = of("BUY")

            @JvmField val SELL = of("SELL")

            @JvmStatic fun of(value: String) = OrderSide(JsonField.of(value))
        }

        /** An enum containing [OrderSide]'s known values. */
        enum class Known {
            BUY,
            SELL,
        }

        /**
         * An enum containing [OrderSide]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OrderSide] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            BUY,
            SELL,
            /**
             * An enum member indicating that [OrderSide] was instantiated with an unknown value.
             */
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
                BUY -> Value.BUY
                SELL -> Value.SELL
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
                BUY -> Known.BUY
                SELL -> Known.SELL
                else -> throw DinariInvalidDataException("Unknown OrderSide: $value")
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

        fun validate(): OrderSide = apply {
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

            return /* spotless:off */ other is OrderSide && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Indicates how long order is valid */
    class OrderTif @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val DAY = of("DAY")

            @JvmField val GTC = of("GTC")

            @JvmField val IOC = of("IOC")

            @JvmField val FOK = of("FOK")

            @JvmStatic fun of(value: String) = OrderTif(JsonField.of(value))
        }

        /** An enum containing [OrderTif]'s known values. */
        enum class Known {
            DAY,
            GTC,
            IOC,
            FOK,
        }

        /**
         * An enum containing [OrderTif]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OrderTif] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DAY,
            GTC,
            IOC,
            FOK,
            /** An enum member indicating that [OrderTif] was instantiated with an unknown value. */
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
                DAY -> Value.DAY
                GTC -> Value.GTC
                IOC -> Value.IOC
                FOK -> Value.FOK
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
                DAY -> Known.DAY
                GTC -> Known.GTC
                IOC -> Known.IOC
                FOK -> Known.FOK
                else -> throw DinariInvalidDataException("Unknown OrderTif: $value")
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

        fun validate(): OrderTif = apply {
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

            return /* spotless:off */ other is OrderTif && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Indicates what type of order */
    class OrderType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val MARKET = of("MARKET")

            @JvmField val LIMIT = of("LIMIT")

            @JvmStatic fun of(value: String) = OrderType(JsonField.of(value))
        }

        /** An enum containing [OrderType]'s known values. */
        enum class Known {
            MARKET,
            LIMIT,
        }

        /**
         * An enum containing [OrderType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OrderType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MARKET,
            LIMIT,
            /**
             * An enum member indicating that [OrderType] was instantiated with an unknown value.
             */
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
                MARKET -> Value.MARKET
                LIMIT -> Value.LIMIT
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
                MARKET -> Known.MARKET
                LIMIT -> Known.LIMIT
                else -> throw DinariInvalidDataException("Unknown OrderType: $value")
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

        fun validate(): OrderType = apply {
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

            return /* spotless:off */ other is OrderType && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Fee
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Fee]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Fee]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fee: Fee) = apply {
                additionalProperties = fee.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Fee].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Fee = Fee(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Fee = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Fee && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Fee{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Order && id == other.id && assetTokenQuantity == other.assetTokenQuantity && brokerageOrderStatus == other.brokerageOrderStatus && chainId == other.chainId && orderContractAddress == other.orderContractAddress && orderSide == other.orderSide && orderTif == other.orderTif && orderTransactionHash == other.orderTransactionHash && orderType == other.orderType && paymentTokenQuantity == other.paymentTokenQuantity && smartContractOrderId == other.smartContractOrderId && cancelTransactionHash == other.cancelTransactionHash && fees == other.fees && networkFeeInUsd == other.networkFeeInUsd && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, assetTokenQuantity, brokerageOrderStatus, chainId, orderContractAddress, orderSide, orderTif, orderTransactionHash, orderType, paymentTokenQuantity, smartContractOrderId, cancelTransactionHash, fees, networkFeeInUsd, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Order{id=$id, assetTokenQuantity=$assetTokenQuantity, brokerageOrderStatus=$brokerageOrderStatus, chainId=$chainId, orderContractAddress=$orderContractAddress, orderSide=$orderSide, orderTif=$orderTif, orderTransactionHash=$orderTransactionHash, orderType=$orderType, paymentTokenQuantity=$paymentTokenQuantity, smartContractOrderId=$smartContractOrderId, cancelTransactionHash=$cancelTransactionHash, fees=$fees, networkFeeInUsd=$networkFeeInUsd, additionalProperties=$additionalProperties}"
}
