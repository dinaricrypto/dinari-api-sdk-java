// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

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

class Eip155CreatePermitTransactionResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val abi: JsonValue,
    private val args: JsonValue,
    private val contractAddress: JsonField<String>,
    private val data: JsonField<String>,
    private val value: JsonField<String>,
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
        @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
    ) : this(abi, args, contractAddress, data, value, mutableMapOf())

    /**
     * [JSON ABI](https://docs.soliditylang.org/en/v0.8.30/abi-spec.html#json) of the smart contract
     * function encoded in the transaction. Provided for informational purposes.
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
     * Transaction value estimate in Wei.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun value(): String = value.getRequired("value")

    /**
     * Returns the raw JSON value of [contractAddress].
     *
     * Unlike [contractAddress], this method doesn't throw if the JSON field has an unexpected type.
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

    /**
     * Returns the raw JSON value of [value].
     *
     * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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
         * [Eip155CreatePermitTransactionResponse].
         *
         * The following fields are required:
         * ```java
         * .abi()
         * .args()
         * .contractAddress()
         * .data()
         * .value()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155CreatePermitTransactionResponse]. */
    class Builder internal constructor() {

        private var abi: JsonValue? = null
        private var args: JsonValue? = null
        private var contractAddress: JsonField<String>? = null
        private var data: JsonField<String>? = null
        private var value: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            eip155CreatePermitTransactionResponse: Eip155CreatePermitTransactionResponse
        ) = apply {
            abi = eip155CreatePermitTransactionResponse.abi
            args = eip155CreatePermitTransactionResponse.args
            contractAddress = eip155CreatePermitTransactionResponse.contractAddress
            data = eip155CreatePermitTransactionResponse.data
            value = eip155CreatePermitTransactionResponse.value
            additionalProperties =
                eip155CreatePermitTransactionResponse.additionalProperties.toMutableMap()
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
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<String>) = apply { this.data = data }

        /** Transaction value estimate in Wei. */
        fun value(value: String) = value(JsonField.of(value))

        /**
         * Sets [Builder.value] to an arbitrary JSON value.
         *
         * You should usually call [Builder.value] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun value(value: JsonField<String>) = apply { this.value = value }

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
         * Returns an immutable instance of [Eip155CreatePermitTransactionResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .abi()
         * .args()
         * .contractAddress()
         * .data()
         * .value()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155CreatePermitTransactionResponse =
            Eip155CreatePermitTransactionResponse(
                checkRequired("abi", abi),
                checkRequired("args", args),
                checkRequired("contractAddress", contractAddress),
                checkRequired("data", data),
                checkRequired("value", value),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Eip155CreatePermitTransactionResponse = apply {
        if (validated) {
            return@apply
        }

        contractAddress()
        data()
        value()
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
        (if (contractAddress.asKnown().isPresent) 1 else 0) +
            (if (data.asKnown().isPresent) 1 else 0) +
            (if (value.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Eip155CreatePermitTransactionResponse &&
            abi == other.abi &&
            args == other.args &&
            contractAddress == other.contractAddress &&
            data == other.data &&
            value == other.value &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(abi, args, contractAddress, data, value, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Eip155CreatePermitTransactionResponse{abi=$abi, args=$args, contractAddress=$contractAddress, data=$data, value=$value, additionalProperties=$additionalProperties}"
}
