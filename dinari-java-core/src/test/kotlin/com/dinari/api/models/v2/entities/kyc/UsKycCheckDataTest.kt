// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsKycCheckDataTest {

    @Test
    fun create() {
        val usKycCheckData =
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
                        .employmentStatus(UsKycCheckData.Employment.EmploymentStatus.UNEMPLOYED)
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
                        .countryOfTaxResidence(UsKycCheckData.Identity.CountryOfTaxResidence.US)
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

        assertThat(usKycCheckData.alpacaCustomerAgreement())
            .isEqualTo(
                UsKycCheckData.AlpacaCustomerAgreement.builder()
                    .ipAddress("192.0.2.1")
                    .signedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(usKycCheckData.amlCheck())
            .isEqualTo(
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
        assertThat(usKycCheckData.dataCitation())
            .isEqualTo(
                UsKycCheckData.DataCitation.builder()
                    .addAddressSource("utility bill")
                    .addDateOfBirthSource("birth certificate")
                    .addDateOfBirthSource("government database lookup")
                    .addTaxIdSource("tax return")
                    .addTaxIdSource("government database lookup")
                    .build()
            )
        assertThat(usKycCheckData.employment())
            .isEqualTo(
                UsKycCheckData.Employment.builder()
                    .employmentStatus(UsKycCheckData.Employment.EmploymentStatus.UNEMPLOYED)
                    .employerAddress("x")
                    .employerName("x")
                    .employmentPosition("x")
                    .build()
            )
        assertThat(usKycCheckData.financialProfile())
            .isEqualTo(
                UsKycCheckData.FinancialProfile.builder()
                    .addFundingSource(
                        UsKycCheckData.FinancialProfile.FundingSource.EMPLOYMENT_INCOME
                    )
                    .liquidNetWorthMax(0L)
                    .liquidNetWorthMin(0L)
                    .build()
            )
        assertThat(usKycCheckData.identity())
            .isEqualTo(
                UsKycCheckData.Identity.builder()
                    .city("xx")
                    .countryOfCitizenship("xx")
                    .countryOfTaxResidence(UsKycCheckData.Identity.CountryOfTaxResidence.US)
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
        assertThat(usKycCheckData.kycMetadata())
            .isEqualTo(
                UsKycCheckData.KycMetadata.builder()
                    .checkCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .checkInitiatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .ipAddress("192.0.2.1")
                    .refId("x")
                    .build()
            )
        assertThat(usKycCheckData.riskDisclosure())
            .isEqualTo(
                UsKycCheckData.RiskDisclosure.builder()
                    .immediateFamilyExposed(true)
                    .isAffiliatedExchangeOrFinra(true)
                    .isControlPerson(true)
                    .isPoliticallyExposed(true)
                    .build()
            )
        assertThat(usKycCheckData.trustedContact())
            .isEqualTo(
                UsKycCheckData.TrustedContact.builder()
                    .familyName("family_name")
                    .givenName("given_name")
                    .emailAddress("email_address")
                    .phoneNumber("+321669910225610")
                    .build()
            )
        assertThat(usKycCheckData.usImmigrationInfo())
            .contains(
                UsKycCheckData.UsImmigrationInfo.builder()
                    .countryOfBirth("xx")
                    .isPermanentResident(true)
                    .departureFromUsDate(LocalDate.parse("2019-12-27"))
                    .visaExpirationDate(LocalDate.parse("2019-12-27"))
                    .visaType(UsKycCheckData.UsImmigrationInfo.VisaType.B1)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usKycCheckData =
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
                        .employmentStatus(UsKycCheckData.Employment.EmploymentStatus.UNEMPLOYED)
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
                        .countryOfTaxResidence(UsKycCheckData.Identity.CountryOfTaxResidence.US)
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

        val roundtrippedUsKycCheckData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usKycCheckData),
                jacksonTypeRef<UsKycCheckData>(),
            )

        assertThat(roundtrippedUsKycCheckData).isEqualTo(usKycCheckData)
    }
}
