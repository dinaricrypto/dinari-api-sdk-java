// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts

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

/** Balance information of `Stock` assets in your `Account`. */
class AccountGetPortfolioResponse
private constructor(
    private val assets: JsonField<List<Asset>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("assets") @ExcludeMissing assets: JsonField<List<Asset>> = JsonMissing.of()
    ) : this(assets, mutableMapOf())

    /**
     * Balance details for all owned `Stocks`.
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
         * Returns a mutable builder for constructing an instance of [AccountGetPortfolioResponse].
         *
         * The following fields are required:
         * ```java
         * .assets()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountGetPortfolioResponse]. */
    class Builder internal constructor() {

        private var assets: JsonField<MutableList<Asset>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountGetPortfolioResponse: AccountGetPortfolioResponse) = apply {
            assets = accountGetPortfolioResponse.assets.map { it.toMutableList() }
            additionalProperties = accountGetPortfolioResponse.additionalProperties.toMutableMap()
        }

        /** Balance details for all owned `Stocks`. */
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
         * Returns an immutable instance of [AccountGetPortfolioResponse].
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
        fun build(): AccountGetPortfolioResponse =
            AccountGetPortfolioResponse(
                checkRequired("assets", assets).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountGetPortfolioResponse = apply {
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

    /** Balance of a dShare in an `Account`. */
    class Asset
    private constructor(
        private val amount: JsonField<Double>,
        private val chainId: JsonField<Chain>,
        private val stockId: JsonField<String>,
        private val symbol: JsonField<String>,
        private val tokenAddress: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("amount") @ExcludeMissing amount: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Chain> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("symbol") @ExcludeMissing symbol: JsonField<String> = JsonMissing.of(),
            @JsonProperty("token_address")
            @ExcludeMissing
            tokenAddress: JsonField<String> = JsonMissing.of(),
        ) : this(amount, chainId, stockId, symbol, tokenAddress, mutableMapOf())

        /**
         * Total amount of the dShare asset token in the `Account`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun amount(): Double = amount.getRequired("amount")

        /**
         * CAIP-2 chain ID of the blockchain where the dShare asset token exists.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun chainId(): Chain = chainId.getRequired("chain_id")

        /**
         * ID of the underlying `Stock` represented by the dShare asset token.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun stockId(): String = stockId.getRequired("stock_id")

        /**
         * Token symbol of the dShare asset token.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun symbol(): String = symbol.getRequired("symbol")

        /**
         * Address of the dShare asset token.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun tokenAddress(): String = tokenAddress.getRequired("token_address")

        /**
         * Returns the raw JSON value of [amount].
         *
         * Unlike [amount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<Double> = amount

        /**
         * Returns the raw JSON value of [chainId].
         *
         * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Chain> = chainId

        /**
         * Returns the raw JSON value of [stockId].
         *
         * Unlike [stockId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stock_id") @ExcludeMissing fun _stockId(): JsonField<String> = stockId

        /**
         * Returns the raw JSON value of [symbol].
         *
         * Unlike [symbol], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("symbol") @ExcludeMissing fun _symbol(): JsonField<String> = symbol

        /**
         * Returns the raw JSON value of [tokenAddress].
         *
         * Unlike [tokenAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("token_address")
        @ExcludeMissing
        fun _tokenAddress(): JsonField<String> = tokenAddress

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
             * .chainId()
             * .stockId()
             * .symbol()
             * .tokenAddress()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Asset]. */
        class Builder internal constructor() {

            private var amount: JsonField<Double>? = null
            private var chainId: JsonField<Chain>? = null
            private var stockId: JsonField<String>? = null
            private var symbol: JsonField<String>? = null
            private var tokenAddress: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(asset: Asset) = apply {
                amount = asset.amount
                chainId = asset.chainId
                stockId = asset.stockId
                symbol = asset.symbol
                tokenAddress = asset.tokenAddress
                additionalProperties = asset.additionalProperties.toMutableMap()
            }

            /** Total amount of the dShare asset token in the `Account`. */
            fun amount(amount: Double) = amount(JsonField.of(amount))

            /**
             * Sets [Builder.amount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.amount] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun amount(amount: JsonField<Double>) = apply { this.amount = amount }

            /** CAIP-2 chain ID of the blockchain where the dShare asset token exists. */
            fun chainId(chainId: Chain) = chainId(JsonField.of(chainId))

            /**
             * Sets [Builder.chainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chainId] with a well-typed [Chain] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun chainId(chainId: JsonField<Chain>) = apply { this.chainId = chainId }

            /** ID of the underlying `Stock` represented by the dShare asset token. */
            fun stockId(stockId: String) = stockId(JsonField.of(stockId))

            /**
             * Sets [Builder.stockId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stockId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

            /** Token symbol of the dShare asset token. */
            fun symbol(symbol: String) = symbol(JsonField.of(symbol))

            /**
             * Sets [Builder.symbol] to an arbitrary JSON value.
             *
             * You should usually call [Builder.symbol] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun symbol(symbol: JsonField<String>) = apply { this.symbol = symbol }

            /** Address of the dShare asset token. */
            fun tokenAddress(tokenAddress: String) = tokenAddress(JsonField.of(tokenAddress))

            /**
             * Sets [Builder.tokenAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tokenAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tokenAddress(tokenAddress: JsonField<String>) = apply {
                this.tokenAddress = tokenAddress
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
             * Returns an immutable instance of [Asset].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .amount()
             * .chainId()
             * .stockId()
             * .symbol()
             * .tokenAddress()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Asset =
                Asset(
                    checkRequired("amount", amount),
                    checkRequired("chainId", chainId),
                    checkRequired("stockId", stockId),
                    checkRequired("symbol", symbol),
                    checkRequired("tokenAddress", tokenAddress),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Asset = apply {
            if (validated) {
                return@apply
            }

            amount()
            chainId().validate()
            stockId()
            symbol()
            tokenAddress()
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
                (chainId.asKnown().getOrNull()?.validity() ?: 0) +
                (if (stockId.asKnown().isPresent) 1 else 0) +
                (if (symbol.asKnown().isPresent) 1 else 0) +
                (if (tokenAddress.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Asset && amount == other.amount && chainId == other.chainId && stockId == other.stockId && symbol == other.symbol && tokenAddress == other.tokenAddress && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(amount, chainId, stockId, symbol, tokenAddress, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Asset{amount=$amount, chainId=$chainId, stockId=$stockId, symbol=$symbol, tokenAddress=$tokenAddress, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AccountGetPortfolioResponse && assets == other.assets && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(assets, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountGetPortfolioResponse{assets=$assets, additionalProperties=$additionalProperties}"
}
