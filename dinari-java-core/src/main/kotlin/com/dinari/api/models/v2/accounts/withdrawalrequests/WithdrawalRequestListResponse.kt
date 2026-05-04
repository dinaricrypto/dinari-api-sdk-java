// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.withdrawalrequests

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = WithdrawalRequestListResponse.Deserializer::class)
@JsonSerialize(using = WithdrawalRequestListResponse.Serializer::class)
class WithdrawalRequestListResponse
private constructor(
    private val requests: List<WithdrawalRequest>? = null,
    private val paginatedWithdrawalRequest: PaginatedWithdrawalRequestResponse? = null,
    private val _json: JsonValue? = null,
) {

    fun requests(): Optional<List<WithdrawalRequest>> = Optional.ofNullable(requests)

    fun paginatedWithdrawalRequest(): Optional<PaginatedWithdrawalRequestResponse> =
        Optional.ofNullable(paginatedWithdrawalRequest)

    fun isRequests(): Boolean = requests != null

    fun isPaginatedWithdrawalRequest(): Boolean = paginatedWithdrawalRequest != null

    fun asRequests(): List<WithdrawalRequest> = requests.getOrThrow("requests")

    fun asPaginatedWithdrawalRequest(): PaginatedWithdrawalRequestResponse =
        paginatedWithdrawalRequest.getOrThrow("paginatedWithdrawalRequest")

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
     * Optional<String> result = withdrawalRequestListResponse.accept(new WithdrawalRequestListResponse.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitRequests(List<WithdrawalRequest> requests) {
     *         return Optional.of(requests.toString());
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
            requests != null -> visitor.visitRequests(requests)
            paginatedWithdrawalRequest != null ->
                visitor.visitPaginatedWithdrawalRequest(paginatedWithdrawalRequest)
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
    fun validate(): WithdrawalRequestListResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitRequests(requests: List<WithdrawalRequest>) {
                    requests.forEach { it.validate() }
                }

                override fun visitPaginatedWithdrawalRequest(
                    paginatedWithdrawalRequest: PaginatedWithdrawalRequestResponse
                ) {
                    paginatedWithdrawalRequest.validate()
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
                override fun visitRequests(requests: List<WithdrawalRequest>) =
                    requests.sumOf { it.validity().toInt() }

                override fun visitPaginatedWithdrawalRequest(
                    paginatedWithdrawalRequest: PaginatedWithdrawalRequestResponse
                ) = paginatedWithdrawalRequest.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WithdrawalRequestListResponse &&
            requests == other.requests &&
            paginatedWithdrawalRequest == other.paginatedWithdrawalRequest
    }

    override fun hashCode(): Int = Objects.hash(requests, paginatedWithdrawalRequest)

    override fun toString(): String =
        when {
            requests != null -> "WithdrawalRequestListResponse{requests=$requests}"
            paginatedWithdrawalRequest != null ->
                "WithdrawalRequestListResponse{paginatedWithdrawalRequest=$paginatedWithdrawalRequest}"
            _json != null -> "WithdrawalRequestListResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid WithdrawalRequestListResponse")
        }

    companion object {

        @JvmStatic
        fun ofRequests(requests: List<WithdrawalRequest>) =
            WithdrawalRequestListResponse(requests = requests.toImmutable())

        @JvmStatic
        fun ofPaginatedWithdrawalRequest(
            paginatedWithdrawalRequest: PaginatedWithdrawalRequestResponse
        ) = WithdrawalRequestListResponse(paginatedWithdrawalRequest = paginatedWithdrawalRequest)
    }

    /**
     * An interface that defines how to map each variant of [WithdrawalRequestListResponse] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        fun visitRequests(requests: List<WithdrawalRequest>): T

        fun visitPaginatedWithdrawalRequest(
            paginatedWithdrawalRequest: PaginatedWithdrawalRequestResponse
        ): T

        /**
         * Maps an unknown variant of [WithdrawalRequestListResponse] to a value of type [T].
         *
         * An instance of [WithdrawalRequestListResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws DinariInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw DinariInvalidDataException("Unknown WithdrawalRequestListResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<WithdrawalRequestListResponse>(WithdrawalRequestListResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): WithdrawalRequestListResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<PaginatedWithdrawalRequestResponse>())
                            ?.let {
                                WithdrawalRequestListResponse(
                                    paginatedWithdrawalRequest = it,
                                    _json = json,
                                )
                            },
                        tryDeserialize(node, jacksonTypeRef<List<WithdrawalRequest>>())?.let {
                            WithdrawalRequestListResponse(requests = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> WithdrawalRequestListResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<WithdrawalRequestListResponse>(WithdrawalRequestListResponse::class) {

        override fun serialize(
            value: WithdrawalRequestListResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.requests != null -> generator.writeObject(value.requests)
                value.paginatedWithdrawalRequest != null ->
                    generator.writeObject(value.paginatedWithdrawalRequest)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid WithdrawalRequestListResponse")
            }
        }
    }

    class PaginatedWithdrawalRequestResponse
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val data: JsonField<List<WithdrawalRequest>>,
        private val paginationMetadata: JsonField<PaginationMetadata>,
        private val _sv: JsonField<_Sv>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data")
            @ExcludeMissing
            data: JsonField<List<WithdrawalRequest>> = JsonMissing.of(),
            @JsonProperty("pagination_metadata")
            @ExcludeMissing
            paginationMetadata: JsonField<PaginationMetadata> = JsonMissing.of(),
            @JsonProperty("_sv") @ExcludeMissing _sv: JsonField<_Sv> = JsonMissing.of(),
        ) : this(data, paginationMetadata, _sv, mutableMapOf())

        /**
         * List of WithdrawalRequest
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): List<WithdrawalRequest> = data.getRequired("data")

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
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<WithdrawalRequest>> = data

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
             * [PaginatedWithdrawalRequestResponse].
             *
             * The following fields are required:
             * ```java
             * .data()
             * .paginationMetadata()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PaginatedWithdrawalRequestResponse]. */
        class Builder internal constructor() {

            private var data: JsonField<MutableList<WithdrawalRequest>>? = null
            private var paginationMetadata: JsonField<PaginationMetadata>? = null
            private var _sv: JsonField<_Sv> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                paginatedWithdrawalRequestResponse: PaginatedWithdrawalRequestResponse
            ) = apply {
                data = paginatedWithdrawalRequestResponse.data.map { it.toMutableList() }
                paginationMetadata = paginatedWithdrawalRequestResponse.paginationMetadata
                _sv = paginatedWithdrawalRequestResponse._sv
                additionalProperties =
                    paginatedWithdrawalRequestResponse.additionalProperties.toMutableMap()
            }

            /** List of WithdrawalRequest */
            fun data(data: List<WithdrawalRequest>) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed `List<WithdrawalRequest>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun data(data: JsonField<List<WithdrawalRequest>>) = apply {
                this.data = data.map { it.toMutableList() }
            }

            /**
             * Adds a single [WithdrawalRequest] to [Builder.data].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addData(data: WithdrawalRequest) = apply {
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
             * Returns an immutable instance of [PaginatedWithdrawalRequestResponse].
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
            fun build(): PaginatedWithdrawalRequestResponse =
                PaginatedWithdrawalRequestResponse(
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
        fun validate(): PaginatedWithdrawalRequestResponse = apply {
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
                val PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1 =
                    of("PaginatedWithdrawalRequestResponse:v1")

                @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
            }

            /** An enum containing [_Sv]'s known values. */
            enum class Known {
                PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1
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
                PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1,
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
                    PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1 ->
                        Value.PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1
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
                    PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1 ->
                        Known.PAGINATED_WITHDRAWAL_REQUEST_RESPONSE_V1
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

            return other is PaginatedWithdrawalRequestResponse &&
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
            "PaginatedWithdrawalRequestResponse{data=$data, paginationMetadata=$paginationMetadata, _sv=$_sv, additionalProperties=$additionalProperties}"
    }
}
