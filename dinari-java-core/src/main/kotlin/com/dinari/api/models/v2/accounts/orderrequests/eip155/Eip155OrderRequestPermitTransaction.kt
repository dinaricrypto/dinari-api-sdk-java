// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects

/** Input parameters for creating a proxied `EIP155OrderRequestPermitTransaction`. */
class Eip155OrderRequestPermitTransaction
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val orderRequestId: JsonField<String>,
    private val permitSignature: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("order_request_id")
        @ExcludeMissing
        orderRequestId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("permit_signature")
        @ExcludeMissing
        permitSignature: JsonField<String> = JsonMissing.of(),
    ) : this(orderRequestId, permitSignature, mutableMapOf())

    /**
     * ID of the prepared proxied order to be submitted as a proxied order.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderRequestId(): String = orderRequestId.getRequired("order_request_id")

    /**
     * Signature of the permit typed data, allowing Dinari to spend the payment token or dShare
     * asset token on behalf of the owner.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun permitSignature(): String = permitSignature.getRequired("permit_signature")

    /**
     * Returns the raw JSON value of [orderRequestId].
     *
     * Unlike [orderRequestId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_request_id")
    @ExcludeMissing
    fun _orderRequestId(): JsonField<String> = orderRequestId

    /**
     * Returns the raw JSON value of [permitSignature].
     *
     * Unlike [permitSignature], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("permit_signature")
    @ExcludeMissing
    fun _permitSignature(): JsonField<String> = permitSignature

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
         * [Eip155OrderRequestPermitTransaction].
         *
         * The following fields are required:
         * ```java
         * .orderRequestId()
         * .permitSignature()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155OrderRequestPermitTransaction]. */
    class Builder internal constructor() {

        private var orderRequestId: JsonField<String>? = null
        private var permitSignature: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            eip155OrderRequestPermitTransaction: Eip155OrderRequestPermitTransaction
        ) = apply {
            orderRequestId = eip155OrderRequestPermitTransaction.orderRequestId
            permitSignature = eip155OrderRequestPermitTransaction.permitSignature
            additionalProperties =
                eip155OrderRequestPermitTransaction.additionalProperties.toMutableMap()
        }

        /** ID of the prepared proxied order to be submitted as a proxied order. */
        fun orderRequestId(orderRequestId: String) = orderRequestId(JsonField.of(orderRequestId))

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

        /**
         * Signature of the permit typed data, allowing Dinari to spend the payment token or dShare
         * asset token on behalf of the owner.
         */
        fun permitSignature(permitSignature: String) =
            permitSignature(JsonField.of(permitSignature))

        /**
         * Sets [Builder.permitSignature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.permitSignature] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun permitSignature(permitSignature: JsonField<String>) = apply {
            this.permitSignature = permitSignature
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
         * Returns an immutable instance of [Eip155OrderRequestPermitTransaction].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .orderRequestId()
         * .permitSignature()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155OrderRequestPermitTransaction =
            Eip155OrderRequestPermitTransaction(
                checkRequired("orderRequestId", orderRequestId),
                checkRequired("permitSignature", permitSignature),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Eip155OrderRequestPermitTransaction = apply {
        if (validated) {
            return@apply
        }

        orderRequestId()
        permitSignature()
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
        (if (orderRequestId.asKnown().isPresent) 1 else 0) +
            (if (permitSignature.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Eip155OrderRequestPermitTransaction &&
            orderRequestId == other.orderRequestId &&
            permitSignature == other.permitSignature &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(orderRequestId, permitSignature, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Eip155OrderRequestPermitTransaction{orderRequestId=$orderRequestId, permitSignature=$permitSignature, additionalProperties=$additionalProperties}"
}
