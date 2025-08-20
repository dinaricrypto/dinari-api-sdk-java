// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.tokentransfers

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
 * Creates a `TokenTransfer` from this `Account`.
 *
 * A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one `Account`
 * to another. As such, only `Account`s that are connected to Dinari-managed `Wallet`s can initiate
 * `TokenTransfer`s.
 */
class TokenTransferCreateParams
private constructor(
    private val accountId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    /**
     * Quantity of the token to transfer.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun quantity(): Double = body.quantity()

    /**
     * ID of the recipient account to which the tokens will be transferred.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipientAccountId(): String = body.recipientAccountId()

    /**
     * Address of the token to transfer.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tokenAddress(): String = body.tokenAddress()

    /**
     * Returns the raw JSON value of [quantity].
     *
     * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _quantity(): JsonField<Double> = body._quantity()

    /**
     * Returns the raw JSON value of [recipientAccountId].
     *
     * Unlike [recipientAccountId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _recipientAccountId(): JsonField<String> = body._recipientAccountId()

    /**
     * Returns the raw JSON value of [tokenAddress].
     *
     * Unlike [tokenAddress], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tokenAddress(): JsonField<String> = body._tokenAddress()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TokenTransferCreateParams].
         *
         * The following fields are required:
         * ```java
         * .quantity()
         * .recipientAccountId()
         * .tokenAddress()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TokenTransferCreateParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(tokenTransferCreateParams: TokenTransferCreateParams) = apply {
            accountId = tokenTransferCreateParams.accountId
            body = tokenTransferCreateParams.body.toBuilder()
            additionalHeaders = tokenTransferCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = tokenTransferCreateParams.additionalQueryParams.toBuilder()
        }

        fun accountId(accountId: String?) = apply { this.accountId = accountId }

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [quantity]
         * - [recipientAccountId]
         * - [tokenAddress]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Quantity of the token to transfer. */
        fun quantity(quantity: Double) = apply { body.quantity(quantity) }

        /**
         * Sets [Builder.quantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quantity] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quantity(quantity: JsonField<Double>) = apply { body.quantity(quantity) }

        /** ID of the recipient account to which the tokens will be transferred. */
        fun recipientAccountId(recipientAccountId: String) = apply {
            body.recipientAccountId(recipientAccountId)
        }

        /**
         * Sets [Builder.recipientAccountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipientAccountId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recipientAccountId(recipientAccountId: JsonField<String>) = apply {
            body.recipientAccountId(recipientAccountId)
        }

        /** Address of the token to transfer. */
        fun tokenAddress(tokenAddress: String) = apply { body.tokenAddress(tokenAddress) }

        /**
         * Sets [Builder.tokenAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tokenAddress] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tokenAddress(tokenAddress: JsonField<String>) = apply {
            body.tokenAddress(tokenAddress)
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
         * Returns an immutable instance of [TokenTransferCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .quantity()
         * .recipientAccountId()
         * .tokenAddress()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TokenTransferCreateParams =
            TokenTransferCreateParams(
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

    /** Input parameters for creating a token transfer from a managed account. */
    class Body
    private constructor(
        private val quantity: JsonField<Double>,
        private val recipientAccountId: JsonField<String>,
        private val tokenAddress: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("quantity")
            @ExcludeMissing
            quantity: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("recipient_account_id")
            @ExcludeMissing
            recipientAccountId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("token_address")
            @ExcludeMissing
            tokenAddress: JsonField<String> = JsonMissing.of(),
        ) : this(quantity, recipientAccountId, tokenAddress, mutableMapOf())

        /**
         * Quantity of the token to transfer.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun quantity(): Double = quantity.getRequired("quantity")

        /**
         * ID of the recipient account to which the tokens will be transferred.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun recipientAccountId(): String = recipientAccountId.getRequired("recipient_account_id")

        /**
         * Address of the token to transfer.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun tokenAddress(): String = tokenAddress.getRequired("token_address")

        /**
         * Returns the raw JSON value of [quantity].
         *
         * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quantity") @ExcludeMissing fun _quantity(): JsonField<Double> = quantity

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
         * Returns the raw JSON value of [tokenAddress].
         *
         * Unlike [tokenAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("token_address")
        @ExcludeMissing
        fun _tokenAddress(): JsonField<String> = tokenAddress

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
             * .quantity()
             * .recipientAccountId()
             * .tokenAddress()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var quantity: JsonField<Double>? = null
            private var recipientAccountId: JsonField<String>? = null
            private var tokenAddress: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                quantity = body.quantity
                recipientAccountId = body.recipientAccountId
                tokenAddress = body.tokenAddress
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Quantity of the token to transfer. */
            fun quantity(quantity: Double) = quantity(JsonField.of(quantity))

            /**
             * Sets [Builder.quantity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quantity] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quantity(quantity: JsonField<Double>) = apply { this.quantity = quantity }

            /** ID of the recipient account to which the tokens will be transferred. */
            fun recipientAccountId(recipientAccountId: String) =
                recipientAccountId(JsonField.of(recipientAccountId))

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

            /** Address of the token to transfer. */
            fun tokenAddress(tokenAddress: String) = tokenAddress(JsonField.of(tokenAddress))

            /**
             * Sets [Builder.tokenAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tokenAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tokenAddress(tokenAddress: JsonField<String>) = apply {
                this.tokenAddress = tokenAddress
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
             * .quantity()
             * .recipientAccountId()
             * .tokenAddress()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("quantity", quantity),
                    checkRequired("recipientAccountId", recipientAccountId),
                    checkRequired("tokenAddress", tokenAddress),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            quantity()
            recipientAccountId()
            tokenAddress()
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
            (if (quantity.asKnown().isPresent) 1 else 0) +
                (if (recipientAccountId.asKnown().isPresent) 1 else 0) +
                (if (tokenAddress.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                quantity == other.quantity &&
                recipientAccountId == other.recipientAccountId &&
                tokenAddress == other.tokenAddress &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(quantity, recipientAccountId, tokenAddress, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{quantity=$quantity, recipientAccountId=$recipientAccountId, tokenAddress=$tokenAddress, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TokenTransferCreateParams &&
            accountId == other.accountId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(accountId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "TokenTransferCreateParams{accountId=$accountId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
