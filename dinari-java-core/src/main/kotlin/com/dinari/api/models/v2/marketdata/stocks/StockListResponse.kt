// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.stocks

import com.dinari.api.core.BaseDeserializer
import com.dinari.api.core.BaseSerializer
import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.allMaxBy
import com.dinari.api.core.checkKnown
import com.dinari.api.core.checkRequired
import com.dinari.api.core.getOrThrow
import com.dinari.api.core.toImmutable
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = StockListResponse.Deserializer::class)
@JsonSerialize(using = StockListResponse.Serializer::class)
class StockListResponse
private constructor(
    private val stocks: List<Stock>? = null,
    private val paginatedStock: PaginatedStockResponse? = null,
    private val _json: JsonValue? = null,
) {

    fun stocks(): Optional<List<Stock>> = Optional.ofNullable(stocks)

    fun paginatedStock(): Optional<PaginatedStockResponse> = Optional.ofNullable(paginatedStock)

    fun isStocks(): Boolean = stocks != null

    fun isPaginatedStock(): Boolean = paginatedStock != null

    fun asStocks(): List<Stock> = stocks.getOrThrow("stocks")

    fun asPaginatedStock(): PaginatedStockResponse = paginatedStock.getOrThrow("paginatedStock")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            stocks != null -> visitor.visitStocks(stocks)
            paginatedStock != null -> visitor.visitPaginatedStock(paginatedStock)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): StockListResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitStocks(stocks: List<Stock>) {
                    stocks.forEach { it.validate() }
                }

                override fun visitPaginatedStock(paginatedStock: PaginatedStockResponse) {
                    paginatedStock.validate()
                }
            }
        )
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitStocks(stocks: List<Stock>) =
                    stocks.sumOf { it.validity().toInt() }

                override fun visitPaginatedStock(paginatedStock: PaginatedStockResponse) =
                    paginatedStock.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StockListResponse &&
            stocks == other.stocks &&
            paginatedStock == other.paginatedStock
    }

    override fun hashCode(): Int = Objects.hash(stocks, paginatedStock)

    override fun toString(): String =
        when {
            stocks != null -> "StockListResponse{stocks=$stocks}"
            paginatedStock != null -> "StockListResponse{paginatedStock=$paginatedStock}"
            _json != null -> "StockListResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid StockListResponse")
        }

    companion object {

        @JvmStatic
        fun ofStocks(stocks: List<Stock>) = StockListResponse(stocks = stocks.toImmutable())

        @JvmStatic
        fun ofPaginatedStock(paginatedStock: PaginatedStockResponse) =
            StockListResponse(paginatedStock = paginatedStock)
    }

    /**
     * An interface that defines how to map each variant of [StockListResponse] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitStocks(stocks: List<Stock>): T

        fun visitPaginatedStock(paginatedStock: PaginatedStockResponse): T

        /**
         * Maps an unknown variant of [StockListResponse] to a value of type [T].
         *
         * An instance of [StockListResponse] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws DinariInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw DinariInvalidDataException("Unknown StockListResponse: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<StockListResponse>(StockListResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): StockListResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<PaginatedStockResponse>())?.let {
                            StockListResponse(paginatedStock = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<List<Stock>>())?.let {
                            StockListResponse(stocks = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> StockListResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<StockListResponse>(StockListResponse::class) {

        override fun serialize(
            value: StockListResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.stocks != null -> generator.writeObject(value.stocks)
                value.paginatedStock != null -> generator.writeObject(value.paginatedStock)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid StockListResponse")
            }
        }
    }

    /** Information about stock available for trading. */
    class Stock
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val isFractionable: JsonField<Boolean>,
        private val isTradable: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val symbol: JsonField<String>,
        private val tokens: JsonField<List<String>>,
        private val cik: JsonField<String>,
        private val compositeFigi: JsonField<String>,
        private val cusip: JsonField<String>,
        private val description: JsonField<String>,
        private val displayName: JsonField<String>,
        private val logoUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_fractionable")
            @ExcludeMissing
            isFractionable: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("is_tradable")
            @ExcludeMissing
            isTradable: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("symbol") @ExcludeMissing symbol: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tokens")
            @ExcludeMissing
            tokens: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("cik") @ExcludeMissing cik: JsonField<String> = JsonMissing.of(),
            @JsonProperty("composite_figi")
            @ExcludeMissing
            compositeFigi: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cusip") @ExcludeMissing cusip: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("display_name")
            @ExcludeMissing
            displayName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("logo_url") @ExcludeMissing logoUrl: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            isFractionable,
            isTradable,
            name,
            symbol,
            tokens,
            cik,
            compositeFigi,
            cusip,
            description,
            displayName,
            logoUrl,
            mutableMapOf(),
        )

        /**
         * ID of the `Stock`
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Whether the `Stock` allows for fractional trading. If it is not fractionable, Dinari only
         * supports limit orders for the `Stock`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isFractionable(): Boolean = isFractionable.getRequired("is_fractionable")

        /**
         * Whether the `Stock` is available for trading.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isTradable(): Boolean = isTradable.getRequired("is_tradable")

        /**
         * Company name
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Ticker symbol
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun symbol(): String = symbol.getRequired("symbol")

        /**
         * List of CAIP-10 formatted token addresses.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun tokens(): List<String> = tokens.getRequired("tokens")

        /**
         * SEC Central Index Key. Refer to
         * [this link](https://www.sec.gov/submit-filings/filer-support-resources/how-do-i-guides/understand-utilize-edgar-ciks-passphrases-access-codes)
         * for more information.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cik(): Optional<String> = cik.getOptional("cik")

        /**
         * Composite FIGI ID. Refer to [this link](https://www.openfigi.com/about/figi) for more
         * information.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun compositeFigi(): Optional<String> = compositeFigi.getOptional("composite_figi")

        /**
         * CUSIP ID. Refer to [this link](https://www.cusip.com/identifiers.html) for more
         * information. A license agreement with CUSIP Global Services is required to receive this
         * value.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cusip(): Optional<String> = cusip.getOptional("cusip")

        /**
         * Description of the company and their services.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Name of `Stock` for application display. If defined, this supercedes the `name` field for
         * displaying the name.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun displayName(): Optional<String> = displayName.getOptional("display_name")

        /**
         * URL of the company's logo. Supported formats are SVG and PNG.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun logoUrl(): Optional<String> = logoUrl.getOptional("logo_url")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [isFractionable].
         *
         * Unlike [isFractionable], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("is_fractionable")
        @ExcludeMissing
        fun _isFractionable(): JsonField<Boolean> = isFractionable

        /**
         * Returns the raw JSON value of [isTradable].
         *
         * Unlike [isTradable], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_tradable")
        @ExcludeMissing
        fun _isTradable(): JsonField<Boolean> = isTradable

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [symbol].
         *
         * Unlike [symbol], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("symbol") @ExcludeMissing fun _symbol(): JsonField<String> = symbol

        /**
         * Returns the raw JSON value of [tokens].
         *
         * Unlike [tokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

        /**
         * Returns the raw JSON value of [cik].
         *
         * Unlike [cik], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cik") @ExcludeMissing fun _cik(): JsonField<String> = cik

        /**
         * Returns the raw JSON value of [compositeFigi].
         *
         * Unlike [compositeFigi], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("composite_figi")
        @ExcludeMissing
        fun _compositeFigi(): JsonField<String> = compositeFigi

        /**
         * Returns the raw JSON value of [cusip].
         *
         * Unlike [cusip], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cusip") @ExcludeMissing fun _cusip(): JsonField<String> = cusip

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [displayName].
         *
         * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("display_name")
        @ExcludeMissing
        fun _displayName(): JsonField<String> = displayName

        /**
         * Returns the raw JSON value of [logoUrl].
         *
         * Unlike [logoUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logo_url") @ExcludeMissing fun _logoUrl(): JsonField<String> = logoUrl

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
             * Returns a mutable builder for constructing an instance of [Stock].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .isFractionable()
             * .isTradable()
             * .name()
             * .symbol()
             * .tokens()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Stock]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var isFractionable: JsonField<Boolean>? = null
            private var isTradable: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var symbol: JsonField<String>? = null
            private var tokens: JsonField<MutableList<String>>? = null
            private var cik: JsonField<String> = JsonMissing.of()
            private var compositeFigi: JsonField<String> = JsonMissing.of()
            private var cusip: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var displayName: JsonField<String> = JsonMissing.of()
            private var logoUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(stock: Stock) = apply {
                id = stock.id
                isFractionable = stock.isFractionable
                isTradable = stock.isTradable
                name = stock.name
                symbol = stock.symbol
                tokens = stock.tokens.map { it.toMutableList() }
                cik = stock.cik
                compositeFigi = stock.compositeFigi
                cusip = stock.cusip
                description = stock.description
                displayName = stock.displayName
                logoUrl = stock.logoUrl
                additionalProperties = stock.additionalProperties.toMutableMap()
            }

            /** ID of the `Stock` */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * Whether the `Stock` allows for fractional trading. If it is not fractionable, Dinari
             * only supports limit orders for the `Stock`.
             */
            fun isFractionable(isFractionable: Boolean) =
                isFractionable(JsonField.of(isFractionable))

            /**
             * Sets [Builder.isFractionable] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isFractionable] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isFractionable(isFractionable: JsonField<Boolean>) = apply {
                this.isFractionable = isFractionable
            }

            /** Whether the `Stock` is available for trading. */
            fun isTradable(isTradable: Boolean) = isTradable(JsonField.of(isTradable))

            /**
             * Sets [Builder.isTradable] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isTradable] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isTradable(isTradable: JsonField<Boolean>) = apply { this.isTradable = isTradable }

            /** Company name */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Ticker symbol */
            fun symbol(symbol: String) = symbol(JsonField.of(symbol))

            /**
             * Sets [Builder.symbol] to an arbitrary JSON value.
             *
             * You should usually call [Builder.symbol] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun symbol(symbol: JsonField<String>) = apply { this.symbol = symbol }

            /** List of CAIP-10 formatted token addresses. */
            fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

            /**
             * Sets [Builder.tokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tokens] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tokens(tokens: JsonField<List<String>>) = apply {
                this.tokens = tokens.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tokens].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addToken(token: String) = apply {
                tokens =
                    (tokens ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tokens", it).add(token)
                    }
            }

            /**
             * SEC Central Index Key. Refer to
             * [this link](https://www.sec.gov/submit-filings/filer-support-resources/how-do-i-guides/understand-utilize-edgar-ciks-passphrases-access-codes)
             * for more information.
             */
            fun cik(cik: String?) = cik(JsonField.ofNullable(cik))

            /** Alias for calling [Builder.cik] with `cik.orElse(null)`. */
            fun cik(cik: Optional<String>) = cik(cik.getOrNull())

            /**
             * Sets [Builder.cik] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cik] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun cik(cik: JsonField<String>) = apply { this.cik = cik }

            /**
             * Composite FIGI ID. Refer to [this link](https://www.openfigi.com/about/figi) for more
             * information.
             */
            fun compositeFigi(compositeFigi: String?) =
                compositeFigi(JsonField.ofNullable(compositeFigi))

            /** Alias for calling [Builder.compositeFigi] with `compositeFigi.orElse(null)`. */
            fun compositeFigi(compositeFigi: Optional<String>) =
                compositeFigi(compositeFigi.getOrNull())

            /**
             * Sets [Builder.compositeFigi] to an arbitrary JSON value.
             *
             * You should usually call [Builder.compositeFigi] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun compositeFigi(compositeFigi: JsonField<String>) = apply {
                this.compositeFigi = compositeFigi
            }

            /**
             * CUSIP ID. Refer to [this link](https://www.cusip.com/identifiers.html) for more
             * information. A license agreement with CUSIP Global Services is required to receive
             * this value.
             */
            fun cusip(cusip: String?) = cusip(JsonField.ofNullable(cusip))

            /** Alias for calling [Builder.cusip] with `cusip.orElse(null)`. */
            fun cusip(cusip: Optional<String>) = cusip(cusip.getOrNull())

            /**
             * Sets [Builder.cusip] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cusip] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cusip(cusip: JsonField<String>) = apply { this.cusip = cusip }

            /** Description of the company and their services. */
            fun description(description: String?) = description(JsonField.ofNullable(description))

            /** Alias for calling [Builder.description] with `description.orElse(null)`. */
            fun description(description: Optional<String>) = description(description.getOrNull())

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /**
             * Name of `Stock` for application display. If defined, this supercedes the `name` field
             * for displaying the name.
             */
            fun displayName(displayName: String?) = displayName(JsonField.ofNullable(displayName))

            /** Alias for calling [Builder.displayName] with `displayName.orElse(null)`. */
            fun displayName(displayName: Optional<String>) = displayName(displayName.getOrNull())

            /**
             * Sets [Builder.displayName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.displayName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun displayName(displayName: JsonField<String>) = apply {
                this.displayName = displayName
            }

            /** URL of the company's logo. Supported formats are SVG and PNG. */
            fun logoUrl(logoUrl: String?) = logoUrl(JsonField.ofNullable(logoUrl))

            /** Alias for calling [Builder.logoUrl] with `logoUrl.orElse(null)`. */
            fun logoUrl(logoUrl: Optional<String>) = logoUrl(logoUrl.getOrNull())

            /**
             * Sets [Builder.logoUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logoUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

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
             * Returns an immutable instance of [Stock].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .isFractionable()
             * .isTradable()
             * .name()
             * .symbol()
             * .tokens()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Stock =
                Stock(
                    checkRequired("id", id),
                    checkRequired("isFractionable", isFractionable),
                    checkRequired("isTradable", isTradable),
                    checkRequired("name", name),
                    checkRequired("symbol", symbol),
                    checkRequired("tokens", tokens).map { it.toImmutable() },
                    cik,
                    compositeFigi,
                    cusip,
                    description,
                    displayName,
                    logoUrl,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Stock = apply {
            if (validated) {
                return@apply
            }

            id()
            isFractionable()
            isTradable()
            name()
            symbol()
            tokens()
            cik()
            compositeFigi()
            cusip()
            description()
            displayName()
            logoUrl()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (isFractionable.asKnown().isPresent) 1 else 0) +
                (if (isTradable.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (symbol.asKnown().isPresent) 1 else 0) +
                (tokens.asKnown().getOrNull()?.size ?: 0) +
                (if (cik.asKnown().isPresent) 1 else 0) +
                (if (compositeFigi.asKnown().isPresent) 1 else 0) +
                (if (cusip.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (displayName.asKnown().isPresent) 1 else 0) +
                (if (logoUrl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Stock &&
                id == other.id &&
                isFractionable == other.isFractionable &&
                isTradable == other.isTradable &&
                name == other.name &&
                symbol == other.symbol &&
                tokens == other.tokens &&
                cik == other.cik &&
                compositeFigi == other.compositeFigi &&
                cusip == other.cusip &&
                description == other.description &&
                displayName == other.displayName &&
                logoUrl == other.logoUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                isFractionable,
                isTradable,
                name,
                symbol,
                tokens,
                cik,
                compositeFigi,
                cusip,
                description,
                displayName,
                logoUrl,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Stock{id=$id, isFractionable=$isFractionable, isTradable=$isTradable, name=$name, symbol=$symbol, tokens=$tokens, cik=$cik, compositeFigi=$compositeFigi, cusip=$cusip, description=$description, displayName=$displayName, logoUrl=$logoUrl, additionalProperties=$additionalProperties}"
    }

    class PaginatedStockResponse
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val data: JsonField<List<Data>>,
        private val paginationMetadata: JsonField<PaginationMetadata>,
        private val _sv: JsonField<_Sv>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<List<Data>> = JsonMissing.of(),
            @JsonProperty("pagination_metadata")
            @ExcludeMissing
            paginationMetadata: JsonField<PaginationMetadata> = JsonMissing.of(),
            @JsonProperty("_sv") @ExcludeMissing _sv: JsonField<_Sv> = JsonMissing.of(),
        ) : this(data, paginationMetadata, _sv, mutableMapOf())

        /**
         * List of Stock
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): List<Data> = data.getRequired("data")

        /**
         * Pagination metadata
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun paginationMetadata(): PaginationMetadata =
            paginationMetadata.getRequired("pagination_metadata")

        /**
         * Version
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun _sv(): Optional<_Sv> = _sv.getOptional("_sv")

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Data>> = data

        /**
         * Returns the raw JSON value of [paginationMetadata].
         *
         * Unlike [paginationMetadata], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("pagination_metadata")
        @ExcludeMissing
        fun _paginationMetadata(): JsonField<PaginationMetadata> = paginationMetadata

        /**
         * Returns the raw JSON value of [_sv].
         *
         * Unlike [_sv], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("_sv") @ExcludeMissing fun __sv(): JsonField<_Sv> = _sv

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
             * Returns a mutable builder for constructing an instance of [PaginatedStockResponse].
             *
             * The following fields are required:
             * ```java
             * .data()
             * .paginationMetadata()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PaginatedStockResponse]. */
        class Builder internal constructor() {

            private var data: JsonField<MutableList<Data>>? = null
            private var paginationMetadata: JsonField<PaginationMetadata>? = null
            private var _sv: JsonField<_Sv> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(paginatedStockResponse: PaginatedStockResponse) = apply {
                data = paginatedStockResponse.data.map { it.toMutableList() }
                paginationMetadata = paginatedStockResponse.paginationMetadata
                _sv = paginatedStockResponse._sv
                additionalProperties = paginatedStockResponse.additionalProperties.toMutableMap()
            }

            /** List of Stock */
            fun data(data: List<Data>) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed `List<Data>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<List<Data>>) = apply {
                this.data = data.map { it.toMutableList() }
            }

            /**
             * Adds a single [Data] to [Builder.data].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addData(data: Data) = apply {
                this.data =
                    (this.data ?: JsonField.of(mutableListOf())).also {
                        checkKnown("data", it).add(data)
                    }
            }

            /** Pagination metadata */
            fun paginationMetadata(paginationMetadata: PaginationMetadata) =
                paginationMetadata(JsonField.of(paginationMetadata))

            /**
             * Sets [Builder.paginationMetadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paginationMetadata] with a well-typed
             * [PaginationMetadata] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun paginationMetadata(paginationMetadata: JsonField<PaginationMetadata>) = apply {
                this.paginationMetadata = paginationMetadata
            }

            /** Version */
            fun _sv(_sv: _Sv) = _sv(JsonField.of(_sv))

            /**
             * Sets [Builder._sv] to an arbitrary JSON value.
             *
             * You should usually call [Builder._sv] with a well-typed [_Sv] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun _sv(_sv: JsonField<_Sv>) = apply { this._sv = _sv }

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
             * Returns an immutable instance of [PaginatedStockResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * .paginationMetadata()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PaginatedStockResponse =
                PaginatedStockResponse(
                    checkRequired("data", data).map { it.toImmutable() },
                    checkRequired("paginationMetadata", paginationMetadata),
                    _sv,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): PaginatedStockResponse = apply {
            if (validated) {
                return@apply
            }

            data().forEach { it.validate() }
            paginationMetadata().validate()
            _sv().ifPresent { it.validate() }
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
            (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (paginationMetadata.asKnown().getOrNull()?.validity() ?: 0) +
                (_sv.asKnown().getOrNull()?.validity() ?: 0)

        /** Information about stock available for trading. */
        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val isFractionable: JsonField<Boolean>,
            private val isTradable: JsonField<Boolean>,
            private val name: JsonField<String>,
            private val symbol: JsonField<String>,
            private val tokens: JsonField<List<String>>,
            private val cik: JsonField<String>,
            private val compositeFigi: JsonField<String>,
            private val cusip: JsonField<String>,
            private val description: JsonField<String>,
            private val displayName: JsonField<String>,
            private val logoUrl: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("is_fractionable")
                @ExcludeMissing
                isFractionable: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("is_tradable")
                @ExcludeMissing
                isTradable: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("symbol")
                @ExcludeMissing
                symbol: JsonField<String> = JsonMissing.of(),
                @JsonProperty("tokens")
                @ExcludeMissing
                tokens: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("cik") @ExcludeMissing cik: JsonField<String> = JsonMissing.of(),
                @JsonProperty("composite_figi")
                @ExcludeMissing
                compositeFigi: JsonField<String> = JsonMissing.of(),
                @JsonProperty("cusip") @ExcludeMissing cusip: JsonField<String> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("display_name")
                @ExcludeMissing
                displayName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("logo_url")
                @ExcludeMissing
                logoUrl: JsonField<String> = JsonMissing.of(),
            ) : this(
                id,
                isFractionable,
                isTradable,
                name,
                symbol,
                tokens,
                cik,
                compositeFigi,
                cusip,
                description,
                displayName,
                logoUrl,
                mutableMapOf(),
            )

            /**
             * ID of the `Stock`
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * Whether the `Stock` allows for fractional trading. If it is not fractionable, Dinari
             * only supports limit orders for the `Stock`.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun isFractionable(): Boolean = isFractionable.getRequired("is_fractionable")

            /**
             * Whether the `Stock` is available for trading.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun isTradable(): Boolean = isTradable.getRequired("is_tradable")

            /**
             * Company name
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Ticker symbol
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun symbol(): String = symbol.getRequired("symbol")

            /**
             * List of CAIP-10 formatted token addresses.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tokens(): List<String> = tokens.getRequired("tokens")

            /**
             * SEC Central Index Key. Refer to
             * [this link](https://www.sec.gov/submit-filings/filer-support-resources/how-do-i-guides/understand-utilize-edgar-ciks-passphrases-access-codes)
             * for more information.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun cik(): Optional<String> = cik.getOptional("cik")

            /**
             * Composite FIGI ID. Refer to [this link](https://www.openfigi.com/about/figi) for more
             * information.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun compositeFigi(): Optional<String> = compositeFigi.getOptional("composite_figi")

            /**
             * CUSIP ID. Refer to [this link](https://www.cusip.com/identifiers.html) for more
             * information. A license agreement with CUSIP Global Services is required to receive
             * this value.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun cusip(): Optional<String> = cusip.getOptional("cusip")

            /**
             * Description of the company and their services.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * Name of `Stock` for application display. If defined, this supercedes the `name` field
             * for displaying the name.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun displayName(): Optional<String> = displayName.getOptional("display_name")

            /**
             * URL of the company's logo. Supported formats are SVG and PNG.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun logoUrl(): Optional<String> = logoUrl.getOptional("logo_url")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [isFractionable].
             *
             * Unlike [isFractionable], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("is_fractionable")
            @ExcludeMissing
            fun _isFractionable(): JsonField<Boolean> = isFractionable

            /**
             * Returns the raw JSON value of [isTradable].
             *
             * Unlike [isTradable], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("is_tradable")
            @ExcludeMissing
            fun _isTradable(): JsonField<Boolean> = isTradable

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [symbol].
             *
             * Unlike [symbol], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("symbol") @ExcludeMissing fun _symbol(): JsonField<String> = symbol

            /**
             * Returns the raw JSON value of [tokens].
             *
             * Unlike [tokens], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

            /**
             * Returns the raw JSON value of [cik].
             *
             * Unlike [cik], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cik") @ExcludeMissing fun _cik(): JsonField<String> = cik

            /**
             * Returns the raw JSON value of [compositeFigi].
             *
             * Unlike [compositeFigi], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("composite_figi")
            @ExcludeMissing
            fun _compositeFigi(): JsonField<String> = compositeFigi

            /**
             * Returns the raw JSON value of [cusip].
             *
             * Unlike [cusip], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cusip") @ExcludeMissing fun _cusip(): JsonField<String> = cusip

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [displayName].
             *
             * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("display_name")
            @ExcludeMissing
            fun _displayName(): JsonField<String> = displayName

            /**
             * Returns the raw JSON value of [logoUrl].
             *
             * Unlike [logoUrl], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("logo_url") @ExcludeMissing fun _logoUrl(): JsonField<String> = logoUrl

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
                 * Returns a mutable builder for constructing an instance of [Data].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .isFractionable()
                 * .isTradable()
                 * .name()
                 * .symbol()
                 * .tokens()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var isFractionable: JsonField<Boolean>? = null
                private var isTradable: JsonField<Boolean>? = null
                private var name: JsonField<String>? = null
                private var symbol: JsonField<String>? = null
                private var tokens: JsonField<MutableList<String>>? = null
                private var cik: JsonField<String> = JsonMissing.of()
                private var compositeFigi: JsonField<String> = JsonMissing.of()
                private var cusip: JsonField<String> = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var displayName: JsonField<String> = JsonMissing.of()
                private var logoUrl: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    id = data.id
                    isFractionable = data.isFractionable
                    isTradable = data.isTradable
                    name = data.name
                    symbol = data.symbol
                    tokens = data.tokens.map { it.toMutableList() }
                    cik = data.cik
                    compositeFigi = data.compositeFigi
                    cusip = data.cusip
                    description = data.description
                    displayName = data.displayName
                    logoUrl = data.logoUrl
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                /** ID of the `Stock` */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /**
                 * Whether the `Stock` allows for fractional trading. If it is not fractionable,
                 * Dinari only supports limit orders for the `Stock`.
                 */
                fun isFractionable(isFractionable: Boolean) =
                    isFractionable(JsonField.of(isFractionable))

                /**
                 * Sets [Builder.isFractionable] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isFractionable] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun isFractionable(isFractionable: JsonField<Boolean>) = apply {
                    this.isFractionable = isFractionable
                }

                /** Whether the `Stock` is available for trading. */
                fun isTradable(isTradable: Boolean) = isTradable(JsonField.of(isTradable))

                /**
                 * Sets [Builder.isTradable] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isTradable] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isTradable(isTradable: JsonField<Boolean>) = apply {
                    this.isTradable = isTradable
                }

                /** Company name */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Ticker symbol */
                fun symbol(symbol: String) = symbol(JsonField.of(symbol))

                /**
                 * Sets [Builder.symbol] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.symbol] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun symbol(symbol: JsonField<String>) = apply { this.symbol = symbol }

                /** List of CAIP-10 formatted token addresses. */
                fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

                /**
                 * Sets [Builder.tokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tokens] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tokens(tokens: JsonField<List<String>>) = apply {
                    this.tokens = tokens.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [tokens].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addToken(token: String) = apply {
                    tokens =
                        (tokens ?: JsonField.of(mutableListOf())).also {
                            checkKnown("tokens", it).add(token)
                        }
                }

                /**
                 * SEC Central Index Key. Refer to
                 * [this link](https://www.sec.gov/submit-filings/filer-support-resources/how-do-i-guides/understand-utilize-edgar-ciks-passphrases-access-codes)
                 * for more information.
                 */
                fun cik(cik: String?) = cik(JsonField.ofNullable(cik))

                /** Alias for calling [Builder.cik] with `cik.orElse(null)`. */
                fun cik(cik: Optional<String>) = cik(cik.getOrNull())

                /**
                 * Sets [Builder.cik] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cik] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun cik(cik: JsonField<String>) = apply { this.cik = cik }

                /**
                 * Composite FIGI ID. Refer to [this link](https://www.openfigi.com/about/figi) for
                 * more information.
                 */
                fun compositeFigi(compositeFigi: String?) =
                    compositeFigi(JsonField.ofNullable(compositeFigi))

                /** Alias for calling [Builder.compositeFigi] with `compositeFigi.orElse(null)`. */
                fun compositeFigi(compositeFigi: Optional<String>) =
                    compositeFigi(compositeFigi.getOrNull())

                /**
                 * Sets [Builder.compositeFigi] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.compositeFigi] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun compositeFigi(compositeFigi: JsonField<String>) = apply {
                    this.compositeFigi = compositeFigi
                }

                /**
                 * CUSIP ID. Refer to [this link](https://www.cusip.com/identifiers.html) for more
                 * information. A license agreement with CUSIP Global Services is required to
                 * receive this value.
                 */
                fun cusip(cusip: String?) = cusip(JsonField.ofNullable(cusip))

                /** Alias for calling [Builder.cusip] with `cusip.orElse(null)`. */
                fun cusip(cusip: Optional<String>) = cusip(cusip.getOrNull())

                /**
                 * Sets [Builder.cusip] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cusip] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun cusip(cusip: JsonField<String>) = apply { this.cusip = cusip }

                /** Description of the company and their services. */
                fun description(description: String?) =
                    description(JsonField.ofNullable(description))

                /** Alias for calling [Builder.description] with `description.orElse(null)`. */
                fun description(description: Optional<String>) =
                    description(description.getOrNull())

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /**
                 * Name of `Stock` for application display. If defined, this supercedes the `name`
                 * field for displaying the name.
                 */
                fun displayName(displayName: String?) =
                    displayName(JsonField.ofNullable(displayName))

                /** Alias for calling [Builder.displayName] with `displayName.orElse(null)`. */
                fun displayName(displayName: Optional<String>) =
                    displayName(displayName.getOrNull())

                /**
                 * Sets [Builder.displayName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.displayName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun displayName(displayName: JsonField<String>) = apply {
                    this.displayName = displayName
                }

                /** URL of the company's logo. Supported formats are SVG and PNG. */
                fun logoUrl(logoUrl: String?) = logoUrl(JsonField.ofNullable(logoUrl))

                /** Alias for calling [Builder.logoUrl] with `logoUrl.orElse(null)`. */
                fun logoUrl(logoUrl: Optional<String>) = logoUrl(logoUrl.getOrNull())

                /**
                 * Sets [Builder.logoUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.logoUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .isFractionable()
                 * .isTradable()
                 * .name()
                 * .symbol()
                 * .tokens()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Data =
                    Data(
                        checkRequired("id", id),
                        checkRequired("isFractionable", isFractionable),
                        checkRequired("isTradable", isTradable),
                        checkRequired("name", name),
                        checkRequired("symbol", symbol),
                        checkRequired("tokens", tokens).map { it.toImmutable() },
                        cik,
                        compositeFigi,
                        cusip,
                        description,
                        displayName,
                        logoUrl,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                id()
                isFractionable()
                isTradable()
                name()
                symbol()
                tokens()
                cik()
                compositeFigi()
                cusip()
                description()
                displayName()
                logoUrl()
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (isFractionable.asKnown().isPresent) 1 else 0) +
                    (if (isTradable.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (symbol.asKnown().isPresent) 1 else 0) +
                    (tokens.asKnown().getOrNull()?.size ?: 0) +
                    (if (cik.asKnown().isPresent) 1 else 0) +
                    (if (compositeFigi.asKnown().isPresent) 1 else 0) +
                    (if (cusip.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0) +
                    (if (displayName.asKnown().isPresent) 1 else 0) +
                    (if (logoUrl.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    id == other.id &&
                    isFractionable == other.isFractionable &&
                    isTradable == other.isTradable &&
                    name == other.name &&
                    symbol == other.symbol &&
                    tokens == other.tokens &&
                    cik == other.cik &&
                    compositeFigi == other.compositeFigi &&
                    cusip == other.cusip &&
                    description == other.description &&
                    displayName == other.displayName &&
                    logoUrl == other.logoUrl &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    isFractionable,
                    isTradable,
                    name,
                    symbol,
                    tokens,
                    cik,
                    compositeFigi,
                    cusip,
                    description,
                    displayName,
                    logoUrl,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{id=$id, isFractionable=$isFractionable, isTradable=$isTradable, name=$name, symbol=$symbol, tokens=$tokens, cik=$cik, compositeFigi=$compositeFigi, cusip=$cusip, description=$description, displayName=$displayName, logoUrl=$logoUrl, additionalProperties=$additionalProperties}"
        }

        /** Pagination metadata */
        class PaginationMetadata
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val next: JsonField<String>,
            private val previous: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("next") @ExcludeMissing next: JsonField<String> = JsonMissing.of(),
                @JsonProperty("previous")
                @ExcludeMissing
                previous: JsonField<String> = JsonMissing.of(),
            ) : this(next, previous, mutableMapOf())

            /**
             * Cursor for next page
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun next(): Optional<String> = next.getOptional("next")

            /**
             * Cursor for previous page
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun previous(): Optional<String> = previous.getOptional("previous")

            /**
             * Returns the raw JSON value of [next].
             *
             * Unlike [next], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("next") @ExcludeMissing fun _next(): JsonField<String> = next

            /**
             * Returns the raw JSON value of [previous].
             *
             * Unlike [previous], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("previous") @ExcludeMissing fun _previous(): JsonField<String> = previous

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
                 * Returns a mutable builder for constructing an instance of [PaginationMetadata].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [PaginationMetadata]. */
            class Builder internal constructor() {

                private var next: JsonField<String> = JsonMissing.of()
                private var previous: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(paginationMetadata: PaginationMetadata) = apply {
                    next = paginationMetadata.next
                    previous = paginationMetadata.previous
                    additionalProperties = paginationMetadata.additionalProperties.toMutableMap()
                }

                /** Cursor for next page */
                fun next(next: String) = next(JsonField.of(next))

                /**
                 * Sets [Builder.next] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.next] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun next(next: JsonField<String>) = apply { this.next = next }

                /** Cursor for previous page */
                fun previous(previous: String) = previous(JsonField.of(previous))

                /**
                 * Sets [Builder.previous] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.previous] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun previous(previous: JsonField<String>) = apply { this.previous = previous }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [PaginationMetadata].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): PaginationMetadata =
                    PaginationMetadata(next, previous, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): PaginationMetadata = apply {
                if (validated) {
                    return@apply
                }

                next()
                previous()
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
                (if (next.asKnown().isPresent) 1 else 0) +
                    (if (previous.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is PaginationMetadata &&
                    next == other.next &&
                    previous == other.previous &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(next, previous, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "PaginationMetadata{next=$next, previous=$previous, additionalProperties=$additionalProperties}"
        }

        /** Version */
        class _Sv @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val PAGINATED_STOCK_RESPONSE_V1 = of("PaginatedStockResponse:v1")

                @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
            }

            /** An enum containing [_Sv]'s known values. */
            enum class Known {
                PAGINATED_STOCK_RESPONSE_V1
            }

            /**
             * An enum containing [_Sv]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [_Sv] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                PAGINATED_STOCK_RESPONSE_V1,
                /** An enum member indicating that [_Sv] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    PAGINATED_STOCK_RESPONSE_V1 -> Value.PAGINATED_STOCK_RESPONSE_V1
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws DinariInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    PAGINATED_STOCK_RESPONSE_V1 -> Known.PAGINATED_STOCK_RESPONSE_V1
                    else -> throw DinariInvalidDataException("Unknown _Sv: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws DinariInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    DinariInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): _Sv = apply {
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

                return other is _Sv && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PaginatedStockResponse &&
                data == other.data &&
                paginationMetadata == other.paginationMetadata &&
                _sv == other._sv &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(data, paginationMetadata, _sv, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PaginatedStockResponse{data=$data, paginationMetadata=$paginationMetadata, _sv=$_sv, additionalProperties=$additionalProperties}"
    }
}
