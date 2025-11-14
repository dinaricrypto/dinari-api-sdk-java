// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

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
import kotlin.jvm.optionals.getOrNull

class OrderBatchCancelResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val cancelQueuedOrders: JsonField<List<Order>>,
    private val failedToCancelOrders: JsonField<List<Order>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("cancel_queued_orders")
        @ExcludeMissing
        cancelQueuedOrders: JsonField<List<Order>> = JsonMissing.of(),
        @JsonProperty("failed_to_cancel_orders")
        @ExcludeMissing
        failedToCancelOrders: JsonField<List<Order>> = JsonMissing.of(),
    ) : this(cancelQueuedOrders, failedToCancelOrders, mutableMapOf())

    /**
     * Orders that were queued to cancel.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cancelQueuedOrders(): List<Order> = cancelQueuedOrders.getRequired("cancel_queued_orders")

    /**
     * Orders that could not be queued to cancel.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun failedToCancelOrders(): List<Order> =
        failedToCancelOrders.getRequired("failed_to_cancel_orders")

    /**
     * Returns the raw JSON value of [cancelQueuedOrders].
     *
     * Unlike [cancelQueuedOrders], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("cancel_queued_orders")
    @ExcludeMissing
    fun _cancelQueuedOrders(): JsonField<List<Order>> = cancelQueuedOrders

    /**
     * Returns the raw JSON value of [failedToCancelOrders].
     *
     * Unlike [failedToCancelOrders], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("failed_to_cancel_orders")
    @ExcludeMissing
    fun _failedToCancelOrders(): JsonField<List<Order>> = failedToCancelOrders

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
         * Returns a mutable builder for constructing an instance of [OrderBatchCancelResponse].
         *
         * The following fields are required:
         * ```java
         * .cancelQueuedOrders()
         * .failedToCancelOrders()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderBatchCancelResponse]. */
    class Builder internal constructor() {

        private var cancelQueuedOrders: JsonField<MutableList<Order>>? = null
        private var failedToCancelOrders: JsonField<MutableList<Order>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(orderBatchCancelResponse: OrderBatchCancelResponse) = apply {
            cancelQueuedOrders =
                orderBatchCancelResponse.cancelQueuedOrders.map { it.toMutableList() }
            failedToCancelOrders =
                orderBatchCancelResponse.failedToCancelOrders.map { it.toMutableList() }
            additionalProperties = orderBatchCancelResponse.additionalProperties.toMutableMap()
        }

        /** Orders that were queued to cancel. */
        fun cancelQueuedOrders(cancelQueuedOrders: List<Order>) =
            cancelQueuedOrders(JsonField.of(cancelQueuedOrders))

        /**
         * Sets [Builder.cancelQueuedOrders] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancelQueuedOrders] with a well-typed `List<Order>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun cancelQueuedOrders(cancelQueuedOrders: JsonField<List<Order>>) = apply {
            this.cancelQueuedOrders = cancelQueuedOrders.map { it.toMutableList() }
        }

        /**
         * Adds a single [Order] to [cancelQueuedOrders].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCancelQueuedOrder(cancelQueuedOrder: Order) = apply {
            cancelQueuedOrders =
                (cancelQueuedOrders ?: JsonField.of(mutableListOf())).also {
                    checkKnown("cancelQueuedOrders", it).add(cancelQueuedOrder)
                }
        }

        /** Orders that could not be queued to cancel. */
        fun failedToCancelOrders(failedToCancelOrders: List<Order>) =
            failedToCancelOrders(JsonField.of(failedToCancelOrders))

        /**
         * Sets [Builder.failedToCancelOrders] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failedToCancelOrders] with a well-typed `List<Order>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun failedToCancelOrders(failedToCancelOrders: JsonField<List<Order>>) = apply {
            this.failedToCancelOrders = failedToCancelOrders.map { it.toMutableList() }
        }

        /**
         * Adds a single [Order] to [failedToCancelOrders].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFailedToCancelOrder(failedToCancelOrder: Order) = apply {
            failedToCancelOrders =
                (failedToCancelOrders ?: JsonField.of(mutableListOf())).also {
                    checkKnown("failedToCancelOrders", it).add(failedToCancelOrder)
                }
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
         * Returns an immutable instance of [OrderBatchCancelResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .cancelQueuedOrders()
         * .failedToCancelOrders()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrderBatchCancelResponse =
            OrderBatchCancelResponse(
                checkRequired("cancelQueuedOrders", cancelQueuedOrders).map { it.toImmutable() },
                checkRequired("failedToCancelOrders", failedToCancelOrders).map {
                    it.toImmutable()
                },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OrderBatchCancelResponse = apply {
        if (validated) {
            return@apply
        }

        cancelQueuedOrders().forEach { it.validate() }
        failedToCancelOrders().forEach { it.validate() }
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
        (cancelQueuedOrders.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (failedToCancelOrders.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrderBatchCancelResponse &&
            cancelQueuedOrders == other.cancelQueuedOrders &&
            failedToCancelOrders == other.failedToCancelOrders &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(cancelQueuedOrders, failedToCancelOrders, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OrderBatchCancelResponse{cancelQueuedOrders=$cancelQueuedOrders, failedToCancelOrders=$failedToCancelOrders, additionalProperties=$additionalProperties}"
}
