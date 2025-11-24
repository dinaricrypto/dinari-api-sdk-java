// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

import com.dinari.api.core.BaseDeserializer
import com.dinari.api.core.BaseSerializer
import com.dinari.api.core.Enum
import com.dinari.api.core.ExcludeMissing
import com.dinari.api.core.JsonField
import com.dinari.api.core.JsonMissing
import com.dinari.api.core.JsonValue
import com.dinari.api.core.checkRequired
import com.dinari.api.core.getOrThrow
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

/** KYC information for an `Entity` in the baseline jurisdiction. */
@JsonDeserialize(using = KycInfo.Deserializer::class)
@JsonSerialize(using = KycInfo.Serializer::class)
class KycInfo
private constructor(
    private val baseline: Baseline? = null,
    private val us: Us? = null,
    private val _json: JsonValue? = null,
) {

    /** KYC information for an `Entity` in the baseline jurisdiction. */
    fun baseline(): Optional<Baseline> = Optional.ofNullable(baseline)

    /** KYC information for an `Entity` in the US jurisdiction. */
    fun us(): Optional<Us> = Optional.ofNullable(us)

    fun isBaseline(): Boolean = baseline != null

    fun isUs(): Boolean = us != null

    /** KYC information for an `Entity` in the baseline jurisdiction. */
    fun asBaseline(): Baseline = baseline.getOrThrow("baseline")

    /** KYC information for an `Entity` in the US jurisdiction. */
    fun asUs(): Us = us.getOrThrow("us")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            baseline != null -> visitor.visitBaseline(baseline)
            us != null -> visitor.visitUs(us)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): KycInfo = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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

        return other is KycInfo && baseline == other.baseline && us == other.us
    }

    override fun hashCode(): Int = Objects.hash(baseline, us)

    override fun toString(): String =
        when {
            baseline != null -> "KycInfo{baseline=$baseline}"
            us != null -> "KycInfo{us=$us}"
            _json != null -> "KycInfo{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid KycInfo")
        }

    companion object {

        /** KYC information for an `Entity` in the baseline jurisdiction. */
        @JvmStatic fun ofBaseline(baseline: Baseline) = KycInfo(baseline = baseline)

        /** KYC information for an `Entity` in the US jurisdiction. */
        @JvmStatic fun ofUs(us: Us) = KycInfo(us = us)
    }

    /** An interface that defines how to map each variant of [KycInfo] to a value of type [T]. */
    interface Visitor<out T> {

        /** KYC information for an `Entity` in the baseline jurisdiction. */
        fun visitBaseline(baseline: Baseline): T

        /** KYC information for an `Entity` in the US jurisdiction. */
        fun visitUs(us: Us): T

        /**
         * Maps an unknown variant of [KycInfo] to a value of type [T].
         *
         * An instance of [KycInfo] can contain an unknown variant if it was deserialized from data
         * that doesn't match any known variant. For example, if the SDK is on an older version than
         * the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws DinariInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw DinariInvalidDataException("Unknown KycInfo: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<KycInfo>(KycInfo::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): KycInfo {
            val json = JsonValue.fromJsonNode(node)
            val jurisdiction =
                json.asObject().getOrNull()?.get("jurisdiction")?.asString()?.getOrNull()

            when (jurisdiction) {
                "BASELINE" -> {
                    return tryDeserialize(node, jacksonTypeRef<Baseline>())?.let {
                        KycInfo(baseline = it, _json = json)
                    } ?: KycInfo(_json = json)
                }
                "US" -> {
                    return tryDeserialize(node, jacksonTypeRef<Us>())?.let {
                        KycInfo(us = it, _json = json)
                    } ?: KycInfo(_json = json)
                }
            }

            return KycInfo(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<KycInfo>(KycInfo::class) {

        override fun serialize(
            value: KycInfo,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.baseline != null -> generator.writeObject(value.baseline)
                value.us != null -> generator.writeObject(value.us)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid KycInfo")
            }
        }
    }

    /** KYC information for an `Entity` in the baseline jurisdiction. */
    class Baseline
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val status: JsonField<KycStatus>,
        private val checkedDt: JsonField<OffsetDateTime>,
        private val data: JsonField<BaselineKycCheckData>,
        private val jurisdiction: JsonField<Jurisdiction>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<KycStatus> = JsonMissing.of(),
            @JsonProperty("checked_dt")
            @ExcludeMissing
            checkedDt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("data")
            @ExcludeMissing
            data: JsonField<BaselineKycCheckData> = JsonMissing.of(),
            @JsonProperty("jurisdiction")
            @ExcludeMissing
            jurisdiction: JsonField<Jurisdiction> = JsonMissing.of(),
        ) : this(id, status, checkedDt, data, jurisdiction, mutableMapOf())

        /**
         * ID of the KYC check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * KYC check status.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): KycStatus = status.getRequired("status")

        /**
         * Datetime when the KYC was last checked. ISO 8601 timestamp.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun checkedDt(): Optional<OffsetDateTime> = checkedDt.getOptional("checked_dt")

        /**
         * KYC data for an `Entity` in the BASELINE jurisdiction.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<BaselineKycCheckData> = data.getOptional("data")

        /**
         * Jurisdiction of the KYC check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun jurisdiction(): Optional<Jurisdiction> = jurisdiction.getOptional("jurisdiction")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<KycStatus> = status

        /**
         * Returns the raw JSON value of [checkedDt].
         *
         * Unlike [checkedDt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("checked_dt")
        @ExcludeMissing
        fun _checkedDt(): JsonField<OffsetDateTime> = checkedDt

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<BaselineKycCheckData> = data

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
             * .id()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Baseline]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var status: JsonField<KycStatus>? = null
            private var checkedDt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var data: JsonField<BaselineKycCheckData> = JsonMissing.of()
            private var jurisdiction: JsonField<Jurisdiction> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(baseline: Baseline) = apply {
                id = baseline.id
                status = baseline.status
                checkedDt = baseline.checkedDt
                data = baseline.data
                jurisdiction = baseline.jurisdiction
                additionalProperties = baseline.additionalProperties.toMutableMap()
            }

            /** ID of the KYC check. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** KYC check status. */
            fun status(status: KycStatus) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [KycStatus] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<KycStatus>) = apply { this.status = status }

            /** Datetime when the KYC was last checked. ISO 8601 timestamp. */
            fun checkedDt(checkedDt: OffsetDateTime?) = checkedDt(JsonField.ofNullable(checkedDt))

            /** Alias for calling [Builder.checkedDt] with `checkedDt.orElse(null)`. */
            fun checkedDt(checkedDt: Optional<OffsetDateTime>) = checkedDt(checkedDt.getOrNull())

            /**
             * Sets [Builder.checkedDt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.checkedDt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun checkedDt(checkedDt: JsonField<OffsetDateTime>) = apply {
                this.checkedDt = checkedDt
            }

            /** KYC data for an `Entity` in the BASELINE jurisdiction. */
            fun data(data: BaselineKycCheckData?) = data(JsonField.ofNullable(data))

            /** Alias for calling [Builder.data] with `data.orElse(null)`. */
            fun data(data: Optional<BaselineKycCheckData>) = data(data.getOrNull())

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [BaselineKycCheckData] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<BaselineKycCheckData>) = apply { this.data = data }

            /** Jurisdiction of the KYC check. */
            fun jurisdiction(jurisdiction: Jurisdiction) = jurisdiction(JsonField.of(jurisdiction))

            /**
             * Sets [Builder.jurisdiction] to an arbitrary JSON value.
             *
             * You should usually call [Builder.jurisdiction] with a well-typed [Jurisdiction] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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
             * .id()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Baseline =
                Baseline(
                    checkRequired("id", id),
                    checkRequired("status", status),
                    checkedDt,
                    data,
                    jurisdiction,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Baseline = apply {
            if (validated) {
                return@apply
            }

            id()
            status().validate()
            checkedDt()
            data().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (checkedDt.asKnown().isPresent) 1 else 0) +
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                (jurisdiction.asKnown().getOrNull()?.validity() ?: 0)

        /** Jurisdiction of the KYC check. */
        class Jurisdiction @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val BASELINE = of("BASELINE")

                @JvmStatic fun of(value: String) = Jurisdiction(JsonField.of(value))
            }

            /** An enum containing [Jurisdiction]'s known values. */
            enum class Known {
                BASELINE
            }

            /**
             * An enum containing [Jurisdiction]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Jurisdiction] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                BASELINE,
                /**
                 * An enum member indicating that [Jurisdiction] was instantiated with an unknown
                 * value.
                 */
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
                    BASELINE -> Value.BASELINE
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
                    BASELINE -> Known.BASELINE
                    else -> throw DinariInvalidDataException("Unknown Jurisdiction: $value")
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
                id == other.id &&
                status == other.status &&
                checkedDt == other.checkedDt &&
                data == other.data &&
                jurisdiction == other.jurisdiction &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, status, checkedDt, data, jurisdiction, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Baseline{id=$id, status=$status, checkedDt=$checkedDt, data=$data, jurisdiction=$jurisdiction, additionalProperties=$additionalProperties}"
    }

    /** KYC information for an `Entity` in the US jurisdiction. */
    class Us
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val status: JsonField<KycStatus>,
        private val checkedDt: JsonField<OffsetDateTime>,
        private val data: JsonField<UsKycCheckData>,
        private val jurisdiction: JsonField<Jurisdiction>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<KycStatus> = JsonMissing.of(),
            @JsonProperty("checked_dt")
            @ExcludeMissing
            checkedDt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("data")
            @ExcludeMissing
            data: JsonField<UsKycCheckData> = JsonMissing.of(),
            @JsonProperty("jurisdiction")
            @ExcludeMissing
            jurisdiction: JsonField<Jurisdiction> = JsonMissing.of(),
        ) : this(id, status, checkedDt, data, jurisdiction, mutableMapOf())

        /**
         * ID of the KYC check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * KYC check status.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): KycStatus = status.getRequired("status")

        /**
         * Datetime when the KYC was last checked. ISO 8601 timestamp.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun checkedDt(): Optional<OffsetDateTime> = checkedDt.getOptional("checked_dt")

        /**
         * KYC data for an `Entity` in the US jurisdiction.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<UsKycCheckData> = data.getOptional("data")

        /**
         * Jurisdiction of the KYC check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun jurisdiction(): Optional<Jurisdiction> = jurisdiction.getOptional("jurisdiction")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<KycStatus> = status

        /**
         * Returns the raw JSON value of [checkedDt].
         *
         * Unlike [checkedDt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("checked_dt")
        @ExcludeMissing
        fun _checkedDt(): JsonField<OffsetDateTime> = checkedDt

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<UsKycCheckData> = data

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
             * .id()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Us]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var status: JsonField<KycStatus>? = null
            private var checkedDt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var data: JsonField<UsKycCheckData> = JsonMissing.of()
            private var jurisdiction: JsonField<Jurisdiction> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(us: Us) = apply {
                id = us.id
                status = us.status
                checkedDt = us.checkedDt
                data = us.data
                jurisdiction = us.jurisdiction
                additionalProperties = us.additionalProperties.toMutableMap()
            }

            /** ID of the KYC check. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** KYC check status. */
            fun status(status: KycStatus) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [KycStatus] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<KycStatus>) = apply { this.status = status }

            /** Datetime when the KYC was last checked. ISO 8601 timestamp. */
            fun checkedDt(checkedDt: OffsetDateTime?) = checkedDt(JsonField.ofNullable(checkedDt))

            /** Alias for calling [Builder.checkedDt] with `checkedDt.orElse(null)`. */
            fun checkedDt(checkedDt: Optional<OffsetDateTime>) = checkedDt(checkedDt.getOrNull())

            /**
             * Sets [Builder.checkedDt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.checkedDt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun checkedDt(checkedDt: JsonField<OffsetDateTime>) = apply {
                this.checkedDt = checkedDt
            }

            /** KYC data for an `Entity` in the US jurisdiction. */
            fun data(data: UsKycCheckData?) = data(JsonField.ofNullable(data))

            /** Alias for calling [Builder.data] with `data.orElse(null)`. */
            fun data(data: Optional<UsKycCheckData>) = data(data.getOrNull())

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [UsKycCheckData] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun data(data: JsonField<UsKycCheckData>) = apply { this.data = data }

            /** Jurisdiction of the KYC check. */
            fun jurisdiction(jurisdiction: Jurisdiction) = jurisdiction(JsonField.of(jurisdiction))

            /**
             * Sets [Builder.jurisdiction] to an arbitrary JSON value.
             *
             * You should usually call [Builder.jurisdiction] with a well-typed [Jurisdiction] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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
             * .id()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Us =
                Us(
                    checkRequired("id", id),
                    checkRequired("status", status),
                    checkedDt,
                    data,
                    jurisdiction,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Us = apply {
            if (validated) {
                return@apply
            }

            id()
            status().validate()
            checkedDt()
            data().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (checkedDt.asKnown().isPresent) 1 else 0) +
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                (jurisdiction.asKnown().getOrNull()?.validity() ?: 0)

        /** Jurisdiction of the KYC check. */
        class Jurisdiction @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val US = of("US")

                @JvmStatic fun of(value: String) = Jurisdiction(JsonField.of(value))
            }

            /** An enum containing [Jurisdiction]'s known values. */
            enum class Known {
                US
            }

            /**
             * An enum containing [Jurisdiction]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Jurisdiction] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                US,
                /**
                 * An enum member indicating that [Jurisdiction] was instantiated with an unknown
                 * value.
                 */
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
                    US -> Value.US
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
                    US -> Known.US
                    else -> throw DinariInvalidDataException("Unknown Jurisdiction: $value")
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
                id == other.id &&
                status == other.status &&
                checkedDt == other.checkedDt &&
                data == other.data &&
                jurisdiction == other.jurisdiction &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, status, checkedDt, data, jurisdiction, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Us{id=$id, status=$status, checkedDt=$checkedDt, data=$data, jurisdiction=$jurisdiction, additionalProperties=$additionalProperties}"
    }
}
