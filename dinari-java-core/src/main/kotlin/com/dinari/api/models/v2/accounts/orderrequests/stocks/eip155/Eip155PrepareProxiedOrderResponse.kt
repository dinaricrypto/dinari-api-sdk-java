// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155

import com.dinari.api.core.Enum
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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Prepared data for creating an `OrderRequest` through the EVM proxied order API route. */
class Eip155PrepareProxiedOrderResponse
private constructor(
    private val id: JsonField<String>,
    private val deadline: JsonField<OffsetDateTime>,
    private val fees: JsonField<List<Fee>>,
    private val orderTypedData: JsonField<OrderTypedData>,
    private val permitTypedData: JsonField<PermitTypedData>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("deadline")
        @ExcludeMissing
        deadline: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("fees") @ExcludeMissing fees: JsonField<List<Fee>> = JsonMissing.of(),
        @JsonProperty("order_typed_data")
        @ExcludeMissing
        orderTypedData: JsonField<OrderTypedData> = JsonMissing.of(),
        @JsonProperty("permit_typed_data")
        @ExcludeMissing
        permitTypedData: JsonField<PermitTypedData> = JsonMissing.of(),
    ) : this(id, deadline, fees, orderTypedData, permitTypedData, mutableMapOf())

    /**
     * ID of the EvmPreparedProxiedOrder.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Deadline for the prepared order to be placed.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun deadline(): OffsetDateTime = deadline.getRequired("deadline")

    /**
     * Fees involved in the order. Provided here as a reference.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fees(): List<Fee> = fees.getRequired("fees")

    /**
     * [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orderTypedData(): OrderTypedData = orderTypedData.getRequired("order_typed_data")

    /**
     * [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun permitTypedData(): PermitTypedData = permitTypedData.getRequired("permit_typed_data")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [deadline].
     *
     * Unlike [deadline], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deadline") @ExcludeMissing fun _deadline(): JsonField<OffsetDateTime> = deadline

    /**
     * Returns the raw JSON value of [fees].
     *
     * Unlike [fees], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fees") @ExcludeMissing fun _fees(): JsonField<List<Fee>> = fees

    /**
     * Returns the raw JSON value of [orderTypedData].
     *
     * Unlike [orderTypedData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("order_typed_data")
    @ExcludeMissing
    fun _orderTypedData(): JsonField<OrderTypedData> = orderTypedData

    /**
     * Returns the raw JSON value of [permitTypedData].
     *
     * Unlike [permitTypedData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("permit_typed_data")
    @ExcludeMissing
    fun _permitTypedData(): JsonField<PermitTypedData> = permitTypedData

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
         * [Eip155PrepareProxiedOrderResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .deadline()
         * .fees()
         * .orderTypedData()
         * .permitTypedData()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Eip155PrepareProxiedOrderResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var deadline: JsonField<OffsetDateTime>? = null
        private var fees: JsonField<MutableList<Fee>>? = null
        private var orderTypedData: JsonField<OrderTypedData>? = null
        private var permitTypedData: JsonField<PermitTypedData>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(eip155PrepareProxiedOrderResponse: Eip155PrepareProxiedOrderResponse) =
            apply {
                id = eip155PrepareProxiedOrderResponse.id
                deadline = eip155PrepareProxiedOrderResponse.deadline
                fees = eip155PrepareProxiedOrderResponse.fees.map { it.toMutableList() }
                orderTypedData = eip155PrepareProxiedOrderResponse.orderTypedData
                permitTypedData = eip155PrepareProxiedOrderResponse.permitTypedData
                additionalProperties =
                    eip155PrepareProxiedOrderResponse.additionalProperties.toMutableMap()
            }

        /** ID of the EvmPreparedProxiedOrder. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Deadline for the prepared order to be placed. */
        fun deadline(deadline: OffsetDateTime) = deadline(JsonField.of(deadline))

        /**
         * Sets [Builder.deadline] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deadline] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deadline(deadline: JsonField<OffsetDateTime>) = apply { this.deadline = deadline }

        /** Fees involved in the order. Provided here as a reference. */
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
         * [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet.
         */
        fun orderTypedData(orderTypedData: OrderTypedData) =
            orderTypedData(JsonField.of(orderTypedData))

        /**
         * Sets [Builder.orderTypedData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orderTypedData] with a well-typed [OrderTypedData] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun orderTypedData(orderTypedData: JsonField<OrderTypedData>) = apply {
            this.orderTypedData = orderTypedData
        }

        /**
         * [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet.
         */
        fun permitTypedData(permitTypedData: PermitTypedData) =
            permitTypedData(JsonField.of(permitTypedData))

        /**
         * Sets [Builder.permitTypedData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.permitTypedData] with a well-typed [PermitTypedData]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun permitTypedData(permitTypedData: JsonField<PermitTypedData>) = apply {
            this.permitTypedData = permitTypedData
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
         * Returns an immutable instance of [Eip155PrepareProxiedOrderResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .deadline()
         * .fees()
         * .orderTypedData()
         * .permitTypedData()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Eip155PrepareProxiedOrderResponse =
            Eip155PrepareProxiedOrderResponse(
                checkRequired("id", id),
                checkRequired("deadline", deadline),
                checkRequired("fees", fees).map { it.toImmutable() },
                checkRequired("orderTypedData", orderTypedData),
                checkRequired("permitTypedData", permitTypedData),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Eip155PrepareProxiedOrderResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        deadline()
        fees().forEach { it.validate() }
        orderTypedData().validate()
        permitTypedData().validate()
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
            (if (deadline.asKnown().isPresent) 1 else 0) +
            (fees.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (orderTypedData.asKnown().getOrNull()?.validity() ?: 0) +
            (permitTypedData.asKnown().getOrNull()?.validity() ?: 0)

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

    /** [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet. */
    class OrderTypedData
    private constructor(
        private val domain: JsonValue,
        private val message: JsonValue,
        private val primaryType: JsonField<String>,
        private val types: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("domain") @ExcludeMissing domain: JsonValue = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonValue = JsonMissing.of(),
            @JsonProperty("primaryType")
            @ExcludeMissing
            primaryType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("types") @ExcludeMissing types: JsonValue = JsonMissing.of(),
        ) : this(domain, message, primaryType, types, mutableMapOf())

        /** Domain separator for the typed data. */
        @JsonProperty("domain") @ExcludeMissing fun _domain(): JsonValue = domain

        /** Message to be signed. Contains the actual data that will be signed with the wallet. */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonValue = message

        /**
         * Primary type of the typed data.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun primaryType(): String = primaryType.getRequired("primaryType")

        /** Types used in the typed data. */
        @JsonProperty("types") @ExcludeMissing fun _types(): JsonValue = types

        /**
         * Returns the raw JSON value of [primaryType].
         *
         * Unlike [primaryType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("primaryType")
        @ExcludeMissing
        fun _primaryType(): JsonField<String> = primaryType

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
             * Returns a mutable builder for constructing an instance of [OrderTypedData].
             *
             * The following fields are required:
             * ```java
             * .domain()
             * .message()
             * .primaryType()
             * .types()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OrderTypedData]. */
        class Builder internal constructor() {

            private var domain: JsonValue? = null
            private var message: JsonValue? = null
            private var primaryType: JsonField<String>? = null
            private var types: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(orderTypedData: OrderTypedData) = apply {
                domain = orderTypedData.domain
                message = orderTypedData.message
                primaryType = orderTypedData.primaryType
                types = orderTypedData.types
                additionalProperties = orderTypedData.additionalProperties.toMutableMap()
            }

            /** Domain separator for the typed data. */
            fun domain(domain: JsonValue) = apply { this.domain = domain }

            /**
             * Message to be signed. Contains the actual data that will be signed with the wallet.
             */
            fun message(message: JsonValue) = apply { this.message = message }

            /** Primary type of the typed data. */
            fun primaryType(primaryType: String) = primaryType(JsonField.of(primaryType))

            /**
             * Sets [Builder.primaryType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.primaryType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun primaryType(primaryType: JsonField<String>) = apply {
                this.primaryType = primaryType
            }

            /** Types used in the typed data. */
            fun types(types: JsonValue) = apply { this.types = types }

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
             * Returns an immutable instance of [OrderTypedData].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .domain()
             * .message()
             * .primaryType()
             * .types()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): OrderTypedData =
                OrderTypedData(
                    checkRequired("domain", domain),
                    checkRequired("message", message),
                    checkRequired("primaryType", primaryType),
                    checkRequired("types", types),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): OrderTypedData = apply {
            if (validated) {
                return@apply
            }

            primaryType()
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
        @JvmSynthetic internal fun validity(): Int = (if (primaryType.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is OrderTypedData && domain == other.domain && message == other.message && primaryType == other.primaryType && types == other.types && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(domain, message, primaryType, types, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OrderTypedData{domain=$domain, message=$message, primaryType=$primaryType, types=$types, additionalProperties=$additionalProperties}"
    }

    /** [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet. */
    class PermitTypedData
    private constructor(
        private val domain: JsonValue,
        private val message: JsonValue,
        private val primaryType: JsonField<String>,
        private val types: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("domain") @ExcludeMissing domain: JsonValue = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonValue = JsonMissing.of(),
            @JsonProperty("primaryType")
            @ExcludeMissing
            primaryType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("types") @ExcludeMissing types: JsonValue = JsonMissing.of(),
        ) : this(domain, message, primaryType, types, mutableMapOf())

        /** Domain separator for the typed data. */
        @JsonProperty("domain") @ExcludeMissing fun _domain(): JsonValue = domain

        /** Message to be signed. Contains the actual data that will be signed with the wallet. */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonValue = message

        /**
         * Primary type of the typed data.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun primaryType(): String = primaryType.getRequired("primaryType")

        /** Types used in the typed data. */
        @JsonProperty("types") @ExcludeMissing fun _types(): JsonValue = types

        /**
         * Returns the raw JSON value of [primaryType].
         *
         * Unlike [primaryType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("primaryType")
        @ExcludeMissing
        fun _primaryType(): JsonField<String> = primaryType

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
             * Returns a mutable builder for constructing an instance of [PermitTypedData].
             *
             * The following fields are required:
             * ```java
             * .domain()
             * .message()
             * .primaryType()
             * .types()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PermitTypedData]. */
        class Builder internal constructor() {

            private var domain: JsonValue? = null
            private var message: JsonValue? = null
            private var primaryType: JsonField<String>? = null
            private var types: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(permitTypedData: PermitTypedData) = apply {
                domain = permitTypedData.domain
                message = permitTypedData.message
                primaryType = permitTypedData.primaryType
                types = permitTypedData.types
                additionalProperties = permitTypedData.additionalProperties.toMutableMap()
            }

            /** Domain separator for the typed data. */
            fun domain(domain: JsonValue) = apply { this.domain = domain }

            /**
             * Message to be signed. Contains the actual data that will be signed with the wallet.
             */
            fun message(message: JsonValue) = apply { this.message = message }

            /** Primary type of the typed data. */
            fun primaryType(primaryType: String) = primaryType(JsonField.of(primaryType))

            /**
             * Sets [Builder.primaryType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.primaryType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun primaryType(primaryType: JsonField<String>) = apply {
                this.primaryType = primaryType
            }

            /** Types used in the typed data. */
            fun types(types: JsonValue) = apply { this.types = types }

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
             * Returns an immutable instance of [PermitTypedData].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .domain()
             * .message()
             * .primaryType()
             * .types()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PermitTypedData =
                PermitTypedData(
                    checkRequired("domain", domain),
                    checkRequired("message", message),
                    checkRequired("primaryType", primaryType),
                    checkRequired("types", types),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): PermitTypedData = apply {
            if (validated) {
                return@apply
            }

            primaryType()
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
        @JvmSynthetic internal fun validity(): Int = (if (primaryType.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PermitTypedData && domain == other.domain && message == other.message && primaryType == other.primaryType && types == other.types && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(domain, message, primaryType, types, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PermitTypedData{domain=$domain, message=$message, primaryType=$primaryType, types=$types, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Eip155PrepareProxiedOrderResponse && id == other.id && deadline == other.deadline && fees == other.fees && orderTypedData == other.orderTypedData && permitTypedData == other.permitTypedData && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, deadline, fees, orderTypedData, permitTypedData, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Eip155PrepareProxiedOrderResponse{id=$id, deadline=$deadline, fees=$fees, orderTypedData=$orderTypedData, permitTypedData=$permitTypedData, additionalProperties=$additionalProperties}"
}
