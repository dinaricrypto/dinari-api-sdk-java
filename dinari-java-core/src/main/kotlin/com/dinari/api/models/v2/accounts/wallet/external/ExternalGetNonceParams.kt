// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.wallet.external

import com.dinari.api.core.Params
import com.dinari.api.core.checkRequired
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Get a nonce and message to be signed in order to verify `Wallet` ownership. */
class ExternalGetNonceParams
private constructor(
    private val accountId: String?,
    private val chainId: WalletChainId,
    private val walletAddress: String,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    /**
     * CAIP-2 formatted chain ID of the blockchain the `Wallet` is on. eip155:0 is used for EOA
     * wallets
     */
    fun chainId(): WalletChainId = chainId

    /** Address of the `Wallet` to connect. */
    fun walletAddress(): String = walletAddress

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
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
        private var chainId: WalletChainId? = null
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
        fun chainId(chainId: WalletChainId) = apply { this.chainId = chainId }

        /** Address of the `Wallet` to connect. */
        fun walletAddress(walletAddress: String) = apply { this.walletAddress = walletAddress }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAlladditional_headers(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAlladditional_headers(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putadditional_headers(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAlladditional_headers(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAlladditional_headers(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceadditional_headers(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceadditional_headers(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAlladditional_headers(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAlladditional_headers(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeadditional_headers(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAlladditional_headers(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAlladditional_query_params(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAlladditional_query_params(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putadditional_query_params(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAlladditional_query_params(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAlladditional_query_params(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceadditional_query_params(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceadditional_query_params(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAlladditional_query_params(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAlladditional_query_params(
            additionalQueryParams: Map<String, Iterable<String>>
        ) = apply { this.additionalQueryParams.replaceAll(additionalQueryParams) }

        fun removeadditional_query_params(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAlladditional_query_params(keys: Set<String>) = apply {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExternalGetNonceParams &&
            accountId == other.accountId &&
            chainId == other.chainId &&
            walletAddress == other.walletAddress &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(accountId, chainId, walletAddress, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ExternalGetNonceParams{accountId=$accountId, chainId=$chainId, walletAddress=$walletAddress, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
