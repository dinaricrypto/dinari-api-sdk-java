// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class OrderRequestListResponse
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
     * List of AccountOrder
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
         * Returns a mutable builder for constructing an instance of [OrderRequestListResponse].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .paginationMetadata()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderRequestListResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<Data>>? = null
        private var paginationMetadata: JsonField<PaginationMetadata>? = null
        private var _sv: JsonField<_Sv> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(orderRequestListResponse: OrderRequestListResponse) = apply {
            data = orderRequestListResponse.data.map { it.toMutableList() }
            paginationMetadata = orderRequestListResponse.paginationMetadata
            _sv = orderRequestListResponse._sv
            additionalProperties = orderRequestListResponse.additionalProperties.toMutableMap()
        }

        /** List of AccountOrder */
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
         * Returns an immutable instance of [OrderRequestListResponse].
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
        fun build(): OrderRequestListResponse =
            OrderRequestListResponse(
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
    fun validate(): OrderRequestListResponse = apply {
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

    /**
     * A request to create an `Order`.
     *
     * An `OrderRequest` is created when a user places an order through the Dinari API. The
     * `OrderRequest` is then fulfilled by creating an `Order` on-chain.
     *
     * The `OrderRequest` is a record of the user's intent to place an order, while the `Order` is
     * the actual transaction that occurs on the blockchain.
     */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val accountId: JsonField<String>,
        private val createdDt: JsonField<OffsetDateTime>,
        private val orderSide: JsonField<OrderSide>,
        private val orderTif: JsonField<OrderTif>,
        private val orderType: JsonField<OrderType>,
        private val status: JsonField<Status>,
        private val cancelMessage: JsonField<String>,
        private val clientOrderId: JsonField<String>,
        private val orderId: JsonField<String>,
        private val recipientAccountId: JsonField<String>,
        private val rejectMessage: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("account_id")
            @ExcludeMissing
            accountId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("created_dt")
            @ExcludeMissing
            createdDt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("order_side")
            @ExcludeMissing
            orderSide: JsonField<OrderSide> = JsonMissing.of(),
            @JsonProperty("order_tif")
            @ExcludeMissing
            orderTif: JsonField<OrderTif> = JsonMissing.of(),
            @JsonProperty("order_type")
            @ExcludeMissing
            orderType: JsonField<OrderType> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("cancel_message")
            @ExcludeMissing
            cancelMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("client_order_id")
            @ExcludeMissing
            clientOrderId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("order_id") @ExcludeMissing orderId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("recipient_account_id")
            @ExcludeMissing
            recipientAccountId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reject_message")
            @ExcludeMissing
            rejectMessage: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            accountId,
            createdDt,
            orderSide,
            orderTif,
            orderType,
            status,
            cancelMessage,
            clientOrderId,
            orderId,
            recipientAccountId,
            rejectMessage,
            mutableMapOf(),
        )

        /**
         * ID of `OrderRequest`. This is the primary identifier for the `/order_requests` routes.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * ID of `Account` placing the `OrderRequest`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun accountId(): String = accountId.getRequired("account_id")

        /**
         * Datetime at which the `OrderRequest` was created. ISO 8601 timestamp.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun createdDt(): OffsetDateTime = createdDt.getRequired("created_dt")

        /**
         * Indicates whether `Order` is a buy or sell.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderSide(): OrderSide = orderSide.getRequired("order_side")

        /**
         * Indicates how long `Order` is valid for.
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
         * Status of `OrderRequest`. Possible values:
         * - `QUOTED`: Order request created with fee quote provided, ready for processing
         * - `PENDING`: Order request is being prepared for submission
         * - `PENDING_BRIDGE`: Order is waiting for bridge transaction to complete
         * - `SUBMITTED`: Order has been successfully submitted to the order book
         * - `ERROR`: An error occurred during order processing
         * - `CANCELLED`: Order request was cancelled
         * - `EXPIRED`: Order request expired due to deadline passing
         * - `REJECTED`: Order request was rejected
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * Reason for the order cancellation if the order status is CANCELLED
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cancelMessage(): Optional<String> = cancelMessage.getOptional("cancel_message")

        /**
         * Customer-supplied ID to map this `OrderRequest` to an order in their own systems.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun clientOrderId(): Optional<String> = clientOrderId.getOptional("client_order_id")

        /**
         * ID of `Order` created from the `OrderRequest`. This is the primary identifier for the
         * `/orders` routes.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun orderId(): Optional<String> = orderId.getOptional("order_id")

        /**
         * ID of recipient `Account`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recipientAccountId(): Optional<String> =
            recipientAccountId.getOptional("recipient_account_id")

        /**
         * Reason for the order rejection if the order status is REJECTED
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun rejectMessage(): Optional<String> = rejectMessage.getOptional("reject_message")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [accountId].
         *
         * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("account_id") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

        /**
         * Returns the raw JSON value of [createdDt].
         *
         * Unlike [createdDt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("created_dt")
        @ExcludeMissing
        fun _createdDt(): JsonField<OffsetDateTime> = createdDt

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
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [cancelMessage].
         *
         * Unlike [cancelMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cancel_message")
        @ExcludeMissing
        fun _cancelMessage(): JsonField<String> = cancelMessage

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
         * Returns the raw JSON value of [orderId].
         *
         * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("order_id") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

        /**
         * Returns the raw JSON value of [recipientAccountId].
         *
         * Unlike [recipientAccountId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("recipient_account_id")
        @ExcludeMissing
        fun _recipientAccountId(): JsonField<String> = recipientAccountId

        /**
         * Returns the raw JSON value of [rejectMessage].
         *
         * Unlike [rejectMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reject_message")
        @ExcludeMissing
        fun _rejectMessage(): JsonField<String> = rejectMessage

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
             * .accountId()
             * .createdDt()
             * .orderSide()
             * .orderTif()
             * .orderType()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var accountId: JsonField<String>? = null
            private var createdDt: JsonField<OffsetDateTime>? = null
            private var orderSide: JsonField<OrderSide>? = null
            private var orderTif: JsonField<OrderTif>? = null
            private var orderType: JsonField<OrderType>? = null
            private var status: JsonField<Status>? = null
            private var cancelMessage: JsonField<String> = JsonMissing.of()
            private var clientOrderId: JsonField<String> = JsonMissing.of()
            private var orderId: JsonField<String> = JsonMissing.of()
            private var recipientAccountId: JsonField<String> = JsonMissing.of()
            private var rejectMessage: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                accountId = data.accountId
                createdDt = data.createdDt
                orderSide = data.orderSide
                orderTif = data.orderTif
                orderType = data.orderType
                status = data.status
                cancelMessage = data.cancelMessage
                clientOrderId = data.clientOrderId
                orderId = data.orderId
                recipientAccountId = data.recipientAccountId
                rejectMessage = data.rejectMessage
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /**
             * ID of `OrderRequest`. This is the primary identifier for the `/order_requests`
             * routes.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** ID of `Account` placing the `OrderRequest`. */
            fun accountId(accountId: String) = accountId(JsonField.of(accountId))

            /**
             * Sets [Builder.accountId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accountId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

            /** Datetime at which the `OrderRequest` was created. ISO 8601 timestamp. */
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

            /** Indicates how long `Order` is valid for. */
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

            /**
             * Status of `OrderRequest`. Possible values:
             * - `QUOTED`: Order request created with fee quote provided, ready for processing
             * - `PENDING`: Order request is being prepared for submission
             * - `PENDING_BRIDGE`: Order is waiting for bridge transaction to complete
             * - `SUBMITTED`: Order has been successfully submitted to the order book
             * - `ERROR`: An error occurred during order processing
             * - `CANCELLED`: Order request was cancelled
             * - `EXPIRED`: Order request expired due to deadline passing
             * - `REJECTED`: Order request was rejected
             */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /** Reason for the order cancellation if the order status is CANCELLED */
            fun cancelMessage(cancelMessage: String?) =
                cancelMessage(JsonField.ofNullable(cancelMessage))

            /** Alias for calling [Builder.cancelMessage] with `cancelMessage.orElse(null)`. */
            fun cancelMessage(cancelMessage: Optional<String>) =
                cancelMessage(cancelMessage.getOrNull())

            /**
             * Sets [Builder.cancelMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cancelMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cancelMessage(cancelMessage: JsonField<String>) = apply {
                this.cancelMessage = cancelMessage
            }

            /** Customer-supplied ID to map this `OrderRequest` to an order in their own systems. */
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
             * ID of `Order` created from the `OrderRequest`. This is the primary identifier for the
             * `/orders` routes.
             */
            fun orderId(orderId: String?) = orderId(JsonField.ofNullable(orderId))

            /** Alias for calling [Builder.orderId] with `orderId.orElse(null)`. */
            fun orderId(orderId: Optional<String>) = orderId(orderId.getOrNull())

            /**
             * Sets [Builder.orderId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

            /** ID of recipient `Account`. */
            fun recipientAccountId(recipientAccountId: String?) =
                recipientAccountId(JsonField.ofNullable(recipientAccountId))

            /**
             * Alias for calling [Builder.recipientAccountId] with
             * `recipientAccountId.orElse(null)`.
             */
            fun recipientAccountId(recipientAccountId: Optional<String>) =
                recipientAccountId(recipientAccountId.getOrNull())

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

            /** Reason for the order rejection if the order status is REJECTED */
            fun rejectMessage(rejectMessage: String?) =
                rejectMessage(JsonField.ofNullable(rejectMessage))

            /** Alias for calling [Builder.rejectMessage] with `rejectMessage.orElse(null)`. */
            fun rejectMessage(rejectMessage: Optional<String>) =
                rejectMessage(rejectMessage.getOrNull())

            /**
             * Sets [Builder.rejectMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rejectMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rejectMessage(rejectMessage: JsonField<String>) = apply {
                this.rejectMessage = rejectMessage
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
             * .accountId()
             * .createdDt()
             * .orderSide()
             * .orderTif()
             * .orderType()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Data =
                Data(
                    checkRequired("id", id),
                    checkRequired("accountId", accountId),
                    checkRequired("createdDt", createdDt),
                    checkRequired("orderSide", orderSide),
                    checkRequired("orderTif", orderTif),
                    checkRequired("orderType", orderType),
                    checkRequired("status", status),
                    cancelMessage,
                    clientOrderId,
                    orderId,
                    recipientAccountId,
                    rejectMessage,
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
            accountId()
            createdDt()
            orderSide().validate()
            orderTif().validate()
            orderType().validate()
            status().validate()
            cancelMessage()
            clientOrderId()
            orderId()
            recipientAccountId()
            rejectMessage()
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
                (if (accountId.asKnown().isPresent) 1 else 0) +
                (if (createdDt.asKnown().isPresent) 1 else 0) +
                (orderSide.asKnown().getOrNull()?.validity() ?: 0) +
                (orderTif.asKnown().getOrNull()?.validity() ?: 0) +
                (orderType.asKnown().getOrNull()?.validity() ?: 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (cancelMessage.asKnown().isPresent) 1 else 0) +
                (if (clientOrderId.asKnown().isPresent) 1 else 0) +
                (if (orderId.asKnown().isPresent) 1 else 0) +
                (if (recipientAccountId.asKnown().isPresent) 1 else 0) +
                (if (rejectMessage.asKnown().isPresent) 1 else 0)

        /** Indicates whether `Order` is a buy or sell. */
        class OrderSide @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                BUY,
                SELL,
                /**
                 * An enum member indicating that [OrderSide] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
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
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws DinariInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    DinariInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws DinariInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

                return other is OrderSide && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Indicates how long `Order` is valid for. */
        class OrderTif @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                DAY,
                GTC,
                IOC,
                FOK,
                /**
                 * An enum member indicating that [OrderTif] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
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
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws DinariInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    DinariInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws DinariInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

                return other is OrderTif && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Type of `Order`. */
        class OrderType @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                MARKET,
                LIMIT,
                /**
                 * An enum member indicating that [OrderType] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
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
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws DinariInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    DinariInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws DinariInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

                return other is OrderType && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Status of `OrderRequest`. Possible values:
         * - `QUOTED`: Order request created with fee quote provided, ready for processing
         * - `PENDING`: Order request is being prepared for submission
         * - `PENDING_BRIDGE`: Order is waiting for bridge transaction to complete
         * - `SUBMITTED`: Order has been successfully submitted to the order book
         * - `ERROR`: An error occurred during order processing
         * - `CANCELLED`: Order request was cancelled
         * - `EXPIRED`: Order request expired due to deadline passing
         * - `REJECTED`: Order request was rejected
         */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val QUOTED = of("QUOTED")

                @JvmField val PENDING = of("PENDING")

                @JvmField val PENDING_BRIDGE = of("PENDING_BRIDGE")

                @JvmField val SUBMITTED = of("SUBMITTED")

                @JvmField val ERROR = of("ERROR")

                @JvmField val CANCELLED = of("CANCELLED")

                @JvmField val EXPIRED = of("EXPIRED")

                @JvmField val REJECTED = of("REJECTED")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                QUOTED,
                PENDING,
                PENDING_BRIDGE,
                SUBMITTED,
                ERROR,
                CANCELLED,
                EXPIRED,
                REJECTED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                QUOTED,
                PENDING,
                PENDING_BRIDGE,
                SUBMITTED,
                ERROR,
                CANCELLED,
                EXPIRED,
                REJECTED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    QUOTED -> Value.QUOTED
                    PENDING -> Value.PENDING
                    PENDING_BRIDGE -> Value.PENDING_BRIDGE
                    SUBMITTED -> Value.SUBMITTED
                    ERROR -> Value.ERROR
                    CANCELLED -> Value.CANCELLED
                    EXPIRED -> Value.EXPIRED
                    REJECTED -> Value.REJECTED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws DinariInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    QUOTED -> Known.QUOTED
                    PENDING -> Known.PENDING
                    PENDING_BRIDGE -> Known.PENDING_BRIDGE
                    SUBMITTED -> Known.SUBMITTED
                    ERROR -> Known.ERROR
                    CANCELLED -> Known.CANCELLED
                    EXPIRED -> Known.EXPIRED
                    REJECTED -> Known.REJECTED
                    else -> throw DinariInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws DinariInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    DinariInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws DinariInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                id == other.id &&
                accountId == other.accountId &&
                createdDt == other.createdDt &&
                orderSide == other.orderSide &&
                orderTif == other.orderTif &&
                orderType == other.orderType &&
                status == other.status &&
                cancelMessage == other.cancelMessage &&
                clientOrderId == other.clientOrderId &&
                orderId == other.orderId &&
                recipientAccountId == other.recipientAccountId &&
                rejectMessage == other.rejectMessage &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                accountId,
                createdDt,
                orderSide,
                orderTif,
                orderType,
                status,
                cancelMessage,
                clientOrderId,
                orderId,
                recipientAccountId,
                rejectMessage,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, accountId=$accountId, createdDt=$createdDt, orderSide=$orderSide, orderTif=$orderTif, orderType=$orderType, status=$status, cancelMessage=$cancelMessage, clientOrderId=$clientOrderId, orderId=$orderId, recipientAccountId=$recipientAccountId, rejectMessage=$rejectMessage, additionalProperties=$additionalProperties}"
    }

    /** Pagination metadata */
    class PaginationMetadata
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val next: JsonField<String>,
        private val previous: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("next") @ExcludeMissing next: JsonField<String> = JsonMissing.of(),
            @JsonProperty("previous") @ExcludeMissing previous: JsonField<String> = JsonMissing.of(),
        ) : this(next, previous, mutableMapOf())

        /**
         * Cursor for next page
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun next(): Optional<String> = next.getOptional("next")

        /**
         * Cursor for previous page
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun previous(): Optional<String> = previous.getOptional("previous")

        /**
         * Returns the raw JSON value of [next].
         *
         * Unlike [next], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("next") @ExcludeMissing fun _next(): JsonField<String> = next

        /**
         * Returns the raw JSON value of [previous].
         *
         * Unlike [previous], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("previous") @ExcludeMissing fun _previous(): JsonField<String> = previous

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

            /** Returns a mutable builder for constructing an instance of [PaginationMetadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PaginationMetadata]. */
        class Builder internal constructor() {

            private var next: JsonField<String> = JsonMissing.of()
            private var previous: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(paginationMetadata: PaginationMetadata) = apply {
                next = paginationMetadata.next
                previous = paginationMetadata.previous
                additionalProperties = paginationMetadata.additionalProperties.toMutableMap()
            }

            /** Cursor for next page */
            fun next(next: String) = next(JsonField.of(next))

            /**
             * Sets [Builder.next] to an arbitrary JSON value.
             *
             * You should usually call [Builder.next] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun next(next: JsonField<String>) = apply { this.next = next }

            /** Cursor for previous page */
            fun previous(previous: String) = previous(JsonField.of(previous))

            /**
             * Sets [Builder.previous] to an arbitrary JSON value.
             *
             * You should usually call [Builder.previous] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun previous(previous: JsonField<String>) = apply { this.previous = previous }

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
             * Returns an immutable instance of [PaginationMetadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): PaginationMetadata =
                PaginationMetadata(next, previous, additionalProperties.toMutableMap())
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
        fun validate(): PaginationMetadata = apply {
            if (validated) {
                return@apply
            }

            next()
            previous()
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
            (if (next.asKnown().isPresent) 1 else 0) + (if (previous.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PaginationMetadata &&
                next == other.next &&
                previous == other.previous &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(next, previous, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PaginationMetadata{next=$next, previous=$previous, additionalProperties=$additionalProperties}"
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

            @JvmField
            val PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1 =
                of("PaginatedAccountOrderRequestResponse:v1")

            @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
        }

        /** An enum containing [_Sv]'s known values. */
        enum class Known {
            PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1
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
            PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1,
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
                PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1 ->
                    Value.PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1
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
                PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1 ->
                    Known.PAGINATED_ACCOUNT_ORDER_REQUEST_RESPONSE_V1
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

        return other is OrderRequestListResponse &&
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
        "OrderRequestListResponse{data=$data, paginationMetadata=$paginationMetadata, _sv=$_sv, additionalProperties=$additionalProperties}"
}
