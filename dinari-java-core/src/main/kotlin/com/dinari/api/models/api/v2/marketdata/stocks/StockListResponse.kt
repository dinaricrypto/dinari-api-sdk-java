// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.marketdata.stocks

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Information about stock available for trading. */
class StockListResponse
private constructor(
    private val id: JsonField<String>,
    private val isFractionable: JsonField<Boolean>,
    private val name: JsonField<String>,
    private val symbol: JsonField<String>,
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
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("symbol") @ExcludeMissing symbol: JsonField<String> = JsonMissing.of(),
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
        name,
        symbol,
        cik,
        compositeFigi,
        cusip,
        description,
        displayName,
        logoUrl,
        mutableMapOf(),
    )

    /**
     * Unique identifier for the stock
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Whether the stock allows for fractional trading. If it is not fractionable, Dinari only
     * supports limit orders for the stock.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isFractionable(): Boolean = isFractionable.getRequired("is_fractionable")

    /**
     * Stock Name
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * Ticker symbol of the stock
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun symbol(): String = symbol.getRequired("symbol")

    /**
     * SEC Central Index Key. Refer to
     * [this link](https://www.sec.gov/submit-filings/filer-support-resources/how-do-i-guides/understand-utilize-edgar-ciks-passphrases-access-codes)
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cik(): Optional<String> = cik.getOptional("cik")

    /**
     * Composite FIGI ID. Refer to [this link](https://www.openfigi.com/about/figi)
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun compositeFigi(): Optional<String> = compositeFigi.getOptional("composite_figi")

    /**
     * CUSIP ID. Refer to [this link](https://www.cusip.com/identifiers.html)
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cusip(): Optional<String> = cusip.getOptional("cusip")

    /**
     * Description of the company and what they do/offer.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * Name of Stock for application display
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun displayName(): Optional<String> = displayName.getOptional("display_name")

    /**
     * The URL of the logo of the stock. The preferred format is svg.
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
     * Unlike [isFractionable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_fractionable")
    @ExcludeMissing
    fun _isFractionable(): JsonField<Boolean> = isFractionable

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
     * Returns the raw JSON value of [cik].
     *
     * Unlike [cik], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cik") @ExcludeMissing fun _cik(): JsonField<String> = cik

    /**
     * Returns the raw JSON value of [compositeFigi].
     *
     * Unlike [compositeFigi], this method doesn't throw if the JSON field has an unexpected type.
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
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

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
         * Returns a mutable builder for constructing an instance of [StockListResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .isFractionable()
         * .name()
         * .symbol()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StockListResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var isFractionable: JsonField<Boolean>? = null
        private var name: JsonField<String>? = null
        private var symbol: JsonField<String>? = null
        private var cik: JsonField<String> = JsonMissing.of()
        private var compositeFigi: JsonField<String> = JsonMissing.of()
        private var cusip: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var logoUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(stockListResponse: StockListResponse) = apply {
            id = stockListResponse.id
            isFractionable = stockListResponse.isFractionable
            name = stockListResponse.name
            symbol = stockListResponse.symbol
            cik = stockListResponse.cik
            compositeFigi = stockListResponse.compositeFigi
            cusip = stockListResponse.cusip
            description = stockListResponse.description
            displayName = stockListResponse.displayName
            logoUrl = stockListResponse.logoUrl
            additionalProperties = stockListResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the stock */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * Whether the stock allows for fractional trading. If it is not fractionable, Dinari only
         * supports limit orders for the stock.
         */
        fun isFractionable(isFractionable: Boolean) = isFractionable(JsonField.of(isFractionable))

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

        /** Stock Name */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Ticker symbol of the stock */
        fun symbol(symbol: String) = symbol(JsonField.of(symbol))

        /**
         * Sets [Builder.symbol] to an arbitrary JSON value.
         *
         * You should usually call [Builder.symbol] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun symbol(symbol: JsonField<String>) = apply { this.symbol = symbol }

        /**
         * SEC Central Index Key. Refer to
         * [this link](https://www.sec.gov/submit-filings/filer-support-resources/how-do-i-guides/understand-utilize-edgar-ciks-passphrases-access-codes)
         */
        fun cik(cik: String?) = cik(JsonField.ofNullable(cik))

        /** Alias for calling [Builder.cik] with `cik.orElse(null)`. */
        fun cik(cik: Optional<String>) = cik(cik.getOrNull())

        /**
         * Sets [Builder.cik] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cik] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cik(cik: JsonField<String>) = apply { this.cik = cik }

        /** Composite FIGI ID. Refer to [this link](https://www.openfigi.com/about/figi) */
        fun compositeFigi(compositeFigi: String?) =
            compositeFigi(JsonField.ofNullable(compositeFigi))

        /** Alias for calling [Builder.compositeFigi] with `compositeFigi.orElse(null)`. */
        fun compositeFigi(compositeFigi: Optional<String>) =
            compositeFigi(compositeFigi.getOrNull())

        /**
         * Sets [Builder.compositeFigi] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compositeFigi] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun compositeFigi(compositeFigi: JsonField<String>) = apply {
            this.compositeFigi = compositeFigi
        }

        /** CUSIP ID. Refer to [this link](https://www.cusip.com/identifiers.html) */
        fun cusip(cusip: String?) = cusip(JsonField.ofNullable(cusip))

        /** Alias for calling [Builder.cusip] with `cusip.orElse(null)`. */
        fun cusip(cusip: Optional<String>) = cusip(cusip.getOrNull())

        /**
         * Sets [Builder.cusip] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cusip] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cusip(cusip: JsonField<String>) = apply { this.cusip = cusip }

        /** Description of the company and what they do/offer. */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Name of Stock for application display */
        fun displayName(displayName: String?) = displayName(JsonField.ofNullable(displayName))

        /** Alias for calling [Builder.displayName] with `displayName.orElse(null)`. */
        fun displayName(displayName: Optional<String>) = displayName(displayName.getOrNull())

        /**
         * Sets [Builder.displayName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayName(displayName: JsonField<String>) = apply { this.displayName = displayName }

        /** The URL of the logo of the stock. The preferred format is svg. */
        fun logoUrl(logoUrl: String?) = logoUrl(JsonField.ofNullable(logoUrl))

        /** Alias for calling [Builder.logoUrl] with `logoUrl.orElse(null)`. */
        fun logoUrl(logoUrl: Optional<String>) = logoUrl(logoUrl.getOrNull())

        /**
         * Sets [Builder.logoUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logoUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [StockListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .isFractionable()
         * .name()
         * .symbol()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StockListResponse =
            StockListResponse(
                checkRequired("id", id),
                checkRequired("isFractionable", isFractionable),
                checkRequired("name", name),
                checkRequired("symbol", symbol),
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

    fun validate(): StockListResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        isFractionable()
        name()
        symbol()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (isFractionable.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (symbol.asKnown().isPresent) 1 else 0) +
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

        return /* spotless:off */ other is StockListResponse && id == other.id && isFractionable == other.isFractionable && name == other.name && symbol == other.symbol && cik == other.cik && compositeFigi == other.compositeFigi && cusip == other.cusip && description == other.description && displayName == other.displayName && logoUrl == other.logoUrl && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, isFractionable, name, symbol, cik, compositeFigi, cusip, description, displayName, logoUrl, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StockListResponse{id=$id, isFractionable=$isFractionable, name=$name, symbol=$symbol, cik=$cik, compositeFigi=$compositeFigi, cusip=$cusip, description=$description, displayName=$displayName, logoUrl=$logoUrl, additionalProperties=$additionalProperties}"
}
