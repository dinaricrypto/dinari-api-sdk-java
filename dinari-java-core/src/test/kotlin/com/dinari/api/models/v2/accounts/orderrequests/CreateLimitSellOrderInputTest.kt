// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CreateLimitSellOrderInputTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val createLimitSellOrderInput =
            CreateLimitSellOrderInput.builder()
                .assetQuantity(0.0)
                .limitPrice(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentTokenAddress("payment_token_address")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(createLimitSellOrderInput.assetQuantity()).isEqualTo(0.0)
        assertThat(createLimitSellOrderInput.limitPrice()).isEqualTo(0.0)
        assertThat(createLimitSellOrderInput.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(createLimitSellOrderInput.paymentTokenAddress())
            .contains("payment_token_address")
        assertThat(createLimitSellOrderInput.recipientAccountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createLimitSellOrderInput =
            CreateLimitSellOrderInput.builder()
                .assetQuantity(0.0)
                .limitPrice(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentTokenAddress("payment_token_address")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedCreateLimitSellOrderInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createLimitSellOrderInput),
                jacksonTypeRef<CreateLimitSellOrderInput>(),
            )

        assertThat(roundtrippedCreateLimitSellOrderInput).isEqualTo(createLimitSellOrderInput)
    }
}
