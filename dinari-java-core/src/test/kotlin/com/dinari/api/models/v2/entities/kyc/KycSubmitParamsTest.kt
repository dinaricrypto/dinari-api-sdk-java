// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KycSubmitParamsTest {

    @Test
    fun create() {
        KycSubmitParams.builder()
            .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .body(
                KycSubmitParams.Body.Baseline.builder()
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
                    .providerName("x")
                    .jurisdiction(KycSubmitParams.Body.Baseline.Jurisdiction.BASELINE)
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            KycSubmitParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .body(
                    KycSubmitParams.Body.Baseline.builder()
                        .data(
                            BaselineKycCheckData.builder()
                                .addressCountryCode("SG")
                                .countryCode("SG")
                                .lastName("Doe")
                                .build()
                        )
                        .providerName("x")
                        .jurisdiction(KycSubmitParams.Body.Baseline.Jurisdiction.BASELINE)
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            KycSubmitParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .body(
                    KycSubmitParams.Body.Baseline.builder()
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
                        .providerName("x")
                        .jurisdiction(KycSubmitParams.Body.Baseline.Jurisdiction.BASELINE)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                KycSubmitParams.Body.ofBaseline(
                    KycSubmitParams.Body.Baseline.builder()
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
                        .providerName("x")
                        .jurisdiction(KycSubmitParams.Body.Baseline.Jurisdiction.BASELINE)
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            KycSubmitParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .body(
                    KycSubmitParams.Body.Baseline.builder()
                        .data(
                            BaselineKycCheckData.builder()
                                .addressCountryCode("SG")
                                .countryCode("SG")
                                .lastName("Doe")
                                .build()
                        )
                        .providerName("x")
                        .jurisdiction(KycSubmitParams.Body.Baseline.Jurisdiction.BASELINE)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                KycSubmitParams.Body.ofBaseline(
                    KycSubmitParams.Body.Baseline.builder()
                        .data(
                            BaselineKycCheckData.builder()
                                .addressCountryCode("SG")
                                .countryCode("SG")
                                .lastName("Doe")
                                .build()
                        )
                        .providerName("x")
                        .jurisdiction(KycSubmitParams.Body.Baseline.Jurisdiction.BASELINE)
                        .build()
                )
            )
    }
}
