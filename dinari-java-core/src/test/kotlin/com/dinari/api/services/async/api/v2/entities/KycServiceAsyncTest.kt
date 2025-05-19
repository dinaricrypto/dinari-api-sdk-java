// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.api.v2.entities

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.api.v2.entities.kyc.KycData
import com.dinari.api.models.api.v2.entities.kyc.KycDocumentType
import com.dinari.api.models.api.v2.entities.kyc.KycSubmitParams
import com.dinari.api.models.api.v2.entities.kyc.KycUploadDocumentParams
import java.time.LocalDate
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class KycServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val kycServiceAsync = client.api().v2().entities().kyc()

        val kycInfoFuture = kycServiceAsync.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val kycInfo = kycInfoFuture.get()
        kycInfo.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun submit() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val kycServiceAsync = client.api().v2().entities().kyc()

        val kycInfoFuture =
            kycServiceAsync.submit(
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
                            .middleName("x")
                            .taxIdNumber("12-3456789")
                            .build()
                    )
                    .providerName("x")
                    .build()
            )

        val kycInfo = kycInfoFuture.get()
        kycInfo.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun uploadDocument() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .secret("My Secret")
                .build()
        val kycServiceAsync = client.api().v2().entities().kyc()

        val responseFuture =
            kycServiceAsync.uploadDocument(
                KycUploadDocumentParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .kycId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .documentType(KycDocumentType.GOVERNMENT_ID)
                    .file("some content".byteInputStream())
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
