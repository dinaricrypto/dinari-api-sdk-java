// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.wallet.external

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

/** Connection message to sign to prove ownership of the `Wallet`. */
class ExternalGetNonceResponse
private constructor(
    private val message: JsonField<String>,
    private val nonce: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("nonce") @ExcludeMissing nonce: JsonField<String> = JsonMissing.of(),
    ) : this(message, nonce, mutableMapOf())

    /**
     * Message to be signed by the `Wallet`
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun message(): String = message.getRequired("message")

    /**
     * Single-use identifier
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun nonce(): String = nonce.getRequired("nonce")

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    /**
     * Returns the raw JSON value of [nonce].
     *
     * Unlike [nonce], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("nonce") @ExcludeMissing fun _nonce(): JsonField<String> = nonce

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
         * Returns a mutable builder for constructing an instance of [ExternalGetNonceResponse].
         *
         * The following fields are required:
         * ```java
         * .message()
         * .nonce()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExternalGetNonceResponse]. */
    class Builder internal constructor() {

        private var message: JsonField<String>? = null
        private var nonce: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(externalGetNonceResponse: ExternalGetNonceResponse) = apply {
            message = externalGetNonceResponse.message
            nonce = externalGetNonceResponse.nonce
            additionalProperties = externalGetNonceResponse.additionalProperties.toMutableMap()
        }

        /** Message to be signed by the `Wallet` */
        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /** Single-use identifier */
        fun nonce(nonce: String) = nonce(JsonField.of(nonce))

        /**
         * Sets [Builder.nonce] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nonce] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun nonce(nonce: JsonField<String>) = apply { this.nonce = nonce }

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
         * Returns an immutable instance of [ExternalGetNonceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .message()
         * .nonce()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExternalGetNonceResponse =
            ExternalGetNonceResponse(
                checkRequired("message", message),
                checkRequired("nonce", nonce),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ExternalGetNonceResponse = apply {
        if (validated) {
            return@apply
        }

        message()
        nonce()
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
        (if (message.asKnown().isPresent) 1 else 0) + (if (nonce.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExternalGetNonceResponse &&
            message == other.message &&
            nonce == other.nonce &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(message, nonce, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExternalGetNonceResponse{message=$message, nonce=$nonce, additionalProperties=$additionalProperties}"
}
