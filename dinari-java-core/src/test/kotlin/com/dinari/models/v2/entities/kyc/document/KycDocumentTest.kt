// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.entities.kyc.document

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KycDocumentTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val kycDocument =
            KycDocument.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .documentType(KycDocumentType.GOVERNMENT_ID)
                .filename("filename")
                .url("url")
                .build()

        assertThat(kycDocument.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(kycDocument.documentType()).isEqualTo(KycDocumentType.GOVERNMENT_ID)
        assertThat(kycDocument.filename()).isEqualTo("filename")
        assertThat(kycDocument.url()).isEqualTo("url")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val kycDocument =
            KycDocument.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .documentType(KycDocumentType.GOVERNMENT_ID)
                .filename("filename")
                .url("url")
                .build()

        val roundtrippedKycDocument =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(kycDocument),
                jacksonTypeRef<KycDocument>(),
            )

        assertThat(roundtrippedKycDocument).isEqualTo(kycDocument)
    }
}
