// File generated from our OpenAPI spec by Stainless.

package com.dinari.models.v2.accounts.orderrequests

import com.dinari.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CreateLimitOrderInputTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val createLimitOrderInput =
            CreateLimitOrderInput.builder()
                .assetQuantity(0L)
                .limitPrice(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(createLimitOrderInput.assetQuantity()).isEqualTo(0L)
        assertThat(createLimitOrderInput.limitPrice()).isEqualTo(0.0)
        assertThat(createLimitOrderInput.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createLimitOrderInput =
            CreateLimitOrderInput.builder()
                .assetQuantity(0L)
                .limitPrice(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedCreateLimitOrderInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createLimitOrderInput),
                jacksonTypeRef<CreateLimitOrderInput>(),
            )

        assertThat(roundtrippedCreateLimitOrderInput).isEqualTo(createLimitOrderInput)
    }
}
