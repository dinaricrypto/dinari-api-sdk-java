// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.async.v2.entities.kyc

import com.dinari.api.TestServerExtension
import com.dinari.api.client.okhttp.DinariOkHttpClientAsync
import com.dinari.api.models.v2.entities.kyc.document.DocumentRetrieveParams
import com.dinari.api.models.v2.entities.kyc.document.DocumentUploadParams
import com.dinari.api.models.v2.entities.kyc.document.KycDocumentType
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DocumentServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val documentServiceAsync = client.v2().entities().kyc().document()

        val kycDocumentsFuture =
            documentServiceAsync.retrieve(
                DocumentRetrieveParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .kycId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val kycDocuments = kycDocumentsFuture.get()
        kycDocuments.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun upload() {
        val client =
            DinariOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val documentServiceAsync = client.v2().entities().kyc().document()

        val kycDocumentFuture =
            documentServiceAsync.upload(
                DocumentUploadParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .kycId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .documentType(KycDocumentType.GOVERNMENT_ID)
                    .file("some content".byteInputStream())
                    .build()
            )

        val kycDocument = kycDocumentFuture.get()
        kycDocument.validate()
    }
}
