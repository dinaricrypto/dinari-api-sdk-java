// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateLimitSellOrderInputTest {

    @Test
    fun create() {
        val createLimitSellOrderInput =
            CreateLimitSellOrderInput.builder()
                .assetQuantity(0.0)
                .limitPrice(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .clientOrderId("client_order_id")
                .paymentTokenAddress("payment_token_address")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(createLimitSellOrderInput.assetQuantity()).isEqualTo(0.0)
        assertThat(createLimitSellOrderInput.limitPrice()).isEqualTo(0.0)
        assertThat(createLimitSellOrderInput.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(createLimitSellOrderInput.clientOrderId()).contains("client_order_id")
        assertThat(createLimitSellOrderInput.paymentTokenAddress())
            .contains("payment_token_address")
        assertThat(createLimitSellOrderInput.recipientAccountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createLimitSellOrderInput =
            CreateLimitSellOrderInput.builder()
                .assetQuantity(0.0)
                .limitPrice(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .clientOrderId("client_order_id")
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
