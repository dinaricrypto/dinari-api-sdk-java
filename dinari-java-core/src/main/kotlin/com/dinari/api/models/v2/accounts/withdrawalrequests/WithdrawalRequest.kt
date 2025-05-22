// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawalrequests

import com.dinari.api.core.Enum
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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * Information for a withdrawal request of payment tokens from an `Account` backed by a
 * Dinari-managed `Wallet`.
 */
class WithdrawalRequest
private constructor(
    private val id: JsonField<String>,
    private val accountId: JsonField<String>,
    private val createdDt: JsonField<OffsetDateTime>,
    private val paymentTokenAmount: JsonField<Double>,
    private val recipientAccountId: JsonField<String>,
    private val status: JsonField<Status>,
    private val updatedDt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_dt")
        @ExcludeMissing
        createdDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("payment_token_amount")
        @ExcludeMissing
        paymentTokenAmount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("recipient_account_id")
        @ExcludeMissing
        recipientAccountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("updated_dt")
        @ExcludeMissing
        updatedDt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        accountId,
        createdDt,
        paymentTokenAmount,
        recipientAccountId,
        status,
        updatedDt,
        mutableMapOf(),
    )

    /**
     * ID of the `WithdrawalRequest`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * ID of the `Account` of the `WithdrawalRequest`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun accountId(): String = accountId.getRequired("account_id")

    /**
     * Datetime at which the `WithdrawalRequest` was created. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdDt(): OffsetDateTime = createdDt.getRequired("created_dt")

    /**
     * Amount of USD+ payment tokens submitted for withdrawal.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun paymentTokenAmount(): Double = paymentTokenAmount.getRequired("payment_token_amount")

    /**
     * ID of the `Account` that will receive USDC payment tokens from the `Withdrawal`. This
     * `Account` must be connected to a non-managed `Wallet` and belong to the same `Entity`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipientAccountId(): String = recipientAccountId.getRequired("recipient_account_id")

    /**
     * Status of the `WithdrawalRequest`
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Datetime at which the `WithdrawalRequest` was updated. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedDt(): OffsetDateTime = updatedDt.getRequired("updated_dt")

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
     * Returns the raw JSON value of [createdDt].
     *
     * Unlike [createdDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_dt")
    @ExcludeMissing
    fun _createdDt(): JsonField<OffsetDateTime> = createdDt

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
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [updatedDt].
     *
     * Unlike [updatedDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_dt")
    @ExcludeMissing
    fun _updatedDt(): JsonField<OffsetDateTime> = updatedDt

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
         * Returns a mutable builder for constructing an instance of [WithdrawalRequest].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .accountId()
         * .createdDt()
         * .paymentTokenAmount()
         * .recipientAccountId()
         * .status()
         * .updatedDt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WithdrawalRequest]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var accountId: JsonField<String>? = null
        private var createdDt: JsonField<OffsetDateTime>? = null
        private var paymentTokenAmount: JsonField<Double>? = null
        private var recipientAccountId: JsonField<String>? = null
        private var status: JsonField<Status>? = null
        private var updatedDt: JsonField<OffsetDateTime>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(withdrawalRequest: WithdrawalRequest) = apply {
            id = withdrawalRequest.id
            accountId = withdrawalRequest.accountId
            createdDt = withdrawalRequest.createdDt
            paymentTokenAmount = withdrawalRequest.paymentTokenAmount
            recipientAccountId = withdrawalRequest.recipientAccountId
            status = withdrawalRequest.status
            updatedDt = withdrawalRequest.updatedDt
            additionalProperties = withdrawalRequest.additionalProperties.toMutableMap()
        }

        /** ID of the `WithdrawalRequest`. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** ID of the `Account` of the `WithdrawalRequest`. */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /**
         * Sets [Builder.accountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        /** Datetime at which the `WithdrawalRequest` was created. ISO 8601 timestamp. */
        fun createdDt(createdDt: OffsetDateTime) = createdDt(JsonField.of(createdDt))

        /**
         * Sets [Builder.createdDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdDt(createdDt: JsonField<OffsetDateTime>) = apply { this.createdDt = createdDt }

        /** Amount of USD+ payment tokens submitted for withdrawal. */
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
         * ID of the `Account` that will receive USDC payment tokens from the `Withdrawal`. This
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

        /** Status of the `WithdrawalRequest` */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Datetime at which the `WithdrawalRequest` was updated. ISO 8601 timestamp. */
        fun updatedDt(updatedDt: OffsetDateTime) = updatedDt(JsonField.of(updatedDt))

        /**
         * Sets [Builder.updatedDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedDt(updatedDt: JsonField<OffsetDateTime>) = apply { this.updatedDt = updatedDt }

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
         * Returns an immutable instance of [WithdrawalRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .accountId()
         * .createdDt()
         * .paymentTokenAmount()
         * .recipientAccountId()
         * .status()
         * .updatedDt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WithdrawalRequest =
            WithdrawalRequest(
                checkRequired("id", id),
                checkRequired("accountId", accountId),
                checkRequired("createdDt", createdDt),
                checkRequired("paymentTokenAmount", paymentTokenAmount),
                checkRequired("recipientAccountId", recipientAccountId),
                checkRequired("status", status),
                checkRequired("updatedDt", updatedDt),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): WithdrawalRequest = apply {
        if (validated) {
            return@apply
        }

        id()
        accountId()
        createdDt()
        paymentTokenAmount()
        recipientAccountId()
        status().validate()
        updatedDt()
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
            (if (createdDt.asKnown().isPresent) 1 else 0) +
            (if (paymentTokenAmount.asKnown().isPresent) 1 else 0) +
            (if (recipientAccountId.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (updatedDt.asKnown().isPresent) 1 else 0)

    /** Status of the `WithdrawalRequest` */
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

            @JvmField val SUBMITTED = of("SUBMITTED")

            @JvmField val ERROR = of("ERROR")

            @JvmField val CANCELLED = of("CANCELLED")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PENDING,
            SUBMITTED,
            ERROR,
            CANCELLED,
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
            SUBMITTED,
            ERROR,
            CANCELLED,
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
                SUBMITTED -> Value.SUBMITTED
                ERROR -> Value.ERROR
                CANCELLED -> Value.CANCELLED
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
                SUBMITTED -> Known.SUBMITTED
                ERROR -> Known.ERROR
                CANCELLED -> Known.CANCELLED
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

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is WithdrawalRequest && id == other.id && accountId == other.accountId && createdDt == other.createdDt && paymentTokenAmount == other.paymentTokenAmount && recipientAccountId == other.recipientAccountId && status == other.status && updatedDt == other.updatedDt && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, accountId, createdDt, paymentTokenAmount, recipientAccountId, status, updatedDt, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WithdrawalRequest{id=$id, accountId=$accountId, createdDt=$createdDt, paymentTokenAmount=$paymentTokenAmount, recipientAccountId=$recipientAccountId, status=$status, updatedDt=$updatedDt, additionalProperties=$additionalProperties}"
}
