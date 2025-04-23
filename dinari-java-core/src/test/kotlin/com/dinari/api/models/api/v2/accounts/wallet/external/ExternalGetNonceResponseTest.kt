// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.wallet.external

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ExternalGetNonceResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val externalGetNonceResponse =
            ExternalGetNonceResponse.builder().message("message").nonce("nonce").build()

        assertThat(externalGetNonceResponse.message()).isEqualTo("message")
        assertThat(externalGetNonceResponse.nonce()).isEqualTo("nonce")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val externalGetNonceResponse =
            ExternalGetNonceResponse.builder().message("message").nonce("nonce").build()

        val roundtrippedExternalGetNonceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(externalGetNonceResponse),
                jacksonTypeRef<ExternalGetNonceResponse>(),
            )

        assertThat(roundtrippedExternalGetNonceResponse).isEqualTo(externalGetNonceResponse)
    }
}
