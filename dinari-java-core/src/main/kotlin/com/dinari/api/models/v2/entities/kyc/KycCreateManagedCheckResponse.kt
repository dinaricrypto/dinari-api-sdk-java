// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

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

/** URL for a managed KYC flow for an `Entity`. */
class KycCreateManagedCheckResponse
private constructor(
    private val embedUrl: JsonField<String>,
    private val expirationDt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("embed_url") @ExcludeMissing embedUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expiration_dt")
        @ExcludeMissing
        expirationDt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(embedUrl, expirationDt, mutableMapOf())

    /**
     * URL of a managed KYC flow interface for the `Entity`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun embedUrl(): String = embedUrl.getRequired("embed_url")

    /**
     * Datetime at which the KYC request will expired. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun expirationDt(): OffsetDateTime = expirationDt.getRequired("expiration_dt")

    /**
     * Returns the raw JSON value of [embedUrl].
     *
     * Unlike [embedUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("embed_url") @ExcludeMissing fun _embedUrl(): JsonField<String> = embedUrl

    /**
     * Returns the raw JSON value of [expirationDt].
     *
     * Unlike [expirationDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expiration_dt")
    @ExcludeMissing
    fun _expirationDt(): JsonField<OffsetDateTime> = expirationDt

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
         * [KycCreateManagedCheckResponse].
         *
         * The following fields are required:
         * ```java
         * .embedUrl()
         * .expirationDt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [KycCreateManagedCheckResponse]. */
    class Builder internal constructor() {

        private var embedUrl: JsonField<String>? = null
        private var expirationDt: JsonField<OffsetDateTime>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(kycCreateManagedCheckResponse: KycCreateManagedCheckResponse) = apply {
            embedUrl = kycCreateManagedCheckResponse.embedUrl
            expirationDt = kycCreateManagedCheckResponse.expirationDt
            additionalProperties = kycCreateManagedCheckResponse.additionalProperties.toMutableMap()
        }

        /** URL of a managed KYC flow interface for the `Entity`. */
        fun embedUrl(embedUrl: String) = embedUrl(JsonField.of(embedUrl))

        /**
         * Sets [Builder.embedUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.embedUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun embedUrl(embedUrl: JsonField<String>) = apply { this.embedUrl = embedUrl }

        /** Datetime at which the KYC request will expired. ISO 8601 timestamp. */
        fun expirationDt(expirationDt: OffsetDateTime) = expirationDt(JsonField.of(expirationDt))

        /**
         * Sets [Builder.expirationDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expirationDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun expirationDt(expirationDt: JsonField<OffsetDateTime>) = apply {
            this.expirationDt = expirationDt
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
         * Returns an immutable instance of [KycCreateManagedCheckResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .embedUrl()
         * .expirationDt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): KycCreateManagedCheckResponse =
            KycCreateManagedCheckResponse(
                checkRequired("embedUrl", embedUrl),
                checkRequired("expirationDt", expirationDt),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): KycCreateManagedCheckResponse = apply {
        if (validated) {
            return@apply
        }

        embedUrl()
        expirationDt()
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
        (if (embedUrl.asKnown().isPresent) 1 else 0) +
            (if (expirationDt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is KycCreateManagedCheckResponse &&
            embedUrl == other.embedUrl &&
            expirationDt == other.expirationDt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(embedUrl, expirationDt, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "KycCreateManagedCheckResponse{embedUrl=$embedUrl, expirationDt=$expirationDt, additionalProperties=$additionalProperties}"
}
