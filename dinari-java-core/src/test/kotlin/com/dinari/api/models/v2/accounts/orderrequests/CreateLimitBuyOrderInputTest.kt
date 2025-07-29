// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateLimitBuyOrderInputTest {

    @Test
    fun create() {
        val createLimitBuyOrderInput =
            CreateLimitBuyOrderInput.builder()
                .assetQuantity(0.0)
                .limitPrice(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(createLimitBuyOrderInput.assetQuantity()).isEqualTo(0.0)
        assertThat(createLimitBuyOrderInput.limitPrice()).isEqualTo(0.0)
        assertThat(createLimitBuyOrderInput.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(createLimitBuyOrderInput.recipientAccountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createLimitBuyOrderInput =
            CreateLimitBuyOrderInput.builder()
                .assetQuantity(0.0)
                .limitPrice(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedCreateLimitBuyOrderInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createLimitBuyOrderInput),
                jacksonTypeRef<CreateLimitBuyOrderInput>(),
            )

        assertThat(roundtrippedCreateLimitBuyOrderInput).isEqualTo(createLimitBuyOrderInput)
    }
}
