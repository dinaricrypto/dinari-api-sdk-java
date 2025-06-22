// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.entities.accounts

import com.dinari.core.ExcludeMissing
import com.dinari.core.JsonField
import com.dinari.core.JsonMissing
import com.dinari.core.JsonValue
import com.dinari.core.checkRequired
import com.dinari.errors.DinariInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects

/** Information about an `Account` owned by an `Entity`. */
class Account
private constructor(
    private val id: JsonField<String>,
    private val createdDt: JsonField<OffsetDateTime>,
    private val entityId: JsonField<String>,
    private val isActive: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_dt")
        @ExcludeMissing
        createdDt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("entity_id") @ExcludeMissing entityId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("is_active") @ExcludeMissing isActive: JsonField<Boolean> = JsonMissing.of(),
    ) : this(id, createdDt, entityId, isActive, mutableMapOf())

    /**
     * Unique ID for the `Account`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Datetime when the `Account` was created. ISO 8601 timestamp.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdDt(): OffsetDateTime = createdDt.getRequired("created_dt")

    /**
     * ID for the `Entity` that owns the `Account`.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun entityId(): String = entityId.getRequired("entity_id")

    /**
     * Indicates whether the `Account` is active.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isActive(): Boolean = isActive.getRequired("is_active")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdDt].
     *
     * Unlike [createdDt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_dt")
    @ExcludeMissing
    fun _createdDt(): JsonField<OffsetDateTime> = createdDt

    /**
     * Returns the raw JSON value of [entityId].
     *
     * Unlike [entityId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entity_id") @ExcludeMissing fun _entityId(): JsonField<String> = entityId

    /**
     * Returns the raw JSON value of [isActive].
     *
     * Unlike [isActive], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_active") @ExcludeMissing fun _isActive(): JsonField<Boolean> = isActive

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
         * Returns a mutable builder for constructing an instance of [Account].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdDt()
         * .entityId()
         * .isActive()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Account]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdDt: JsonField<OffsetDateTime>? = null
        private var entityId: JsonField<String>? = null
        private var isActive: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(account: Account) = apply {
            id = account.id
            createdDt = account.createdDt
            entityId = account.entityId
            isActive = account.isActive
            additionalProperties = account.additionalProperties.toMutableMap()
        }

        /** Unique ID for the `Account`. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Datetime when the `Account` was created. ISO 8601 timestamp. */
        fun createdDt(createdDt: OffsetDateTime) = createdDt(JsonField.of(createdDt))

        /**
         * Sets [Builder.createdDt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdDt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdDt(createdDt: JsonField<OffsetDateTime>) = apply { this.createdDt = createdDt }

        /** ID for the `Entity` that owns the `Account`. */
        fun entityId(entityId: String) = entityId(JsonField.of(entityId))

        /**
         * Sets [Builder.entityId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entityId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun entityId(entityId: JsonField<String>) = apply { this.entityId = entityId }

        /** Indicates whether the `Account` is active. */
        fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

        /**
         * Sets [Builder.isActive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isActive] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

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
         * Returns an immutable instance of [Account].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdDt()
         * .entityId()
         * .isActive()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Account =
            Account(
                checkRequired("id", id),
                checkRequired("createdDt", createdDt),
                checkRequired("entityId", entityId),
                checkRequired("isActive", isActive),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Account = apply {
        if (validated) {
            return@apply
        }

        id()
        createdDt()
        entityId()
        isActive()
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
            (if (createdDt.asKnown().isPresent) 1 else 0) +
            (if (entityId.asKnown().isPresent) 1 else 0) +
            (if (isActive.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Account && id == other.id && createdDt == other.createdDt && entityId == other.entityId && isActive == other.isActive && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdDt, entityId, isActive, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Account{id=$id, createdDt=$createdDt, entityId=$entityId, isActive=$isActive, additionalProperties=$additionalProperties}"
}
