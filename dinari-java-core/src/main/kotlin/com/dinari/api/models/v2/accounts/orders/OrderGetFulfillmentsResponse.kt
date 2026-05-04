// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orders

import com.dinari.api.core.BaseDeserializer
import com.dinari.api.core.BaseSerializer
import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.allMaxBy
import com.dinari.api.core.checkKnown
import com.dinari.api.core.checkRequired
import com.dinari.api.core.getOrThrow
import com.dinari.api.core.toImmutable
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = OrderGetFulfillmentsResponse.Deserializer::class)
@JsonSerialize(using = OrderGetFulfillmentsResponse.Serializer::class)
class OrderGetFulfillmentsResponse
private constructor(
    private val accountOrderFulfillments: List<AccountOrderFulfillment>? = null,
    private val paginatedAccountOrderFulfillment: PaginatedAccountOrderFulfillmentResponse? = null,
    private val _json: JsonValue? = null,
) {

    fun accountOrderFulfillments(): Optional<List<AccountOrderFulfillment>> =
        Optional.ofNullable(accountOrderFulfillments)

    fun paginatedAccountOrderFulfillment(): Optional<PaginatedAccountOrderFulfillmentResponse> =
        Optional.ofNullable(paginatedAccountOrderFulfillment)

    fun isAccountOrderFulfillments(): Boolean = accountOrderFulfillments != null

    fun isPaginatedAccountOrderFulfillment(): Boolean = paginatedAccountOrderFulfillment != null

    fun asAccountOrderFulfillments(): List<AccountOrderFulfillment> =
        accountOrderFulfillments.getOrThrow("accountOrderFulfillments")

    fun asPaginatedAccountOrderFulfillment(): PaginatedAccountOrderFulfillmentResponse =
        paginatedAccountOrderFulfillment.getOrThrow("paginatedAccountOrderFulfillment")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.dinari.api.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = orderGetFulfillmentsResponse.accept(new OrderGetFulfillmentsResponse.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitAccountOrderFulfillments(List<AccountOrderFulfillment> accountOrderFulfillments) {
     *         return Optional.of(accountOrderFulfillments.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws DinariInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            accountOrderFulfillments != null ->
                visitor.visitAccountOrderFulfillments(accountOrderFulfillments)
            paginatedAccountOrderFulfillment != null ->
                visitor.visitPaginatedAccountOrderFulfillment(paginatedAccountOrderFulfillment)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws DinariInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): OrderGetFulfillmentsResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitAccountOrderFulfillments(
                    accountOrderFulfillments: List<AccountOrderFulfillment>
                ) {
                    accountOrderFulfillments.forEach { it.validate() }
                }

                override fun visitPaginatedAccountOrderFulfillment(
                    paginatedAccountOrderFulfillment: PaginatedAccountOrderFulfillmentResponse
                ) {
                    paginatedAccountOrderFulfillment.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitAccountOrderFulfillments(
                    accountOrderFulfillments: List<AccountOrderFulfillment>
                ) = accountOrderFulfillments.sumOf { it.validity().toInt() }

                override fun visitPaginatedAccountOrderFulfillment(
                    paginatedAccountOrderFulfillment: PaginatedAccountOrderFulfillmentResponse
                ) = paginatedAccountOrderFulfillment.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OrderGetFulfillmentsResponse &&
            accountOrderFulfillments == other.accountOrderFulfillments &&
            paginatedAccountOrderFulfillment == other.paginatedAccountOrderFulfillment
    }

    override fun hashCode(): Int =
        Objects.hash(accountOrderFulfillments, paginatedAccountOrderFulfillment)

    override fun toString(): String =
        when {
            accountOrderFulfillments != null ->
                "OrderGetFulfillmentsResponse{accountOrderFulfillments=$accountOrderFulfillments}"
            paginatedAccountOrderFulfillment != null ->
                "OrderGetFulfillmentsResponse{paginatedAccountOrderFulfillment=$paginatedAccountOrderFulfillment}"
            _json != null -> "OrderGetFulfillmentsResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid OrderGetFulfillmentsResponse")
        }

    companion object {

        @JvmStatic
        fun ofAccountOrderFulfillments(accountOrderFulfillments: List<AccountOrderFulfillment>) =
            OrderGetFulfillmentsResponse(
                accountOrderFulfillments = accountOrderFulfillments.toImmutable()
            )

        @JvmStatic
        fun ofPaginatedAccountOrderFulfillment(
            paginatedAccountOrderFulfillment: PaginatedAccountOrderFulfillmentResponse
        ) =
            OrderGetFulfillmentsResponse(
                paginatedAccountOrderFulfillment = paginatedAccountOrderFulfillment
            )
    }

    /**
     * An interface that defines how to map each variant of [OrderGetFulfillmentsResponse] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        fun visitAccountOrderFulfillments(
            accountOrderFulfillments: List<AccountOrderFulfillment>
        ): T

        fun visitPaginatedAccountOrderFulfillment(
            paginatedAccountOrderFulfillment: PaginatedAccountOrderFulfillmentResponse
        ): T

        /**
         * Maps an unknown variant of [OrderGetFulfillmentsResponse] to a value of type [T].
         *
         * An instance of [OrderGetFulfillmentsResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws DinariInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw DinariInvalidDataException("Unknown OrderGetFulfillmentsResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<OrderGetFulfillmentsResponse>(OrderGetFulfillmentsResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): OrderGetFulfillmentsResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(
                                node,
                                jacksonTypeRef<PaginatedAccountOrderFulfillmentResponse>(),
                            )
                            ?.let {
                                OrderGetFulfillmentsResponse(
                                    paginatedAccountOrderFulfillment = it,
                                    _json = json,
                                )
                            },
                        tryDeserialize(node, jacksonTypeRef<List<AccountOrderFulfillment>>())?.let {
                            OrderGetFulfillmentsResponse(
                                accountOrderFulfillments = it,
                                _json = json,
                            )
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> OrderGetFulfillmentsResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<OrderGetFulfillmentsResponse>(OrderGetFulfillmentsResponse::class) {

        override fun serialize(
            value: OrderGetFulfillmentsResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.accountOrderFulfillments != null ->
                    generator.writeObject(value.accountOrderFulfillments)
                value.paginatedAccountOrderFulfillment != null ->
                    generator.writeObject(value.paginatedAccountOrderFulfillment)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid OrderGetFulfillmentsResponse")
            }
        }
    }

    /**
     * Information about a fulfillment of an `Order`. An order may be fulfilled in multiple
     * transactions.
     */
    class AccountOrderFulfillment
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val assetTokenFilled: JsonField<Double>,
        private val assetTokenSpent: JsonField<Double>,
        private val chainId: JsonField<String>,
        private val orderId: JsonField<String>,
        private val paymentTokenFilled: JsonField<Double>,
        private val paymentTokenSpent: JsonField<Double>,
        private val transactionDt: JsonField<OffsetDateTime>,
        private val transactionHash: JsonField<String>,
        private val alloyId: JsonField<String>,
        private val paymentTokenFee: JsonField<Double>,
        private val stockId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("asset_token_filled")
            @ExcludeMissing
            assetTokenFilled: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("asset_token_spent")
            @ExcludeMissing
            assetTokenSpent: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("chain_id") @ExcludeMissing chainId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("order_id") @ExcludeMissing orderId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("payment_token_filled")
            @ExcludeMissing
            paymentTokenFilled: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("payment_token_spent")
            @ExcludeMissing
            paymentTokenSpent: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("transaction_dt")
            @ExcludeMissing
            transactionDt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("transaction_hash")
            @ExcludeMissing
            transactionHash: JsonField<String> = JsonMissing.of(),
            @JsonProperty("alloy_id") @ExcludeMissing alloyId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("payment_token_fee")
            @ExcludeMissing
            paymentTokenFee: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("stock_id") @ExcludeMissing stockId: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            assetTokenFilled,
            assetTokenSpent,
            chainId,
            orderId,
            paymentTokenFilled,
            paymentTokenSpent,
            transactionDt,
            transactionHash,
            alloyId,
            paymentTokenFee,
            stockId,
            mutableMapOf(),
        )

        /**
         * ID of the `OrderFulfillment`.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Amount of dShare asset token filled for `BUY` orders.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun assetTokenFilled(): Double = assetTokenFilled.getRequired("asset_token_filled")

        /**
         * Amount of dShare asset token spent for `SELL` orders.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun assetTokenSpent(): Double = assetTokenSpent.getRequired("asset_token_spent")

        /**
         * Blockchain that the transaction was run on.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun chainId(): String = chainId.getRequired("chain_id")

        /**
         * ID of the `Order` this `OrderFulfillment` is for.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun orderId(): String = orderId.getRequired("order_id")

        /**
         * Amount of payment token filled for `SELL` orders.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun paymentTokenFilled(): Double = paymentTokenFilled.getRequired("payment_token_filled")

        /**
         * Amount of payment token spent for `BUY` orders.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun paymentTokenSpent(): Double = paymentTokenSpent.getRequired("payment_token_spent")

        /**
         * Time when transaction occurred.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun transactionDt(): OffsetDateTime = transactionDt.getRequired("transaction_dt")

        /**
         * Transaction hash for this fulfillment.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun transactionHash(): String = transactionHash.getRequired("transaction_hash")

        /**
         * The `Alloy` ID associated with the `Order`
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun alloyId(): Optional<String> = alloyId.getOptional("alloy_id")

        /**
         * Fee amount, in payment tokens.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun paymentTokenFee(): Optional<Double> = paymentTokenFee.getOptional("payment_token_fee")

        /**
         * The `Stock` ID associated with the `Order`
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun stockId(): Optional<String> = stockId.getOptional("stock_id")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [assetTokenFilled].
         *
         * Unlike [assetTokenFilled], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("asset_token_filled")
        @ExcludeMissing
        fun _assetTokenFilled(): JsonField<Double> = assetTokenFilled

        /**
         * Returns the raw JSON value of [assetTokenSpent].
         *
         * Unlike [assetTokenSpent], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("asset_token_spent")
        @ExcludeMissing
        fun _assetTokenSpent(): JsonField<Double> = assetTokenSpent

        /**
         * Returns the raw JSON value of [chainId].
         *
         * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<String> = chainId

        /**
         * Returns the raw JSON value of [orderId].
         *
         * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("order_id") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

        /**
         * Returns the raw JSON value of [paymentTokenFilled].
         *
         * Unlike [paymentTokenFilled], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("payment_token_filled")
        @ExcludeMissing
        fun _paymentTokenFilled(): JsonField<Double> = paymentTokenFilled

        /**
         * Returns the raw JSON value of [paymentTokenSpent].
         *
         * Unlike [paymentTokenSpent], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("payment_token_spent")
        @ExcludeMissing
        fun _paymentTokenSpent(): JsonField<Double> = paymentTokenSpent

        /**
         * Returns the raw JSON value of [transactionDt].
         *
         * Unlike [transactionDt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("transaction_dt")
        @ExcludeMissing
        fun _transactionDt(): JsonField<OffsetDateTime> = transactionDt

        /**
         * Returns the raw JSON value of [transactionHash].
         *
         * Unlike [transactionHash], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("transaction_hash")
        @ExcludeMissing
        fun _transactionHash(): JsonField<String> = transactionHash

        /**
         * Returns the raw JSON value of [alloyId].
         *
         * Unlike [alloyId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("alloy_id") @ExcludeMissing fun _alloyId(): JsonField<String> = alloyId

        /**
         * Returns the raw JSON value of [paymentTokenFee].
         *
         * Unlike [paymentTokenFee], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("payment_token_fee")
        @ExcludeMissing
        fun _paymentTokenFee(): JsonField<Double> = paymentTokenFee

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
             * Returns a mutable builder for constructing an instance of [AccountOrderFulfillment].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .assetTokenFilled()
             * .assetTokenSpent()
             * .chainId()
             * .orderId()
             * .paymentTokenFilled()
             * .paymentTokenSpent()
             * .transactionDt()
             * .transactionHash()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AccountOrderFulfillment]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var assetTokenFilled: JsonField<Double>? = null
            private var assetTokenSpent: JsonField<Double>? = null
            private var chainId: JsonField<String>? = null
            private var orderId: JsonField<String>? = null
            private var paymentTokenFilled: JsonField<Double>? = null
            private var paymentTokenSpent: JsonField<Double>? = null
            private var transactionDt: JsonField<OffsetDateTime>? = null
            private var transactionHash: JsonField<String>? = null
            private var alloyId: JsonField<String> = JsonMissing.of()
            private var paymentTokenFee: JsonField<Double> = JsonMissing.of()
            private var stockId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(accountOrderFulfillment: AccountOrderFulfillment) = apply {
                id = accountOrderFulfillment.id
                assetTokenFilled = accountOrderFulfillment.assetTokenFilled
                assetTokenSpent = accountOrderFulfillment.assetTokenSpent
                chainId = accountOrderFulfillment.chainId
                orderId = accountOrderFulfillment.orderId
                paymentTokenFilled = accountOrderFulfillment.paymentTokenFilled
                paymentTokenSpent = accountOrderFulfillment.paymentTokenSpent
                transactionDt = accountOrderFulfillment.transactionDt
                transactionHash = accountOrderFulfillment.transactionHash
                alloyId = accountOrderFulfillment.alloyId
                paymentTokenFee = accountOrderFulfillment.paymentTokenFee
                stockId = accountOrderFulfillment.stockId
                additionalProperties = accountOrderFulfillment.additionalProperties.toMutableMap()
            }

            /** ID of the `OrderFulfillment`. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Amount of dShare asset token filled for `BUY` orders. */
            fun assetTokenFilled(assetTokenFilled: Double) =
                assetTokenFilled(JsonField.of(assetTokenFilled))

            /**
             * Sets [Builder.assetTokenFilled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.assetTokenFilled] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun assetTokenFilled(assetTokenFilled: JsonField<Double>) = apply {
                this.assetTokenFilled = assetTokenFilled
            }

            /** Amount of dShare asset token spent for `SELL` orders. */
            fun assetTokenSpent(assetTokenSpent: Double) =
                assetTokenSpent(JsonField.of(assetTokenSpent))

            /**
             * Sets [Builder.assetTokenSpent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.assetTokenSpent] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun assetTokenSpent(assetTokenSpent: JsonField<Double>) = apply {
                this.assetTokenSpent = assetTokenSpent
            }

            /** Blockchain that the transaction was run on. */
            fun chainId(chainId: String) = chainId(JsonField.of(chainId))

            /**
             * Sets [Builder.chainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chainId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun chainId(chainId: JsonField<String>) = apply { this.chainId = chainId }

            /** ID of the `Order` this `OrderFulfillment` is for. */
            fun orderId(orderId: String) = orderId(JsonField.of(orderId))

            /**
             * Sets [Builder.orderId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

            /** Amount of payment token filled for `SELL` orders. */
            fun paymentTokenFilled(paymentTokenFilled: Double) =
                paymentTokenFilled(JsonField.of(paymentTokenFilled))

            /**
             * Sets [Builder.paymentTokenFilled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paymentTokenFilled] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun paymentTokenFilled(paymentTokenFilled: JsonField<Double>) = apply {
                this.paymentTokenFilled = paymentTokenFilled
            }

            /** Amount of payment token spent for `BUY` orders. */
            fun paymentTokenSpent(paymentTokenSpent: Double) =
                paymentTokenSpent(JsonField.of(paymentTokenSpent))

            /**
             * Sets [Builder.paymentTokenSpent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paymentTokenSpent] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun paymentTokenSpent(paymentTokenSpent: JsonField<Double>) = apply {
                this.paymentTokenSpent = paymentTokenSpent
            }

            /** Time when transaction occurred. */
            fun transactionDt(transactionDt: OffsetDateTime) =
                transactionDt(JsonField.of(transactionDt))

            /**
             * Sets [Builder.transactionDt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transactionDt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun transactionDt(transactionDt: JsonField<OffsetDateTime>) = apply {
                this.transactionDt = transactionDt
            }

            /** Transaction hash for this fulfillment. */
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

            /** The `Alloy` ID associated with the `Order` */
            fun alloyId(alloyId: String?) = alloyId(JsonField.ofNullable(alloyId))

            /** Alias for calling [Builder.alloyId] with `alloyId.orElse(null)`. */
            fun alloyId(alloyId: Optional<String>) = alloyId(alloyId.getOrNull())

            /**
             * Sets [Builder.alloyId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.alloyId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun alloyId(alloyId: JsonField<String>) = apply { this.alloyId = alloyId }

            /** Fee amount, in payment tokens. */
            fun paymentTokenFee(paymentTokenFee: Double?) =
                paymentTokenFee(JsonField.ofNullable(paymentTokenFee))

            /**
             * Alias for [Builder.paymentTokenFee].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun paymentTokenFee(paymentTokenFee: Double) =
                paymentTokenFee(paymentTokenFee as Double?)

            /** Alias for calling [Builder.paymentTokenFee] with `paymentTokenFee.orElse(null)`. */
            fun paymentTokenFee(paymentTokenFee: Optional<Double>) =
                paymentTokenFee(paymentTokenFee.getOrNull())

            /**
             * Sets [Builder.paymentTokenFee] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paymentTokenFee] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun paymentTokenFee(paymentTokenFee: JsonField<Double>) = apply {
                this.paymentTokenFee = paymentTokenFee
            }

            /** The `Stock` ID associated with the `Order` */
            fun stockId(stockId: String?) = stockId(JsonField.ofNullable(stockId))

            /** Alias for calling [Builder.stockId] with `stockId.orElse(null)`. */
            fun stockId(stockId: Optional<String>) = stockId(stockId.getOrNull())

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
             * Returns an immutable instance of [AccountOrderFulfillment].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .assetTokenFilled()
             * .assetTokenSpent()
             * .chainId()
             * .orderId()
             * .paymentTokenFilled()
             * .paymentTokenSpent()
             * .transactionDt()
             * .transactionHash()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AccountOrderFulfillment =
                AccountOrderFulfillment(
                    checkRequired("id", id),
                    checkRequired("assetTokenFilled", assetTokenFilled),
                    checkRequired("assetTokenSpent", assetTokenSpent),
                    checkRequired("chainId", chainId),
                    checkRequired("orderId", orderId),
                    checkRequired("paymentTokenFilled", paymentTokenFilled),
                    checkRequired("paymentTokenSpent", paymentTokenSpent),
                    checkRequired("transactionDt", transactionDt),
                    checkRequired("transactionHash", transactionHash),
                    alloyId,
                    paymentTokenFee,
                    stockId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws DinariInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): AccountOrderFulfillment = apply {
            if (validated) {
                return@apply
            }

            id()
            assetTokenFilled()
            assetTokenSpent()
            chainId()
            orderId()
            paymentTokenFilled()
            paymentTokenSpent()
            transactionDt()
            transactionHash()
            alloyId()
            paymentTokenFee()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (assetTokenFilled.asKnown().isPresent) 1 else 0) +
                (if (assetTokenSpent.asKnown().isPresent) 1 else 0) +
                (if (chainId.asKnown().isPresent) 1 else 0) +
                (if (orderId.asKnown().isPresent) 1 else 0) +
                (if (paymentTokenFilled.asKnown().isPresent) 1 else 0) +
                (if (paymentTokenSpent.asKnown().isPresent) 1 else 0) +
                (if (transactionDt.asKnown().isPresent) 1 else 0) +
                (if (transactionHash.asKnown().isPresent) 1 else 0) +
                (if (alloyId.asKnown().isPresent) 1 else 0) +
                (if (paymentTokenFee.asKnown().isPresent) 1 else 0) +
                (if (stockId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AccountOrderFulfillment &&
                id == other.id &&
                assetTokenFilled == other.assetTokenFilled &&
                assetTokenSpent == other.assetTokenSpent &&
                chainId == other.chainId &&
                orderId == other.orderId &&
                paymentTokenFilled == other.paymentTokenFilled &&
                paymentTokenSpent == other.paymentTokenSpent &&
                transactionDt == other.transactionDt &&
                transactionHash == other.transactionHash &&
                alloyId == other.alloyId &&
                paymentTokenFee == other.paymentTokenFee &&
                stockId == other.stockId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                assetTokenFilled,
                assetTokenSpent,
                chainId,
                orderId,
                paymentTokenFilled,
                paymentTokenSpent,
                transactionDt,
                transactionHash,
                alloyId,
                paymentTokenFee,
                stockId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AccountOrderFulfillment{id=$id, assetTokenFilled=$assetTokenFilled, assetTokenSpent=$assetTokenSpent, chainId=$chainId, orderId=$orderId, paymentTokenFilled=$paymentTokenFilled, paymentTokenSpent=$paymentTokenSpent, transactionDt=$transactionDt, transactionHash=$transactionHash, alloyId=$alloyId, paymentTokenFee=$paymentTokenFee, stockId=$stockId, additionalProperties=$additionalProperties}"
    }

    class PaginatedAccountOrderFulfillmentResponse
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val data: JsonField<List<Data>>,
        private val paginationMetadata: JsonField<PaginationMetadata>,
        private val _sv: JsonField<_Sv>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<List<Data>> = JsonMissing.of(),
            @JsonProperty("pagination_metadata")
            @ExcludeMissing
            paginationMetadata: JsonField<PaginationMetadata> = JsonMissing.of(),
            @JsonProperty("_sv") @ExcludeMissing _sv: JsonField<_Sv> = JsonMissing.of(),
        ) : this(data, paginationMetadata, _sv, mutableMapOf())

        /**
         * List of AccountOrderFulfillment
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): List<Data> = data.getRequired("data")

        /**
         * Pagination metadata
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun paginationMetadata(): PaginationMetadata =
            paginationMetadata.getRequired("pagination_metadata")

        /**
         * Version
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun _sv(): Optional<_Sv> = _sv.getOptional("_sv")

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Data>> = data

        /**
         * Returns the raw JSON value of [paginationMetadata].
         *
         * Unlike [paginationMetadata], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("pagination_metadata")
        @ExcludeMissing
        fun _paginationMetadata(): JsonField<PaginationMetadata> = paginationMetadata

        /**
         * Returns the raw JSON value of [_sv].
         *
         * Unlike [_sv], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("_sv") @ExcludeMissing fun __sv(): JsonField<_Sv> = _sv

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
             * [PaginatedAccountOrderFulfillmentResponse].
             *
             * The following fields are required:
             * ```java
             * .data()
             * .paginationMetadata()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PaginatedAccountOrderFulfillmentResponse]. */
        class Builder internal constructor() {

            private var data: JsonField<MutableList<Data>>? = null
            private var paginationMetadata: JsonField<PaginationMetadata>? = null
            private var _sv: JsonField<_Sv> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                paginatedAccountOrderFulfillmentResponse: PaginatedAccountOrderFulfillmentResponse
            ) = apply {
                data = paginatedAccountOrderFulfillmentResponse.data.map { it.toMutableList() }
                paginationMetadata = paginatedAccountOrderFulfillmentResponse.paginationMetadata
                _sv = paginatedAccountOrderFulfillmentResponse._sv
                additionalProperties =
                    paginatedAccountOrderFulfillmentResponse.additionalProperties.toMutableMap()
            }

            /** List of AccountOrderFulfillment */
            fun data(data: List<Data>) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed `List<Data>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<List<Data>>) = apply {
                this.data = data.map { it.toMutableList() }
            }

            /**
             * Adds a single [Data] to [Builder.data].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addData(data: Data) = apply {
                this.data =
                    (this.data ?: JsonField.of(mutableListOf())).also {
                        checkKnown("data", it).add(data)
                    }
            }

            /** Pagination metadata */
            fun paginationMetadata(paginationMetadata: PaginationMetadata) =
                paginationMetadata(JsonField.of(paginationMetadata))

            /**
             * Sets [Builder.paginationMetadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paginationMetadata] with a well-typed
             * [PaginationMetadata] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun paginationMetadata(paginationMetadata: JsonField<PaginationMetadata>) = apply {
                this.paginationMetadata = paginationMetadata
            }

            /** Version */
            fun _sv(_sv: _Sv) = _sv(JsonField.of(_sv))

            /**
             * Sets [Builder._sv] to an arbitrary JSON value.
             *
             * You should usually call [Builder._sv] with a well-typed [_Sv] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun _sv(_sv: JsonField<_Sv>) = apply { this._sv = _sv }

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
             * Returns an immutable instance of [PaginatedAccountOrderFulfillmentResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .data()
             * .paginationMetadata()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PaginatedAccountOrderFulfillmentResponse =
                PaginatedAccountOrderFulfillmentResponse(
                    checkRequired("data", data).map { it.toImmutable() },
                    checkRequired("paginationMetadata", paginationMetadata),
                    _sv,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws DinariInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): PaginatedAccountOrderFulfillmentResponse = apply {
            if (validated) {
                return@apply
            }

            data().forEach { it.validate() }
            paginationMetadata().validate()
            _sv().ifPresent { it.validate() }
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
            (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (paginationMetadata.asKnown().getOrNull()?.validity() ?: 0) +
                (_sv.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Information about a fulfillment of an `Order`. An order may be fulfilled in multiple
         * transactions.
         */
        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val assetTokenFilled: JsonField<Double>,
            private val assetTokenSpent: JsonField<Double>,
            private val chainId: JsonField<String>,
            private val orderId: JsonField<String>,
            private val paymentTokenFilled: JsonField<Double>,
            private val paymentTokenSpent: JsonField<Double>,
            private val transactionDt: JsonField<OffsetDateTime>,
            private val transactionHash: JsonField<String>,
            private val alloyId: JsonField<String>,
            private val paymentTokenFee: JsonField<Double>,
            private val stockId: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("asset_token_filled")
                @ExcludeMissing
                assetTokenFilled: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("asset_token_spent")
                @ExcludeMissing
                assetTokenSpent: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("chain_id")
                @ExcludeMissing
                chainId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("order_id")
                @ExcludeMissing
                orderId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("payment_token_filled")
                @ExcludeMissing
                paymentTokenFilled: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("payment_token_spent")
                @ExcludeMissing
                paymentTokenSpent: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("transaction_dt")
                @ExcludeMissing
                transactionDt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("transaction_hash")
                @ExcludeMissing
                transactionHash: JsonField<String> = JsonMissing.of(),
                @JsonProperty("alloy_id")
                @ExcludeMissing
                alloyId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("payment_token_fee")
                @ExcludeMissing
                paymentTokenFee: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("stock_id")
                @ExcludeMissing
                stockId: JsonField<String> = JsonMissing.of(),
            ) : this(
                id,
                assetTokenFilled,
                assetTokenSpent,
                chainId,
                orderId,
                paymentTokenFilled,
                paymentTokenSpent,
                transactionDt,
                transactionHash,
                alloyId,
                paymentTokenFee,
                stockId,
                mutableMapOf(),
            )

            /**
             * ID of the `OrderFulfillment`.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * Amount of dShare asset token filled for `BUY` orders.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun assetTokenFilled(): Double = assetTokenFilled.getRequired("asset_token_filled")

            /**
             * Amount of dShare asset token spent for `SELL` orders.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun assetTokenSpent(): Double = assetTokenSpent.getRequired("asset_token_spent")

            /**
             * Blockchain that the transaction was run on.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun chainId(): String = chainId.getRequired("chain_id")

            /**
             * ID of the `Order` this `OrderFulfillment` is for.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun orderId(): String = orderId.getRequired("order_id")

            /**
             * Amount of payment token filled for `SELL` orders.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun paymentTokenFilled(): Double =
                paymentTokenFilled.getRequired("payment_token_filled")

            /**
             * Amount of payment token spent for `BUY` orders.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun paymentTokenSpent(): Double = paymentTokenSpent.getRequired("payment_token_spent")

            /**
             * Time when transaction occurred.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun transactionDt(): OffsetDateTime = transactionDt.getRequired("transaction_dt")

            /**
             * Transaction hash for this fulfillment.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun transactionHash(): String = transactionHash.getRequired("transaction_hash")

            /**
             * The `Alloy` ID associated with the `Order`
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun alloyId(): Optional<String> = alloyId.getOptional("alloy_id")

            /**
             * Fee amount, in payment tokens.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun paymentTokenFee(): Optional<Double> =
                paymentTokenFee.getOptional("payment_token_fee")

            /**
             * The `Stock` ID associated with the `Order`
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun stockId(): Optional<String> = stockId.getOptional("stock_id")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [assetTokenFilled].
             *
             * Unlike [assetTokenFilled], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("asset_token_filled")
            @ExcludeMissing
            fun _assetTokenFilled(): JsonField<Double> = assetTokenFilled

            /**
             * Returns the raw JSON value of [assetTokenSpent].
             *
             * Unlike [assetTokenSpent], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("asset_token_spent")
            @ExcludeMissing
            fun _assetTokenSpent(): JsonField<Double> = assetTokenSpent

            /**
             * Returns the raw JSON value of [chainId].
             *
             * Unlike [chainId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("chain_id") @ExcludeMissing fun _chainId(): JsonField<String> = chainId

            /**
             * Returns the raw JSON value of [orderId].
             *
             * Unlike [orderId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("order_id") @ExcludeMissing fun _orderId(): JsonField<String> = orderId

            /**
             * Returns the raw JSON value of [paymentTokenFilled].
             *
             * Unlike [paymentTokenFilled], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("payment_token_filled")
            @ExcludeMissing
            fun _paymentTokenFilled(): JsonField<Double> = paymentTokenFilled

            /**
             * Returns the raw JSON value of [paymentTokenSpent].
             *
             * Unlike [paymentTokenSpent], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("payment_token_spent")
            @ExcludeMissing
            fun _paymentTokenSpent(): JsonField<Double> = paymentTokenSpent

            /**
             * Returns the raw JSON value of [transactionDt].
             *
             * Unlike [transactionDt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("transaction_dt")
            @ExcludeMissing
            fun _transactionDt(): JsonField<OffsetDateTime> = transactionDt

            /**
             * Returns the raw JSON value of [transactionHash].
             *
             * Unlike [transactionHash], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("transaction_hash")
            @ExcludeMissing
            fun _transactionHash(): JsonField<String> = transactionHash

            /**
             * Returns the raw JSON value of [alloyId].
             *
             * Unlike [alloyId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("alloy_id") @ExcludeMissing fun _alloyId(): JsonField<String> = alloyId

            /**
             * Returns the raw JSON value of [paymentTokenFee].
             *
             * Unlike [paymentTokenFee], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("payment_token_fee")
            @ExcludeMissing
            fun _paymentTokenFee(): JsonField<Double> = paymentTokenFee

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
                 * Returns a mutable builder for constructing an instance of [Data].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .assetTokenFilled()
                 * .assetTokenSpent()
                 * .chainId()
                 * .orderId()
                 * .paymentTokenFilled()
                 * .paymentTokenSpent()
                 * .transactionDt()
                 * .transactionHash()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var assetTokenFilled: JsonField<Double>? = null
                private var assetTokenSpent: JsonField<Double>? = null
                private var chainId: JsonField<String>? = null
                private var orderId: JsonField<String>? = null
                private var paymentTokenFilled: JsonField<Double>? = null
                private var paymentTokenSpent: JsonField<Double>? = null
                private var transactionDt: JsonField<OffsetDateTime>? = null
                private var transactionHash: JsonField<String>? = null
                private var alloyId: JsonField<String> = JsonMissing.of()
                private var paymentTokenFee: JsonField<Double> = JsonMissing.of()
                private var stockId: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    id = data.id
                    assetTokenFilled = data.assetTokenFilled
                    assetTokenSpent = data.assetTokenSpent
                    chainId = data.chainId
                    orderId = data.orderId
                    paymentTokenFilled = data.paymentTokenFilled
                    paymentTokenSpent = data.paymentTokenSpent
                    transactionDt = data.transactionDt
                    transactionHash = data.transactionHash
                    alloyId = data.alloyId
                    paymentTokenFee = data.paymentTokenFee
                    stockId = data.stockId
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                /** ID of the `OrderFulfillment`. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Amount of dShare asset token filled for `BUY` orders. */
                fun assetTokenFilled(assetTokenFilled: Double) =
                    assetTokenFilled(JsonField.of(assetTokenFilled))

                /**
                 * Sets [Builder.assetTokenFilled] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.assetTokenFilled] with a well-typed [Double]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun assetTokenFilled(assetTokenFilled: JsonField<Double>) = apply {
                    this.assetTokenFilled = assetTokenFilled
                }

                /** Amount of dShare asset token spent for `SELL` orders. */
                fun assetTokenSpent(assetTokenSpent: Double) =
                    assetTokenSpent(JsonField.of(assetTokenSpent))

                /**
                 * Sets [Builder.assetTokenSpent] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.assetTokenSpent] with a well-typed [Double]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun assetTokenSpent(assetTokenSpent: JsonField<Double>) = apply {
                    this.assetTokenSpent = assetTokenSpent
                }

                /** Blockchain that the transaction was run on. */
                fun chainId(chainId: String) = chainId(JsonField.of(chainId))

                /**
                 * Sets [Builder.chainId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.chainId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun chainId(chainId: JsonField<String>) = apply { this.chainId = chainId }

                /** ID of the `Order` this `OrderFulfillment` is for. */
                fun orderId(orderId: String) = orderId(JsonField.of(orderId))

                /**
                 * Sets [Builder.orderId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.orderId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun orderId(orderId: JsonField<String>) = apply { this.orderId = orderId }

                /** Amount of payment token filled for `SELL` orders. */
                fun paymentTokenFilled(paymentTokenFilled: Double) =
                    paymentTokenFilled(JsonField.of(paymentTokenFilled))

                /**
                 * Sets [Builder.paymentTokenFilled] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.paymentTokenFilled] with a well-typed [Double]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun paymentTokenFilled(paymentTokenFilled: JsonField<Double>) = apply {
                    this.paymentTokenFilled = paymentTokenFilled
                }

                /** Amount of payment token spent for `BUY` orders. */
                fun paymentTokenSpent(paymentTokenSpent: Double) =
                    paymentTokenSpent(JsonField.of(paymentTokenSpent))

                /**
                 * Sets [Builder.paymentTokenSpent] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.paymentTokenSpent] with a well-typed [Double]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun paymentTokenSpent(paymentTokenSpent: JsonField<Double>) = apply {
                    this.paymentTokenSpent = paymentTokenSpent
                }

                /** Time when transaction occurred. */
                fun transactionDt(transactionDt: OffsetDateTime) =
                    transactionDt(JsonField.of(transactionDt))

                /**
                 * Sets [Builder.transactionDt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transactionDt] with a well-typed
                 * [OffsetDateTime] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun transactionDt(transactionDt: JsonField<OffsetDateTime>) = apply {
                    this.transactionDt = transactionDt
                }

                /** Transaction hash for this fulfillment. */
                fun transactionHash(transactionHash: String) =
                    transactionHash(JsonField.of(transactionHash))

                /**
                 * Sets [Builder.transactionHash] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transactionHash] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun transactionHash(transactionHash: JsonField<String>) = apply {
                    this.transactionHash = transactionHash
                }

                /** The `Alloy` ID associated with the `Order` */
                fun alloyId(alloyId: String?) = alloyId(JsonField.ofNullable(alloyId))

                /** Alias for calling [Builder.alloyId] with `alloyId.orElse(null)`. */
                fun alloyId(alloyId: Optional<String>) = alloyId(alloyId.getOrNull())

                /**
                 * Sets [Builder.alloyId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.alloyId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun alloyId(alloyId: JsonField<String>) = apply { this.alloyId = alloyId }

                /** Fee amount, in payment tokens. */
                fun paymentTokenFee(paymentTokenFee: Double?) =
                    paymentTokenFee(JsonField.ofNullable(paymentTokenFee))

                /**
                 * Alias for [Builder.paymentTokenFee].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun paymentTokenFee(paymentTokenFee: Double) =
                    paymentTokenFee(paymentTokenFee as Double?)

                /**
                 * Alias for calling [Builder.paymentTokenFee] with `paymentTokenFee.orElse(null)`.
                 */
                fun paymentTokenFee(paymentTokenFee: Optional<Double>) =
                    paymentTokenFee(paymentTokenFee.getOrNull())

                /**
                 * Sets [Builder.paymentTokenFee] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.paymentTokenFee] with a well-typed [Double]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun paymentTokenFee(paymentTokenFee: JsonField<Double>) = apply {
                    this.paymentTokenFee = paymentTokenFee
                }

                /** The `Stock` ID associated with the `Order` */
                fun stockId(stockId: String?) = stockId(JsonField.ofNullable(stockId))

                /** Alias for calling [Builder.stockId] with `stockId.orElse(null)`. */
                fun stockId(stockId: Optional<String>) = stockId(stockId.getOrNull())

                /**
                 * Sets [Builder.stockId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.stockId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun stockId(stockId: JsonField<String>) = apply { this.stockId = stockId }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .assetTokenFilled()
                 * .assetTokenSpent()
                 * .chainId()
                 * .orderId()
                 * .paymentTokenFilled()
                 * .paymentTokenSpent()
                 * .transactionDt()
                 * .transactionHash()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Data =
                    Data(
                        checkRequired("id", id),
                        checkRequired("assetTokenFilled", assetTokenFilled),
                        checkRequired("assetTokenSpent", assetTokenSpent),
                        checkRequired("chainId", chainId),
                        checkRequired("orderId", orderId),
                        checkRequired("paymentTokenFilled", paymentTokenFilled),
                        checkRequired("paymentTokenSpent", paymentTokenSpent),
                        checkRequired("transactionDt", transactionDt),
                        checkRequired("transactionHash", transactionHash),
                        alloyId,
                        paymentTokenFee,
                        stockId,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws DinariInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                id()
                assetTokenFilled()
                assetTokenSpent()
                chainId()
                orderId()
                paymentTokenFilled()
                paymentTokenSpent()
                transactionDt()
                transactionHash()
                alloyId()
                paymentTokenFee()
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (assetTokenFilled.asKnown().isPresent) 1 else 0) +
                    (if (assetTokenSpent.asKnown().isPresent) 1 else 0) +
                    (if (chainId.asKnown().isPresent) 1 else 0) +
                    (if (orderId.asKnown().isPresent) 1 else 0) +
                    (if (paymentTokenFilled.asKnown().isPresent) 1 else 0) +
                    (if (paymentTokenSpent.asKnown().isPresent) 1 else 0) +
                    (if (transactionDt.asKnown().isPresent) 1 else 0) +
                    (if (transactionHash.asKnown().isPresent) 1 else 0) +
                    (if (alloyId.asKnown().isPresent) 1 else 0) +
                    (if (paymentTokenFee.asKnown().isPresent) 1 else 0) +
                    (if (stockId.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    id == other.id &&
                    assetTokenFilled == other.assetTokenFilled &&
                    assetTokenSpent == other.assetTokenSpent &&
                    chainId == other.chainId &&
                    orderId == other.orderId &&
                    paymentTokenFilled == other.paymentTokenFilled &&
                    paymentTokenSpent == other.paymentTokenSpent &&
                    transactionDt == other.transactionDt &&
                    transactionHash == other.transactionHash &&
                    alloyId == other.alloyId &&
                    paymentTokenFee == other.paymentTokenFee &&
                    stockId == other.stockId &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    assetTokenFilled,
                    assetTokenSpent,
                    chainId,
                    orderId,
                    paymentTokenFilled,
                    paymentTokenSpent,
                    transactionDt,
                    transactionHash,
                    alloyId,
                    paymentTokenFee,
                    stockId,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{id=$id, assetTokenFilled=$assetTokenFilled, assetTokenSpent=$assetTokenSpent, chainId=$chainId, orderId=$orderId, paymentTokenFilled=$paymentTokenFilled, paymentTokenSpent=$paymentTokenSpent, transactionDt=$transactionDt, transactionHash=$transactionHash, alloyId=$alloyId, paymentTokenFee=$paymentTokenFee, stockId=$stockId, additionalProperties=$additionalProperties}"
        }

        /** Pagination metadata */
        class PaginationMetadata
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val next: JsonField<String>,
            private val previous: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("next") @ExcludeMissing next: JsonField<String> = JsonMissing.of(),
                @JsonProperty("previous")
                @ExcludeMissing
                previous: JsonField<String> = JsonMissing.of(),
            ) : this(next, previous, mutableMapOf())

            /**
             * Cursor for next page
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun next(): Optional<String> = next.getOptional("next")

            /**
             * Cursor for previous page
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun previous(): Optional<String> = previous.getOptional("previous")

            /**
             * Returns the raw JSON value of [next].
             *
             * Unlike [next], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("next") @ExcludeMissing fun _next(): JsonField<String> = next

            /**
             * Returns the raw JSON value of [previous].
             *
             * Unlike [previous], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("previous") @ExcludeMissing fun _previous(): JsonField<String> = previous

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
                 * Returns a mutable builder for constructing an instance of [PaginationMetadata].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [PaginationMetadata]. */
            class Builder internal constructor() {

                private var next: JsonField<String> = JsonMissing.of()
                private var previous: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(paginationMetadata: PaginationMetadata) = apply {
                    next = paginationMetadata.next
                    previous = paginationMetadata.previous
                    additionalProperties = paginationMetadata.additionalProperties.toMutableMap()
                }

                /** Cursor for next page */
                fun next(next: String) = next(JsonField.of(next))

                /**
                 * Sets [Builder.next] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.next] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun next(next: JsonField<String>) = apply { this.next = next }

                /** Cursor for previous page */
                fun previous(previous: String) = previous(JsonField.of(previous))

                /**
                 * Sets [Builder.previous] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.previous] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun previous(previous: JsonField<String>) = apply { this.previous = previous }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [PaginationMetadata].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): PaginationMetadata =
                    PaginationMetadata(next, previous, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws DinariInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): PaginationMetadata = apply {
                if (validated) {
                    return@apply
                }

                next()
                previous()
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
                (if (next.asKnown().isPresent) 1 else 0) +
                    (if (previous.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is PaginationMetadata &&
                    next == other.next &&
                    previous == other.previous &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(next, previous, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "PaginationMetadata{next=$next, previous=$previous, additionalProperties=$additionalProperties}"
        }

        /** Version */
        class _Sv @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField
                val PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1 =
                    of("PaginatedAccountOrderFulfillmentResponse:v1")

                @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
            }

            /** An enum containing [_Sv]'s known values. */
            enum class Known {
                PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
            }

            /**
             * An enum containing [_Sv]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [_Sv] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1,
                /** An enum member indicating that [_Sv] was instantiated with an unknown value. */
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
                    PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1 ->
                        Value.PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
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
                    PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1 ->
                        Known.PAGINATED_ACCOUNT_ORDER_FULFILLMENT_RESPONSE_V1
                    else -> throw DinariInvalidDataException("Unknown _Sv: $value")
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

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws DinariInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): _Sv = apply {
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

                return other is _Sv && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PaginatedAccountOrderFulfillmentResponse &&
                data == other.data &&
                paginationMetadata == other.paginationMetadata &&
                _sv == other._sv &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(data, paginationMetadata, _sv, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PaginatedAccountOrderFulfillmentResponse{data=$data, paginationMetadata=$paginationMetadata, _sv=$_sv, additionalProperties=$additionalProperties}"
    }
}
