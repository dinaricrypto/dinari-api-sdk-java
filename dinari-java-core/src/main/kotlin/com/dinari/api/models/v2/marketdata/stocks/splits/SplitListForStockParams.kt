// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks.splits

import com.dinari.api.core.Enum
import com.dinari.api.core.JsonField
import com.dinari.api.core.Params
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Get a list of stock splits for a specific `Stock`. The splits are ordered by the date they were
 * created, with the most recent split first.
 *
 * In an example 10-for-1 stock split, trading will be halted for the stock at the end of the
 * `payable_date`, as the split transitions from `PENDING` to `IN_PROGRESS`. This usually occurs
 * over a weekend to minimize trading disruptions. Each share of stock owned by a shareholder will
 * then be converted into 10 shares, and the split becomes `COMPLETE` as trading resumes on the
 * `ex_date` with new split-adjusted prices.
 */
class SplitListForStockParams
private constructor(
    private val stockId: String?,
    private val limit: Long?,
    private val next: String?,
    private val order: Order?,
    private val page: Long?,
    private val pageSize: Long?,
    private val previous: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun stockId(): Optional<String> = Optional.ofNullable(stockId)

    /** Number of results to return */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Cursor for next page */
    fun next(): Optional<String> = Optional.ofNullable(next)

    /** Sort order */
    fun order(): Optional<Order> = Optional.ofNullable(order)

    fun page(): Optional<Long> = Optional.ofNullable(page)

    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** Cursor for previous page */
    fun previous(): Optional<String> = Optional.ofNullable(previous)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): SplitListForStockParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [SplitListForStockParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SplitListForStockParams]. */
    class Builder internal constructor() {

        private var stockId: String? = null
        private var limit: Long? = null
        private var next: String? = null
        private var order: Order? = null
        private var page: Long? = null
        private var pageSize: Long? = null
        private var previous: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(splitListForStockParams: SplitListForStockParams) = apply {
            stockId = splitListForStockParams.stockId
            limit = splitListForStockParams.limit
            next = splitListForStockParams.next
            order = splitListForStockParams.order
            page = splitListForStockParams.page
            pageSize = splitListForStockParams.pageSize
            previous = splitListForStockParams.previous
            additionalHeaders = splitListForStockParams.additionalHeaders.toBuilder()
            additionalQueryParams = splitListForStockParams.additionalQueryParams.toBuilder()
        }

        fun stockId(stockId: String?) = apply { this.stockId = stockId }

        /** Alias for calling [Builder.stockId] with `stockId.orElse(null)`. */
        fun stockId(stockId: Optional<String>) = stockId(stockId.getOrNull())

        /** Number of results to return */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Cursor for next page */
        fun next(next: String?) = apply { this.next = next }

        /** Alias for calling [Builder.next] with `next.orElse(null)`. */
        fun next(next: Optional<String>) = next(next.getOrNull())

        /** Sort order */
        fun order(order: Order?) = apply { this.order = order }

        /** Alias for calling [Builder.order] with `order.orElse(null)`. */
        fun order(order: Optional<Order>) = order(order.getOrNull())

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

        /** Cursor for previous page */
        fun previous(previous: String?) = apply { this.previous = previous }

        /** Alias for calling [Builder.previous] with `previous.orElse(null)`. */
        fun previous(previous: Optional<String>) = previous(previous.getOrNull())

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
         * Returns an immutable instance of [SplitListForStockParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SplitListForStockParams =
            SplitListForStockParams(
                stockId,
                limit,
                next,
                order,
                page,
                pageSize,
                previous,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> stockId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                limit?.let { put("limit", it.toString()) }
                next?.let { put("next", it) }
                order?.let { put("order", it.toString()) }
                page?.let { put("page", it.toString()) }
                pageSize?.let { put("page_size", it.toString()) }
                previous?.let { put("previous", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Sort order */
    class Order @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ASC = of("asc")

            @JvmField val DESC = of("desc")

            @JvmStatic fun of(value: String) = Order(JsonField.of(value))
        }

        /** An enum containing [Order]'s known values. */
        enum class Known {
            ASC,
            DESC,
        }

        /**
         * An enum containing [Order]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Order] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ASC,
            DESC,
            /** An enum member indicating that [Order] was instantiated with an unknown value. */
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
                ASC -> Value.ASC
                DESC -> Value.DESC
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
                ASC -> Known.ASC
                DESC -> Known.DESC
                else -> throw DinariInvalidDataException("Unknown Order: $value")
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

        fun validate(): Order = apply {
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

            return other is Order && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SplitListForStockParams &&
            stockId == other.stockId &&
            limit == other.limit &&
            next == other.next &&
            order == other.order &&
            page == other.page &&
            pageSize == other.pageSize &&
            previous == other.previous &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            stockId,
            limit,
            next,
            order,
            page,
            pageSize,
            previous,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "SplitListForStockParams{stockId=$stockId, limit=$limit, next=$next, order=$order, page=$page, pageSize=$pageSize, previous=$previous, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
