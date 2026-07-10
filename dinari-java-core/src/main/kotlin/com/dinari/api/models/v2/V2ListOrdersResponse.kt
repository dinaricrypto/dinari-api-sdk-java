// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2

import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkKnown
import com.dinari.api.core.checkRequired
import com.dinari.api.core.toImmutable
import com.dinari.api.errors.DinariInvalidDataException
import com.dinari.api.models.v2.marketdata.alloys.PaginationMetadata
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class V2ListOrdersResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<List<Data>>,
    private val paginationMetadata: JsonField<PaginationMetadata>,
    private val _sv: JsonField<_Sv>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<List<Data>> = JsonMissing.of(),
        @JsonProperty("pagination_metadata")
        @ExcludeMissing
        paginationMetadata: JsonField<PaginationMetadata> = JsonMissing.of(),
        @JsonProperty("_sv") @ExcludeMissing _sv: JsonField<_Sv> = JsonMissing.of(),
    ) : this(data, paginationMetadata, _sv, mutableMapOf())

    /**
     * List of EntityOrder
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): List<Data> = data.getRequired("data")

    /**
     * Pagination metadata
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paginationMetadata(): PaginationMetadata =
        paginationMetadata.getRequired("pagination_metadata")

    /**
     * Version
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun _sv(): Optional<_Sv> = _sv.getOptional("_sv")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Data>> = data

    /**
     * Returns the raw JSON value of [paginationMetadata].
     *
     * Unlike [paginationMetadata], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("pagination_metadata")
    @ExcludeMissing
    fun _paginationMetadata(): JsonField<PaginationMetadata> = paginationMetadata

    /**
     * Returns the raw JSON value of [_sv].
     *
     * Unlike [_sv], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("_sv") @ExcludeMissing fun __sv(): JsonField<_Sv> = _sv

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
         * Returns a mutable builder for constructing an instance of [V2ListOrdersResponse].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .paginationMetadata()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [V2ListOrdersResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<Data>>? = null
        private var paginationMetadata: JsonField<PaginationMetadata>? = null
        private var _sv: JsonField<_Sv> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(v2ListOrdersResponse: V2ListOrdersResponse) = apply {
            data = v2ListOrdersResponse.data.map { it.toMutableList() }
            paginationMetadata = v2ListOrdersResponse.paginationMetadata
            _sv = v2ListOrdersResponse._sv
            additionalProperties = v2ListOrdersResponse.additionalProperties.toMutableMap()
        }

        /** List of EntityOrder */
        fun data(data: List<Data>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<Data>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<List<Data>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [Data] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: Data) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        /** Pagination metadata */
        fun paginationMetadata(paginationMetadata: PaginationMetadata) =
            paginationMetadata(JsonField.of(paginationMetadata))

        /**
         * Sets [Builder.paginationMetadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paginationMetadata] with a well-typed
         * [PaginationMetadata] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun paginationMetadata(paginationMetadata: JsonField<PaginationMetadata>) = apply {
            this.paginationMetadata = paginationMetadata
        }

        /** Version */
        fun _sv(_sv: _Sv) = _sv(JsonField.of(_sv))

        /**
         * Sets [Builder._sv] to an arbitrary JSON value.
         *
         * You should usually call [Builder._sv] with a well-typed [_Sv] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun _sv(_sv: JsonField<_Sv>) = apply { this._sv = _sv }

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
         * Returns an immutable instance of [V2ListOrdersResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .data()
         * .paginationMetadata()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): V2ListOrdersResponse =
            V2ListOrdersResponse(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("paginationMetadata", paginationMetadata),
                _sv,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws DinariInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): V2ListOrdersResponse = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        paginationMetadata().validate()
        _sv().ifPresent { it.validate() }
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
        (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (paginationMetadata.asKnown().getOrNull()?.validity() ?: 0) +
            (_sv.asKnown().getOrNull()?.validity() ?: 0)

    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val chainId: JsonField<String>,
        private val createdDt: JsonField<OffsetDateTime>,
        private val orderContractAddress: JsonField<String>,
        private val orderSide: JsonField<OrderSide>,
        private val orderTif: JsonField<OrderTif>,
        private val orderTransactionHash: JsonField<String>,
        private val orderType: JsonField<OrderType>,
        private val paymentToken: JsonField<String>,
        private val status: JsonField<BrokerageOrderStatus>,
        private val stockId: JsonField<String>,
        private val accountId: JsonField<String>,
        private val assetToken: JsonField<String>,
        private val assetTokenQuantity: JsonField<Double>,
        private val cancelTransactionHash: JsonField<String>,
        private val clientOrderId: JsonField<String>,
        private val entityId: JsonField<String>,
        private val fee: JsonField<Double>,
        private val limitPrice: JsonField<Double>,
        private val orderRequestId: JsonField<String>,
        private val paymentTokenQuantity: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("created_dt")
            @ExcludeMissing
            createdDt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("order_contract_address")
            @ExcludeMissing
            orderContractAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("order_side")
            @ExcludeMissing
            orderSide: JsonField<OrderSide> = JsonMissing.of(),
            @JsonProperty("order_tif")
            @ExcludeMissing
            orderTif: JsonField<OrderTif> = JsonMissing.of(),
            @JsonProperty("order_transaction_hash")
            @ExcludeMissing
            orderTransactionHash: JsonField<String> = JsonMissing.of(),
            @JsonProperty("order_type")
            @ExcludeMissing
            orderType: JsonField<OrderType> = JsonMissing.of(),
            @JsonProperty("payment_token")
            @ExcludeMissing
            paymentToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status")
            @ExcludeMissing
            status: JsonField<BrokerageOrderStatus> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("account_id")
            @ExcludeMissing
            accountId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("asset_token")
            @ExcludeMissing
            assetToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("asset_token_quantity")
            @ExcludeMissing
            assetTokenQuantity: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("cancel_transaction_hash")
            @ExcludeMissing
            cancelTransactionHash: JsonField<String> = JsonMissing.of(),
            @JsonProperty("client_order_id")
            @ExcludeMissing
            clientOrderId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("entity_id")
            @ExcludeMissing
            entityId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fee") @ExcludeMissing fee: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("limit_price")
            @ExcludeMissing
            limitPrice: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("order_request_id")
            @ExcludeMissing
            orderRequestId: JsonField<String> = JsonMissing.of(),
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
            paymentToken,
            status,
            stockId,
            accountId,
            assetToken,
            assetTokenQuantity,
            cancelTransactionHash,
            clientOrderId,
            entityId,
            fee,
            limitPrice,
            orderRequestId,
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
        fun chainId(): String = chainId.getRequired("chain_id")

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
        fun orderContractAddress(): String =
            orderContractAddress.getRequired("order_contract_address")

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
        fun orderTransactionHash(): String =
            orderTransactionHash.getRequired("order_transaction_hash")

        /**
         * Type of `Order`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderType(): OrderType = orderType.getRequired("order_type")

        /**
         * The payment token (stablecoin) address.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun paymentToken(): String = paymentToken.getRequired("payment_token")

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
         * Account ID the order was made for.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun accountId(): Optional<String> = accountId.getOptional("account_id")

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
         * Customer-supplied unique identifier to map this `Order` to an order in the customer's
         * systems.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun clientOrderId(): Optional<String> = clientOrderId.getOptional("client_order_id")

        /**
         * Entity ID of the Order
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun entityId(): Optional<String> = entityId.getOptional("entity_id")

        /**
         * Fee amount associated with `Order`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fee(): Optional<Double> = fee.getOptional("fee")

        /**
         * For limit `Orders`, the price per asset, specified in the `Stock`'s native currency (USD
         * for US equities and ETFs).
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun limitPrice(): Optional<Double> = limitPrice.getOptional("limit_price")

        /**
         * Order Request ID for the `Order`
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun orderRequestId(): Optional<String> = orderRequestId.getOptional("order_request_id")

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
        @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<String> = chainId

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
         * Unlike [orderContractAddress], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("order_contract_address")
        @ExcludeMissing
        fun _orderContractAddress(): JsonField<String> = orderContractAddress

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
         * Returns the raw JSON value of [orderTransactionHash].
         *
         * Unlike [orderTransactionHash], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("order_transaction_hash")
        @ExcludeMissing
        fun _orderTransactionHash(): JsonField<String> = orderTransactionHash

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
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun _status(): JsonField<BrokerageOrderStatus> = status

        /**
         * Returns the raw JSON value of [stockId].
         *
         * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

        /**
         * Returns the raw JSON value of [accountId].
         *
         * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("account_id") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

        /**
         * Returns the raw JSON value of [assetToken].
         *
         * Unlike [assetToken], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("asset_token")
        @ExcludeMissing
        fun _assetToken(): JsonField<String> = assetToken

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
         * Returns the raw JSON value of [cancelTransactionHash].
         *
         * Unlike [cancelTransactionHash], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("cancel_transaction_hash")
        @ExcludeMissing
        fun _cancelTransactionHash(): JsonField<String> = cancelTransactionHash

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
         * Returns the raw JSON value of [entityId].
         *
         * Unlike [entityId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("entity_id") @ExcludeMissing fun _entityId(): JsonField<String> = entityId

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
        @JsonProperty("limit_price")
        @ExcludeMissing
        fun _limitPrice(): JsonField<Double> = limitPrice

        /**
         * Returns the raw JSON value of [orderRequestId].
         *
         * Unlike [orderRequestId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("order_request_id")
        @ExcludeMissing
        fun _orderRequestId(): JsonField<String> = orderRequestId

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
             * Returns a mutable builder for constructing an instance of [Data].
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
             * .paymentToken()
             * .status()
             * .stockId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var chainId: JsonField<String>? = null
            private var createdDt: JsonField<OffsetDateTime>? = null
            private var orderContractAddress: JsonField<String>? = null
            private var orderSide: JsonField<OrderSide>? = null
            private var orderTif: JsonField<OrderTif>? = null
            private var orderTransactionHash: JsonField<String>? = null
            private var orderType: JsonField<OrderType>? = null
            private var paymentToken: JsonField<String>? = null
            private var status: JsonField<BrokerageOrderStatus>? = null
            private var stockId: JsonField<String>? = null
            private var accountId: JsonField<String> = JsonMissing.of()
            private var assetToken: JsonField<String> = JsonMissing.of()
            private var assetTokenQuantity: JsonField<Double> = JsonMissing.of()
            private var cancelTransactionHash: JsonField<String> = JsonMissing.of()
            private var clientOrderId: JsonField<String> = JsonMissing.of()
            private var entityId: JsonField<String> = JsonMissing.of()
            private var fee: JsonField<Double> = JsonMissing.of()
            private var limitPrice: JsonField<Double> = JsonMissing.of()
            private var orderRequestId: JsonField<String> = JsonMissing.of()
            private var paymentTokenQuantity: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                chainId = data.chainId
                createdDt = data.createdDt
                orderContractAddress = data.orderContractAddress
                orderSide = data.orderSide
                orderTif = data.orderTif
                orderTransactionHash = data.orderTransactionHash
                orderType = data.orderType
                paymentToken = data.paymentToken
                status = data.status
                stockId = data.stockId
                accountId = data.accountId
                assetToken = data.assetToken
                assetTokenQuantity = data.assetTokenQuantity
                cancelTransactionHash = data.cancelTransactionHash
                clientOrderId = data.clientOrderId
                entityId = data.entityId
                fee = data.fee
                limitPrice = data.limitPrice
                orderRequestId = data.orderRequestId
                paymentTokenQuantity = data.paymentTokenQuantity
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** ID of the `Order`. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * CAIP-2 formatted chain ID of the blockchain that the `Order` transaction was run on.
             */
            fun chainId(chainId: String) = chainId(JsonField.of(chainId))

            /**
             * Sets [Builder.chainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chainId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun chainId(chainId: JsonField<String>) = apply { this.chainId = chainId }

            /** Datetime at which the `Order` was created. ISO 8601 timestamp. */
            fun createdDt(createdDt: OffsetDateTime) = createdDt(JsonField.of(createdDt))

            /**
             * Sets [Builder.createdDt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdDt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdDt(createdDt: JsonField<OffsetDateTime>) = apply {
                this.createdDt = createdDt
            }

            /** Smart contract address that `Order` was created from. */
            fun orderContractAddress(orderContractAddress: String) =
                orderContractAddress(JsonField.of(orderContractAddress))

            /**
             * Sets [Builder.orderContractAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderContractAddress] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun orderContractAddress(orderContractAddress: JsonField<String>) = apply {
                this.orderContractAddress = orderContractAddress
            }

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

            /** Transaction hash for the `Order` creation. */
            fun orderTransactionHash(orderTransactionHash: String) =
                orderTransactionHash(JsonField.of(orderTransactionHash))

            /**
             * Sets [Builder.orderTransactionHash] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderTransactionHash] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun orderTransactionHash(orderTransactionHash: JsonField<String>) = apply {
                this.orderTransactionHash = orderTransactionHash
            }

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

            /** The payment token (stablecoin) address. */
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

            /** Status of the `Order`. */
            fun status(status: BrokerageOrderStatus) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [BrokerageOrderStatus]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun status(status: JsonField<BrokerageOrderStatus>) = apply { this.status = status }

            /** The `Stock` ID associated with the `Order` */
            fun stockId(stockId: String) = stockId(JsonField.of(stockId))

            /**
             * Sets [Builder.stockId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stockId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

            /** Account ID the order was made for. */
            fun accountId(accountId: String?) = accountId(JsonField.ofNullable(accountId))

            /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
            fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

            /**
             * Sets [Builder.accountId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accountId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

            /** The dShare asset token address. */
            fun assetToken(assetToken: String?) = assetToken(JsonField.ofNullable(assetToken))

            /** Alias for calling [Builder.assetToken] with `assetToken.orElse(null)`. */
            fun assetToken(assetToken: Optional<String>) = assetToken(assetToken.getOrNull())

            /**
             * Sets [Builder.assetToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.assetToken] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun assetToken(assetToken: JsonField<String>) = apply { this.assetToken = assetToken }

            /** Total amount of assets involved. */
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

            /** Transaction hash for cancellation of `Order`, if the `Order` was cancelled. */
            fun cancelTransactionHash(cancelTransactionHash: String?) =
                cancelTransactionHash(JsonField.ofNullable(cancelTransactionHash))

            /**
             * Alias for calling [Builder.cancelTransactionHash] with
             * `cancelTransactionHash.orElse(null)`.
             */
            fun cancelTransactionHash(cancelTransactionHash: Optional<String>) =
                cancelTransactionHash(cancelTransactionHash.getOrNull())

            /**
             * Sets [Builder.cancelTransactionHash] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cancelTransactionHash] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun cancelTransactionHash(cancelTransactionHash: JsonField<String>) = apply {
                this.cancelTransactionHash = cancelTransactionHash
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

            /** Entity ID of the Order */
            fun entityId(entityId: String?) = entityId(JsonField.ofNullable(entityId))

            /** Alias for calling [Builder.entityId] with `entityId.orElse(null)`. */
            fun entityId(entityId: Optional<String>) = entityId(entityId.getOrNull())

            /**
             * Sets [Builder.entityId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.entityId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun entityId(entityId: JsonField<String>) = apply { this.entityId = entityId }

            /** Fee amount associated with `Order`. */
            fun fee(fee: Double?) = fee(JsonField.ofNullable(fee))

            /**
             * Alias for [Builder.fee].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun fee(fee: Double) = fee(fee as Double?)

            /** Alias for calling [Builder.fee] with `fee.orElse(null)`. */
            fun fee(fee: Optional<Double>) = fee(fee.getOrNull())

            /**
             * Sets [Builder.fee] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fee] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun fee(fee: JsonField<Double>) = apply { this.fee = fee }

            /**
             * For limit `Orders`, the price per asset, specified in the `Stock`'s native currency
             * (USD for US equities and ETFs).
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

            /** Order Request ID for the `Order` */
            fun orderRequestId(orderRequestId: String?) =
                orderRequestId(JsonField.ofNullable(orderRequestId))

            /** Alias for calling [Builder.orderRequestId] with `orderRequestId.orElse(null)`. */
            fun orderRequestId(orderRequestId: Optional<String>) =
                orderRequestId(orderRequestId.getOrNull())

            /**
             * Sets [Builder.orderRequestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderRequestId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderRequestId(orderRequestId: JsonField<String>) = apply {
                this.orderRequestId = orderRequestId
            }

            /** Total amount of payment involved. */
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
             * Returns an immutable instance of [Data].
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
             * .paymentToken()
             * .status()
             * .stockId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Data =
                Data(
                    checkRequired("id", id),
                    checkRequired("chainId", chainId),
                    checkRequired("createdDt", createdDt),
                    checkRequired("orderContractAddress", orderContractAddress),
                    checkRequired("orderSide", orderSide),
                    checkRequired("orderTif", orderTif),
                    checkRequired("orderTransactionHash", orderTransactionHash),
                    checkRequired("orderType", orderType),
                    checkRequired("paymentToken", paymentToken),
                    checkRequired("status", status),
                    checkRequired("stockId", stockId),
                    accountId,
                    assetToken,
                    assetTokenQuantity,
                    cancelTransactionHash,
                    clientOrderId,
                    entityId,
                    fee,
                    limitPrice,
                    orderRequestId,
                    paymentTokenQuantity,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws DinariInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            id()
            chainId()
            createdDt()
            orderContractAddress()
            orderSide().validate()
            orderTif().validate()
            orderTransactionHash()
            orderType().validate()
            paymentToken()
            status().validate()
            stockId()
            accountId()
            assetToken()
            assetTokenQuantity()
            cancelTransactionHash()
            clientOrderId()
            entityId()
            fee()
            limitPrice()
            orderRequestId()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (chainId.asKnown().isPresent) 1 else 0) +
                (if (createdDt.asKnown().isPresent) 1 else 0) +
                (if (orderContractAddress.asKnown().isPresent) 1 else 0) +
                (orderSide.asKnown().getOrNull()?.validity() ?: 0) +
                (orderTif.asKnown().getOrNull()?.validity() ?: 0) +
                (if (orderTransactionHash.asKnown().isPresent) 1 else 0) +
                (orderType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (paymentToken.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (stockId.asKnown().isPresent) 1 else 0) +
                (if (accountId.asKnown().isPresent) 1 else 0) +
                (if (assetToken.asKnown().isPresent) 1 else 0) +
                (if (assetTokenQuantity.asKnown().isPresent) 1 else 0) +
                (if (cancelTransactionHash.asKnown().isPresent) 1 else 0) +
                (if (clientOrderId.asKnown().isPresent) 1 else 0) +
                (if (entityId.asKnown().isPresent) 1 else 0) +
                (if (fee.asKnown().isPresent) 1 else 0) +
                (if (limitPrice.asKnown().isPresent) 1 else 0) +
                (if (orderRequestId.asKnown().isPresent) 1 else 0) +
                (if (paymentTokenQuantity.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                id == other.id &&
                chainId == other.chainId &&
                createdDt == other.createdDt &&
                orderContractAddress == other.orderContractAddress &&
                orderSide == other.orderSide &&
                orderTif == other.orderTif &&
                orderTransactionHash == other.orderTransactionHash &&
                orderType == other.orderType &&
                paymentToken == other.paymentToken &&
                status == other.status &&
                stockId == other.stockId &&
                accountId == other.accountId &&
                assetToken == other.assetToken &&
                assetTokenQuantity == other.assetTokenQuantity &&
                cancelTransactionHash == other.cancelTransactionHash &&
                clientOrderId == other.clientOrderId &&
                entityId == other.entityId &&
                fee == other.fee &&
                limitPrice == other.limitPrice &&
                orderRequestId == other.orderRequestId &&
                paymentTokenQuantity == other.paymentTokenQuantity &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                chainId,
                createdDt,
                orderContractAddress,
                orderSide,
                orderTif,
                orderTransactionHash,
                orderType,
                paymentToken,
                status,
                stockId,
                accountId,
                assetToken,
                assetTokenQuantity,
                cancelTransactionHash,
                clientOrderId,
                entityId,
                fee,
                limitPrice,
                orderRequestId,
                paymentTokenQuantity,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, chainId=$chainId, createdDt=$createdDt, orderContractAddress=$orderContractAddress, orderSide=$orderSide, orderTif=$orderTif, orderTransactionHash=$orderTransactionHash, orderType=$orderType, paymentToken=$paymentToken, status=$status, stockId=$stockId, accountId=$accountId, assetToken=$assetToken, assetTokenQuantity=$assetTokenQuantity, cancelTransactionHash=$cancelTransactionHash, clientOrderId=$clientOrderId, entityId=$entityId, fee=$fee, limitPrice=$limitPrice, orderRequestId=$orderRequestId, paymentTokenQuantity=$paymentTokenQuantity, additionalProperties=$additionalProperties}"
    }

    /** Version */
    class _Sv @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PAGINATED_ENTITY_ORDER_RESPONSE_V1 = of("PaginatedEntityOrderResponse:v1")

            @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
        }

        /** An enum containing [_Sv]'s known values. */
        enum class Known {
            PAGINATED_ENTITY_ORDER_RESPONSE_V1
        }

        /**
         * An enum containing [_Sv]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [_Sv] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PAGINATED_ENTITY_ORDER_RESPONSE_V1,
            /** An enum member indicating that [_Sv] was instantiated with an unknown value. */
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
                PAGINATED_ENTITY_ORDER_RESPONSE_V1 -> Value.PAGINATED_ENTITY_ORDER_RESPONSE_V1
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
                PAGINATED_ENTITY_ORDER_RESPONSE_V1 -> Known.PAGINATED_ENTITY_ORDER_RESPONSE_V1
                else -> throw DinariInvalidDataException("Unknown _Sv: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws DinariInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): _Sv = apply {
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

            return other is _Sv && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is V2ListOrdersResponse &&
            data == other.data &&
            paginationMetadata == other.paginationMetadata &&
            _sv == other._sv &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(data, paginationMetadata, _sv, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "V2ListOrdersResponse{data=$data, paginationMetadata=$paginationMetadata, _sv=$_sv, additionalProperties=$additionalProperties}"
}
