// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

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
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** KYC data for an `Entity` in the US jurisdiction. */
class UsKycCheckData
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val alpacaCustomerAgreement: JsonField<AlpacaCustomerAgreement>,
    private val amlCheck: JsonField<AmlCheck>,
    private val dataCitation: JsonField<DataCitation>,
    private val employment: JsonField<Employment>,
    private val financialProfile: JsonField<FinancialProfile>,
    private val identity: JsonField<Identity>,
    private val kycMetadata: JsonField<KycMetadata>,
    private val nonProfessionalTraderAttestation: JsonField<NonProfessionalTraderAttestation>,
    private val riskDisclosure: JsonField<RiskDisclosure>,
    private val trustedContact: JsonField<TrustedContact>,
    private val usImmigrationInfo: JsonField<UsImmigrationInfo>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("alpaca_customer_agreement")
        @ExcludeMissing
        alpacaCustomerAgreement: JsonField<AlpacaCustomerAgreement> = JsonMissing.of(),
        @JsonProperty("aml_check") @ExcludeMissing amlCheck: JsonField<AmlCheck> = JsonMissing.of(),
        @JsonProperty("data_citation")
        @ExcludeMissing
        dataCitation: JsonField<DataCitation> = JsonMissing.of(),
        @JsonProperty("employment")
        @ExcludeMissing
        employment: JsonField<Employment> = JsonMissing.of(),
        @JsonProperty("financial_profile")
        @ExcludeMissing
        financialProfile: JsonField<FinancialProfile> = JsonMissing.of(),
        @JsonProperty("identity") @ExcludeMissing identity: JsonField<Identity> = JsonMissing.of(),
        @JsonProperty("kyc_metadata")
        @ExcludeMissing
        kycMetadata: JsonField<KycMetadata> = JsonMissing.of(),
        @JsonProperty("non_professional_trader_attestation")
        @ExcludeMissing
        nonProfessionalTraderAttestation: JsonField<NonProfessionalTraderAttestation> =
            JsonMissing.of(),
        @JsonProperty("risk_disclosure")
        @ExcludeMissing
        riskDisclosure: JsonField<RiskDisclosure> = JsonMissing.of(),
        @JsonProperty("trusted_contact")
        @ExcludeMissing
        trustedContact: JsonField<TrustedContact> = JsonMissing.of(),
        @JsonProperty("us_immigration_info")
        @ExcludeMissing
        usImmigrationInfo: JsonField<UsImmigrationInfo> = JsonMissing.of(),
    ) : this(
        alpacaCustomerAgreement,
        amlCheck,
        dataCitation,
        employment,
        financialProfile,
        identity,
        kycMetadata,
        nonProfessionalTraderAttestation,
        riskDisclosure,
        trustedContact,
        usImmigrationInfo,
        mutableMapOf(),
    )

    /**
     * Information to affirm that the individual has read, agreed to, and signed Alpaca's customer
     * agreement, found here:
     * https://files.alpaca.markets/disclosures/library/AcctAppMarginAndCustAgmt.pdf
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun alpacaCustomerAgreement(): AlpacaCustomerAgreement =
        alpacaCustomerAgreement.getRequired("alpaca_customer_agreement")

    /**
     * AML check information for this individual. If any of the checks have a match, provide details
     * about the matches or hits found. The individual will be marked as high risk and be subject to
     * manual review.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun amlCheck(): AmlCheck = amlCheck.getRequired("aml_check")

    /**
     * Data source citations for a KYC check.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun dataCitation(): DataCitation = dataCitation.getRequired("data_citation")

    /**
     * Employment information for the individual
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun employment(): Employment = employment.getRequired("employment")

    /**
     * Financial profile information for the individual <br/><br/> Examples of liquid net worth
     * ranges: <br/> - $0 - $20,000 <br/> - $20,000 - $50,000 <br/> - $50,000 - $100,000 <br/> -
     * $100,000 - $500,000 <br/> - $500,000 - $1,000,000
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun financialProfile(): FinancialProfile = financialProfile.getRequired("financial_profile")

    /**
     * Identity information for the individual
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun identity(): Identity = identity.getRequired("identity")

    /**
     * Metadata about the KYC check.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun kycMetadata(): KycMetadata = kycMetadata.getRequired("kyc_metadata")

    /**
     * The non-professional trader property is a self-attestation for US customers that can affect
     * the metered realtime data fees. This field must be updated when if there is a change in the
     * user's attestation. This field may also be modified by Dinari compliance team. For more
     * information, please see the US Customers Integration Guide.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun nonProfessionalTraderAttestation(): NonProfessionalTraderAttestation =
        nonProfessionalTraderAttestation.getRequired("non_professional_trader_attestation")

    /**
     * Risk information about the individual <br/><br/> Fields denote if the account owner falls
     * under each category defined by FINRA rules. If any of the answers is true (yes), additional
     * verifications may be required before US account approval.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun riskDisclosure(): RiskDisclosure = riskDisclosure.getRequired("risk_disclosure")

    /**
     * Information for a trusted contact person for the individual. More information: <br/>
     * - <a
     *   href="https://www.investor.gov/introduction-investing/general-resources/news-alerts/alerts-bulletins/investor-bulletins-trusted-contact"
     *   target="_blank" rel="noopener noreferrer">Investor.gov - Trusted Contact</a> <br/>
     * - <a href="https://www.finra.org/investors/insights/trusted-contact" target="_blank"
     *   rel="noopener noreferrer">FINRA - Trusted Contact</a>
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun trustedContact(): TrustedContact = trustedContact.getRequired("trusted_contact")

    /**
     * US immigration information for this individual. Required if the individual is not a US
     * citizen.
     *
     * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usImmigrationInfo(): Optional<UsImmigrationInfo> =
        usImmigrationInfo.getOptional("us_immigration_info")

    /**
     * Returns the raw JSON value of [alpacaCustomerAgreement].
     *
     * Unlike [alpacaCustomerAgreement], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("alpaca_customer_agreement")
    @ExcludeMissing
    fun _alpacaCustomerAgreement(): JsonField<AlpacaCustomerAgreement> = alpacaCustomerAgreement

    /**
     * Returns the raw JSON value of [amlCheck].
     *
     * Unlike [amlCheck], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aml_check") @ExcludeMissing fun _amlCheck(): JsonField<AmlCheck> = amlCheck

    /**
     * Returns the raw JSON value of [dataCitation].
     *
     * Unlike [dataCitation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data_citation")
    @ExcludeMissing
    fun _dataCitation(): JsonField<DataCitation> = dataCitation

    /**
     * Returns the raw JSON value of [employment].
     *
     * Unlike [employment], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("employment")
    @ExcludeMissing
    fun _employment(): JsonField<Employment> = employment

    /**
     * Returns the raw JSON value of [financialProfile].
     *
     * Unlike [financialProfile], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("financial_profile")
    @ExcludeMissing
    fun _financialProfile(): JsonField<FinancialProfile> = financialProfile

    /**
     * Returns the raw JSON value of [identity].
     *
     * Unlike [identity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("identity") @ExcludeMissing fun _identity(): JsonField<Identity> = identity

    /**
     * Returns the raw JSON value of [kycMetadata].
     *
     * Unlike [kycMetadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kyc_metadata")
    @ExcludeMissing
    fun _kycMetadata(): JsonField<KycMetadata> = kycMetadata

    /**
     * Returns the raw JSON value of [nonProfessionalTraderAttestation].
     *
     * Unlike [nonProfessionalTraderAttestation], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("non_professional_trader_attestation")
    @ExcludeMissing
    fun _nonProfessionalTraderAttestation(): JsonField<NonProfessionalTraderAttestation> =
        nonProfessionalTraderAttestation

    /**
     * Returns the raw JSON value of [riskDisclosure].
     *
     * Unlike [riskDisclosure], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("risk_disclosure")
    @ExcludeMissing
    fun _riskDisclosure(): JsonField<RiskDisclosure> = riskDisclosure

    /**
     * Returns the raw JSON value of [trustedContact].
     *
     * Unlike [trustedContact], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("trusted_contact")
    @ExcludeMissing
    fun _trustedContact(): JsonField<TrustedContact> = trustedContact

    /**
     * Returns the raw JSON value of [usImmigrationInfo].
     *
     * Unlike [usImmigrationInfo], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("us_immigration_info")
    @ExcludeMissing
    fun _usImmigrationInfo(): JsonField<UsImmigrationInfo> = usImmigrationInfo

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
         * Returns a mutable builder for constructing an instance of [UsKycCheckData].
         *
         * The following fields are required:
         * ```java
         * .alpacaCustomerAgreement()
         * .amlCheck()
         * .dataCitation()
         * .employment()
         * .financialProfile()
         * .identity()
         * .kycMetadata()
         * .nonProfessionalTraderAttestation()
         * .riskDisclosure()
         * .trustedContact()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsKycCheckData]. */
    class Builder internal constructor() {

        private var alpacaCustomerAgreement: JsonField<AlpacaCustomerAgreement>? = null
        private var amlCheck: JsonField<AmlCheck>? = null
        private var dataCitation: JsonField<DataCitation>? = null
        private var employment: JsonField<Employment>? = null
        private var financialProfile: JsonField<FinancialProfile>? = null
        private var identity: JsonField<Identity>? = null
        private var kycMetadata: JsonField<KycMetadata>? = null
        private var nonProfessionalTraderAttestation: JsonField<NonProfessionalTraderAttestation>? =
            null
        private var riskDisclosure: JsonField<RiskDisclosure>? = null
        private var trustedContact: JsonField<TrustedContact>? = null
        private var usImmigrationInfo: JsonField<UsImmigrationInfo> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(usKycCheckData: UsKycCheckData) = apply {
            alpacaCustomerAgreement = usKycCheckData.alpacaCustomerAgreement
            amlCheck = usKycCheckData.amlCheck
            dataCitation = usKycCheckData.dataCitation
            employment = usKycCheckData.employment
            financialProfile = usKycCheckData.financialProfile
            identity = usKycCheckData.identity
            kycMetadata = usKycCheckData.kycMetadata
            nonProfessionalTraderAttestation = usKycCheckData.nonProfessionalTraderAttestation
            riskDisclosure = usKycCheckData.riskDisclosure
            trustedContact = usKycCheckData.trustedContact
            usImmigrationInfo = usKycCheckData.usImmigrationInfo
            additionalProperties = usKycCheckData.additionalProperties.toMutableMap()
        }

        /**
         * Information to affirm that the individual has read, agreed to, and signed Alpaca's
         * customer agreement, found here:
         * https://files.alpaca.markets/disclosures/library/AcctAppMarginAndCustAgmt.pdf
         */
        fun alpacaCustomerAgreement(alpacaCustomerAgreement: AlpacaCustomerAgreement) =
            alpacaCustomerAgreement(JsonField.of(alpacaCustomerAgreement))

        /**
         * Sets [Builder.alpacaCustomerAgreement] to an arbitrary JSON value.
         *
         * You should usually call [Builder.alpacaCustomerAgreement] with a well-typed
         * [AlpacaCustomerAgreement] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun alpacaCustomerAgreement(alpacaCustomerAgreement: JsonField<AlpacaCustomerAgreement>) =
            apply {
                this.alpacaCustomerAgreement = alpacaCustomerAgreement
            }

        /**
         * AML check information for this individual. If any of the checks have a match, provide
         * details about the matches or hits found. The individual will be marked as high risk and
         * be subject to manual review.
         */
        fun amlCheck(amlCheck: AmlCheck) = amlCheck(JsonField.of(amlCheck))

        /**
         * Sets [Builder.amlCheck] to an arbitrary JSON value.
         *
         * You should usually call [Builder.amlCheck] with a well-typed [AmlCheck] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun amlCheck(amlCheck: JsonField<AmlCheck>) = apply { this.amlCheck = amlCheck }

        /** Data source citations for a KYC check. */
        fun dataCitation(dataCitation: DataCitation) = dataCitation(JsonField.of(dataCitation))

        /**
         * Sets [Builder.dataCitation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dataCitation] with a well-typed [DataCitation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun dataCitation(dataCitation: JsonField<DataCitation>) = apply {
            this.dataCitation = dataCitation
        }

        /** Employment information for the individual */
        fun employment(employment: Employment) = employment(JsonField.of(employment))

        /**
         * Sets [Builder.employment] to an arbitrary JSON value.
         *
         * You should usually call [Builder.employment] with a well-typed [Employment] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun employment(employment: JsonField<Employment>) = apply { this.employment = employment }

        /**
         * Financial profile information for the individual <br/><br/> Examples of liquid net worth
         * ranges: <br/> - $0 - $20,000 <br/> - $20,000 - $50,000 <br/> - $50,000 - $100,000 <br/> -
         * $100,000 - $500,000 <br/> - $500,000 - $1,000,000
         */
        fun financialProfile(financialProfile: FinancialProfile) =
            financialProfile(JsonField.of(financialProfile))

        /**
         * Sets [Builder.financialProfile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.financialProfile] with a well-typed [FinancialProfile]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun financialProfile(financialProfile: JsonField<FinancialProfile>) = apply {
            this.financialProfile = financialProfile
        }

        /** Identity information for the individual */
        fun identity(identity: Identity) = identity(JsonField.of(identity))

        /**
         * Sets [Builder.identity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.identity] with a well-typed [Identity] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun identity(identity: JsonField<Identity>) = apply { this.identity = identity }

        /** Metadata about the KYC check. */
        fun kycMetadata(kycMetadata: KycMetadata) = kycMetadata(JsonField.of(kycMetadata))

        /**
         * Sets [Builder.kycMetadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kycMetadata] with a well-typed [KycMetadata] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun kycMetadata(kycMetadata: JsonField<KycMetadata>) = apply {
            this.kycMetadata = kycMetadata
        }

        /**
         * The non-professional trader property is a self-attestation for US customers that can
         * affect the metered realtime data fees. This field must be updated when if there is a
         * change in the user's attestation. This field may also be modified by Dinari compliance
         * team. For more information, please see the US Customers Integration Guide.
         */
        fun nonProfessionalTraderAttestation(
            nonProfessionalTraderAttestation: NonProfessionalTraderAttestation
        ) = nonProfessionalTraderAttestation(JsonField.of(nonProfessionalTraderAttestation))

        /**
         * Sets [Builder.nonProfessionalTraderAttestation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nonProfessionalTraderAttestation] with a well-typed
         * [NonProfessionalTraderAttestation] value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun nonProfessionalTraderAttestation(
            nonProfessionalTraderAttestation: JsonField<NonProfessionalTraderAttestation>
        ) = apply { this.nonProfessionalTraderAttestation = nonProfessionalTraderAttestation }

        /**
         * Risk information about the individual <br/><br/> Fields denote if the account owner falls
         * under each category defined by FINRA rules. If any of the answers is true (yes),
         * additional verifications may be required before US account approval.
         */
        fun riskDisclosure(riskDisclosure: RiskDisclosure) =
            riskDisclosure(JsonField.of(riskDisclosure))

        /**
         * Sets [Builder.riskDisclosure] to an arbitrary JSON value.
         *
         * You should usually call [Builder.riskDisclosure] with a well-typed [RiskDisclosure] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun riskDisclosure(riskDisclosure: JsonField<RiskDisclosure>) = apply {
            this.riskDisclosure = riskDisclosure
        }

        /**
         * Information for a trusted contact person for the individual. More information: <br/>
         * - <a
         *   href="https://www.investor.gov/introduction-investing/general-resources/news-alerts/alerts-bulletins/investor-bulletins-trusted-contact"
         *   target="_blank" rel="noopener noreferrer">Investor.gov - Trusted Contact</a> <br/>
         * - <a href="https://www.finra.org/investors/insights/trusted-contact" target="_blank"
         *   rel="noopener noreferrer">FINRA - Trusted Contact</a>
         */
        fun trustedContact(trustedContact: TrustedContact) =
            trustedContact(JsonField.of(trustedContact))

        /**
         * Sets [Builder.trustedContact] to an arbitrary JSON value.
         *
         * You should usually call [Builder.trustedContact] with a well-typed [TrustedContact] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun trustedContact(trustedContact: JsonField<TrustedContact>) = apply {
            this.trustedContact = trustedContact
        }

        /**
         * US immigration information for this individual. Required if the individual is not a US
         * citizen.
         */
        fun usImmigrationInfo(usImmigrationInfo: UsImmigrationInfo?) =
            usImmigrationInfo(JsonField.ofNullable(usImmigrationInfo))

        /** Alias for calling [Builder.usImmigrationInfo] with `usImmigrationInfo.orElse(null)`. */
        fun usImmigrationInfo(usImmigrationInfo: Optional<UsImmigrationInfo>) =
            usImmigrationInfo(usImmigrationInfo.getOrNull())

        /**
         * Sets [Builder.usImmigrationInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usImmigrationInfo] with a well-typed [UsImmigrationInfo]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun usImmigrationInfo(usImmigrationInfo: JsonField<UsImmigrationInfo>) = apply {
            this.usImmigrationInfo = usImmigrationInfo
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
         * Returns an immutable instance of [UsKycCheckData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .alpacaCustomerAgreement()
         * .amlCheck()
         * .dataCitation()
         * .employment()
         * .financialProfile()
         * .identity()
         * .kycMetadata()
         * .nonProfessionalTraderAttestation()
         * .riskDisclosure()
         * .trustedContact()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UsKycCheckData =
            UsKycCheckData(
                checkRequired("alpacaCustomerAgreement", alpacaCustomerAgreement),
                checkRequired("amlCheck", amlCheck),
                checkRequired("dataCitation", dataCitation),
                checkRequired("employment", employment),
                checkRequired("financialProfile", financialProfile),
                checkRequired("identity", identity),
                checkRequired("kycMetadata", kycMetadata),
                checkRequired("nonProfessionalTraderAttestation", nonProfessionalTraderAttestation),
                checkRequired("riskDisclosure", riskDisclosure),
                checkRequired("trustedContact", trustedContact),
                usImmigrationInfo,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): UsKycCheckData = apply {
        if (validated) {
            return@apply
        }

        alpacaCustomerAgreement().validate()
        amlCheck().validate()
        dataCitation().validate()
        employment().validate()
        financialProfile().validate()
        identity().validate()
        kycMetadata().validate()
        nonProfessionalTraderAttestation().validate()
        riskDisclosure().validate()
        trustedContact().validate()
        usImmigrationInfo().ifPresent { it.validate() }
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
        (alpacaCustomerAgreement.asKnown().getOrNull()?.validity() ?: 0) +
            (amlCheck.asKnown().getOrNull()?.validity() ?: 0) +
            (dataCitation.asKnown().getOrNull()?.validity() ?: 0) +
            (employment.asKnown().getOrNull()?.validity() ?: 0) +
            (financialProfile.asKnown().getOrNull()?.validity() ?: 0) +
            (identity.asKnown().getOrNull()?.validity() ?: 0) +
            (kycMetadata.asKnown().getOrNull()?.validity() ?: 0) +
            (nonProfessionalTraderAttestation.asKnown().getOrNull()?.validity() ?: 0) +
            (riskDisclosure.asKnown().getOrNull()?.validity() ?: 0) +
            (trustedContact.asKnown().getOrNull()?.validity() ?: 0) +
            (usImmigrationInfo.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Information to affirm that the individual has read, agreed to, and signed Alpaca's customer
     * agreement, found here:
     * https://files.alpaca.markets/disclosures/library/AcctAppMarginAndCustAgmt.pdf
     */
    class AlpacaCustomerAgreement
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val ipAddress: JsonField<String>,
        private val signedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ip_address")
            @ExcludeMissing
            ipAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("signed_at")
            @ExcludeMissing
            signedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(ipAddress, signedAt, mutableMapOf())

        /**
         * The IP address from where the individual signed the agreement.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun ipAddress(): String = ipAddress.getRequired("ip_address")

        /**
         * The timestamp the agreement was signed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun signedAt(): OffsetDateTime = signedAt.getRequired("signed_at")

        /**
         * Returns the raw JSON value of [ipAddress].
         *
         * Unlike [ipAddress], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ip_address") @ExcludeMissing fun _ipAddress(): JsonField<String> = ipAddress

        /**
         * Returns the raw JSON value of [signedAt].
         *
         * Unlike [signedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("signed_at")
        @ExcludeMissing
        fun _signedAt(): JsonField<OffsetDateTime> = signedAt

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
             * Returns a mutable builder for constructing an instance of [AlpacaCustomerAgreement].
             *
             * The following fields are required:
             * ```java
             * .ipAddress()
             * .signedAt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AlpacaCustomerAgreement]. */
        class Builder internal constructor() {

            private var ipAddress: JsonField<String>? = null
            private var signedAt: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(alpacaCustomerAgreement: AlpacaCustomerAgreement) = apply {
                ipAddress = alpacaCustomerAgreement.ipAddress
                signedAt = alpacaCustomerAgreement.signedAt
                additionalProperties = alpacaCustomerAgreement.additionalProperties.toMutableMap()
            }

            /** The IP address from where the individual signed the agreement. */
            fun ipAddress(ipAddress: String) = ipAddress(JsonField.of(ipAddress))

            /**
             * Sets [Builder.ipAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ipAddress] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun ipAddress(ipAddress: JsonField<String>) = apply { this.ipAddress = ipAddress }

            /** The timestamp the agreement was signed. */
            fun signedAt(signedAt: OffsetDateTime) = signedAt(JsonField.of(signedAt))

            /**
             * Sets [Builder.signedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.signedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun signedAt(signedAt: JsonField<OffsetDateTime>) = apply { this.signedAt = signedAt }

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
             * Returns an immutable instance of [AlpacaCustomerAgreement].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .ipAddress()
             * .signedAt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AlpacaCustomerAgreement =
                AlpacaCustomerAgreement(
                    checkRequired("ipAddress", ipAddress),
                    checkRequired("signedAt", signedAt),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): AlpacaCustomerAgreement = apply {
            if (validated) {
                return@apply
            }

            ipAddress()
            signedAt()
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
            (if (ipAddress.asKnown().isPresent) 1 else 0) +
                (if (signedAt.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AlpacaCustomerAgreement &&
                ipAddress == other.ipAddress &&
                signedAt == other.signedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(ipAddress, signedAt, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AlpacaCustomerAgreement{ipAddress=$ipAddress, signedAt=$signedAt, additionalProperties=$additionalProperties}"
    }

    /**
     * AML check information for this individual. If any of the checks have a match, provide details
     * about the matches or hits found. The individual will be marked as high risk and be subject to
     * manual review.
     */
    class AmlCheck
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val checkCreatedAt: JsonField<OffsetDateTime>,
        private val isAdverseMediaMatch: JsonField<Boolean>,
        private val isMonitoredListsMatch: JsonField<Boolean>,
        private val isPoliticallyExposedPersonMatch: JsonField<Boolean>,
        private val isSanctionsMatch: JsonField<Boolean>,
        private val records: JsonField<List<String>>,
        private val refId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("check_created_at")
            @ExcludeMissing
            checkCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("is_adverse_media_match")
            @ExcludeMissing
            isAdverseMediaMatch: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("is_monitored_lists_match")
            @ExcludeMissing
            isMonitoredListsMatch: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("is_politically_exposed_person_match")
            @ExcludeMissing
            isPoliticallyExposedPersonMatch: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("is_sanctions_match")
            @ExcludeMissing
            isSanctionsMatch: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("records")
            @ExcludeMissing
            records: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("ref_id") @ExcludeMissing refId: JsonField<String> = JsonMissing.of(),
        ) : this(
            checkCreatedAt,
            isAdverseMediaMatch,
            isMonitoredListsMatch,
            isPoliticallyExposedPersonMatch,
            isSanctionsMatch,
            records,
            refId,
            mutableMapOf(),
        )

        /**
         * Datetime that this AML check was created.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun checkCreatedAt(): OffsetDateTime = checkCreatedAt.getRequired("check_created_at")

        /**
         * Whether there was a match in the adverse media check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isAdverseMediaMatch(): Boolean =
            isAdverseMediaMatch.getRequired("is_adverse_media_match")

        /**
         * Whether there was a match in the monitored lists check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isMonitoredListsMatch(): Boolean =
            isMonitoredListsMatch.getRequired("is_monitored_lists_match")

        /**
         * Whether there was a match in the politically exposed person (PEP) check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isPoliticallyExposedPersonMatch(): Boolean =
            isPoliticallyExposedPersonMatch.getRequired("is_politically_exposed_person_match")

        /**
         * Whether there was a match in the sanctions check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isSanctionsMatch(): Boolean = isSanctionsMatch.getRequired("is_sanctions_match")

        /**
         * If any of the checks have a match, provide details about the matches or hits found.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun records(): List<String> = records.getRequired("records")

        /**
         * Your unique identifier for the AML check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun refId(): String = refId.getRequired("ref_id")

        /**
         * Returns the raw JSON value of [checkCreatedAt].
         *
         * Unlike [checkCreatedAt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("check_created_at")
        @ExcludeMissing
        fun _checkCreatedAt(): JsonField<OffsetDateTime> = checkCreatedAt

        /**
         * Returns the raw JSON value of [isAdverseMediaMatch].
         *
         * Unlike [isAdverseMediaMatch], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("is_adverse_media_match")
        @ExcludeMissing
        fun _isAdverseMediaMatch(): JsonField<Boolean> = isAdverseMediaMatch

        /**
         * Returns the raw JSON value of [isMonitoredListsMatch].
         *
         * Unlike [isMonitoredListsMatch], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("is_monitored_lists_match")
        @ExcludeMissing
        fun _isMonitoredListsMatch(): JsonField<Boolean> = isMonitoredListsMatch

        /**
         * Returns the raw JSON value of [isPoliticallyExposedPersonMatch].
         *
         * Unlike [isPoliticallyExposedPersonMatch], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("is_politically_exposed_person_match")
        @ExcludeMissing
        fun _isPoliticallyExposedPersonMatch(): JsonField<Boolean> = isPoliticallyExposedPersonMatch

        /**
         * Returns the raw JSON value of [isSanctionsMatch].
         *
         * Unlike [isSanctionsMatch], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("is_sanctions_match")
        @ExcludeMissing
        fun _isSanctionsMatch(): JsonField<Boolean> = isSanctionsMatch

        /**
         * Returns the raw JSON value of [records].
         *
         * Unlike [records], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("records") @ExcludeMissing fun _records(): JsonField<List<String>> = records

        /**
         * Returns the raw JSON value of [refId].
         *
         * Unlike [refId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ref_id") @ExcludeMissing fun _refId(): JsonField<String> = refId

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
             * Returns a mutable builder for constructing an instance of [AmlCheck].
             *
             * The following fields are required:
             * ```java
             * .checkCreatedAt()
             * .isAdverseMediaMatch()
             * .isMonitoredListsMatch()
             * .isPoliticallyExposedPersonMatch()
             * .isSanctionsMatch()
             * .records()
             * .refId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AmlCheck]. */
        class Builder internal constructor() {

            private var checkCreatedAt: JsonField<OffsetDateTime>? = null
            private var isAdverseMediaMatch: JsonField<Boolean>? = null
            private var isMonitoredListsMatch: JsonField<Boolean>? = null
            private var isPoliticallyExposedPersonMatch: JsonField<Boolean>? = null
            private var isSanctionsMatch: JsonField<Boolean>? = null
            private var records: JsonField<MutableList<String>>? = null
            private var refId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(amlCheck: AmlCheck) = apply {
                checkCreatedAt = amlCheck.checkCreatedAt
                isAdverseMediaMatch = amlCheck.isAdverseMediaMatch
                isMonitoredListsMatch = amlCheck.isMonitoredListsMatch
                isPoliticallyExposedPersonMatch = amlCheck.isPoliticallyExposedPersonMatch
                isSanctionsMatch = amlCheck.isSanctionsMatch
                records = amlCheck.records.map { it.toMutableList() }
                refId = amlCheck.refId
                additionalProperties = amlCheck.additionalProperties.toMutableMap()
            }

            /** Datetime that this AML check was created. */
            fun checkCreatedAt(checkCreatedAt: OffsetDateTime) =
                checkCreatedAt(JsonField.of(checkCreatedAt))

            /**
             * Sets [Builder.checkCreatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.checkCreatedAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun checkCreatedAt(checkCreatedAt: JsonField<OffsetDateTime>) = apply {
                this.checkCreatedAt = checkCreatedAt
            }

            /** Whether there was a match in the adverse media check. */
            fun isAdverseMediaMatch(isAdverseMediaMatch: Boolean) =
                isAdverseMediaMatch(JsonField.of(isAdverseMediaMatch))

            /**
             * Sets [Builder.isAdverseMediaMatch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isAdverseMediaMatch] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun isAdverseMediaMatch(isAdverseMediaMatch: JsonField<Boolean>) = apply {
                this.isAdverseMediaMatch = isAdverseMediaMatch
            }

            /** Whether there was a match in the monitored lists check. */
            fun isMonitoredListsMatch(isMonitoredListsMatch: Boolean) =
                isMonitoredListsMatch(JsonField.of(isMonitoredListsMatch))

            /**
             * Sets [Builder.isMonitoredListsMatch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isMonitoredListsMatch] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun isMonitoredListsMatch(isMonitoredListsMatch: JsonField<Boolean>) = apply {
                this.isMonitoredListsMatch = isMonitoredListsMatch
            }

            /** Whether there was a match in the politically exposed person (PEP) check. */
            fun isPoliticallyExposedPersonMatch(isPoliticallyExposedPersonMatch: Boolean) =
                isPoliticallyExposedPersonMatch(JsonField.of(isPoliticallyExposedPersonMatch))

            /**
             * Sets [Builder.isPoliticallyExposedPersonMatch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isPoliticallyExposedPersonMatch] with a well-typed
             * [Boolean] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun isPoliticallyExposedPersonMatch(
                isPoliticallyExposedPersonMatch: JsonField<Boolean>
            ) = apply { this.isPoliticallyExposedPersonMatch = isPoliticallyExposedPersonMatch }

            /** Whether there was a match in the sanctions check. */
            fun isSanctionsMatch(isSanctionsMatch: Boolean) =
                isSanctionsMatch(JsonField.of(isSanctionsMatch))

            /**
             * Sets [Builder.isSanctionsMatch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isSanctionsMatch] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isSanctionsMatch(isSanctionsMatch: JsonField<Boolean>) = apply {
                this.isSanctionsMatch = isSanctionsMatch
            }

            /**
             * If any of the checks have a match, provide details about the matches or hits found.
             */
            fun records(records: List<String>) = records(JsonField.of(records))

            /**
             * Sets [Builder.records] to an arbitrary JSON value.
             *
             * You should usually call [Builder.records] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun records(records: JsonField<List<String>>) = apply {
                this.records = records.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [records].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRecord(record: String) = apply {
                records =
                    (records ?: JsonField.of(mutableListOf())).also {
                        checkKnown("records", it).add(record)
                    }
            }

            /** Your unique identifier for the AML check. */
            fun refId(refId: String) = refId(JsonField.of(refId))

            /**
             * Sets [Builder.refId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.refId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun refId(refId: JsonField<String>) = apply { this.refId = refId }

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
             * Returns an immutable instance of [AmlCheck].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .checkCreatedAt()
             * .isAdverseMediaMatch()
             * .isMonitoredListsMatch()
             * .isPoliticallyExposedPersonMatch()
             * .isSanctionsMatch()
             * .records()
             * .refId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AmlCheck =
                AmlCheck(
                    checkRequired("checkCreatedAt", checkCreatedAt),
                    checkRequired("isAdverseMediaMatch", isAdverseMediaMatch),
                    checkRequired("isMonitoredListsMatch", isMonitoredListsMatch),
                    checkRequired(
                        "isPoliticallyExposedPersonMatch",
                        isPoliticallyExposedPersonMatch,
                    ),
                    checkRequired("isSanctionsMatch", isSanctionsMatch),
                    checkRequired("records", records).map { it.toImmutable() },
                    checkRequired("refId", refId),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): AmlCheck = apply {
            if (validated) {
                return@apply
            }

            checkCreatedAt()
            isAdverseMediaMatch()
            isMonitoredListsMatch()
            isPoliticallyExposedPersonMatch()
            isSanctionsMatch()
            records()
            refId()
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
            (if (checkCreatedAt.asKnown().isPresent) 1 else 0) +
                (if (isAdverseMediaMatch.asKnown().isPresent) 1 else 0) +
                (if (isMonitoredListsMatch.asKnown().isPresent) 1 else 0) +
                (if (isPoliticallyExposedPersonMatch.asKnown().isPresent) 1 else 0) +
                (if (isSanctionsMatch.asKnown().isPresent) 1 else 0) +
                (records.asKnown().getOrNull()?.size ?: 0) +
                (if (refId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AmlCheck &&
                checkCreatedAt == other.checkCreatedAt &&
                isAdverseMediaMatch == other.isAdverseMediaMatch &&
                isMonitoredListsMatch == other.isMonitoredListsMatch &&
                isPoliticallyExposedPersonMatch == other.isPoliticallyExposedPersonMatch &&
                isSanctionsMatch == other.isSanctionsMatch &&
                records == other.records &&
                refId == other.refId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                checkCreatedAt,
                isAdverseMediaMatch,
                isMonitoredListsMatch,
                isPoliticallyExposedPersonMatch,
                isSanctionsMatch,
                records,
                refId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AmlCheck{checkCreatedAt=$checkCreatedAt, isAdverseMediaMatch=$isAdverseMediaMatch, isMonitoredListsMatch=$isMonitoredListsMatch, isPoliticallyExposedPersonMatch=$isPoliticallyExposedPersonMatch, isSanctionsMatch=$isSanctionsMatch, records=$records, refId=$refId, additionalProperties=$additionalProperties}"
    }

    /** Data source citations for a KYC check. */
    class DataCitation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val addressSources: JsonField<List<String>>,
        private val dateOfBirthSources: JsonField<List<String>>,
        private val taxIdSources: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("address_sources")
            @ExcludeMissing
            addressSources: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("date_of_birth_sources")
            @ExcludeMissing
            dateOfBirthSources: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("tax_id_sources")
            @ExcludeMissing
            taxIdSources: JsonField<List<String>> = JsonMissing.of(),
        ) : this(addressSources, dateOfBirthSources, taxIdSources, mutableMapOf())

        /**
         * List of sources for address verification
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun addressSources(): List<String> = addressSources.getRequired("address_sources")

        /**
         * List of sources for date of birth verification
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun dateOfBirthSources(): List<String> =
            dateOfBirthSources.getRequired("date_of_birth_sources")

        /**
         * List of sources for tax ID verification
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun taxIdSources(): List<String> = taxIdSources.getRequired("tax_id_sources")

        /**
         * Returns the raw JSON value of [addressSources].
         *
         * Unlike [addressSources], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("address_sources")
        @ExcludeMissing
        fun _addressSources(): JsonField<List<String>> = addressSources

        /**
         * Returns the raw JSON value of [dateOfBirthSources].
         *
         * Unlike [dateOfBirthSources], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("date_of_birth_sources")
        @ExcludeMissing
        fun _dateOfBirthSources(): JsonField<List<String>> = dateOfBirthSources

        /**
         * Returns the raw JSON value of [taxIdSources].
         *
         * Unlike [taxIdSources], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("tax_id_sources")
        @ExcludeMissing
        fun _taxIdSources(): JsonField<List<String>> = taxIdSources

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
             * Returns a mutable builder for constructing an instance of [DataCitation].
             *
             * The following fields are required:
             * ```java
             * .addressSources()
             * .dateOfBirthSources()
             * .taxIdSources()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [DataCitation]. */
        class Builder internal constructor() {

            private var addressSources: JsonField<MutableList<String>>? = null
            private var dateOfBirthSources: JsonField<MutableList<String>>? = null
            private var taxIdSources: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(dataCitation: DataCitation) = apply {
                addressSources = dataCitation.addressSources.map { it.toMutableList() }
                dateOfBirthSources = dataCitation.dateOfBirthSources.map { it.toMutableList() }
                taxIdSources = dataCitation.taxIdSources.map { it.toMutableList() }
                additionalProperties = dataCitation.additionalProperties.toMutableMap()
            }

            /** List of sources for address verification */
            fun addressSources(addressSources: List<String>) =
                addressSources(JsonField.of(addressSources))

            /**
             * Sets [Builder.addressSources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.addressSources] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun addressSources(addressSources: JsonField<List<String>>) = apply {
                this.addressSources = addressSources.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [addressSources].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAddressSource(addressSource: String) = apply {
                addressSources =
                    (addressSources ?: JsonField.of(mutableListOf())).also {
                        checkKnown("addressSources", it).add(addressSource)
                    }
            }

            /** List of sources for date of birth verification */
            fun dateOfBirthSources(dateOfBirthSources: List<String>) =
                dateOfBirthSources(JsonField.of(dateOfBirthSources))

            /**
             * Sets [Builder.dateOfBirthSources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dateOfBirthSources] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun dateOfBirthSources(dateOfBirthSources: JsonField<List<String>>) = apply {
                this.dateOfBirthSources = dateOfBirthSources.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [dateOfBirthSources].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDateOfBirthSource(dateOfBirthSource: String) = apply {
                dateOfBirthSources =
                    (dateOfBirthSources ?: JsonField.of(mutableListOf())).also {
                        checkKnown("dateOfBirthSources", it).add(dateOfBirthSource)
                    }
            }

            /** List of sources for tax ID verification */
            fun taxIdSources(taxIdSources: List<String>) = taxIdSources(JsonField.of(taxIdSources))

            /**
             * Sets [Builder.taxIdSources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.taxIdSources] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun taxIdSources(taxIdSources: JsonField<List<String>>) = apply {
                this.taxIdSources = taxIdSources.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [taxIdSources].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTaxIdSource(taxIdSource: String) = apply {
                taxIdSources =
                    (taxIdSources ?: JsonField.of(mutableListOf())).also {
                        checkKnown("taxIdSources", it).add(taxIdSource)
                    }
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
             * Returns an immutable instance of [DataCitation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .addressSources()
             * .dateOfBirthSources()
             * .taxIdSources()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): DataCitation =
                DataCitation(
                    checkRequired("addressSources", addressSources).map { it.toImmutable() },
                    checkRequired("dateOfBirthSources", dateOfBirthSources).map {
                        it.toImmutable()
                    },
                    checkRequired("taxIdSources", taxIdSources).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): DataCitation = apply {
            if (validated) {
                return@apply
            }

            addressSources()
            dateOfBirthSources()
            taxIdSources()
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
            (addressSources.asKnown().getOrNull()?.size ?: 0) +
                (dateOfBirthSources.asKnown().getOrNull()?.size ?: 0) +
                (taxIdSources.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DataCitation &&
                addressSources == other.addressSources &&
                dateOfBirthSources == other.dateOfBirthSources &&
                taxIdSources == other.taxIdSources &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(addressSources, dateOfBirthSources, taxIdSources, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "DataCitation{addressSources=$addressSources, dateOfBirthSources=$dateOfBirthSources, taxIdSources=$taxIdSources, additionalProperties=$additionalProperties}"
    }

    /** Employment information for the individual */
    class Employment
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val employmentStatus: JsonField<EmploymentStatus>,
        private val employerAddress: JsonField<String>,
        private val employerName: JsonField<String>,
        private val employmentPosition: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("employment_status")
            @ExcludeMissing
            employmentStatus: JsonField<EmploymentStatus> = JsonMissing.of(),
            @JsonProperty("employer_address")
            @ExcludeMissing
            employerAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("employer_name")
            @ExcludeMissing
            employerName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("employment_position")
            @ExcludeMissing
            employmentPosition: JsonField<String> = JsonMissing.of(),
        ) : this(
            employmentStatus,
            employerAddress,
            employerName,
            employmentPosition,
            mutableMapOf(),
        )

        /**
         * One of the following: employed, unemployed, retired, or student.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun employmentStatus(): EmploymentStatus = employmentStatus.getRequired("employment_status")

        /**
         * The employer's address if the user is employed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun employerAddress(): Optional<String> = employerAddress.getOptional("employer_address")

        /**
         * The name of the employer if the user is employed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun employerName(): Optional<String> = employerName.getOptional("employer_name")

        /**
         * The user's position if they are employed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun employmentPosition(): Optional<String> =
            employmentPosition.getOptional("employment_position")

        /**
         * Returns the raw JSON value of [employmentStatus].
         *
         * Unlike [employmentStatus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("employment_status")
        @ExcludeMissing
        fun _employmentStatus(): JsonField<EmploymentStatus> = employmentStatus

        /**
         * Returns the raw JSON value of [employerAddress].
         *
         * Unlike [employerAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("employer_address")
        @ExcludeMissing
        fun _employerAddress(): JsonField<String> = employerAddress

        /**
         * Returns the raw JSON value of [employerName].
         *
         * Unlike [employerName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("employer_name")
        @ExcludeMissing
        fun _employerName(): JsonField<String> = employerName

        /**
         * Returns the raw JSON value of [employmentPosition].
         *
         * Unlike [employmentPosition], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("employment_position")
        @ExcludeMissing
        fun _employmentPosition(): JsonField<String> = employmentPosition

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
             * Returns a mutable builder for constructing an instance of [Employment].
             *
             * The following fields are required:
             * ```java
             * .employmentStatus()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Employment]. */
        class Builder internal constructor() {

            private var employmentStatus: JsonField<EmploymentStatus>? = null
            private var employerAddress: JsonField<String> = JsonMissing.of()
            private var employerName: JsonField<String> = JsonMissing.of()
            private var employmentPosition: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(employment: Employment) = apply {
                employmentStatus = employment.employmentStatus
                employerAddress = employment.employerAddress
                employerName = employment.employerName
                employmentPosition = employment.employmentPosition
                additionalProperties = employment.additionalProperties.toMutableMap()
            }

            /** One of the following: employed, unemployed, retired, or student. */
            fun employmentStatus(employmentStatus: EmploymentStatus) =
                employmentStatus(JsonField.of(employmentStatus))

            /**
             * Sets [Builder.employmentStatus] to an arbitrary JSON value.
             *
             * You should usually call [Builder.employmentStatus] with a well-typed
             * [EmploymentStatus] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun employmentStatus(employmentStatus: JsonField<EmploymentStatus>) = apply {
                this.employmentStatus = employmentStatus
            }

            /** The employer's address if the user is employed. */
            fun employerAddress(employerAddress: String?) =
                employerAddress(JsonField.ofNullable(employerAddress))

            /** Alias for calling [Builder.employerAddress] with `employerAddress.orElse(null)`. */
            fun employerAddress(employerAddress: Optional<String>) =
                employerAddress(employerAddress.getOrNull())

            /**
             * Sets [Builder.employerAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.employerAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun employerAddress(employerAddress: JsonField<String>) = apply {
                this.employerAddress = employerAddress
            }

            /** The name of the employer if the user is employed. */
            fun employerName(employerName: String?) =
                employerName(JsonField.ofNullable(employerName))

            /** Alias for calling [Builder.employerName] with `employerName.orElse(null)`. */
            fun employerName(employerName: Optional<String>) =
                employerName(employerName.getOrNull())

            /**
             * Sets [Builder.employerName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.employerName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun employerName(employerName: JsonField<String>) = apply {
                this.employerName = employerName
            }

            /** The user's position if they are employed. */
            fun employmentPosition(employmentPosition: String?) =
                employmentPosition(JsonField.ofNullable(employmentPosition))

            /**
             * Alias for calling [Builder.employmentPosition] with
             * `employmentPosition.orElse(null)`.
             */
            fun employmentPosition(employmentPosition: Optional<String>) =
                employmentPosition(employmentPosition.getOrNull())

            /**
             * Sets [Builder.employmentPosition] to an arbitrary JSON value.
             *
             * You should usually call [Builder.employmentPosition] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun employmentPosition(employmentPosition: JsonField<String>) = apply {
                this.employmentPosition = employmentPosition
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
             * Returns an immutable instance of [Employment].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .employmentStatus()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Employment =
                Employment(
                    checkRequired("employmentStatus", employmentStatus),
                    employerAddress,
                    employerName,
                    employmentPosition,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Employment = apply {
            if (validated) {
                return@apply
            }

            employmentStatus().validate()
            employerAddress()
            employerName()
            employmentPosition()
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
            (employmentStatus.asKnown().getOrNull()?.validity() ?: 0) +
                (if (employerAddress.asKnown().isPresent) 1 else 0) +
                (if (employerName.asKnown().isPresent) 1 else 0) +
                (if (employmentPosition.asKnown().isPresent) 1 else 0)

        /** One of the following: employed, unemployed, retired, or student. */
        class EmploymentStatus
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val UNEMPLOYED = of("UNEMPLOYED")

                @JvmField val EMPLOYED = of("EMPLOYED")

                @JvmField val STUDENT = of("STUDENT")

                @JvmField val RETIRED = of("RETIRED")

                @JvmStatic fun of(value: String) = EmploymentStatus(JsonField.of(value))
            }

            /** An enum containing [EmploymentStatus]'s known values. */
            enum class Known {
                UNEMPLOYED,
                EMPLOYED,
                STUDENT,
                RETIRED,
            }

            /**
             * An enum containing [EmploymentStatus]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [EmploymentStatus] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                UNEMPLOYED,
                EMPLOYED,
                STUDENT,
                RETIRED,
                /**
                 * An enum member indicating that [EmploymentStatus] was instantiated with an
                 * unknown value.
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
                    UNEMPLOYED -> Value.UNEMPLOYED
                    EMPLOYED -> Value.EMPLOYED
                    STUDENT -> Value.STUDENT
                    RETIRED -> Value.RETIRED
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
                    UNEMPLOYED -> Known.UNEMPLOYED
                    EMPLOYED -> Known.EMPLOYED
                    STUDENT -> Known.STUDENT
                    RETIRED -> Known.RETIRED
                    else -> throw DinariInvalidDataException("Unknown EmploymentStatus: $value")
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

            fun validate(): EmploymentStatus = apply {
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

                return other is EmploymentStatus && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Employment &&
                employmentStatus == other.employmentStatus &&
                employerAddress == other.employerAddress &&
                employerName == other.employerName &&
                employmentPosition == other.employmentPosition &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                employmentStatus,
                employerAddress,
                employerName,
                employmentPosition,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Employment{employmentStatus=$employmentStatus, employerAddress=$employerAddress, employerName=$employerName, employmentPosition=$employmentPosition, additionalProperties=$additionalProperties}"
    }

    /**
     * Financial profile information for the individual <br/><br/> Examples of liquid net worth
     * ranges: <br/> - $0 - $20,000 <br/> - $20,000 - $50,000 <br/> - $50,000 - $100,000 <br/> -
     * $100,000 - $500,000 <br/> - $500,000 - $1,000,000
     */
    class FinancialProfile
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val fundingSources: JsonField<List<FundingSource>>,
        private val liquidNetWorthMax: JsonField<Long>,
        private val liquidNetWorthMin: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("funding_sources")
            @ExcludeMissing
            fundingSources: JsonField<List<FundingSource>> = JsonMissing.of(),
            @JsonProperty("liquid_net_worth_max")
            @ExcludeMissing
            liquidNetWorthMax: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("liquid_net_worth_min")
            @ExcludeMissing
            liquidNetWorthMin: JsonField<Long> = JsonMissing.of(),
        ) : this(fundingSources, liquidNetWorthMax, liquidNetWorthMin, mutableMapOf())

        /**
         * One or more of the following: employment_income, investments, inheritance,
         * business_income, savings, family.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fundingSources(): List<FundingSource> = fundingSources.getRequired("funding_sources")

        /**
         * The upper bound of the user's liquid net worth (USD).
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun liquidNetWorthMax(): Long = liquidNetWorthMax.getRequired("liquid_net_worth_max")

        /**
         * The lower bound of the user's liquid net worth (USD). Can be 0 if max is <=$20,000, but
         * otherwise must be within an order of magnitude of the max value.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun liquidNetWorthMin(): Long = liquidNetWorthMin.getRequired("liquid_net_worth_min")

        /**
         * Returns the raw JSON value of [fundingSources].
         *
         * Unlike [fundingSources], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("funding_sources")
        @ExcludeMissing
        fun _fundingSources(): JsonField<List<FundingSource>> = fundingSources

        /**
         * Returns the raw JSON value of [liquidNetWorthMax].
         *
         * Unlike [liquidNetWorthMax], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("liquid_net_worth_max")
        @ExcludeMissing
        fun _liquidNetWorthMax(): JsonField<Long> = liquidNetWorthMax

        /**
         * Returns the raw JSON value of [liquidNetWorthMin].
         *
         * Unlike [liquidNetWorthMin], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("liquid_net_worth_min")
        @ExcludeMissing
        fun _liquidNetWorthMin(): JsonField<Long> = liquidNetWorthMin

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
             * Returns a mutable builder for constructing an instance of [FinancialProfile].
             *
             * The following fields are required:
             * ```java
             * .fundingSources()
             * .liquidNetWorthMax()
             * .liquidNetWorthMin()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FinancialProfile]. */
        class Builder internal constructor() {

            private var fundingSources: JsonField<MutableList<FundingSource>>? = null
            private var liquidNetWorthMax: JsonField<Long>? = null
            private var liquidNetWorthMin: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(financialProfile: FinancialProfile) = apply {
                fundingSources = financialProfile.fundingSources.map { it.toMutableList() }
                liquidNetWorthMax = financialProfile.liquidNetWorthMax
                liquidNetWorthMin = financialProfile.liquidNetWorthMin
                additionalProperties = financialProfile.additionalProperties.toMutableMap()
            }

            /**
             * One or more of the following: employment_income, investments, inheritance,
             * business_income, savings, family.
             */
            fun fundingSources(fundingSources: List<FundingSource>) =
                fundingSources(JsonField.of(fundingSources))

            /**
             * Sets [Builder.fundingSources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fundingSources] with a well-typed
             * `List<FundingSource>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun fundingSources(fundingSources: JsonField<List<FundingSource>>) = apply {
                this.fundingSources = fundingSources.map { it.toMutableList() }
            }

            /**
             * Adds a single [FundingSource] to [fundingSources].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addFundingSource(fundingSource: FundingSource) = apply {
                fundingSources =
                    (fundingSources ?: JsonField.of(mutableListOf())).also {
                        checkKnown("fundingSources", it).add(fundingSource)
                    }
            }

            /** The upper bound of the user's liquid net worth (USD). */
            fun liquidNetWorthMax(liquidNetWorthMax: Long) =
                liquidNetWorthMax(JsonField.of(liquidNetWorthMax))

            /**
             * Sets [Builder.liquidNetWorthMax] to an arbitrary JSON value.
             *
             * You should usually call [Builder.liquidNetWorthMax] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun liquidNetWorthMax(liquidNetWorthMax: JsonField<Long>) = apply {
                this.liquidNetWorthMax = liquidNetWorthMax
            }

            /**
             * The lower bound of the user's liquid net worth (USD). Can be 0 if max is <=$20,000,
             * but otherwise must be within an order of magnitude of the max value.
             */
            fun liquidNetWorthMin(liquidNetWorthMin: Long) =
                liquidNetWorthMin(JsonField.of(liquidNetWorthMin))

            /**
             * Sets [Builder.liquidNetWorthMin] to an arbitrary JSON value.
             *
             * You should usually call [Builder.liquidNetWorthMin] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun liquidNetWorthMin(liquidNetWorthMin: JsonField<Long>) = apply {
                this.liquidNetWorthMin = liquidNetWorthMin
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
             * Returns an immutable instance of [FinancialProfile].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .fundingSources()
             * .liquidNetWorthMax()
             * .liquidNetWorthMin()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FinancialProfile =
                FinancialProfile(
                    checkRequired("fundingSources", fundingSources).map { it.toImmutable() },
                    checkRequired("liquidNetWorthMax", liquidNetWorthMax),
                    checkRequired("liquidNetWorthMin", liquidNetWorthMin),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): FinancialProfile = apply {
            if (validated) {
                return@apply
            }

            fundingSources().forEach { it.validate() }
            liquidNetWorthMax()
            liquidNetWorthMin()
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
            (fundingSources.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (liquidNetWorthMax.asKnown().isPresent) 1 else 0) +
                (if (liquidNetWorthMin.asKnown().isPresent) 1 else 0)

        class FundingSource @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val EMPLOYMENT_INCOME = of("EMPLOYMENT_INCOME")

                @JvmField val INVESTMENTS = of("INVESTMENTS")

                @JvmField val INHERITANCE = of("INHERITANCE")

                @JvmField val BUSINESS_INCOME = of("BUSINESS_INCOME")

                @JvmField val SAVINGS = of("SAVINGS")

                @JvmField val FAMILY = of("FAMILY")

                @JvmStatic fun of(value: String) = FundingSource(JsonField.of(value))
            }

            /** An enum containing [FundingSource]'s known values. */
            enum class Known {
                EMPLOYMENT_INCOME,
                INVESTMENTS,
                INHERITANCE,
                BUSINESS_INCOME,
                SAVINGS,
                FAMILY,
            }

            /**
             * An enum containing [FundingSource]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [FundingSource] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                EMPLOYMENT_INCOME,
                INVESTMENTS,
                INHERITANCE,
                BUSINESS_INCOME,
                SAVINGS,
                FAMILY,
                /**
                 * An enum member indicating that [FundingSource] was instantiated with an unknown
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
                    EMPLOYMENT_INCOME -> Value.EMPLOYMENT_INCOME
                    INVESTMENTS -> Value.INVESTMENTS
                    INHERITANCE -> Value.INHERITANCE
                    BUSINESS_INCOME -> Value.BUSINESS_INCOME
                    SAVINGS -> Value.SAVINGS
                    FAMILY -> Value.FAMILY
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
                    EMPLOYMENT_INCOME -> Known.EMPLOYMENT_INCOME
                    INVESTMENTS -> Known.INVESTMENTS
                    INHERITANCE -> Known.INHERITANCE
                    BUSINESS_INCOME -> Known.BUSINESS_INCOME
                    SAVINGS -> Known.SAVINGS
                    FAMILY -> Known.FAMILY
                    else -> throw DinariInvalidDataException("Unknown FundingSource: $value")
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

            fun validate(): FundingSource = apply {
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

                return other is FundingSource && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FinancialProfile &&
                fundingSources == other.fundingSources &&
                liquidNetWorthMax == other.liquidNetWorthMax &&
                liquidNetWorthMin == other.liquidNetWorthMin &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(fundingSources, liquidNetWorthMax, liquidNetWorthMin, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FinancialProfile{fundingSources=$fundingSources, liquidNetWorthMax=$liquidNetWorthMax, liquidNetWorthMin=$liquidNetWorthMin, additionalProperties=$additionalProperties}"
    }

    /** Identity information for the individual */
    class Identity
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val city: JsonField<String>,
        private val countryOfCitizenship: JsonField<String>,
        private val countryOfTaxResidence: JsonField<CountryOfTaxResidence>,
        private val dateOfBirth: JsonField<LocalDate>,
        private val emailAddress: JsonField<String>,
        private val familyName: JsonField<String>,
        private val givenName: JsonField<String>,
        private val phoneNumber: JsonField<String>,
        private val postalCode: JsonField<String>,
        private val streetAddress: JsonField<String>,
        private val taxId: JsonField<String>,
        private val middleName: JsonField<String>,
        private val state: JsonField<String>,
        private val unit: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("city") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
            @JsonProperty("country_of_citizenship")
            @ExcludeMissing
            countryOfCitizenship: JsonField<String> = JsonMissing.of(),
            @JsonProperty("country_of_tax_residence")
            @ExcludeMissing
            countryOfTaxResidence: JsonField<CountryOfTaxResidence> = JsonMissing.of(),
            @JsonProperty("date_of_birth")
            @ExcludeMissing
            dateOfBirth: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("email_address")
            @ExcludeMissing
            emailAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("family_name")
            @ExcludeMissing
            familyName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("given_name")
            @ExcludeMissing
            givenName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phone_number")
            @ExcludeMissing
            phoneNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("postal_code")
            @ExcludeMissing
            postalCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("street_address")
            @ExcludeMissing
            streetAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tax_id") @ExcludeMissing taxId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("middle_name")
            @ExcludeMissing
            middleName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
            @JsonProperty("unit") @ExcludeMissing unit: JsonField<String> = JsonMissing.of(),
        ) : this(
            city,
            countryOfCitizenship,
            countryOfTaxResidence,
            dateOfBirth,
            emailAddress,
            familyName,
            givenName,
            phoneNumber,
            postalCode,
            streetAddress,
            taxId,
            middleName,
            state,
            unit,
            mutableMapOf(),
        )

        /**
         * City of the applicant.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun city(): String = city.getRequired("city")

        /**
         * Nationality of the applicant.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun countryOfCitizenship(): String =
            countryOfCitizenship.getRequired("country_of_citizenship")

        /**
         * Country of residency of the applicant. Must be 'US'.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun countryOfTaxResidence(): CountryOfTaxResidence =
            countryOfTaxResidence.getRequired("country_of_tax_residence")

        /**
         * Date of birth of the applicant.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun dateOfBirth(): LocalDate = dateOfBirth.getRequired("date_of_birth")

        /**
         * Email address of the applicant.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun emailAddress(): String = emailAddress.getRequired("email_address")

        /**
         * The last name (surname) of the user.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun familyName(): String = familyName.getRequired("family_name")

        /**
         * The first/given name of the user.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun givenName(): String = givenName.getRequired("given_name")

        /**
         * Phone number should include the country code, format: “+15555555555”
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun phoneNumber(): String = phoneNumber.getRequired("phone_number")

        /**
         * Postal code of the applicant.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun postalCode(): String = postalCode.getRequired("postal_code")

        /**
         * Street address of the applicant.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun streetAddress(): String = streetAddress.getRequired("street_address")

        /**
         * Social Security Number (SSN) or Tax Identification Number (TIN) of the applicant.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun taxId(): String = taxId.getRequired("tax_id")

        /**
         * The middle name of the user.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun middleName(): Optional<String> = middleName.getOptional("middle_name")

        /**
         * State of the applicant. Required if the applicant resides in the US as a 2-letter
         * abbreviation.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun state(): Optional<String> = state.getOptional("state")

        /**
         * The specific apartment number if applicable
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun unit(): Optional<String> = unit.getOptional("unit")

        /**
         * Returns the raw JSON value of [city].
         *
         * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

        /**
         * Returns the raw JSON value of [countryOfCitizenship].
         *
         * Unlike [countryOfCitizenship], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("country_of_citizenship")
        @ExcludeMissing
        fun _countryOfCitizenship(): JsonField<String> = countryOfCitizenship

        /**
         * Returns the raw JSON value of [countryOfTaxResidence].
         *
         * Unlike [countryOfTaxResidence], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("country_of_tax_residence")
        @ExcludeMissing
        fun _countryOfTaxResidence(): JsonField<CountryOfTaxResidence> = countryOfTaxResidence

        /**
         * Returns the raw JSON value of [dateOfBirth].
         *
         * Unlike [dateOfBirth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("date_of_birth")
        @ExcludeMissing
        fun _dateOfBirth(): JsonField<LocalDate> = dateOfBirth

        /**
         * Returns the raw JSON value of [emailAddress].
         *
         * Unlike [emailAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("email_address")
        @ExcludeMissing
        fun _emailAddress(): JsonField<String> = emailAddress

        /**
         * Returns the raw JSON value of [familyName].
         *
         * Unlike [familyName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("family_name")
        @ExcludeMissing
        fun _familyName(): JsonField<String> = familyName

        /**
         * Returns the raw JSON value of [givenName].
         *
         * Unlike [givenName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("given_name") @ExcludeMissing fun _givenName(): JsonField<String> = givenName

        /**
         * Returns the raw JSON value of [phoneNumber].
         *
         * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("phone_number")
        @ExcludeMissing
        fun _phoneNumber(): JsonField<String> = phoneNumber

        /**
         * Returns the raw JSON value of [postalCode].
         *
         * Unlike [postalCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("postal_code")
        @ExcludeMissing
        fun _postalCode(): JsonField<String> = postalCode

        /**
         * Returns the raw JSON value of [streetAddress].
         *
         * Unlike [streetAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("street_address")
        @ExcludeMissing
        fun _streetAddress(): JsonField<String> = streetAddress

        /**
         * Returns the raw JSON value of [taxId].
         *
         * Unlike [taxId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tax_id") @ExcludeMissing fun _taxId(): JsonField<String> = taxId

        /**
         * Returns the raw JSON value of [middleName].
         *
         * Unlike [middleName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("middle_name")
        @ExcludeMissing
        fun _middleName(): JsonField<String> = middleName

        /**
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<String> = state

        /**
         * Returns the raw JSON value of [unit].
         *
         * Unlike [unit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("unit") @ExcludeMissing fun _unit(): JsonField<String> = unit

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
             * Returns a mutable builder for constructing an instance of [Identity].
             *
             * The following fields are required:
             * ```java
             * .city()
             * .countryOfCitizenship()
             * .countryOfTaxResidence()
             * .dateOfBirth()
             * .emailAddress()
             * .familyName()
             * .givenName()
             * .phoneNumber()
             * .postalCode()
             * .streetAddress()
             * .taxId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Identity]. */
        class Builder internal constructor() {

            private var city: JsonField<String>? = null
            private var countryOfCitizenship: JsonField<String>? = null
            private var countryOfTaxResidence: JsonField<CountryOfTaxResidence>? = null
            private var dateOfBirth: JsonField<LocalDate>? = null
            private var emailAddress: JsonField<String>? = null
            private var familyName: JsonField<String>? = null
            private var givenName: JsonField<String>? = null
            private var phoneNumber: JsonField<String>? = null
            private var postalCode: JsonField<String>? = null
            private var streetAddress: JsonField<String>? = null
            private var taxId: JsonField<String>? = null
            private var middleName: JsonField<String> = JsonMissing.of()
            private var state: JsonField<String> = JsonMissing.of()
            private var unit: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(identity: Identity) = apply {
                city = identity.city
                countryOfCitizenship = identity.countryOfCitizenship
                countryOfTaxResidence = identity.countryOfTaxResidence
                dateOfBirth = identity.dateOfBirth
                emailAddress = identity.emailAddress
                familyName = identity.familyName
                givenName = identity.givenName
                phoneNumber = identity.phoneNumber
                postalCode = identity.postalCode
                streetAddress = identity.streetAddress
                taxId = identity.taxId
                middleName = identity.middleName
                state = identity.state
                unit = identity.unit
                additionalProperties = identity.additionalProperties.toMutableMap()
            }

            /** City of the applicant. */
            fun city(city: String) = city(JsonField.of(city))

            /**
             * Sets [Builder.city] to an arbitrary JSON value.
             *
             * You should usually call [Builder.city] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun city(city: JsonField<String>) = apply { this.city = city }

            /** Nationality of the applicant. */
            fun countryOfCitizenship(countryOfCitizenship: String) =
                countryOfCitizenship(JsonField.of(countryOfCitizenship))

            /**
             * Sets [Builder.countryOfCitizenship] to an arbitrary JSON value.
             *
             * You should usually call [Builder.countryOfCitizenship] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun countryOfCitizenship(countryOfCitizenship: JsonField<String>) = apply {
                this.countryOfCitizenship = countryOfCitizenship
            }

            /** Country of residency of the applicant. Must be 'US'. */
            fun countryOfTaxResidence(countryOfTaxResidence: CountryOfTaxResidence) =
                countryOfTaxResidence(JsonField.of(countryOfTaxResidence))

            /**
             * Sets [Builder.countryOfTaxResidence] to an arbitrary JSON value.
             *
             * You should usually call [Builder.countryOfTaxResidence] with a well-typed
             * [CountryOfTaxResidence] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun countryOfTaxResidence(countryOfTaxResidence: JsonField<CountryOfTaxResidence>) =
                apply {
                    this.countryOfTaxResidence = countryOfTaxResidence
                }

            /** Date of birth of the applicant. */
            fun dateOfBirth(dateOfBirth: LocalDate) = dateOfBirth(JsonField.of(dateOfBirth))

            /**
             * Sets [Builder.dateOfBirth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dateOfBirth] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dateOfBirth(dateOfBirth: JsonField<LocalDate>) = apply {
                this.dateOfBirth = dateOfBirth
            }

            /** Email address of the applicant. */
            fun emailAddress(emailAddress: String) = emailAddress(JsonField.of(emailAddress))

            /**
             * Sets [Builder.emailAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.emailAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun emailAddress(emailAddress: JsonField<String>) = apply {
                this.emailAddress = emailAddress
            }

            /** The last name (surname) of the user. */
            fun familyName(familyName: String) = familyName(JsonField.of(familyName))

            /**
             * Sets [Builder.familyName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.familyName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun familyName(familyName: JsonField<String>) = apply { this.familyName = familyName }

            /** The first/given name of the user. */
            fun givenName(givenName: String) = givenName(JsonField.of(givenName))

            /**
             * Sets [Builder.givenName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.givenName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun givenName(givenName: JsonField<String>) = apply { this.givenName = givenName }

            /** Phone number should include the country code, format: “+15555555555” */
            fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

            /**
             * Sets [Builder.phoneNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.phoneNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                this.phoneNumber = phoneNumber
            }

            /** Postal code of the applicant. */
            fun postalCode(postalCode: String) = postalCode(JsonField.of(postalCode))

            /**
             * Sets [Builder.postalCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.postalCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun postalCode(postalCode: JsonField<String>) = apply { this.postalCode = postalCode }

            /** Street address of the applicant. */
            fun streetAddress(streetAddress: String) = streetAddress(JsonField.of(streetAddress))

            /**
             * Sets [Builder.streetAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.streetAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun streetAddress(streetAddress: JsonField<String>) = apply {
                this.streetAddress = streetAddress
            }

            /** Social Security Number (SSN) or Tax Identification Number (TIN) of the applicant. */
            fun taxId(taxId: String) = taxId(JsonField.of(taxId))

            /**
             * Sets [Builder.taxId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.taxId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun taxId(taxId: JsonField<String>) = apply { this.taxId = taxId }

            /** The middle name of the user. */
            fun middleName(middleName: String?) = middleName(JsonField.ofNullable(middleName))

            /** Alias for calling [Builder.middleName] with `middleName.orElse(null)`. */
            fun middleName(middleName: Optional<String>) = middleName(middleName.getOrNull())

            /**
             * Sets [Builder.middleName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.middleName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun middleName(middleName: JsonField<String>) = apply { this.middleName = middleName }

            /**
             * State of the applicant. Required if the applicant resides in the US as a 2-letter
             * abbreviation.
             */
            fun state(state: String?) = state(JsonField.ofNullable(state))

            /** Alias for calling [Builder.state] with `state.orElse(null)`. */
            fun state(state: Optional<String>) = state(state.getOrNull())

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun state(state: JsonField<String>) = apply { this.state = state }

            /** The specific apartment number if applicable */
            fun unit(unit: String?) = unit(JsonField.ofNullable(unit))

            /** Alias for calling [Builder.unit] with `unit.orElse(null)`. */
            fun unit(unit: Optional<String>) = unit(unit.getOrNull())

            /**
             * Sets [Builder.unit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.unit] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun unit(unit: JsonField<String>) = apply { this.unit = unit }

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
             * Returns an immutable instance of [Identity].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .city()
             * .countryOfCitizenship()
             * .countryOfTaxResidence()
             * .dateOfBirth()
             * .emailAddress()
             * .familyName()
             * .givenName()
             * .phoneNumber()
             * .postalCode()
             * .streetAddress()
             * .taxId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Identity =
                Identity(
                    checkRequired("city", city),
                    checkRequired("countryOfCitizenship", countryOfCitizenship),
                    checkRequired("countryOfTaxResidence", countryOfTaxResidence),
                    checkRequired("dateOfBirth", dateOfBirth),
                    checkRequired("emailAddress", emailAddress),
                    checkRequired("familyName", familyName),
                    checkRequired("givenName", givenName),
                    checkRequired("phoneNumber", phoneNumber),
                    checkRequired("postalCode", postalCode),
                    checkRequired("streetAddress", streetAddress),
                    checkRequired("taxId", taxId),
                    middleName,
                    state,
                    unit,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Identity = apply {
            if (validated) {
                return@apply
            }

            city()
            countryOfCitizenship()
            countryOfTaxResidence().validate()
            dateOfBirth()
            emailAddress()
            familyName()
            givenName()
            phoneNumber()
            postalCode()
            streetAddress()
            taxId()
            middleName()
            state()
            unit()
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
            (if (city.asKnown().isPresent) 1 else 0) +
                (if (countryOfCitizenship.asKnown().isPresent) 1 else 0) +
                (countryOfTaxResidence.asKnown().getOrNull()?.validity() ?: 0) +
                (if (dateOfBirth.asKnown().isPresent) 1 else 0) +
                (if (emailAddress.asKnown().isPresent) 1 else 0) +
                (if (familyName.asKnown().isPresent) 1 else 0) +
                (if (givenName.asKnown().isPresent) 1 else 0) +
                (if (phoneNumber.asKnown().isPresent) 1 else 0) +
                (if (postalCode.asKnown().isPresent) 1 else 0) +
                (if (streetAddress.asKnown().isPresent) 1 else 0) +
                (if (taxId.asKnown().isPresent) 1 else 0) +
                (if (middleName.asKnown().isPresent) 1 else 0) +
                (if (state.asKnown().isPresent) 1 else 0) +
                (if (unit.asKnown().isPresent) 1 else 0)

        /** Country of residency of the applicant. Must be 'US'. */
        class CountryOfTaxResidence
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmStatic fun of(value: String) = CountryOfTaxResidence(JsonField.of(value))
            }

            /** An enum containing [CountryOfTaxResidence]'s known values. */
            enum class Known {
                US
            }

            /**
             * An enum containing [CountryOfTaxResidence]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [CountryOfTaxResidence] can contain an unknown value in a couple of
             * cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                US,
                /**
                 * An enum member indicating that [CountryOfTaxResidence] was instantiated with an
                 * unknown value.
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
                    else ->
                        throw DinariInvalidDataException("Unknown CountryOfTaxResidence: $value")
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

            fun validate(): CountryOfTaxResidence = apply {
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

                return other is CountryOfTaxResidence && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Identity &&
                city == other.city &&
                countryOfCitizenship == other.countryOfCitizenship &&
                countryOfTaxResidence == other.countryOfTaxResidence &&
                dateOfBirth == other.dateOfBirth &&
                emailAddress == other.emailAddress &&
                familyName == other.familyName &&
                givenName == other.givenName &&
                phoneNumber == other.phoneNumber &&
                postalCode == other.postalCode &&
                streetAddress == other.streetAddress &&
                taxId == other.taxId &&
                middleName == other.middleName &&
                state == other.state &&
                unit == other.unit &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                city,
                countryOfCitizenship,
                countryOfTaxResidence,
                dateOfBirth,
                emailAddress,
                familyName,
                givenName,
                phoneNumber,
                postalCode,
                streetAddress,
                taxId,
                middleName,
                state,
                unit,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Identity{city=$city, countryOfCitizenship=$countryOfCitizenship, countryOfTaxResidence=$countryOfTaxResidence, dateOfBirth=$dateOfBirth, emailAddress=$emailAddress, familyName=$familyName, givenName=$givenName, phoneNumber=$phoneNumber, postalCode=$postalCode, streetAddress=$streetAddress, taxId=$taxId, middleName=$middleName, state=$state, unit=$unit, additionalProperties=$additionalProperties}"
    }

    /** Metadata about the KYC check. */
    class KycMetadata
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val checkCompletedAt: JsonField<OffsetDateTime>,
        private val checkInitiatedAt: JsonField<OffsetDateTime>,
        private val ipAddress: JsonField<String>,
        private val refId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("check_completed_at")
            @ExcludeMissing
            checkCompletedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("check_initiated_at")
            @ExcludeMissing
            checkInitiatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("ip_address")
            @ExcludeMissing
            ipAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ref_id") @ExcludeMissing refId: JsonField<String> = JsonMissing.of(),
        ) : this(checkCompletedAt, checkInitiatedAt, ipAddress, refId, mutableMapOf())

        /**
         * Completion datetime of KYC check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun checkCompletedAt(): OffsetDateTime = checkCompletedAt.getRequired("check_completed_at")

        /**
         * Start datetime of KYC check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun checkInitiatedAt(): OffsetDateTime = checkInitiatedAt.getRequired("check_initiated_at")

        /**
         * IP address of applicant at time of KYC check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun ipAddress(): String = ipAddress.getRequired("ip_address")

        /**
         * Your unique identifier for the KYC check.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun refId(): String = refId.getRequired("ref_id")

        /**
         * Returns the raw JSON value of [checkCompletedAt].
         *
         * Unlike [checkCompletedAt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("check_completed_at")
        @ExcludeMissing
        fun _checkCompletedAt(): JsonField<OffsetDateTime> = checkCompletedAt

        /**
         * Returns the raw JSON value of [checkInitiatedAt].
         *
         * Unlike [checkInitiatedAt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("check_initiated_at")
        @ExcludeMissing
        fun _checkInitiatedAt(): JsonField<OffsetDateTime> = checkInitiatedAt

        /**
         * Returns the raw JSON value of [ipAddress].
         *
         * Unlike [ipAddress], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ip_address") @ExcludeMissing fun _ipAddress(): JsonField<String> = ipAddress

        /**
         * Returns the raw JSON value of [refId].
         *
         * Unlike [refId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ref_id") @ExcludeMissing fun _refId(): JsonField<String> = refId

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
             * Returns a mutable builder for constructing an instance of [KycMetadata].
             *
             * The following fields are required:
             * ```java
             * .checkCompletedAt()
             * .checkInitiatedAt()
             * .ipAddress()
             * .refId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [KycMetadata]. */
        class Builder internal constructor() {

            private var checkCompletedAt: JsonField<OffsetDateTime>? = null
            private var checkInitiatedAt: JsonField<OffsetDateTime>? = null
            private var ipAddress: JsonField<String>? = null
            private var refId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(kycMetadata: KycMetadata) = apply {
                checkCompletedAt = kycMetadata.checkCompletedAt
                checkInitiatedAt = kycMetadata.checkInitiatedAt
                ipAddress = kycMetadata.ipAddress
                refId = kycMetadata.refId
                additionalProperties = kycMetadata.additionalProperties.toMutableMap()
            }

            /** Completion datetime of KYC check. */
            fun checkCompletedAt(checkCompletedAt: OffsetDateTime) =
                checkCompletedAt(JsonField.of(checkCompletedAt))

            /**
             * Sets [Builder.checkCompletedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.checkCompletedAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun checkCompletedAt(checkCompletedAt: JsonField<OffsetDateTime>) = apply {
                this.checkCompletedAt = checkCompletedAt
            }

            /** Start datetime of KYC check. */
            fun checkInitiatedAt(checkInitiatedAt: OffsetDateTime) =
                checkInitiatedAt(JsonField.of(checkInitiatedAt))

            /**
             * Sets [Builder.checkInitiatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.checkInitiatedAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun checkInitiatedAt(checkInitiatedAt: JsonField<OffsetDateTime>) = apply {
                this.checkInitiatedAt = checkInitiatedAt
            }

            /** IP address of applicant at time of KYC check. */
            fun ipAddress(ipAddress: String) = ipAddress(JsonField.of(ipAddress))

            /**
             * Sets [Builder.ipAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ipAddress] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun ipAddress(ipAddress: JsonField<String>) = apply { this.ipAddress = ipAddress }

            /** Your unique identifier for the KYC check. */
            fun refId(refId: String) = refId(JsonField.of(refId))

            /**
             * Sets [Builder.refId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.refId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun refId(refId: JsonField<String>) = apply { this.refId = refId }

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
             * Returns an immutable instance of [KycMetadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .checkCompletedAt()
             * .checkInitiatedAt()
             * .ipAddress()
             * .refId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): KycMetadata =
                KycMetadata(
                    checkRequired("checkCompletedAt", checkCompletedAt),
                    checkRequired("checkInitiatedAt", checkInitiatedAt),
                    checkRequired("ipAddress", ipAddress),
                    checkRequired("refId", refId),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): KycMetadata = apply {
            if (validated) {
                return@apply
            }

            checkCompletedAt()
            checkInitiatedAt()
            ipAddress()
            refId()
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
            (if (checkCompletedAt.asKnown().isPresent) 1 else 0) +
                (if (checkInitiatedAt.asKnown().isPresent) 1 else 0) +
                (if (ipAddress.asKnown().isPresent) 1 else 0) +
                (if (refId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is KycMetadata &&
                checkCompletedAt == other.checkCompletedAt &&
                checkInitiatedAt == other.checkInitiatedAt &&
                ipAddress == other.ipAddress &&
                refId == other.refId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(checkCompletedAt, checkInitiatedAt, ipAddress, refId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "KycMetadata{checkCompletedAt=$checkCompletedAt, checkInitiatedAt=$checkInitiatedAt, ipAddress=$ipAddress, refId=$refId, additionalProperties=$additionalProperties}"
    }

    /**
     * The non-professional trader property is a self-attestation for US customers that can affect
     * the metered realtime data fees. This field must be updated when if there is a change in the
     * user's attestation. This field may also be modified by Dinari compliance team. For more
     * information, please see the US Customers Integration Guide.
     */
    class NonProfessionalTraderAttestation
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val attestationDt: JsonField<OffsetDateTime>,
        private val isNonProfessionalTrader: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("attestation_dt")
            @ExcludeMissing
            attestationDt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("is_non_professional_trader")
            @ExcludeMissing
            isNonProfessionalTrader: JsonField<Boolean> = JsonMissing.of(),
        ) : this(attestationDt, isNonProfessionalTrader, mutableMapOf())

        /**
         * Datetime when the attestation was made.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun attestationDt(): OffsetDateTime = attestationDt.getRequired("attestation_dt")

        /**
         * Whether the individual attests to being a non-professional trader.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isNonProfessionalTrader(): Boolean =
            isNonProfessionalTrader.getRequired("is_non_professional_trader")

        /**
         * Returns the raw JSON value of [attestationDt].
         *
         * Unlike [attestationDt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("attestation_dt")
        @ExcludeMissing
        fun _attestationDt(): JsonField<OffsetDateTime> = attestationDt

        /**
         * Returns the raw JSON value of [isNonProfessionalTrader].
         *
         * Unlike [isNonProfessionalTrader], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("is_non_professional_trader")
        @ExcludeMissing
        fun _isNonProfessionalTrader(): JsonField<Boolean> = isNonProfessionalTrader

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
             * [NonProfessionalTraderAttestation].
             *
             * The following fields are required:
             * ```java
             * .attestationDt()
             * .isNonProfessionalTrader()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [NonProfessionalTraderAttestation]. */
        class Builder internal constructor() {

            private var attestationDt: JsonField<OffsetDateTime>? = null
            private var isNonProfessionalTrader: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(nonProfessionalTraderAttestation: NonProfessionalTraderAttestation) =
                apply {
                    attestationDt = nonProfessionalTraderAttestation.attestationDt
                    isNonProfessionalTrader =
                        nonProfessionalTraderAttestation.isNonProfessionalTrader
                    additionalProperties =
                        nonProfessionalTraderAttestation.additionalProperties.toMutableMap()
                }

            /** Datetime when the attestation was made. */
            fun attestationDt(attestationDt: OffsetDateTime) =
                attestationDt(JsonField.of(attestationDt))

            /**
             * Sets [Builder.attestationDt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attestationDt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun attestationDt(attestationDt: JsonField<OffsetDateTime>) = apply {
                this.attestationDt = attestationDt
            }

            /** Whether the individual attests to being a non-professional trader. */
            fun isNonProfessionalTrader(isNonProfessionalTrader: Boolean) =
                isNonProfessionalTrader(JsonField.of(isNonProfessionalTrader))

            /**
             * Sets [Builder.isNonProfessionalTrader] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isNonProfessionalTrader] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun isNonProfessionalTrader(isNonProfessionalTrader: JsonField<Boolean>) = apply {
                this.isNonProfessionalTrader = isNonProfessionalTrader
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
             * Returns an immutable instance of [NonProfessionalTraderAttestation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .attestationDt()
             * .isNonProfessionalTrader()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): NonProfessionalTraderAttestation =
                NonProfessionalTraderAttestation(
                    checkRequired("attestationDt", attestationDt),
                    checkRequired("isNonProfessionalTrader", isNonProfessionalTrader),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): NonProfessionalTraderAttestation = apply {
            if (validated) {
                return@apply
            }

            attestationDt()
            isNonProfessionalTrader()
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
            (if (attestationDt.asKnown().isPresent) 1 else 0) +
                (if (isNonProfessionalTrader.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is NonProfessionalTraderAttestation &&
                attestationDt == other.attestationDt &&
                isNonProfessionalTrader == other.isNonProfessionalTrader &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(attestationDt, isNonProfessionalTrader, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "NonProfessionalTraderAttestation{attestationDt=$attestationDt, isNonProfessionalTrader=$isNonProfessionalTrader, additionalProperties=$additionalProperties}"
    }

    /**
     * Risk information about the individual <br/><br/> Fields denote if the account owner falls
     * under each category defined by FINRA rules. If any of the answers is true (yes), additional
     * verifications may be required before US account approval.
     */
    class RiskDisclosure
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val immediateFamilyExposed: JsonField<Boolean>,
        private val isAffiliatedExchangeOrFinra: JsonField<Boolean>,
        private val isControlPerson: JsonField<Boolean>,
        private val isPoliticallyExposed: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("immediate_family_exposed")
            @ExcludeMissing
            immediateFamilyExposed: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("is_affiliated_exchange_or_finra")
            @ExcludeMissing
            isAffiliatedExchangeOrFinra: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("is_control_person")
            @ExcludeMissing
            isControlPerson: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("is_politically_exposed")
            @ExcludeMissing
            isPoliticallyExposed: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            immediateFamilyExposed,
            isAffiliatedExchangeOrFinra,
            isControlPerson,
            isPoliticallyExposed,
            mutableMapOf(),
        )

        /**
         * If the individual's immediate family member (sibling, husband/wife, child, parent) is
         * either politically exposed or holds a control position.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun immediateFamilyExposed(): Boolean =
            immediateFamilyExposed.getRequired("immediate_family_exposed")

        /**
         * Whether the individual is affiliated with any exchanges or FINRA.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isAffiliatedExchangeOrFinra(): Boolean =
            isAffiliatedExchangeOrFinra.getRequired("is_affiliated_exchange_or_finra")

        /**
         * Whether the individual holds a controlling position in a publicly traded company, is a
         * member of the board of directors, or has policy making abilities in a publicly traded
         * company.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isControlPerson(): Boolean = isControlPerson.getRequired("is_control_person")

        /**
         * Whether the individual is politically exposed.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isPoliticallyExposed(): Boolean =
            isPoliticallyExposed.getRequired("is_politically_exposed")

        /**
         * Returns the raw JSON value of [immediateFamilyExposed].
         *
         * Unlike [immediateFamilyExposed], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("immediate_family_exposed")
        @ExcludeMissing
        fun _immediateFamilyExposed(): JsonField<Boolean> = immediateFamilyExposed

        /**
         * Returns the raw JSON value of [isAffiliatedExchangeOrFinra].
         *
         * Unlike [isAffiliatedExchangeOrFinra], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("is_affiliated_exchange_or_finra")
        @ExcludeMissing
        fun _isAffiliatedExchangeOrFinra(): JsonField<Boolean> = isAffiliatedExchangeOrFinra

        /**
         * Returns the raw JSON value of [isControlPerson].
         *
         * Unlike [isControlPerson], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("is_control_person")
        @ExcludeMissing
        fun _isControlPerson(): JsonField<Boolean> = isControlPerson

        /**
         * Returns the raw JSON value of [isPoliticallyExposed].
         *
         * Unlike [isPoliticallyExposed], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("is_politically_exposed")
        @ExcludeMissing
        fun _isPoliticallyExposed(): JsonField<Boolean> = isPoliticallyExposed

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
             * Returns a mutable builder for constructing an instance of [RiskDisclosure].
             *
             * The following fields are required:
             * ```java
             * .immediateFamilyExposed()
             * .isAffiliatedExchangeOrFinra()
             * .isControlPerson()
             * .isPoliticallyExposed()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RiskDisclosure]. */
        class Builder internal constructor() {

            private var immediateFamilyExposed: JsonField<Boolean>? = null
            private var isAffiliatedExchangeOrFinra: JsonField<Boolean>? = null
            private var isControlPerson: JsonField<Boolean>? = null
            private var isPoliticallyExposed: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(riskDisclosure: RiskDisclosure) = apply {
                immediateFamilyExposed = riskDisclosure.immediateFamilyExposed
                isAffiliatedExchangeOrFinra = riskDisclosure.isAffiliatedExchangeOrFinra
                isControlPerson = riskDisclosure.isControlPerson
                isPoliticallyExposed = riskDisclosure.isPoliticallyExposed
                additionalProperties = riskDisclosure.additionalProperties.toMutableMap()
            }

            /**
             * If the individual's immediate family member (sibling, husband/wife, child, parent) is
             * either politically exposed or holds a control position.
             */
            fun immediateFamilyExposed(immediateFamilyExposed: Boolean) =
                immediateFamilyExposed(JsonField.of(immediateFamilyExposed))

            /**
             * Sets [Builder.immediateFamilyExposed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.immediateFamilyExposed] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun immediateFamilyExposed(immediateFamilyExposed: JsonField<Boolean>) = apply {
                this.immediateFamilyExposed = immediateFamilyExposed
            }

            /** Whether the individual is affiliated with any exchanges or FINRA. */
            fun isAffiliatedExchangeOrFinra(isAffiliatedExchangeOrFinra: Boolean) =
                isAffiliatedExchangeOrFinra(JsonField.of(isAffiliatedExchangeOrFinra))

            /**
             * Sets [Builder.isAffiliatedExchangeOrFinra] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isAffiliatedExchangeOrFinra] with a well-typed
             * [Boolean] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun isAffiliatedExchangeOrFinra(isAffiliatedExchangeOrFinra: JsonField<Boolean>) =
                apply {
                    this.isAffiliatedExchangeOrFinra = isAffiliatedExchangeOrFinra
                }

            /**
             * Whether the individual holds a controlling position in a publicly traded company, is
             * a member of the board of directors, or has policy making abilities in a publicly
             * traded company.
             */
            fun isControlPerson(isControlPerson: Boolean) =
                isControlPerson(JsonField.of(isControlPerson))

            /**
             * Sets [Builder.isControlPerson] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isControlPerson] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isControlPerson(isControlPerson: JsonField<Boolean>) = apply {
                this.isControlPerson = isControlPerson
            }

            /** Whether the individual is politically exposed. */
            fun isPoliticallyExposed(isPoliticallyExposed: Boolean) =
                isPoliticallyExposed(JsonField.of(isPoliticallyExposed))

            /**
             * Sets [Builder.isPoliticallyExposed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isPoliticallyExposed] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun isPoliticallyExposed(isPoliticallyExposed: JsonField<Boolean>) = apply {
                this.isPoliticallyExposed = isPoliticallyExposed
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
             * Returns an immutable instance of [RiskDisclosure].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .immediateFamilyExposed()
             * .isAffiliatedExchangeOrFinra()
             * .isControlPerson()
             * .isPoliticallyExposed()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): RiskDisclosure =
                RiskDisclosure(
                    checkRequired("immediateFamilyExposed", immediateFamilyExposed),
                    checkRequired("isAffiliatedExchangeOrFinra", isAffiliatedExchangeOrFinra),
                    checkRequired("isControlPerson", isControlPerson),
                    checkRequired("isPoliticallyExposed", isPoliticallyExposed),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): RiskDisclosure = apply {
            if (validated) {
                return@apply
            }

            immediateFamilyExposed()
            isAffiliatedExchangeOrFinra()
            isControlPerson()
            isPoliticallyExposed()
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
            (if (immediateFamilyExposed.asKnown().isPresent) 1 else 0) +
                (if (isAffiliatedExchangeOrFinra.asKnown().isPresent) 1 else 0) +
                (if (isControlPerson.asKnown().isPresent) 1 else 0) +
                (if (isPoliticallyExposed.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RiskDisclosure &&
                immediateFamilyExposed == other.immediateFamilyExposed &&
                isAffiliatedExchangeOrFinra == other.isAffiliatedExchangeOrFinra &&
                isControlPerson == other.isControlPerson &&
                isPoliticallyExposed == other.isPoliticallyExposed &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                immediateFamilyExposed,
                isAffiliatedExchangeOrFinra,
                isControlPerson,
                isPoliticallyExposed,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RiskDisclosure{immediateFamilyExposed=$immediateFamilyExposed, isAffiliatedExchangeOrFinra=$isAffiliatedExchangeOrFinra, isControlPerson=$isControlPerson, isPoliticallyExposed=$isPoliticallyExposed, additionalProperties=$additionalProperties}"
    }

    /**
     * Information for a trusted contact person for the individual. More information: <br/>
     * - <a
     *   href="https://www.investor.gov/introduction-investing/general-resources/news-alerts/alerts-bulletins/investor-bulletins-trusted-contact"
     *   target="_blank" rel="noopener noreferrer">Investor.gov - Trusted Contact</a> <br/>
     * - <a href="https://www.finra.org/investors/insights/trusted-contact" target="_blank"
     *   rel="noopener noreferrer">FINRA - Trusted Contact</a>
     */
    class TrustedContact
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val familyName: JsonField<String>,
        private val givenName: JsonField<String>,
        private val emailAddress: JsonField<String>,
        private val phoneNumber: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("family_name")
            @ExcludeMissing
            familyName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("given_name")
            @ExcludeMissing
            givenName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("email_address")
            @ExcludeMissing
            emailAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phone_number")
            @ExcludeMissing
            phoneNumber: JsonField<String> = JsonMissing.of(),
        ) : this(familyName, givenName, emailAddress, phoneNumber, mutableMapOf())

        /**
         * The family name of the trusted contact
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun familyName(): String = familyName.getRequired("family_name")

        /**
         * The given name of the trusted contact
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun givenName(): String = givenName.getRequired("given_name")

        /**
         * The email address of the trusted contact. At least one of email_address or phone_number
         * is required.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun emailAddress(): Optional<String> = emailAddress.getOptional("email_address")

        /**
         * The phone number of the trusted contact. At least one of email_address or phone_number is
         * required.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

        /**
         * Returns the raw JSON value of [familyName].
         *
         * Unlike [familyName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("family_name")
        @ExcludeMissing
        fun _familyName(): JsonField<String> = familyName

        /**
         * Returns the raw JSON value of [givenName].
         *
         * Unlike [givenName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("given_name") @ExcludeMissing fun _givenName(): JsonField<String> = givenName

        /**
         * Returns the raw JSON value of [emailAddress].
         *
         * Unlike [emailAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("email_address")
        @ExcludeMissing
        fun _emailAddress(): JsonField<String> = emailAddress

        /**
         * Returns the raw JSON value of [phoneNumber].
         *
         * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("phone_number")
        @ExcludeMissing
        fun _phoneNumber(): JsonField<String> = phoneNumber

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
             * Returns a mutable builder for constructing an instance of [TrustedContact].
             *
             * The following fields are required:
             * ```java
             * .familyName()
             * .givenName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TrustedContact]. */
        class Builder internal constructor() {

            private var familyName: JsonField<String>? = null
            private var givenName: JsonField<String>? = null
            private var emailAddress: JsonField<String> = JsonMissing.of()
            private var phoneNumber: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(trustedContact: TrustedContact) = apply {
                familyName = trustedContact.familyName
                givenName = trustedContact.givenName
                emailAddress = trustedContact.emailAddress
                phoneNumber = trustedContact.phoneNumber
                additionalProperties = trustedContact.additionalProperties.toMutableMap()
            }

            /** The family name of the trusted contact */
            fun familyName(familyName: String) = familyName(JsonField.of(familyName))

            /**
             * Sets [Builder.familyName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.familyName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun familyName(familyName: JsonField<String>) = apply { this.familyName = familyName }

            /** The given name of the trusted contact */
            fun givenName(givenName: String) = givenName(JsonField.of(givenName))

            /**
             * Sets [Builder.givenName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.givenName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun givenName(givenName: JsonField<String>) = apply { this.givenName = givenName }

            /**
             * The email address of the trusted contact. At least one of email_address or
             * phone_number is required.
             */
            fun emailAddress(emailAddress: String?) =
                emailAddress(JsonField.ofNullable(emailAddress))

            /** Alias for calling [Builder.emailAddress] with `emailAddress.orElse(null)`. */
            fun emailAddress(emailAddress: Optional<String>) =
                emailAddress(emailAddress.getOrNull())

            /**
             * Sets [Builder.emailAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.emailAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun emailAddress(emailAddress: JsonField<String>) = apply {
                this.emailAddress = emailAddress
            }

            /**
             * The phone number of the trusted contact. At least one of email_address or
             * phone_number is required.
             */
            fun phoneNumber(phoneNumber: String?) = phoneNumber(JsonField.ofNullable(phoneNumber))

            /** Alias for calling [Builder.phoneNumber] with `phoneNumber.orElse(null)`. */
            fun phoneNumber(phoneNumber: Optional<String>) = phoneNumber(phoneNumber.getOrNull())

            /**
             * Sets [Builder.phoneNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.phoneNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                this.phoneNumber = phoneNumber
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
             * Returns an immutable instance of [TrustedContact].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .familyName()
             * .givenName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TrustedContact =
                TrustedContact(
                    checkRequired("familyName", familyName),
                    checkRequired("givenName", givenName),
                    emailAddress,
                    phoneNumber,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): TrustedContact = apply {
            if (validated) {
                return@apply
            }

            familyName()
            givenName()
            emailAddress()
            phoneNumber()
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
            (if (familyName.asKnown().isPresent) 1 else 0) +
                (if (givenName.asKnown().isPresent) 1 else 0) +
                (if (emailAddress.asKnown().isPresent) 1 else 0) +
                (if (phoneNumber.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TrustedContact &&
                familyName == other.familyName &&
                givenName == other.givenName &&
                emailAddress == other.emailAddress &&
                phoneNumber == other.phoneNumber &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(familyName, givenName, emailAddress, phoneNumber, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TrustedContact{familyName=$familyName, givenName=$givenName, emailAddress=$emailAddress, phoneNumber=$phoneNumber, additionalProperties=$additionalProperties}"
    }

    /**
     * US immigration information for this individual. Required if the individual is not a US
     * citizen.
     */
    class UsImmigrationInfo
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val countryOfBirth: JsonField<String>,
        private val isPermanentResident: JsonField<Boolean>,
        private val departureFromUsDate: JsonField<LocalDate>,
        private val visaExpirationDate: JsonField<LocalDate>,
        private val visaType: JsonField<VisaType>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("country_of_birth")
            @ExcludeMissing
            countryOfBirth: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_permanent_resident")
            @ExcludeMissing
            isPermanentResident: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("departure_from_us_date")
            @ExcludeMissing
            departureFromUsDate: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("visa_expiration_date")
            @ExcludeMissing
            visaExpirationDate: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("visa_type")
            @ExcludeMissing
            visaType: JsonField<VisaType> = JsonMissing.of(),
        ) : this(
            countryOfBirth,
            isPermanentResident,
            departureFromUsDate,
            visaExpirationDate,
            visaType,
            mutableMapOf(),
        )

        /**
         * Country where the individual was born.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun countryOfBirth(): String = countryOfBirth.getRequired("country_of_birth")

        /**
         * Whether the individual is a US permanent resident (green card holder).
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun isPermanentResident(): Boolean =
            isPermanentResident.getRequired("is_permanent_resident")

        /**
         * Date the individual is scheduled to leave the US. Required for B1 and B2 visas.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun departureFromUsDate(): Optional<LocalDate> =
            departureFromUsDate.getOptional("departure_from_us_date")

        /**
         * Expiration date of the visa. Required if visa_type is provided.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun visaExpirationDate(): Optional<LocalDate> =
            visaExpirationDate.getOptional("visa_expiration_date")

        /**
         * Type of visa the individual holds. Required if not a permanent resident.
         *
         * @throws DinariInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun visaType(): Optional<VisaType> = visaType.getOptional("visa_type")

        /**
         * Returns the raw JSON value of [countryOfBirth].
         *
         * Unlike [countryOfBirth], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("country_of_birth")
        @ExcludeMissing
        fun _countryOfBirth(): JsonField<String> = countryOfBirth

        /**
         * Returns the raw JSON value of [isPermanentResident].
         *
         * Unlike [isPermanentResident], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("is_permanent_resident")
        @ExcludeMissing
        fun _isPermanentResident(): JsonField<Boolean> = isPermanentResident

        /**
         * Returns the raw JSON value of [departureFromUsDate].
         *
         * Unlike [departureFromUsDate], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("departure_from_us_date")
        @ExcludeMissing
        fun _departureFromUsDate(): JsonField<LocalDate> = departureFromUsDate

        /**
         * Returns the raw JSON value of [visaExpirationDate].
         *
         * Unlike [visaExpirationDate], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("visa_expiration_date")
        @ExcludeMissing
        fun _visaExpirationDate(): JsonField<LocalDate> = visaExpirationDate

        /**
         * Returns the raw JSON value of [visaType].
         *
         * Unlike [visaType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("visa_type") @ExcludeMissing fun _visaType(): JsonField<VisaType> = visaType

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
             * Returns a mutable builder for constructing an instance of [UsImmigrationInfo].
             *
             * The following fields are required:
             * ```java
             * .countryOfBirth()
             * .isPermanentResident()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UsImmigrationInfo]. */
        class Builder internal constructor() {

            private var countryOfBirth: JsonField<String>? = null
            private var isPermanentResident: JsonField<Boolean>? = null
            private var departureFromUsDate: JsonField<LocalDate> = JsonMissing.of()
            private var visaExpirationDate: JsonField<LocalDate> = JsonMissing.of()
            private var visaType: JsonField<VisaType> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usImmigrationInfo: UsImmigrationInfo) = apply {
                countryOfBirth = usImmigrationInfo.countryOfBirth
                isPermanentResident = usImmigrationInfo.isPermanentResident
                departureFromUsDate = usImmigrationInfo.departureFromUsDate
                visaExpirationDate = usImmigrationInfo.visaExpirationDate
                visaType = usImmigrationInfo.visaType
                additionalProperties = usImmigrationInfo.additionalProperties.toMutableMap()
            }

            /** Country where the individual was born. */
            fun countryOfBirth(countryOfBirth: String) =
                countryOfBirth(JsonField.of(countryOfBirth))

            /**
             * Sets [Builder.countryOfBirth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.countryOfBirth] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun countryOfBirth(countryOfBirth: JsonField<String>) = apply {
                this.countryOfBirth = countryOfBirth
            }

            /** Whether the individual is a US permanent resident (green card holder). */
            fun isPermanentResident(isPermanentResident: Boolean) =
                isPermanentResident(JsonField.of(isPermanentResident))

            /**
             * Sets [Builder.isPermanentResident] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isPermanentResident] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun isPermanentResident(isPermanentResident: JsonField<Boolean>) = apply {
                this.isPermanentResident = isPermanentResident
            }

            /** Date the individual is scheduled to leave the US. Required for B1 and B2 visas. */
            fun departureFromUsDate(departureFromUsDate: LocalDate?) =
                departureFromUsDate(JsonField.ofNullable(departureFromUsDate))

            /**
             * Alias for calling [Builder.departureFromUsDate] with
             * `departureFromUsDate.orElse(null)`.
             */
            fun departureFromUsDate(departureFromUsDate: Optional<LocalDate>) =
                departureFromUsDate(departureFromUsDate.getOrNull())

            /**
             * Sets [Builder.departureFromUsDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.departureFromUsDate] with a well-typed [LocalDate]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun departureFromUsDate(departureFromUsDate: JsonField<LocalDate>) = apply {
                this.departureFromUsDate = departureFromUsDate
            }

            /** Expiration date of the visa. Required if visa_type is provided. */
            fun visaExpirationDate(visaExpirationDate: LocalDate?) =
                visaExpirationDate(JsonField.ofNullable(visaExpirationDate))

            /**
             * Alias for calling [Builder.visaExpirationDate] with
             * `visaExpirationDate.orElse(null)`.
             */
            fun visaExpirationDate(visaExpirationDate: Optional<LocalDate>) =
                visaExpirationDate(visaExpirationDate.getOrNull())

            /**
             * Sets [Builder.visaExpirationDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.visaExpirationDate] with a well-typed [LocalDate]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun visaExpirationDate(visaExpirationDate: JsonField<LocalDate>) = apply {
                this.visaExpirationDate = visaExpirationDate
            }

            /** Type of visa the individual holds. Required if not a permanent resident. */
            fun visaType(visaType: VisaType) = visaType(JsonField.of(visaType))

            /**
             * Sets [Builder.visaType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.visaType] with a well-typed [VisaType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun visaType(visaType: JsonField<VisaType>) = apply { this.visaType = visaType }

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
             * Returns an immutable instance of [UsImmigrationInfo].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .countryOfBirth()
             * .isPermanentResident()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UsImmigrationInfo =
                UsImmigrationInfo(
                    checkRequired("countryOfBirth", countryOfBirth),
                    checkRequired("isPermanentResident", isPermanentResident),
                    departureFromUsDate,
                    visaExpirationDate,
                    visaType,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): UsImmigrationInfo = apply {
            if (validated) {
                return@apply
            }

            countryOfBirth()
            isPermanentResident()
            departureFromUsDate()
            visaExpirationDate()
            visaType().ifPresent { it.validate() }
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
            (if (countryOfBirth.asKnown().isPresent) 1 else 0) +
                (if (isPermanentResident.asKnown().isPresent) 1 else 0) +
                (if (departureFromUsDate.asKnown().isPresent) 1 else 0) +
                (if (visaExpirationDate.asKnown().isPresent) 1 else 0) +
                (visaType.asKnown().getOrNull()?.validity() ?: 0)

        /** Type of visa the individual holds. Required if not a permanent resident. */
        class VisaType @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val B1 = of("B1")

                @JvmField val B2 = of("B2")

                @JvmField val DACA = of("DACA")

                @JvmField val E1 = of("E1")

                @JvmField val E2 = of("E2")

                @JvmField val E3 = of("E3")

                @JvmField val F1 = of("F1")

                @JvmField val G4 = of("G4")

                @JvmField val H1_B = of("H1B")

                @JvmField val J1 = of("J1")

                @JvmField val L1 = of("L1")

                @JvmField val OTHER = of("Other")

                @JvmField val O1 = of("O1")

                @JvmField val TN1 = of("TN1")

                @JvmStatic fun of(value: String) = VisaType(JsonField.of(value))
            }

            /** An enum containing [VisaType]'s known values. */
            enum class Known {
                B1,
                B2,
                DACA,
                E1,
                E2,
                E3,
                F1,
                G4,
                H1_B,
                J1,
                L1,
                OTHER,
                O1,
                TN1,
            }

            /**
             * An enum containing [VisaType]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [VisaType] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                B1,
                B2,
                DACA,
                E1,
                E2,
                E3,
                F1,
                G4,
                H1_B,
                J1,
                L1,
                OTHER,
                O1,
                TN1,
                /**
                 * An enum member indicating that [VisaType] was instantiated with an unknown value.
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
                    B1 -> Value.B1
                    B2 -> Value.B2
                    DACA -> Value.DACA
                    E1 -> Value.E1
                    E2 -> Value.E2
                    E3 -> Value.E3
                    F1 -> Value.F1
                    G4 -> Value.G4
                    H1_B -> Value.H1_B
                    J1 -> Value.J1
                    L1 -> Value.L1
                    OTHER -> Value.OTHER
                    O1 -> Value.O1
                    TN1 -> Value.TN1
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
                    B1 -> Known.B1
                    B2 -> Known.B2
                    DACA -> Known.DACA
                    E1 -> Known.E1
                    E2 -> Known.E2
                    E3 -> Known.E3
                    F1 -> Known.F1
                    G4 -> Known.G4
                    H1_B -> Known.H1_B
                    J1 -> Known.J1
                    L1 -> Known.L1
                    OTHER -> Known.OTHER
                    O1 -> Known.O1
                    TN1 -> Known.TN1
                    else -> throw DinariInvalidDataException("Unknown VisaType: $value")
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

            fun validate(): VisaType = apply {
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

                return other is VisaType && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UsImmigrationInfo &&
                countryOfBirth == other.countryOfBirth &&
                isPermanentResident == other.isPermanentResident &&
                departureFromUsDate == other.departureFromUsDate &&
                visaExpirationDate == other.visaExpirationDate &&
                visaType == other.visaType &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                countryOfBirth,
                isPermanentResident,
                departureFromUsDate,
                visaExpirationDate,
                visaType,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UsImmigrationInfo{countryOfBirth=$countryOfBirth, isPermanentResident=$isPermanentResident, departureFromUsDate=$departureFromUsDate, visaExpirationDate=$visaExpirationDate, visaType=$visaType, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsKycCheckData &&
            alpacaCustomerAgreement == other.alpacaCustomerAgreement &&
            amlCheck == other.amlCheck &&
            dataCitation == other.dataCitation &&
            employment == other.employment &&
            financialProfile == other.financialProfile &&
            identity == other.identity &&
            kycMetadata == other.kycMetadata &&
            nonProfessionalTraderAttestation == other.nonProfessionalTraderAttestation &&
            riskDisclosure == other.riskDisclosure &&
            trustedContact == other.trustedContact &&
            usImmigrationInfo == other.usImmigrationInfo &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            alpacaCustomerAgreement,
            amlCheck,
            dataCitation,
            employment,
            financialProfile,
            identity,
            kycMetadata,
            nonProfessionalTraderAttestation,
            riskDisclosure,
            trustedContact,
            usImmigrationInfo,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UsKycCheckData{alpacaCustomerAgreement=$alpacaCustomerAgreement, amlCheck=$amlCheck, dataCitation=$dataCitation, employment=$employment, financialProfile=$financialProfile, identity=$identity, kycMetadata=$kycMetadata, nonProfessionalTraderAttestation=$nonProfessionalTraderAttestation, riskDisclosure=$riskDisclosure, trustedContact=$trustedContact, usImmigrationInfo=$usImmigrationInfo, additionalProperties=$additionalProperties}"
}
