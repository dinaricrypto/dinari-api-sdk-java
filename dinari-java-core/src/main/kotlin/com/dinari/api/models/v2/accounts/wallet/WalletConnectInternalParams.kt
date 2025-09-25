// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.wallet

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.Params
import com.dinari.api.core.checkRequired
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import com.dinari.api.errors.DinariInvalidDataException
import com.dinari.api.models.v2.accounts.wallet.external.WalletChainId
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Connect an internal `Wallet` to the `Account`. */
class WalletConnectInternalParams
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
    fun chainId(): WalletChainId = body.chainId()

    /**
     * Address of the `Wallet`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun walletAddress(): String = body.walletAddress()

    /**
     * Is the linked Wallet shared or not
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isShared(): Optional<Boolean> = body.isShared()

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _chainId(): JsonField<WalletChainId> = body._chainId()

    /**
     * Returns the raw JSON value of [walletAddress].
     *
     * Unlike [walletAddress], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _walletAddress(): JsonField<String> = body._walletAddress()

    /**
     * Returns the raw JSON value of [isShared].
     *
     * Unlike [isShared], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _isShared(): JsonField<Boolean> = body._isShared()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WalletConnectInternalParams].
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .walletAddress()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WalletConnectInternalParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(walletConnectInternalParams: WalletConnectInternalParams) = apply {
            accountId = walletConnectInternalParams.accountId
            body = walletConnectInternalParams.body.toBuilder()
            additionalHeaders = walletConnectInternalParams.additionalHeaders.toBuilder()
            additionalQueryParams = walletConnectInternalParams.additionalQueryParams.toBuilder()
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
         * - [walletAddress]
         * - [isShared]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is used
         * for EOA wallets
         */
        fun chainId(chainId: WalletChainId) = apply { body.chainId(chainId) }

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [WalletChainId] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun chainId(chainId: JsonField<WalletChainId>) = apply { body.chainId(chainId) }

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

        /** Is the linked Wallet shared or not */
        fun isShared(isShared: Boolean) = apply { body.isShared(isShared) }

        /**
         * Sets [Builder.isShared] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isShared] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isShared(isShared: JsonField<Boolean>) = apply { body.isShared(isShared) }

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
         * Returns an immutable instance of [WalletConnectInternalParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .walletAddress()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WalletConnectInternalParams =
            WalletConnectInternalParams(
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val chainId: JsonField<WalletChainId>,
        private val walletAddress: JsonField<String>,
        private val isShared: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("chain_id")
            @ExcludeMissing
            chainId: JsonField<WalletChainId> = JsonMissing.of(),
            @JsonProperty("wallet_address")
            @ExcludeMissing
            walletAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_shared")
            @ExcludeMissing
            isShared: JsonField<Boolean> = JsonMissing.of(),
        ) : this(chainId, walletAddress, isShared, mutableMapOf())

        /**
         * CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is used
         * for EOA wallets
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun chainId(): WalletChainId = chainId.getRequired("chain_id")

        /**
         * Address of the `Wallet`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun walletAddress(): String = walletAddress.getRequired("wallet_address")

        /**
         * Is the linked Wallet shared or not
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun isShared(): Optional<Boolean> = isShared.getOptional("is_shared")

        /**
         * Returns the raw JSON value of [chainId].
         *
         * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<WalletChainId> = chainId

        /**
         * Returns the raw JSON value of [walletAddress].
         *
         * Unlike [walletAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("wallet_address")
        @ExcludeMissing
        fun _walletAddress(): JsonField<String> = walletAddress

        /**
         * Returns the raw JSON value of [isShared].
         *
         * Unlike [isShared], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_shared") @ExcludeMissing fun _isShared(): JsonField<Boolean> = isShared

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
             * .walletAddress()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var chainId: JsonField<WalletChainId>? = null
            private var walletAddress: JsonField<String>? = null
            private var isShared: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                chainId = body.chainId
                walletAddress = body.walletAddress
                isShared = body.isShared
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is
             * used for EOA wallets
             */
            fun chainId(chainId: WalletChainId) = chainId(JsonField.of(chainId))

            /**
             * Sets [Builder.chainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chainId] with a well-typed [WalletChainId] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun chainId(chainId: JsonField<WalletChainId>) = apply { this.chainId = chainId }

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

            /** Is the linked Wallet shared or not */
            fun isShared(isShared: Boolean) = isShared(JsonField.of(isShared))

            /**
             * Sets [Builder.isShared] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isShared] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isShared(isShared: JsonField<Boolean>) = apply { this.isShared = isShared }

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
             * .walletAddress()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("chainId", chainId),
                    checkRequired("walletAddress", walletAddress),
                    isShared,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            chainId().validate()
            walletAddress()
            isShared()
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
                (if (walletAddress.asKnown().isPresent) 1 else 0) +
                (if (isShared.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                chainId == other.chainId &&
                walletAddress == other.walletAddress &&
                isShared == other.isShared &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(chainId, walletAddress, isShared, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{chainId=$chainId, walletAddress=$walletAddress, isShared=$isShared, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WalletConnectInternalParams &&
            accountId == other.accountId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(accountId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "WalletConnectInternalParams{accountId=$accountId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
