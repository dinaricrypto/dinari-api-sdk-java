// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderRequestCreateMarketBuyParamsTest {

    @Test
    fun create() {
        OrderRequestCreateMarketBuyParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .createMarketBuyOrderInput(
                CreateMarketBuyOrderInput.builder()
                    .paymentAmount(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OrderRequestCreateMarketBuyParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createMarketBuyOrderInput(
                    CreateMarketBuyOrderInput.builder()
                        .paymentAmount(0.0)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            OrderRequestCreateMarketBuyParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createMarketBuyOrderInput(
                    CreateMarketBuyOrderInput.builder()
                        .paymentAmount(0.0)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                CreateMarketBuyOrderInput.builder()
                    .paymentAmount(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OrderRequestCreateMarketBuyParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createMarketBuyOrderInput(
                    CreateMarketBuyOrderInput.builder()
                        .paymentAmount(0.0)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                CreateMarketBuyOrderInput.builder()
                    .paymentAmount(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }
}
