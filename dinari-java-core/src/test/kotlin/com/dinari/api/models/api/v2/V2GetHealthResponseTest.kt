// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class V2GetHealthResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val v2GetHealthResponse = V2GetHealthResponse.builder().status("status").build()

        assertThat(v2GetHealthResponse.status()).isEqualTo("status")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val v2GetHealthResponse = V2GetHealthResponse.builder().status("status").build()

        val roundtrippedV2GetHealthResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(v2GetHealthResponse),
                jacksonTypeRef<V2GetHealthResponse>(),
            )

        assertThat(roundtrippedV2GetHealthResponse).isEqualTo(v2GetHealthResponse)
    }
}
