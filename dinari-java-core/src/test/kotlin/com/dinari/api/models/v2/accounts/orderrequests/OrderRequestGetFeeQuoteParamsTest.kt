// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests

import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderRequestGetFeeQuoteParamsTest {

    @Test
    fun create() {
        OrderRequestGetFeeQuoteParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .orderSide(OrderSide.BUY)
            .orderType(OrderType.MARKET)
            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .assetTokenQuantity(0.0)
            .chainId(Chain.EIP155_1)
            .limitPrice(0.0)
            .paymentTokenAddress("payment_token_address")
            .paymentTokenQuantity(0.0)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OrderRequestGetFeeQuoteParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .orderSide(OrderSide.BUY)
                .orderType(OrderType.MARKET)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            OrderRequestGetFeeQuoteParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .orderSide(OrderSide.BUY)
                .orderType(OrderType.MARKET)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetTokenQuantity(0.0)
                .chainId(Chain.EIP155_1)
                .limitPrice(0.0)
                .paymentTokenAddress("payment_token_address")
                .paymentTokenQuantity(0.0)
                .build()

        val body = params._body()

        assertThat(body.orderSide()).isEqualTo(OrderSide.BUY)
        assertThat(body.orderType()).isEqualTo(OrderType.MARKET)
        assertThat(body.stockId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.assetTokenQuantity()).contains(0.0)
        assertThat(body.chainId()).contains(Chain.EIP155_1)
        assertThat(body.limitPrice()).contains(0.0)
        assertThat(body.paymentTokenAddress()).contains("payment_token_address")
        assertThat(body.paymentTokenQuantity()).contains(0.0)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OrderRequestGetFeeQuoteParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .orderSide(OrderSide.BUY)
                .orderType(OrderType.MARKET)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()

        assertThat(body.orderSide()).isEqualTo(OrderSide.BUY)
        assertThat(body.orderType()).isEqualTo(OrderType.MARKET)
        assertThat(body.stockId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
