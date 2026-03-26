// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.marketdata.alloys

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Paginated response containing a list of Alloys. */
class AlloyListResponse
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
     * List of Alloys
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
     * Schema version
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
     * Unlike [paginationMetadata], this method doesn't throw if the JSON field has an unexpected
     * type.
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
         * Returns a mutable builder for constructing an instance of [AlloyListResponse].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .paginationMetadata()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AlloyListResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<Data>>? = null
        private var paginationMetadata: JsonField<PaginationMetadata>? = null
        private var _sv: JsonField<_Sv> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(alloyListResponse: AlloyListResponse) = apply {
            data = alloyListResponse.data.map { it.toMutableList() }
            paginationMetadata = alloyListResponse.paginationMetadata
            _sv = alloyListResponse._sv
            additionalProperties = alloyListResponse.additionalProperties.toMutableMap()
        }

        /** List of Alloys */
        fun data(data: List<Data>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<Data>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * [PaginationMetadata] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun paginationMetadata(paginationMetadata: JsonField<PaginationMetadata>) = apply {
            this.paginationMetadata = paginationMetadata
        }

        /** Schema version */
        fun _sv(_sv: _Sv) = _sv(JsonField.of(_sv))

        /**
         * Sets [Builder._sv] to an arbitrary JSON value.
         *
         * You should usually call [Builder._sv] with a well-typed [_Sv] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [AlloyListResponse].
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
        fun build(): AlloyListResponse =
            AlloyListResponse(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("paginationMetadata", paginationMetadata),
                _sv,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AlloyListResponse = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (paginationMetadata.asKnown().getOrNull()?.validity() ?: 0) +
            (_sv.asKnown().getOrNull()?.validity() ?: 0)

    /** Alloy details. */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val isTradable: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val symbol: JsonField<String>,
        private val _sv: JsonField<_Sv>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_tradable")
            @ExcludeMissing
            isTradable: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("symbol") @ExcludeMissing symbol: JsonField<String> = JsonMissing.of(),
            @JsonProperty("_sv") @ExcludeMissing _sv: JsonField<_Sv> = JsonMissing.of(),
        ) : this(id, isTradable, name, symbol, _sv, mutableMapOf())

        /**
         * Unique identifier of the Alloy asset
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Indicates if tradable on Dinari platform
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isTradable(): Boolean = isTradable.getRequired("is_tradable")

        /**
         * Name of the Alloy
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Symbol of the Alloy
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun symbol(): String = symbol.getRequired("symbol")

        /**
         * Schema version
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun _sv(): Optional<_Sv> = _sv.getOptional("_sv")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [isTradable].
         *
         * Unlike [isTradable], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_tradable")
        @ExcludeMissing
        fun _isTradable(): JsonField<Boolean> = isTradable

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [symbol].
         *
         * Unlike [symbol], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("symbol") @ExcludeMissing fun _symbol(): JsonField<String> = symbol

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
             * Returns a mutable builder for constructing an instance of [Data].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .isTradable()
             * .name()
             * .symbol()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var isTradable: JsonField<Boolean>? = null
            private var name: JsonField<String>? = null
            private var symbol: JsonField<String>? = null
            private var _sv: JsonField<_Sv> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                isTradable = data.isTradable
                name = data.name
                symbol = data.symbol
                _sv = data._sv
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** Unique identifier of the Alloy asset */
            fun id(id: String?) = id(JsonField.ofNullable(id))

            /** Alias for calling [Builder.id] with `id.orElse(null)`. */
            fun id(id: Optional<String>) = id(id.getOrNull())

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Indicates if tradable on Dinari platform */
            fun isTradable(isTradable: Boolean) = isTradable(JsonField.of(isTradable))

            /**
             * Sets [Builder.isTradable] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isTradable] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isTradable(isTradable: JsonField<Boolean>) = apply { this.isTradable = isTradable }

            /** Name of the Alloy */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Symbol of the Alloy */
            fun symbol(symbol: String) = symbol(JsonField.of(symbol))

            /**
             * Sets [Builder.symbol] to an arbitrary JSON value.
             *
             * You should usually call [Builder.symbol] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun symbol(symbol: JsonField<String>) = apply { this.symbol = symbol }

            /** Schema version */
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .isTradable()
             * .name()
             * .symbol()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Data =
                Data(
                    checkRequired("id", id),
                    checkRequired("isTradable", isTradable),
                    checkRequired("name", name),
                    checkRequired("symbol", symbol),
                    _sv,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            id()
            isTradable()
            name()
            symbol()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (isTradable.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (symbol.asKnown().isPresent) 1 else 0) +
                (_sv.asKnown().getOrNull()?.validity() ?: 0)

        /** Schema version */
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

                @JvmField val ALLOY_V1 = of("Alloy:v1")

                @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
            }

            /** An enum containing [_Sv]'s known values. */
            enum class Known {
                ALLOY_V1
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
                ALLOY_V1,
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
                    ALLOY_V1 -> Value.ALLOY_V1
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
                    ALLOY_V1 -> Known.ALLOY_V1
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

            return other is Data &&
                id == other.id &&
                isTradable == other.isTradable &&
                name == other.name &&
                symbol == other.symbol &&
                _sv == other._sv &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, isTradable, name, symbol, _sv, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, isTradable=$isTradable, name=$name, symbol=$symbol, _sv=$_sv, additionalProperties=$additionalProperties}"
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
            @JsonProperty("previous") @ExcludeMissing previous: JsonField<String> = JsonMissing.of(),
        ) : this(next, previous, mutableMapOf())

        /**
         * Cursor for next page
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun next(): Optional<String> = next.getOptional("next")

        /**
         * Cursor for previous page
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
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
         * Unlike [previous], this method doesn't throw if the JSON field has an unexpected type.
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

            /** Returns a mutable builder for constructing an instance of [PaginationMetadata]. */
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
             * You should usually call [Builder.next] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun next(next: JsonField<String>) = apply { this.next = next }

            /** Cursor for previous page */
            fun previous(previous: String) = previous(JsonField.of(previous))

            /**
             * Sets [Builder.previous] to an arbitrary JSON value.
             *
             * You should usually call [Builder.previous] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun previous(previous: JsonField<String>) = apply { this.previous = previous }

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
             * Returns an immutable instance of [PaginationMetadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): PaginationMetadata =
                PaginationMetadata(next, previous, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

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
            (if (next.asKnown().isPresent) 1 else 0) + (if (previous.asKnown().isPresent) 1 else 0)

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

    /** Schema version */
    class _Sv @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PAGINATED_ALLOY_RESPONSE_V1 = of("PaginatedAlloyResponse:v1")

            @JvmStatic fun of(value: String) = _Sv(JsonField.of(value))
        }

        /** An enum containing [_Sv]'s known values. */
        enum class Known {
            PAGINATED_ALLOY_RESPONSE_V1
        }

        /**
         * An enum containing [_Sv]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [_Sv] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PAGINATED_ALLOY_RESPONSE_V1,
            /** An enum member indicating that [_Sv] was instantiated with an unknown value. */
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
                PAGINATED_ALLOY_RESPONSE_V1 -> Value.PAGINATED_ALLOY_RESPONSE_V1
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
                PAGINATED_ALLOY_RESPONSE_V1 -> Known.PAGINATED_ALLOY_RESPONSE_V1
                else -> throw DinariInvalidDataException("Unknown _Sv: $value")
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

        return other is AlloyListResponse &&
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
        "AlloyListResponse{data=$data, paginationMetadata=$paginationMetadata, _sv=$_sv, additionalProperties=$additionalProperties}"
}
