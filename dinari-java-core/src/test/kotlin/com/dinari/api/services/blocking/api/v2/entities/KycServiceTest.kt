// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.api.v2.entities

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.api.v2.entities.kyc.KycData
import com.dinari.api.models.api.v2.entities.kyc.KycDocumentType
import com.dinari.api.models.api.v2.entities.kyc.KycGetUrlParams
import com.dinari.api.models.api.v2.entities.kyc.KycRetrieveParams
import com.dinari.api.models.api.v2.entities.kyc.KycSubmitParams
import com.dinari.api.models.api.v2.entities.kyc.KycUploadDocumentParams
import java.time.LocalDate
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class KycServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val kycService = client.api().v2().entities().kyc()

        val kycInfo =
            kycService.retrieve(
                KycRetrieveParams.builder().entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        kycInfo.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getUrl() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val kycService = client.api().v2().entities().kyc()

        val response =
            kycService.getUrl(
                KycGetUrlParams.builder().entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun submit() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val kycService = client.api().v2().entities().kyc()

        val kycInfo =
            kycService.submit(
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
            )

        kycInfo.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun uploadDocument() {
        val client =
            DinariOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val kycService = client.api().v2().entities().kyc()

        val response =
            kycService.uploadDocument(
                KycUploadDocumentParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .kycId("kyc_id")
                    .documentType(KycDocumentType.GOVERNMENT_ID)
                    .build()
            )

        response.validate()
    }
}
