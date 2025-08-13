// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders.stocks.eip155

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

/** Prepared transactions to place an order on an EIP-155 (EVM) chain. */
class Eip155PrepareOrderResponse
private constructor(
    private val fees: JsonField<List<OrderFeeAmount>>,
    private val transactionData: JsonField<List<TransactionData>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("fees")
        @ExcludeMissing
        fees: JsonField<List<OrderFeeAmount>> = JsonMissing.of(),
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
    fun fees(): List<OrderFeeAmount> = fees.getRequired("fees")

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
    @JsonProperty("fees") @ExcludeMissing fun _fees(): JsonField<List<OrderFeeAmount>> = fees

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

        private var fees: JsonField<MutableList<OrderFeeAmount>>? = null
        private var transactionData: JsonField<MutableList<TransactionData>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eip155PrepareOrderResponse: Eip155PrepareOrderResponse) = apply {
            fees = eip155PrepareOrderResponse.fees.map { it.toMutableList() }
            transactionData = eip155PrepareOrderResponse.transactionData.map { it.toMutableList() }
            additionalProperties = eip155PrepareOrderResponse.additionalProperties.toMutableMap()
        }

        /** Fees included in the order transaction. Provided here as a reference. */
        fun fees(fees: List<OrderFeeAmount>) = fees(JsonField.of(fees))

        /**
         * Sets [Builder.fees] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fees] with a well-typed `List<OrderFeeAmount>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fees(fees: JsonField<List<OrderFeeAmount>>) = apply {
            this.fees = fees.map { it.toMutableList() }
        }

        /**
         * Adds a single [OrderFeeAmount] to [fees].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFee(fee: OrderFeeAmount) = apply {
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

            return other is TransactionData &&
                abi == other.abi &&
                args == other.args &&
                contractAddress == other.contractAddress &&
                data == other.data &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(abi, args, contractAddress, data, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TransactionData{abi=$abi, args=$args, contractAddress=$contractAddress, data=$data, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Eip155PrepareOrderResponse &&
            fees == other.fees &&
            transactionData == other.transactionData &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(fees, transactionData, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Eip155PrepareOrderResponse{fees=$fees, transactionData=$transactionData, additionalProperties=$additionalProperties}"
}
