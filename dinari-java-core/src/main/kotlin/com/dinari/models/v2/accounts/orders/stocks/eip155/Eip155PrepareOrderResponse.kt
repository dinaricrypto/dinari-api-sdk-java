// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts.orders.stocks.eip155

import com.dinari.core.Enum
import com.dinari.core.ExcludeMissing
import com.dinari.core.JsonField
import com.dinari.core.JsonMissing
import com.dinari.core.JsonValue
import com.dinari.core.checkKnown
import com.dinari.core.checkRequired
import com.dinari.core.toImmutable
import com.dinari.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Prepared transactions to place an order on an EIP-155 (EVM) chain. */
class Eip155PrepareOrderResponse
private constructor(
    private val fees: JsonField<List<Fee>>,
    private val transactionData: JsonField<List<TransactionData>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("fees") @ExcludeMissing fees: JsonField<List<Fee>> = JsonMissing.of(),
        @JsonProperty("transaction_data")
        @ExcludeMissing
        transactionData: JsonField<List<TransactionData>> = JsonMissing.of(),
    ) : this(fees, transactionData, mutableMapOf())

    /**
     * Fees included in the order transaction. Provided here as a reference.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fees(): List<Fee> = fees.getRequired("fees")

    /**
     * List of contract addresses and call data for building transactions to be signed and submitted
     * on chain. Transactions should be submitted on chain in the order provided in this property.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transactionData(): List<TransactionData> = transactionData.getRequired("transaction_data")

    /**
     * Returns the raw JSON value of [fees].
     *
     * Unlike [fees], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fees") @ExcludeMissing fun _fees(): JsonField<List<Fee>> = fees

    /**
     * Returns the raw JSON value of [transactionData].
     *
     * Unlike [transactionData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transaction_data")
    @ExcludeMissing
    fun _transactionData(): JsonField<List<TransactionData>> = transactionData

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
         * Returns a mutable builder for constructing an instance of [Eip155PrepareOrderResponse].
         *
         * The following fields are required:
         * ```java
         * .fees()
         * .transactionData()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155PrepareOrderResponse]. */
    class Builder internal constructor() {

        private var fees: JsonField<MutableList<Fee>>? = null
        private var transactionData: JsonField<MutableList<TransactionData>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eip155PrepareOrderResponse: Eip155PrepareOrderResponse) = apply {
            fees = eip155PrepareOrderResponse.fees.map { it.toMutableList() }
            transactionData = eip155PrepareOrderResponse.transactionData.map { it.toMutableList() }
            additionalProperties = eip155PrepareOrderResponse.additionalProperties.toMutableMap()
        }

        /** Fees included in the order transaction. Provided here as a reference. */
        fun fees(fees: List<Fee>) = fees(JsonField.of(fees))

        /**
         * Sets [Builder.fees] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fees] with a well-typed `List<Fee>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fees(fees: JsonField<List<Fee>>) = apply { this.fees = fees.map { it.toMutableList() } }

        /**
         * Adds a single [Fee] to [fees].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFee(fee: Fee) = apply {
            fees = (fees ?: JsonField.of(mutableListOf())).also { checkKnown("fees", it).add(fee) }
        }

        /**
         * List of contract addresses and call data for building transactions to be signed and
         * submitted on chain. Transactions should be submitted on chain in the order provided in
         * this property.
         */
        fun transactionData(transactionData: List<TransactionData>) =
            transactionData(JsonField.of(transactionData))

        /**
         * Sets [Builder.transactionData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transactionData] with a well-typed
         * `List<TransactionData>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun transactionData(transactionData: JsonField<List<TransactionData>>) = apply {
            this.transactionData = transactionData.map { it.toMutableList() }
        }

        /**
         * Adds a single [TransactionData] to [Builder.transactionData].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTransactionData(transactionData: TransactionData) = apply {
            this.transactionData =
                (this.transactionData ?: JsonField.of(mutableListOf())).also {
                    checkKnown("transactionData", it).add(transactionData)
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
         * Returns an immutable instance of [Eip155PrepareOrderResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .fees()
         * .transactionData()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155PrepareOrderResponse =
            Eip155PrepareOrderResponse(
                checkRequired("fees", fees).map { it.toImmutable() },
                checkRequired("transactionData", transactionData).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Eip155PrepareOrderResponse = apply {
        if (validated) {
            return@apply
        }

        fees().forEach { it.validate() }
        transactionData().forEach { it.validate() }
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
        (fees.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (transactionData.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Fee
    private constructor(
        private val feeInEth: JsonField<Double>,
        private val feeInWei: JsonField<String>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("fee_in_eth")
            @ExcludeMissing
            feeInEth: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("fee_in_wei")
            @ExcludeMissing
            feeInWei: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(feeInEth, feeInWei, type, mutableMapOf())

        /**
         * The quantity of the fee paid via payment token in
         * [ETH](https://ethereum.org/en/developers/docs/intro-to-ether/#what-is-ether).
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun feeInEth(): Double = feeInEth.getRequired("fee_in_eth")

        /**
         * The quantity of the fee paid via payment token in
         * [wei](https://ethereum.org/en/developers/docs/intro-to-ether/#denominations).
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun feeInWei(): String = feeInWei.getRequired("fee_in_wei")

        /**
         * Type of fee.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * Returns the raw JSON value of [feeInEth].
         *
         * Unlike [feeInEth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fee_in_eth") @ExcludeMissing fun _feeInEth(): JsonField<Double> = feeInEth

        /**
         * Returns the raw JSON value of [feeInWei].
         *
         * Unlike [feeInWei], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fee_in_wei") @ExcludeMissing fun _feeInWei(): JsonField<String> = feeInWei

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
             * Returns a mutable builder for constructing an instance of [Fee].
             *
             * The following fields are required:
             * ```java
             * .feeInEth()
             * .feeInWei()
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Fee]. */
        class Builder internal constructor() {

            private var feeInEth: JsonField<Double>? = null
            private var feeInWei: JsonField<String>? = null
            private var type: JsonField<Type>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fee: Fee) = apply {
                feeInEth = fee.feeInEth
                feeInWei = fee.feeInWei
                type = fee.type
                additionalProperties = fee.additionalProperties.toMutableMap()
            }

            /**
             * The quantity of the fee paid via payment token in
             * [ETH](https://ethereum.org/en/developers/docs/intro-to-ether/#what-is-ether).
             */
            fun feeInEth(feeInEth: Double) = feeInEth(JsonField.of(feeInEth))

            /**
             * Sets [Builder.feeInEth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.feeInEth] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun feeInEth(feeInEth: JsonField<Double>) = apply { this.feeInEth = feeInEth }

            /**
             * The quantity of the fee paid via payment token in
             * [wei](https://ethereum.org/en/developers/docs/intro-to-ether/#denominations).
             */
            fun feeInWei(feeInWei: String) = feeInWei(JsonField.of(feeInWei))

            /**
             * Sets [Builder.feeInWei] to an arbitrary JSON value.
             *
             * You should usually call [Builder.feeInWei] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun feeInWei(feeInWei: JsonField<String>) = apply { this.feeInWei = feeInWei }

            /** Type of fee. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             * Returns an immutable instance of [Fee].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .feeInEth()
             * .feeInWei()
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Fee =
                Fee(
                    checkRequired("feeInEth", feeInEth),
                    checkRequired("feeInWei", feeInWei),
                    checkRequired("type", type),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Fee = apply {
            if (validated) {
                return@apply
            }

            feeInEth()
            feeInWei()
            type().validate()
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
            (if (feeInEth.asKnown().isPresent) 1 else 0) +
                (if (feeInWei.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /** Type of fee. */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val SPONSORED_NETWORK = of("SPONSORED_NETWORK")

                @JvmField val NETWORK = of("NETWORK")

                @JvmField val TRADING = of("TRADING")

                @JvmField val ORDER = of("ORDER")

                @JvmField val PARTNER_ORDER = of("PARTNER_ORDER")

                @JvmField val PARTNER_TRADING = of("PARTNER_TRADING")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                SPONSORED_NETWORK,
                NETWORK,
                TRADING,
                ORDER,
                PARTNER_ORDER,
                PARTNER_TRADING,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SPONSORED_NETWORK,
                NETWORK,
                TRADING,
                ORDER,
                PARTNER_ORDER,
                PARTNER_TRADING,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    SPONSORED_NETWORK -> Value.SPONSORED_NETWORK
                    NETWORK -> Value.NETWORK
                    TRADING -> Value.TRADING
                    ORDER -> Value.ORDER
                    PARTNER_ORDER -> Value.PARTNER_ORDER
                    PARTNER_TRADING -> Value.PARTNER_TRADING
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
                    SPONSORED_NETWORK -> Known.SPONSORED_NETWORK
                    NETWORK -> Known.NETWORK
                    TRADING -> Known.TRADING
                    ORDER -> Known.ORDER
                    PARTNER_ORDER -> Known.PARTNER_ORDER
                    PARTNER_TRADING -> Known.PARTNER_TRADING
                    else -> throw DinariInvalidDataException("Unknown Type: $value")
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

            fun validate(): Type = apply {
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

                return /* spotless:off */ other is Type && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Fee && feeInEth == other.feeInEth && feeInWei == other.feeInWei && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(feeInEth, feeInWei, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Fee{feeInEth=$feeInEth, feeInWei=$feeInWei, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * Information about a transaction to be signed with a wallet and submitted on chain.
     *
     * Typically the transactions will include an ERC20 approval transaction to allow the Dinari
     * smart contract to spend the payment token or Dshare asset tokens on behalf of the user,
     * followed by a transaction to call the Dinari smart contract to create an `Order`.
     */
    class TransactionData
    private constructor(
        private val abi: JsonValue,
        private val args: JsonValue,
        private val contractAddress: JsonField<String>,
        private val data: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("abi") @ExcludeMissing abi: JsonValue = JsonMissing.of(),
            @JsonProperty("args") @ExcludeMissing args: JsonValue = JsonMissing.of(),
            @JsonProperty("contract_address")
            @ExcludeMissing
            contractAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<String> = JsonMissing.of(),
        ) : this(abi, args, contractAddress, data, mutableMapOf())

        /**
         * [JSON ABI](https://docs.soliditylang.org/en/v0.8.30/abi-spec.html#json) of the smart
         * contract function encoded in the transaction. Provided for informational purposes.
         */
        @JsonProperty("abi") @ExcludeMissing fun _abi(): JsonValue = abi

        /**
         * Arguments to the smart contract function encoded in the transaction. Provided for
         * informational purposes.
         */
        @JsonProperty("args") @ExcludeMissing fun _args(): JsonValue = args

        /**
         * Smart contract address that the transaction should call.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contractAddress(): String = contractAddress.getRequired("contract_address")

        /**
         * Hex-encoded function call.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): String = data.getRequired("data")

        /**
         * Returns the raw JSON value of [contractAddress].
         *
         * Unlike [contractAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("contract_address")
        @ExcludeMissing
        fun _contractAddress(): JsonField<String> = contractAddress

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

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
             * Returns a mutable builder for constructing an instance of [TransactionData].
             *
             * The following fields are required:
             * ```java
             * .abi()
             * .args()
             * .contractAddress()
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TransactionData]. */
        class Builder internal constructor() {

            private var abi: JsonValue? = null
            private var args: JsonValue? = null
            private var contractAddress: JsonField<String>? = null
            private var data: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(transactionData: TransactionData) = apply {
                abi = transactionData.abi
                args = transactionData.args
                contractAddress = transactionData.contractAddress
                data = transactionData.data
                additionalProperties = transactionData.additionalProperties.toMutableMap()
            }

            /**
             * [JSON ABI](https://docs.soliditylang.org/en/v0.8.30/abi-spec.html#json) of the smart
             * contract function encoded in the transaction. Provided for informational purposes.
             */
            fun abi(abi: JsonValue) = apply { this.abi = abi }

            /**
             * Arguments to the smart contract function encoded in the transaction. Provided for
             * informational purposes.
             */
            fun args(args: JsonValue) = apply { this.args = args }

            /** Smart contract address that the transaction should call. */
            fun contractAddress(contractAddress: String) =
                contractAddress(JsonField.of(contractAddress))

            /**
             * Sets [Builder.contractAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contractAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contractAddress(contractAddress: JsonField<String>) = apply {
                this.contractAddress = contractAddress
            }

            /** Hex-encoded function call. */
            fun data(data: String) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<String>) = apply { this.data = data }

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
             * Returns an immutable instance of [TransactionData].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .abi()
             * .args()
             * .contractAddress()
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TransactionData =
                TransactionData(
                    checkRequired("abi", abi),
                    checkRequired("args", args),
                    checkRequired("contractAddress", contractAddress),
                    checkRequired("data", data),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): TransactionData = apply {
            if (validated) {
                return@apply
            }

            contractAddress()
            data()
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
            (if (contractAddress.asKnown().isPresent) 1 else 0) +
                (if (data.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TransactionData && abi == other.abi && args == other.args && contractAddress == other.contractAddress && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(abi, args, contractAddress, data, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TransactionData{abi=$abi, args=$args, contractAddress=$contractAddress, data=$data, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Eip155PrepareOrderResponse && fees == other.fees && transactionData == other.transactionData && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(fees, transactionData, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Eip155PrepareOrderResponse{fees=$fees, transactionData=$transactionData, additionalProperties=$additionalProperties}"
}
