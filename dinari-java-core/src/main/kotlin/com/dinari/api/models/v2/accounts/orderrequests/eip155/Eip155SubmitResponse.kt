// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.errors.DinariInvalidDataException
import com.dinari.api.models.v2.accounts.orderrequests.OrderRequestStatus
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderTif
import com.dinari.api.models.v2.accounts.orders.OrderType
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A request to create an `Order`.
 *
 * An `EIP155OrderRequest` is created when a user places an order through the Dinari API. The
 * `EIP155OrderRequest` is then fulfilled by creating an `Order` on-chain.
 *
 * The `EIP155OrderRequest` is a record of the user's intent to place an order, while the `Order` is
 * the actual transaction that occurs on the blockchain.
 */
class Eip155SubmitResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val accountId: JsonField<String>,
    private val createdDt: JsonField<OffsetDateTime>,
    private val orderSide: JsonField<OrderSide>,
    private val orderTif: JsonField<OrderTif>,
    private val orderType: JsonField<OrderType>,
    private val status: JsonField<OrderRequestStatus>,
    private val cancelMessage: JsonField<String>,
    private val orderId: JsonField<String>,
    private val recipientAccountId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_dt")
        @ExcludeMissing
        createdDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("order_side")
        @ExcludeMissing
        orderSide: JsonField<OrderSide> = JsonMissing.of(),
        @JsonProperty("order_tif") @ExcludeMissing orderTif: JsonField<OrderTif> = JsonMissing.of(),
        @JsonProperty("order_type")
        @ExcludeMissing
        orderType: JsonField<OrderType> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<OrderRequestStatus> = JsonMissing.of(),
        @JsonProperty("cancel_message")
        @ExcludeMissing
        cancelMessage: JsonField<String> = JsonMissing.of(),
        @JsonProperty("order_id") @ExcludeMissing orderId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("recipient_account_id")
        @ExcludeMissing
        recipientAccountId: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        accountId,
        createdDt,
        orderSide,
        orderTif,
        orderType,
        status,
        cancelMessage,
        orderId,
        recipientAccountId,
        mutableMapOf(),
    )

    /**
     * ID of `EIP155OrderRequest`. This is the primary identifier for the `/order_requests` routes.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * ID of `Account` placing the `EIP155OrderRequest`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun accountId(): String = accountId.getRequired("account_id")

    /**
     * Datetime at which the `EIP155OrderRequest` was created. ISO 8601 timestamp.
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
     * Status of `EIP155OrderRequest`. Possible values:
     * - `QUOTED`: Order request created with fee quote provided, ready for processing
     * - `PENDING`: Order request is being prepared for submission
     * - `PENDING_BRIDGE`: Order is waiting for bridge transaction to complete
     * - `SUBMITTED`: Order has been successfully submitted to the order book
     * - `ERROR`: An error occurred during order processing
     * - `CANCELLED`: Order request was cancelled
     * - `EXPIRED`: Order request expired due to deadline passing
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): OrderRequestStatus = status.getRequired("status")

    /**
     * Reason for the order cancellation if the order status is CANCELLED
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cancelMessage(): Optional<String> = cancelMessage.getOptional("cancel_message")

    /**
     * ID of `Order` created from the `EIP155OrderRequest`. This is the primary identifier for the
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
    @JsonProperty("order_side") @ExcludeMissing fun _orderSide(): JsonField<OrderSide> = orderSide

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
    @JsonProperty("order_type") @ExcludeMissing fun _orderType(): JsonField<OrderType> = orderType

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<OrderRequestStatus> = status

    /**
     * Returns the raw JSON value of [cancelMessage].
     *
     * Unlike [cancelMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cancel_message")
    @ExcludeMissing
    fun _cancelMessage(): JsonField<String> = cancelMessage

    /**
     * Returns the raw JSON value of [orderId].
     *
     * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_id") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

    /**
     * Returns the raw JSON value of [recipientAccountId].
     *
     * Unlike [recipientAccountId], this method doesn't throw if the JSON field has an unexpected
     * type.
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
         * Returns a mutable builder for constructing an instance of [Eip155SubmitResponse].
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

    /** A builder for [Eip155SubmitResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var accountId: JsonField<String>? = null
        private var createdDt: JsonField<OffsetDateTime>? = null
        private var orderSide: JsonField<OrderSide>? = null
        private var orderTif: JsonField<OrderTif>? = null
        private var orderType: JsonField<OrderType>? = null
        private var status: JsonField<OrderRequestStatus>? = null
        private var cancelMessage: JsonField<String> = JsonMissing.of()
        private var orderId: JsonField<String> = JsonMissing.of()
        private var recipientAccountId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eip155SubmitResponse: Eip155SubmitResponse) = apply {
            id = eip155SubmitResponse.id
            accountId = eip155SubmitResponse.accountId
            createdDt = eip155SubmitResponse.createdDt
            orderSide = eip155SubmitResponse.orderSide
            orderTif = eip155SubmitResponse.orderTif
            orderType = eip155SubmitResponse.orderType
            status = eip155SubmitResponse.status
            cancelMessage = eip155SubmitResponse.cancelMessage
            orderId = eip155SubmitResponse.orderId
            recipientAccountId = eip155SubmitResponse.recipientAccountId
            additionalProperties = eip155SubmitResponse.additionalProperties.toMutableMap()
        }

        /**
         * ID of `EIP155OrderRequest`. This is the primary identifier for the `/order_requests`
         * routes.
         */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** ID of `Account` placing the `EIP155OrderRequest`. */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /**
         * Sets [Builder.accountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        /** Datetime at which the `EIP155OrderRequest` was created. ISO 8601 timestamp. */
        fun createdDt(createdDt: OffsetDateTime) = createdDt(JsonField.of(createdDt))

        /**
         * Sets [Builder.createdDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdDt(createdDt: JsonField<OffsetDateTime>) = apply { this.createdDt = createdDt }

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

        /** Indicates how long `Order` is valid for. */
        fun orderTif(orderTif: OrderTif) = orderTif(JsonField.of(orderTif))

        /**
         * Sets [Builder.orderTif] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderTif] with a well-typed [OrderTif] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun orderTif(orderTif: JsonField<OrderTif>) = apply { this.orderTif = orderTif }

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

        /**
         * Status of `EIP155OrderRequest`. Possible values:
         * - `QUOTED`: Order request created with fee quote provided, ready for processing
         * - `PENDING`: Order request is being prepared for submission
         * - `PENDING_BRIDGE`: Order is waiting for bridge transaction to complete
         * - `SUBMITTED`: Order has been successfully submitted to the order book
         * - `ERROR`: An error occurred during order processing
         * - `CANCELLED`: Order request was cancelled
         * - `EXPIRED`: Order request expired due to deadline passing
         */
        fun status(status: OrderRequestStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [OrderRequestStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<OrderRequestStatus>) = apply { this.status = status }

        /** Reason for the order cancellation if the order status is CANCELLED */
        fun cancelMessage(cancelMessage: String?) =
            cancelMessage(JsonField.ofNullable(cancelMessage))

        /** Alias for calling [Builder.cancelMessage] with `cancelMessage.orElse(null)`. */
        fun cancelMessage(cancelMessage: Optional<String>) =
            cancelMessage(cancelMessage.getOrNull())

        /**
         * Sets [Builder.cancelMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancelMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cancelMessage(cancelMessage: JsonField<String>) = apply {
            this.cancelMessage = cancelMessage
        }

        /**
         * ID of `Order` created from the `EIP155OrderRequest`. This is the primary identifier for
         * the `/orders` routes.
         */
        fun orderId(orderId: String?) = orderId(JsonField.ofNullable(orderId))

        /** Alias for calling [Builder.orderId] with `orderId.orElse(null)`. */
        fun orderId(orderId: Optional<String>) = orderId(orderId.getOrNull())

        /**
         * Sets [Builder.orderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

        /** ID of recipient `Account`. */
        fun recipientAccountId(recipientAccountId: String?) =
            recipientAccountId(JsonField.ofNullable(recipientAccountId))

        /**
         * Alias for calling [Builder.recipientAccountId] with `recipientAccountId.orElse(null)`.
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
         * Returns an immutable instance of [Eip155SubmitResponse].
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
        fun build(): Eip155SubmitResponse =
            Eip155SubmitResponse(
                checkRequired("id", id),
                checkRequired("accountId", accountId),
                checkRequired("createdDt", createdDt),
                checkRequired("orderSide", orderSide),
                checkRequired("orderTif", orderTif),
                checkRequired("orderType", orderType),
                checkRequired("status", status),
                cancelMessage,
                orderId,
                recipientAccountId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Eip155SubmitResponse = apply {
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
        orderId()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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
            (if (orderId.asKnown().isPresent) 1 else 0) +
            (if (recipientAccountId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Eip155SubmitResponse &&
            id == other.id &&
            accountId == other.accountId &&
            createdDt == other.createdDt &&
            orderSide == other.orderSide &&
            orderTif == other.orderTif &&
            orderType == other.orderType &&
            status == other.status &&
            cancelMessage == other.cancelMessage &&
            orderId == other.orderId &&
            recipientAccountId == other.recipientAccountId &&
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
            orderId,
            recipientAccountId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Eip155SubmitResponse{id=$id, accountId=$accountId, createdDt=$createdDt, orderSide=$orderSide, orderTif=$orderTif, orderType=$orderType, status=$status, cancelMessage=$cancelMessage, orderId=$orderId, recipientAccountId=$recipientAccountId, additionalProperties=$additionalProperties}"
}
