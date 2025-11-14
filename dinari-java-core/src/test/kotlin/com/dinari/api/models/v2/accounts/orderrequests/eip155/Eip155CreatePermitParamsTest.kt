// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.eip155

import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderTif
import com.dinari.api.models.v2.accounts.orders.OrderType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Eip155CreatePermitParamsTest {

    @Test
    fun create() {
        Eip155CreatePermitParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .chainId(Chain.EIP155_1)
            .orderSide(OrderSide.BUY)
            .orderTif(OrderTif.DAY)
            .orderType(OrderType.MARKET)
            .paymentToken("payment_token")
            .assetTokenQuantity(0.0)
            .clientOrderId("client_order_id")
            .limitPrice(0.0)
            .paymentTokenQuantity(0.0)
            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .tokenId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            Eip155CreatePermitParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .paymentToken("payment_token")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            Eip155CreatePermitParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .paymentToken("payment_token")
                .assetTokenQuantity(0.0)
                .clientOrderId("client_order_id")
                .limitPrice(0.0)
                .paymentTokenQuantity(0.0)
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .tokenId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()

        assertThat(body.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(body.orderSide()).isEqualTo(OrderSide.BUY)
        assertThat(body.orderTif()).isEqualTo(OrderTif.DAY)
        assertThat(body.orderType()).isEqualTo(OrderType.MARKET)
        assertThat(body.paymentToken()).isEqualTo("payment_token")
        assertThat(body.assetTokenQuantity()).contains(0.0)
        assertThat(body.clientOrderId()).contains("client_order_id")
        assertThat(body.limitPrice()).contains(0.0)
        assertThat(body.paymentTokenQuantity()).contains(0.0)
        assertThat(body.stockId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.tokenId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            Eip155CreatePermitParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .paymentToken("payment_token")
                .build()

        val body = params._body()

        assertThat(body.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(body.orderSide()).isEqualTo(OrderSide.BUY)
        assertThat(body.orderTif()).isEqualTo(OrderTif.DAY)
        assertThat(body.orderType()).isEqualTo(OrderType.MARKET)
        assertThat(body.paymentToken()).isEqualTo("payment_token")
    }
}
