// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawals

import com.dinari.api.core.Params
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Get a list of all `Withdrawals` under the `Account`, sorted by most recent. */
class WithdrawalListParams
private constructor(
    private val accountId: String?,
    private val page: Long?,
    private val pageSize: Long?,
    private val withdrawalRequestId: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    fun page(): Optional<Long> = Optional.ofNullable(page)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** ID of the `WithdrawalRequest` to find `Withdrawals` for. */
    fun withdrawalRequestId(): Optional<String> = Optional.ofNullable(withdrawalRequestId)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): WithdrawalListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [WithdrawalListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WithdrawalListParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var page: Long? = null
        private var pageSize: Long? = null
        private var withdrawalRequestId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(withdrawalListParams: WithdrawalListParams) = apply {
            accountId = withdrawalListParams.accountId
            page = withdrawalListParams.page
            pageSize = withdrawalListParams.pageSize
            withdrawalRequestId = withdrawalListParams.withdrawalRequestId
            additionalHeaders = withdrawalListParams.additionalHeaders.toBuilder()
            additionalQueryParams = withdrawalListParams.additionalQueryParams.toBuilder()
        }

        fun accountId(accountId: String?) = apply { this.accountId = accountId }

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

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

        /** ID of the `WithdrawalRequest` to find `Withdrawals` for. */
        fun withdrawalRequestId(withdrawalRequestId: String?) = apply {
            this.withdrawalRequestId = withdrawalRequestId
        }

        /**
         * Alias for calling [Builder.withdrawalRequestId] with `withdrawalRequestId.orElse(null)`.
         */
        fun withdrawalRequestId(withdrawalRequestId: Optional<String>) =
            withdrawalRequestId(withdrawalRequestId.getOrNull())

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
         * Returns an immutable instance of [WithdrawalListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WithdrawalListParams =
            WithdrawalListParams(
                accountId,
                page,
                pageSize,
                withdrawalRequestId,
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
                page?.let { put("page", it.toString()) }
                pageSize?.let { put("page_size", it.toString()) }
                withdrawalRequestId?.let { put("withdrawal_request_id", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WithdrawalListParams &&
            accountId == other.accountId &&
            page == other.page &&
            pageSize == other.pageSize &&
            withdrawalRequestId == other.withdrawalRequestId &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            accountId,
            page,
            pageSize,
            withdrawalRequestId,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "WithdrawalListParams{accountId=$accountId, page=$page, pageSize=$pageSize, withdrawalRequestId=$withdrawalRequestId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
