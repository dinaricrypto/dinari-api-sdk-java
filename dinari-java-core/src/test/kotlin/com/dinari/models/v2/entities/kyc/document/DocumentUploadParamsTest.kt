// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.entities.kyc.document

import com.dinari.core.MultipartField
import com.dinari.core.http.QueryParams
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DocumentUploadParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        DocumentUploadParams.builder()
            .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .kycId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .documentType(KycDocumentType.GOVERNMENT_ID)
            .file("some content".byteInputStream())
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            DocumentUploadParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .kycId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .documentType(KycDocumentType.GOVERNMENT_ID)
                .file("some content".byteInputStream())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(params._pathParam(1)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params =
            DocumentUploadParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .kycId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .documentType(KycDocumentType.GOVERNMENT_ID)
                .file("some content".byteInputStream())
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("document_type", "GOVERNMENT_ID").build())
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            DocumentUploadParams.builder()
                .entityId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .kycId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .documentType(KycDocumentType.GOVERNMENT_ID)
                .file("some content".byteInputStream())
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf("file" to MultipartField.of("some content".byteInputStream())).mapValues {
                    (_, field) ->
                    field.map { (it as? ByteArray)?.inputStream() ?: it }
                }
            )
    }
}
