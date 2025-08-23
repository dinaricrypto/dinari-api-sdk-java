// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2

import com.dinari.api.core.Params
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import com.dinari.api.models.v2.accounts.Chain
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Get a list of all `Orders` under the `Entity`. Optionally `Orders` can be transaction hash or
 * fulfillment transaction hash.
 */
class V2ListOrdersParams
private constructor(
    private val chainId: Chain?,
    private val orderFulfillmentTransactionHash: String?,
    private val orderRequestId: String?,
    private val orderTransactionHash: String?,
    private val page: Long?,
    private val pageSize: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** CAIP-2 formatted chain ID of the blockchain the `Order` was made on. */
    fun chainId(): Optional<Chain> = Optional.ofNullable(chainId)

    /** Fulfillment transaction hash of the `Order`. */
    fun orderFulfillmentTransactionHash(): Optional<String> =
        Optional.ofNullable(orderFulfillmentTransactionHash)

    /** Order Request ID for the `Order` */
    fun orderRequestId(): Optional<String> = Optional.ofNullable(orderRequestId)

    /** Transaction hash of the `Order`. */
    fun orderTransactionHash(): Optional<String> = Optional.ofNullable(orderTransactionHash)

    fun page(): Optional<Long> = Optional.ofNullable(page)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): V2ListOrdersParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [V2ListOrdersParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [V2ListOrdersParams]. */
    class Builder internal constructor() {

        private var chainId: Chain? = null
        private var orderFulfillmentTransactionHash: String? = null
        private var orderRequestId: String? = null
        private var orderTransactionHash: String? = null
        private var page: Long? = null
        private var pageSize: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(v2ListOrdersParams: V2ListOrdersParams) = apply {
            chainId = v2ListOrdersParams.chainId
            orderFulfillmentTransactionHash = v2ListOrdersParams.orderFulfillmentTransactionHash
            orderRequestId = v2ListOrdersParams.orderRequestId
            orderTransactionHash = v2ListOrdersParams.orderTransactionHash
            page = v2ListOrdersParams.page
            pageSize = v2ListOrdersParams.pageSize
            additionalHeaders = v2ListOrdersParams.additionalHeaders.toBuilder()
            additionalQueryParams = v2ListOrdersParams.additionalQueryParams.toBuilder()
        }

        /** CAIP-2 formatted chain ID of the blockchain the `Order` was made on. */
        fun chainId(chainId: Chain?) = apply { this.chainId = chainId }

        /** Alias for calling [Builder.chainId] with `chainId.orElse(null)`. */
        fun chainId(chainId: Optional<Chain>) = chainId(chainId.getOrNull())

        /** Fulfillment transaction hash of the `Order`. */
        fun orderFulfillmentTransactionHash(orderFulfillmentTransactionHash: String?) = apply {
            this.orderFulfillmentTransactionHash = orderFulfillmentTransactionHash
        }

        /**
         * Alias for calling [Builder.orderFulfillmentTransactionHash] with
         * `orderFulfillmentTransactionHash.orElse(null)`.
         */
        fun orderFulfillmentTransactionHash(orderFulfillmentTransactionHash: Optional<String>) =
            orderFulfillmentTransactionHash(orderFulfillmentTransactionHash.getOrNull())

        /** Order Request ID for the `Order` */
        fun orderRequestId(orderRequestId: String?) = apply { this.orderRequestId = orderRequestId }

        /** Alias for calling [Builder.orderRequestId] with `orderRequestId.orElse(null)`. */
        fun orderRequestId(orderRequestId: Optional<String>) =
            orderRequestId(orderRequestId.getOrNull())

        /** Transaction hash of the `Order`. */
        fun orderTransactionHash(orderTransactionHash: String?) = apply {
            this.orderTransactionHash = orderTransactionHash
        }

        /**
         * Alias for calling [Builder.orderTransactionHash] with
         * `orderTransactionHash.orElse(null)`.
         */
        fun orderTransactionHash(orderTransactionHash: Optional<String>) =
            orderTransactionHash(orderTransactionHash.getOrNull())

        fun page(page: Long?) = apply { this.page = page }

        /**
         * Alias for [Builder.page].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun page(page: Long) = page(page as Long?)

        /** Alias for calling [Builder.page] with `page.orElse(null)`. */
        fun page(page: Optional<Long>) = page(page.getOrNull())

        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /**
         * Alias for [Builder.pageSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

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
         * Returns an immutable instance of [V2ListOrdersParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): V2ListOrdersParams =
            V2ListOrdersParams(
                chainId,
                orderFulfillmentTransactionHash,
                orderRequestId,
                orderTransactionHash,
                page,
                pageSize,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                chainId?.let { put("chain_id", it.toString()) }
                orderFulfillmentTransactionHash?.let {
                    put("order_fulfillment_transaction_hash", it)
                }
                orderRequestId?.let { put("order_request_id", it) }
                orderTransactionHash?.let { put("order_transaction_hash", it) }
                page?.let { put("page", it.toString()) }
                pageSize?.let { put("page_size", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is V2ListOrdersParams &&
            chainId == other.chainId &&
            orderFulfillmentTransactionHash == other.orderFulfillmentTransactionHash &&
            orderRequestId == other.orderRequestId &&
            orderTransactionHash == other.orderTransactionHash &&
            page == other.page &&
            pageSize == other.pageSize &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            chainId,
            orderFulfillmentTransactionHash,
            orderRequestId,
            orderTransactionHash,
            page,
            pageSize,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "V2ListOrdersParams{chainId=$chainId, orderFulfillmentTransactionHash=$orderFulfillmentTransactionHash, orderRequestId=$orderRequestId, orderTransactionHash=$orderTransactionHash, page=$page, pageSize=$pageSize, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
