// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.wallet.external

import com.dinari.api.core.Enum
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

/** Connect a `Wallet` to the `Account` after verifying the signature. */
class ExternalConnectParams
private constructor(
    private val accountId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    /**
     * CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is used for
     * EOA wallets
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): ChainId = body.chainId()

    /**
     * Nonce contained within the connection message.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun nonce(): String = body.nonce()

    /**
     * Signature payload from signing the connection message with the `Wallet`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun signature(): String = body.signature()

    /**
     * Address of the `Wallet`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun walletAddress(): String = body.walletAddress()

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _chainId(): JsonField<ChainId> = body._chainId()

    /**
     * Returns the raw JSON value of [nonce].
     *
     * Unlike [nonce], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _nonce(): JsonField<String> = body._nonce()

    /**
     * Returns the raw JSON value of [signature].
     *
     * Unlike [signature], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _signature(): JsonField<String> = body._signature()

    /**
     * Returns the raw JSON value of [walletAddress].
     *
     * Unlike [walletAddress], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _walletAddress(): JsonField<String> = body._walletAddress()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExternalConnectParams].
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .nonce()
         * .signature()
         * .walletAddress()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExternalConnectParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(externalConnectParams: ExternalConnectParams) = apply {
            accountId = externalConnectParams.accountId
            body = externalConnectParams.body.toBuilder()
            additionalHeaders = externalConnectParams.additionalHeaders.toBuilder()
            additionalQueryParams = externalConnectParams.additionalQueryParams.toBuilder()
        }

        fun accountId(accountId: String?) = apply { this.accountId = accountId }

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [chainId]
         * - [nonce]
         * - [signature]
         * - [walletAddress]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is used
         * for EOA wallets
         */
        fun chainId(chainId: ChainId) = apply { body.chainId(chainId) }

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [ChainId] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<ChainId>) = apply { body.chainId(chainId) }

        /** Nonce contained within the connection message. */
        fun nonce(nonce: String) = apply { body.nonce(nonce) }

        /**
         * Sets [Builder.nonce] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nonce] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun nonce(nonce: JsonField<String>) = apply { body.nonce(nonce) }

        /** Signature payload from signing the connection message with the `Wallet`. */
        fun signature(signature: String) = apply { body.signature(signature) }

        /**
         * Sets [Builder.signature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.signature] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun signature(signature: JsonField<String>) = apply { body.signature(signature) }

        /** Address of the `Wallet`. */
        fun walletAddress(walletAddress: String) = apply { body.walletAddress(walletAddress) }

        /**
         * Sets [Builder.walletAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.walletAddress] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun walletAddress(walletAddress: JsonField<String>) = apply {
            body.walletAddress(walletAddress)
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
         * Returns an immutable instance of [ExternalConnectParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .nonce()
         * .signature()
         * .walletAddress()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExternalConnectParams =
            ExternalConnectParams(
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

    /** Input parameters for connecting an `Account` to a `Wallet` owned by the `Entity`. */
    class Body
    private constructor(
        private val chainId: JsonField<ChainId>,
        private val nonce: JsonField<String>,
        private val signature: JsonField<String>,
        private val walletAddress: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("chain_id")
            @ExcludeMissing
            chainId: JsonField<ChainId> = JsonMissing.of(),
            @JsonProperty("nonce") @ExcludeMissing nonce: JsonField<String> = JsonMissing.of(),
            @JsonProperty("signature")
            @ExcludeMissing
            signature: JsonField<String> = JsonMissing.of(),
            @JsonProperty("wallet_address")
            @ExcludeMissing
            walletAddress: JsonField<String> = JsonMissing.of(),
        ) : this(chainId, nonce, signature, walletAddress, mutableMapOf())

        /**
         * CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is used
         * for EOA wallets
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun chainId(): ChainId = chainId.getRequired("chain_id")

        /**
         * Nonce contained within the connection message.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun nonce(): String = nonce.getRequired("nonce")

        /**
         * Signature payload from signing the connection message with the `Wallet`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun signature(): String = signature.getRequired("signature")

        /**
         * Address of the `Wallet`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun walletAddress(): String = walletAddress.getRequired("wallet_address")

        /**
         * Returns the raw JSON value of [chainId].
         *
         * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<ChainId> = chainId

        /**
         * Returns the raw JSON value of [nonce].
         *
         * Unlike [nonce], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("nonce") @ExcludeMissing fun _nonce(): JsonField<String> = nonce

        /**
         * Returns the raw JSON value of [signature].
         *
         * Unlike [signature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("signature") @ExcludeMissing fun _signature(): JsonField<String> = signature

        /**
         * Returns the raw JSON value of [walletAddress].
         *
         * Unlike [walletAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("wallet_address")
        @ExcludeMissing
        fun _walletAddress(): JsonField<String> = walletAddress

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
             * .chainId()
             * .nonce()
             * .signature()
             * .walletAddress()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var chainId: JsonField<ChainId>? = null
            private var nonce: JsonField<String>? = null
            private var signature: JsonField<String>? = null
            private var walletAddress: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                chainId = body.chainId
                nonce = body.nonce
                signature = body.signature
                walletAddress = body.walletAddress
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is
             * used for EOA wallets
             */
            fun chainId(chainId: ChainId) = chainId(JsonField.of(chainId))

            /**
             * Sets [Builder.chainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chainId] with a well-typed [ChainId] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun chainId(chainId: JsonField<ChainId>) = apply { this.chainId = chainId }

            /** Nonce contained within the connection message. */
            fun nonce(nonce: String) = nonce(JsonField.of(nonce))

            /**
             * Sets [Builder.nonce] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nonce] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun nonce(nonce: JsonField<String>) = apply { this.nonce = nonce }

            /** Signature payload from signing the connection message with the `Wallet`. */
            fun signature(signature: String) = signature(JsonField.of(signature))

            /**
             * Sets [Builder.signature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.signature] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun signature(signature: JsonField<String>) = apply { this.signature = signature }

            /** Address of the `Wallet`. */
            fun walletAddress(walletAddress: String) = walletAddress(JsonField.of(walletAddress))

            /**
             * Sets [Builder.walletAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.walletAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun walletAddress(walletAddress: JsonField<String>) = apply {
                this.walletAddress = walletAddress
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
             * .chainId()
             * .nonce()
             * .signature()
             * .walletAddress()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("chainId", chainId),
                    checkRequired("nonce", nonce),
                    checkRequired("signature", signature),
                    checkRequired("walletAddress", walletAddress),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            chainId().validate()
            nonce()
            signature()
            walletAddress()
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
            (chainId.asKnown().getOrNull()?.validity() ?: 0) +
                (if (nonce.asKnown().isPresent) 1 else 0) +
                (if (signature.asKnown().isPresent) 1 else 0) +
                (if (walletAddress.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && chainId == other.chainId && nonce == other.nonce && signature == other.signature && walletAddress == other.walletAddress && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(chainId, nonce, signature, walletAddress, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{chainId=$chainId, nonce=$nonce, signature=$signature, walletAddress=$walletAddress, additionalProperties=$additionalProperties}"
    }

    /**
     * CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is used for
     * EOA wallets
     */
    class ChainId @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val EIP155_1 = of("eip155:1")

            @JvmField val EIP155_42161 = of("eip155:42161")

            @JvmField val EIP155_8453 = of("eip155:8453")

            @JvmField val EIP155_81457 = of("eip155:81457")

            @JvmField val EIP155_7887 = of("eip155:7887")

            @JvmField val EIP155_98866 = of("eip155:98866")

            @JvmField val EIP155_0 = of("eip155:0")

            @JvmStatic fun of(value: String) = ChainId(JsonField.of(value))
        }

        /** An enum containing [ChainId]'s known values. */
        enum class Known {
            EIP155_1,
            EIP155_42161,
            EIP155_8453,
            EIP155_81457,
            EIP155_7887,
            EIP155_98866,
            EIP155_0,
        }

        /**
         * An enum containing [ChainId]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ChainId] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            EIP155_1,
            EIP155_42161,
            EIP155_8453,
            EIP155_81457,
            EIP155_7887,
            EIP155_98866,
            EIP155_0,
            /** An enum member indicating that [ChainId] was instantiated with an unknown value. */
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
                EIP155_1 -> Value.EIP155_1
                EIP155_42161 -> Value.EIP155_42161
                EIP155_8453 -> Value.EIP155_8453
                EIP155_81457 -> Value.EIP155_81457
                EIP155_7887 -> Value.EIP155_7887
                EIP155_98866 -> Value.EIP155_98866
                EIP155_0 -> Value.EIP155_0
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
                EIP155_1 -> Known.EIP155_1
                EIP155_42161 -> Known.EIP155_42161
                EIP155_8453 -> Known.EIP155_8453
                EIP155_81457 -> Known.EIP155_81457
                EIP155_7887 -> Known.EIP155_7887
                EIP155_98866 -> Known.EIP155_98866
                EIP155_0 -> Known.EIP155_0
                else -> throw DinariInvalidDataException("Unknown ChainId: $value")
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

        fun validate(): ChainId = apply {
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

            return /* spotless:off */ other is ChainId && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ExternalConnectParams && accountId == other.accountId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(accountId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ExternalConnectParams{accountId=$accountId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
