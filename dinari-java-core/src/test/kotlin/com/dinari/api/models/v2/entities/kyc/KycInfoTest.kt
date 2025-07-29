// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KycInfoTest {

    @Test
    fun create() {
        val kycInfo =
            KycInfo.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(KycInfo.Status.PASS)
                .checkedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    KycData.builder()
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
                .build()

        assertThat(kycInfo.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(kycInfo.status()).isEqualTo(KycInfo.Status.PASS)
        assertThat(kycInfo.checkedDt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(kycInfo.data())
            .contains(
                KycData.builder()
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val kycInfo =
            KycInfo.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(KycInfo.Status.PASS)
                .checkedDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .data(
                    KycData.builder()
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
                .build()

        val roundtrippedKycInfo =
            jsonMapper.readValue(jsonMapper.writeValueAsString(kycInfo), jacksonTypeRef<KycInfo>())

        assertThat(roundtrippedKycInfo).isEqualTo(kycInfo)
    }
}
