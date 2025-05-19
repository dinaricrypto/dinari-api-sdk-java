// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.entities.kyc

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KycDataTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val kycData =
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
                .middleName("x")
                .taxIdNumber("12-3456789")
                .build()

        assertThat(kycData.countryCode()).isEqualTo("SG")
        assertThat(kycData.lastName()).isEqualTo("Doe")
        assertThat(kycData.addressCity()).contains("San Francisco")
        assertThat(kycData.addressPostalCode()).contains("94111")
        assertThat(kycData.addressStreet1()).contains("123 Main St.")
        assertThat(kycData.addressStreet2()).contains("Apt. 123")
        assertThat(kycData.addressSubdivision()).contains("California")
        assertThat(kycData.birthDate()).contains(LocalDate.parse("2019-12-27"))
        assertThat(kycData.email()).contains("johndoe@website.com")
        assertThat(kycData.firstName()).contains("John")
        assertThat(kycData.middleName()).contains("x")
        assertThat(kycData.taxIdNumber()).contains("12-3456789")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val kycData =
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
                .middleName("x")
                .taxIdNumber("12-3456789")
                .build()

        val roundtrippedKycData =
            jsonMapper.readValue(jsonMapper.writeValueAsString(kycData), jacksonTypeRef<KycData>())

        assertThat(roundtrippedKycData).isEqualTo(kycData)
    }
}
