// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

import com.dinari.api.core.JsonValue
import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Eip155CreatePermitResponseTest {

    @Test
    fun create() {
        val eip155CreatePermitResponse =
            Eip155CreatePermitResponse.builder()
                .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .permit(
                    Eip155CreatePermitResponse.Permit.builder()
                        .putAdditionalProperty("foo", JsonValue.from(null))
                        .build()
                )
                .build()

        assertThat(eip155CreatePermitResponse.orderRequestId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(eip155CreatePermitResponse.permit())
            .isEqualTo(
                Eip155CreatePermitResponse.Permit.builder()
                    .putAdditionalProperty("foo", JsonValue.from(null))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eip155CreatePermitResponse =
            Eip155CreatePermitResponse.builder()
                .orderRequestId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .permit(
                    Eip155CreatePermitResponse.Permit.builder()
                        .putAdditionalProperty("foo", JsonValue.from(null))
                        .build()
                )
                .build()

        val roundtrippedEip155CreatePermitResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eip155CreatePermitResponse),
                jacksonTypeRef<Eip155CreatePermitResponse>(),
            )

        assertThat(roundtrippedEip155CreatePermitResponse).isEqualTo(eip155CreatePermitResponse)
    }
}
