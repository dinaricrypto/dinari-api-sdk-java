// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.entities.kyc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KycUploadDocumentParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        KycUploadDocumentParams.builder()
            .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .kycId("kyc_id")
            .documentType(KycDocumentType.GOVERNMENT_ID)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            KycUploadDocumentParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .kycId("kyc_id")
                .documentType(KycDocumentType.GOVERNMENT_ID)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(params._pathParam(1)).isEqualTo("kyc_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            KycUploadDocumentParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .kycId("kyc_id")
                .documentType(KycDocumentType.GOVERNMENT_ID)
                .build()

        val body = params._body()

        assertThat(body.documentType()).isEqualTo(KycDocumentType.GOVERNMENT_ID)
    }
}
