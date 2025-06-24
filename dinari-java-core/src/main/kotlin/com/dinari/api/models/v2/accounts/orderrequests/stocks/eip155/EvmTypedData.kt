// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155

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
import java.util.Collections
import java.util.Objects

/** [EIP-712](https://eips.ethereum.org/EIPS/eip-712) typed data to be signed with a wallet. */
class EvmTypedData
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
    @JsonProperty("primaryType") @ExcludeMissing fun _primaryType(): JsonField<String> = primaryType

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
         * Returns a mutable builder for constructing an instance of [EvmTypedData].
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

    /** A builder for [EvmTypedData]. */
    class Builder internal constructor() {

        private var domain: JsonValue? = null
        private var message: JsonValue? = null
        private var primaryType: JsonField<String>? = null
        private var types: JsonValue? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(evmTypedData: EvmTypedData) = apply {
            domain = evmTypedData.domain
            message = evmTypedData.message
            primaryType = evmTypedData.primaryType
            types = evmTypedData.types
            additionalProperties = evmTypedData.additionalProperties.toMutableMap()
        }

        /** Domain separator for the typed data. */
        fun domain(domain: JsonValue) = apply { this.domain = domain }

        /** Message to be signed. Contains the actual data that will be signed with the wallet. */
        fun message(message: JsonValue) = apply { this.message = message }

        /** Primary type of the typed data. */
        fun primaryType(primaryType: String) = primaryType(JsonField.of(primaryType))

        /**
         * Sets [Builder.primaryType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.primaryType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun primaryType(primaryType: JsonField<String>) = apply { this.primaryType = primaryType }

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
         * Returns an immutable instance of [EvmTypedData].
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
        fun build(): EvmTypedData =
            EvmTypedData(
                checkRequired("domain", domain),
                checkRequired("message", message),
                checkRequired("primaryType", primaryType),
                checkRequired("types", types),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EvmTypedData = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = (if (primaryType.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EvmTypedData && domain == other.domain && message == other.message && primaryType == other.primaryType && types == other.types && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(domain, message, primaryType, types, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EvmTypedData{domain=$domain, message=$message, primaryType=$primaryType, types=$types, additionalProperties=$additionalProperties}"
}
