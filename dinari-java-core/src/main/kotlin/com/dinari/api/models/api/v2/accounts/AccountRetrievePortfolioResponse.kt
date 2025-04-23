// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkKnown
import com.dinari.api.core.checkRequired
import com.dinari.api.core.toImmutable
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** This is an object representing the balance of cash and stock assets in your account. */
class AccountRetrievePortfolioResponse
private constructor(
    private val assets: JsonField<List<Asset>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("assets") @ExcludeMissing assets: JsonField<List<Asset>> = JsonMissing.of()
    ) : this(assets, mutableMapOf())

    /**
     * Stock Balance details for all owned stocks
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun assets(): List<Asset> = assets.getRequired("assets")

    /**
     * Returns the raw JSON value of [assets].
     *
     * Unlike [assets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("assets") @ExcludeMissing fun _assets(): JsonField<List<Asset>> = assets

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
         * Returns a mutable builder for constructing an instance of
         * [AccountRetrievePortfolioResponse].
         *
         * The following fields are required:
         * ```java
         * .assets()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountRetrievePortfolioResponse]. */
    class Builder internal constructor() {

        private var assets: JsonField<MutableList<Asset>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountRetrievePortfolioResponse: AccountRetrievePortfolioResponse) =
            apply {
                assets = accountRetrievePortfolioResponse.assets.map { it.toMutableList() }
                additionalProperties =
                    accountRetrievePortfolioResponse.additionalProperties.toMutableMap()
            }

        /** Stock Balance details for all owned stocks */
        fun assets(assets: List<Asset>) = assets(JsonField.of(assets))

        /**
         * Sets [Builder.assets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.assets] with a well-typed `List<Asset>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun assets(assets: JsonField<List<Asset>>) = apply {
            this.assets = assets.map { it.toMutableList() }
        }

        /**
         * Adds a single [Asset] to [assets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAsset(asset: Asset) = apply {
            assets =
                (assets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("assets", it).add(asset)
                }
        }

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
         * Returns an immutable instance of [AccountRetrievePortfolioResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .assets()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountRetrievePortfolioResponse =
            AccountRetrievePortfolioResponse(
                checkRequired("assets", assets).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountRetrievePortfolioResponse = apply {
        if (validated) {
            return@apply
        }

        assets().forEach { it.validate() }
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
        (assets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Balance of a stock in the account */
    class Asset
    private constructor(
        private val amount: JsonField<Double>,
        private val marketValue: JsonField<Double>,
        private val stockId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("amount") @ExcludeMissing amount: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("market_value")
            @ExcludeMissing
            marketValue: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
        ) : this(amount, marketValue, stockId, mutableMapOf())

        /**
         * Total amount of the stock
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun amount(): Double = amount.getRequired("amount")

        /**
         * Total market value of the stock
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun marketValue(): Double = marketValue.getRequired("market_value")

        /**
         * ID of Stock
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun stockId(): String = stockId.getRequired("stock_id")

        /**
         * Returns the raw JSON value of [amount].
         *
         * Unlike [amount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<Double> = amount

        /**
         * Returns the raw JSON value of [marketValue].
         *
         * Unlike [marketValue], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("market_value")
        @ExcludeMissing
        fun _marketValue(): JsonField<Double> = marketValue

        /**
         * Returns the raw JSON value of [stockId].
         *
         * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

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
             * Returns a mutable builder for constructing an instance of [Asset].
             *
             * The following fields are required:
             * ```java
             * .amount()
             * .marketValue()
             * .stockId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Asset]. */
        class Builder internal constructor() {

            private var amount: JsonField<Double>? = null
            private var marketValue: JsonField<Double>? = null
            private var stockId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(asset: Asset) = apply {
                amount = asset.amount
                marketValue = asset.marketValue
                stockId = asset.stockId
                additionalProperties = asset.additionalProperties.toMutableMap()
            }

            /** Total amount of the stock */
            fun amount(amount: Double) = amount(JsonField.of(amount))

            /**
             * Sets [Builder.amount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.amount] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun amount(amount: JsonField<Double>) = apply { this.amount = amount }

            /** Total market value of the stock */
            fun marketValue(marketValue: Double) = marketValue(JsonField.of(marketValue))

            /**
             * Sets [Builder.marketValue] to an arbitrary JSON value.
             *
             * You should usually call [Builder.marketValue] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun marketValue(marketValue: JsonField<Double>) = apply {
                this.marketValue = marketValue
            }

            /** ID of Stock */
            fun stockId(stockId: String) = stockId(JsonField.of(stockId))

            /**
             * Sets [Builder.stockId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stockId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

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
             * Returns an immutable instance of [Asset].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .amount()
             * .marketValue()
             * .stockId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Asset =
                Asset(
                    checkRequired("amount", amount),
                    checkRequired("marketValue", marketValue),
                    checkRequired("stockId", stockId),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Asset = apply {
            if (validated) {
                return@apply
            }

            amount()
            marketValue()
            stockId()
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
            (if (amount.asKnown().isPresent) 1 else 0) +
                (if (marketValue.asKnown().isPresent) 1 else 0) +
                (if (stockId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Asset && amount == other.amount && marketValue == other.marketValue && stockId == other.stockId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(amount, marketValue, stockId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Asset{amount=$amount, marketValue=$marketValue, stockId=$stockId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AccountRetrievePortfolioResponse && assets == other.assets && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(assets, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountRetrievePortfolioResponse{assets=$assets, additionalProperties=$additionalProperties}"
}
