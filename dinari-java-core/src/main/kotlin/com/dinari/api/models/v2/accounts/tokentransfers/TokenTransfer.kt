// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.tokentransfers

import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.errors.DinariInvalidDataException
import com.dinari.api.models.v2.accounts.Chain
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Information about a token transfer between accounts. */
class TokenTransfer
private constructor(
    private val id: JsonField<String>,
    private val chainId: JsonField<Chain>,
    private val createdDt: JsonField<OffsetDateTime>,
    private val quantity: JsonField<Double>,
    private val recipientAccountId: JsonField<String>,
    private val senderAccountId: JsonField<String>,
    private val status: JsonField<Status>,
    private val tokenAddress: JsonField<String>,
    private val updatedDt: JsonField<OffsetDateTime>,
    private val transactionHash: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Chain> = JsonMissing.of(),
        @JsonProperty("created_dt")
        @ExcludeMissing
        createdDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("quantity") @ExcludeMissing quantity: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("recipient_account_id")
        @ExcludeMissing
        recipientAccountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sender_account_id")
        @ExcludeMissing
        senderAccountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("token_address")
        @ExcludeMissing
        tokenAddress: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_dt")
        @ExcludeMissing
        updatedDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("transaction_hash")
        @ExcludeMissing
        transactionHash: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        chainId,
        createdDt,
        quantity,
        recipientAccountId,
        senderAccountId,
        status,
        tokenAddress,
        updatedDt,
        transactionHash,
        mutableMapOf(),
    )

    /**
     * ID of the token transfer.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * CAIP-2 chain ID of the blockchain that the transfer is made on.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): Chain = chainId.getRequired("chain_id")

    /**
     * Datetime at which the transfer was created. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdDt(): OffsetDateTime = createdDt.getRequired("created_dt")

    /**
     * Quantity of the token being transferred.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun quantity(): Double = quantity.getRequired("quantity")

    /**
     * ID of the account to which the tokens are transferred.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipientAccountId(): String = recipientAccountId.getRequired("recipient_account_id")

    /**
     * ID of the account from which the tokens are transferred.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun senderAccountId(): String = senderAccountId.getRequired("sender_account_id")

    /**
     * Status of the token transfer.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Address of the token being transferred.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tokenAddress(): String = tokenAddress.getRequired("token_address")

    /**
     * Datetime at which the transfer was last updated. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedDt(): OffsetDateTime = updatedDt.getRequired("updated_dt")

    /**
     * Transaction hash of the transfer on the blockchain, if applicable. This is only present if
     * the transfer has been executed on-chain.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun transactionHash(): Optional<String> = transactionHash.getOptional("transaction_hash")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Chain> = chainId

    /**
     * Returns the raw JSON value of [createdDt].
     *
     * Unlike [createdDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_dt")
    @ExcludeMissing
    fun _createdDt(): JsonField<OffsetDateTime> = createdDt

    /**
     * Returns the raw JSON value of [quantity].
     *
     * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quantity") @ExcludeMissing fun _quantity(): JsonField<Double> = quantity

    /**
     * Returns the raw JSON value of [recipientAccountId].
     *
     * Unlike [recipientAccountId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("recipient_account_id")
    @ExcludeMissing
    fun _recipientAccountId(): JsonField<String> = recipientAccountId

    /**
     * Returns the raw JSON value of [senderAccountId].
     *
     * Unlike [senderAccountId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_account_id")
    @ExcludeMissing
    fun _senderAccountId(): JsonField<String> = senderAccountId

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [tokenAddress].
     *
     * Unlike [tokenAddress], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("token_address")
    @ExcludeMissing
    fun _tokenAddress(): JsonField<String> = tokenAddress

    /**
     * Returns the raw JSON value of [updatedDt].
     *
     * Unlike [updatedDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_dt")
    @ExcludeMissing
    fun _updatedDt(): JsonField<OffsetDateTime> = updatedDt

    /**
     * Returns the raw JSON value of [transactionHash].
     *
     * Unlike [transactionHash], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transaction_hash")
    @ExcludeMissing
    fun _transactionHash(): JsonField<String> = transactionHash

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
         * Returns a mutable builder for constructing an instance of [TokenTransfer].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .chainId()
         * .createdDt()
         * .quantity()
         * .recipientAccountId()
         * .senderAccountId()
         * .status()
         * .tokenAddress()
         * .updatedDt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TokenTransfer]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var chainId: JsonField<Chain>? = null
        private var createdDt: JsonField<OffsetDateTime>? = null
        private var quantity: JsonField<Double>? = null
        private var recipientAccountId: JsonField<String>? = null
        private var senderAccountId: JsonField<String>? = null
        private var status: JsonField<Status>? = null
        private var tokenAddress: JsonField<String>? = null
        private var updatedDt: JsonField<OffsetDateTime>? = null
        private var transactionHash: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tokenTransfer: TokenTransfer) = apply {
            id = tokenTransfer.id
            chainId = tokenTransfer.chainId
            createdDt = tokenTransfer.createdDt
            quantity = tokenTransfer.quantity
            recipientAccountId = tokenTransfer.recipientAccountId
            senderAccountId = tokenTransfer.senderAccountId
            status = tokenTransfer.status
            tokenAddress = tokenTransfer.tokenAddress
            updatedDt = tokenTransfer.updatedDt
            transactionHash = tokenTransfer.transactionHash
            additionalProperties = tokenTransfer.additionalProperties.toMutableMap()
        }

        /** ID of the token transfer. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** CAIP-2 chain ID of the blockchain that the transfer is made on. */
        fun chainId(chainId: Chain) = chainId(JsonField.of(chainId))

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [Chain] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<Chain>) = apply { this.chainId = chainId }

        /** Datetime at which the transfer was created. ISO 8601 timestamp. */
        fun createdDt(createdDt: OffsetDateTime) = createdDt(JsonField.of(createdDt))

        /**
         * Sets [Builder.createdDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdDt(createdDt: JsonField<OffsetDateTime>) = apply { this.createdDt = createdDt }

        /** Quantity of the token being transferred. */
        fun quantity(quantity: Double) = quantity(JsonField.of(quantity))

        /**
         * Sets [Builder.quantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quantity] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quantity(quantity: JsonField<Double>) = apply { this.quantity = quantity }

        /** ID of the account to which the tokens are transferred. */
        fun recipientAccountId(recipientAccountId: String) =
            recipientAccountId(JsonField.of(recipientAccountId))

        /**
         * Sets [Builder.recipientAccountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipientAccountId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recipientAccountId(recipientAccountId: JsonField<String>) = apply {
            this.recipientAccountId = recipientAccountId
        }

        /** ID of the account from which the tokens are transferred. */
        fun senderAccountId(senderAccountId: String) =
            senderAccountId(JsonField.of(senderAccountId))

        /**
         * Sets [Builder.senderAccountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderAccountId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun senderAccountId(senderAccountId: JsonField<String>) = apply {
            this.senderAccountId = senderAccountId
        }

        /** Status of the token transfer. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Address of the token being transferred. */
        fun tokenAddress(tokenAddress: String) = tokenAddress(JsonField.of(tokenAddress))

        /**
         * Sets [Builder.tokenAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tokenAddress] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tokenAddress(tokenAddress: JsonField<String>) = apply {
            this.tokenAddress = tokenAddress
        }

        /** Datetime at which the transfer was last updated. ISO 8601 timestamp. */
        fun updatedDt(updatedDt: OffsetDateTime) = updatedDt(JsonField.of(updatedDt))

        /**
         * Sets [Builder.updatedDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedDt(updatedDt: JsonField<OffsetDateTime>) = apply { this.updatedDt = updatedDt }

        /**
         * Transaction hash of the transfer on the blockchain, if applicable. This is only present
         * if the transfer has been executed on-chain.
         */
        fun transactionHash(transactionHash: String) =
            transactionHash(JsonField.of(transactionHash))

        /**
         * Sets [Builder.transactionHash] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transactionHash] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun transactionHash(transactionHash: JsonField<String>) = apply {
            this.transactionHash = transactionHash
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
         * Returns an immutable instance of [TokenTransfer].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .chainId()
         * .createdDt()
         * .quantity()
         * .recipientAccountId()
         * .senderAccountId()
         * .status()
         * .tokenAddress()
         * .updatedDt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TokenTransfer =
            TokenTransfer(
                checkRequired("id", id),
                checkRequired("chainId", chainId),
                checkRequired("createdDt", createdDt),
                checkRequired("quantity", quantity),
                checkRequired("recipientAccountId", recipientAccountId),
                checkRequired("senderAccountId", senderAccountId),
                checkRequired("status", status),
                checkRequired("tokenAddress", tokenAddress),
                checkRequired("updatedDt", updatedDt),
                transactionHash,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TokenTransfer = apply {
        if (validated) {
            return@apply
        }

        id()
        chainId().validate()
        createdDt()
        quantity()
        recipientAccountId()
        senderAccountId()
        status().validate()
        tokenAddress()
        updatedDt()
        transactionHash()
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
            (chainId.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdDt.asKnown().isPresent) 1 else 0) +
            (if (quantity.asKnown().isPresent) 1 else 0) +
            (if (recipientAccountId.asKnown().isPresent) 1 else 0) +
            (if (senderAccountId.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (tokenAddress.asKnown().isPresent) 1 else 0) +
            (if (updatedDt.asKnown().isPresent) 1 else 0) +
            (if (transactionHash.asKnown().isPresent) 1 else 0)

    /** Status of the token transfer. */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PENDING = of("PENDING")

            @JvmField val IN_PROGRESS = of("IN_PROGRESS")

            @JvmField val COMPLETE = of("COMPLETE")

            @JvmField val FAILED = of("FAILED")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PENDING,
            IN_PROGRESS,
            COMPLETE,
            FAILED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PENDING,
            IN_PROGRESS,
            COMPLETE,
            FAILED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                PENDING -> Value.PENDING
                IN_PROGRESS -> Value.IN_PROGRESS
                COMPLETE -> Value.COMPLETE
                FAILED -> Value.FAILED
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
                PENDING -> Known.PENDING
                IN_PROGRESS -> Known.IN_PROGRESS
                COMPLETE -> Known.COMPLETE
                FAILED -> Known.FAILED
                else -> throw DinariInvalidDataException("Unknown Status: $value")
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

        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TokenTransfer &&
            id == other.id &&
            chainId == other.chainId &&
            createdDt == other.createdDt &&
            quantity == other.quantity &&
            recipientAccountId == other.recipientAccountId &&
            senderAccountId == other.senderAccountId &&
            status == other.status &&
            tokenAddress == other.tokenAddress &&
            updatedDt == other.updatedDt &&
            transactionHash == other.transactionHash &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            chainId,
            createdDt,
            quantity,
            recipientAccountId,
            senderAccountId,
            status,
            tokenAddress,
            updatedDt,
            transactionHash,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TokenTransfer{id=$id, chainId=$chainId, createdDt=$createdDt, quantity=$quantity, recipientAccountId=$recipientAccountId, senderAccountId=$senderAccountId, status=$status, tokenAddress=$tokenAddress, updatedDt=$updatedDt, transactionHash=$transactionHash, additionalProperties=$additionalProperties}"
}
