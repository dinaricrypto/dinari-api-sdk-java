// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

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

/** A preview of the fee that would be collected when placing an Order Request. */
class OrderRequestGetFeeQuoteResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val fee: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("fee") @ExcludeMissing fee: JsonField<Double> = JsonMissing.of()
    ) : this(fee, mutableMapOf())

    /**
     * Cash amount in USD paid for fees for the Order Request.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fee(): Double = fee.getRequired("fee")

    /**
     * Returns the raw JSON value of [fee].
     *
     * Unlike [fee], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fee") @ExcludeMissing fun _fee(): JsonField<Double> = fee

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
         * [OrderRequestGetFeeQuoteResponse].
         *
         * The following fields are required:
         * ```java
         * .fee()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderRequestGetFeeQuoteResponse]. */
    class Builder internal constructor() {

        private var fee: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(orderRequestGetFeeQuoteResponse: OrderRequestGetFeeQuoteResponse) =
            apply {
                fee = orderRequestGetFeeQuoteResponse.fee
                additionalProperties =
                    orderRequestGetFeeQuoteResponse.additionalProperties.toMutableMap()
            }

        /** Cash amount in USD paid for fees for the Order Request. */
        fun fee(fee: Double) = fee(JsonField.of(fee))

        /**
         * Sets [Builder.fee] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fee] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fee(fee: JsonField<Double>) = apply { this.fee = fee }

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
         * Returns an immutable instance of [OrderRequestGetFeeQuoteResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .fee()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrderRequestGetFeeQuoteResponse =
            OrderRequestGetFeeQuoteResponse(
                checkRequired("fee", fee),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OrderRequestGetFeeQuoteResponse = apply {
        if (validated) {
            return@apply
        }

        fee()
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
    @JvmSynthetic internal fun validity(): Int = (if (fee.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrderRequestGetFeeQuoteResponse &&
            fee == other.fee &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(fee, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OrderRequestGetFeeQuoteResponse{fee=$fee, additionalProperties=$additionalProperties}"
}
