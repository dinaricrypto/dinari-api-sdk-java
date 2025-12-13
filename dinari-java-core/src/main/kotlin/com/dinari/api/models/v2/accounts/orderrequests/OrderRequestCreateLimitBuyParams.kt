// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.JsonValue
import com.dinari.api.core.Params
import com.dinari.api.core.checkRequired
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create a managed `OrderRequest` to place a limit buy `Order`.
 *
 * Fees for the `Order` are included in the transaction. Refer to our
 * [Fee Quote API](https://docs.dinari.com/reference/createproxiedorderfeequote#/) for fee
 * estimation.
 *
 * If an `OrderRequest` with the same `client_order_id` already exists for the given account, the
 * creation call will fail.
 */
class OrderRequestCreateLimitBuyParams
private constructor(
    private val accountId: String?,
    private val createLimitBuyOrderInput: CreateLimitBuyOrderInput,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accountId(): Optional<String> = Optional.ofNullable(accountId)

    /** Input parameters for creating a limit buy `OrderRequest`. */
    fun createLimitBuyOrderInput(): CreateLimitBuyOrderInput = createLimitBuyOrderInput

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        createLimitBuyOrderInput._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [OrderRequestCreateLimitBuyParams].
         *
         * The following fields are required:
         * ```java
         * .createLimitBuyOrderInput()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderRequestCreateLimitBuyParams]. */
    class Builder internal constructor() {

        private var accountId: String? = null
        private var createLimitBuyOrderInput: CreateLimitBuyOrderInput? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(orderRequestCreateLimitBuyParams: OrderRequestCreateLimitBuyParams) =
            apply {
                accountId = orderRequestCreateLimitBuyParams.accountId
                createLimitBuyOrderInput = orderRequestCreateLimitBuyParams.createLimitBuyOrderInput
                additionalHeaders = orderRequestCreateLimitBuyParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    orderRequestCreateLimitBuyParams.additionalQueryParams.toBuilder()
            }

        fun accountId(accountId: String?) = apply { this.accountId = accountId }

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

        /** Input parameters for creating a limit buy `OrderRequest`. */
        fun createLimitBuyOrderInput(createLimitBuyOrderInput: CreateLimitBuyOrderInput) = apply {
            this.createLimitBuyOrderInput = createLimitBuyOrderInput
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
         * Returns an immutable instance of [OrderRequestCreateLimitBuyParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .createLimitBuyOrderInput()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrderRequestCreateLimitBuyParams =
            OrderRequestCreateLimitBuyParams(
                accountId,
                checkRequired("createLimitBuyOrderInput", createLimitBuyOrderInput),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): CreateLimitBuyOrderInput = createLimitBuyOrderInput

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> accountId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrderRequestCreateLimitBuyParams &&
            accountId == other.accountId &&
            createLimitBuyOrderInput == other.createLimitBuyOrderInput &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(accountId, createLimitBuyOrderInput, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "OrderRequestCreateLimitBuyParams{accountId=$accountId, createLimitBuyOrderInput=$createLimitBuyOrderInput, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
