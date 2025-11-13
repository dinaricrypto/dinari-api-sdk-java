// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateMarketBuyOrderInputTest {

    @Test
    fun create() {
        val createMarketBuyOrderInput =
            CreateMarketBuyOrderInput.builder()
                .paymentAmount(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .clientOrderId("client_order_id")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(createMarketBuyOrderInput.paymentAmount()).isEqualTo(0.0)
        assertThat(createMarketBuyOrderInput.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(createMarketBuyOrderInput.clientOrderId()).contains("client_order_id")
        assertThat(createMarketBuyOrderInput.recipientAccountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createMarketBuyOrderInput =
            CreateMarketBuyOrderInput.builder()
                .paymentAmount(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .clientOrderId("client_order_id")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedCreateMarketBuyOrderInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createMarketBuyOrderInput),
                jacksonTypeRef<CreateMarketBuyOrderInput>(),
            )

        assertThat(roundtrippedCreateMarketBuyOrderInput).isEqualTo(createMarketBuyOrderInput)
    }
}
