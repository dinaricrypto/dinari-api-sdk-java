// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.wallet.external

import com.dinari.api.core.Enum
import com.dinari.api.core.JsonField
import com.dinari.api.core.Params
import com.dinari.api.core.checkRequired
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Get a nonce and message to be signed in order to verify `Wallet` ownership. */
class ExternalGetNonceParams
private constructor(
    private val accountId: String?,
    private val chainId: ChainId,
    private val walletAddress: String,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    /**
     * CAIP-2 formatted chain ID of the blockchain the `Wallet` is on. eip155:0 is used for EOA
     * wallets
     */
    fun chainId(): ChainId = chainId

    /** Address of the `Wallet` to connect. */
    fun walletAddress(): String = walletAddress

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExternalGetNonceParams].
         *
         * The following fields are required:
         * ```java
         * .chainId()
         * .walletAddress()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExternalGetNonceParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var chainId: ChainId? = null
        private var walletAddress: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(externalGetNonceParams: ExternalGetNonceParams) = apply {
            accountId = externalGetNonceParams.accountId
            chainId = externalGetNonceParams.chainId
            walletAddress = externalGetNonceParams.walletAddress
            additionalHeaders = externalGetNonceParams.additionalHeaders.toBuilder()
            additionalQueryParams = externalGetNonceParams.additionalQueryParams.toBuilder()
        }

        fun accountId(accountId: String?) = apply { this.accountId = accountId }

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

        /**
         * CAIP-2 formatted chain ID of the blockchain the `Wallet` is on. eip155:0 is used for EOA
         * wallets
         */
        fun chainId(chainId: ChainId) = apply { this.chainId = chainId }

        /** Address of the `Wallet` to connect. */
        fun walletAddress(walletAddress: String) = apply { this.walletAddress = walletAddress }

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
         * Returns an immutable instance of [ExternalGetNonceParams].
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
        fun build(): ExternalGetNonceParams =
            ExternalGetNonceParams(
                accountId,
                checkRequired("chainId", chainId),
                checkRequired("walletAddress", walletAddress),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> accountId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("chain_id", chainId.toString())
                put("wallet_address", walletAddress)
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * CAIP-2 formatted chain ID of the blockchain the `Wallet` is on. eip155:0 is used for EOA
     * wallets
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

        return /* spotless:off */ other is ExternalGetNonceParams && accountId == other.accountId && chainId == other.chainId && walletAddress == other.walletAddress && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(accountId, chainId, walletAddress, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ExternalGetNonceParams{accountId=$accountId, chainId=$chainId, walletAddress=$walletAddress, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
