// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.Params
import com.dinari.api.core.checkRequired
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create a proxied order on EVM from a prepared proxied order. An `OrderRequest` representing the
 * proxied order is returned.
 */
class Eip155CreateProxiedOrderParams
private constructor(
    private val accountId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    /**
     * Signature of the order typed data, allowing Dinari to place the proxied order on behalf of
     * the `Wallet`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderSignature(): String = body.orderSignature()

    /**
     * Signature of the permit typed data, allowing Dinari to spend the payment token or dShare
     * asset token on behalf of the owner.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun permitSignature(): String = body.permitSignature()

    /**
     * ID of the prepared proxied order to be submitted as a proxied order.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun preparedProxiedOrderId(): String = body.preparedProxiedOrderId()

    /**
     * Returns the raw JSON value of [orderSignature].
     *
     * Unlike [orderSignature], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _orderSignature(): JsonField<String> = body._orderSignature()

    /**
     * Returns the raw JSON value of [permitSignature].
     *
     * Unlike [permitSignature], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _permitSignature(): JsonField<String> = body._permitSignature()

    /**
     * Returns the raw JSON value of [preparedProxiedOrderId].
     *
     * Unlike [preparedProxiedOrderId], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _preparedProxiedOrderId(): JsonField<String> = body._preparedProxiedOrderId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [Eip155CreateProxiedOrderParams].
         *
         * The following fields are required:
         * ```java
         * .orderSignature()
         * .permitSignature()
         * .preparedProxiedOrderId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155CreateProxiedOrderParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(eip155CreateProxiedOrderParams: Eip155CreateProxiedOrderParams) = apply {
            accountId = eip155CreateProxiedOrderParams.accountId
            body = eip155CreateProxiedOrderParams.body.toBuilder()
            additionalHeaders = eip155CreateProxiedOrderParams.additionalHeaders.toBuilder()
            additionalQueryParams = eip155CreateProxiedOrderParams.additionalQueryParams.toBuilder()
        }

        fun accountId(accountId: String?) = apply { this.accountId = accountId }

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [orderSignature]
         * - [permitSignature]
         * - [preparedProxiedOrderId]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Signature of the order typed data, allowing Dinari to place the proxied order on behalf
         * of the `Wallet`.
         */
        fun orderSignature(orderSignature: String) = apply { body.orderSignature(orderSignature) }

        /**
         * Sets [Builder.orderSignature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderSignature] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun orderSignature(orderSignature: JsonField<String>) = apply {
            body.orderSignature(orderSignature)
        }

        /**
         * Signature of the permit typed data, allowing Dinari to spend the payment token or dShare
         * asset token on behalf of the owner.
         */
        fun permitSignature(permitSignature: String) = apply {
            body.permitSignature(permitSignature)
        }

        /**
         * Sets [Builder.permitSignature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.permitSignature] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun permitSignature(permitSignature: JsonField<String>) = apply {
            body.permitSignature(permitSignature)
        }

        /** ID of the prepared proxied order to be submitted as a proxied order. */
        fun preparedProxiedOrderId(preparedProxiedOrderId: String) = apply {
            body.preparedProxiedOrderId(preparedProxiedOrderId)
        }

        /**
         * Sets [Builder.preparedProxiedOrderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.preparedProxiedOrderId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun preparedProxiedOrderId(preparedProxiedOrderId: JsonField<String>) = apply {
            body.preparedProxiedOrderId(preparedProxiedOrderId)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [Eip155CreateProxiedOrderParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .orderSignature()
         * .permitSignature()
         * .preparedProxiedOrderId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155CreateProxiedOrderParams =
            Eip155CreateProxiedOrderParams(
                accountId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> accountId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Input parameters for creating a proxied `OrderRequest` from a `EvmPreparedProxiedOrder`. */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val orderSignature: JsonField<String>,
        private val permitSignature: JsonField<String>,
        private val preparedProxiedOrderId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("order_signature")
            @ExcludeMissing
            orderSignature: JsonField<String> = JsonMissing.of(),
            @JsonProperty("permit_signature")
            @ExcludeMissing
            permitSignature: JsonField<String> = JsonMissing.of(),
            @JsonProperty("prepared_proxied_order_id")
            @ExcludeMissing
            preparedProxiedOrderId: JsonField<String> = JsonMissing.of(),
        ) : this(orderSignature, permitSignature, preparedProxiedOrderId, mutableMapOf())

        /**
         * Signature of the order typed data, allowing Dinari to place the proxied order on behalf
         * of the `Wallet`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderSignature(): String = orderSignature.getRequired("order_signature")

        /**
         * Signature of the permit typed data, allowing Dinari to spend the payment token or dShare
         * asset token on behalf of the owner.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun permitSignature(): String = permitSignature.getRequired("permit_signature")

        /**
         * ID of the prepared proxied order to be submitted as a proxied order.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun preparedProxiedOrderId(): String =
            preparedProxiedOrderId.getRequired("prepared_proxied_order_id")

        /**
         * Returns the raw JSON value of [orderSignature].
         *
         * Unlike [orderSignature], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("order_signature")
        @ExcludeMissing
        fun _orderSignature(): JsonField<String> = orderSignature

        /**
         * Returns the raw JSON value of [permitSignature].
         *
         * Unlike [permitSignature], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("permit_signature")
        @ExcludeMissing
        fun _permitSignature(): JsonField<String> = permitSignature

        /**
         * Returns the raw JSON value of [preparedProxiedOrderId].
         *
         * Unlike [preparedProxiedOrderId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("prepared_proxied_order_id")
        @ExcludeMissing
        fun _preparedProxiedOrderId(): JsonField<String> = preparedProxiedOrderId

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .orderSignature()
             * .permitSignature()
             * .preparedProxiedOrderId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var orderSignature: JsonField<String>? = null
            private var permitSignature: JsonField<String>? = null
            private var preparedProxiedOrderId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                orderSignature = body.orderSignature
                permitSignature = body.permitSignature
                preparedProxiedOrderId = body.preparedProxiedOrderId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Signature of the order typed data, allowing Dinari to place the proxied order on
             * behalf of the `Wallet`.
             */
            fun orderSignature(orderSignature: String) =
                orderSignature(JsonField.of(orderSignature))

            /**
             * Sets [Builder.orderSignature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderSignature] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderSignature(orderSignature: JsonField<String>) = apply {
                this.orderSignature = orderSignature
            }

            /**
             * Signature of the permit typed data, allowing Dinari to spend the payment token or
             * dShare asset token on behalf of the owner.
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

            /** ID of the prepared proxied order to be submitted as a proxied order. */
            fun preparedProxiedOrderId(preparedProxiedOrderId: String) =
                preparedProxiedOrderId(JsonField.of(preparedProxiedOrderId))

            /**
             * Sets [Builder.preparedProxiedOrderId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.preparedProxiedOrderId] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun preparedProxiedOrderId(preparedProxiedOrderId: JsonField<String>) = apply {
                this.preparedProxiedOrderId = preparedProxiedOrderId
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .orderSignature()
             * .permitSignature()
             * .preparedProxiedOrderId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("orderSignature", orderSignature),
                    checkRequired("permitSignature", permitSignature),
                    checkRequired("preparedProxiedOrderId", preparedProxiedOrderId),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            orderSignature()
            permitSignature()
            preparedProxiedOrderId()
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
            (if (orderSignature.asKnown().isPresent) 1 else 0) +
                (if (permitSignature.asKnown().isPresent) 1 else 0) +
                (if (preparedProxiedOrderId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                orderSignature == other.orderSignature &&
                permitSignature == other.permitSignature &&
                preparedProxiedOrderId == other.preparedProxiedOrderId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                orderSignature,
                permitSignature,
                preparedProxiedOrderId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{orderSignature=$orderSignature, permitSignature=$permitSignature, preparedProxiedOrderId=$preparedProxiedOrderId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Eip155CreateProxiedOrderParams &&
            accountId == other.accountId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(accountId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "Eip155CreateProxiedOrderParams{accountId=$accountId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
