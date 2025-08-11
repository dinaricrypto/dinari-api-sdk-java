// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.entities

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.entities.kyc.KycData
import com.dinari.api.models.v2.entities.kyc.KycSubmitParams
import java.time.LocalDate
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class KycServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val kycService = client.v2().entities().kyc()

        val kycInfo = kycService.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        kycInfo.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun createManagedCheck() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val kycService = client.v2().entities().kyc()

        val response = kycService.createManagedCheck("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun submit() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val kycService = client.v2().entities().kyc()

        val kycInfo =
            kycService.submit(
                KycSubmitParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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
                    .providerName("x")
                    .build()
            )

        kycInfo.validate()
    }
}
