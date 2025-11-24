// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BaselineKycCheckDataTest {

    @Test
    fun create() {
        val baselineKycCheckData =
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

        assertThat(baselineKycCheckData.addressCountryCode()).isEqualTo("SG")
        assertThat(baselineKycCheckData.countryCode()).isEqualTo("SG")
        assertThat(baselineKycCheckData.lastName()).isEqualTo("Doe")
        assertThat(baselineKycCheckData.addressCity()).contains("San Francisco")
        assertThat(baselineKycCheckData.addressPostalCode()).contains("94111")
        assertThat(baselineKycCheckData.addressStreet1()).contains("123 Main St.")
        assertThat(baselineKycCheckData.addressStreet2()).contains("Apt. 123")
        assertThat(baselineKycCheckData.addressSubdivision()).contains("California")
        assertThat(baselineKycCheckData.birthDate()).contains(LocalDate.parse("2019-12-27"))
        assertThat(baselineKycCheckData.email()).contains("johndoe@website.com")
        assertThat(baselineKycCheckData.firstName()).contains("John")
        assertThat(baselineKycCheckData.middleName()).contains("x")
        assertThat(baselineKycCheckData.taxIdNumber()).contains("12-3456789")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val baselineKycCheckData =
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

        val roundtrippedBaselineKycCheckData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(baselineKycCheckData),
                jacksonTypeRef<BaselineKycCheckData>(),
            )

        assertThat(roundtrippedBaselineKycCheckData).isEqualTo(baselineKycCheckData)
    }
}
