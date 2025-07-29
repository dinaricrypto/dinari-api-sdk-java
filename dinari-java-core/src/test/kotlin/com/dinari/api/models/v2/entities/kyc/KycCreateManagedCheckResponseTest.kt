// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.entities.kyc

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KycCreateManagedCheckResponseTest {

    @Test
    fun create() {
        val kycCreateManagedCheckResponse =
            KycCreateManagedCheckResponse.builder()
                .embedUrl("embed_url")
                .expirationDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(kycCreateManagedCheckResponse.embedUrl()).isEqualTo("embed_url")
        assertThat(kycCreateManagedCheckResponse.expirationDt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val kycCreateManagedCheckResponse =
            KycCreateManagedCheckResponse.builder()
                .embedUrl("embed_url")
                .expirationDt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedKycCreateManagedCheckResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(kycCreateManagedCheckResponse),
                jacksonTypeRef<KycCreateManagedCheckResponse>(),
            )

        assertThat(roundtrippedKycCreateManagedCheckResponse)
            .isEqualTo(kycCreateManagedCheckResponse)
    }
}
