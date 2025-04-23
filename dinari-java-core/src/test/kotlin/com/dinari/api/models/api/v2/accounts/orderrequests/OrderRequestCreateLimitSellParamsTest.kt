// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.api.v2.accounts.orderrequests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class OrderRequestCreateLimitSellParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        OrderRequestCreateLimitSellParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .limitOrderRequestInput(
                LimitOrderRequestInput.builder()
                    .assetQuantity(0L)
                    .limitPrice(0.0)
                    .stockId("stock_id")
                    .build()
            )
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            OrderRequestCreateLimitSellParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .limitOrderRequestInput(
                    LimitOrderRequestInput.builder()
                        .assetQuantity(0L)
                        .limitPrice(0.0)
                        .stockId("stock_id")
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            OrderRequestCreateLimitSellParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .limitOrderRequestInput(
                    LimitOrderRequestInput.builder()
                        .assetQuantity(0L)
                        .limitPrice(0.0)
                        .stockId("stock_id")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                LimitOrderRequestInput.builder()
                    .assetQuantity(0L)
                    .limitPrice(0.0)
                    .stockId("stock_id")
                    .build()
            )
    }
}
