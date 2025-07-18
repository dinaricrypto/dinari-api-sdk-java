// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.models.v2.accounts.orderrequests.stocks.eip155

import com.dinari.api.core.JsonValue
import com.dinari.api.models.v2.accounts.Chain
import com.dinari.api.models.v2.accounts.orders.OrderSide
import com.dinari.api.models.v2.accounts.orders.OrderTif
import com.dinari.api.models.v2.accounts.orders.OrderType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Eip155PrepareProxiedOrderParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        Eip155PrepareProxiedOrderParams.builder()
            .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .chainId(Chain.EIP155_1)
            .orderSide(OrderSide.BUY)
            .orderTif(OrderTif.DAY)
            .orderType(OrderType.MARKET)
            .paymentToken("payment_token")
            .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .assetTokenQuantity(JsonValue.from("0"))
            .limitPrice(JsonValue.from("0"))
            .paymentTokenQuantity(JsonValue.from("0"))
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            Eip155PrepareProxiedOrderParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .paymentToken("payment_token")
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            Eip155PrepareProxiedOrderParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .paymentToken("payment_token")
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .assetTokenQuantity(JsonValue.from("0"))
                .limitPrice(JsonValue.from("0"))
                .paymentTokenQuantity(JsonValue.from("0"))
                .build()

        val body = params._body()

        assertThat(body.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(body.orderSide()).isEqualTo(OrderSide.BUY)
        assertThat(body.orderTif()).isEqualTo(OrderTif.DAY)
        assertThat(body.orderType()).isEqualTo(OrderType.MARKET)
        assertThat(body.paymentToken()).isEqualTo("payment_token")
        assertThat(body.stockId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body._assetTokenQuantity()).isEqualTo(JsonValue.from("0"))
        assertThat(body._limitPrice()).isEqualTo(JsonValue.from("0"))
        assertThat(body._paymentTokenQuantity()).isEqualTo(JsonValue.from("0"))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            Eip155PrepareProxiedOrderParams.builder()
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .chainId(Chain.EIP155_1)
                .orderSide(OrderSide.BUY)
                .orderTif(OrderTif.DAY)
                .orderType(OrderType.MARKET)
                .paymentToken("payment_token")
                .stockId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()

        assertThat(body.chainId()).isEqualTo(Chain.EIP155_1)
        assertThat(body.orderSide()).isEqualTo(OrderSide.BUY)
        assertThat(body.orderTif()).isEqualTo(OrderTif.DAY)
        assertThat(body.orderType()).isEqualTo(OrderType.MARKET)
        assertThat(body.paymentToken()).isEqualTo("payment_token")
        assertThat(body.stockId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
