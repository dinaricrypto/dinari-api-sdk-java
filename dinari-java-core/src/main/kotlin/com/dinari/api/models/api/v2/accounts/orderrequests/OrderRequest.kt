// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orderrequests

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Request to create an order */
class OrderRequest
private constructor(
    private val accountId: JsonField<String>,
    private val confirmationCode: JsonField<String>,
    private val createdDt: JsonField<OffsetDateTime>,
    private val status: JsonField<Status>,
    private val orderId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("confirmation_code")
        @ExcludeMissing
        confirmationCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_dt")
        @ExcludeMissing
        createdDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("order_id") @ExcludeMissing orderId: JsonField<String> = JsonMissing.of(),
    ) : this(accountId, confirmationCode, createdDt, status, orderId, mutableMapOf())

    /**
     * ID of account placing the order
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun accountId(): String = accountId.getRequired("account_id")

    /**
     * Confirmation code of order request. This is the primary identifier for the `/order_requests`
     * endpoint
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun confirmationCode(): String = confirmationCode.getRequired("confirmation_code")

    /**
     * Timestamp at which the order request was created.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdDt(): OffsetDateTime = createdDt.getRequired("created_dt")

    /**
     * Status of order request
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * ID of order created from the order request. This is the primary identifier for the `/orders`
     * endpoint
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun orderId(): Optional<String> = orderId.getOptional("order_id")

    /**
     * Returns the raw JSON value of [accountId].
     *
     * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account_id") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

    /**
     * Returns the raw JSON value of [confirmationCode].
     *
     * Unlike [confirmationCode], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("confirmation_code")
    @ExcludeMissing
    fun _confirmationCode(): JsonField<String> = confirmationCode

    /**
     * Returns the raw JSON value of [createdDt].
     *
     * Unlike [createdDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_dt")
    @ExcludeMissing
    fun _createdDt(): JsonField<OffsetDateTime> = createdDt

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [orderId].
     *
     * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_id") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

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
         * Returns a mutable builder for constructing an instance of [OrderRequest].
         *
         * The following fields are required:
         * ```java
         * .accountId()
         * .confirmationCode()
         * .createdDt()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OrderRequest]. */
    class Builder internal constructor() {

        private var accountId: JsonField<String>? = null
        private var confirmationCode: JsonField<String>? = null
        private var createdDt: JsonField<OffsetDateTime>? = null
        private var status: JsonField<Status>? = null
        private var orderId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(orderRequest: OrderRequest) = apply {
            accountId = orderRequest.accountId
            confirmationCode = orderRequest.confirmationCode
            createdDt = orderRequest.createdDt
            status = orderRequest.status
            orderId = orderRequest.orderId
            additionalProperties = orderRequest.additionalProperties.toMutableMap()
        }

        /** ID of account placing the order */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /**
         * Sets [Builder.accountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        /**
         * Confirmation code of order request. This is the primary identifier for the
         * `/order_requests` endpoint
         */
        fun confirmationCode(confirmationCode: String) =
            confirmationCode(JsonField.of(confirmationCode))

        /**
         * Sets [Builder.confirmationCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.confirmationCode] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun confirmationCode(confirmationCode: JsonField<String>) = apply {
            this.confirmationCode = confirmationCode
        }

        /** Timestamp at which the order request was created. */
        fun createdDt(createdDt: OffsetDateTime) = createdDt(JsonField.of(createdDt))

        /**
         * Sets [Builder.createdDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdDt(createdDt: JsonField<OffsetDateTime>) = apply { this.createdDt = createdDt }

        /** Status of order request */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * ID of order created from the order request. This is the primary identifier for the
         * `/orders` endpoint
         */
        fun orderId(orderId: String) = orderId(JsonField.of(orderId))

        /**
         * Sets [Builder.orderId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

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
         * Returns an immutable instance of [OrderRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .accountId()
         * .confirmationCode()
         * .createdDt()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OrderRequest =
            OrderRequest(
                checkRequired("accountId", accountId),
                checkRequired("confirmationCode", confirmationCode),
                checkRequired("createdDt", createdDt),
                checkRequired("status", status),
                orderId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OrderRequest = apply {
        if (validated) {
            return@apply
        }

        accountId()
        confirmationCode()
        createdDt()
        status().validate()
        orderId()
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
        (if (accountId.asKnown().isPresent) 1 else 0) +
            (if (confirmationCode.asKnown().isPresent) 1 else 0) +
            (if (createdDt.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (orderId.asKnown().isPresent) 1 else 0)

    /** Status of order request */
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

        return /* spotless:off */ other is OrderRequest && accountId == other.accountId && confirmationCode == other.confirmationCode && createdDt == other.createdDt && status == other.status && orderId == other.orderId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(accountId, confirmationCode, createdDt, status, orderId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OrderRequest{accountId=$accountId, confirmationCode=$confirmationCode, createdDt=$createdDt, status=$status, orderId=$orderId, additionalProperties=$additionalProperties}"
}
