// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orderrequests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderRequestCreateMarketBuyParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        OrderRequestCreateMarketBuyParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .paymentAmount(0.0)
            .stockId("stock_id")
            .includeFees(true)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            OrderRequestCreateMarketBuyParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentAmount(0.0)
                .stockId("stock_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            OrderRequestCreateMarketBuyParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentAmount(0.0)
                .stockId("stock_id")
                .includeFees(true)
                .build()

        val body = params._body()

        assertThat(body.paymentAmount()).isEqualTo(0.0)
        assertThat(body.stockId()).isEqualTo("stock_id")
        assertThat(body.includeFees()).contains(true)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OrderRequestCreateMarketBuyParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentAmount(0.0)
                .stockId("stock_id")
                .build()

        val body = params._body()

        assertThat(body.paymentAmount()).isEqualTo(0.0)
        assertThat(body.stockId()).isEqualTo("stock_id")
    }
}
