// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
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

/** Token permit to be signed by the smart contract submitter. */
class Eip155CreatePermitResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val orderRequestId: JsonField<String>,
    private val permit: JsonField<Permit>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("order_request_id")
        @ExcludeMissing
        orderRequestId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("permit") @ExcludeMissing permit: JsonField<Permit> = JsonMissing.of(),
    ) : this(orderRequestId, permit, mutableMapOf())

    /**
     * ID representing the EIP155 `OrderRequest`
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderRequestId(): String = orderRequestId.getRequired("order_request_id")

    /**
     * Token permit that is to be signed by smart contract submitter for authorizing token transfer
     * for the `OrderRequest`
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun permit(): Permit = permit.getRequired("permit")

    /**
     * Returns the raw JSON value of [orderRequestId].
     *
     * Unlike [orderRequestId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_request_id")
    @ExcludeMissing
    fun _orderRequestId(): JsonField<String> = orderRequestId

    /**
     * Returns the raw JSON value of [permit].
     *
     * Unlike [permit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("permit") @ExcludeMissing fun _permit(): JsonField<Permit> = permit

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
         * Returns a mutable builder for constructing an instance of [Eip155CreatePermitResponse].
         *
         * The following fields are required:
         * ```java
         * .orderRequestId()
         * .permit()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155CreatePermitResponse]. */
    class Builder internal constructor() {

        private var orderRequestId: JsonField<String>? = null
        private var permit: JsonField<Permit>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eip155CreatePermitResponse: Eip155CreatePermitResponse) = apply {
            orderRequestId = eip155CreatePermitResponse.orderRequestId
            permit = eip155CreatePermitResponse.permit
            additionalProperties = eip155CreatePermitResponse.additionalProperties.toMutableMap()
        }

        /** ID representing the EIP155 `OrderRequest` */
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
         * Token permit that is to be signed by smart contract submitter for authorizing token
         * transfer for the `OrderRequest`
         */
        fun permit(permit: Permit) = permit(JsonField.of(permit))

        /**
         * Sets [Builder.permit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.permit] with a well-typed [Permit] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun permit(permit: JsonField<Permit>) = apply { this.permit = permit }

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
         * Returns an immutable instance of [Eip155CreatePermitResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .orderRequestId()
         * .permit()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155CreatePermitResponse =
            Eip155CreatePermitResponse(
                checkRequired("orderRequestId", orderRequestId),
                checkRequired("permit", permit),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Eip155CreatePermitResponse = apply {
        if (validated) {
            return@apply
        }

        orderRequestId()
        permit().validate()
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
            (permit.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Token permit that is to be signed by smart contract submitter for authorizing token transfer
     * for the `OrderRequest`
     */
    class Permit
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

            /** Returns a mutable builder for constructing an instance of [Permit]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Permit]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(permit: Permit) = apply {
                additionalProperties = permit.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Permit].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Permit = Permit(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Permit = apply {
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

            return other is Permit && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Permit{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Eip155CreatePermitResponse &&
            orderRequestId == other.orderRequestId &&
            permit == other.permit &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(orderRequestId, permit, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Eip155CreatePermitResponse{orderRequestId=$orderRequestId, permit=$permit, additionalProperties=$additionalProperties}"
}
