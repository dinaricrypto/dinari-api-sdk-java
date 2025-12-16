// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.dinari.api.errors.DinariInvalidDataException
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class KycInfoTest {

    @Test
    fun ofBaseline() {
        val baseline =
            KycInfo.Baseline.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(KycStatus.PASS)
                .checkedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    BaselineKycCheckData.builder()
                        .addressCountryCode("SG")
                        .countryCode("SG")
                        .lastName("Doe")
                        .addressCity("San Francisco")
                        .addressPostalCode("94111")
                        .addressStreet1("123 Main St.")
                        .addressStreet2("Apt. 123")
                        .addressSubdivision("California")
                        .birthDate(LocalDate.parse("2019-12-27"))
                        .email("johndoe@website.com")
                        .firstName("John")
                        .middleName("x")
                        .taxIdNumber("12-3456789")
                        .build()
                )
                .jurisdiction(KycInfo.Baseline.Jurisdiction.BASELINE)
                .build()

        val kycInfo = KycInfo.ofBaseline(baseline)

        assertThat(kycInfo.baseline()).contains(baseline)
        assertThat(kycInfo.us()).isEmpty
    }

    @Test
    fun ofBaselineRoundtrip() {
        val jsonMapper = jsonMapper()
        val kycInfo =
            KycInfo.ofBaseline(
                KycInfo.Baseline.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .status(KycStatus.PASS)
                    .checkedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        BaselineKycCheckData.builder()
                            .addressCountryCode("SG")
                            .countryCode("SG")
                            .lastName("Doe")
                            .addressCity("San Francisco")
                            .addressPostalCode("94111")
                            .addressStreet1("123 Main St.")
                            .addressStreet2("Apt. 123")
                            .addressSubdivision("California")
                            .birthDate(LocalDate.parse("2019-12-27"))
                            .email("johndoe@website.com")
                            .firstName("John")
                            .middleName("x")
                            .taxIdNumber("12-3456789")
                            .build()
                    )
                    .jurisdiction(KycInfo.Baseline.Jurisdiction.BASELINE)
                    .build()
            )

        val roundtrippedKycInfo =
            jsonMapper.readValue(jsonMapper.writeValueAsString(kycInfo), jacksonTypeRef<KycInfo>())

        assertThat(roundtrippedKycInfo).isEqualTo(kycInfo)
    }

    @Test
    fun ofUs() {
        val us =
            KycInfo.Us.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(KycStatus.PASS)
                .checkedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    UsKycCheckData.builder()
                        .alpacaCustomerAgreement(
                            UsKycCheckData.AlpacaCustomerAgreement.builder()
                                .ipAddress("192.0.2.1")
                                .signedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .amlCheck(
                            UsKycCheckData.AmlCheck.builder()
                                .checkCreatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .isAdverseMediaMatch(true)
                                .isMonitoredListsMatch(true)
                                .isPoliticallyExposedPersonMatch(true)
                                .isSanctionsMatch(true)
                                .addRecord(
                                    "Name: John Doe, Alias: Jonathan Doe, Address: 123 Main St, Springfield, DOB: 01/01/1980, Type of Hit: PEP, Position: Mayor of Springfield, List: World-Check, URL: http://example.com/article"
                                )
                                .addRecord(
                                    "Name: John Doe, Address: 456 Elm St, Springfield, Type of Hit: Adverse Media, Summary: Involved in financial scandal, URL: http://example.com/article"
                                )
                                .refId("x")
                                .build()
                        )
                        .dataCitation(
                            UsKycCheckData.DataCitation.builder()
                                .addAddressSource("utility bill")
                                .addDateOfBirthSource("birth certificate")
                                .addDateOfBirthSource("government database lookup")
                                .addTaxIdSource("tax return")
                                .addTaxIdSource("government database lookup")
                                .build()
                        )
                        .employment(
                            UsKycCheckData.Employment.builder()
                                .employmentStatus(
                                    UsKycCheckData.Employment.EmploymentStatus.UNEMPLOYED
                                )
                                .employerAddress("x")
                                .employerName("x")
                                .employmentPosition("x")
                                .build()
                        )
                        .financialProfile(
                            UsKycCheckData.FinancialProfile.builder()
                                .addFundingSource(
                                    UsKycCheckData.FinancialProfile.FundingSource.EMPLOYMENT_INCOME
                                )
                                .liquidNetWorthMax(0L)
                                .liquidNetWorthMin(0L)
                                .build()
                        )
                        .identity(
                            UsKycCheckData.Identity.builder()
                                .city("xx")
                                .countryOfCitizenship("xx")
                                .countryOfTaxResidence(
                                    UsKycCheckData.Identity.CountryOfTaxResidence.US
                                )
                                .dateOfBirth(LocalDate.parse("2019-12-27"))
                                .emailAddress("email_address")
                                .familyName("xx")
                                .givenName("x")
                                .phoneNumber("+321669910225610")
                                .postalCode("x")
                                .streetAddress("xx")
                                .taxId("732-66-9102")
                                .middleName("x")
                                .state("x")
                                .unit("x")
                                .build()
                        )
                        .kycMetadata(
                            UsKycCheckData.KycMetadata.builder()
                                .checkCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .checkInitiatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .ipAddress("192.0.2.1")
                                .refId("x")
                                .build()
                        )
                        .nonProfessionalTraderAttestation(
                            UsKycCheckData.NonProfessionalTraderAttestation.builder()
                                .attestationDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .isNonProfessionalTrader(true)
                                .build()
                        )
                        .riskDisclosure(
                            UsKycCheckData.RiskDisclosure.builder()
                                .immediateFamilyExposed(true)
                                .isAffiliatedExchangeOrFinra(true)
                                .isControlPerson(true)
                                .isPoliticallyExposed(true)
                                .build()
                        )
                        .trustedContact(
                            UsKycCheckData.TrustedContact.builder()
                                .familyName("family_name")
                                .givenName("given_name")
                                .emailAddress("email_address")
                                .phoneNumber("+321669910225610")
                                .build()
                        )
                        .usImmigrationInfo(
                            UsKycCheckData.UsImmigrationInfo.builder()
                                .countryOfBirth("xx")
                                .isPermanentResident(true)
                                .departureFromUsDate(LocalDate.parse("2019-12-27"))
                                .visaExpirationDate(LocalDate.parse("2019-12-27"))
                                .visaType(UsKycCheckData.UsImmigrationInfo.VisaType.B1)
                                .build()
                        )
                        .build()
                )
                .jurisdiction(KycInfo.Us.Jurisdiction.US)
                .build()

        val kycInfo = KycInfo.ofUs(us)

        assertThat(kycInfo.baseline()).isEmpty
        assertThat(kycInfo.us()).contains(us)
    }

    @Test
    fun ofUsRoundtrip() {
        val jsonMapper = jsonMapper()
        val kycInfo =
            KycInfo.ofUs(
                KycInfo.Us.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .status(KycStatus.PASS)
                    .checkedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .data(
                        UsKycCheckData.builder()
                            .alpacaCustomerAgreement(
                                UsKycCheckData.AlpacaCustomerAgreement.builder()
                                    .ipAddress("192.0.2.1")
                                    .signedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .build()
                            )
                            .amlCheck(
                                UsKycCheckData.AmlCheck.builder()
                                    .checkCreatedAt(
                                        OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                    )
                                    .isAdverseMediaMatch(true)
                                    .isMonitoredListsMatch(true)
                                    .isPoliticallyExposedPersonMatch(true)
                                    .isSanctionsMatch(true)
                                    .addRecord(
                                        "Name: John Doe, Alias: Jonathan Doe, Address: 123 Main St, Springfield, DOB: 01/01/1980, Type of Hit: PEP, Position: Mayor of Springfield, List: World-Check, URL: http://example.com/article"
                                    )
                                    .addRecord(
                                        "Name: John Doe, Address: 456 Elm St, Springfield, Type of Hit: Adverse Media, Summary: Involved in financial scandal, URL: http://example.com/article"
                                    )
                                    .refId("x")
                                    .build()
                            )
                            .dataCitation(
                                UsKycCheckData.DataCitation.builder()
                                    .addAddressSource("utility bill")
                                    .addDateOfBirthSource("birth certificate")
                                    .addDateOfBirthSource("government database lookup")
                                    .addTaxIdSource("tax return")
                                    .addTaxIdSource("government database lookup")
                                    .build()
                            )
                            .employment(
                                UsKycCheckData.Employment.builder()
                                    .employmentStatus(
                                        UsKycCheckData.Employment.EmploymentStatus.UNEMPLOYED
                                    )
                                    .employerAddress("x")
                                    .employerName("x")
                                    .employmentPosition("x")
                                    .build()
                            )
                            .financialProfile(
                                UsKycCheckData.FinancialProfile.builder()
                                    .addFundingSource(
                                        UsKycCheckData.FinancialProfile.FundingSource
                                            .EMPLOYMENT_INCOME
                                    )
                                    .liquidNetWorthMax(0L)
                                    .liquidNetWorthMin(0L)
                                    .build()
                            )
                            .identity(
                                UsKycCheckData.Identity.builder()
                                    .city("xx")
                                    .countryOfCitizenship("xx")
                                    .countryOfTaxResidence(
                                        UsKycCheckData.Identity.CountryOfTaxResidence.US
                                    )
                                    .dateOfBirth(LocalDate.parse("2019-12-27"))
                                    .emailAddress("email_address")
                                    .familyName("xx")
                                    .givenName("x")
                                    .phoneNumber("+321669910225610")
                                    .postalCode("x")
                                    .streetAddress("xx")
                                    .taxId("732-66-9102")
                                    .middleName("x")
                                    .state("x")
                                    .unit("x")
                                    .build()
                            )
                            .kycMetadata(
                                UsKycCheckData.KycMetadata.builder()
                                    .checkCompletedAt(
                                        OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                    )
                                    .checkInitiatedAt(
                                        OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                    )
                                    .ipAddress("192.0.2.1")
                                    .refId("x")
                                    .build()
                            )
                            .nonProfessionalTraderAttestation(
                                UsKycCheckData.NonProfessionalTraderAttestation.builder()
                                    .attestationDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .isNonProfessionalTrader(true)
                                    .build()
                            )
                            .riskDisclosure(
                                UsKycCheckData.RiskDisclosure.builder()
                                    .immediateFamilyExposed(true)
                                    .isAffiliatedExchangeOrFinra(true)
                                    .isControlPerson(true)
                                    .isPoliticallyExposed(true)
                                    .build()
                            )
                            .trustedContact(
                                UsKycCheckData.TrustedContact.builder()
                                    .familyName("family_name")
                                    .givenName("given_name")
                                    .emailAddress("email_address")
                                    .phoneNumber("+321669910225610")
                                    .build()
                            )
                            .usImmigrationInfo(
                                UsKycCheckData.UsImmigrationInfo.builder()
                                    .countryOfBirth("xx")
                                    .isPermanentResident(true)
                                    .departureFromUsDate(LocalDate.parse("2019-12-27"))
                                    .visaExpirationDate(LocalDate.parse("2019-12-27"))
                                    .visaType(UsKycCheckData.UsImmigrationInfo.VisaType.B1)
                                    .build()
                            )
                            .build()
                    )
                    .jurisdiction(KycInfo.Us.Jurisdiction.US)
                    .build()
            )

        val roundtrippedKycInfo =
            jsonMapper.readValue(jsonMapper.writeValueAsString(kycInfo), jacksonTypeRef<KycInfo>())

        assertThat(roundtrippedKycInfo).isEqualTo(kycInfo)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val kycInfo = jsonMapper().convertValue(testCase.value, jacksonTypeRef<KycInfo>())

        val e = assertThrows<DinariInvalidDataException> { kycInfo.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
