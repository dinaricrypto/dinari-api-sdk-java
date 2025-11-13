// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderRequestCreateLimitSellParamsTest {

    @Test
    fun create() {
        OrderRequestCreateLimitSellParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .createLimitSellOrderInput(
                CreateLimitSellOrderInput.builder()
                    .assetQuantity(0.0)
                    .limitPrice(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .clientOrderId("client_order_id")
                    .paymentTokenAddress("payment_token_address")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OrderRequestCreateLimitSellParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createLimitSellOrderInput(
                    CreateLimitSellOrderInput.builder()
                        .assetQuantity(0.0)
                        .limitPrice(0.0)
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
            OrderRequestCreateLimitSellParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createLimitSellOrderInput(
                    CreateLimitSellOrderInput.builder()
                        .assetQuantity(0.0)
                        .limitPrice(0.0)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .clientOrderId("client_order_id")
                        .paymentTokenAddress("payment_token_address")
                        .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                CreateLimitSellOrderInput.builder()
                    .assetQuantity(0.0)
                    .limitPrice(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .clientOrderId("client_order_id")
                    .paymentTokenAddress("payment_token_address")
                    .recipientAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OrderRequestCreateLimitSellParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createLimitSellOrderInput(
                    CreateLimitSellOrderInput.builder()
                        .assetQuantity(0.0)
                        .limitPrice(0.0)
                        .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                CreateLimitSellOrderInput.builder()
                    .assetQuantity(0.0)
                    .limitPrice(0.0)
                    .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }
}
