// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateMarketSellOrderInputTest {

    @Test
    fun create() {
        val createMarketSellOrderInput =
            CreateMarketSellOrderInput.builder()
                .assetQuantity(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentTokenAddress("payment_token_address")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(createMarketSellOrderInput.assetQuantity()).isEqualTo(0.0)
        assertThat(createMarketSellOrderInput.stockId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(createMarketSellOrderInput.paymentTokenAddress())
            .contains("payment_token_address")
        assertThat(createMarketSellOrderInput.recipientAccountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createMarketSellOrderInput =
            CreateMarketSellOrderInput.builder()
                .assetQuantity(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentTokenAddress("payment_token_address")
                .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedCreateMarketSellOrderInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createMarketSellOrderInput),
                jacksonTypeRef<CreateMarketSellOrderInput>(),
            )

        assertThat(roundtrippedCreateMarketSellOrderInput).isEqualTo(createMarketSellOrderInput)
    }
}
