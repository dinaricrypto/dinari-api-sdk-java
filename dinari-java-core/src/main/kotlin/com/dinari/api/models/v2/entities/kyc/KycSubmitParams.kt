// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

import com.dinari.api.core.BaseDeserializer
import com.dinari.api.core.BaseSerializer
import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.Params
import com.dinari.api.core.checkRequired
import com.dinari.api.core.getOrThrow
import com.dinari.api.core.http.Headers
import com.dinari.api.core.http.QueryParams
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

/**
 * Submit KYC data directly, for partners that are provisioned to provide their own KYC data.
 *
 * This feature is available for everyone in sandbox mode, and for specifically provisioned partners
 * in production.
 */
class KycSubmitParams
private constructor(
    private val entityId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun entityId(): Optional<String> = Optional.ofNullable(entityId)

    /**
     * Input parameters for providing KYC information for an `Entity` in the baseline jurisdiction.
     */
    fun body(): Body = body

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [KycSubmitParams].
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [KycSubmitParams]. */
    class Builder internal constructor() {

        private var entityId: String? = null
        private var body: Body? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(kycSubmitParams: KycSubmitParams) = apply {
            entityId = kycSubmitParams.entityId
            body = kycSubmitParams.body
            additionalHeaders = kycSubmitParams.additionalHeaders.toBuilder()
            additionalQueryParams = kycSubmitParams.additionalQueryParams.toBuilder()
        }

        fun entityId(entityId: String?) = apply { this.entityId = entityId }

        /** Alias for calling [Builder.entityId] with `entityId.orElse(null)`. */
        fun entityId(entityId: Optional<String>) = entityId(entityId.getOrNull())

        /**
         * Input parameters for providing KYC information for an `Entity` in the baseline
         * jurisdiction.
         */
        fun body(body: Body) = apply { this.body = body }

        /** Alias for calling [body] with `Body.ofBaseline(baseline)`. */
        fun body(baseline: Body.Baseline) = body(Body.ofBaseline(baseline))

        /** Alias for calling [body] with `Body.ofUs(us)`. */
        fun body(us: Body.Us) = body(Body.ofUs(us))

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [KycSubmitParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .body()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): KycSubmitParams =
            KycSubmitParams(
                entityId,
                checkRequired("body", body),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> entityId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Input parameters for providing KYC information for an `Entity` in the baseline jurisdiction.
     */
    @JsonDeserialize(using = Body.Deserializer::class)
    @JsonSerialize(using = Body.Serializer::class)
    class Body
    private constructor(
        private val baseline: Baseline? = null,
        private val us: Us? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * Input parameters for providing KYC information for an `Entity` in the baseline
         * jurisdiction.
         */
        fun baseline(): Optional<Baseline> = Optional.ofNullable(baseline)

        /**
         * Input parameters for providing KYC information for an `Entity` in the US jurisdiction.
         */
        fun us(): Optional<Us> = Optional.ofNullable(us)

        fun isBaseline(): Boolean = baseline != null

        fun isUs(): Boolean = us != null

        /**
         * Input parameters for providing KYC information for an `Entity` in the baseline
         * jurisdiction.
         */
        fun asBaseline(): Baseline = baseline.getOrThrow("baseline")

        /**
         * Input parameters for providing KYC information for an `Entity` in the US jurisdiction.
         */
        fun asUs(): Us = us.getOrThrow("us")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                baseline != null -> visitor.visitBaseline(baseline)
                us != null -> visitor.visitUs(us)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBaseline(baseline: Baseline) {
                        baseline.validate()
                    }

                    override fun visitUs(us: Us) {
                        us.validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitBaseline(baseline: Baseline) = baseline.validity()

                    override fun visitUs(us: Us) = us.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body && baseline == other.baseline && us == other.us
        }

        override fun hashCode(): Int = Objects.hash(baseline, us)

        override fun toString(): String =
            when {
                baseline != null -> "Body{baseline=$baseline}"
                us != null -> "Body{us=$us}"
                _json != null -> "Body{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Body")
            }

        companion object {

            /**
             * Input parameters for providing KYC information for an `Entity` in the baseline
             * jurisdiction.
             */
            @JvmStatic fun ofBaseline(baseline: Baseline) = Body(baseline = baseline)

            /**
             * Input parameters for providing KYC information for an `Entity` in the US
             * jurisdiction.
             */
            @JvmStatic fun ofUs(us: Us) = Body(us = us)
        }

        /** An interface that defines how to map each variant of [Body] to a value of type [T]. */
        interface Visitor<out T> {

            /**
             * Input parameters for providing KYC information for an `Entity` in the baseline
             * jurisdiction.
             */
            fun visitBaseline(baseline: Baseline): T

            /**
             * Input parameters for providing KYC information for an `Entity` in the US
             * jurisdiction.
             */
            fun visitUs(us: Us): T

            /**
             * Maps an unknown variant of [Body] to a value of type [T].
             *
             * An instance of [Body] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws DinariInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw DinariInvalidDataException("Unknown Body: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Body>(Body::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Body {
                val json = JsonValue.fromJsonNode(node)
                val jurisdiction =
                    json.asObject().getOrNull()?.get("jurisdiction")?.asString()?.getOrNull()

                when (jurisdiction) {
                    "BASELINE" -> {
                        return tryDeserialize(node, jacksonTypeRef<Baseline>())?.let {
                            Body(baseline = it, _json = json)
                        } ?: Body(_json = json)
                    }
                    "US" -> {
                        return tryDeserialize(node, jacksonTypeRef<Us>())?.let {
                            Body(us = it, _json = json)
                        } ?: Body(_json = json)
                    }
                }

                return Body(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Body>(Body::class) {

            override fun serialize(
                value: Body,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.baseline != null -> generator.writeObject(value.baseline)
                    value.us != null -> generator.writeObject(value.us)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Body")
                }
            }
        }

        /**
         * Input parameters for providing KYC information for an `Entity` in the baseline
         * jurisdiction.
         */
        class Baseline
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val data: JsonField<BaselineKycCheckData>,
            private val providerName: JsonField<String>,
            private val jurisdiction: JsonField<Jurisdiction>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("data")
                @ExcludeMissing
                data: JsonField<BaselineKycCheckData> = JsonMissing.of(),
                @JsonProperty("provider_name")
                @ExcludeMissing
                providerName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("jurisdiction")
                @ExcludeMissing
                jurisdiction: JsonField<Jurisdiction> = JsonMissing.of(),
            ) : this(data, providerName, jurisdiction, mutableMapOf())

            /**
             * KYC data for an `Entity` in the BASELINE jurisdiction.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun data(): BaselineKycCheckData = data.getRequired("data")

            /**
             * Name of the KYC provider that provided the KYC information.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun providerName(): String = providerName.getRequired("provider_name")

            /**
             * Jurisdiction of the KYC check.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun jurisdiction(): Optional<Jurisdiction> = jurisdiction.getOptional("jurisdiction")

            /**
             * Returns the raw JSON value of [data].
             *
             * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("data")
            @ExcludeMissing
            fun _data(): JsonField<BaselineKycCheckData> = data

            /**
             * Returns the raw JSON value of [providerName].
             *
             * Unlike [providerName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("provider_name")
            @ExcludeMissing
            fun _providerName(): JsonField<String> = providerName

            /**
             * Returns the raw JSON value of [jurisdiction].
             *
             * Unlike [jurisdiction], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("jurisdiction")
            @ExcludeMissing
            fun _jurisdiction(): JsonField<Jurisdiction> = jurisdiction

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
                 * Returns a mutable builder for constructing an instance of [Baseline].
                 *
                 * The following fields are required:
                 * ```java
                 * .data()
                 * .providerName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Baseline]. */
            class Builder internal constructor() {

                private var data: JsonField<BaselineKycCheckData>? = null
                private var providerName: JsonField<String>? = null
                private var jurisdiction: JsonField<Jurisdiction> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(baseline: Baseline) = apply {
                    data = baseline.data
                    providerName = baseline.providerName
                    jurisdiction = baseline.jurisdiction
                    additionalProperties = baseline.additionalProperties.toMutableMap()
                }

                /** KYC data for an `Entity` in the BASELINE jurisdiction. */
                fun data(data: BaselineKycCheckData) = data(JsonField.of(data))

                /**
                 * Sets [Builder.data] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.data] with a well-typed [BaselineKycCheckData]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun data(data: JsonField<BaselineKycCheckData>) = apply { this.data = data }

                /** Name of the KYC provider that provided the KYC information. */
                fun providerName(providerName: String) = providerName(JsonField.of(providerName))

                /**
                 * Sets [Builder.providerName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.providerName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun providerName(providerName: JsonField<String>) = apply {
                    this.providerName = providerName
                }

                /** Jurisdiction of the KYC check. */
                fun jurisdiction(jurisdiction: Jurisdiction) =
                    jurisdiction(JsonField.of(jurisdiction))

                /**
                 * Sets [Builder.jurisdiction] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.jurisdiction] with a well-typed [Jurisdiction]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun jurisdiction(jurisdiction: JsonField<Jurisdiction>) = apply {
                    this.jurisdiction = jurisdiction
                }

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
                 * Returns an immutable instance of [Baseline].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .data()
                 * .providerName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Baseline =
                    Baseline(
                        checkRequired("data", data),
                        checkRequired("providerName", providerName),
                        jurisdiction,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Baseline = apply {
                if (validated) {
                    return@apply
                }

                data().validate()
                providerName()
                jurisdiction().ifPresent { it.validate() }
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
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (providerName.asKnown().isPresent) 1 else 0) +
                    (jurisdiction.asKnown().getOrNull()?.validity() ?: 0)

            /** Jurisdiction of the KYC check. */
            class Jurisdiction
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val BASELINE = of("BASELINE")

                    @JvmStatic fun of(value: String) = Jurisdiction(JsonField.of(value))
                }

                /** An enum containing [Jurisdiction]'s known values. */
                enum class Known {
                    BASELINE
                }

                /**
                 * An enum containing [Jurisdiction]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [Jurisdiction] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    BASELINE,
                    /**
                     * An enum member indicating that [Jurisdiction] was instantiated with an
                     * unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        BASELINE -> Value.BASELINE
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws DinariInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        BASELINE -> Known.BASELINE
                        else -> throw DinariInvalidDataException("Unknown Jurisdiction: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws DinariInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        DinariInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): Jurisdiction = apply {
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

                    return other is Jurisdiction && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Baseline &&
                    data == other.data &&
                    providerName == other.providerName &&
                    jurisdiction == other.jurisdiction &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(data, providerName, jurisdiction, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Baseline{data=$data, providerName=$providerName, jurisdiction=$jurisdiction, additionalProperties=$additionalProperties}"
        }

        /**
         * Input parameters for providing KYC information for an `Entity` in the US jurisdiction.
         */
        class Us
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val data: JsonField<UsKycCheckData>,
            private val providerName: JsonField<String>,
            private val jurisdiction: JsonField<Jurisdiction>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("data")
                @ExcludeMissing
                data: JsonField<UsKycCheckData> = JsonMissing.of(),
                @JsonProperty("provider_name")
                @ExcludeMissing
                providerName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("jurisdiction")
                @ExcludeMissing
                jurisdiction: JsonField<Jurisdiction> = JsonMissing.of(),
            ) : this(data, providerName, jurisdiction, mutableMapOf())

            /**
             * KYC data for an `Entity` in the US jurisdiction.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun data(): UsKycCheckData = data.getRequired("data")

            /**
             * Name of the KYC provider that provided the KYC information.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun providerName(): String = providerName.getRequired("provider_name")

            /**
             * Jurisdiction of the KYC check.
             *
             * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun jurisdiction(): Optional<Jurisdiction> = jurisdiction.getOptional("jurisdiction")

            /**
             * Returns the raw JSON value of [data].
             *
             * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<UsKycCheckData> = data

            /**
             * Returns the raw JSON value of [providerName].
             *
             * Unlike [providerName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("provider_name")
            @ExcludeMissing
            fun _providerName(): JsonField<String> = providerName

            /**
             * Returns the raw JSON value of [jurisdiction].
             *
             * Unlike [jurisdiction], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("jurisdiction")
            @ExcludeMissing
            fun _jurisdiction(): JsonField<Jurisdiction> = jurisdiction

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
                 * Returns a mutable builder for constructing an instance of [Us].
                 *
                 * The following fields are required:
                 * ```java
                 * .data()
                 * .providerName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Us]. */
            class Builder internal constructor() {

                private var data: JsonField<UsKycCheckData>? = null
                private var providerName: JsonField<String>? = null
                private var jurisdiction: JsonField<Jurisdiction> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(us: Us) = apply {
                    data = us.data
                    providerName = us.providerName
                    jurisdiction = us.jurisdiction
                    additionalProperties = us.additionalProperties.toMutableMap()
                }

                /** KYC data for an `Entity` in the US jurisdiction. */
                fun data(data: UsKycCheckData) = data(JsonField.of(data))

                /**
                 * Sets [Builder.data] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.data] with a well-typed [UsKycCheckData] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun data(data: JsonField<UsKycCheckData>) = apply { this.data = data }

                /** Name of the KYC provider that provided the KYC information. */
                fun providerName(providerName: String) = providerName(JsonField.of(providerName))

                /**
                 * Sets [Builder.providerName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.providerName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun providerName(providerName: JsonField<String>) = apply {
                    this.providerName = providerName
                }

                /** Jurisdiction of the KYC check. */
                fun jurisdiction(jurisdiction: Jurisdiction) =
                    jurisdiction(JsonField.of(jurisdiction))

                /**
                 * Sets [Builder.jurisdiction] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.jurisdiction] with a well-typed [Jurisdiction]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun jurisdiction(jurisdiction: JsonField<Jurisdiction>) = apply {
                    this.jurisdiction = jurisdiction
                }

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
                 * Returns an immutable instance of [Us].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .data()
                 * .providerName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Us =
                    Us(
                        checkRequired("data", data),
                        checkRequired("providerName", providerName),
                        jurisdiction,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Us = apply {
                if (validated) {
                    return@apply
                }

                data().validate()
                providerName()
                jurisdiction().ifPresent { it.validate() }
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
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (providerName.asKnown().isPresent) 1 else 0) +
                    (jurisdiction.asKnown().getOrNull()?.validity() ?: 0)

            /** Jurisdiction of the KYC check. */
            class Jurisdiction
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val US = of("US")

                    @JvmStatic fun of(value: String) = Jurisdiction(JsonField.of(value))
                }

                /** An enum containing [Jurisdiction]'s known values. */
                enum class Known {
                    US
                }

                /**
                 * An enum containing [Jurisdiction]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [Jurisdiction] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    US,
                    /**
                     * An enum member indicating that [Jurisdiction] was instantiated with an
                     * unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        US -> Value.US
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws DinariInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        US -> Known.US
                        else -> throw DinariInvalidDataException("Unknown Jurisdiction: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws DinariInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        DinariInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): Jurisdiction = apply {
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

                    return other is Jurisdiction && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Us &&
                    data == other.data &&
                    providerName == other.providerName &&
                    jurisdiction == other.jurisdiction &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(data, providerName, jurisdiction, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Us{data=$data, providerName=$providerName, jurisdiction=$jurisdiction, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is KycSubmitParams &&
            entityId == other.entityId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(entityId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "KycSubmitParams{entityId=$entityId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
