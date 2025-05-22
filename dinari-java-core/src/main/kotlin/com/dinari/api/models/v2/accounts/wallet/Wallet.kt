// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.wallet

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

/** Information about a blockchain `Wallet`. */
class Wallet
private constructor(
    private val address: JsonField<String>,
    private val isAmlFlagged: JsonField<Boolean>,
    private val isManagedWallet: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
        @JsonProperty("is_aml_flagged")
        @ExcludeMissing
        isAmlFlagged: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("is_managed_wallet")
        @ExcludeMissing
        isManagedWallet: JsonField<Boolean> = JsonMissing.of(),
    ) : this(address, isAmlFlagged, isManagedWallet, mutableMapOf())

    /**
     * Address of the `Wallet`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun address(): String = address.getRequired("address")

    /**
     * Indicates whether the `Wallet` is flagged for AML violation.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isAmlFlagged(): Boolean = isAmlFlagged.getRequired("is_aml_flagged")

    /**
     * Indicates whether the `Wallet` is a Dinari-managed wallet.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isManagedWallet(): Boolean = isManagedWallet.getRequired("is_managed_wallet")

    /**
     * Returns the raw JSON value of [address].
     *
     * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

    /**
     * Returns the raw JSON value of [isAmlFlagged].
     *
     * Unlike [isAmlFlagged], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_aml_flagged")
    @ExcludeMissing
    fun _isAmlFlagged(): JsonField<Boolean> = isAmlFlagged

    /**
     * Returns the raw JSON value of [isManagedWallet].
     *
     * Unlike [isManagedWallet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_managed_wallet")
    @ExcludeMissing
    fun _isManagedWallet(): JsonField<Boolean> = isManagedWallet

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
         * Returns a mutable builder for constructing an instance of [Wallet].
         *
         * The following fields are required:
         * ```java
         * .address()
         * .isAmlFlagged()
         * .isManagedWallet()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Wallet]. */
    class Builder internal constructor() {

        private var address: JsonField<String>? = null
        private var isAmlFlagged: JsonField<Boolean>? = null
        private var isManagedWallet: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(wallet: Wallet) = apply {
            address = wallet.address
            isAmlFlagged = wallet.isAmlFlagged
            isManagedWallet = wallet.isManagedWallet
            additionalProperties = wallet.additionalProperties.toMutableMap()
        }

        /** Address of the `Wallet`. */
        fun address(address: String) = address(JsonField.of(address))

        /**
         * Sets [Builder.address] to an arbitrary JSON value.
         *
         * You should usually call [Builder.address] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun address(address: JsonField<String>) = apply { this.address = address }

        /** Indicates whether the `Wallet` is flagged for AML violation. */
        fun isAmlFlagged(isAmlFlagged: Boolean) = isAmlFlagged(JsonField.of(isAmlFlagged))

        /**
         * Sets [Builder.isAmlFlagged] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isAmlFlagged] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isAmlFlagged(isAmlFlagged: JsonField<Boolean>) = apply {
            this.isAmlFlagged = isAmlFlagged
        }

        /** Indicates whether the `Wallet` is a Dinari-managed wallet. */
        fun isManagedWallet(isManagedWallet: Boolean) =
            isManagedWallet(JsonField.of(isManagedWallet))

        /**
         * Sets [Builder.isManagedWallet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isManagedWallet] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isManagedWallet(isManagedWallet: JsonField<Boolean>) = apply {
            this.isManagedWallet = isManagedWallet
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
         * Returns an immutable instance of [Wallet].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .address()
         * .isAmlFlagged()
         * .isManagedWallet()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Wallet =
            Wallet(
                checkRequired("address", address),
                checkRequired("isAmlFlagged", isAmlFlagged),
                checkRequired("isManagedWallet", isManagedWallet),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Wallet = apply {
        if (validated) {
            return@apply
        }

        address()
        isAmlFlagged()
        isManagedWallet()
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
        (if (address.asKnown().isPresent) 1 else 0) +
            (if (isAmlFlagged.asKnown().isPresent) 1 else 0) +
            (if (isManagedWallet.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Wallet && address == other.address && isAmlFlagged == other.isAmlFlagged && isManagedWallet == other.isManagedWallet && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(address, isAmlFlagged, isManagedWallet, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Wallet{address=$address, isAmlFlagged=$isAmlFlagged, isManagedWallet=$isManagedWallet, additionalProperties=$additionalProperties}"
}
