// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawals

import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.errors.DinariInvalidDataException
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.BrokerageOrderStatus
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * Information for a withdrawal of payment tokens from an `Account` backed by a Dinari-managed
 * `Wallet`.
 */
class Withdrawal
private constructor(
    private val id: JsonField<String>,
    private val accountId: JsonField<String>,
    private val chainId: JsonField<Chain>,
    private val paymentTokenAddress: JsonField<String>,
    private val paymentTokenAmount: JsonField<Double>,
    private val recipientAccountId: JsonField<String>,
    private val status: JsonField<BrokerageOrderStatus>,
    private val transactionDt: JsonField<OffsetDateTime>,
    private val transactionHash: JsonField<String>,
    private val withdrawalRequestId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<Chain> = JsonMissing.of(),
        @JsonProperty("payment_token_address")
        @ExcludeMissing
        paymentTokenAddress: JsonField<String> = JsonMissing.of(),
        @JsonProperty("payment_token_amount")
        @ExcludeMissing
        paymentTokenAmount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("recipient_account_id")
        @ExcludeMissing
        recipientAccountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        status: JsonField<BrokerageOrderStatus> = JsonMissing.of(),
        @JsonProperty("transaction_dt")
        @ExcludeMissing
        transactionDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("transaction_hash")
        @ExcludeMissing
        transactionHash: JsonField<String> = JsonMissing.of(),
        @JsonProperty("withdrawal_request_id")
        @ExcludeMissing
        withdrawalRequestId: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        accountId,
        chainId,
        paymentTokenAddress,
        paymentTokenAmount,
        recipientAccountId,
        status,
        transactionDt,
        transactionHash,
        withdrawalRequestId,
        mutableMapOf(),
    )

    /**
     * ID of the `Withdrawal`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * ID of the `Account` from which the `Withdrawal` is made.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun accountId(): String = accountId.getRequired("account_id")

    /**
     * CAIP-2 chain ID of the blockchain where the `Withdrawal` is made.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chainId(): Chain = chainId.getRequired("chain_id")

    /**
     * Address of USDC payment token that the `Withdrawal` will be received in.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentTokenAddress(): String = paymentTokenAddress.getRequired("payment_token_address")

    /**
     * Amount of USDC payment tokens to be withdrawn.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentTokenAmount(): Double = paymentTokenAmount.getRequired("payment_token_amount")

    /**
     * ID of the `Account` that will receive payment tokens from the `Withdrawal`. This `Account`
     * must be connected to a non-managed `Wallet` and belong to the same `Entity`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipientAccountId(): String = recipientAccountId.getRequired("recipient_account_id")

    /**
     * Status of the `Withdrawal`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): BrokerageOrderStatus = status.getRequired("status")

    /**
     * Datetime at which the `Withdrawal` was transacted. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transactionDt(): OffsetDateTime = transactionDt.getRequired("transaction_dt")

    /**
     * Hash of the transaction for the `Withdrawal`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transactionHash(): String = transactionHash.getRequired("transaction_hash")

    /**
     * ID of the `WithdrawalRequest` associated with this `Withdrawal`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun withdrawalRequestId(): String = withdrawalRequestId.getRequired("withdrawal_request_id")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [accountId].
     *
     * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account_id") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

    /**
     * Returns the raw JSON value of [chainId].
     *
     * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<Chain> = chainId

    /**
     * Returns the raw JSON value of [paymentTokenAddress].
     *
     * Unlike [paymentTokenAddress], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("payment_token_address")
    @ExcludeMissing
    fun _paymentTokenAddress(): JsonField<String> = paymentTokenAddress

    /**
     * Returns the raw JSON value of [paymentTokenAmount].
     *
     * Unlike [paymentTokenAmount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("payment_token_amount")
    @ExcludeMissing
    fun _paymentTokenAmount(): JsonField<Double> = paymentTokenAmount

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
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<BrokerageOrderStatus> = status

    /**
     * Returns the raw JSON value of [transactionDt].
     *
     * Unlike [transactionDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transaction_dt")
    @ExcludeMissing
    fun _transactionDt(): JsonField<OffsetDateTime> = transactionDt

    /**
     * Returns the raw JSON value of [transactionHash].
     *
     * Unlike [transactionHash], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transaction_hash")
    @ExcludeMissing
    fun _transactionHash(): JsonField<String> = transactionHash

    /**
     * Returns the raw JSON value of [withdrawalRequestId].
     *
     * Unlike [withdrawalRequestId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("withdrawal_request_id")
    @ExcludeMissing
    fun _withdrawalRequestId(): JsonField<String> = withdrawalRequestId

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
         * Returns a mutable builder for constructing an instance of [Withdrawal].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .accountId()
         * .chainId()
         * .paymentTokenAddress()
         * .paymentTokenAmount()
         * .recipientAccountId()
         * .status()
         * .transactionDt()
         * .transactionHash()
         * .withdrawalRequestId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Withdrawal]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var accountId: JsonField<String>? = null
        private var chainId: JsonField<Chain>? = null
        private var paymentTokenAddress: JsonField<String>? = null
        private var paymentTokenAmount: JsonField<Double>? = null
        private var recipientAccountId: JsonField<String>? = null
        private var status: JsonField<BrokerageOrderStatus>? = null
        private var transactionDt: JsonField<OffsetDateTime>? = null
        private var transactionHash: JsonField<String>? = null
        private var withdrawalRequestId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(withdrawal: Withdrawal) = apply {
            id = withdrawal.id
            accountId = withdrawal.accountId
            chainId = withdrawal.chainId
            paymentTokenAddress = withdrawal.paymentTokenAddress
            paymentTokenAmount = withdrawal.paymentTokenAmount
            recipientAccountId = withdrawal.recipientAccountId
            status = withdrawal.status
            transactionDt = withdrawal.transactionDt
            transactionHash = withdrawal.transactionHash
            withdrawalRequestId = withdrawal.withdrawalRequestId
            additionalProperties = withdrawal.additionalProperties.toMutableMap()
        }

        /** ID of the `Withdrawal`. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** ID of the `Account` from which the `Withdrawal` is made. */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /**
         * Sets [Builder.accountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        /** CAIP-2 chain ID of the blockchain where the `Withdrawal` is made. */
        fun chainId(chainId: Chain) = chainId(JsonField.of(chainId))

        /**
         * Sets [Builder.chainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chainId] with a well-typed [Chain] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chainId(chainId: JsonField<Chain>) = apply { this.chainId = chainId }

        /** Address of USDC payment token that the `Withdrawal` will be received in. */
        fun paymentTokenAddress(paymentTokenAddress: String) =
            paymentTokenAddress(JsonField.of(paymentTokenAddress))

        /**
         * Sets [Builder.paymentTokenAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentTokenAddress] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentTokenAddress(paymentTokenAddress: JsonField<String>) = apply {
            this.paymentTokenAddress = paymentTokenAddress
        }

        /** Amount of USDC payment tokens to be withdrawn. */
        fun paymentTokenAmount(paymentTokenAmount: Double) =
            paymentTokenAmount(JsonField.of(paymentTokenAmount))

        /**
         * Sets [Builder.paymentTokenAmount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentTokenAmount] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentTokenAmount(paymentTokenAmount: JsonField<Double>) = apply {
            this.paymentTokenAmount = paymentTokenAmount
        }

        /**
         * ID of the `Account` that will receive payment tokens from the `Withdrawal`. This
         * `Account` must be connected to a non-managed `Wallet` and belong to the same `Entity`.
         */
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

        /** Status of the `Withdrawal`. */
        fun status(status: BrokerageOrderStatus) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [BrokerageOrderStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun status(status: JsonField<BrokerageOrderStatus>) = apply { this.status = status }

        /** Datetime at which the `Withdrawal` was transacted. ISO 8601 timestamp. */
        fun transactionDt(transactionDt: OffsetDateTime) =
            transactionDt(JsonField.of(transactionDt))

        /**
         * Sets [Builder.transactionDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transactionDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun transactionDt(transactionDt: JsonField<OffsetDateTime>) = apply {
            this.transactionDt = transactionDt
        }

        /** Hash of the transaction for the `Withdrawal`. */
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

        /** ID of the `WithdrawalRequest` associated with this `Withdrawal`. */
        fun withdrawalRequestId(withdrawalRequestId: String) =
            withdrawalRequestId(JsonField.of(withdrawalRequestId))

        /**
         * Sets [Builder.withdrawalRequestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.withdrawalRequestId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun withdrawalRequestId(withdrawalRequestId: JsonField<String>) = apply {
            this.withdrawalRequestId = withdrawalRequestId
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
         * Returns an immutable instance of [Withdrawal].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .accountId()
         * .chainId()
         * .paymentTokenAddress()
         * .paymentTokenAmount()
         * .recipientAccountId()
         * .status()
         * .transactionDt()
         * .transactionHash()
         * .withdrawalRequestId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Withdrawal =
            Withdrawal(
                checkRequired("id", id),
                checkRequired("accountId", accountId),
                checkRequired("chainId", chainId),
                checkRequired("paymentTokenAddress", paymentTokenAddress),
                checkRequired("paymentTokenAmount", paymentTokenAmount),
                checkRequired("recipientAccountId", recipientAccountId),
                checkRequired("status", status),
                checkRequired("transactionDt", transactionDt),
                checkRequired("transactionHash", transactionHash),
                checkRequired("withdrawalRequestId", withdrawalRequestId),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Withdrawal = apply {
        if (validated) {
            return@apply
        }

        id()
        accountId()
        chainId().validate()
        paymentTokenAddress()
        paymentTokenAmount()
        recipientAccountId()
        status().validate()
        transactionDt()
        transactionHash()
        withdrawalRequestId()
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
            (if (accountId.asKnown().isPresent) 1 else 0) +
            (chainId.asKnown().getOrNull()?.validity() ?: 0) +
            (if (paymentTokenAddress.asKnown().isPresent) 1 else 0) +
            (if (paymentTokenAmount.asKnown().isPresent) 1 else 0) +
            (if (recipientAccountId.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (transactionDt.asKnown().isPresent) 1 else 0) +
            (if (transactionHash.asKnown().isPresent) 1 else 0) +
            (if (withdrawalRequestId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Withdrawal &&
            id == other.id &&
            accountId == other.accountId &&
            chainId == other.chainId &&
            paymentTokenAddress == other.paymentTokenAddress &&
            paymentTokenAmount == other.paymentTokenAmount &&
            recipientAccountId == other.recipientAccountId &&
            status == other.status &&
            transactionDt == other.transactionDt &&
            transactionHash == other.transactionHash &&
            withdrawalRequestId == other.withdrawalRequestId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            accountId,
            chainId,
            paymentTokenAddress,
            paymentTokenAmount,
            recipientAccountId,
            status,
            transactionDt,
            transactionHash,
            withdrawalRequestId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Withdrawal{id=$id, accountId=$accountId, chainId=$chainId, paymentTokenAddress=$paymentTokenAddress, paymentTokenAmount=$paymentTokenAmount, recipientAccountId=$recipientAccountId, status=$status, transactionDt=$transactionDt, transactionHash=$transactionHash, withdrawalRequestId=$withdrawalRequestId, additionalProperties=$additionalProperties}"
}
