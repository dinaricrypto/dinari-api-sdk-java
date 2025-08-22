// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkKnown
import com.dinari.api.core.checkRequired
import com.dinari.api.core.toImmutable
import com.dinari.api.errors.DinariInvalidDataException
import com.dinari.api.models.v2.accounts.orders.stocks.eip155.OrderFeeAmount
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Prepared data for creating an `OrderRequest` through the EVM proxied order API route. */
class Eip155PrepareProxiedOrderResponse
private constructor(
    private val id: JsonField<String>,
    private val deadline: JsonField<OffsetDateTime>,
    private val fees: JsonField<List<OrderFeeAmount>>,
    private val orderTypedData: JsonField<EvmTypedData>,
    private val permitTypedData: JsonField<EvmTypedData>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("deadline")
        @ExcludeMissing
        deadline: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("fees")
        @ExcludeMissing
        fees: JsonField<List<OrderFeeAmount>> = JsonMissing.of(),
        @JsonProperty("order_typed_data")
        @ExcludeMissing
        orderTypedData: JsonField<EvmTypedData> = JsonMissing.of(),
        @JsonProperty("permit_typed_data")
        @ExcludeMissing
        permitTypedData: JsonField<EvmTypedData> = JsonMissing.of(),
    ) : this(id, deadline, fees, orderTypedData, permitTypedData, mutableMapOf())

    /**
     * ID of the EvmPreparedProxiedOrder.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Deadline for the prepared order to be placed.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun deadline(): OffsetDateTime = deadline.getRequired("deadline")

    /**
     * Fees involved in the order. Provided here as a reference.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fees(): List<OrderFeeAmount> = fees.getRequired("fees")

    /**
     * [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderTypedData(): EvmTypedData = orderTypedData.getRequired("order_typed_data")

    /**
     * [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun permitTypedData(): EvmTypedData = permitTypedData.getRequired("permit_typed_data")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [deadline].
     *
     * Unlike [deadline], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deadline") @ExcludeMissing fun _deadline(): JsonField<OffsetDateTime> = deadline

    /**
     * Returns the raw JSON value of [fees].
     *
     * Unlike [fees], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fees") @ExcludeMissing fun _fees(): JsonField<List<OrderFeeAmount>> = fees

    /**
     * Returns the raw JSON value of [orderTypedData].
     *
     * Unlike [orderTypedData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_typed_data")
    @ExcludeMissing
    fun _orderTypedData(): JsonField<EvmTypedData> = orderTypedData

    /**
     * Returns the raw JSON value of [permitTypedData].
     *
     * Unlike [permitTypedData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("permit_typed_data")
    @ExcludeMissing
    fun _permitTypedData(): JsonField<EvmTypedData> = permitTypedData

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
         * [Eip155PrepareProxiedOrderResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .deadline()
         * .fees()
         * .orderTypedData()
         * .permitTypedData()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155PrepareProxiedOrderResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var deadline: JsonField<OffsetDateTime>? = null
        private var fees: JsonField<MutableList<OrderFeeAmount>>? = null
        private var orderTypedData: JsonField<EvmTypedData>? = null
        private var permitTypedData: JsonField<EvmTypedData>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eip155PrepareProxiedOrderResponse: Eip155PrepareProxiedOrderResponse) =
            apply {
                id = eip155PrepareProxiedOrderResponse.id
                deadline = eip155PrepareProxiedOrderResponse.deadline
                fees = eip155PrepareProxiedOrderResponse.fees.map { it.toMutableList() }
                orderTypedData = eip155PrepareProxiedOrderResponse.orderTypedData
                permitTypedData = eip155PrepareProxiedOrderResponse.permitTypedData
                additionalProperties =
                    eip155PrepareProxiedOrderResponse.additionalProperties.toMutableMap()
            }

        /** ID of the EvmPreparedProxiedOrder. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Deadline for the prepared order to be placed. */
        fun deadline(deadline: OffsetDateTime) = deadline(JsonField.of(deadline))

        /**
         * Sets [Builder.deadline] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deadline] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deadline(deadline: JsonField<OffsetDateTime>) = apply { this.deadline = deadline }

        /** Fees involved in the order. Provided here as a reference. */
        fun fees(fees: List<OrderFeeAmount>) = fees(JsonField.of(fees))

        /**
         * Sets [Builder.fees] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fees] with a well-typed `List<OrderFeeAmount>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fees(fees: JsonField<List<OrderFeeAmount>>) = apply {
            this.fees = fees.map { it.toMutableList() }
        }

        /**
         * Adds a single [OrderFeeAmount] to [fees].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFee(fee: OrderFeeAmount) = apply {
            fees = (fees ?: JsonField.of(mutableListOf())).also { checkKnown("fees", it).add(fee) }
        }

        /**
         * [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet.
         */
        fun orderTypedData(orderTypedData: EvmTypedData) =
            orderTypedData(JsonField.of(orderTypedData))

        /**
         * Sets [Builder.orderTypedData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderTypedData] with a well-typed [EvmTypedData] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun orderTypedData(orderTypedData: JsonField<EvmTypedData>) = apply {
            this.orderTypedData = orderTypedData
        }

        /**
         * [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet.
         */
        fun permitTypedData(permitTypedData: EvmTypedData) =
            permitTypedData(JsonField.of(permitTypedData))

        /**
         * Sets [Builder.permitTypedData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.permitTypedData] with a well-typed [EvmTypedData] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun permitTypedData(permitTypedData: JsonField<EvmTypedData>) = apply {
            this.permitTypedData = permitTypedData
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
         * Returns an immutable instance of [Eip155PrepareProxiedOrderResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .deadline()
         * .fees()
         * .orderTypedData()
         * .permitTypedData()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155PrepareProxiedOrderResponse =
            Eip155PrepareProxiedOrderResponse(
                checkRequired("id", id),
                checkRequired("deadline", deadline),
                checkRequired("fees", fees).map { it.toImmutable() },
                checkRequired("orderTypedData", orderTypedData),
                checkRequired("permitTypedData", permitTypedData),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Eip155PrepareProxiedOrderResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        deadline()
        fees().forEach { it.validate() }
        orderTypedData().validate()
        permitTypedData().validate()
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
            (if (deadline.asKnown().isPresent) 1 else 0) +
            (fees.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (orderTypedData.asKnown().getOrNull()?.validity() ?: 0) +
            (permitTypedData.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Eip155PrepareProxiedOrderResponse &&
            id == other.id &&
            deadline == other.deadline &&
            fees == other.fees &&
            orderTypedData == other.orderTypedData &&
            permitTypedData == other.permitTypedData &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, deadline, fees, orderTypedData, permitTypedData, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Eip155PrepareProxiedOrderResponse{id=$id, deadline=$deadline, fees=$fees, orderTypedData=$orderTypedData, permitTypedData=$permitTypedData, additionalProperties=$additionalProperties}"
}
