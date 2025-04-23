// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.entities.kyc

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KycInfoTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val kycInfo =
            KycInfo.builder()
                .id("id")
                .status(KycInfo.Status.PASS)
                .checkedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    KycData.builder()
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
                        .middleName("middle_name")
                        .taxIdNumber("123456789")
                        .build()
                )
                .providerName("provider_name")
                .build()

        assertThat(kycInfo.id()).isEqualTo("id")
        assertThat(kycInfo.status()).isEqualTo(KycInfo.Status.PASS)
        assertThat(kycInfo.checkedDt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(kycInfo.data())
            .contains(
                KycData.builder()
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
                    .middleName("middle_name")
                    .taxIdNumber("123456789")
                    .build()
            )
        assertThat(kycInfo.providerName()).contains("provider_name")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val kycInfo =
            KycInfo.builder()
                .id("id")
                .status(KycInfo.Status.PASS)
                .checkedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    KycData.builder()
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
                        .middleName("middle_name")
                        .taxIdNumber("123456789")
                        .build()
                )
                .providerName("provider_name")
                .build()

        val roundtrippedKycInfo =
            jsonMapper.readValue(jsonMapper.writeValueAsString(kycInfo), jacksonTypeRef<KycInfo>())

        assertThat(roundtrippedKycInfo).isEqualTo(kycInfo)
    }
}
