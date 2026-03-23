// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2.entities.kyc

import com.dinari.api.client.okhttp.DinariOkHttpClient
import com.dinari.api.models.v2.entities.kyc.document.DocumentRetrieveParams
import com.dinari.api.models.v2.entities.kyc.document.DocumentUploadParams
import com.dinari.api.models.v2.entities.kyc.document.KycDocumentType
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DocumentServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val documentService = client.v2().entities().kyc().document()

        val kycDocuments =
            documentService.retrieve(
                DocumentRetrieveParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .kycId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        kycDocuments.forEach { it.validate() }
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun upload() {
        val client =
            DinariOkHttpClient.builder()
                .apiKeyId("My API Key ID")
                .apiSecretKey("My API Secret Key")
                .build()
        val documentService = client.v2().entities().kyc().document()

        val kycDocument =
            documentService.upload(
                DocumentUploadParams.builder()
                    .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .kycId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .documentType(KycDocumentType.GOVERNMENT_ID)
                    .file("Example data".byteInputStream())
                    .build()
            )

        kycDocument.validate()
    }
}
