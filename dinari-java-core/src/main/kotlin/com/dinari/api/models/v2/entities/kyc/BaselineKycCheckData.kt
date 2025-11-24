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
import java.time.LocalDate
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** KYC data for an `Entity` in the BASELINE jurisdiction. */
class BaselineKycCheckData
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val addressCountryCode: JsonField<String>,
    private val countryCode: JsonField<String>,
    private val lastName: JsonField<String>,
    private val addressCity: JsonField<String>,
    private val addressPostalCode: JsonField<String>,
    private val addressStreet1: JsonField<String>,
    private val addressStreet2: JsonField<String>,
    private val addressSubdivision: JsonField<String>,
    private val birthDate: JsonField<LocalDate>,
    private val email: JsonField<String>,
    private val firstName: JsonField<String>,
    private val middleName: JsonField<String>,
    private val taxIdNumber: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("address_country_code")
        @ExcludeMissing
        addressCountryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country_code")
        @ExcludeMissing
        countryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("last_name") @ExcludeMissing lastName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("address_city")
        @ExcludeMissing
        addressCity: JsonField<String> = JsonMissing.of(),
        @JsonProperty("address_postal_code")
        @ExcludeMissing
        addressPostalCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("address_street_1")
        @ExcludeMissing
        addressStreet1: JsonField<String> = JsonMissing.of(),
        @JsonProperty("address_street_2")
        @ExcludeMissing
        addressStreet2: JsonField<String> = JsonMissing.of(),
        @JsonProperty("address_subdivision")
        @ExcludeMissing
        addressSubdivision: JsonField<String> = JsonMissing.of(),
        @JsonProperty("birth_date")
        @ExcludeMissing
        birthDate: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("first_name") @ExcludeMissing firstName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("middle_name")
        @ExcludeMissing
        middleName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tax_id_number")
        @ExcludeMissing
        taxIdNumber: JsonField<String> = JsonMissing.of(),
    ) : this(
        addressCountryCode,
        countryCode,
        lastName,
        addressCity,
        addressPostalCode,
        addressStreet1,
        addressStreet2,
        addressSubdivision,
        birthDate,
        email,
        firstName,
        middleName,
        taxIdNumber,
        mutableMapOf(),
    )

    /**
     * Country of residence. ISO 3166-1 alpha 2 country code.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun addressCountryCode(): String = addressCountryCode.getRequired("address_country_code")

    /**
     * Country of citizenship or home country of the organization. ISO 3166-1 alpha 2 country code.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun countryCode(): String = countryCode.getRequired("country_code")

    /**
     * Last name of the person.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lastName(): String = lastName.getRequired("last_name")

    /**
     * City of address. Not all international addresses use this attribute.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun addressCity(): Optional<String> = addressCity.getOptional("address_city")

    /**
     * Postal code of residence address. Not all international addresses use this attribute.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun addressPostalCode(): Optional<String> = addressPostalCode.getOptional("address_postal_code")

    /**
     * Street address of address.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun addressStreet1(): Optional<String> = addressStreet1.getOptional("address_street_1")

    /**
     * Extension of address, usually apartment or suite number.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun addressStreet2(): Optional<String> = addressStreet2.getOptional("address_street_2")

    /**
     * State or subdivision of address. In the US, this should be the unabbreviated name of the
     * state. Not all international addresses use this attribute.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun addressSubdivision(): Optional<String> =
        addressSubdivision.getOptional("address_subdivision")

    /**
     * Birth date of the individual. In ISO 8601 format, YYYY-MM-DD.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun birthDate(): Optional<LocalDate> = birthDate.getOptional("birth_date")

    /**
     * Email address.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * First name of the person.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun firstName(): Optional<String> = firstName.getOptional("first_name")

    /**
     * Middle name of the user
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun middleName(): Optional<String> = middleName.getOptional("middle_name")

    /**
     * ID number of the official tax document of the country the entity belongs to.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxIdNumber(): Optional<String> = taxIdNumber.getOptional("tax_id_number")

    /**
     * Returns the raw JSON value of [addressCountryCode].
     *
     * Unlike [addressCountryCode], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("address_country_code")
    @ExcludeMissing
    fun _addressCountryCode(): JsonField<String> = addressCountryCode

    /**
     * Returns the raw JSON value of [countryCode].
     *
     * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country_code")
    @ExcludeMissing
    fun _countryCode(): JsonField<String> = countryCode

    /**
     * Returns the raw JSON value of [lastName].
     *
     * Unlike [lastName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_name") @ExcludeMissing fun _lastName(): JsonField<String> = lastName

    /**
     * Returns the raw JSON value of [addressCity].
     *
     * Unlike [addressCity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("address_city")
    @ExcludeMissing
    fun _addressCity(): JsonField<String> = addressCity

    /**
     * Returns the raw JSON value of [addressPostalCode].
     *
     * Unlike [addressPostalCode], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("address_postal_code")
    @ExcludeMissing
    fun _addressPostalCode(): JsonField<String> = addressPostalCode

    /**
     * Returns the raw JSON value of [addressStreet1].
     *
     * Unlike [addressStreet1], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("address_street_1")
    @ExcludeMissing
    fun _addressStreet1(): JsonField<String> = addressStreet1

    /**
     * Returns the raw JSON value of [addressStreet2].
     *
     * Unlike [addressStreet2], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("address_street_2")
    @ExcludeMissing
    fun _addressStreet2(): JsonField<String> = addressStreet2

    /**
     * Returns the raw JSON value of [addressSubdivision].
     *
     * Unlike [addressSubdivision], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("address_subdivision")
    @ExcludeMissing
    fun _addressSubdivision(): JsonField<String> = addressSubdivision

    /**
     * Returns the raw JSON value of [birthDate].
     *
     * Unlike [birthDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("birth_date") @ExcludeMissing fun _birthDate(): JsonField<LocalDate> = birthDate

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    /**
     * Returns the raw JSON value of [firstName].
     *
     * Unlike [firstName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("first_name") @ExcludeMissing fun _firstName(): JsonField<String> = firstName

    /**
     * Returns the raw JSON value of [middleName].
     *
     * Unlike [middleName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("middle_name") @ExcludeMissing fun _middleName(): JsonField<String> = middleName

    /**
     * Returns the raw JSON value of [taxIdNumber].
     *
     * Unlike [taxIdNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tax_id_number")
    @ExcludeMissing
    fun _taxIdNumber(): JsonField<String> = taxIdNumber

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
         * Returns a mutable builder for constructing an instance of [BaselineKycCheckData].
         *
         * The following fields are required:
         * ```java
         * .addressCountryCode()
         * .countryCode()
         * .lastName()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BaselineKycCheckData]. */
    class Builder internal constructor() {

        private var addressCountryCode: JsonField<String>? = null
        private var countryCode: JsonField<String>? = null
        private var lastName: JsonField<String>? = null
        private var addressCity: JsonField<String> = JsonMissing.of()
        private var addressPostalCode: JsonField<String> = JsonMissing.of()
        private var addressStreet1: JsonField<String> = JsonMissing.of()
        private var addressStreet2: JsonField<String> = JsonMissing.of()
        private var addressSubdivision: JsonField<String> = JsonMissing.of()
        private var birthDate: JsonField<LocalDate> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var firstName: JsonField<String> = JsonMissing.of()
        private var middleName: JsonField<String> = JsonMissing.of()
        private var taxIdNumber: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(baselineKycCheckData: BaselineKycCheckData) = apply {
            addressCountryCode = baselineKycCheckData.addressCountryCode
            countryCode = baselineKycCheckData.countryCode
            lastName = baselineKycCheckData.lastName
            addressCity = baselineKycCheckData.addressCity
            addressPostalCode = baselineKycCheckData.addressPostalCode
            addressStreet1 = baselineKycCheckData.addressStreet1
            addressStreet2 = baselineKycCheckData.addressStreet2
            addressSubdivision = baselineKycCheckData.addressSubdivision
            birthDate = baselineKycCheckData.birthDate
            email = baselineKycCheckData.email
            firstName = baselineKycCheckData.firstName
            middleName = baselineKycCheckData.middleName
            taxIdNumber = baselineKycCheckData.taxIdNumber
            additionalProperties = baselineKycCheckData.additionalProperties.toMutableMap()
        }

        /** Country of residence. ISO 3166-1 alpha 2 country code. */
        fun addressCountryCode(addressCountryCode: String) =
            addressCountryCode(JsonField.of(addressCountryCode))

        /**
         * Sets [Builder.addressCountryCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addressCountryCode] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun addressCountryCode(addressCountryCode: JsonField<String>) = apply {
            this.addressCountryCode = addressCountryCode
        }

        /**
         * Country of citizenship or home country of the organization. ISO 3166-1 alpha 2 country
         * code.
         */
        fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

        /**
         * Sets [Builder.countryCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.countryCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun countryCode(countryCode: JsonField<String>) = apply { this.countryCode = countryCode }

        /** Last name of the person. */
        fun lastName(lastName: String) = lastName(JsonField.of(lastName))

        /**
         * Sets [Builder.lastName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastName] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

        /** City of address. Not all international addresses use this attribute. */
        fun addressCity(addressCity: String?) = addressCity(JsonField.ofNullable(addressCity))

        /** Alias for calling [Builder.addressCity] with `addressCity.orElse(null)`. */
        fun addressCity(addressCity: Optional<String>) = addressCity(addressCity.getOrNull())

        /**
         * Sets [Builder.addressCity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addressCity] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun addressCity(addressCity: JsonField<String>) = apply { this.addressCity = addressCity }

        /** Postal code of residence address. Not all international addresses use this attribute. */
        fun addressPostalCode(addressPostalCode: String?) =
            addressPostalCode(JsonField.ofNullable(addressPostalCode))

        /** Alias for calling [Builder.addressPostalCode] with `addressPostalCode.orElse(null)`. */
        fun addressPostalCode(addressPostalCode: Optional<String>) =
            addressPostalCode(addressPostalCode.getOrNull())

        /**
         * Sets [Builder.addressPostalCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addressPostalCode] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun addressPostalCode(addressPostalCode: JsonField<String>) = apply {
            this.addressPostalCode = addressPostalCode
        }

        /** Street address of address. */
        fun addressStreet1(addressStreet1: String?) =
            addressStreet1(JsonField.ofNullable(addressStreet1))

        /** Alias for calling [Builder.addressStreet1] with `addressStreet1.orElse(null)`. */
        fun addressStreet1(addressStreet1: Optional<String>) =
            addressStreet1(addressStreet1.getOrNull())

        /**
         * Sets [Builder.addressStreet1] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addressStreet1] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun addressStreet1(addressStreet1: JsonField<String>) = apply {
            this.addressStreet1 = addressStreet1
        }

        /** Extension of address, usually apartment or suite number. */
        fun addressStreet2(addressStreet2: String?) =
            addressStreet2(JsonField.ofNullable(addressStreet2))

        /** Alias for calling [Builder.addressStreet2] with `addressStreet2.orElse(null)`. */
        fun addressStreet2(addressStreet2: Optional<String>) =
            addressStreet2(addressStreet2.getOrNull())

        /**
         * Sets [Builder.addressStreet2] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addressStreet2] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun addressStreet2(addressStreet2: JsonField<String>) = apply {
            this.addressStreet2 = addressStreet2
        }

        /**
         * State or subdivision of address. In the US, this should be the unabbreviated name of the
         * state. Not all international addresses use this attribute.
         */
        fun addressSubdivision(addressSubdivision: String?) =
            addressSubdivision(JsonField.ofNullable(addressSubdivision))

        /**
         * Alias for calling [Builder.addressSubdivision] with `addressSubdivision.orElse(null)`.
         */
        fun addressSubdivision(addressSubdivision: Optional<String>) =
            addressSubdivision(addressSubdivision.getOrNull())

        /**
         * Sets [Builder.addressSubdivision] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addressSubdivision] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun addressSubdivision(addressSubdivision: JsonField<String>) = apply {
            this.addressSubdivision = addressSubdivision
        }

        /** Birth date of the individual. In ISO 8601 format, YYYY-MM-DD. */
        fun birthDate(birthDate: LocalDate?) = birthDate(JsonField.ofNullable(birthDate))

        /** Alias for calling [Builder.birthDate] with `birthDate.orElse(null)`. */
        fun birthDate(birthDate: Optional<LocalDate>) = birthDate(birthDate.getOrNull())

        /**
         * Sets [Builder.birthDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.birthDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun birthDate(birthDate: JsonField<LocalDate>) = apply { this.birthDate = birthDate }

        /** Email address. */
        fun email(email: String?) = email(JsonField.ofNullable(email))

        /** Alias for calling [Builder.email] with `email.orElse(null)`. */
        fun email(email: Optional<String>) = email(email.getOrNull())

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** First name of the person. */
        fun firstName(firstName: String?) = firstName(JsonField.ofNullable(firstName))

        /** Alias for calling [Builder.firstName] with `firstName.orElse(null)`. */
        fun firstName(firstName: Optional<String>) = firstName(firstName.getOrNull())

        /**
         * Sets [Builder.firstName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.firstName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

        /** Middle name of the user */
        fun middleName(middleName: String?) = middleName(JsonField.ofNullable(middleName))

        /** Alias for calling [Builder.middleName] with `middleName.orElse(null)`. */
        fun middleName(middleName: Optional<String>) = middleName(middleName.getOrNull())

        /**
         * Sets [Builder.middleName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.middleName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun middleName(middleName: JsonField<String>) = apply { this.middleName = middleName }

        /** ID number of the official tax document of the country the entity belongs to. */
        fun taxIdNumber(taxIdNumber: String?) = taxIdNumber(JsonField.ofNullable(taxIdNumber))

        /** Alias for calling [Builder.taxIdNumber] with `taxIdNumber.orElse(null)`. */
        fun taxIdNumber(taxIdNumber: Optional<String>) = taxIdNumber(taxIdNumber.getOrNull())

        /**
         * Sets [Builder.taxIdNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taxIdNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun taxIdNumber(taxIdNumber: JsonField<String>) = apply { this.taxIdNumber = taxIdNumber }

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
         * Returns an immutable instance of [BaselineKycCheckData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .addressCountryCode()
         * .countryCode()
         * .lastName()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BaselineKycCheckData =
            BaselineKycCheckData(
                checkRequired("addressCountryCode", addressCountryCode),
                checkRequired("countryCode", countryCode),
                checkRequired("lastName", lastName),
                addressCity,
                addressPostalCode,
                addressStreet1,
                addressStreet2,
                addressSubdivision,
                birthDate,
                email,
                firstName,
                middleName,
                taxIdNumber,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BaselineKycCheckData = apply {
        if (validated) {
            return@apply
        }

        addressCountryCode()
        countryCode()
        lastName()
        addressCity()
        addressPostalCode()
        addressStreet1()
        addressStreet2()
        addressSubdivision()
        birthDate()
        email()
        firstName()
        middleName()
        taxIdNumber()
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
        (if (addressCountryCode.asKnown().isPresent) 1 else 0) +
            (if (countryCode.asKnown().isPresent) 1 else 0) +
            (if (lastName.asKnown().isPresent) 1 else 0) +
            (if (addressCity.asKnown().isPresent) 1 else 0) +
            (if (addressPostalCode.asKnown().isPresent) 1 else 0) +
            (if (addressStreet1.asKnown().isPresent) 1 else 0) +
            (if (addressStreet2.asKnown().isPresent) 1 else 0) +
            (if (addressSubdivision.asKnown().isPresent) 1 else 0) +
            (if (birthDate.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (firstName.asKnown().isPresent) 1 else 0) +
            (if (middleName.asKnown().isPresent) 1 else 0) +
            (if (taxIdNumber.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BaselineKycCheckData &&
            addressCountryCode == other.addressCountryCode &&
            countryCode == other.countryCode &&
            lastName == other.lastName &&
            addressCity == other.addressCity &&
            addressPostalCode == other.addressPostalCode &&
            addressStreet1 == other.addressStreet1 &&
            addressStreet2 == other.addressStreet2 &&
            addressSubdivision == other.addressSubdivision &&
            birthDate == other.birthDate &&
            email == other.email &&
            firstName == other.firstName &&
            middleName == other.middleName &&
            taxIdNumber == other.taxIdNumber &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            addressCountryCode,
            countryCode,
            lastName,
            addressCity,
            addressPostalCode,
            addressStreet1,
            addressStreet2,
            addressSubdivision,
            birthDate,
            email,
            firstName,
            middleName,
            taxIdNumber,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BaselineKycCheckData{addressCountryCode=$addressCountryCode, countryCode=$countryCode, lastName=$lastName, addressCity=$addressCity, addressPostalCode=$addressPostalCode, addressStreet1=$addressStreet1, addressStreet2=$addressStreet2, addressSubdivision=$addressSubdivision, birthDate=$birthDate, email=$email, firstName=$firstName, middleName=$middleName, taxIdNumber=$taxIdNumber, additionalProperties=$additionalProperties}"
}
