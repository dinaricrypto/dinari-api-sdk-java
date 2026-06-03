// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

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

/** Get quote for a specified `Stock`. */
class StockRetrieveCurrentQuoteParams
private constructor(
    private val stockId: String?,
    private val feed: Feed?,
    private val xApiVersion: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun stockId(): Optional<String> = Optional.ofNullable(stockId)

    /**
     * Requested data source for the quote. Only applies when using x-api-version: 2. Allowed
     * values:
     * - `null`: (default) Selects the highest quality available free data source.
     * - `sip`: Consolidated quote from all U.S. exchanges (NBBO). This is a paid data source and
     *   incurs usage-based billing.
     */
    fun feed(): Optional<Feed> = Optional.ofNullable(feed)

    fun xApiVersion(): Optional<String> = Optional.ofNullable(xApiVersion)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): StockRetrieveCurrentQuoteParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [StockRetrieveCurrentQuoteParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StockRetrieveCurrentQuoteParams]. */
    class Builder internal constructor() {

        private var stockId: String? = null
        private var feed: Feed? = null
        private var xApiVersion: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(stockRetrieveCurrentQuoteParams: StockRetrieveCurrentQuoteParams) =
            apply {
                stockId = stockRetrieveCurrentQuoteParams.stockId
                feed = stockRetrieveCurrentQuoteParams.feed
                xApiVersion = stockRetrieveCurrentQuoteParams.xApiVersion
                additionalHeaders = stockRetrieveCurrentQuoteParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    stockRetrieveCurrentQuoteParams.additionalQueryParams.toBuilder()
            }

        fun stockId(stockId: String?) = apply { this.stockId = stockId }

        /** Alias for calling [Builder.stockId] with `stockId.orElse(null)`. */
        fun stockId(stockId: Optional<String>) = stockId(stockId.getOrNull())

        /**
         * Requested data source for the quote. Only applies when using x-api-version: 2. Allowed
         * values:
         * - `null`: (default) Selects the highest quality available free data source.
         * - `sip`: Consolidated quote from all U.S. exchanges (NBBO). This is a paid data source
         *   and incurs usage-based billing.
         */
        fun feed(feed: Feed?) = apply { this.feed = feed }

        /** Alias for calling [Builder.feed] with `feed.orElse(null)`. */
        fun feed(feed: Optional<Feed>) = feed(feed.getOrNull())

        fun xApiVersion(xApiVersion: String?) = apply { this.xApiVersion = xApiVersion }

        /** Alias for calling [Builder.xApiVersion] with `xApiVersion.orElse(null)`. */
        fun xApiVersion(xApiVersion: Optional<String>) = xApiVersion(xApiVersion.getOrNull())

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
         * Returns an immutable instance of [StockRetrieveCurrentQuoteParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): StockRetrieveCurrentQuoteParams =
            StockRetrieveCurrentQuoteParams(
                stockId,
                feed,
                xApiVersion,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> stockId ?: ""
            else -> ""
        }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                xApiVersion?.let { put("X-API-Version", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                feed?.let { put("feed", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /**
     * Requested data source for the quote. Only applies when using x-api-version: 2. Allowed
     * values:
     * - `null`: (default) Selects the highest quality available free data source.
     * - `sip`: Consolidated quote from all U.S. exchanges (NBBO). This is a paid data source and
     *   incurs usage-based billing.
     */
    class Feed @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SIP = of("sip")

            @JvmStatic fun of(value: String) = Feed(JsonField.of(value))
        }

        /** An enum containing [Feed]'s known values. */
        enum class Known {
            SIP
        }

        /**
         * An enum containing [Feed]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Feed] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SIP,
            /** An enum member indicating that [Feed] was instantiated with an unknown value. */
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
                SIP -> Value.SIP
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
                SIP -> Known.SIP
                else -> throw DinariInvalidDataException("Unknown Feed: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws DinariInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Feed = apply {
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

            return other is Feed && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StockRetrieveCurrentQuoteParams &&
            stockId == other.stockId &&
            feed == other.feed &&
            xApiVersion == other.xApiVersion &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(stockId, feed, xApiVersion, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "StockRetrieveCurrentQuoteParams{stockId=$stockId, feed=$feed, xApiVersion=$xApiVersion, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
