// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.entities.kyc

import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KycSubmitParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        KycSubmitParams.builder()
            .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            KycSubmitParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .data(KycData.builder().countryCode("SG").lastName("Doe").build())
                .providerName("provider_name")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            KycSubmitParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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

        val body = params._body()

        assertThat(body.data())
            .isEqualTo(
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
        assertThat(body.providerName()).isEqualTo("provider_name")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            KycSubmitParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .data(KycData.builder().countryCode("SG").lastName("Doe").build())
                .providerName("provider_name")
                .build()

        val body = params._body()

        assertThat(body.data())
            .isEqualTo(KycData.builder().countryCode("SG").lastName("Doe").build())
        assertThat(body.providerName()).isEqualTo("provider_name")
    }
}
